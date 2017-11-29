package backend;

import java.util.ArrayList;

public class Transcript {
	
	private ArrayList<Grade> grades;

	public Transcript() {
		this.grades = new ArrayList<>();
	}

	public Transcript(ArrayList<Grade> grades) {
		this.grades = grades;
	}
	
	

	public ArrayList<Grade> getGrades() {
		return grades;
	}
	
	

}
