package PassengerCheckInApp;

/*Added By Amer*/
public class Carrier {
	private Integer carrierId;
	private String  carrierName;
	
	
	public Carrier(String carrierName) {
		super();
		this.carrierName = carrierName;
	}


	public Carrier(Integer carrierId, String carrierName)  throws IllegalArgumentException
	 {
		super();
		
		if(carrierName.trim().length() == 0 ) 
		{
			
			throw new IllegalArgumentException("Carrier Name Cannot be blank");
		}
		this.carrierId = carrierId;
		this.carrierName = carrierName;
	}


	public Integer getCarrierId() {
		return carrierId;
	}


	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}


	public String getCarrierName() {
		return carrierName;
	}


	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


}
