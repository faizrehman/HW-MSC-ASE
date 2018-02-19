package PassengerCheckInApp;
import java.util.Date;
/*Added By Faisal*/
public class Flight {
	
	private String  FlightCode;
	private String  CarrierName;
	private String  FlightTime;
	private Integer MaxAllowedWeight;	
	
	public Flight(String FlightCode, String CarrierName,
			String FlightTime,int MaxAllowedWeight)  throws IllegalArgumentException
	{
		/* Added by Faisal*/
		if(FlightCode.trim().length() == 0 || CarrierName.trim().length() == 0
				|| FlightTime.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("FlighCode, Carrier Name & Flight Time Cannot be blank");
		}
		this.FlightCode = FlightCode;
		this.CarrierName = CarrierName;
		this.FlightTime = FlightTime;
		this.MaxAllowedWeight = MaxAllowedWeight;		
		
	}
	
	public String getFlightCode() {		
		return FlightCode;		
	}

	public String getCarrierName() {		
		return CarrierName;
		
	}
	public String getFlightTime() {		
		return FlightTime;		
	}
	
	public Integer getMaxAllowedWeight() {		
		return MaxAllowedWeight;		
	}

}
