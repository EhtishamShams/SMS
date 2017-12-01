
package backend;
import dal.DAL;

import java.util.ArrayList;
import java.sql.Date;

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

	// mark attendance functionality
	public boolean markAttendance(School sch, String Ccode, String rollno, char SID, LAttendance atd, Semester sem,
			Date day) {
		Student s = sch.getStudent(rollno);
		Course c = sch.getCourse(Ccode);
		CourseSection cs = c.getCourseSection(sem, SID);
	
		 int key= DAL.getSectionKey(SID,Ccode,sem.getSession());
		Attendance at = new Attendance(atd, day, s, cs);

		boolean check = cs.addAttendance(at);
		if (check) {
			 check=DAL.markAttendanceDB(key,rollno,day,atd);
		}
		return check;
	}

	public ArrayList<CourseSection> getCurrentSemesterCourseSections() {
		ArrayList<CourseSection> sec = new ArrayList<CourseSection>();
		School sch = Session.getSchl();
		sec = sch.getCourseSection(this.empID);
		return sec;
	}


	public boolean addAttendance(CourseSection b, String date) {
		
		Date d = Date.valueOf(date);
        String CID = b.getCourse().getCourseCode();
		int key = DAL.getSectionKey(b.getSectionID(), CID, b.semester.getSession());
		School sc = Session.getSchl();

		for (int i = 0; i < sc.getStudents().size(); i++) {
			for (int j = 0; j < sc.getStudents().get(i).getStudiedCourses().size(); j++) {

				if (sc.getStudents().get(i).getStudiedCourses().get(j).equals(b)) {
					Attendance a = new Attendance(LAttendance.P, d, sc.getStudents().get(i), b);
					b.addAtd(a);
					DAL.addAttendanceDB(LAttendance.P, sc.getStudents().get(i).getRollNo(), key, d);
				}
			}

		}

		return true;
	}
}