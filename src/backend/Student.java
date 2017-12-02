package backend;

import java.util.ArrayList;
import java.util.Date;

public class Student extends User{

	private String rollNo;
	private String fatherCNIC;
	private String fatherName;
	private float CGPA;
	private int creditsEarned;
	private int creditsAttempted;
	private ArrayList<CourseSection> courses = null;
	private Transcript trans = null;
	
	public Student(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String rollNo, String fatherCNIC, String fatherName, float cGPA,
			int creditsEarned, int creditsAttempted, ArrayList<CourseSection> courses, Transcript trans) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.rollNo = rollNo;
		this.fatherCNIC = fatherCNIC;
		this.fatherName = fatherName;
		this.CGPA = cGPA;
		this.creditsEarned = creditsEarned;
		this.creditsAttempted = creditsAttempted;
		this.courses = courses;
		this.trans = trans;
	}
	
	public ArrayList<CourseSection> getStudiedCourses()
	{
		return courses;
	}
	
	public String getRollNo() 
	{
		return rollNo;
	}

	public void setRollNo(String rollNo) 
	{
		this.rollNo = rollNo;
	}

	public String getFatherCNIC() 
	{
		return fatherCNIC;
	}

	public void setFatherCNIC(String fatherCNIC) 
	{
		this.fatherCNIC = fatherCNIC;
	}

	public String getFatherName() 
	{
		return fatherName;
	}

	public void setFatherName(String fatherName) 
	{
		this.fatherName = fatherName;
	}

	public float getCGPA() 
	{
		return CGPA;
	}

	public void setCGPA(float CGPA) 
	{
		this.CGPA = CGPA;
	}

	public int getCreditsEarned() 
	{
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned) 
	{
		this.creditsEarned = creditsEarned;
	}

	public int getCreditsAttempted() 
	{
		return creditsAttempted;
	}

	public void setCreditsAttempted(int creditsAttempted) 
	{
		this.creditsAttempted = creditsAttempted;
	}
	
	public Grade getCourseGrade(String courseCode) {
		return trans.getGrade(courseCode);
	}

	public ArrayList<CourseSection> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<CourseSection> courses) {
		this.courses = courses;
	}

	public Transcript getTranscript() {
		return trans;
	}

	public void setTranscript(Transcript transcript) {
		this.trans = transcript;
	}

	
	
	
	//////////////////////////REMOVE SECTION HELPER/////////////////////////////////
	public boolean ifSectionExists(char SectionID)
	{
		
		for(CourseSection cs : this.courses)
		{
			  if(cs.getSectionID()==SectionID)
			  {
			     return true;
			  }
		}
	
		return false;
	}
	
	///////////////////////NOUMAN//////////////
	
	public boolean removeStudentCourseRegistration(CourseSection cs) {
		if(this.courses.contains(cs)) {
			this.courses.remove(cs);
			return true;
		}
		else
			return false;
	}
	
	public boolean removeGradeFromTranscript(CourseSection cs,LGrade L) {
		Grade g = new Grade(L,cs);
		return this.trans.removeGrade(g);
	}
	
	/*public void viewDetails()
	{
		super.viewDetails();
		System.out.println("RollNo : \t" + rollNo);
		System.out.println("FatherCNIC : \t" + fatherCNIC);
		System.out.println("FatherName : \t" + fatherName);
		System.out.println("CGPA : \t" + CGPA);
		System.out.println("Credits Earned : \t" + creditsEarned);
		System.out.println("Credits Attempted : \t" + creditsAttempted);
		
		
    	
	}*/
}
