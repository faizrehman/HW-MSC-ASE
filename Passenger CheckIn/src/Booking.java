import javax.swing.JOptionPane;

public class Booking {
	
	
	private String  BookingReference;
	private String  PassengerName;
	private String  FlightCode;
	private boolean CheckIn;
	private Integer CheckedInWeight;
	private String  BaggageDimension;
	
	
	public Booking(String BookingReference, String PassengerName,
			String FlightCode,boolean CheckIn) 
	{
		
		/* Added by Faisal*/
		if(BookingReference.trim().length() == 0 || PassengerName.trim().length() == 0
				|| FlightCode.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("Booking Reference, Passenger Name & Flight Code Cannot be blank");
		}
		this.BookingReference = BookingReference;
		this.PassengerName = PassengerName;
		this.FlightCode = FlightCode;
		this.CheckIn = CheckIn;		
				
	}
	
	public boolean IsCheckedIn() {		
		return CheckIn;
		
	}
	/*Added By Faisal*/
	public void SetCheckedIn(Integer CheckedInWeight,
			String BaggageDimension ) {	
		try
		{
			if(CheckedInWeight == 0)
			{
				throw new ZeroCheckedInWeight();
			}			
			else
			{
				this.CheckIn=true;
				this.CheckedInWeight=CheckedInWeight;
				this.BaggageDimension=BaggageDimension;
			}
			
			
		}
		catch(ZeroCheckedInWeight e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Alert", JOptionPane.ERROR_MESSAGE);
		}		
		
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
/*Added By Faisal*/
	public void setCheckedInWeight(Integer checkedInWeight) throws ZeroCheckedInWeight {
		
		try
		{
			if(checkedInWeight == 0)
			{
				throw new ZeroCheckedInWeight();
			}			
			else
				CheckedInWeight = checkedInWeight;
			
		}
		catch(ZeroCheckedInWeight e) 
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Alert", JOptionPane.ERROR_MESSAGE);
		}			
		
	}

	public String getBaggageDimension() {
		return BaggageDimension;
	}

	public void setBaggageDimension(String baggageDimension) {
		
		BaggageDimension = baggageDimension;
	}
	
	
	
	

}
