/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dal.DBAccess;

/**
 *
 * @author hamza
 */
public class HRDepartment extends Department{
    
    private ArrayList<Office> offices = null;
    private ArrayList<Allotment> allotments = null;

    public HRDepartment(ArrayList<Office> offices, ArrayList<Allotment> allotments, String name, ArrayList<Staff> staff) {
        super(name, staff);
        this.offices = offices;
        this.allotments = allotments;
    }

    public ArrayList<Office> getOffices() {
        return offices;
    }

    public void setOffices(ArrayList<Office> offices) {
        this.offices = offices;
    }

    public ArrayList<Allotment> getAllotments() {
        return allotments;
    }

    public void setAllotments(ArrayList<Allotment> allotments) {
        this.allotments = allotments;
    }
    
    public boolean ifOfficeExists(String officeID) {
    		for (Office o : offices) {
    			if (o.getID().equals(officeID))
    				return true;
    		}
    		return false;
    }
    
    public boolean addOffice(Office o) {
    		boolean check = Session.getDal().addOffice(o);
    		if (check)
    			offices.add(o);
    		return check;
    }
    
}
