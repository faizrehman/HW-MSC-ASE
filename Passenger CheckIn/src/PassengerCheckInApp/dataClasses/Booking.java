package PassengerCheckInApp.dataClasses;
import javax.swing.JOptionPane;


import PassengerCheckInApp.Exception.*;
public class Booking {
	
	
	private String  BookingReference;
	private Passenger passenger;
	private String  FlightCode;
	private boolean CheckIn;
	private Integer CheckedInWeight;
	private String  BaggageDimension;

	public Booking(String BookingReference, Passenger PassengerData,
			String FlightCode,boolean CheckIn) throws IllegalArgumentException
	{
		
		/* Added by Faisal*/
		if(BookingReference.trim().length() == 0 || PassengerData == null
				|| FlightCode.trim().length() == 0) 
		{			
			throw new IllegalArgumentException("Booking Reference, Passenger Name & Flight Code Cannot be blank");
		}	
		
		this.BookingReference = BookingReference;
		this.passenger = PassengerData;
		this.FlightCode = FlightCode;
		this.CheckIn = CheckIn;		
				
	}
	public boolean IsCheckedIn() {		
		return CheckIn;
		
	}
	
	
	
	/*Added By Faisal*/
	public void SetCheckedIn(Integer CheckedInWeight,String BaggageDimension ) throws InValidCheckInException
	{			
	

			Integer length,breadth,height;
		if(BaggageDimension.matches("\\d{2}x\\d{2}x\\d{2}"))
		{
			String[] dimension=BaggageDimension.split("x");
		 	length =Integer.parseInt(dimension[0]); // l
			breadth =Integer.parseInt(dimension[1]); // b
			height =Integer.parseInt(dimension[2]); // h 
			
			if(length > 20 || breadth > 20 || height > 20 || CheckedInWeight > 100)
			{

				throw new InValidCheckInException();
			}
			else
			{	this.CheckIn=true;
			this.CheckedInWeight=CheckedInWeight;
			this.BaggageDimension=BaggageDimension;
			}
		}
		else
		{

			throw new InValidCheckInException();
		}
			
					
				
	}

	
	public String getBookingReference() {		
		return BookingReference;
		
	}
	public Passenger getPassenger() {		
		return passenger;
		
	}
	
	public String getFlightCode() {
		
		return FlightCode;
	}
	

	public Integer getCheckedInWeight() {
		return CheckedInWeight;
	}
/*Added By Faisal*/
	public void setCheckedInWeight(Integer checkedInWeight) throws InValidCheckInException {
		
			if(checkedInWeight == 0)
			{
				throw new InValidCheckInException();
			}			
			else
			{
				CheckedInWeight = checkedInWeight;
			
			}
	}

	public String getBaggageDimension() {
		return BaggageDimension;
	}

	public void setBaggageDimension(String baggageDimension) {
		
		BaggageDimension = baggageDimension;
	}
	
	
	
	

}
