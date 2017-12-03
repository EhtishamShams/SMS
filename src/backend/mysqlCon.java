package backend;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import dal.DBAccess; 

public class mysqlCon {
	
	public boolean addFaculty(School s,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired, ArrayList<String> degrees,String position)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
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
			
				con.close(); 
				return true;
			}
			
			con.close(); 
			}catch(Exception e){ System.out.println(e);}  
		return false;
     }
	
	
	
	public boolean addStaff(String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
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
				con.close(); 
				return true;
			}
			
			con.close(); 
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}
	
	public boolean removeStaff(String empID)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
			int userid=0; String eid="";
			
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
				con.close(); 
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
					con.close(); 
					return true;
				}

			
			}	
			con.close(); 
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}

	public boolean addSection(char sectionID, int maxSeats, int currSeats, FacultyMember sectionTeacher, Semester semester,
								Course course)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
			
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
					}
  			}
			con.close();  
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}
	
      public boolean removeSection(String c_code , char sID,Semester semester)
      {
    	  try {
  			Class.forName("com.mysql.jdbc.Driver");  
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
  			Statement stmt=con.createStatement();  
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
		  	  				con.close();
		  	  				return true;
		  	  		    }	
		  			}
		  			
  			}
		  			
		  			con.close();  
  		
  			}catch(Exception e){ System.out.println(e);}  
  		
  		return false;
    	  
      }
	
	public boolean updateSection( String c_code, char secID, FacultyMember nf, int maxs, Semester s)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
			
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
				    con.close();
				     return true;
				     }
				}
			con.close();  
			
			}catch(Exception e){ System.out.println(e);}  
		return false;
	}
	
	public boolean updateStaff(String n_name, /*String n_password,*/ Date n_DOB, String n_phoneNo, String n_email, String n_CNIC, char n_gender,
			String n_emergencyContact, String n_address, String empID, Date n_dateHired)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
			int userid=0;
			
			ResultSet rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        userid=rs.getInt(1); 
		
			if(userid!=0)
			{
				stmt.executeUpdate("UPDATE USER 	\r\n" + 
						"SET NAME='"+n_name+"',DateOfBirth='"+n_DOB+"',PhoneNo='"+n_phoneNo+"',Email='"+n_email+"',CNIC='"+n_CNIC+"',Gender='"+n_gender+"',EmergencyContact='"+n_emergencyContact+"',Address='"+n_address+"' WHERE UserID=+"+userid+";");
						   
				stmt.executeUpdate("UPDATE staff SET DateHired='"+n_dateHired+"'  WHERE EmpID='"+empID+"';");
				con.close(); 
				return true;
				
				//,PASSWORD='"+n_password+"'
			}
			
			con.close(); 
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}
//////////////////////////////////////////////////MUAZ///////////////////////////////////////////////////
	
	public boolean addAllotmentDB(String oid, String Empid)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement();  
			String allotment /*userid*/="";   //just a typo
			String temp=""/*0*/; //string cant be equal to a int
			
			ResultSet rs=stmt.executeQuery("select* from Allotment where EmpID='"+Empid+"'"); 
			while(rs.next()) 
		        allotment=rs.getString(1);  //() <-this cannot be empty 
			System.out.println("LALALA"+allotment);
			
			ResultSet rs1=stmt.executeQuery("select* from Allotment where OfficeID='"+oid+"'"); 
			while(rs1.next()) 
		        temp=rs1.getString(1);  //() <-this cannot be empty 
			System.out.println("LALALA"+temp);
			
			if(allotment=="" && temp=="")    //null to empty string null not working and its not entering the loop
			{
				System.out.println("LOOP ENTERED");
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
			 
			 Class.forName("com.mysql.jdbc.Driver");   
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
				Statement stmt=con.createStatement(); 
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
	 
	 public boolean updateAllotmentDB(String oid/*int oid*/, String eid)
	 {
		 	try {
				Class.forName("com.mysql.jdbc.Driver");   
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
				Statement stmt=con.createStatement();  
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
	 public boolean addSchoolDB(String sid, String name)
	 {
		try {
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement(); 
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
	 
	 public boolean updateSchoolDB(String sid, String name)
	 {
		try {
			Class.forName("com.mysql.jdbc.Driver");   
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","open1234"); 
			Statement stmt=con.createStatement(); 
			String sch="";
			String temp="";
			
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
	 public boolean markAttendanceDB(String sid, String rollno, Date d, LAttendance a)
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
	 
	
	
}
