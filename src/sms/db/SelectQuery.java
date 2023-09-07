package sms.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) {
		String q="SELECT * from student";
		try {
			Statement stmt = dbConnection.dbConn().createStatement();
			ResultSet rs =stmt.executeQuery(q);
			
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"  "+ rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}
		

	}


