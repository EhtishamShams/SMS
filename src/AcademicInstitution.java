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
	private ArrayList<Timetable> timetables;
	private ArrayList<School> schools;
	private ArrayList<User> users;
	private ArrayList<Department> depts;
	
	public AcademicInstitution(String name, String location, ArrayList<Timetable> timetables, ArrayList<School> schools,
			ArrayList<User> users, ArrayList<Department> depts) {
		super();
		this.name = name;
		this.location = location;
		this.timetables = timetables;
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
	
	
	
}

