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

	
	public String getCheckInSummary()
	{
		StringBuffer allEntries=new StringBuffer();
		
		allEntries.append( "Carrier Name" + "		" + "Booking Reference" + "		" + "Passenger Name" + "		" + "CheckIn Status");
		allEntries.append('\n');
		
		for(Booking details : bookingList.getAllBookings().values())
		{
			allEntries.append( details.getFlightObject().getCarrierName() + "			" + details.getBookingReference() + "			" + details.getPassengerName() + "			" + details.IsCheckedIn());
			allEntries.append('\n');
		}
		return allEntries.toString();
		
		
	}
	
}
