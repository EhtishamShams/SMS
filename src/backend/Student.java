package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private Transcript transcript;
	
	public Student(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String rollNo, String fatherCNIC, String fatherName, float cGPA,
			int creditsEarned, int creditsAttempted, ArrayList<CourseSection> courses) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address);
		this.rollNo = rollNo;
		this.fatherCNIC = fatherCNIC;
		this.fatherName = fatherName;
		CGPA = cGPA;
		this.creditsEarned = creditsEarned;
		this.creditsAttempted = creditsAttempted;
		this.courses = courses;
		//this.transcript = new Transcript();
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
	
	//hamza
	public boolean updateDetails(String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		
		
		this.name = name;
		this.DOB = DOB;
		this.phoneNo = phone;
		this.email = email;
		this.CNIC = CNIC;
		this.gender = gender;
		this.emergencyContact = eCont;
		this.address = address;
		this.fatherCNIC = fCNIC;
		this.fatherName = fName;
		
		return true;
	}
	
	//hamza
	public double computeGPA(ArrayList<Grade> grades) {
		
		double ret = 0;
		int credits = 0;
		
		for(Grade g:grades) {
			int grCreds = g.getCourseSection().getCourse().getCreditHours();
			credits+= grCreds;
			ret += g.getGrade().getGpa() * grCreds;
		}
		
		if(credits!=0)
			return ret/credits;
		else
			return 0;
	}
	
	//hamza
	public double computeCGPA() {
		int credits = 0;
		double ret = 0;
		for(Grade gr:transcript.getGrades()) {
			credits+=gr.getCourseSection().getCourse().getCreditHours();
			ret+=gr.getCourseSection().getCourse().getCreditHours()*gr.getGrade().getGpa();
		}
		if(credits!=0)
			return ret/credits;
		else
			return 0;
	}

}
