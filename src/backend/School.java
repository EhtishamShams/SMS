/**
 * 
 */
package backend;

import java.util.ArrayList;

import dal.DAL;

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
			if(s.getRollNo().equals(rollNo))
				return s;
		}
		
		return null;
	}
	
	public Course getCourse(String courseCode) {
		for(Course c : courses)
		{
			if(c.getCourseCode().equals(courseCode))
				return c;
		}
		
		return null;
	}
	
	public CourseSection getCourseSection(Course c, char secID,Semester sem) {
		return c.getCourseSection(secID,sem);
	}
	
	public boolean registerStudentInCourse(Student s, Course c, CourseSection cs,Semester sem) {
		
		if(s.checkSemesterRegistrations(sem).size()<5)
		{
			ArrayList<Course> prereq = c.getPrerequisites();
			
			boolean passed = s.checkCoursesPassed(prereq);
			boolean seatAvailibility = cs.checkSeatAvailibility();
			
			if(passed && seatAvailibility) {
				int sectionKey = DAL.getSectionKey(cs.getSectionID(), c.getCourseCode(), sem.getSession());
				
				cs.incrementCurrSeats();
				DAL.incrementCurrSeats(sectionKey);
				
				s.addStudentCourseRegistration(cs);
				DAL.addStudentCourseRegistration(s.getRollNo(), sectionKey);
				
				s.addGradeToTranscript(cs, LGrade.I);
				DAL.addGradeToTranscript(LGrade.I.toString(), sectionKey, s.getRollNo(), sem.getSession());
				
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	

	public boolean updateStudentCourseRegistration(Student s, CourseSection oldCs, CourseSection newCs, Semester sem) {
		
		if(newCs.checkSeatAvailibility()) {
			int oldSectionKey = DAL.getSectionKey(oldCs.getSectionID(), oldCs.getCourse().getCourseCode(), sem.getSession());
			int newSectionKey = DAL.getSectionKey(newCs.getSectionID(), newCs.getCourse().getCourseCode(), sem.getSession());
			
			newCs.incrementCurrSeats();
			DAL.incrementCurrSeats(newSectionKey);
			oldCs.decrementCurrSeats();
			DAL.decrementCurrSeats(oldSectionKey);
			
			s.addStudentCourseRegistration(newCs);
			DAL.addStudentCourseRegistration(s.getRollNo(), newSectionKey);
			s.removeStudentCourseRegistration(oldCs);
			DAL.removeStudentCourseRegistration(s.getRollNo(), oldSectionKey);
			oldCs.removeStudentAttendance(s);
			s.updateGradeSection(oldCs, newCs);
			DAL.updateGradeSection(LGrade.I.toString(), oldSectionKey, newSectionKey, s.getRollNo(), sem.getSession());
			
			return true;
		}
		else
			return false;
	}

	public boolean removeStudentCourseRegistration(Student s, CourseSection cs, Semester sem) {
		
		int sectionKey = DAL.getSectionKey(cs.getSectionID(), cs.getCourse().getCourseCode(), sem.getSession());
		
		if(s.removeGradeFromTranscript(cs,LGrade.I) && s.removeStudentCourseRegistration(cs)) {
			DAL.removeGradeFromTranscript(LGrade.I.toString(), sectionKey, s.getRollNo(), sem.getSession());
			DAL.removeStudentCourseRegistration(s.getRollNo(), sectionKey);
			cs.removeStudentAttendance(s);
			DAL.removeStudentAttendance(s.getRollNo(), sectionKey);
			cs.decrementCurrSeats();
			DAL.decrementCurrSeats(sectionKey);
			return true;
		}
		else
			return false;
	}
	
	/*
	public FacultyMember getFacultyMember(String empID) {
		for(FacultyMember f : faculty) {
			if(f.getEmpID().equals(empID))
				return f;
		}
		
		return null;
	}
	*/

}


