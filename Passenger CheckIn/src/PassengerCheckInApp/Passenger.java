package PassengerCheckInApp;

import java.sql.Date;
/*Added By Amer*/ 
public class Passenger {

	public Passenger(Integer passengerId, String passengerFName, String passengerLName) throws IllegalArgumentException{
		super();
		if(passengerId == 0 || passengerFName.trim().length() == 0
				|| passengerLName.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("passenger Id, passenger First Name  & passenger lat Name  Cannot be blank");
		}
		this.passengerId = passengerId;
		this.passengerFName = passengerFName;
		this.passengerLName = passengerLName;
	}

	public Passenger(Integer passengerId, String passengerFName, String passengerLName, String address,
			String mobileNumber, Date dOB) throws IllegalArgumentException {
		super();
		
	
		if(passengerId == 0 || passengerFName.trim().length() == 0
				|| passengerLName.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("passenger Id, passenger First Name  & passenger lat Name  Cannot be blank");
		}
		this.passengerId = passengerId;
		this.passengerFName = passengerFName;
		this.passengerLName = passengerLName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		DOB = dOB;
	}

	private Integer passengerId;
	private String  passengerFName;
	private String  passengerLName;
	private String  address;
	private String  mobileNumber;
	private Date  DOB;
	
	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerFName() {
		return passengerFName;
	}
	public String getPassengerFullName() {
		return passengerFName+" " + passengerLName;
	}
	public void setPassengerFName(String passengerFName) {
		this.passengerFName = passengerFName;
	}

	public String getPassengerLName() {
		return passengerLName;
	}

	public void setPassengerLName(String passengerLName) {
		this.passengerLName = passengerLName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}




}
