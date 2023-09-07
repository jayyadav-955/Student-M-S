package sms.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQ {

	public static void main(String[] args) {
		String qchu = "Delete  from student where rollno = ?";
		try {
			PreparedStatement ps = dbConnection.dbConn().prepareStatement(qchu);
			ps.setInt(1, 101);
			ps.execute();
			System.out.println("Deletion Successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
