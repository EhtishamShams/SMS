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
    
    //Helper function for add allotment 
    public Office getOffice(String Oid)
    {
    	
    	for(int i=0 ; i<(this.offices.size());i++)
    	{  
    		if(this.offices.get(i).ID==Oid)
    		{
    			return offices.get(i);
    			
    		}
    		
    	}
		return null;	
    }
    
    //Helper function to for Add Allotment
    public boolean addAllotment(Allotment a)
    {
    	this.allotments.add(a);
    	return true;	
    }
    //helper for Update Allotment
    public Allotment getAllotment(Staff s)
    {
       
    	for(int i=0; i<this.allotments.size();i++)
    	{
    		if(this.allotments.get(i).allotedTo.equals(s))
    		{
    			return this.allotments.get(i);
    		}
    	
    	}
		return null;	
    }
    
    //Helper for Update Allotment 
    public boolean setAllotedOffice(Office a, Allotment b)
    {
    	for(int i=0; i<this.allotments.size();i++)
    	{
    		if(this.allotments.get(i).equals(b))
    		{
    			 this.allotments.get(i).allotedOffice= a;
    			 return true;
    		}
    	
    	}
    	return false;
    }
    //Helper for remove Allotment
    public boolean removeAllotment(Staff s)
    {
    	for(int i=0; i<this.allotments.size();i++)
    	{
    		if(this.allotments.get(i).allotedTo.equals(s))
    		{
    			this.allotments.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
    

    
}


