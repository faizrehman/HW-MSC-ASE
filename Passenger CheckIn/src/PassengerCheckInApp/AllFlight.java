package PassengerCheckInApp;
import java.util.HashMap;
/*Added By Faisal*/
public class AllFlight {

private HashMap<String,Flight> flightList;
	
	
	public AllFlight() 
	{
		flightList = new HashMap<String,Flight>();
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
	
	public void Add(Flight a) throws Exception
	{		
		/* Modified by Amer*/
		 if (IsValidFlightCode(a.getFlightCode()))
		flightList.put(a.getFlightCode(), a);	
	}
	
	public String FlightDetails()
	{
		StringBuffer allEntries=new StringBuffer();
		
		for(Flight details : flightList.values())
		{
			allEntries.append(details.getFlightCode() + "		" + details.getCarrier().getCarrierName());
			allEntries.append('\n');
		}
		return allEntries.toString();		
		
	}
	
	public HashMap<String,Flight> getAllFlights()
	{
		return flightList;
	}
}
