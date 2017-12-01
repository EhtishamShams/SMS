package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import backend.*;

public class Load {
	
	public void loadFaculty() {
				
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select U.Name, U.Password, U.DateOfBirth, U.PhoneNo, U.Email, U.CNIC, U.Gender, U.EmergencyContact, U.Address, S.empID, S.DateHired, fm.Position, fm.SchoolID From User U join Staff S join facultymember fm)";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			query = "Select Degree From facultymemberdegrees Where EmpID=?";
			pst = conn.prepareStatement(query);
			
			while(rs.next()) {
				ArrayList<String> facDegrees = new ArrayList<String>();
				pst.setString(1, rs.getString(10));
				ResultSet rs2 = pst.executeQuery();
				
				while(rs2.next())
					facDegrees.add(rs2.getString(1));
				
				Session.getInst().getSchool(rs.getString(13)).getFaculty().add(new FacultyMember(rs.getString(1), rs.getString(2),  rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7).charAt(0),
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), facDegrees,
						rs.getString(12)));
			}
				
			for(School sch:Session.getInst().getSchools()) {
				for(FacultyMember facM:sch.getFaculty()) {
					Session.getInst().getUsers().add(facM);
				}
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
	}

}
