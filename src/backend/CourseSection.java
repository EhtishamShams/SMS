package backend;

import java.sql.Date;
import java.util.ArrayList;

public class CourseSection {
	
	private char sectionID;
	private int maxSeats;
	private int currSeats;
	private FacultyMember sectionTeacher = null;
	private Semester semester = null;
	private Course course = null;
	private ArrayList<Attendance> studentAttendances = null;
	 
	public CourseSection(char sectionID, int maxSeats, int currSeats) {
		this.sectionID = sectionID;
		this.maxSeats = maxSeats;
		this.currSeats = 0;
		this.studentAttendances = new ArrayList<Attendance>();
	}
	
	public CourseSection(char sectionID, int maxSeats, int currSeats, FacultyMember sectionTeacher, Semester semester,
			Course course, ArrayList<Attendance> studentAttendances) {
		super();
		this.sectionID = sectionID;
		this.maxSeats = maxSeats;
		this.currSeats = currSeats;
		this.setSectionTeacher(sectionTeacher);
		this.semester = semester;
		this.course = course;
		this.studentAttendances = studentAttendances;
	}

	
	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public int getCurrSeats() {
		return currSeats;
	}

	public void setCurrSeats(int currSeats) {
		this.currSeats = currSeats;
	}

	public char getSectionID() {
		return sectionID;
	}

	public ArrayList<Attendance> getStudentAttendance() {
		return studentAttendances;
	}

	public boolean incrementCurrSeats() {
		if(currSeats!=maxSeats)
		{
			currSeats++;
			return true;
		}
		else
			return false;
			
	}
    public void addAtd(Attendance a)
    {
    	this.studentAttendances.add(a);
    }
	
	public boolean decrementCurrSeats() {
		if(currSeats!=0)
		{
			currSeats--;
			return true;
		}
		else
			return false;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void removeStudentAttendance(Student student) {
		for(Attendance attd: studentAttendances) {
			if(attd.getStudent().getRollNo().equals(student.getRollNo())){
				studentAttendances.remove(attd);
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////
	
	 public void setFaculty(FacultyMember f) {
		 sectionTeacher=f;
	 }
	 
	 public FacultyMember getFaculty() {
		 return sectionTeacher;
	 }
	 
	 
	 
	//helper for mark attendance
	public boolean addAttendance(Attendance a)
	{
		this.studentAttendances.add(a);
		return true;
	}
	 
	public ArrayList<Attendance>getAttendance(Date day)
	{
		ArrayList<Attendance> atd= new ArrayList<Attendance>();
		
		for(int i=0;i<this.studentAttendances.size();i++)
		{
			if(studentAttendances.get(i).Day.equals(day))
			{
				atd.add(studentAttendances.get(i));
			}
				
		}
		return atd;
	}

	public FacultyMember getSectionTeacher() {
		return sectionTeacher;
	}

	public void setSectionTeacher(FacultyMember sectionTeacher) {
		this.sectionTeacher = sectionTeacher;
	}
}
