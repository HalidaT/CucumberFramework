package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.Array;


public class DButils {
	
	static String url = "jdbc:mysql://database-1.cbf9mjnqgnfr.us-east-2.rds.amazonaws.com:3306/stock_trading_tracker";
	static String username = "admin";
	static String password = "Password123!";
	
	public static void main(String[] args)  {
		try {
			// in order to work with JDBC and connect to a Database, we need to follow certain steps:
			// 1. we need to create a Connection reference with DriverManager object, followed by using the getConnection function
			Connection connect = DriverManager.getConnection(url, username, password);
			// 2. in order to execute a SQL query, we need to create a statement reference variable
		    // object type is connection object, using createStatement function.
			Statement statement = connect.createStatement();
			statement.executeQuery("DELETE FROM records where id = '43463'");
        	ResultSet resultSet = statement.executeQuery("SELECT * FROM records WHERE symbol='bitCoin'");
        	ResultSetMetaData rsmd = resultSet.getMetaData();
        	
        	System.out.println("column count : " + rsmd.getColumnCount());
			
			resultSet.next();
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				System.out.println(resultSet.getString(i));
			}
		} catch (SQLException e) {
			System.out.println("Cannot establish DB connection");
			e.printStackTrace();
		}
	
	}
	
	
	// insert query
	public void insertRecord(String query) {
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			System.out.println("DB connection established.");
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			connect.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	}
	
	
	// delete query
	public void deleteRecord(String query) {
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			System.out.println("DB connection established.");
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			connect.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	}
	
	// update query
	public void updateRecord(String query) {
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			System.out.println("DB connection established.");
			Statement statement = connect.createStatement();
			statement.executeUpdate(query);
			connect.close();
		} catch (SQLException e) {
			System.out.println("DB connection Not established.");
			e.printStackTrace();
		}
	} 
		
		}
			
		

	
 
	

		
		

	