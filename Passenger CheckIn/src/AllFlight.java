import java.util.HashMap;
/*Added By Faisal*/
public class AllFlight {

private HashMap<String,Flight> flightList;
	
	
	public AllFlight() 
	{
		flightList = new HashMap<String,Flight>();
	}
	
	public Flight Find(String FlightCode,String Name)
	{		
		Flight a = flightList.get(FlightCode);
		if(a!=null)
		{
		
			if(a.getCarrierName().equals(Name))
			{
				return a;		
			}
		}
		return null;
		
	}
	
	public void Add(Flight a) 
	{		
		flightList.put(a.getFlightCode(), a);	
	}
	
	public String FlightDetails()
	{
		StringBuffer allEntries=new StringBuffer();
		
		for(Flight details : flightList.values())
		{
			allEntries.append(details.getFlightCode() + "		" + details.getCarrierName());
			allEntries.append('\n');
		}
		return allEntries.toString();		
		
	}
	
	public HashMap<String,Flight> getAllFlights()
	{
		return flightList;
	}
}
