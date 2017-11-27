/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Date;



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
    
    
}
