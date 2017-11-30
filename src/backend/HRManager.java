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
    
    public boolean addOffice(String officeID) {
    		HRDepartment dept = Session.getHrDept(); 
    		if (!dept.ifOfficeExists(officeID)) {
    			Office o = new Office(officeID);
    			return dept.addOffice(o);
    		}
    		return false;
    }
    
}
