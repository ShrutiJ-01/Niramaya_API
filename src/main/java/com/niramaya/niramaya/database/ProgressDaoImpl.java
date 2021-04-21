package com.niramaya.niramaya.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import com.niramaya.niramaya.entities.UserProgressLog;

@Repository
public class ProgressDaoImpl implements ProgressDao {

	@Override
	public int updateUserProgress(UserProgressLog progress_log) {
		
		
		String tableQuery="CREATE TABLE IF NOT EXISTS "+progress_log.getUsername()+" (timestamp VARCHAR(45) not NULL, " +
                " current INTEGER, " + 
                " expected INTEGER, " + 
                " ratio FLOAT, " + 
                " PRIMARY KEY ( timestamp ))";

		 String insertQuery = "INSERT INTO "+progress_log.getUsername()+" values('" + progress_log.getTimestamp() + "'," + progress_log.getCurrent_progress() + "," + progress_log.getExpected_progress() + "," +
                 progress_log.getRatio() + ")";
		Statement progressUpdateStmt;
		try {
			//get database connection
			DatabaseConnection database = new DatabaseConnection();
			Connection databaseConnection = database.getDbConnection();
			
			//create statement
			progressUpdateStmt = databaseConnection.createStatement();
			
			//create table if it does not exist
			progressUpdateStmt.executeUpdate(tableQuery);
			System.out.println("Created table in database");
			
			//inserting todays progress into table
			if(!SameDay(databaseConnection, progress_log.getTimestamp(),progress_log.getUsername())) {
				
				int result =progressUpdateStmt.executeUpdate(insertQuery);
				
				if (result == 1) {
					System.out.println("updated progress of "+progress_log.getUsername()+" to database");
					databaseConnection.close();
					return 1;
				} else {
					System.out.println("Couldnt update progress of "+progress_log.getUsername()+" to database");
					return 0;
				}	
			}
			else {
				//if request to uodate progress made more than twice on same day
				return 2;
			}

		} catch (SQLException e) {

			System.out.println(e);
			return 0;
		}

	}
	
	boolean SameDay(Connection connection, String timestamp,String username) {
		
		Statement stmt;
		boolean flag=false;
		try {
			
			stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM "+username);
			while(rs.next())
			{
				if(rs.getString(1).substring(0,11).equalsIgnoreCase(timestamp.substring(0,11)))
				{
					flag=true;
					return flag;
				}
			}
			return flag;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return flag;
		}	
	}
	
	int getLength(ResultSet resultSet) {
		int length=0;
		try {
			while(resultSet.next())
			length+=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			length=0;
		}
		return length;
		
	}

	@Override
	public UserProgressLog getWeeklyLog(String username) {

		Statement stmt;
		int progressDone=0;
		int expectedprogress=0;
		String timestampBeginning="";
		String timestampEnding="";
		
		UserProgressLog weeklyProgressLog=new UserProgressLog();
		try {
			
			//get database connection
			DatabaseConnection database = new DatabaseConnection();
			Connection databaseConnection = database.getDbConnection();
			//create statement
			stmt = databaseConnection.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM "+username);
			
			if(getLength(rs)>7)	
			{
				//getting recent week data
				for(int i=0;i<7;i++)
				{
					if(i==0) {timestampBeginning=rs.getString(0).substring(0,11);}
					if(i==6) {timestampEnding=rs.getString(0).substring(0,11);}
					progressDone+=rs.getInt(2);
					expectedprogress+=rs.getInt(3);
				}
				
				weeklyProgressLog.setTimestamp(""+timestampBeginning+"-"+timestampEnding);								
				weeklyProgressLog.setUsername(username);
				weeklyProgressLog.setCurrent_progress(progressDone);
				weeklyProgressLog.setExpected_progress(expectedprogress);
				weeklyProgressLog.calculateRatio();
			}
			else {
				System.out.println("Not A week yet");
				weeklyProgressLog.setUsername(username);
				weeklyProgressLog.setTimestamp("Not a week yet");
				weeklyProgressLog.setRatio((float)0.0);
			}
			return weeklyProgressLog;
			
		} catch (SQLException e) {
			System.out.println("daily progress didnot begin");
			weeklyProgressLog.setUsername(username);
			weeklyProgressLog.setTimestamp("daily progress didnot begin");
			weeklyProgressLog.setRatio((float)0.0);
			return weeklyProgressLog;
		}

	}
}
