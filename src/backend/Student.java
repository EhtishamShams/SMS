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
	private ArrayList<CourseSection> courses;
	private Transcript trans;
	
	public Student(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String rollNo, String fatherCNIC, String fatherName, float cGPA,
			int creditsEarned, int creditsAttempted, ArrayList<CourseSection> courses, Transcript trans) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.rollNo = rollNo;
		this.fatherCNIC = fatherCNIC;
		this.fatherName = fatherName;
		CGPA = cGPA;
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

}
