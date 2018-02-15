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
		
			if(a.getPassengerName().equals(PassengerName))
			{
				return a;		
			}
		}
		return null;
		
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
			allEntries.append(details.getBookingReference() + "		" + details.getPassengerName());
			allEntries.append('\n');
		}
		return allEntries.toString();
		
		
	}

}
