/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Advisor
 */
public class AcademicManager extends Staff{

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
    
    public boolean registerStudentInCourse(School s, String rollNo, String courseCode,char secID, Semester sem) {
    	
    	Student std = s.getStudent(rollNo);
    	Course c = s.getCourse(courseCode);
    	
    	if(std!=null && c!=null)
    	{
    		CourseSection cs = s.getCourseSection(c, secID,sem);
    		
    		if(cs!=null)
    			return s.registerStudentInCourse(std, c, cs, sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
    public boolean updateStudentCourseRegistration(School s, String rollNo, String courseCode,char oldID,char newID,  Semester sem) {
    	
    	Student std = s.getStudent(rollNo);
    	Course c = s.getCourse(courseCode);
    	
    	if(std!=null && c!=null)
    	{
    		CourseSection oldCs = s.getCourseSection(c, oldID,sem);
    		CourseSection newCs = s.getCourseSection(c, newID,sem);
    		
    		if(oldCs!=null && newCs!=null)
    			return s.updateStudentCourseRegistration(std, oldCs, newCs,sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
    public boolean removeStudentCourseRegistration(School s, String rollNo, String courseCode,char secID, Semester sem) {
    	Student std = s.getStudent(rollNo);
    	Course c = s.getCourse(courseCode);
    	
    	if(std!=null && c!=null)
    	{
    		CourseSection cs = s.getCourseSection(c, secID,sem);
    		
    		if(cs!=null)
    			return s.removeStudentCourseRegistration(std, cs,sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
}
