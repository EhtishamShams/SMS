
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
	public boolean markAttendance(  String rollno,  LAttendance atd, Date day, CourseSection cs) {
		Semester sem= Session.getSem();
		School sch= Session.getSchl();
		Student s = sch.getStudent(rollno);
		
	
		 int key= DAL.getSectionKey(cs.getSectionID(),cs.getCourse().getCourseCode(),sem.getSession());
		Attendance at = new Attendance(atd, day, s, cs);

		boolean check = cs.addAttendance(at);
		if (check) {
			 check=DAL.markAttendanceDB(key,rollno,day,atd);
		}
		return check;
	}

	public ArrayList<CourseSection> getCurrentSemesterCourseSections() {
		ArrayList<CourseSection> sec;
		School sch = Session.getSchl();
		sec = sch.getCourseSection(this.empID);
		return sec;
	}


	public boolean addAttendance(CourseSection b, Date d) {
		
		
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
	
	public ArrayList<Date> extractDate(CourseSection a)
	{
		ArrayList<Date> abc = new ArrayList<Date>();
		
		for(int i =0; i< a.getStudentAttendance().size();i++)
		{
			  if(abc.contains(a.getStudentAttendance().get(i).Day))
			  {
				  
			  }
			  else
			  {
				  abc.add(a.getStudentAttendance().get(i).Day);
			  }
			
		}
		
		
		if(abc.size()==0)
		{
			return null;
		}
		else
			return abc;
	}
	
	public ArrayList<Attendance> getAttendanceByDate(CourseSection a, Date d)
	{
		ArrayList<Attendance> abc = new ArrayList<Attendance>();
		
		for(int i =0; i< a.getStudentAttendance().size();i++)
		{
			if(a.getStudentAttendance().get(i).Day.equals(d))
			{
				abc.add(a.getStudentAttendance().get(i));
			}
		}
		if(abc.size()==0)
		{
			return null;
		}
		else
			return abc;
	}
}