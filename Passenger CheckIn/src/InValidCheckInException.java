@SuppressWarnings("serial")
public class InValidCheckInException  extends Exception{

	
	public InValidCheckInException() 
	{		
		super("Max Baggage/person < 100 kg & Dimensions < 19x19x19 (LxBxH)");	
		
	}
}
