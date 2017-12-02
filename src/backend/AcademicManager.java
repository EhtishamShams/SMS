/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;

import dal.DAL;

import java.sql.*;

/**
 *
 * @author Advisor
 */
public class AcademicManager extends Staff {

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}

	// hamza
	public boolean addCourse(String schoolID, String code, String name, int creditHours, String desc,
			ArrayList<String> preReqs) {

		for (String pCrs : preReqs) {
			if (pCrs.equals(code))
				preReqs.remove(pCrs);
		}

		School s = null;
		for (School sch : Session.getInst().getSchools()) {
			if (sch.getId().equals(schoolID))
				s = sch;
		}

		// Checks if course code is already taken
		if (s.ifCourseExists(code))
			return false;

		ArrayList<Course> crsPreReqs = s.getCoursesFromCode(preReqs);

		// Creating new course object
		Course crs = new Course(code, name, creditHours, desc, crsPreReqs, true);

		// Adds course in school
		return s.addCourse(crs);
	}

	// hamza
	public boolean updateCourse(String schoolID, String code, String name, int creditHours, String desc,
			ArrayList<String> preReqs) {

		for (String pCrs : preReqs) {
			if (pCrs.equals(code))
				preReqs.remove(pCrs);
		}

		School s = null;
		for (School sch : Session.getInst().getSchools()) {
			if (sch.getId().equals(schoolID))
				s = sch;
		}

		// retrieving course object from school
		Course crs = s.getCourse(code);

		// Returns if invalid course id provided
		if (crs == null)
			return false;

		ArrayList<Course> crsPreReqs = s.getCoursesFromCode(preReqs);

		if (!DAL.updateCourseDetails(name, creditHours, desc, crsPreReqs, crs))
			return false;

		// Updating in ArrayList
		crs.updateDetails(name, creditHours, desc, crsPreReqs);
		return true;
	}

	// hamza
	public boolean removeCourse(String schoolID, String code) {

		School s = null;
		for (School sch : Session.getInst().getSchools()) {
			if (sch.getId().equals(schoolID))
				s = sch;
		}

		// retrieving course object from school
		Course crs = s.getCourse(code);

		// Returns if invalid course id provided
		if (crs == null)
			return false;

		return s.removeCourse(crs);

	}

	// hamza
	public boolean removeFaculty(String schoolID, String empID, String repEmpID) {

		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		if (!sch.findFaculty(empID))
			return false;

		// replacement not found in school
		if (repEmpID != null && !sch.findFaculty(repEmpID))
			return false;

		return sch.removeFaculty(empID, repEmpID);

	}

	// hamza
	public boolean registerStudent(String schoolID, String name, Date DOB, String phone, String email, String CNIC,
			char gender, String eCont, String address, String fCNIC, String fName) {

		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		if (!sch.validateStudent(fCNIC))
			return false;

		Student std = new Student(name, null, DOB, phone, email, CNIC, gender, eCont, address, null, fCNIC, fName, 0, 0,
				0, null);

		return sch.addStudent(std);

	}

	// hamza
	public boolean updateStudent(String schoolID, String rollNo, String name, Date DOB, String phone, String email,
			String CNIC, char gender, String eCont, String address, String fCNIC, String fName) {

		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);

		if (std == null)
			return false;

		if (!sch.validateUpdateStudent(CNIC, std))
			return false;

		if (!DAL.updateStudentDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName, std))
			return false;

		std.updateDetails(name, DOB, phone, email, CNIC, gender, eCont, address, fCNIC, fName);
		return true;
	}

	// hamza
	public boolean removeStudent(String rollNo, String schoolID) {

		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);

		if (std == null)
			return false;

		return sch.removeStudent(std);
	}

}
