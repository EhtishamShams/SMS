/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;
import java.util.ArrayList;
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

			check = DAL.addAllotmentDB(oid, s.getEmpID());
			if (check) {
				d.addAllotment(temp);
			}
			return check;
		}
		return false;
	}

	// update allotment functionality

	boolean updateAllotment(String eid, String oid) {
		AcademicInstitution k = Session.getInst();
		HRDepartment d = Session.getHrDept();
		Staff s = k.getStaff(eid);
		if (s != null) {
			boolean check = false;
			Office a = d.getOffice(oid);
			Allotment temp = d.getAllotment(s);
			check = DAL.updateAllotmentDB(oid, s.getEmpID());
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
			check = DAL.deleteAllotmentDB(s.getEmpID());
			if (check) {
				d.removeAllotment(s);
			}
			return check;
		}
		return false;
	}



	//faculty issue fixed. Class:HRmanager!
			public ArrayList<Staff> getUnallotedStaff() {
			HRDepartment a = Session.getHrDept();
			boolean check = false;
			AcademicDepartment b = Session.getAcademicDept();
			AccountsDepartment c = Session.getAccountsDept();
			ArrayList<Staff> abc = new ArrayList<Staff>();
			AcademicInstitution k = Session.getInst();
			ArrayList<Staff> faculty = k.getFacultyMemberList();
			for (int i = 0; i < a.getStaff().size(); i++) {
				for (int j = 0; j < a.getAllotments().size(); j++) {
					if (a.getStaff().get(i).getEmpID().equals(a.getAllotments().get(j).getAllotedTo().getEmpID())) {
						check = true;
					}
				}
				if (!check)
					abc.add(a.getStaff().get(i));
				check = false;
			}
			for (int i = 0; i < b.getStaff().size(); i++) {
				for (int j = 0; j < a.getAllotments().size(); j++) {
					if (b.getStaff().get(i).getEmpID().equals(a.getAllotments().get(j).getAllotedTo().getEmpID())) {
						check = true;
					}
				}
				if (!check)
					abc.add(a.getStaff().get(i));
				check = false;
			}
			for (int i = 0; i < c.getStaff().size(); i++) {
				for (int j = 0; j < a.getAllotments().size(); j++) {
					if (c.getStaff().get(i).getEmpID().equals(a.getAllotments().get(j).getAllotedTo().getEmpID())) {
						check = true;
					}
				}
				if (!check)
					abc.add(a.getStaff().get(i));
				check = false;
			}
			for (int i = 0; i < faculty.size(); i++) {
				for (int j = 0; j < a.getAllotments().size(); j++) {
					if (faculty.get(i).getEmpID().equals(a.getAllotments().get(j).getAllotedTo().getEmpID())) {
						check = true;
					}
				}
				if (!check)
					abc.add(a.getStaff().get(i));
				check = false;
			}
			if (abc.size() == 0) {
				return null;
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
			abc.add(a.getAllotments().get(i).getAllotedTo());
		}

		return abc;
	}

	public ArrayList<Office> getUnallotedOffice() {

		boolean check = false;
		ArrayList<Office> abc = new ArrayList<Office>();
		HRDepartment a = Session.getHrDept();

		for (int i = 0; i < a.getOffices().size(); i++) {
			for (int j = 0; j < a.getAllotments().size(); j++) {
				if (a.getOffices().get(i).equals(a.getAllotments().get(j).getAllotedOffice())) {
					check = true;
				}
				if (!check) {
					abc.add(a.getOffices().get(i));
				}
				check = false;
			}

		}
		if (abc.size() == 0) {
			return null;
		} else
			return abc;
	}

	///////////////////////////////////////////////// HIRE
	///////////////////////////////////////////////// SATFF///////////////////////////////////////////////////////////





	public boolean addOffice(String officeID) {
		HRDepartment dept = Session.getHrDept();
		if (!dept.ifOfficeExists(officeID)) {
			Office o = new Office(officeID);
			return dept.addOffice(o);
		}
		return false;
	}

	 protected boolean hireEmployee(Enum<LDepartment> dname,String name, String password, Date DOB, String phoneNo, String email, 
	    		String CNIC, char gender,String emergencyContact, String address, String empID, Date dateHired)
	    {
	   	    int index=0;
		   	boolean HRindex=Session.getHrDept().checkStaffByCNIC(CNIC);
		    boolean Acdindex=Session.getAcademicDept().checkStaffByCNIC(CNIC);
		    boolean Accindex=Session.getAccountsDept().checkStaffByCNIC(CNIC);
	   	   
		    if(HRindex==false && Acdindex ==false && Accindex ==false) {

		 	    if(dname==LDepartment.A) {
		 	    	index=Session.getAcademicDept().ifStaffExistsByIndex(empID);
		 	    	if(index==-1) {
		    		Staff temp=new Staff(name,password,DOB,phoneNo,email,CNIC,gender,emergencyContact,address,empID,dateHired);
		    		Session.getAcademicDept().addStaff(temp);
		    		//SQL CON/////
			    	    DAL.addStaff( name, password, DOB, phoneNo, email,  CNIC,gender, emergencyContact, address,empID,dateHired);
			    	    DAL.addManager(empID,"AcademicManager", Session.getAcademicDept().getName());
	                 return true;
		 	    	}
		    	}
		 	    
		 	    if(dname==LDepartment.F) {
		 	    	index=Session.getAccountsDept().ifStaffExistsByIndex(empID);
		 	    	if(index==-1) {
		 	    	Staff temp=new Staff(name,password,DOB,phoneNo,email,CNIC,gender,emergencyContact,address,empID,dateHired);
		    		Session.getAccountsDept().addStaff(temp);
		    		//SQL CON/////
			    	    DAL.addStaff( name, password, DOB, phoneNo, email,  CNIC,gender, emergencyContact, address,empID,dateHired);
			    	    DAL.addManager(empID,"FinanceManager", Session.getAccountsDept().getName());
			    	    return true;
		 	    	}
		 	    	
		 	    }
		 	    
		 	    if(dname==LDepartment.HR) {
		 	    	index=Session.getHrDept().ifStaffExistsByIndex(empID);
		 	    	if(index==-1) {
		 	    	Staff temp=new Staff(name,password,DOB,phoneNo,email,CNIC,gender,emergencyContact,address,empID,dateHired);
		    		Session.getHrDept().addStaff(temp);
		    		//SQL CON/////
			    	    DAL.addStaff( name, password, DOB, phoneNo, email,  CNIC,gender, emergencyContact, address,empID,dateHired);
		    		    DAL.addManager(empID,"HRManager", Session.getHrDept().getName());
			    	    return true;
		 	    	}
		 	    }
	    	    
		    }
			return false;
	    
	    }
	 protected boolean fireEmployee(String empID)
	    {	
	    	int HRindex=Session.getHrDept().ifStaffExistsByIndex(empID);
		    int Acdindex=Session.getAcademicDept().ifStaffExistsByIndex(empID);
		    int Accindex=Session.getAccountsDept().ifStaffExistsByIndex(empID);
		    //int index=0;
	         if(HRindex!=-1)
		    	{
		    		///SQL CON//
		        	deleteAllotment(empID); // (Muaz Functionality)
		        	DAL.removeStaff(empID);
		    	    DAL.removeManager(empID);
		        	return Session.getHrDept().removestaff(empID);
		    	}
		    	
		    if(Acdindex !=-1)
		    	{
		    		///SQL CON//
		        	deleteAllotment(empID); // (Muaz Functionality)
		    	    DAL.removeStaff(empID);
		    	    DAL.removeManager(empID);
		        	return Session.getAcademicDept().removestaff(empID);
		    	}
		    	
		    if(Accindex!=-1)
		    	{
		    		///SQL CON//
		        	deleteAllotment(empID); // (Muaz Functionality)
		    	    DAL.removeStaff(empID);
		    	    DAL.removeManager(empID);
		        	return Session.getAcademicDept().removestaff(empID);
		    	}
		    
		    return false;
	    }
	 protected boolean updateStaff(String n_name,/* String n_password, */Date n_DOB, String n_phoneNo, 
	    		String n_email, String n_CNIC, char n_gender,String n_emergencyContact, String n_address, String empID, 
	    		Date n_dateHired)
	    {
	    	
	    	
	    	int HRindex=Session.getHrDept().ifStaffExistsByIndex(empID);
		    int Acdindex=Session.getAcademicDept().ifStaffExistsByIndex(empID);
		    int Accindex=Session.getAccountsDept().ifStaffExistsByIndex(empID);
		    //int index=0;
		    	if(HRindex!=-1)
		    	{
		    		Staff s1= Session.getHrDept().getStaffMember(HRindex);
		    		s1.updateDetails(n_name,/*n_password,*/n_DOB,n_phoneNo,n_email, n_CNIC,n_gender,n_emergencyContact,n_address, empID,n_dateHired);
		    		Session.getHrDept().updateStaffMemberToStaff(HRindex,s1);
		    		
		    	//SQL CON//	
		   	     DAL.updateStaff(n_name,/* n_password,*/ n_DOB, n_phoneNo,n_email,n_CNIC,n_gender,n_emergencyContact, n_address, empID,n_dateHired);
		    	 return true;
		    	}
		    	
		    	else if(Acdindex !=-1)
		    	{Staff s1= Session.getHrDept().getStaffMember(Acdindex);
	    		s1.updateDetails(n_name,/*n_password,*/n_DOB,n_phoneNo,n_email, n_CNIC,n_gender,n_emergencyContact,n_address, empID,n_dateHired);
	    		Session.getAcademicDept().updateStaffMemberToStaff(Acdindex,s1);
	    		
		    	//SQL CON//	
		   	     DAL.updateStaff(n_name,/* n_password,*/ n_DOB, n_phoneNo,n_email,n_CNIC,n_gender,n_emergencyContact, n_address, empID,n_dateHired);
	    		return true;
		    	}
		    	
		    	else if(Accindex!=-1)
		    	{
		    		Staff s1= Session.getAccountsDept().getStaffMember(Accindex);
		    		s1.updateDetails(n_name,/*n_password,*/n_DOB,n_phoneNo,n_email, n_CNIC,n_gender,n_emergencyContact,n_address, empID,n_dateHired);
		    		Session.getHrDept().updateStaffMemberToStaff(Accindex,s1);
		    		
			    	//SQL CON//	
			   	     DAL.updateStaff(n_name,/* n_password,*/ n_DOB, n_phoneNo,n_email,n_CNIC,n_gender,n_emergencyContact, n_address, empID,n_dateHired);
			    		return true;
		   
		    }
	    
	    	else 
	    		return false;
	    }
}
