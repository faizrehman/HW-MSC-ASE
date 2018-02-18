@SuppressWarnings("serial")
public class InValidCheckInException  extends Exception{

	
	public InValidCheckInException() 
	{		
		super("Max Baggage/person <= 100 kg & Dimensions should be <= 20x20x20 (LxBxH)");	
		
	}
}
