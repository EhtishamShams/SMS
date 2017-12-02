package backend;

import java.util.ArrayList;

public class Transcript {
	
	private ArrayList<Grade> grades = null;

	public Transcript() {
		this.grades = new ArrayList<>();
	}

	public Transcript(ArrayList<Grade> grades) {
		this.grades = grades;
	}
	
	
	public ArrayList<Grade> getGrades() {
		return grades;
	}
	
	public Grade getGrade(String courseCode) {
		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(courseCode))
				return g;
		}
		return null;
	}
	

}
