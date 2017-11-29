/**
 * 
 */
package dal;

import java.sql.*;

/**
 * @author Ehtisham
 *
 */
public class DBAccess {
	private static Connection con;
	private static Statement stmt;
	
	public static boolean createConnection() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS","root","stark");
			stmt=con.createStatement();
		} catch (SQLException e) {
			
		}
		
		if (con == null)
			return false;
		else
			return true;
	}

	public static Statement getStatement() {
		return stmt;
	}
	
	public static Connection getConnection() {
		return con;
	}

	public static boolean closeConnection() {
		boolean check = true;
		try {
			con.close();
		} catch (SQLException e) {
			check = false;
		}
		return check;
	}
}
