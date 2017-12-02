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

	public boolean checkCoursesPassed(ArrayList<Course> cList) {
		boolean passed;

		for (Course c : cList) {
			passed = false;

			for (Grade g : grades) {
				if (g.getCourseSection().getCourse().getCourseCode().equals(c.getCourseCode())
						&& !g.getGrade().equals(LGrade.F)) {
					passed = true;
				}
			}

			if (!passed)
				return false;
		}

		return true;
	}

	public boolean checkCoursePassed(Course course) {

		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(course.getCourseCode())
					&& !g.getGrade().equals(LGrade.F)) {
				return true;
			}
		}

		return false;
	}

	public void addGrade(Grade g) {
		this.grades.add(g);
	}

	public boolean updateGradeSection(CourseSection oldCs, CourseSection newCs) {
		for (Grade g : grades) {
			if (g.getCourseSection().getCourse().getCourseCode().equals(oldCs.getCourse().getCourseCode())
					&& g.getCourseSection().getSectionID() == oldCs.getSectionID() && g.getGrade().equals(LGrade.I)) {
				g.setCourseSection(newCs);
				return true;
			}
		}

		return false;
	}

	public boolean removeGrade(Grade g) {
		for (Grade grade : grades) {
			if (grade.getCourseSection().getCourse().getCourseCode()
					.equals(g.getCourseSection().getCourse().getCourseCode())
					&& grade.getCourseSection().getSectionID() == g.getCourseSection().getSectionID()
					&& grade.getGrade().equals(g.getGrade())) {
				this.grades.remove(grade);
				return true;
			}
		}

		return false;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}

}
