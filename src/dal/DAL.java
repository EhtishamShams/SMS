package dal;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import backend.*;

/**
 * @author hamza
 *
 */

public class DAL {
	public static boolean addFaculty(School s,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired, ArrayList<String> degrees,String position)
	{
		try {
			Statement stmt = DBAccess.getStatement();
			int userid=0;
			
			ResultSet rs=stmt.executeQuery("select* from User where CNIC='"+CNIC+"'"); 
			while(rs.next()) 
		        userid=rs.getInt(1); 
		
			if(userid==0)
			{
				stmt.executeUpdate("INSERT INTO USER (NAME,PASSWORD,DateOfBirth,PhoneNo,Email,CNIC,Gender,EmergencyContact,Address) "
						   + "VALUES('"+name+"','"+password+"','"+DOB+"','"+phoneNo+"','"+email+"','"+CNIC+"','"+gender+"','"+emergencyContact+"','"+address+"');");
				ResultSet rs1=stmt.executeQuery("select* from User where CNIC='"+CNIC+"'"); 
				while(rs1.next()) 
				userid=rs1.getInt(1);  
				
				stmt.executeUpdate("INSERT INTO staff (UserID,EmpID,DateHired) VALUES ('"+userid+"','"+empID+"','"+dateHired+"');");
				stmt.executeUpdate("INSERT INTO facultymember (EmpID,POSITION,SchoolID) VALUES ('"+empID+"','"+position+"','"+s.getId()+"');"); 
				for(String d : degrees)
				{
					stmt.executeUpdate("INSERT INTO facultymemberdegrees (EmpID,Degree) VALUES ('"+empID+"','"+d+"');"); 
				}
				DBAccess.getConnection().commit();
				return true;
			}
			
			}catch(Exception e){ System.out.println(e);}  
		return false;
     }
	
	
	public static boolean addStaff(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired)
	{
		try {
			Statement stmt = DBAccess.getStatement();
		
			int userid=0;
			
			ResultSet rs=stmt.executeQuery("select* from User where CNIC='"+CNIC+"'"); 
			while(rs.next()) 
		        userid=rs.getInt(1); 
		
			if(userid==0)
			{
				stmt.executeUpdate("INSERT INTO USER (NAME,PASSWORD,DateOfBirth,PhoneNo,Email,CNIC,Gender,EmergencyContact,Address) "
						   + "VALUES('"+name+"','"+password+"','"+DOB+"','"+phoneNo+"','"+email+"','"+CNIC+"','"+gender+"','"+emergencyContact+"','"+address+"');");
				ResultSet rs1=stmt.executeQuery("select* from User where CNIC='"+CNIC+"'"); 
				while(rs1.next()) 
				userid=rs1.getInt(1);  
				
				stmt.executeUpdate("INSERT INTO staff (UserID,EmpID,DateHired) VALUES ('"+userid+"','"+empID+"','"+dateHired+"');");
				DBAccess.getConnection().commit();
				return true;
			}
			
		
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}
	
	
	public static boolean updateStaff(String n_name, /*String n_password,*/ Date n_DOB, String n_phoneNo, String n_email, String n_CNIC, char n_gender,
			String n_emergencyContact, String n_address, String empID, Date n_dateHired)
	{
		try {
			int userid=0;
			Statement stmt = DBAccess.getStatement();			
			ResultSet rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        userid=rs.getInt(1); 
		
			if(userid!=0)
			{
				stmt.executeUpdate("UPDATE USER 	\r\n" + 
						"SET NAME='"+n_name+"',DateOfBirth='"+n_DOB+"',PhoneNo='"+n_phoneNo+"',Email='"+n_email+"',CNIC='"+n_CNIC+"',Gender='"+n_gender+"',EmergencyContact='"+n_emergencyContact+"',Address='"+n_address+"' WHERE UserID=+"+userid+";");
						   
				stmt.executeUpdate("UPDATE staff SET DateHired='"+n_dateHired+"'  WHERE EmpID='"+empID+"';"); 
				DBAccess.getConnection().commit();
				return true;
				
				//,PASSWORD='"+n_password+"'
			}
			
		
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}
	
	public static boolean removeStaff(String empID)
	{
		try { 
			int userid=0; String eid="";
			Statement stmt = DBAccess.getStatement();
			ResultSet rs=stmt.executeQuery("select* from facultymember where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        eid=rs.getString(1); 
		
			if(eid!="")
			{
				stmt.executeUpdate("Delete from facultymemberdegrees where EmpID='"+empID+"'");		
				stmt.executeUpdate("UPDATE coursesection SET TeacherID = NULL WHERE TeacherID='"+empID+"'");
				stmt.executeUpdate("Delete from facultymember where EmpID='"+empID+"'");
				rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
				while(rs.next()) 
			        userid=rs.getInt(1); 
				
				stmt.executeUpdate("Delete from staff where EmpID='"+empID+"'");
				stmt.executeUpdate("Delete from user where UserID='"+userid+"'");
				DBAccess.getConnection().commit();
				return true;
				
			}
			
			else if(eid=="")
			{
				
				rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
				while(rs.next()) 
			        userid=rs.getInt(1); 
				
				if(userid>0) {
					stmt.executeUpdate("Delete from staff where EmpID='"+empID+"'");
					stmt.executeUpdate("Delete from user where UserID='"+userid+"'");
					DBAccess.getConnection().commit();
					return true;
				}

			
			}	
	

			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}

	public static boolean addSection(char sectionID, int maxSeats, int currSeats, FacultyMember sectionTeacher, Semester semester,
			Course course)
		{
		    try {
		    	Statement stmt = DBAccess.getStatement(); 
		    	int secid=0; String code="";int check_sem=0;
				ResultSet rs=stmt.executeQuery("select CourseCode from course where CourseCode='"+course.getCourseCode()+"' AND IsOffered = 1");  
	  			while(rs.next()) 
	  		        code=rs.getString(1);
	  			
	  			rs=stmt.executeQuery("select IsActive from semester where Session='"+semester.getSession()+"' AND IsActive=1");  
	  			while(rs.next()) 
	  			check_sem=rs.getInt(1);
	  			
	  			if(code !="" && check_sem==1) {
	  						code=""; 
				
						rs=stmt.executeQuery("select* from coursesection where SectionID='"+sectionID+"'AND CourseCode='"+course.getCourseCode()+"'"); 
						while(rs.next()) 
					        secid=rs.getInt(1); 
						
						if(secid==0)
						{
							stmt.executeUpdate("INSERT INTO coursesection(`SectionID`,`CurrSeats`,`TeacherID`,`CourseCode`,`Session`) "
									            + "VALUES('"+sectionID+"','"+currSeats+"','"+sectionTeacher.getEmpID()+"','"+course.getCourseCode()+"','"+semester.getSession()+"');");
							DBAccess.getConnection().commit();
							return true;
						}
	  			}
			}catch(Exception e){ System.out.println(e);}  
			
			return false;
		}

	public static boolean updateSection(String c_code, char secID, FacultyMember nf, int maxs, Semester s)
	{
		try {
			Statement stmt = DBAccess.getStatement();
			int secid=0; String empid=""; int check_sem=0;
			ResultSet rs=stmt.executeQuery("select* from coursesection where SectionID='"+secID+"'AND CourseCode='"+c_code+"'AND Session='"+s.getSession()+"';"); 
			while(rs.next()) 
		        secid=rs.getInt(1); 
			
  			rs=stmt.executeQuery("select IsActive from semester where Session='"+s.getSession()+"' AND IsActive = 1");  
  			while(rs.next())
  			check_sem=rs.getInt(1);
			
			if(secid!=0 && check_sem==1)
			{
				rs=stmt.executeQuery("select EmpID from facultymember where EmpID='"+nf.getEmpID()+"'"); 
				while(rs.next()) 
			        empid=rs.getString(1); 
				if(empid!="") {
					stmt.executeUpdate("UPDATE coursesection SET MaxSeats = '"+maxs+"' WHERE SectionID='"+secID+"'AND CourseCode='"+c_code+"'");
					stmt.executeUpdate("UPDATE coursesection SET TeacherID = '"+nf.getEmpID()+"' WHERE SectionID='"+secID+"'AND CourseCode='"+c_code+"'");
					DBAccess.getConnection().commit();
					return true;
				     }
				}
	 
			
			}catch(Exception e){ System.out.println(e);}  
		return false;
	}
	
    public static boolean removeSection(String c_code , char sID,Semester semester)
    {
  	  try { 
			Statement stmt = DBAccess.getStatement();
String code=""; int secid=0; int check_sem=0;
  			
  			ResultSet rs=stmt.executeQuery("select CourseCode from course where CourseCode='"+c_code+"' AND IsOffered = 1");  
  			while(rs.next()) 
  		        code=rs.getString(1);
  			
  			
  			rs=stmt.executeQuery("select IsActive from semester where Session='"+semester.getSession()+"' AND IsActive = 1");  
  			while(rs.next()) 
  			check_sem=rs.getInt(1);
  			
  			
  			
  			if(code !="" && check_sem==1) {
  						code="";
		  			 rs=stmt.executeQuery("select CourseCode from coursesection where CourseCode='"+c_code+"'");  
		  			while(rs.next()) 
		  		        code=rs.getString(1); 
		  			
		  			if(code!="")
		  			{
		  				
		  	  			rs=stmt.executeQuery("select* from coursesection where SectionID='"+sID+"'"); 
		  	  			while(rs.next()) 
		  	  		        secid=rs.getInt(1); 
		  	  		System.out.println(secid);
		  	  			if(secid!=0)
		  	  			{
		  	  				stmt.executeUpdate("Delete from coursesection where SectionID='"+sID+"'AND CourseCode='"+c_code+"'AND Session='"+semester.getSession()+"'");
		  	  				DBAccess.getConnection().commit();
		  	  				return true;
		  	  		    }	
		  			}
		  			
			}

		}catch(Exception e){ System.out.println(e);}  
		
		return false;
    }

    public static void getSectionAttendance(CourseSection cs,ArrayList<Student> std)
    {
    	try { 
    		Statement stmt = DBAccess.getStatement();
			ResultSet rs=stmt.executeQuery("select * from attendance where SectionKey='"+cs.getSectionID()+"'");  
			String roll="";
			
			ArrayList<Attendance> att = cs.getStudentAttendance();
			
			while(rs.next()) 
			{	
				roll=rs.getString(1);
				rs.getDate(1);    //date		
				for(Student s : std)
				{
					  if(roll.equals(s.getRollNo()))
					  {
					      Student s1=s;
					      Attendance temp=new Attendance(LAttendance.valueOf(rs.getString(1)),rs.getDate(1),s1);
					      att.add(temp);
					  }
				}
			}
			
			DBAccess.getConnection().commit();
		}catch(Exception e){ System.out.println(e);}

    }
}
