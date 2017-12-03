/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.sql.Date;
import dal.*;

/**
 *
 * @author Advisor
 */
public class AcademicManager extends Staff {

	public AcademicManager(String name, String password, Date DOB, String phoneNo, String email, String CNIC,
			char gender, String emergencyContact, String address, String empID, Date dateHired) {
		super(name, password, DOB, phoneNo, email, CNIC, gender, emergencyContact, address, empID, dateHired);
	}


	public boolean registerStudentInCourse(String schoolID, String rollNo, String courseCode, char secID) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();
			CourseSection cs = sch.getCourseSection(c, secID, sem);

			if (cs != null) {
				if (sch.registerStudentInCourse(std, c, cs, sem)) {
					Fee f = Session.getAccountsDept().getStudentFee(rollNo, sem.getSession());

					if (f == null) {
						f = new Fee(0, null, sem.getFeeDueDate(), std, sem);
						f.addAmount(sem.getPerCreditHrFee() * c.getCreditHours());
						Session.getAccountsDept().addFee(f);
						DAL.addFee(f);
					} else {
						f.addAmount(sem.getPerCreditHrFee() * c.getCreditHours());
						Session.getAccountsDept().updateFee(f);
						DAL.updateFeeAmount(f);
					}

					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public boolean updateStudentCourseRegistration(String schoolID, String rollNo, String courseCode, char newID) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();
			CourseSection oldCs = std.getRegisteredCourseSection(c, sem);
			CourseSection newCs = sch.getCourseSection(c, newID, sem);

			if (oldCs != null && newCs != null)
				return sch.updateStudentCourseRegistration(std, oldCs, newCs, sem);
			else
				return false;
		} else
			return false;
	}

	public boolean removeStudentCourseRegistration(String schoolID, String rollNo, String courseCode) {
		School sch = null;

		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Student std = sch.getStudent(rollNo);
		Course c = sch.getCourse(courseCode);

		if (std != null && c != null) {
			Semester sem = Session.getSem();

			CourseSection cs = std.getRegisteredCourseSection(c, sem);

			if (cs != null) {
				if (sch.removeStudentCourseRegistration(std, cs, sem)) {
					Fee f = Session.getAccountsDept().getStudentFee(rollNo, sem.getSession());

					if (f != null) {
						f.deductAmount(sem.getPerCreditHrFee() * c.getCreditHours());

						if (f.getAmount() == 0) {
							Session.getAccountsDept().removeFee(f);
							DAL.removeFee(f);
						} else {
							Session.getAccountsDept().updateFee(f);
							DAL.updateFeeAmount(f);
						}
					}

					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public FacultyMember getFacultyMember(String empID) {
		return Session.getInst().getFacultyMember(empID);
	}

	public void addTimeTable(String fileName, String filePath, String schoolID, String session) {
		School sch = null;
		for (School s : Session.getInst().getSchools()) {
			if (s.getId().equals(schoolID))
				sch = s;
		}

		Semester sem = null;
		for (Semester s : Session.getInst().getSemesters()) {
			if (s.getSession().equals(session))
				sem = s;
		}

		Timetable tbl = new Timetable(fileName, filePath, sch, sem);
		Session.getAcademicDept().addTimeTable(tbl);
	}


	////////////////////////////////ADD FACULTY/////////////////////////////////////////////////////////
 boolean RegisterFaculty(String schoolid,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, Date dateHired, ArrayList<String> degrees,
			String position,String EmpID)
	{
	 	
	    int index=Session.getHrDept().ifStaffExistsByIndex(EmpID);
	    if(index!=-1) {

					 index=Session.getInst().getSchool(schoolid).ifFacultyExistsByIndex(EmpID);
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
	   index=Session.getInst().getSchool(schoolid).courseExistsByIndex(c_code);
	   
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
	   index=Session.getInst().getSchool(schoolid).courseExistsByIndex(c_code);
	   if(index !=-1)
	   {
		  Course tempcourse=Session.getSchl().getCourseFromCourses(index);
		  secIndex=tempcourse.ifSectionExists(sID); 
		  if(secIndex==true  )
			  {
			  //SQL CON/////
			  if( DAL.removeSection(c_code ,sID,Session.getSem())==true) {   
				  	tempcourse.removeCourseSection(sID);
				  	Session.getSchl().updateCourseToCourses(index,tempcourse);
			    
			    ArrayList<Student> sectionStudents=Session.getInst().getSchool(schoolid).getStudentFromStudents(sID);;
                    if(sectionStudents!= null)
                    {
					    for(Student s : sectionStudents)
						{
					    	removeStudentCourseRegistration(schoolid, s.getRollNo(), c_code,sID);    //Noumans functionality
						}
                    }

			  	remove=true;
   	    	    }
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
	   index=Session.getSchl().courseExistsByIndex(c_code);
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
   ///////////////////////////////////////////NOUMAN/////////////////////////////////////////////
   public boolean removeStudentCourseRegistration(String schoolID, String rollNo, String courseCode,char secID) {
   	School sch = null;
   	
   	for(School s:Session.getInst().getSchools()) {
			if(s.getId().equals(schoolID))
				sch = s;
		}
   	
   	Student std = sch.getStudent(rollNo);
   	Course c = sch.getCourse(courseCode);
   	
   	
   	if(std!=null && c!=null)
   	{
   		Semester sem = Session.getSem();
   		CourseSection cs = sch.getCourseSection(c, secID, sem);
   		
   		if(cs!=null)
   			return sch.removeStudentCourseRegistration(std, cs,sem);
   		else
   			return false;
   	}
   	else
   		return false;
   }

   

    
    // function for updating school name 
	boolean updateSchool(String id , String updatedName , AcademicInstitution a)
	{
		boolean check= false;
		check=a.updateSchool(id,updatedName);
			
			if(check)
			{
				 DAL.updateSchoolDB(id,name);
				return true;
			}
		return check;
	}
    //function for adding another school in the institution 
	
	boolean addSchool(String id, String name,AcademicInstitution a)
	{
		return a.Validate(id, name);
	}
	
}
