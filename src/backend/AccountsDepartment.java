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
public class AccountsDepartment extends Department {

	private ArrayList<Pay> pays;
	private ArrayList<Fee> fees;

	public AccountsDepartment(ArrayList<Pay> pays, ArrayList<Fee> fees, String name, ArrayList<Staff> staff) {
		super(name, staff);
		this.pays = pays;
		this.fees = fees;
	}

	public ArrayList<Pay> getPays() {
		return pays;
	}

	public void setPays(ArrayList<Pay> pays) {
		this.pays = pays;
	}

	public ArrayList<Fee> getFees() {
		return fees;
	}

	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}

}
