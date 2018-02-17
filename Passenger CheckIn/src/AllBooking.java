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
		if(BookingReference.trim().length()==0)
		{
			throw new IllegalStateException("Booking Reference or Passenger Last name cannot be blank");
			
		}
		Booking a = bookingList.get(BookingReference.toUpperCase());
		if(a!=null)
		{
		
			if(a.getPassengerName().toLowerCase().equals(PassengerName.toLowerCase()))
			{
				return a;		
			}
		}
		return null;
		
	}
	
	public boolean UpdateCheckInStatus(String BookingReference,Integer CheckedInWeight,
							String BaggageDimension )
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
