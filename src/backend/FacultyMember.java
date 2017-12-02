
package backend;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Ehtisham
 *
 */

public class FacultyMember extends Staff {
	
	private ArrayList<String> degrees = null;
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
	
	public boolean updateGrade(String rollNum, String grade, String courseCode, String secID, String semester) {
		Student stu = Session.getInst().getStudent(rollNum);
		Grade g = stu.getCourseGrade(courseCode);
		LGrade oldVal = g.getGrade();
		g.setGrade(LGrade.valueOf(grade));
		boolean check = Session.getDal().updateGrade(g,stu.getRollNo());
		if (!check)
			g.setGrade(oldVal);
		return check;
		
		
	}
	

}
