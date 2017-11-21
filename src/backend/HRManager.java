/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

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
    public boolean hireEmployee(Department d,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired)
    {
    	int index=d.ifStaffExists(CNIC);
    	if(index!=-1)
    	{
    		Staff temp=new Staff(name,password,DOB,phoneNo,email,CNIC,gender,emergencyContact,address,empID,dateHired);
    		return d.addStaff(temp);
    		
    	}
    	
    	else 
    		return false;
    
    }
    
   //////////////////////////////////////////////FIRE STAFF////////////////////////////////////////////////////////////
    
    public boolean fireEmployee(Department d, String empID)
    {
    	return d.removestaff(empID);
    }
    
    ////////////////////////////////////////////////UPDATE STAFF////////////////////////////////////////////////////////
    
    public boolean updateStaff(Department d,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired)
    {
    	int index=d.ifStaffExists(CNIC);
    	if(index!=-1)
    	{
    		Staff s1= d.getStaffMember(index);
    		s1.updateDetails(name,password,DOB,phoneNo,email, CNIC,gender,emergencyContact,address,empID,dateHired);
    		d.updateStaffMemberToStaff(index,s1);
    		return true;
    	}
    	
    	else 
    		return false;
    }
    
   
    
}
