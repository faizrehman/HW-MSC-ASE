package PassengerCheckInApp;

import java.io.FileNotFoundException;
import java.util.HashMap;

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
		
		/*Added By Amer Still need more*/
		StringBuffer allEntries=new StringBuffer();
		
		allEntries.append( "Carrier Name" + "		" + "Booking Reference" + "		" + "Passenger Name" + "		" 
						+ "CheckIn Status" + "		" + "CheckedIn Weight (KG)");
		allEntries.append('\n');
		
		for(Booking details : bookings.getAllBookings().values())
		{
			String getFlightCode =details.getFlightCode();
			
			HashMap<String,Flight> AllFlights =flights.getAllFlights();
		
			Flight flight=AllFlights.get(getFlightCode);
			if (flight==null) 
			{
				continue;
			}
			String carrierName =flight.getCarrier().getCarrierName();
			
			
			String Passenger=details.getPassenger().getPassengerFName() +" " + details.getPassenger().getPassengerLName();
			
			allEntries.append( carrierName + "			" + details.getBookingReference() + "			" + Passenger + "			" + details.IsCheckedIn() + "			" + details.getCheckedInWeight());
			
			allEntries.append('\n');
		}
		return allEntries.toString();
	
		
	}
	
}
