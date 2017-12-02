package backend;

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

	public Course getCourse() {
		return course;
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
	
	
	
	 
}
