package backend;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date; 

public class mysqlCon {
	
	public boolean addFaculty(School s,String name, String password, Date DOB, String phoneNo, String email, String CNIC, char gender,
			String emergencyContact, String address, String empID, Date dateHired, ArrayList<String> degrees,String position)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
			Statement stmt=con.createStatement();  
			
			int secid=0; String code="";int check_sem=0;
			ResultSet rs=stmt.executeQuery("select CourseCode from courses where CourseCode='"+course.getCourseCode()+"' AND IsOffered = 1");  
  			while(rs.next()) 
  		        code=rs.getString(1);
  			
  			rs=stmt.executeQuery("select IsActive from semester where Session='"+semester.getSession()+"' AND IsActive = 1");  
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
	
      public boolean removeSection(School school, String c_code , char sID,String semester)
      {
    	  try {
  			Class.forName("com.mysql.jdbc.Driver");  
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
  			Statement stmt=con.createStatement();  
  			String code=""; int secid=0; int check_sem=0;
  			
  			ResultSet rs=stmt.executeQuery("select CourseCode from courses where CourseCode='"+c_code+"' AND IsOffered = 1");  
  			while(rs.next()) 
  		        code=rs.getString(1);
  			
  			rs=stmt.executeQuery("select IsActive from semester where Session='"+semester+"' AND IsActive = 1");  
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
		  	  			
		  	  			if(secid!=0)
		  	  			{
		  	  				stmt.executeUpdate("Delete from coursesection where SectionID='"+sID+"'AND CourseCode='"+c_code+"'AND Session='"+semester+"'");
		  	  				con.close();
		  	  				return true;
		  	  		    }	
		  			}
		  			
  			}
		  			
		  			con.close();  
  		
  			}catch(Exception e){ System.out.println(e);}  
  		
  		return false;
    	  
      }
	
	public boolean updateSection(School school, String c_code, char secID, FacultyMember nf, int maxs, Semester s)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
			Statement stmt=con.createStatement();  
			
			int secid=0; String empid=""; int check_sem=0;
			ResultSet rs=stmt.executeQuery("select* from coursesection where SectionID='"+secID+"'AND CourseCode='"+c_code+"'AND Session='"+s.getSession()+"';"); 
			while(rs.next()) 
		        secid=rs.getInt(1); 
			
  			rs=stmt.executeQuery("select IsActive from semester where Session='"+s.getSession()+"' AND IsActive = 1");  
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
	
	public boolean updateStaff(String n_name, String n_password, Date n_DOB, String n_phoneNo, String n_email, String n_CNIC, char n_gender,
			String n_emergencyContact, String n_address, String empID, Date n_dateHired)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","mysql"); 
			Statement stmt=con.createStatement();  
			int userid=0;
			
			ResultSet rs=stmt.executeQuery("select UserID from staff where EmpID='"+empID+"'"); 
			while(rs.next()) 
		        userid=rs.getInt(1); 
		
			if(userid!=0)
			{
				stmt.executeUpdate("UPDATE USER 	\r\n" + 
						"SET NAME='"+n_name+"',PASSWORD='"+n_password+"',DateOfBirth='"+n_DOB+"',PhoneNo='"+n_phoneNo+"',Email='"+n_email+"',CNIC='"+n_CNIC+"',Gender='"+n_gender+"',EmergencyContact='"+n_emergencyContact+"',Address='"+n_address+"' WHERE UserID=+"+userid+";");
						   
				stmt.executeUpdate("UPDATE staff SET DateHired='"+n_dateHired+"'  WHERE EmpID='"+empID+"';");
				con.close(); 
				return true;
			}
			
			con.close(); 
			
			}catch(Exception e){ System.out.println(e);}  
		
		return false;
	}

}
