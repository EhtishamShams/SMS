/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;



/**
 *
 * @author Advisor
 */
public class AcademicManager extends Staff{

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
    
	public boolean addCourse(School s, String code, String name, int creditHours, String desc, ArrayList<Course> preReqs) {
		
		//Checks if course code is already taken
		if(s.ifCourseExists(code))
			return false;
		
		//Creating new course object
		Course crs = new Course(code, name, creditHours, desc, preReqs);
		
		//Adds course in school
		return s.addCourse(crs);
	}
	
	public boolean updateCourse(School s, String code, String name, int creditHours, String desc, ArrayList<Course> preReqs) {
		
		//retrieving course object from school
		Course crs = s.getCourse(code);
		
		//Returns if invalid course id provided
		if(crs == null)
			return false;
		
		//Updating
		return crs.updateDetails(name, creditHours, desc, preReqs);
	}
    
	public boolean removeCourse(School s, String code) {
		
		//retrieving course object from school
		Course crs = s.getCourse(code);
		
		//Returns if invalid course id provided
		if(crs == null)
			return false;
		
		return s.removeCourse(crs);
		
	}
    
	public boolean removeFaculty(School sch, String empID, String repEmpID) {
		
		if(!sch.findFaculty(empID))
			return false;
		
		if(!sch.findFaculty(repEmpID))
			return false;
		
		return sch.removeFaculty(empID, repEmpID);
		
	}
	
	public boolean registerStudent(School sch, String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		if(!sch.validateStudent(fCNIC))
			return false;
		
		Student std = new Student(name, null, DOB, phone, email, CNIC, gender, eCont, address, null, fCNIC, fName, 0, 0, 0, null);
		
		return sch.addStudent(std);
		
		
	}
	
	public boolean updateStudent(School sch, String rollNo, String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		Student std = sch.getStudent(rollNo);
		
		if(std==null)
			return false;
		
		if(!sch.validateUpdateStudent(CNIC, std))
			return false;
		
		return std.updateDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName);
	}
	
	public boolean removeStudent(String rollNo, School sch) {
		
		
		
	}
}
