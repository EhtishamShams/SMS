/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.Date;

/**
 *
 * @author Advisor
 */
public class Attendance {
	LAttendance status;
	Date Day;
	Student student;

	public Attendance(LAttendance status, Date Day, Student student) {
		this.status = status;
		this.Day = Day;
		this.student = student;
	}

	public LAttendance getStatus() {
		return status;
	}

	public void setStatus(LAttendance status) {
		this.status = status;
	}

	public Date getDay() {
		return Day;
	}

	public void setDay(Date Day) {
		this.Day = Day;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
