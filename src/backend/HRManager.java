/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

import dal.DAL;

/**
 *
 * @author Advisor
 */
public class HRManager extends Staff{
    
    public HRManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
    
   ///////////////////////////////////////////////// HIRE SATFF///////////////////////////////////////////////////////////
    protected boolean hireEmployee(String name, String password, Date DOB, String phoneNo, String email, 
    		String CNIC, char gender,String emergencyContact, String address, String empID, Date dateHired)
    {
    	int index=Session.getHrDept().ifStaffExists(empID);
    	if(index!=-1)
    	{
    		Staff temp=new Staff(name,password,DOB,phoneNo,email,CNIC,gender,emergencyContact,address,empID,dateHired);
    		Session.getHrDept().addStaff(temp);
    		//SQL CON/////
			 
	    	    DAL.addStaff( name, password, DOB, phoneNo, email,  CNIC,gender, emergencyContact, address,empID,dateHired);
    		 
    		 return true;
    		
    	}
    	
    	else 
    		return false;
    
    }
    
   //////////////////////////////////////////////FIRE STAFF////////////////////////////////////////////////////////////
    
    protected boolean fireEmployee(String empID)
    {	
    	///SQL CON//
    	deleteAllotment(empID); // (Muaz Functionality)
	    DAL.removeStaff(empID);
    	return Session.getHrDept().removestaff(empID);
    }
    
    ////////////////////////////////////////////////UPDATE STAFF////////////////////////////////////////////////////////
    
    protected boolean updateStaff(String n_name,/* String n_password, */Date n_DOB, String n_phoneNo, 
    		String n_email, String n_CNIC, char n_gender,String n_emergencyContact, String n_address, String empID, 
    		Date n_dateHired)
    {
    	int index=Session.getHrDept().ifStaffExists(empID);
    	if(index!=-1)
    	{
    		Staff s1= Session.getHrDept().getStaffMember(index);
    		s1.updateDetails(n_name,/*n_password,*/n_DOB,n_phoneNo,n_email, n_CNIC,n_gender,n_emergencyContact,n_address, empID,n_dateHired);
    		Session.getHrDept().updateStaffMemberToStaff(index,s1);
    		
    	//SQL CON//	
   	     DAL.updateStaff(n_name,/* n_password,*/ n_DOB, n_phoneNo,n_email,n_CNIC,n_gender,n_emergencyContact, n_address, empID,n_dateHired);
    		return true;
    	}	 
    	else 
    		return false;
    }
       
}