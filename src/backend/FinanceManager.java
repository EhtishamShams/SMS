/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Advisor
 */
public class FinanceManager extends Staff{

	public FinanceManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
	
    public boolean payStaff(String empID, String datePaid, String payMonth, double amount) {
    		AccountsDepartment dept = Session.getAccountsDept();
    		
    		if (!dept.checkPay(empID, Date.valueOf(payMonth))) {
        		Staff s = Session.getInst().getStaff(empID);
    			Pay p = new Pay(amount, Date.valueOf(datePaid), s);
    			return dept.addPay(p);
    		}
    		return false;
    }
    
    
    public boolean acceptFee(String rollNum, String datePaid, String semester) {
    		Fee f = Session.getAccountsDept().getFee(rollNum, semester);
    		Date oldDate = f.getDatePaid();
    		f.setDatePaid(Date.valueOf(datePaid));
    		boolean check = Session.getDal().updateFee(f);
    		if (!check)
    			f.setDatePaid(oldDate);
    		return check;
    }
    
    
}
