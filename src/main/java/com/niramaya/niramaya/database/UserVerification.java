package com.niramaya.niramaya.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVerification {

    public static boolean isValidCredential(String deviceid) {
        //get database connection
        DatabaseConnection database = new DatabaseConnection();
        Connection databaseConnection = database.getDbConnection();

        //create statement
        final String verificationCheck = "SELECT * from userlist WHERE deviceid = ?";
        PreparedStatement ps;
        try {
            //created prepared statement
            ps = databaseConnection.prepareStatement(verificationCheck);
            ps.setString(1,deviceid);
            final ResultSet resultSet = ps.executeQuery();

            //finding length of result set
            int len=0;
            while(resultSet.next()) {
                len=len+1;
            }
            ps.close();
            databaseConnection.close();

            //returning 1 if device id exists in database
            if(len>0)
                return true;
            else
                System.out.println(len);
                return false;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Device not registered");
            return false;
        }
    }

}