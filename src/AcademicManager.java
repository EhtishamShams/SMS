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
public class AcademicManager extends Staff{

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}
	
	////////////////////////////////ADD FACULTY/////////////////////////////////////////////////////////
 boolean RegisterFaculty(String schoolid,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, Date dateHired, ArrayList<String> degrees,
			String position,String EmpID)
	{
	 	
	    int index=Session.getHrDept().ifStaffExists(EmpID);
	    if(index!=-1) {

					 index=Session.getInst().getSchool(schoolid).ifFacultyExists(EmpID);
			    	if(index!=-1)
			    	{
			    		Staff stf = new Staff(name,password,DOB, phoneNo, email,CNIC, gender, emergencyContact, address,EmpID,dateHired);
			    		FacultyMember temp=new FacultyMember(name,password,DOB,phoneNo,email,CNIC,gender, emergencyContact, address, EmpID,dateHired,degrees,position);
			    		////SQL CONN/////////////////
			    	    DAL.addFaculty(Session.getSchl(),name, password, DOB,phoneNo, email, CNIC, gender,emergencyContact,address, EmpID, dateHired,  degrees,position);   
			    	    
			    	    Session.getInst().getSchool(schoolid).addFacultyMember(temp);
			    	    Session.getHrDept().addStaff(stf);			    	   
			    	    return true;
			    	}
	    }
    	
		return false;

	}
	
   ////////////////////////////////ADD SECTION//////////////////////////////////////////////////////////// 
  protected boolean addSection(String schoolid,String c_code,String EmpID,char sID)
   {
	   int index=0; boolean secIndex=false; boolean add=false;
	   ArrayList<Attendance> attendances=new ArrayList<Attendance>();
	   index=Session.getInst().getSchool(schoolid).courseExists(c_code);
	   
	   FacultyMember f= Session.getSchl().getFacultyfromList(EmpID);
	   
	   
	   
	   if(index !=-1)
	   {
		  Course tempcourse=Session.getSchl().getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(sID); 
		  if(secIndex==false)
			  {
			  if(Session.getSchl().facultyExists(f)==true) {
			  
			    CourseSection cs=new CourseSection(sID,50,0,f,Session.getSem(),tempcourse,attendances);
			  	tempcourse.addCourseSection(cs);
			  	
			  	////SQL CONN/////////////////
	    	     DAL.addSection(sID, 50, 0, f,Session.getSem(),tempcourse);
	    	     
	    	     Session.getInst().getSchool(schoolid).updateCourseToCourses(index,tempcourse);
			  	add=true;
			  }
			  }
		  else
		  {
		//	  System.out.println("Section Already Exists");
			  add=false;
		  }
		  
	   }
	   
	  /* else
	   {
		   System.out.println("Course Doesnot Exist");
	   }*/
	   
	  return add; 
   }
   
   //////////////////////////////////////REMOVE SECTION/////////////////////////////////////////////////////////
   protected boolean removeSection(String schoolid, String c_code , char sID)
   {
	   int index=0; boolean secIndex=false; boolean remove=false;
	   index=Session.getInst().getSchool(schoolid).courseExists(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=Session.getSchl().getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(sID); 
		  if(secIndex==true)
			  {
			  
			  	tempcourse.removeCourseSection(sID);
			  	Session.getSchl().updateCourseToCourses(index,tempcourse);
			  	
			  	//SQL CON/////
			  	
			  
	    	     DAL.removeSection(Session.getSchl(), c_code ,sID,Session.getSem());
	    	     
	    	     
			  	remove=true;
			  }
		  else
		  {
			//  System.out.println("Section Doesnot Exist");
			  remove=false;
		  }
	   }
		  
	 /* else
		  {
		  System.out.println("Course Doesnot Exist");
		  }*/
	  
	   
	  return remove; 
   }
 
 ////////////////////////////////////UPDATE SECTION///////////////////////////////////////
   protected boolean updateSection(String schoolid,String c_code, char secID, String EmpID, int maxs)
   {
	   
	   int index=0; boolean secIndex=false; boolean update=false;
	   
	   FacultyMember nf=Session.getInst().getSchool(schoolid).getFacultyfromList(EmpID);
	   index=Session.getSchl().courseExists(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=Session.getSchl().getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(secID); 
		  if(secIndex==true)
			  {
				  if(Session.getSchl().facultyExists(nf)==true) {
				  	tempcourse.updateCourseSection(secID,nf,maxs);
				  	Session.getSchl().updateCourseToCourses(index,tempcourse);
				  	
				  	////SQL CONN/////////////////
				  	
		    	     DAL.updateSection(c_code,secID,nf,maxs,Session.getSem());

				  	update=true;
				  }
				  else 
					  update=false;
			  }
		  else
		  {
			  //System.out.println("Section Doesnot Exist");
			  update=false;
		  }
	   }
		  
	 /*else
		  {
		  System.out.println("Course Doesnot Exist");
		  }*/
	  
	   
	  return update; 
   }
   ////////////////////////////////////////////////////////////////////////////////////////
}
