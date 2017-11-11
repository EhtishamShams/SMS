
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
	
	public Student() 
	{
		
	}
	
	
	
	public Student(String rollNo, String fatherCNIC, String fatherName, float cGPA, int creditsEarned,
			int creditsAttempted, ArrayList<CourseSection> courses) {
		super();
		this.rollNo = rollNo;
		this.fatherCNIC = fatherCNIC;
		this.fatherName = fatherName;
		CGPA = cGPA;
		this.creditsEarned = creditsEarned;
		this.creditsAttempted = creditsAttempted;
		this.courses = courses;
	}


	public void viewAttendance()
	{
		
	}

	public void viewTranscript()
	{
		
	}

	public boolean updateDetails(String name, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, String fatherCNIC, String fatherName)
	{
		return true;
	}
	
	public boolean addGrade(Grade g)
	{
		return true;
	}
	
	public ArrayList<CourseSection> getStudentCourseSections()
	{
		return courses;
	}
	
	public ArrayList<Attendance> getAttendance(String crsCode, String secID, Semester sem)
	{
		return null;
	}
	
	public boolean addCourseSection(CourseSection crs)
	{
		return false;
	}
	
	public boolean removeCourseSection(CourseSection crs)
	{
		return false;
	}
	
	public CourseSection getCourse(String code, Semester sem)
	{
		return null;
	}
	
	public Grade getGrade(CourseSection cs)
	{
		return null;
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

}
