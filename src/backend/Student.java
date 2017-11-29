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
	public ArrayList<CourseSection> courses;
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
		this.transcript = new Transcript();
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

	public ArrayList<CourseSection> checkSemesterRegistrations(Semester sem) {
		ArrayList<CourseSection> csList = new ArrayList<>();
		
		for(CourseSection cs:courses) {
			if(cs.getSemester().equals(sem))
				csList.add(cs);
		}
		
		return csList;
	}
	
	public boolean checkCoursesPassed(ArrayList<Course> cList) {
		return transcript.checkCoursesPassed(cList);
	}
	
	public void addStudentCourseRegistration(CourseSection cs) {
		this.courses.add(cs);
	}
	
	public boolean removeStudentCourseRegistration(CourseSection cs) {
		if(this.courses.contains(cs)) {
			this.courses.remove(cs);
			return true;
		}
		else
			return false;
	}
	
	public void addGradeToTranscript(CourseSection cs, LGrade L) {
		Grade g = new Grade(L,cs);
		this.transcript.addGrade(g);
	}
	
	public boolean removeGradeFromTranscript(CourseSection cs,LGrade L) {
		Grade g = new Grade(L,cs);
		return this.transcript.removeGrade(g);
	}
	
	public void updateGradeSection(CourseSection oldCs, CourseSection newCs) {
		this.transcript.updateGradeSection(oldCs, newCs);
	}
}
