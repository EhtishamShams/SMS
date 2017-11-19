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
	
	public Student getStudent(String rollNo) {
		for(Student s : students)
		{
			if(s.getRollNo()==rollNo)
				return s;
		}
		
		return null;
	}
	
	public Course getCourse(String courseCode) {
		for(Course c : courses)
		{
			if(c.getCourseCode()==courseCode)
				return c;
		}
		
		return null;
	}
	
	public CourseSection getCourseSection(Course c, char secID) {
		return c.getCourseSection(secID);
	}
	
	public boolean registerStudentInCourse(Student s, Course c, CourseSection cs,Semester sem) {
		
		if(s.checkSemesterRegistrations(sem).size()<5)
		{
			ArrayList<Course> prereq = c.getPrerequisites();
			
			boolean passed = s.checkCoursesPassed(prereq);
			boolean seatAvailibility = cs.checkSeatAvailibility();
			
			if(passed && seatAvailibility) {
				cs.incrementCurrSeats();
				s.addStudentCourseRegistration(cs);
				s.addGradeToTranscript(cs, LGrade.I);
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	

	public boolean updateStudentCourseRegistration(Student s, CourseSection oldCs, CourseSection newCs) {
		
		if(newCs.checkSeatAvailibility()) {
			newCs.incrementCurrSeats();
			oldCs.decrementCurrSeats();
			s.addStudentCourseRegistration(newCs);
			s.removeStudentCourseRegistration(oldCs);
			s.updateGradeSection(oldCs, newCs);
			
			return true;
		}
		else
			return false;
	}

	public boolean removeStudentCourseRegistration(Student s, CourseSection cs) {
		
		if(s.removeGradeFromTranscript(cs,LGrade.I) && s.removeStudentCourseRegistration(cs)) {
			cs.decrementCurrSeats();
			return true;
		}
		else
			return false;
	}
}
