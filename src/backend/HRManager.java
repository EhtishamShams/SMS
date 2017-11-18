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
    
   //add allotment functionality
    boolean addAllotment(String oid, Staff s, HRDepartment d)
    {
    	Office a =d.getOffice(oid);
    	Allotment temp= new Allotment(a,s);    	
    	boolean check= d.addAllotment(temp);
    	return check;
    }
    
    //update allotment functionality
    
    boolean updateAllotment(Staff s, String id, HRDepartment d)
    {
    	Office a =d.getOffice(id);
    	Allotment temp = d.getAllotment(s);    	
    	boolean check=d.setAllotedOffice(a, temp);
    	return check;
    }
    
    //remove Allotment functionality
    boolean deleteAllotment(Staff s, HRDepartment d)
    {
    	
    	boolean check =d.removeAllotment(s);
    	return check;
    }
}
