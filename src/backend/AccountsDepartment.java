/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

import dal.DAL;
import dal.DBAccess;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hamza
 */
public class AccountsDepartment extends Department{
    
    private ArrayList<Pay> pays;
    private ArrayList<Fee> fees;

    public AccountsDepartment(ArrayList<Pay> pays, ArrayList<Fee> fees, String name, ArrayList<Staff> staff) {
        super(name, staff);
        this.pays = pays;
        this.fees = fees;
    }

    public ArrayList<Pay> getPays() {
        return pays;
    }

    public void setPays(ArrayList<Pay> pays) {
        this.pays = pays;
    }

    public ArrayList<Fee> getFees() {
        return fees;
    }

    public void setFees(ArrayList<Fee> fees) {
        this.fees = fees;
    }
    
    public Pay getPay(String empID, Date month) {
    		for (Pay p : pays) {
    			if (p.getStaffMember().getEmpID().equals(empID) && p.getDatePaid().getMonth() == month.getMonth())
    				return p;
    		}
    		return null;
    }
    
    public boolean checkPay(String empID, Date month) {
		for (Pay p : pays) {
			if (p.getStaffMember().getEmpID().equals(empID) && p.getDatePaid().getMonth() == month.getMonth())
				return true;
		}
		return false;
}
    
    public boolean addPay(Pay p) {
		boolean check = Session.getDal().addPay(p);
		if (check)
			pays.add(p);
		return check;
	}
    
    public Fee getFee(String rollNum, String semester) {
    		for (Fee f : fees) {
    			if (f.getStudent().getRollNo().equals(rollNum) && f.getSemester().getSession().equals(semester))
    				return f;
    		}
    		return null;
    }
    
}
