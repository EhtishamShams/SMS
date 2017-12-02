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
						DAL.updateFee(f);
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
							DAL.updateFee(f);
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

}
