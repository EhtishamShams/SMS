package backend;

import java.util.*;

/**
 * 
 */

/**
 * @author Ehtisham
 *
 */

public class AcademicInstitution {
	private String name;
	private String location;
	private ArrayList<School> schools;
	private ArrayList<User> users;
	private ArrayList<Department> depts;
	private ArrayList<Semester> semesters;

	public AcademicInstitution(String name, String location, ArrayList<School> schools, ArrayList<User> users,
			ArrayList<Department> depts, ArrayList<Semester> sems) {
		this.name = name;
		this.location = location;
		this.schools = schools;
		this.users = users;
		this.depts = depts;
		this.semesters = sems;
	}

	public ArrayList<School> getSchools() {

		return schools;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Department> getDepts() {
		return depts;
	}

	public void setDepts(ArrayList<Department> depts) {
		this.depts = depts;
	}

	public ArrayList<User> getUsers() {

		return users;
	}

	public School getSchool(String sID) {
		for (School s : schools) {
			if (s.getId().equals(sID))
				return s;
		}
		return null;
	}

	// hamza
	public Semester getSemester(String session) {

		for (Semester sem : semesters) {
			if (sem.getSession().equals(session))
				return sem;
		}

		return null;
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	// hamza
	public FacultyMember getFacultyMember(String empID) {
		for (School sch : schools) {
			for (FacultyMember FM : sch.getFaculty()) {
				if (FM.getEmpID().equals(empID))
					return FM;
			}
		}

		return null;
	}

	public Staff getStaff(String empID) {

		for (School sch : schools) {
			Staff temp = sch.getFacultyMember(empID);
			if (temp != null)
				return temp;
		}

		for (Department dep : depts) {
			Staff temp = dep.getStaffMember(empID);
			if (temp != null)
				return temp;
		}

		return null;
	}
	
	public School getStudentSchool(String rollNum) {
		for (School s : schools) {
			if (s.ifStudentExists(rollNum))
				return s;
		}
		return null;
	}
	
	public School getFacultySchool(String empID) {
		for (School s : schools) {
			if (s.ifFacultyExists(empID))
				return s;
		}
		return null;
	}
	
	public Student getStudent(String rollNo) {

		for (School sch : schools) {
			Student temp = sch.getStudent(rollNo);
			if (temp != null)
				return temp;
		}
		return null;
	}

	public Course getCourse(String code) {

		for (School sch : schools) {
			return sch.getCourse(code);
		}

		return null;
	}

	public School getCourseSchool(String code) {
		for(School sch:schools) {
			if(sch.getCourse(code)!=null)
				return sch;
		}
		
		return null;
	}
}
