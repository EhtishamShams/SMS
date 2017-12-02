package dal;
import java.sql.*;
import backend.*;

/**
 * @author hamza
 *
 */

public class DAL {
	
	public boolean addPay(Pay p) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Pay VALUES (" + p.getAmount() + ", " + "'" + p.getDatePaid() + "', "
					+ p.getStaffMember().getEmpID() + ")");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean updateFee(Fee f) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("UPDATE Fee SET DatePaid = '" +f.getDatePaid() + "' WHERE RollNo = '" + f.getStudent().getRollNo()
					+ "' AND Session = '" + f.getSemester().getSession() + "'");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean addOffice(Office o) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Office VALUES ('" + o.getID() + "')");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean changePassword(String newPass, String CNIC) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("UPDATE User SET Password = '" + newPass + "' WHERE CNIC = '" + CNIC + "'" );
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean updateGrade(Grade g, String rollNum) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			ResultSet rs = stmnt.executeQuery("SELECT SectionKey FROM CourseSection WHERE SectionID = '" + g.getCourseSection().getSectionID()
					+ "' AND CourseCode = '" + g.getCourseSection().getCourse().getCourseCode()
					+ "' AND Session = '" + g.getCourseSection().getSemester().getSession() + "'");
			rs.next();
			String sectionKey = rs.getString(1);
			stmnt.executeUpdate("UPDATE Grade SET Grade = '" + g.getGrade().toString() + "' WHERE SectionKey = '" + sectionKey
					+ "' AND RollNo = '" + rollNum + "'" );
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
}
