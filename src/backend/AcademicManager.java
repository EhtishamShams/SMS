/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Date;

import dal.DAL;

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
    
	public boolean addCourse(String schoolID, String code, String name, int creditHours, String desc, ArrayList<Course> preReqs) {
		
		School s = null;
		for(School sch:Session.getInst().getSchools()) {
			if(sch.getId()==schoolID)
				s = sch;
		}
		
		//Checks if course code is already taken
		if(s.ifCourseExists(code))
			return false;
		
		//Creating new course object
		Course crs = new Course(code, name, creditHours, desc, preReqs);
		
		//Adds course in school
		return s.addCourse(crs);
	}
	
	public boolean updateCourse(String schoolID, String code, String name, int creditHours, String desc, ArrayList<Course> preReqs) {
		
		School s = null;
		for(School sch:Session.getInst().getSchools()) {
			if(sch.getId()==schoolID)
				s = sch;
		}
		
		//retrieving course object from school
		Course crs = s.getCourse(code);
		
		//Returns if invalid course id provided
		if(crs == null)
			return false;
		
		if(!DAL.updateCourseDetails(name, creditHours, desc, preReqs, crs))
			return false;
		
		//Updating in ArrayList
		crs.updateDetails(name, creditHours, desc, preReqs);
		return true;
	}
    
	public boolean removeCourse(String schoolID, String code) {
		
		School s = null;
		for(School sch:Session.getInst().getSchools()) {
			if(sch.getId()==schoolID)
				s = sch;
		}
		
		//retrieving course object from school
		Course crs = s.getCourse(code);
		
		//Returns if invalid course id provided
		if(crs == null)
			return false;
		
		return s.removeCourse(crs);
		
	}
    
	public boolean removeFaculty(String schoolID, String empID, String repEmpID) {
		
		School sch = null;
		for(School s:Session.getInst().getSchools()) {
			if(s.getId()==schoolID)
				sch = s;
		}
		
		if(!sch.findFaculty(empID))
			return false;
		
		if(!sch.findFaculty(repEmpID))
			return false;
		
		return sch.removeFaculty(empID, repEmpID);
		
	}
	
	public boolean registerStudent(String schoolID, String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		School sch = null;
		for(School s:Session.getInst().getSchools()) {
			if(s.getId()==schoolID)
				sch = s;
		}
		
		if(!sch.validateStudent(fCNIC))
			return false;
		
		Student std = new Student(name, null, DOB, phone, email, CNIC, gender, eCont, address, null, fCNIC, fName, 0, 0, 0, null);
		
		return sch.addStudent(std);
		
		
	}
	
	public boolean updateStudent(String schoolID, String rollNo, String name, Date DOB, String phone, String email, String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {
		
		School sch = null;
		for(School s:Session.getInst().getSchools()) {
			if(s.getId()==schoolID)
				sch = s;
		}
		
		Student std = sch.getStudent(rollNo);
		
		if(std==null)
			return false;
		
		if(!sch.validateUpdateStudent(CNIC, std))
			return false;
		
		if(!DAL.updateStudentDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName, std))
			return false;
		
		std.updateDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName);
		return true;
	}
	
	public boolean removeStudent(String rollNo, String schoolID) {
		
		School sch = null;
		for(School s:Session.getInst().getSchools()) {
			if(s.getId()==schoolID)
				sch = s;
		}
		
		Student std = sch.getStudent(rollNo);
		
		if(std==null)
			return false;
		
		return sch.removeStudent(std);
	}
	
}
