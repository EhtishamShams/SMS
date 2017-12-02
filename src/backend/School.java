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
	private ArrayList<FacultyMember> faculty = null;
	private ArrayList<Student> students = null;
	private ArrayList<Course> courses = null;
	
	public School(String id, String name, ArrayList<FacultyMember> faculty, ArrayList<Student> students,
			ArrayList<Course> courses) {
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.students = students;
		this.courses = courses;
	}
	
	public School(String sid, String n) {
		this.id = sid;
		this.name = n;
		this.faculty = new ArrayList<FacultyMember>();
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<Course>();
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
	

	//helper for mark attendance
//	public Student getStudent(String s)
//	{
//		for(int i=0 ; i< this.students.size();i++)
//		{
//			if(this.students.get(i).getRollNo().equals(s))
//			{
//				return this.students.get(i);
//			}
//			
//		}
//		return null;
//	}

	public boolean ifStudentExists(String rollNum) {
		for (Student s : students) {
			if (s.getRollNo().equals(rollNum))
				return true;
		}
		return false;
	}

	public boolean ifFacultyExists(String empID) {
		for (FacultyMember f : faculty) {
			if (f.getEmpID().equals(empID))
				return true;
		}
		return false;
	}
	
	//////////////////////ADD FACULTY HELPER/////////////////////////////////////////////////
	
	public int ifFacultyExistsByIndex(String empID)                  //returning index instead of boolean bcoz coz it later is required for update
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
	public int courseExistsByIndex(String code)
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
	/////////////////////////////////////////////NOUMAN///////////////////////////
	
	public Course getCourse(String courseCode) {
		for(Course c : courses)
		{
			if(c.getCourseCode().equals(courseCode))
				return c;
		}
		
		return null;
	}
	
	public Student getStudent(String rollNo) {
		for(Student s : students)
		{
			if(s.getRollNo().equals(rollNo))
				return s;
		}
		
		return null;
	}
	
	public CourseSection getCourseSection(Course c, char secID,Semester sem) {
		return c.getCourseSection(secID,sem);
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
	
	
	//helper for mark attendance
//	public Course getCourse(String s)
//	{
//		for(int i=0 ; i< this.courses.size();i++)
//		{
//			if(this.courses.get(i).getCourseCode().equals(s))
//			{
//				return this.courses.get(i);
//			}
//			
//		}
//		return null;
//	}
//	
	
   public  ArrayList<CourseSection> getFacultyCourseSections(String id)
   {
	   ArrayList<CourseSection> sec= new ArrayList<CourseSection>();
	   Semester current=Session.getSem();  
	    
	   for(int i=0; i<this.courses.size();i++)   
	   {
		   for(int j=0;j<courses.get(i).getSections().size();j++)
		   {
			   if(courses.get(i).getSections().get(j).getSectionTeacher().empID.equals(id)  &&  courses.get(i).getSections().get(j).getSemester().getSession().equals(current.getSession()))
			   {
				   sec.add(courses.get(i).getSections().get(j));
			   }
			   
		   }
	   }
   
	   return sec;
	   
   }

}
