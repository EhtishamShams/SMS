package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Load {
	
	public void loadFaculty() {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select UserID From User Where UserID = (Select S.UserID From (Select * From User) As U join Staff S Where U.UserID=S.UserID and S.EmpID=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			ResultSet rs = pst.executeQuery();
			rs.next();
			userID = rs.getString(1);
			
			if(repEmpID!=null) {
				query = "Update CourseSection Set TeacherID=? Where TeacherID=? and session=(select session from Semester where IsActive=1)";
				pst = conn.prepareStatement(query);
				pst.setString(1, repEmpID);
				pst.setString(2, empID);
				pst.executeUpdate();
			}
			
		
			query = "Delete from FacultyMember Where EmpID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			pst.execute();
			
			query = "Delete from Staff Where EmpID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			pst.execute();
			
			query = "Delete from User Where UserID=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			pst.execute();		
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		return true;
	}

}
