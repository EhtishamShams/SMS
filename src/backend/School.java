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
	
	
	//////////////////////ADD FACULTY HELPER/////////////////////////////////////////////////
	
	public int ifFacultyExists(String empID)                  //returning index instead of boolean bcoz coz it later is required for update
	{
		int found = 0;
		for(FacultyMember fm : this.faculty)
		{
			  if(empID.equals(fm.getEmpID()))
			  {
			      found=faculty.indexOf(fm);
				  break;
			  }
			  
			  else
			  found=-1;
		}
	
		return found;
		
	}
	
	public FacultyMember getFacultyfromList(String empID)
	{
		for(FacultyMember fm : this.faculty)
		{
			  if(empID.equals(fm.getEmpID()))
			  {
			      return fm;
			  }
		}
		return null;
	}

	//////////////////////////////// ADD FACULTY ////////////////////////////////////////////////////
	
	protected boolean addFacultyMember(FacultyMember fm)
    {
    	return faculty.add(fm);
    }
	
	
	////////////////SECTION//////////////////////////////////////////////////////////////////////////
	public int courseExists(String code)
	{
		int found = 0;
		for(Course c : this.courses)
		{
			  if(code.equals(c.getCourseCode()))
			  {
			      found=courses.indexOf(c);
				  break;
			  }
			  
			  else
			  found=-1;
		}
	
		return found;
	}
	
	
	protected Course getCourseFromCourses(int i)
	{
		return courses.get(i);
	}
	
	protected void updateCourseToCourses(int i,Course c)
	{
		 courses.set(i,c);
	}
	//////////////////////////////////remove section helper///////////////////////
	protected ArrayList<Student> getStudentFromStudents(char SectionID)
	{
		ArrayList<Student> sectionStudent=new ArrayList<Student>();
		for(Student s : this.students)
		{
			  if(s.ifSectionExists(SectionID)==true)
			  {
			    sectionStudent.add(s);
			  }
		}
		return sectionStudent;
	}
	
	protected boolean facultyExists(FacultyMember f)
	{
		boolean found=false;
		for(FacultyMember fm : this.faculty)
		{
			  if(f.getEmpID().equals(fm.getEmpID()))
			  {
			      found=true;
				  break;
			  }
		 
		}
		 return found;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
