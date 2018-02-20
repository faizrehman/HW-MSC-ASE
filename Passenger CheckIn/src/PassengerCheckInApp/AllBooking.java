package PassengerCheckInApp;

import java.util.HashMap;
import java.util.TreeMap;

public class AllBooking {
	
private HashMap<String,Booking> bookingList;
	
	
	public AllBooking() 
	{
		bookingList = new HashMap<String,Booking>();
	}
		
	
	public Booking IsValidBooking(String BookingReference,String PassengerName) throws  IllegalStateException
	{		
		if(BookingReference.trim().length()==0 || !BookingReference.toUpperCase().matches("^[A-Za-z]{3}[0-9]{3}\\z"))
		{
			throw new IllegalStateException("Booking Reference must be 3 characters followed by 3 digits");
			
		}
		Booking a = bookingList.get(BookingReference.toUpperCase());
		if(a!=null)
		{		
			if(a.getPassengerName().toLowerCase().equals(PassengerName.toLowerCase()))
			{
				return a;		
			}
			else
			{
				throw new IllegalStateException("Not a valid passenger name");
			}
		}
		return null;
		
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
	
	public void Add(Booking a) 
	{		
		bookingList.put(a.getBookingReference(), a);	
	}
	
	public String BookingDetails()
	{
		StringBuffer allEntries=new StringBuffer();
		
		for(Booking details : bookingList.values())
		{
			allEntries.append(details.getBookingReference() + "		" + details.getPassengerName() + "		" + details.IsCheckedIn());
			allEntries.append('\n');
		}
		return allEntries.toString();
		
		
	}
	
	public HashMap<String,Booking> getAllBookings() 
	{
		return bookingList;
	}

}
