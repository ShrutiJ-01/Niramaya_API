package com.niramaya.niramaya.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import com.niramaya.niramaya.entities.UserProgressLog;

@Repository
public class ProgressDaoImpl implements ProgressDao {
	
	//TODO: add a function that returns ratio of a particular username

	@Override
	public int updateUserProgress(UserProgressLog progress_log) {

		 String query = "INSERT INTO progress values('" + progress_log.getUsername() + "'," + progress_log.getCurrent_progress() + "," + progress_log.getExpected_progress() + "," +
                 progress_log.getRatio() + ")";
		Statement updateProgressrstmt;
		try {
			DatabaseConnection database = new DatabaseConnection();
			Connection databaseConnection = database.getDbConnection();
			updateProgressrstmt = databaseConnection.createStatement();
			int result = updateProgressrstmt.executeUpdate(query);
			if (result == 1) {
				System.out.println("updated progress of "+progress_log.getUsername()+" to database");
				databaseConnection.close();
				return 1;
			} else {
				System.out.println("Couldnt update progress of "+progress_log.getUsername()+" to database");
				return 0;
			}

		} catch (SQLException e) {

			System.out.println(e);
			return 0;
		}

	}
}
