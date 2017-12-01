package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import backend.*;

/**
 * @author hamza
 *
 */

public class DAL {
	
	public static boolean addCourse(Course c, School sch) {
		// Adding in Database
		try {
			Connection conn = DBAccess.getConnection();

			String query = "Insert Into course Values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.setString(2, c.getCourseName());
			pst.setInt(3, c.getCreditHours());
			pst.setString(4, c.getDescription());
			pst.setString(5, sch.getId());
			pst.setBoolean(6, true);
			pst.execute();

			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());

			for (Course pReq : c.getPrerequisites()) {

				pst.setString(2, pReq.getCourseCode());
				pst.execute();
			}

			conn.commit();
			
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public static boolean addStudent(Student std, School sch) {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Insert into User(Name, DateOfBirth, PhoneNo, CNIC, email, gender, emergencyContact, Address) Values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getName());
			pst.setDate(2, (java.sql.Date) std.getDOB());
			pst.setString(3, std.getPhoneNo());
			pst.setString(4, std.getCNIC());
			pst.setString(5, std.getEmail());
			pst.setString(6, Character.toString(std.getGender()));
			pst.setString(7, std.getEmergencyContact());
			pst.setString(8, std.getAddress());
			pst.execute();
			
			query = "Select UserID From User Where CNIC=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, std.getCNIC());
			ResultSet rs = pst.executeQuery();
			rs.next();
			String userID = rs.getString(1);
			
			query = "Insert into Student(UserID, FatherName, FatherCNIC, CGPA, CreditsEarned, CreditsAttempted, SchoolID) Values(?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, userID);
			pst.setString(2, std.getFatherName());
			pst.setString(3, std.getFatherCNIC());
			pst.setDouble(4, std.getCGPA());
			pst.setInt(5, std.getCreditsEarned());
			pst.setInt(6, std.getCreditsAttempted());
			pst.setString(7, sch.getId());
			pst.execute();
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public static boolean removeCourse(Course c) {

		// Updating course status in database
		try {
			Connection conn = DBAccess.getConnection();

			String query = "Update course Set IsOffered=? where CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setBoolean(1, false);
			pst.setString(2, c.getCourseCode());
			pst.executeUpdate();

			query = "Delete from coursesection Where CourseCode = (Select CourseCode From (Select * From coursesection) As A join semester s where s.IsActive=true and s.CourseCode=?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.execute();

			conn.commit();
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public static boolean removeFaculty(String empID, String repEmpID) {
		
		String userID;
		
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

	public static boolean updateCourseDetails(String courseName, int creditHours, String description, ArrayList<Course> prerequisites, Course crs) {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Update Course Set CourseName=?, CreditHours=?, Description=? Where CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, courseName);
			pst.setInt(2, creditHours);
			pst.setString(3, description);
			pst.setString(4, crs.getCourseCode());
			pst.executeUpdate();
			
			query = "Delete From CoursePrerequisites Where CourseCode=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, crs.getCourseCode());
			pst.execute();
			
			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, crs.getCourseCode());
			
			for(Course pReq:prerequisites) {
				
				pst.setString(2,  pReq.getCourseCode());
				pst.execute();
			}
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	public static boolean updateStudentDetails(String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName, Student stu) {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Update User Set Name=?, DateOfBirth=?, PhoneNo=?, CNIC=?, email=?, gender=?, emergencyContact=?, Address=? Where CNIC=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setDate(2, (java.sql.Date) DOB);
			pst.setString(3, phone);
			pst.setString(4, CNIC);
			pst.setString(5, email);
			pst.setString(6, Character.toString(gender));
			pst.setString(7, eCont);
			pst.setString(8, address);
			pst.setString(9, stu.getCNIC());
			pst.execute();
			
			query = "Update Student Set FatherName=?, FatherCNIC=? Where RollNo=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, fName);
			pst.setString(2, fCNIC);
			pst.setString(3, stu.getRollNo());
			pst.execute();
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		return true;
	}

	//TODO: Check remove student functionalities
	public static boolean removeStudent(Student std) {
		
		String userID;
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select UserID From User Where UserID = (Select S.UserID From (Select * From User) As U join Student S Where U.UserID=S.UserID and S.RollNo=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
			ResultSet rs = pst.executeQuery();
			rs.next();
			userID = rs.getString(1);
		
			query = "Delete from Student Where RollNo=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
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

	public static ArrayList<Fee> getFees(Student std) {
		
		ArrayList<Fee> fees = new ArrayList<Fee>();
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From Fee Where RollNo=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, std.getRollNo());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				fees.add(new Fee(rs.getDouble(1), rs.getDate(2), rs.getDate(3), std, Session.getInst().getSemester(rs.getString(4))));
			}	
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return null;
		}
		
		return fees;
	}
	
	public static ArrayList<Pay> getPays(Staff staff) {
		
		ArrayList<Pay> pays = new ArrayList<Pay>();
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From pay Where EmpID=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, staff.getEmpID());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				pays.add(new Pay(rs.getDouble(1), rs.getDate(2), staff));
			}	
			
			conn.commit();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return null;
		}
		
		return pays;
	}

//	public static ArrayList<String> getStudentCourses(String rollNo){
//		
//		ArrayList<Course> courses = new ArrayList<Course>();
//		
//		try {
//			
//			Connection conn = DBAccess.getConnection();
//		
//			
//			String query = "Select CourseCode From Course Where CourseCode=(Select CourseCode From studentcoursesection join CourseSection where RollNo=?)";
//			PreparedStatement pst = conn.prepareStatement(query);
//			pst.setString(1, rollNo);
//			ResultSet rs = pst.executeQuery();
//			
//			while(rs.next()) {
//				
//			}	
//			
//			conn.commit();
//		}
//		catch(Exception e) {
//			
//			System.out.println(e);
//			return null;
//		}
//		
//		return pays;
//	}
	
}


