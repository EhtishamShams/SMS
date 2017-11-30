package backend;

import java.util.*;
import dal.DAL;
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

	public AcademicInstitution(String name, String location, ArrayList<School> schools, ArrayList<User> users1,
			ArrayList<Department> depts) {
		this.name = name;
		this.location = location;
		this.schools = schools;
		this.users = users1;
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

	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	// helper function to return the school from the id

	public boolean updateSchool(String id, String n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < (this.schools.size()); i++) {
			if (this.schools.get(i).getId().equals(id)) {
				schools.get(i).setName(n);
				return true;
			}
		}
		return false;
	}

	public boolean Validate(String id, String n) {
		boolean check = true;
		for (int i = 0; i < (this.schools.size()); i++) {
			if (this.schools.get(i).getId().equals(id) || this.schools.get(i).getName().equals(n)) {
				check = false;
			}
		}
		 check=DAL.updateSchoolDB(id,n);
		if (check) {
			School temp = new School(id, n);
			schools.add(temp);

		}
		return check;
	}

	public School getSchool(String name) {
		for (int i = 0; i < this.schools.size(); i++) {
			if (schools.get(i).getName().equals(name))
				return schools.get(i);
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

}
