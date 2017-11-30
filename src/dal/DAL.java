package dal;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import backend.*;

/**
 * @author HumnaGul
 *
 */


public boolean addAllotmentDB(String oid, String Empid)
	{
		try {
			Statement stmt=DBAccess.getStatement(); 
			String allotment /*userid*/=null;   //just a typo
			String temp=""/*0*/; //string cant be equal to a int
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where EmpID='"+Empid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1);  //() <-this cannot be empty 
			
			ResultSet rs1=stmt.executeQuery("select* from Allotment where OfficeID='"+oid+"'"); 
			while(rs.next()) 
		        temp=rs1.getString(1);  //() <-this cannot be empty 
			
			
			if(allotment==null && temp==null)
			{
				
					stmt.executeUpdate("INSERT INTO Allotment (OfficeID,EmpID)"
								+ "VALUES('"+oid+"','"+Empid+"');");
					 
					
					return true;

			} 
			}catch(Exception e){ System.out.println(e);}  
		return false;
     }
	 
	
	public boolean deleteAllotmentDB(String empid)
	 {
		 try {
			Statement stmt=DBAccess.getStatement();  
			String allotment=null;
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where EmpID='"+empid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1); 
			if(allotment!=null)
			{
				stmt.executeUpdate("delete from Allotment where EmpID='"+empid+"'");
				return true;
			}
			}catch(Exception e){ System.out.println(e);}  
			return false;
	 
	 }
	 
	 public boolean updateAllotmentDB(int oid, String eid)
	 {
		 	try {
			Statement stmt=DBAccess.getStatement();
			String allotment=null;
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where OfficeID='"+oid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1); 
			if(allotment==null)
			{
				stmt.executeUpdate("UPDATE Allotment SET OfficeID='"+oid+"' where EmpID='"+eid+"'");
				return true;
			} 
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 public boolean addSchoolDB(String sid, String name)
	 {
		try {
			Statement stmt=DBAccess.getStatement(); 
			String sch=null;
			String temp=null;
			
			ResultSet rs=stmt.executeQuery("select* from School where SchoolID='"+sid+"'"); 
			while(rs.next()) 
		        sch=rs.getString(1); 
			
		    rs=stmt.executeQuery("select* from School where Name='"+name+"'"); 
			while(rs.next()) 
		        temp=rs.getString(1); 
			
			if(sch==null && temp==null)
			{
				stmt.executeUpdate("INSERT INTO School (SchoolID,Name)"
								+ "VALUES('"+sid+"','"+name+"');");
				return true;
			}
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 
	 public boolean updateSchoolDB(String sid, String name)
	 {
		try {
			Statement stmt=DBAccess.getStatement();
			String sch=null;
			String temp=null;
			
			ResultSet rs=stmt.executeQuery("select* from School where SchoolID='"+sid+"'"); 
			while(rs.next()) 
		       sch=rs.getString(1); 
			if(sch!=null)
			{
				stmt.executeUpdate("UPDATE School SET Name = '"+name+"' WHERE SchoolID='"+sid+"'");
				 
				return true;
			}
			
			}catch(Exception e){ System.out.println(e);}  
			return false;
	 }
	 public boolean markAttendanceDB(int sid, String rollno, Date d, LAttendance a)
	 {
		try {
			
			Statement stmt=DBAccess.getStatement();
			
				stmt.executeUpdate("INSERT INTO Attendance (RollNo,Day,SectionKey,Status)"
								+ "VALUES('"+rollno+"','"+d+"','"+sid+"','"+a+"');");
				
				return true;
		
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 
	 public int getSectionKey(char sectionID,String courseCode,String session) {
		int sectionKey = -1;
		
		try{  

			Statement stmt=DBAccess.getStatement();
			ResultSet rs=stmt.executeQuery("select * from CourseSection where SectionID='"+sectionID+"' and courseCode='"+courseCode+"' and Session='"+session+"';");  
			
			while(rs.next())  
				sectionKey = rs.getInt(1);
			 
			return sectionKey;
		}catch(Exception e){ 
			System.out.println(e);
			return sectionKey;
		} 
	}
	
	public boolean addAttendanceDB(String atd , String rollno,int  key, Date d)
	{
		try {
			Statement stmt=DBAccess.getStatement(); 
			
					stmt.executeUpdate("INSERT INTO Attendance (RollNo,Day,SectionKey,Status)"
								+ "VALUES('"+rollno+"','"+d+"','"+key+"','"+atd+"');");
					 
					DBAccess.getStatement(); 
					return true;
			}catch(Exception e){ System.out.println(e);}  
		return false;
     }
	 
	 public ArrayList<String> returnCourse(String code)
	 {	
		ArrayList<String> codes = new ArrayList<String>();
		 try{  
			
			
			Statement stmt=DBAccess.getStatement(); 
			ResultSet rs=stmt.executeQuery("select * from CoursePrerequisites where CourseCode='"+code+"';");  
			
			while(rs.next())  
			{
				codes.add(rs.getString(2));
			}
			    return codes;
		} catch(Exception e){ 
			System.out.println(e);
			return codes;
		} 
		 
	 }
	 
	