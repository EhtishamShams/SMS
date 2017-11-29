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
public class HRDepartment extends Department{
    
    private ArrayList<Office> offices;
    private ArrayList<Allotment> allotments;

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
    
    
}
