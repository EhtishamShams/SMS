package backend;

public class Grade {
	
	private LGrade grade;
	private CourseSection course;
	
	public Grade(LGrade grade, CourseSection course) {
		this.grade = grade;
		this.course = course;
	}

	public LGrade getGrade() {
		return grade;
	}

	public void setGrade(LGrade grade) {
		this.grade = grade;
	}

	public CourseSection getCourseSection() {
		return course;
	}
	

}
