
package com.niramaya.niramaya.database;
import java.sql.*;

import org.springframework.stereotype.Repository;

import com.niramaya.niramaya.entities.User;
@Repository
public class UserListDaoImpl implements UserListDao {

    @Override
    public int addUsertoUserlist(User new_user) {
        String query = "INSERT INTO userlist values('" + new_user.getUsername() + "','" + new_user.getTimestamp()+ "','"+new_user.getDeviceId()+"')";
        Statement addUserstmt;
        try {
            DatabaseConnection database = new DatabaseConnection();
            Connection databaseConnection = database.getDbConnection();
            addUserstmt = databaseConnection.createStatement();
            int result = addUserstmt.executeUpdate(query);
            if (result == 1) {
                System.out.println("added user to userlist");
                databaseConnection.close();
                return 1;
            } else {
                System.out.println("Couldnot add user to userlist");
                return 0;
            }

        } catch (SQLException e) {

            return 2;
        }
    }


}
