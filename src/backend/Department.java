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
public class Department {
    
    protected String name;
    protected ArrayList<Staff> staff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }
    
    public Department(String name, ArrayList<Staff> staff){
        this.name = name;
        this.staff = staff;
    }
    
    ///////////////////////////////////////////////////ADD STAFF//////////////////////////////////////////////////
    public int ifStaffExists(String cnic)
    {
    	int found = 0;
		for(Staff s : this.staff)
		{
			  if(cnic.equals(s.getCNIC()))
			  {
			      found=staff.indexOf(s);
				  break;
			  }
			  
			  else
			  found=-1;
		}
	
		return found;
    }
    
    public boolean addStaff(Staff f)
    {
    	return staff.add(f);
    }
    
    
    //////////////////////////////////////////REMOVE STAFF/////////////////////////////////////////////////////////
    public boolean removestaff(String empID)
    {
    	for(Staff s : staff)
		{
			if(empID.equals(s.getEmpID()))
			{
				this.staff.remove(s);
			    return true;
			}
			    
			else 
				break;
		}
    	
    	return false;
    }
    
   /////////////////////////////////////////////UPDATE STAFF ///////////////////////////////////////////////////////////////
    
    public Staff getStaffMember(int i)
    {
    	return this.staff.get(i);
    }
    
    public void updateStaffMemberToStaff(int i,Staff s)
	{
	     staff.set(i,s);
	}
   
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
