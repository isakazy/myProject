package test;

import org.junit.Test;
import utilities.Config;

import java.sql.*;
import java.util.List;

public class DBtest {
    @Test
    public void connectionTest() throws SQLException {
        Connection connection = DriverManager.getConnection(Config.getValue("DBurl"), Config.getValue("DBuserName"), Config.getValue("DBpassword"));
        String query = "select * from employees";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery();

         
         }

    }

