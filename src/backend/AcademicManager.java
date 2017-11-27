/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Date;

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
	

	public boolean RegisterFaculty(School s,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, Date dateHired, ArrayList<String> degrees,
			String position)
	{
		int index=s.ifFacultyExists(CNIC);
    	if(index!=-1)
    	{
    		FacultyMember temp=new FacultyMember(name,password,DOB,phoneNo,email,CNIC,gender, emergencyContact, address, empID,dateHired,degrees,position);
    		
    		////SQL CONN/////////////////
    		mysqlCon con1= new mysqlCon();
    	     con1.addFaculty(s,name, password, DOB,phoneNo, email, CNIC, gender,emergencyContact,address, empID, dateHired,  degrees,position);
    	     
    	     return s.addFacultyMember(temp);
    	}
    	
    	else 
    		return false;

	}
	
   ////////////////////////////////ADD SECTION//////////////////////////////////////////////////////////// 
   public boolean addSection(School school,String c_code,FacultyMember f,char sID,Semester s)
   {
	   int index=0; boolean secIndex=false; boolean add=false;
	   ArrayList<Attendance> attendances=new ArrayList<Attendance>();
	   index=school.courseExists(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=school.getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(sID); 
		  if(secIndex==false)
			  {
			    CourseSection cs=new CourseSection(sID,50,0,f,s,tempcourse,attendances);
			  	tempcourse.addCourseSection(cs);
			  	
			  	////SQL CONN/////////////////
			  	 mysqlCon con1= new mysqlCon();
	    	     con1.addSection(sID, 50, 0, f,s,tempcourse);
	    	     
			  	school.updateCourseToCourses(index,tempcourse);
			  	add=true;
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
   public boolean removeSection(School school, String c_code , char sID,Semester semester)
   {
	   int index=0; boolean secIndex=false; boolean remove=false;
	   index=school.courseExists(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=school.getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(sID); 
		  if(secIndex==true)
			  {
			  
			  	tempcourse.removeCourseSection(sID);
			  	school.updateCourseToCourses(index,tempcourse);
			  	
			  	//SQL CON/////
			  	
			  	mysqlCon con1= new mysqlCon();
	    	     con1.removeSection(school, c_code ,sID,semester.getSession());
	    	     
	    	     
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
   public boolean updateSection(School school, String c_code, char secID, FacultyMember nf, int maxs, Semester s)
   {
	   int index=0; boolean secIndex=false; boolean update=false;
	   index=school.courseExists(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=school.getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(secID); 
		  if(secIndex==true)
			  {
				  if(school.facultyExists(nf)==true) {
				  	tempcourse.updateCourseSection(secID,nf,maxs);
				  	school.updateCourseToCourses(index,tempcourse);
				  	
				  	////SQL CONN/////////////////
				  	 mysqlCon con1= new mysqlCon();
		    	     con1.updateSection(school, c_code,secID,nf,maxs,s);

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
