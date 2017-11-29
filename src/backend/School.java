/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Date;

import dal.DAL;
import dal.DBAccess;

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
			if(c.getCourseCode().equals(code))
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
	
	public boolean validateStudent(String CNIC) {
		
		for(Student st:students) {
			if(st.getCNIC().equals(CNIC))
				return false;
		}
		
		return true;
	}
	
	public boolean validateUpdateStudent(String CNIC, Student obj) {
		
		for(Student st:students) {
			if(st.getCNIC().equals(CNIC) && st!=obj)
				return false;
		}
		
		return true;
	}
	
	public boolean ifCourseExists(String code) {
		
		for(Course c:this.courses) {
			if(c.getCourseCode().equals(code))
				return true;
		}
		return false;
	}
	
	public boolean findFaculty(String empID) {
		
		for(FacultyMember FM:faculty) {
			if(FM.getEmpID().equals(empID))
				return true;
		}
		
		return false;
	}
	
	public Student getStudent(String rollNo) {
		
		for(Student stu:students) {
			if(stu.getRollNo().equals(rollNo))
				return stu;
		}
		
		return null;
	}
	
	public boolean addCourse(Course c) {
		
		//Adding in database
		if(!DAL.addCourse(c, this))
			return false;
		
		//Adding in ArrayList
		this.courses.add(c);
		return true;
	}
	
	public boolean addStudent(Student std) {
		
		if(!DAL.addStudent(std, this))
			return false;
		
		students.add(std);
		return true;
	}
	
	public boolean removeCourse(Course c) {
		
		if(!DAL.removeCourse(c))
			return false;
		
		//CHECK IF UPDATING REQUIRED FOR ISOFFERED IN OBJECT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		return true;
	}
	
	public boolean removeFaculty(String empID, String repEmpID) {
		
		for(FacultyMember fac:faculty) {
			if(fac.getEmpID().equals(empID))
				faculty.remove(fac);
		}
		
		return true;
	}
	
	public boolean removeStudent(Student std) {
		
		if(!DAL.removeStudent(std))
			return false;
		
		students.remove(std);
		return true;
	}
	
	public static void main(String[] args) {
		
		DBAccess db = new DBAccess();
		DBAccess.createConnection();
		Student std = new Student("sdf", "sfklj", new Date(), "adsf", "sdf", "sdf", 'a', "asd", "asd", "as", "sdf", "sdf", 0, 0, 0, null);
		std.setRollNo("1");
		DAL.removeStudent(std);
	}
	
}
