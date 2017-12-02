/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;

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

		for (Course c : this.courses) {
			if (c.getCourseCode().equals(code))
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

	// hamza
	public boolean validateStudent(String CNIC) {

		for (Student st : students) {
			if (st.getCNIC().equals(CNIC))
				return false;
		}

		return true;
	}

	// hamza
	public boolean validateUpdateStudent(String CNIC, Student obj) {

		for (Student st : students) {
			if (st.getCNIC().equals(CNIC) && st != obj)
				return false;
		}

		return true;
	}

	// hamza
	public boolean ifCourseExists(String code) {

		for (Course c : this.courses) {
			if (c.getCourseCode().equals(code))
				return true;
		}
		return false;
	}

	// hamza
	public boolean findFaculty(String empID) {

		for (FacultyMember FM : faculty) {
			if (FM.getEmpID().equals(empID))
				return true;
		}

		return false;
	}

	// hamza
	public Student getStudent(String rollNo) {

		for (Student stu : students) {
			if (stu.getRollNo().equals(rollNo))
				return stu;
		}

		return null;
	}

	// hamza
	public boolean addCourse(Course c) {

		// Adding in database
		if (!DAL.addCourse(c, this))
			return false;

		// Adding in ArrayList
		this.courses.add(c);
		return true;
	}

	// hamza
	public boolean addStudent(Student std) {

		if (!DAL.addStudent(std, this))
			return false;

		students.add(std);
		return true;
	}

	// hamza
	public boolean removeCourse(Course c) {

		if (!DAL.removeCourse(c))
			return false;

		for (CourseSection cSec : c.getSections()) {
			if (cSec.getSemester().getSession().equals(Session.getSem().getSession()))
				;// TODO: Call Humna's RemoveCourseSection function here on cSec
		}

		c.setIsOffered(false);

		return true;
	}

	// hamza
	public boolean removeFaculty(String empID, String repEmpID) {

		FacultyMember facM = null;

		for (FacultyMember fac : faculty) {
			if (fac.getEmpID() == empID)
				facM = fac;
		}

		// TODO: need to get replacement if the employee is currently teaching a course
		// if(facM.getCurrentSectionCourseSections()==null && repEmpID==null)
		// return false;

		if (!DAL.removeFaculty(empID, repEmpID))
			return false;

		// Removing Staff
		for (Staff u : Session.getAcademicDept().getStaff()) {
			if (u.getCNIC().equals(facM.getCNIC())) {
				Session.getInst().getUsers().remove(u);
			}
		}

		// Removing User
		for (User u : Session.getInst().getUsers()) {
			if (u.getCNIC().equals(facM.getCNIC())) {
				Session.getInst().getUsers().remove(u);
			}
		}

		// Removing Pay
		for (Pay pay : Session.getAccountsDept().getPays()) {
			if (pay.getStaffMember().getCNIC().equals(facM.getCNIC()))
				Session.getAccountsDept().getPays().remove(pay);
		}

		// Removing From School
		for (FacultyMember fac : faculty) {
			if (fac.getEmpID().equals(empID))
				faculty.remove(fac);
		}

		// Replacing current courses
		if (repEmpID != null) {

			FacultyMember replacement = null;

			for (FacultyMember fac : faculty) {
				if (fac.getEmpID() == repEmpID)
					replacement = fac;
			}

			for (Course crs : courses) {
				for (CourseSection crsSec : crs.getSections()) {
					if (crsSec.getSemester().getSession().equals(Session.getSem().getSession())
							&& crsSec.getTeacher().getEmpID().equals(empID))
						crsSec.setTeacher(replacement);

				}
			}
		}

		return true;
	}

	// hamza
	public boolean removeStudent(Student std) {

		if (!DAL.removeStudent(std))
			return false;

		// Removing User
		for (User u : Session.getInst().getUsers()) {
			if (u.getCNIC().equals(std.getCNIC())) {
				Session.getInst().getUsers().remove(u);
			}
		}

		// Removing Attendance
		for (CourseSection crs : std.getStudiedCourses()) {
			for (Attendance att : crs.getStudentAttendance()) {
				if (att.getStudent() == std)
					crs.getStudentAttendance().remove(att);
			}
		}

		// Removing Fee
		for (Fee fee : Session.getAccountsDept().getFees()) {
			if (fee.getStudent() == std)
				Session.getAccountsDept().getFees().remove(fee);
		}

		students.remove(std);
		return true;
	}

	// hamza
	public FacultyMember getFacultyMember(String empID) {
		for (FacultyMember fac : faculty) {
			if (fac.getEmpID().equals(empID))
				return fac;
		}

		return null;
	}

}
