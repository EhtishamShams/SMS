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
	
	public boolean addCourse(Course c) {
		
		//Adding in Database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			String query = "Insert Into course Values(?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, c.getCourseCode());
			pst.setString(2, c.getCourseName());
			pst.setInt(3, c.getCreditHours());
			pst.setString(4, c.getDescription());
			pst.setString(5, this.id);
			pst.execute();
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
	

}
