package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import backend.*;

public class DAL {

	public static int getSectionKey(char sectionID,String courseCode,String session) {
		int sectionKey = -1;
		
		try{  
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement(); 
			 
			ResultSet rs=stmt.executeQuery("select * from coursesection where SectionID='"+sectionID+"' and courseCode='"+courseCode+"' and Session='"+session+"';");  
			
			while(rs.next())  
				sectionKey = rs.getInt(1);
			
			return sectionKey;
		}catch(Exception e){ 
			System.out.println(e);
			return sectionKey;
		} 
	}
	
	public static boolean incrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("Update coursesection Set CurrSeats = CurrSeats+1 Where SectionKey ="+ sectionKey+";");
			  
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean decrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("Update coursesection Set CurrSeats = CurrSeats-1 Where SectionKey ="+ sectionKey+";");
			  
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean addStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			DBAccess.createConnection();
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("insert into studentcoursesection (RollNo,SectionKey) values ('"+rollNo+"',"+sectionKey+");");
			 
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean removeStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("delete from studentcoursesection where RollNo='"+rollNo+"' and SectionKey="+sectionKey+";");
			 
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean addGradeToTranscript(String grade,int sectionKey,String rollNo,String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("insert into grade (Grade,SectionKey,RollNo,Session) values ('"+grade
					+"',"+sectionKey+",'"+rollNo+"','"+session+"');");
			 
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean removeGradeFromTranscript(String grade,int sectionKey,String rollNo,String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("delete from grade where Grade ='"+grade
					+"' and sectionKey = "+sectionKey+" and RollNo='"+rollNo+"' and Session='"+session+"';");
			  
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static boolean updateGradeSection(String grade,int oldSectionKey,int newSectionKey,String rollNo,String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			stmt.executeUpdate("update grade set SectionKey ="+newSectionKey
					+" where Grade = '" + grade+"' and SectionKey = "+oldSectionKey+" and RollNo='"+rollNo+"' and Session='"+session+"';");
			 
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public static int getUserIDFacultyMember(String empID) {
		int userID = -1;
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			ResultSet rs = stmt.executeQuery("select * from staff where EmpID='"+empID+"';");
			
			while(rs.next())  
				userID = rs.getInt(1);
			
			return userID;
		}catch(Exception e){ 
			System.out.println(e);
			return userID;
		} 
	}
	
	public static boolean updateFacultyDetails(String empID,String name, Date DOB, String phoneNo, String email,String CNIC,char gender,
			String emergencyContact, String address, ArrayList<String> degrees, String position) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();
			
			con.setAutoCommit(false);
			
			int userID = getUserIDFacultyMember(empID);
			stmt.executeUpdate("update user set name ='"+name+"',DateOfBirth = '"+DOB
					+"',PhoneNo='"+phoneNo+"', email='"+email+"',CNIC='"+CNIC+"',Gender='"+gender
					+"',EmergencyContact='"+emergencyContact+"',Address='"+address+"' where UserID="+userID+";");
			
			stmt = DBAccess.getStatement();
			stmt.executeUpdate("delete from facultymemberdegrees where EmpID='"+empID+"';");
			
			for(String d : degrees) {
				stmt = DBAccess.getStatement();
				stmt.executeUpdate("insert into facultymemberdegrees values ('"+empID+"','"+d+"');");
			}
			
			stmt = DBAccess.getStatement();
			stmt.executeUpdate("update facultymember set position='"+position+"' where EmpID='"+empID+"';");
			
			con.commit();
			
			return true;
		}catch(Exception e){ 
			System.out.println(e);
			return false;
		} 
	}
	
	public ArrayList<Student> getStudents(School school){
		ArrayList<Student> stdList = new ArrayList<>();
		
		try{  
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement(); 
			 
			ResultSet rs = stmt.executeQuery("select * from user inner join student on user.UserID = student.UserID where student.SchoolID='"+school.getId()+"';");  
			
			String rollNo,fatherCNIC,fatherName;
			float CGPA;
			int creditsEarned,creditsAttempted;
			ArrayList<CourseSection> courses;
			
			while(rs.next())  
			{
				sectionKey = rs.getInt(1);
			}
			
			return sectionKey;
		}catch(Exception e){ 
			System.out.println(e);
			return sectionKey;
		} 
	}
}
