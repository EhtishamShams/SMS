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
	
	public boolean checkCoursesPassed(ArrayList<Course> cList) {
		boolean passed;
		
		for(Course c: cList) {
			passed = false;
			
			for(Grade g: grades) {
				if(c==g.getCourseSection().getCourse() && !g.getGrade().equals(LGrade.F))
				{
					passed = true;
				}
			}
			
			if(!passed)
				return false;
			
		}
		
		return true;
		
	}
	
	public void addGrade(Grade g) {
		this.grades.add(g);
	}
	
	public boolean updateGradeSection(CourseSection oldCs, CourseSection newCs) {
		for(Grade g: grades) {
			if(g.getCourseSection()==oldCs && g.getGrade().equals(LGrade.I)) {
				g.setCourseSection(newCs);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeGrade(Grade g) {
		if(this.grades.contains(g)) {
			this.grades.remove(g);
			return true;
		}
		else
			return false;
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