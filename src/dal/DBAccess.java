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
	private static Connection con = null;
	private static Statement stmt;

	public static boolean createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "abcd");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
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
