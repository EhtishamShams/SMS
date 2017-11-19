package backend;

import java.util.ArrayList;

public class CourseSection {
	
	private char sectionID;
	private int maxSeats;
	private int currSeats;
	FacultyMember sectionTeacher;
	Semester semester;
	Course course;
	private ArrayList<Attendance> studentAttendances;
	 
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
		this.sectionTeacher = sectionTeacher;
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
	
	public boolean decrementCurrSeats() {
		if(currSeats!=0)
		{
			currSeats--;
			return true;
		}
		else
			return false;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	 public void setFaculty(FacultyMember f) {
		 sectionTeacher=f;
	 }
	 
	 public FacultyMember getFaculty() {
		 return sectionTeacher;
	 }
	 
	 /////////////////////////////////////////////////////////////////////////////////////
	 
}
