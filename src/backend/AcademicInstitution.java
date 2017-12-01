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
	
	public School getSchool(String school_id)
	{

		for(School sch : this.schools)
		{
			  if(school_id.equals(sch.getId()))
			  {
			      return sch;
			  }
		}
		return null;
	}

	
	///////////////////////////////MUAZ/////////////////////////////////////////
	
	 public Staff getStaff(String empID) {    
			
	   	 for (User u : users) {
				if ((u instanceof Staff) && ((Staff) u).getEmpID().equals(empID)) 
					return (Staff)u;
			}
			return null;
		}

	
	////////////////////////////NOUMAN////////////////////////
	 public ArrayList<School> getSchools(){
			
			return schools;
		}
	 
	
}

