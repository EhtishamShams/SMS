
package backend;

import java.util.ArrayList;
import java.util.Date;


public class FacultyMember extends Staff {
	
	private ArrayList<String> degrees;
	private String position;
	
	public FacultyMember(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired, ArrayList<String> degrees,
			String position) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
		this.degrees = degrees;
		this.position = position;
	}

	public ArrayList<String> getDegrees() {
		return degrees;
	}

	public void setDegrees(ArrayList<String> degrees) {
		this.degrees = degrees;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	//mark attendance functionality
	public boolean markAttendance(School sch,String Ccode,String rollno,char SID,LAttendance atd,Semester sem,Date day)
	{
	    Student s= sch.getStudent(rollno);
	    Course c= sch.getCourse(Ccode);
	    CourseSection cs= c.getCourseSection(sem, SID);
	    Attendance at= new  Attendance(atd,day,s,cs);	    
	    boolean check=cs.addAttendance(at);
		return check;
	}
	

}
