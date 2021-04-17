package com.niramaya.niramaya.database;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.niramaya.niramaya.entities.Report;
@Repository
public class ReportDaoImpl implements ReportDao {

	@Override
	public int addReporttolist(Report new_report) {
		String query = "INSERT INTO userlist values('" + new_report.getUsername() + "','" + new_report.getMindtype() + "','" + new_report.getBodytype() + "','" + new_report.getTimestamp()
				+ "')";
		Statement addReporttmt;
		try {
			DatabaseConnection database = new DatabaseConnection();
			Connection databaseConnection = database.getDbConnection();
			addReporttmt = databaseConnection.createStatement();
			int result = addReporttmt.executeUpdate(query);
			if (result == 1) {
				System.out.println("added report to list");
				databaseConnection.close();
				return 1;
			} else {
				System.out.println("Couldnot add report to list");
				return 0;
			}

		} catch (SQLException e) {

			System.out.println(e);
			return 0;
		}
	}
	
	
}
