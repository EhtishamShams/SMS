/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.sql.*;

/**
 * @author Ehtisham
 *
 */
public class School {
	
	private String id;
	private String name;
	private ArrayList<FacultyMember> faculty;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	public School(String id, String name, ArrayList<FacultyMember> faculty, ArrayList<Student> students,
			ArrayList<Course> courses) {
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.students = students;
		this.courses = courses;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Course getCourse(String code) {
		
		for(Course c:this.courses) {
			if(c.getCourseCode()==code)
				return c;
		}
		
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<FacultyMember> getFaculty() {
		return faculty;
	}

	public void setFaculty(ArrayList<FacultyMember> faculty) {
		this.faculty = faculty;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public boolean ifCourseExists(String code) {
		
		for(Course c:this.courses) {
			if(c.getCourseCode()==code)
				return true;
		}
		return false;
	}
	
	public boolean findFaculty(String empID) {
		
		for(FacultyMember FM:faculty) {
			if(FM.getEmpID()==empID)
				return true;
		}
		
		return false;
	}
	
	public boolean addCourse(Course c) {
		
		//Adding in Database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			conn.setAutoCommit(false);
			
			String query = "Insert Into course Values(?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.setString(2, c.getCourseName());
			pst.setInt(3, c.getCreditHours());
			pst.setString(4, c.getDescription());
			pst.setString(5, this.id);
			pst.setBoolean(6, true);
			pst.execute();
			
			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			
			for(Course pReq:c.getPrerequisites()) {
				
				pst.setString(2,  pReq.getCourseCode());
				pst.execute();
			}
			
			conn.commit();
			conn.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		//Adding in ArrayList
		this.courses.add(c);
		return true;
	}
	
	public boolean removeCourse(Course c) {
		
		//Updating course status in database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			conn.setAutoCommit(false);
			
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
			conn.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		//CHECK IF UPDATING REQUIRED FOR ISOFFERED IN OBJECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return true;
	}
	
	public boolean removeFaculty(String empID, String repEmpID) {
		
		String userID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			conn.setAutoCommit(false);
			
			String query = "Select UserID From User Where UserID = (Select S.UserID From (Select * From User) As U join Staff S Where U.UserID=S.UserID and S.EmpID=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, empID);
			ResultSet rs = pst.executeQuery();
			rs.next();
			userID = rs.getString(1);
			
			query = "Update CourseSection Set TeacherID=? Where TeacherID=? and session=(select session from Semester where IsActive=1)";
			pst = conn.prepareStatement(query);
			pst.setString(1, repEmpID);
			pst.setString(2, empID);
			pst.executeUpdate();
		
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
			conn.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		faculty.remove(empID);
		return true;
	}
	
}
