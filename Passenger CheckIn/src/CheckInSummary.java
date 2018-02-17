/*Added By Faisal*/
public class CheckInSummary  {
	
	private AllBooking bookingList;	
	
	public CheckInSummary(AllBooking bookingList,AllFlight f) 
	{
		for(Booking bk : bookingList.getAllBookings().values()) 
		{
			
			for(Flight fl : f.getAllFlights().values())
			{
				if(bk.getFlightCode().equals(fl.getFlightCode())) 
				{
					bk.setFlightObject(fl);
				}
			}
		}
		
		this.bookingList = bookingList;
	}
	
	public AllBooking getBookingList() 
	{
		return bookingList;
				
	}

	
}
