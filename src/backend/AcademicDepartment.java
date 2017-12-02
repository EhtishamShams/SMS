/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author hamza
 */
public class AcademicDepartment extends Department {

	private ArrayList<Timetable> timeTables;

	public AcademicDepartment(ArrayList<Timetable> timeTables, String name, ArrayList<Staff> staff) {
		super(name, staff);
		this.timeTables = timeTables;
	}

	public ArrayList<Timetable> getTimeTables() {
		return timeTables;
	}

	public void setTimeTables(ArrayList<Timetable> timeTables) {
		this.timeTables = timeTables;
	}

	public void addTimeTable(Timetable tbl) {
		this.timeTables.add(tbl);
	}

}
