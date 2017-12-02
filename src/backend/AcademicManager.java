/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;


import dal.DAL;
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
    
    // function for updating school name 
	boolean updateSchool(String id , String updatedName , AcademicInstitution a)
	{
		boolean check= false;
		check=a.updateSchool(id,updatedName);
			
			if(check)
			{
				 DAL.updateSchoolDB(id,name);
				return true;
			}
		return check;
	}
    //function for adding another school in the institution 
	
	boolean addSchool(String id, String name,AcademicInstitution a)
	{
		return a.Validate(id, name);
	}
	
    
}
