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
	public ArrayList<CourseSection> courses;
	
	
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
	
	public boolean updateDetails(String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			conn.setAutoCommit(false);
			
			String query = "Update User Set Name=?, DateOfBirth=?, PhoneNo=?, CNIC=?, email=?, gender=?, emergencyContact=?, Address=? Where CNIC=?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setDate(2, (java.sql.Date) DOB);
			pst.setString(3, phone);
			pst.setString(4, CNIC);
			pst.setString(5, email);
			pst.setString(6, Character.toString(gender));
			pst.setString(7, eCont);
			pst.setString(8, address);
			pst.setString(9, this.getCNIC());
			pst.execute();
			
			query = "Update Student Set FatherName=?, FatherCNIC=? Where RollNo=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, fName);
			pst.setString(2, fCNIC);
			pst.setString(3, this.rollNo);
			pst.execute();
			
			conn.commit();
			conn.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
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

}
