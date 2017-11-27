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
		
		//Updating in database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","abcd");
			conn.setAutoCommit(false);
			
			String query = "Update Course Set CourseName=?, CreditHours=?, Description=? Where CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, name);
			pst.setInt(2, creditHours);
			pst.setString(3, desc);
			pst.setString(4, code);
			pst.executeUpdate();
			
			query = "Delete From CoursePrerequisites Where CourseCode=?";
			pst = conn.prepareStatement(query);
			pst.setString(1, code);
			pst.execute();
			
			query = "Insert into CoursePrerequisites Values(?, ?)";
			pst = conn.prepareStatement(query);
			pst.setString(1, code);
			
			for(Course pReq:preReqs) {
				
				pst.setString(2,  pReq.getCourseCode());
				pst.execute();
			}
			
			conn.commit();
			conn.close();
		}
		catch(Exception e) {
			
			System.out.println(e);
			return false;
		}
		
		//Updating Object
		crs.updateDetails(name, creditHours, desc, preReqs);
		return true;
	}
    
    
}
