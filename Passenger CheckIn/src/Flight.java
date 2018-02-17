import java.util.Date;
/*Added By Faisal*/
public class Flight {
	
	private String  FlightCode;
	private String  CarrierName;
	private Date  FlightTime;
	private Integer MaxAllowedWeight;	
	
	public Flight(String FlightCode, String CarrierName,
			Date FlightTime,int MaxAllowedWeight) 
	{
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
	public Date getFlightTime() {		
		return FlightTime;		
	}
	
	public Integer getMaxAllowedWeight() {		
		return MaxAllowedWeight;		
	}

}
