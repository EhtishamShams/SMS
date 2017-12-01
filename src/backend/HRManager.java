/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Date;
import dal.DAL;

/**
 *
 * @author Advisor
 */
public class HRManager extends Staff {

	public HRManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}

	// add allotment functionality
	boolean addAllotment(String oid, String eid) {
		AcademicInstitution k = Session.getInst();
		HRDepartment d = Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			Office a = d.getOffice(oid);

			Allotment temp = new Allotment(a, s);

			check = DAL.addAllotmentDB(oid, s.empID);
			if (check) {
				d.addAllotment(temp);
			}
			return check;
		}
		return false;
	}

	// update allotment functionality

	boolean updateAllotment(String eid, String id) {
		AcademicInstitution k = Session.getInst();
		HRDepartment d = Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			Office a = d.getOffice(id);
			Allotment temp = d.getAllotment(s);
			check = DAL.updateAllotmentDB(id, s.empID);
			if (check) {
				d.setAllotedOffice(a, temp);
			}
			return check;
		}
		return false;
	}

	// remove Allotment functionality
	boolean deleteAllotment(String eid) {
		AcademicInstitution k = Session.getInst();
		HRDepartment d = Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			check = DAL.deleteAllotmentDB(s.empID);
			if (check) {
				d.removeAllotment(s);
			}
			return check;
		}
		return false;
	}

	public ArrayList<Staff> getUnallotedStaff() {
		HRDepartment a = Session.getHrDept();
		boolean check = false;
		AcademicDepartment b = Session.getAcademicDept();
		AccountsDepartment c = Session.getAccountDept();
		ArrayList<Staff> abc = null;
		for (int i = 0; i < a.getStaff().size(); i++) {
			if (i == 0) {
				abc = new ArrayList<Staff>();
				check = true;
			}
			if (a.getAllotments().get(i).allotedTo.equals(a.staff.get(i))) {
				abc.add(a.staff.get(i));
			}
		}
		for (int i = 0; i < b.getStaff().size(); i++) {
			if (i == 0 && check == false) {
				abc = new ArrayList<Staff>();
				check = true;
			}

			if (a.getAllotments().get(i).allotedTo.equals(b.staff.get(i))) {
				abc.add(b.staff.get(i));
			}
		}
		for (int i = 0; i < a.getStaff().size(); i++) {
			if (i == 0 && check == false) {
				abc = new ArrayList<Staff>();
				check = true;
			}
			if (a.getAllotments().get(i).allotedTo.equals(c.staff.get(i))) {
				abc.add(c.staff.get(i));
			}
		}

		return abc;
	}

	public ArrayList<Staff> getAllotedStaff() {

		HRDepartment a = Session.getHrDept();

		ArrayList<Staff> abc = null;

		for (int i = 0; i < a.getAllotments().size(); i++) {
			if (i == 0) {
				abc = new ArrayList<Staff>();
			}
			abc.add(a.getAllotments().get(i).allotedTo);
		}

		return abc;
	}

	public ArrayList<Office> getUnallotedOffice() {

		boolean check=false;
		ArrayList<Office> abc = new ArrayList<Office>();
		HRDepartment a = Session.getHrDept();
		
		for(int i=0 ; i<a.getOffices().size();i++)
		{
			for(int j=0; j<a.getAllotments().size();j++)
			{
			    if(a.getOffices().get(i).equals(a.getAllotments().get(j)))
			    {
			    	check= true;
			    }
			    if(!check)
			    {
			    	abc.add(a.getOffices().get(i));
			    }
			    check=false;
			}
			
		}
		if(abc.size()==0)
		{
			return null;
		}
		else
			return abc;
	}

}
