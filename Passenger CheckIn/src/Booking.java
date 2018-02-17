  public class Booking {
	
	
	private String  BookingReference;
	private String  PassengerName;
	private String  FlightCode;
	private boolean CheckIn;
	private Integer  CheckedInWeight;
	private String  BaggageDimension;
	
	
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
	public void SetCheckedIn(Integer CheckedInWeight,
			String BaggageDimension ) {		
		this.CheckIn=true;
		this.CheckedInWeight=CheckedInWeight;
		this.BaggageDimension=BaggageDimension;
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
	

	public Integer getCheckedInWeight() {
		return CheckedInWeight;
	}

	public void setCheckedInWeight(Integer checkedInWeight) {
		CheckedInWeight = checkedInWeight;
	}

	public String getBaggageDimension() {
		return BaggageDimension;
	}

	public void setBaggageDimension(String baggageDimension) {
		BaggageDimension = baggageDimension;
	}
	
	
	
	

}
