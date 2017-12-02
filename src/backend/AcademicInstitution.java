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
			ArrayList<Department> depts) {
		this.name = name;
		this.location = location;
		this.schools = schools;
		this.users = users;
		this.depts = depts;
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

	public ArrayList<School> getSchools() {
		return schools;
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

	public Student getStudent(String rollNum) {
		for (User u : users) {
			if ((u instanceof Student) && ((Student) u).getRollNo().equals(rollNum))
				return (Student) u;
		}
		return null;
	}

	public FacultyMember getFacultyMember(String empID) {
		for (School sch : schools) {
			for (FacultyMember FM : sch.getFaculty()) {
				if (FM.getEmpID().equals(empID))
					return FM;
			}
		}

		return null;
	}

}
