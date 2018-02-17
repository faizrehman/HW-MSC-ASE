  public class Booking {
	
	
	private String  BookingReference;
	private String  PassengerName;
	private String  FlightCode;
	private boolean CheckIn;
	/*Added by Faisal*/
	private Flight 	FlightObject;
	
	
	public Booking(String BookingReference, String PassengerName,
			String FlightCode,boolean CheckIn) 
	{
		this.BookingReference = BookingReference;
		this.PassengerName = PassengerName;
		this.FlightCode = FlightCode;
		this.CheckIn = CheckIn;
				
	}
	
	public boolean IsCheckedIn() {		
		return CheckIn;
		
	}
	public void SetCheckedIn() {		
		this.CheckIn=true;
		
	}

	
	public String getBookingReference() {		
		return BookingReference;
		
	}
	public String getPassengerName() {		
		return PassengerName;
		
	}
	
	public String getFlightCode() {
		
		return FlightCode;
	}
	/*Added by Faisal*/
	public void setFlightObject(Flight f) 
	{
		this.FlightObject = f;
	}
	public Flight getFlightObject() 
	{
		return FlightObject;
	}
	
	
	
	

}
