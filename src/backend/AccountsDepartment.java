/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

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
    
    public Fee getStudentFee(String rollNo, String session) {
    	for(Fee f: fees) {
    		if(f.getStudent().getRollNo().equals(rollNo) && f.getSemester().getSession().equals(session))
    			return f;
    	}
    	
    	return null;
    }
    
    
    public void addFee(Fee f) {
    	this.fees.add(f);
    }
    
    public boolean updateFee(Fee fee) {
    	for(Fee f: fees) {
    		if(f.getStudent().getRollNo().equals(fee.getStudent().getRollNo()) && 
    				f.getSemester().getSession().equals(fee.getSemester().getSession())) {
    			f = fee;
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean removeFee(Fee fee) {
    	for(Fee f : fees) {
    		if(f.getStudent().getRollNo().equals(fee.getStudent().getRollNo()) &&
    				f.getSemester().getSession().equals(fee.getSemester().getSession())) {
    			this.fees.remove(f);
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
}
