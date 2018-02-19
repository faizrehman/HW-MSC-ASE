/*Added By Faisal*/
public class CheckInSummaryReport  {
	
	private AllBooking bookings;
	private AllFlight flights;	
	
	public CheckInSummaryReport(AllBooking b,AllFlight f) throws IllegalArgumentException
	{
		if(b == null || f == null) 
		{			
			throw new IllegalArgumentException("Bookings & FlightInfo cannot be null");
		}
		this.bookings = b;
		this.flights = f;
	}
	
	public String getCheckInSummaryReport()
	{
		StringBuffer allEntries=new StringBuffer();
		
		allEntries.append( "Carrier Name" + "		" + "Booking Reference" + "		" + "Passenger Name" + "		" 
						+ "CheckIn Status" + "		" + "CheckedIn Weight (KG)");
		allEntries.append('\n');
		
		for(Booking details : bookings.getAllBookings().values())
		{
			allEntries.append( flights.getAllFlights().get(details.getFlightCode()).getCarrierName() + "			" + details.getBookingReference() + "			" 
								+ details.getPassengerName() + "			" + details.IsCheckedIn()
								+ "			" + details.getCheckedInWeight());
			allEntries.append('\n');
		}
		return allEntries.toString();
		
		
	}
	
}
