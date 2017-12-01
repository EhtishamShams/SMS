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

	public Semester getSemester() {
		return semester;
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
	
	public boolean checkSeatAvailibility() {
		return (this.maxSeats>this.currSeats);
	}
	
	public ArrayList<Attendance> getStudentAttendance(String rollNo){
		ArrayList<Attendance> attendance = new ArrayList<>();
		
		for(Attendance attd : studentAttendances) {
			if(attd.getStudent().getRollNo().equals(rollNo)) {
				attendance.add(attd);
			}
		}
		
		if(attendance.size()==0)
			return null;
		
		return attendance;
	}
	
	public void removeStudentAttendance(Student student) {
		for(Attendance attd: studentAttendances) {
			if(attd.getStudent().getRollNo().equals(student.getRollNo())){
				studentAttendances.remove(attd);
			}
		}
	}
	
}
