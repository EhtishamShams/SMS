package dal;
import java.sql.*;

import java.util.ArrayList;
import java.util.Date;
import backend.*;

/**
 * @author Advisor
 *
 */
public class DAL {

public static boolean addAllotmentDB(String oid, String Empid)
	{
		try {
			Statement stmt=DBAccess.getStatement(); 
			String allotment="";   //just a typo
			String temp="";
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where EmpID='"+Empid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1);  //() <-this cannot be empty 
			
			ResultSet rs1=stmt.executeQuery("select* from Allotment where OfficeID='"+oid+"'"); 
			while(rs.next()) 
		        temp=rs1.getString(1);  //() <-this cannot be empty 
			
			
			if(allotment=="" && temp=="")
			{
				
					stmt.executeUpdate("INSERT INTO Allotment (OfficeID,EmpID)"
								+ "VALUES('"+oid+"','"+Empid+"');");
					 
					
					return true;

			} 
			}catch(Exception e){ System.out.println(e);}  
		return false;
     }
	 
	
	public static boolean deleteAllotmentDB(String empid)
	 {
		 try {
			Statement stmt=DBAccess.getStatement();  
			String allotment="";
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where EmpID='"+empid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1); 
			if(allotment!="")
			{
				stmt.executeUpdate("delete from Allotment where EmpID='"+empid+"'");
				return true;
			}
			}catch(Exception e){ System.out.println(e);}  
			return false;
	 
	 }
	 
	 public static boolean updateAllotmentDB(String oid, String eid)
	 {
		 	try {
			Statement stmt=DBAccess.getStatement();
			String allotment="";
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where OfficeID='"+oid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1); 
			if(allotment=="")
			{
				stmt.executeUpdate("UPDATE Allotment SET OfficeID='"+oid+"' where EmpID='"+eid+"'");
				return true;
			} 
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 public static boolean addSchoolDB(String sid, String name)
	 {
		try {
			Statement stmt=DBAccess.getStatement(); 
			String sch="";
			String temp="";
			
			ResultSet rs=stmt.executeQuery("select* from School where SchoolID='"+sid+"'"); 
			while(rs.next()) 
		        sch=rs.getString(1); 
			
		    rs=stmt.executeQuery("select* from School where Name='"+name+"'"); 
			while(rs.next()) 
		        temp=rs.getString(1); 
			
			if(sch=="" && temp=="")
			{
				stmt.executeUpdate("INSERT INTO School (SchoolID,Name)"
								+ "VALUES('"+sid+"','"+name+"');");
				return true;
			}
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 
	 public static boolean updateSchoolDB(String sid, String name)
	 {
		try {
			Statement stmt=DBAccess.getStatement();
			String sch="";
		
			
			ResultSet rs=stmt.executeQuery("select* from School where SchoolID='"+sid+"'"); 
			while(rs.next()) 
		       sch=rs.getString(1); 
			if(sch!="")
			{
				stmt.executeUpdate("UPDATE School SET Name = '"+name+"' WHERE SchoolID='"+sid+"'");
				 
				return true;
			}
			
			}catch(Exception e){ System.out.println(e);}  
			return false;
	 }
	 public static boolean markAttendanceDB(int sid, String rollno, Date d, LAttendance a)
	 {
		try {
			
			Statement stmt=DBAccess.getStatement();
			
				stmt.executeUpdate("INSERT INTO Attendance (RollNo,Day,SectionKey,Status)"
								+ "VALUES('"+rollno+"','"+d+"','"+sid+"','"+a+"');");
				
				return true;
		
			}catch(Exception e){ System.out.println(e);}  
			return false;

	 }
	 
	 public static int getSectionKey(char sectionID,String courseCode,String session) {
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
	
	public static boolean addAttendanceDB(LAttendance atd , String rollno,int  key, Date d)
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
	 
	 public static ArrayList<String> returnCourse(String code)
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
	 
}
