/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.Date;

/**
 *
 * @author Advisor
 */
public class Attendance{
    LAttendance status;
    Date Day;
    CourseSection section;
    Student student;

    public Attendance()
    {
    	
    }
    public Attendance(LAttendance atd, Date day2, Student s, CourseSection cs) {
		// TODO Auto-generated constructor stub
    	 this.status = atd;
         this.Day = day2;
         this.section = cs;
         this.student = s;
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
    public CourseSection getSection() {
        return section;
    }

    public void setSection(CourseSection section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    

    
    
    
}
