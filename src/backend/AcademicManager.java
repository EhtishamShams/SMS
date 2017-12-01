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
    
    public boolean registerStudentInCourse(String schoolID, String rollNo, String courseCode,char secID) {
    	School sch = null;
    	
    	for(School s:Session.getInst().getSchools()) {
			if(s.getId().equals(schoolID))
				sch = s;
		}
    	
    	Student std = sch.getStudent(rollNo);
    	Course c = sch.getCourse(courseCode);
    	
    	if(std!=null && c!=null)
    	{
    		Semester sem = Session.getSem();
    		CourseSection cs = sch.getCourseSection(c, secID,sem);
    		
    		if(cs!=null)
    			return sch.registerStudentInCourse(std, c, cs, sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
    public boolean updateStudentCourseRegistration(String schoolID, String rollNo, String courseCode,char oldID,char newID) {
    	School sch = null;
    	
    	for(School s:Session.getInst().getSchools()) {
			if(s.getId().equals(schoolID))
				sch = s;
		}
    	
    	Student std = sch.getStudent(rollNo);
    	Course c = sch.getCourse(courseCode);
    	
    	if(std!=null && c!=null)
    	{
    		Semester sem = Session.getSem();
    		CourseSection oldCs = sch.getCourseSection(c, oldID,sem);
    		CourseSection newCs = sch.getCourseSection(c, newID,sem);
    		
    		if(oldCs!=null && newCs!=null)
    			return sch.updateStudentCourseRegistration(std, oldCs, newCs,sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
    public boolean removeStudentCourseRegistration(String schoolID, String rollNo, String courseCode,char secID) {
    	School sch = null;
    	
    	for(School s:Session.getInst().getSchools()) {
			if(s.getId().equals(schoolID))
				sch = s;
		}
    	
    	Student std = sch.getStudent(rollNo);
    	Course c = sch.getCourse(courseCode);
    	
    	
    	if(std!=null && c!=null)
    	{
    		Semester sem = Session.getSem();
    		CourseSection cs = sch.getCourseSection(c, secID, sem);
    		
    		if(cs!=null)
    			return sch.removeStudentCourseRegistration(std, cs,sem);
    		else
    			return false;
    	}
    	else
    		return false;
    }
    
    public FacultyMember getFacultyMember(String empID) {
    	return Session.getInst().getFacultyMember(empID);
    }
    
}
