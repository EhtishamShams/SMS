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
	private float perCreditHrFee;
	private Date feeDueDate = null;

	public Semester(String session, boolean active, float perCreditHrFee) {
		super();
		this.session = session;
		this.active = active;
		this.perCreditHrFee = perCreditHrFee;
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

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getPerCreditHrFee() {
		return perCreditHrFee;
	}

	public void setPerCreditHrFee(float perCreditHrFee) {
		this.perCreditHrFee = perCreditHrFee;
	}

	public Date getFeeDueDate() {
		return feeDueDate;
	}

	public void setFeeDueDate(Date feeDueDate) {
		this.feeDueDate = feeDueDate;
	}
	
	
	
}
