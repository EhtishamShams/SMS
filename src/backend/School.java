/**
 * 
 */
package backend;

import java.util.ArrayList;

/**
 * @author Ehtisham
 *
 */
public class School {
	
	private String id;
	private String name;
	private ArrayList<FacultyMember> faculty = null;
	private ArrayList<Student> students = null;
	private ArrayList<Course> courses = null;
	
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
	
	public boolean ifStudentExists(String rollNum) {
		for (Student s : students) {
			if (s.getRollNo().equals(rollNum))
				return true;
		}
		return false;
	}

	public boolean ifFacultyExists(String empID) {
		for (FacultyMember f : faculty) {
			if (f.getEmpID().equals(empID))
				return true;
		}
		return false;
	}
	
	

}
