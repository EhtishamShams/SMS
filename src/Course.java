package backend;

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

    public Course(String courseCode, String courseName, int creditHours, String description, ArrayList<Course> prerequisites) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.description = description;
        this.prerequisites = prerequisites;
        this.sections = new ArrayList<>();
    }
    
    public Course(String courseCode, String courseName, int creditHours, String description,
			ArrayList<Course> prerequisites, ArrayList<CourseSection> sections) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.description = description;
		this.prerequisites = prerequisites;
		this.sections = sections;
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
    
    public boolean updateDetails(String courseName, int creditHours, String description, ArrayList<Course> prerequisites) {//, School courseSchool) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.description = description;
        this.prerequisites = prerequisites;
        return true;
    }
    
    public boolean addCourseSection(CourseSection section) {
    		this.sections.add(section);
    		return true;
    }
    
    public boolean ifSectionExists(char secID) {
    	for(CourseSection s: this.sections)
    	{
    		if(s.getSectionID()==secID)
    			return true;
    	}
    	
    	return false;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
    public boolean removeCourseSection(char secID) {
    	for(CourseSection s: this.sections){
    		if(s.getSectionID()==secID) {
    			this.sections.remove(s);
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean updateCourseSection(char secID,FacultyMember f, int max_seats) {
    	for(CourseSection s: this.sections){
    		if(s.getSectionID()==secID) {
    			s.setMaxSeats(max_seats);
    			s.setFaculty(f);
    			return true;
    		}
    	}
    	return false;
    }
    
    /////////////////////////////////////////////////////////////////////////////
 }
    