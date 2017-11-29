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
public class HRManager extends Staff {

	public HRManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}

	// add allotment functionality
	boolean addAllotment(String oid, String eid) {
		AcademicInstitution k = Session.getInst();
		HRDepartment d= Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
		boolean check = false;
		Office a = d.getOffice(oid);

		Allotment temp = new Allotment(a, s);

		// check=addAllotmentDB(oid,s.empID);
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
		HRDepartment d= Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			Office a = d.getOffice(id);
			Allotment temp = d.getAllotment(s);
			// check=updateAllotmentDB(id, s.empID);
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
		HRDepartment d= Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			// check=deleteAllotmentDB(s.empID);
			if (check) {
				d.removeAllotment(s);
			}
			return check;
		}
		return false;
	}

}
