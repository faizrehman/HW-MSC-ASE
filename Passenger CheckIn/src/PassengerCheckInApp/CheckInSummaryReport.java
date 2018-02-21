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
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}
	public String getCheckInSummaryReport()
	{
		
		/*Added By Amer Still need more*/
		StringBuffer allEntries=new StringBuffer();
		String space10 = new String(new char[2]).replace('\0', '|');
		
		
		
		allEntries.append( fixedLengthString("Carrier Name",20) + space10 + fixedLengthString("Booking Reference",17) + space10 + fixedLengthString("Passenger Name",25) + space10 
						+ fixedLengthString("CheckIn Status",14) + space10 + fixedLengthString("CheckedIn Weight (KG)",21));
		allEntries.append('\n');

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
	
			
			allEntries.append( fixedLengthString(carrierName,20) + space10 + fixedLengthString(details.getBookingReference(),17) + space10 +
					fixedLengthString(Passenger,25)+ space10 + fixedLengthString(String.valueOf(details.IsCheckedIn()),14)+ space10 + fixedLengthString(String.valueOf(details.getCheckedInWeight()),21));
			
			allEntries.append('\n');
		}
		return allEntries.toString();
	
		
	}
	
}
