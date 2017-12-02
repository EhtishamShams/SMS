package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import backend.*;

public class Load {
	
	public void loadFaculty() {
				
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select U.Name, U.Password, U.DateOfBirth, U.PhoneNo, U.Email, U.CNIC, U.Gender, U.EmergencyContact, U.Address, S.empID, S.DateHired, fm.Position, fm.SchoolID From User U join Staff S join facultymember fm on U.userID=S.userID and fm.empID = S.empID ";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			query = "Select Degree From facultymemberdegrees Where EmpID=?";
			pst = conn.prepareStatement(query);
			
			while(rs.next()) {
				ArrayList<String> facDegrees = new ArrayList<String>();
				pst.setString(1, rs.getString(10));
				ResultSet rs2 = pst.executeQuery();
				
				while(rs2.next())
					facDegrees.add(rs2.getString(1));
				
				Session.getInst().getSchool(rs.getString(13)).getFaculty().add(new FacultyMember(rs.getString(1), rs.getString(2),  rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7).charAt(0),
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11), facDegrees,
						rs.getString(12)));
			}
				
			for(School sch:Session.getInst().getSchools()) {
				for(FacultyMember facM:sch.getFaculty()) {
					Session.getInst().getUsers().add(facM);
				}
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
	
	public void loadCourses() {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From course";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Course crs = new Course(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), new ArrayList<Course>(), new ArrayList<CourseSection>(), rs.getBoolean(6));
				Session.getInst().getSchool(rs.getString(5)).getCourses().add(crs);
				loadCourseSection(crs, Session.getInst().getSchool(rs.getString(5)));
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	private void loadCourseSection(Course crs, School sch) {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From coursesection where coursecode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, crs.getCourseCode());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				crs.getSections().add(new CourseSection(rs.getString(2).charAt(0), rs.getInt(3), rs.getInt(4), sch.getFacultyMember(rs.getString(5)), Session.getInst().getSemester(rs.getString(7)), crs, new ArrayList<Attendance>()));
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public void loadStudents() {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select U.Name, U.Password, U.DateOfBirth, U.PhoneNo, U.Email, U.CNIC, U.Gender, U.EmergencyContact, U.Address, S.rollNo, S.fathername, S.fathercnic, S.cgpa, S.creditsearned, S.creditsattempted, S.schoolID From User U join Student S on U.userID=S.UserID";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			query = "Select CourseCode, Session, SectionID From CourseSection CS join studentcoursesection SCS on CS.sectionKey=SCS.sectionKey Where rollNo=?";
			pst = conn.prepareStatement(query);
			
			while(rs.next()) {
				School sch = Session.getInst().getSchool(rs.getString(16));
				pst.setString(1, rs.getString(10));
				ResultSet stdCourses = pst.executeQuery();
				
				ArrayList<CourseSection> courses = new ArrayList<CourseSection>();
				
				while(stdCourses.next()) {
					courses.add(sch.getCourse(stdCourses.getString(1)).getCourseSection(stdCourses.getString(2), stdCourses.getString(3).charAt(0)));
				}
				
				Student std = new Student(rs.getString(1), rs.getString(2),  rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7).charAt(0),
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(12), rs.getString(11), (float) rs.getDouble(13), rs.getInt(14), rs.getInt(15), courses);
				
				loadTranscript(std);
				sch.getStudents().add(std);
			}
			
			//Adding into users array
			for(School sch:Session.getInst().getSchools()) {
				for(Student std:sch.getStudents()) {
					Session.getInst().getUsers().add(std);
				}
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	private void loadTranscript(Student std) {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			Transcript transcript = new Transcript();
			
			String query = "Select Grade From grade G join CourseSection CS on G.sectionKey=CS.sectionKey and G.session=CS.session where CS.coursecode=? and CS.session=? and CS.sectionID=? and G.rollNo=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(4, std.getRollNo());
			
			for(CourseSection cSec:std.getStudiedCourses()) {
				pst.setString(1, cSec.getCourse().getCourseCode());
				pst.setString(2, cSec.getSemester().getSession());
				pst.setString(3, Character.toString(cSec.getSectionID()));
				ResultSet rs = pst.executeQuery();
				
				if(rs.next())
					transcript.getGrades().add(new Grade(LGrade.valueOf(rs.getString(1)), cSec));
			}
			
			std.setTranscript(transcript);
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public void loadSemesters() {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From semester";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Semester temp = new Semester(rs.getString(1), rs.getBoolean(2), rs.getDouble(3), rs.getDate(4));
				Session.getInst().getSemesters().add(temp);
				if(temp.isActive())
					Session.setSem(temp);
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public void loadSchools() {
		
		try {
			Connection conn = DBAccess.getConnection();
			
			String query = "Select * From school";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Session.getInst().getSchools().add(new School(rs.getString(1), rs.getString(2), new ArrayList<FacultyMember>(), new ArrayList<Student>(), new ArrayList<Course>()));
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public void loadAttendance() {
		try {
			Connection conn = DBAccess.getConnection();
			String query = "Select A.status,A.rollNo, A.Day From attendance A join CourseSection CS on A.sectionKey=CS.sectionKey where CS.SectionID=? and CS.Session=? and CS.CourseCode=?";
			PreparedStatement pst = conn.prepareStatement(query);
			
			for(School sch:Session.getInst().getSchools()) {
				for(Course crs:sch.getCourses()) {
					for(CourseSection crsSec:crs.getSections()) {
						if(crsSec.getSemester() == Session.getSem()) {
							pst.setString(1, Character.toString(crsSec.getSectionID()));
							pst.setString(2, crsSec.getSemester().getSession());
							pst.setString(3, crs.getCourseCode());
							ResultSet rs = pst.executeQuery();
							
							while(rs.next()) {
								crsSec.getStudentAttendance().add(new Attendance(LAttendance.valueOf(rs.getString(1)), rs.getDate(3),sch.getStudent(rs.getString(2))));
							}
						}
					}
				}
			}
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}

}
