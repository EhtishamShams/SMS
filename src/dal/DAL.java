package dal;

import java.sql.*;
import java.util.ArrayList;

import backend.*;

public class DAL {

	public static int getSectionKey(char sectionID, String courseCode, String session) {
		int sectionKey = -1;

		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			ResultSet rs = stmt.executeQuery("select * from coursesection where SectionID='" + sectionID
					+ "' and courseCode='" + courseCode + "' and Session='" + session + "';");

			while (rs.next())
				sectionKey = rs.getInt(1);

			con.commit();

			return sectionKey;
		} catch (Exception e) {
			System.out.println(e);
			return sectionKey;
		}
	}

	public static boolean incrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("Update coursesection Set CurrSeats = CurrSeats+1 Where SectionKey =" + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean decrementCurrSeats(int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("Update coursesection Set CurrSeats = CurrSeats-1 Where SectionKey =" + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			DBAccess.createConnection();
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into studentcoursesection (RollNo,SectionKey) values ('" + rollNo + "',"
					+ sectionKey + ");");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeStudentCourseRegistration(String rollNo, int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from studentcoursesection where RollNo='" + rollNo + "' and SectionKey="
					+ sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addGradeToTranscript(String grade, int sectionKey, String rollNo, String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into grade (Grade,SectionKey,RollNo,Session) values ('" + grade + "',"
					+ sectionKey + ",'" + rollNo + "','" + session + "');");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeGradeFromTranscript(String grade, int sectionKey, String rollNo, String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from grade where Grade ='" + grade + "' and sectionKey = " + sectionKey
					+ " and RollNo='" + rollNo + "' and Session='" + session + "';");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean updateGradeSection(String grade, int oldSectionKey, int newSectionKey, String rollNo,
			String session) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("update grade set SectionKey =" + newSectionKey + " where Grade = '" + grade + "' and SectionKey = "
							+ oldSectionKey + " and RollNo='" + rollNo + "' and Session='" + session + "';");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean removeStudentAttendance(String rollNo, int sectionKey) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from attendance where RollNo ='" + rollNo + "' and SectionKey = " + sectionKey + ";");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static int getUserIDFacultyMember(String empID) {
		int userID = -1;
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			ResultSet rs = stmt.executeQuery("select * from staff where EmpID='" + empID + "';");

			while (rs.next())
				userID = rs.getInt(1);

			con.commit();

			return userID;
		} catch (Exception e) {
			System.out.println(e);
			return userID;
		}
	}

	public static boolean updateFacultyDetails(String empID, String name, Date DOB, String phoneNo, String email,
			String CNIC, char gender, String emergencyContact, String address, ArrayList<String> degrees,
			String position) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			int userID = getUserIDFacultyMember(empID);
			stmt.executeUpdate("update user set name ='" + name + "',DateOfBirth = '" + DOB + "',PhoneNo='" + phoneNo
					+ "', email='" + email + "',CNIC='" + CNIC + "',Gender='" + gender + "',EmergencyContact='"
					+ emergencyContact + "',Address='" + address + "' where UserID=" + userID + ";");

			stmt = DBAccess.getStatement();
			stmt.executeUpdate("delete from facultymemberdegrees where EmpID='" + empID + "';");

			for (String d : degrees) {
				stmt = DBAccess.getStatement();
				stmt.executeUpdate("insert into facultymemberdegrees values ('" + empID + "','" + d + "');");
			}

			stmt = DBAccess.getStatement();
			stmt.executeUpdate("update facultymember set position='" + position + "' where EmpID='" + empID + "';");

			con.commit();

			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addFee(Fee f) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("insert into fee (Amount,DatePaid,DueDate,RollNo,Session) values (" + f.getAmount()
					+ ",'" + f.getDatePaid() + "','" + f.getDueDate() + "','" + f.getStudent().getRollNo() + "','"
					+ f.getSemester().getSession() + "');");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateFeeAmount(Fee f) {

		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("update fee set Amount = " + f.getAmount() + " where RollNo = '"
					+ f.getStudent().getRollNo() + "' and Session = '" + f.getSemester().getSession() + "';");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean removeFee(Fee f) {
		try {
			Connection con = DBAccess.getConnection();
			Statement stmt = DBAccess.getStatement();

			stmt.executeUpdate("delete from fee where RollNo = '" + f.getStudent().getRollNo() + "' and Session = '"
					+ f.getSemester().getSession() + "';");

			con.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

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
	 

	public boolean addPay(Pay p) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Pay VALUES (" + p.getAmount() + ", " + "'" + p.getDatePaid() + "', "
					+ p.getStaffMember().getEmpID() + ")");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean updateFeeDate(Fee f) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("UPDATE Fee SET DatePaid = '" +f.getDatePaid() + "' WHERE RollNo = '" + f.getStudent().getRollNo()
					+ "' AND Session = '" + f.getSemester().getSession() + "'");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean addOffice(Office o) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("INSERT INTO Office VALUES ('" + o.getID() + "')");
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean changePassword(String newPass, String CNIC) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			stmnt.executeUpdate("UPDATE User SET Password = '" + newPass + "' WHERE CNIC = '" + CNIC + "'" );
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public boolean updateGrade(Grade g, String rollNum) {
		boolean check = true;
		Statement stmnt = DBAccess.getStatement();
		try {
			ResultSet rs = stmnt.executeQuery("SELECT SectionKey FROM CourseSection WHERE SectionID = '" + g.getCourseSection().getSectionID()
					+ "' AND CourseCode = '" + g.getCourseSection().getCourse().getCourseCode()
					+ "' AND Session = '" + g.getCourseSection().getSemester().getSession() + "'");
			rs.next();
			String sectionKey = rs.getString(1);
			stmnt.executeUpdate("UPDATE Grade SET Grade = '" + g.getGrade().toString() + "' WHERE SectionKey = '" + sectionKey
					+ "' AND RollNo = '" + rollNum + "'" );
			DBAccess.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			check = false;
		}
		return check;
	}

}
