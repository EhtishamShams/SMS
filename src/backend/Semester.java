/**
 * 
 */
package backend;

import java.sql.Date;

/**
 * @author Ehtisham
 *
 */
public class Semester {
	private String session;
	private boolean active;
	double perCreditHourFee;
	Date dueDate;
	
	public Semester(String session, boolean active, double perCreditHourFee, Date dueDate) {
		this.session = session;
		this.active = active;
		this.perCreditHourFee = perCreditHourFee;
		this.dueDate = dueDate;
	}

	public double getPerCreditHourFee() {
		return perCreditHourFee;
	}

	public void setPerCreditHourFee(double perCreditHourFee) {
		this.perCreditHourFee = perCreditHourFee;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	public boolean isActive() {
		return active;
	}
}
