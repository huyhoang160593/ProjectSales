package dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {

	 public static Connection getConnection() {
		 Connection cons = null;
		 String connectionUrl = "jdbc:sqlserver://localhost:1433;"	//Kết nối cơ sở dữ liệu dưới cổng mặc định là 1433
		 		+ "databaseName=sales;"		//Tên database: sales
		 		+ "user=adminiulover;"		//Tài khoản cơ sở dữ liệu
		 		+ "password=1234";			//Mật khẩu cơ sở dữ liệu
		 try {
			cons=DriverManager.getConnection(connectionUrl);	//biến cons được thực thi bằng việc tạo kết nối với lệnh connectionUrl
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return cons;
	 }
	 
	 public static void main(String[] args) {		//Kiểm tra xem kết nối đã được thiết đặt hay chưa
		 System.out.println(getConnection());
	 }
}
