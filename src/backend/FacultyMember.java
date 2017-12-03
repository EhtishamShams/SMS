
package backend;

import dal.DAL;

import java.sql.Date;
import java.util.ArrayList;

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

	public boolean updateDetails(String name, Date DOB, String phoneNo, String email, String CNIC, char gender,
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

		DAL.updateFacultyDetails(this.empID, name, DOB, phoneNo, email, CNIC, gender, emergencyContact, address,
				degrees, position);

		return true;
	}

	public Student getStudentAttendance(String rollNo) {
		return Session.getInst().getStudent(rollNo);
	}

	// mark attendance functionality
	public boolean markAttendance(String rollno, LAttendance atd, Date day, CourseSection cs) {
		Semester sem = Session.getSem();
		School sch = Session.getSchl();
		Student s = sch.getStudent(rollno);

		int key = DAL.getSectionKey(cs.getSectionID(), cs.getCourse().getCourseCode(), sem.getSession());
		Attendance at = new Attendance(atd, day, s);

		boolean check = cs.addAttendance(at);
		if (check) {
			check = DAL.markAttendanceDB(key, rollno, day, atd);
		}
		return check;
	}

	public ArrayList<CourseSection> getCurrentSemesterCourseSections() {
		ArrayList<CourseSection> sec;
		School sch = Session.getSchl();
		sec = sch.getFacultyCourseSections(this.empID);
		return sec;
	}

	public boolean updateGrade(String rollNum, String grade, String courseCode, String secID, String semester) {
		Student stu = Session.getInst().getStudent(rollNum);
		Grade g = stu.getCourseGrade(courseCode);
		LGrade oldVal = g.getGrade();
		g.setGrade(LGrade.valueOf(grade));
		boolean check = Session.getDal().updateGrade(g, stu.getRollNo());
		if (!check)
			g.setGrade(oldVal);
		return check;

	}

	public boolean addAttendance(CourseSection b, Date d) {

		String CID = b.getCourse().getCourseCode();
		int key = DAL.getSectionKey(b.getSectionID(), CID, b.getSemester().getSession());
		School sc = Session.getSchl();

		for (int i = 0; i < sc.getStudents().size(); i++) {
			for (int j = 0; j < sc.getStudents().get(i).getStudiedCourses().size(); j++) {

				if (sc.getStudents().get(i).getStudiedCourses().get(j).equals(b)) {
					Attendance a = new Attendance(LAttendance.P, d, sc.getStudents().get(i));
					b.addAtd(a);
					DAL.addAttendanceDB(LAttendance.P, sc.getStudents().get(i).getRollNo(), key, d);
				}
			}

		}

		return true;
	}

	public ArrayList<Date> extractDate(CourseSection a) {
		ArrayList<Date> abc = new ArrayList<Date>();

		for (int i = 0; i < a.getStudentAttendance().size(); i++) {
			if (abc.contains(a.getStudentAttendance().get(i).getDay())) {

			} else {
				abc.add(a.getStudentAttendance().get(i).getDay());
			}

		}

		if (abc.size() == 0) {
			return null;
		} else
			return abc;
	}

	public ArrayList<Attendance> getAttendanceByDate(CourseSection a, Date d) {
		ArrayList<Attendance> abc = new ArrayList<Attendance>();

		for (int i = 0; i < a.getStudentAttendance().size(); i++) {
			if (a.getStudentAttendance().get(i).getDay().equals(d)) {
				abc.add(a.getStudentAttendance().get(i));
			}
		}
		if (abc.size() == 0) {
			return null;
		} else
			return abc;
	}

	public void addDegree(String degree) {
		this.degrees.add(degree);
	}

}
