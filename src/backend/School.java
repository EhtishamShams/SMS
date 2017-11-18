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
	
	//helper for mark attendance
	public Student getStudent(String s)
	{
		for(int i=0 ; i< this.students.size();i++)
		{
			if(this.students.get(i).getRollNo().equals(s))
			{
				return this.students.get(i);
			}
			
		}
		return null;
	}
	
	//helper for mark attendance
	public Course getCourse(String s)
	{
		for(int i=0 ; i< this.courses.size();i++)
		{
			if(this.courses.get(i).getCourseCode().equals(s))
			{
				return this.courses.get(i);
			}
			
		}
		return null;
	}
	
	
}
