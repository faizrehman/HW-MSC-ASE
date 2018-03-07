package PassengerCheckInApp.dataClasses;
/*Added By Faisal*/
public class Flight {
	
	private String  FlightCode;
	private Carrier  carrier;
	private String  FlightTime;
	private Integer MaxAllowedWeight;	
	private Integer ExtraChargePerKg;
	
	public Flight(String FlightCode, Carrier Carrier,
			String FlightTime,int MaxAllowedWeight,Integer ExtraChargePerKg)  throws IllegalArgumentException
	{
		
		/* Added by Faisal*/
		if(FlightCode.trim().length() == 0 || Carrier ==null
				|| FlightTime.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("FlighCode, Carrier Name & Flight Time Cannot be blank");
		}
		this.FlightCode = FlightCode;
		this.carrier = Carrier;
		this.FlightTime = FlightTime;
		this.MaxAllowedWeight = MaxAllowedWeight;	
		this.ExtraChargePerKg = ExtraChargePerKg;
		
	}
	
	public String getFlightCode() {		
		return FlightCode;		
	}

	public Carrier getCarrier() {		
		return carrier;
		
	}
	public String getFlightTime() {		
		return FlightTime;		
	}
	
	public Integer getMaxAllowedWeight() {		
		return MaxAllowedWeight;		
	}
	
	public Integer getExtraChargePerKg() 
	{
		return ExtraChargePerKg;
	}

}
