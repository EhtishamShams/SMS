
package backend;

import java.util.ArrayList;
import java.sql.Date;
import dal.DAL;

/**
 * @author Ehtisham
 *
 */

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
	
	public boolean updateDetails(String name, Date DOB, String phoneNo, String email,String CNIC,char gender,
			String emergencyContact, String address, ArrayList<String> degrees, String position) {
		this.name = name;
		this.DOB = DOB;
		this.phoneNo = phoneNo;
		this.email = email;
		this.CNIC = CNIC;
		this.gender = gender;
		this.emergencyContact = emergencyContact;
		this.address = address;
		this.degrees = degrees;
		this.position = position;
		
		DAL.updateFacultyDetails(this.empID, name, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, degrees, position);
		
		return true;
	}
	
	public Student getStudentAttendance(String rollNo) {
		return Session.getInst().getStudent(rollNo);
	}

}
