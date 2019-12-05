package dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {

	 public static Connection getConnection() {
		 Connection cons = null;
		 String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=sales;user=adminiulover;password=1234";
		 try {
			cons=DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return cons;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(getConnection());
	 }
}
