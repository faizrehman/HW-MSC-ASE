import java.util.HashMap;
import java.util.TreeMap;

public class AllBooking {
	
private HashMap<String,Booking> bookingList;
	
	
	public AllBooking() 
	{
		bookingList = new HashMap<String,Booking>();
	}
	
	public Booking FindbyName(String BookingReference,String PassengerName)
	{		
		Booking a = bookingList.get(BookingReference);
		if(a!=null)
		{
		
			if(a.getPassengerName().toLowerCase().equals(PassengerName.toLowerCase()))
			{
				return a;		
			}
		}
		return null;
		
	}
	
	
	public boolean IsValidBooking(String BookingReference,String PassengerName)
	{		
		Booking a = bookingList.get(BookingReference);
		if(a!=null)
		{
		
			if(a.getPassengerName().toLowerCase().equals(PassengerName.toLowerCase()))
			{
				return true;		
			}
		}
		return false;
		
	}
	
	public boolean UpdateCheckInStatus(String BookingReference)
	{		
		Booking a = bookingList.get(BookingReference);
		if(a!=null)
		{
			bookingList.get(BookingReference).SetCheckedIn();
			
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
