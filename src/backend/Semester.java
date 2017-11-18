/**
 * 
 */
package backend;

import java.util.Date;

/**
 * @author Ehtisham
 *
 */
public class Semester {
	private String session;
	private Date year;
	
	public Semester(String session, Date year) {
		this.session = session;
		this.year = year;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
	
}
