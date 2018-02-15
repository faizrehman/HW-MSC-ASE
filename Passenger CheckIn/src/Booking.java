public class Booking {
	
	
	private String  BookingReference;
	private String  PassengerName;
	private String  FlightCode;
	private boolean  CheckIn;
	
	
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

	public String getBookingReference() {		
		return BookingReference;
		
	}
	public String getPassengerName() {		
		return PassengerName;
		
	}

}
