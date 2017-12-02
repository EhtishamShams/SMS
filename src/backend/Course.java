package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Nouman
 */
public class Course {

	private String courseCode;
	private String courseName;
	private int creditHours;
	private String description;
	private ArrayList<Course> prerequisites;
	private ArrayList<CourseSection> sections;
	private boolean isOffered;

	public Course(String courseCode, String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, boolean isOffered) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		this.sections = new ArrayList<>();
		this.isOffered = isOffered;
	}

	public Course(String courseCode, String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, ArrayList<CourseSection> sections, boolean isOffered) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		this.sections = sections;
		this.isOffered = isOffered;
	}

	public boolean getIsOffered() {
		return isOffered;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public String getDescription() {
		return description;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public ArrayList<CourseSection> getSections() {
		return sections;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public void setIsOffered(boolean isOffered) {
		this.isOffered = isOffered;
	}

	// hamza
	public void updateDetails(String courseName, int creditHours, String description, ArrayList<Course> prerequisites) {// ,
																														// School
																														// courseSchool)
																														// {

		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
	}

	// hamza
	public boolean addCourseSection(CourseSection section) {
		this.sections.add(section);
		return true;
	}

	// hamza
	public boolean ifSectionExists(char secID) {
		for (CourseSection s : this.sections) {
			if (s.getSectionID() == secID)
				return true;
		}

		return false;
	}

	// hamza
	public CourseSection getCourseSection(String session, char secID) {
		for (CourseSection cSec : sections) {
			if (cSec.getSemester().getSession().equals(session) && cSec.getSectionID() == secID)
				return cSec;
		}

		return null;
	}

}
