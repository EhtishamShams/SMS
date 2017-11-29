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
public class Department {

	protected String name;
	protected ArrayList<Staff> staff;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public void setStaff(ArrayList<Staff> staff) {
		this.staff = staff;
	}

	public Department(String name, ArrayList<Staff> staff) {
		this.name = name;
		this.staff = staff;
	}

	public Staff getEmp(String id) {

		for (int i = 0; i < staff.size(); i++) {
			if (staff.get(i).getEmpID().equals(id)) {
				return staff.get(i);
			}
		}
		return null;
	}

}
