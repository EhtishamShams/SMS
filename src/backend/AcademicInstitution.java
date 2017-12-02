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
	private ArrayList<School> schools = null;
	private ArrayList<User> users = null;
	private ArrayList<Department> depts = null;
	
	public AcademicInstitution(String name, String location, ArrayList<School> schools,
			ArrayList<User> users, ArrayList<Department> depts) {
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
	
	public Student getStudent(String rollNum) {
		for (User u : users) {
			if ((u instanceof Student) && ((Student) u).getRollNo().equals(rollNum)) 
				return (Student)u;
		}
		return null;
	}
	
	public Staff getStaff(String empID) {
		for (User u : users) {
			if ((u instanceof Staff) && ((Staff) u).getEmpID().equals(empID)) 
				return (Staff)u;
		}
		return null;
	}
	
	public boolean studentLogin(String rollNum, String pass) {
		User u = getStudent(rollNum);
		if (u != null && u.matchPassword(pass)) {
			Session.setUser(u);
			Session.setType(UType.Student);
			return true;
		}
		else
			return false;
	}
	
	public boolean staffLogin(String empID, String pass) {
		User u = getStaff(empID);
		if (u != null && u.matchPassword(pass)) {
			Session.setUser(u);
			if (u instanceof HRManager)
				Session.setType(UType.HRManager);
			else if (u instanceof AcademicManager)
				Session.setType(UType.AcademicManager);
			else if (u instanceof FinanceManager)
				Session.setType(UType.FinanceManager);
			else if (u instanceof FacultyMember)
				Session.setType(UType.FacultyMember);
			return true;
		}
		else
			return false;
	}
	
	public boolean logout() {
		if (Session.getUser() != null) {
			Session.setUser(null);
			Session.setType(UType.LoggedOut);
			return true;
		}
		else
			return false;
	}

	public ArrayList<School> getSchools() {
		return schools;
	}

	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
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
	
	public School getSchool(String sID) {
		for (School s : schools) {
			if (s.getId().equals(sID))
				return s;
		}
		return null;
	}
	
	public void loadFaculty(ArrayList<FacultyMember> arr) {
		for (FacultyMember f : arr) {
			users.add(f);
		}
	}
	
	
	
}

