package sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	public static Connection dbConn() {

		String url = "jdbc:mysql://127.0.0.1:3306/phalak_se";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
