package PassengerCheckInApp.dataClasses;

import java.util.HashMap;
import java.util.TreeMap;

import PassengerCheckInApp.Exception.*;

public class AllBooking {
	
private HashMap<String,Booking> bookingList;
	
	
	public AllBooking() 
	{
		bookingList = new HashMap<String,Booking>();
	}
		
	
	public Booking IsValidBooking(String BookingReference,String PassengerLName) throws  IllegalStateException
	{		
		if(BookingReference.trim().length()==0 || !BookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Booking Reference must be 3 characters followed by 3 digits");
			
		}
		Booking a = bookingList.get(BookingReference.toUpperCase());
		if(a!=null)
		{		
			
			/* Modified by Amer*/
			if (a.IsCheckedIn()==false) {
				
			if(a.getPassenger().getPassengerLName().toLowerCase().equals(PassengerLName.toLowerCase()))
			{
				return a;		
			}
			else
			{
				throw new IllegalStateException("Not a valid passenger name");
			}}else
			{
				throw new IllegalStateException("passenger has already checked-in");
			}
		}
		return null;
		
	}
	/* Added by Amer*/
	public boolean  IsValidBookingReference(String BookingReference) throws  IllegalStateException
	{		
		if(BookingReference.trim().length()==0 || !BookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Booking Reference must be 3 characters followed by 3 digits");
			
		}
		
		
		return true;
		
	}
	/* Added by Amer*/
	public boolean  IsValidFlightCode(String FlightCode) throws  IllegalStateException
	{		
		if(FlightCode.trim().length()==0 || !FlightCode.toUpperCase().matches("^[A-Za-z]{2}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Flight Code must be 2 characters followed by 3 digits");
			
		}
		
		
		return true;
		
	}
	
	public boolean UpdateCheckInStatus(String BookingReference,Integer CheckedInWeight,
							String BaggageDimension) throws InValidCheckInException
	{		
		Booking a = bookingList.get(BookingReference);
		if(a!=null)
		{
			bookingList.get(BookingReference).SetCheckedIn(CheckedInWeight,BaggageDimension);
			
			return true;
		}
		return false;
		
	}
	
	public void Add(Booking a) throws Exception
	{		
		/* Modified by Amer*/
		if (IsValidBookingReference(a.getBookingReference()))
			if (IsValidFlightCode(a.getFlightCode()))
		bookingList.put(a.getBookingReference(), a);	
	}
	
	public String BookingDetails()
	{
		StringBuffer allEntries=new StringBuffer();
		
		for(Booking details : bookingList.values())
		{
			allEntries.append(details.getBookingReference() + "		" + details.getPassenger().getPassengerFName()+ " " + details.getPassenger().getPassengerLName() + "		" + details.IsCheckedIn());
			allEntries.append('\n');
		}
		return allEntries.toString();
		
		
	}
	
	public HashMap<String,Booking> getAllBookings() 
	{
		return bookingList;
	}

}
