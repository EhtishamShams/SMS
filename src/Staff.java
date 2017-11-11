
import java.util.Date;

public class Staff extends User{

	protected String empID;
	protected Date dateHired;
	
	public Staff(String empID, Date dateHired) 
	{
    
	}
	
	public boolean updateDetails(String name, Date DOB, String phoneNo, String email, String CNIC, char gender, String emergencyContact,
			String address)
	{
		return false;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}
	
	
	
	

}
