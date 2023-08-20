package utilities;

import org.apache.log4j.Logger;
import org.junit.Test;
import steps.HooksTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtilities {

    private static Connection connection;
    final static Logger logger = Logger.getLogger(HooksTest.class);

    public static Connection connection() throws SQLException{
        logger.info("checking for JDBC connection");
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(Config.getValue("DBurl"), Config.getValue("DBuserName"), Config.getValue("DBpassword"));
            logger.info("created new JDBC connection");
        }
        return connection;
    }

    public static void closeConnection () throws SQLException {
        if (connection() != null && !connection().isClosed()){
            connection.close();
            logger.info("closed JDBC connection");
        }
    }

    public static ResultSet sendQuery(String query )throws SQLException{
        PreparedStatement preparedStatement = connection().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public static ResultSet sendQuery(String query, Object[] parameters )throws SQLException{
        PreparedStatement preparedStatement = connection().prepareStatement(query);

        for(int i = 0; i < parameters.length; i ++){
            preparedStatement.setObject(i + 1, parameters[i]);
        }
        return preparedStatement.executeQuery();
    }



    public static List<Object>retrieveResultToList(ResultSet resultSet, String columnName) throws SQLException{
        List<Object> result = new ArrayList<>();
            while(resultSet.next()){
                result.add(resultSet.getObject(columnName));
            }
            return result;
        }

    public static List<Object>retrieveResultToList(ResultSet resultSet, int columnIndex) throws SQLException{
        List<Object> result = new ArrayList<>();
        while(resultSet.next()){
            result.add(resultSet.getObject(columnIndex));
        }
        return result;
    }

    public static Map <String, String> retrieveResultsToMap(ResultSet resultSet, String columnName1, String columnName2 )throws SQLException{

        Map<String, String> map = new HashMap<>();
        while (resultSet.next()){
            map.put(resultSet.getString(columnName1), resultSet.getString(columnName2));


        }
        return map;


    }























    @Test
            public void firstTest() throws SQLException {
        String url = "jdbc:oracle:thin:@3.125.123.103:1521:CODEWISE" ;
        String userName = "SYSTEM";
        String password = "Codewise_123";
        Connection connection = DriverManager.getConnection(url, userName, password); // create connection with the dataBase
        Statement statement = connection.createStatement();

        //right the query
        String query = "select * from employees";
        //prepare statement
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // execute the query
        ResultSet resultSet = preparedStatement.executeQuery();  // statement stores the data

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("employee_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            // ... extract other columns as needed

            System.out.println("Employee ID: " + employeeId);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            // ... print other columns as needed

            System.out.println("--------------------");
        }


    }

}
