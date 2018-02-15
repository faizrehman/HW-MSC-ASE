import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AllBookingDemo {
	
	private AllBooking bookings;
	private AllBookingGUI gui;
	
	
	public AllBookingDemo()
	{
		bookings = new AllBooking();
		
		BufferedReader buff=null;
		String data []=new String[4];
		try {
			buff=new BufferedReader(new FileReader("C:\\Users\\mfais\\eclipse-workspace\\BaggageCheckIn\\src\\Bookings.txt"));
			String inputLine=buff.readLine();
			while(inputLine !=null) {
				data=inputLine.split(",");
				Booking b = new Booking(data[0], data[1], data[2],Boolean.getBoolean(data[3]));
				bookings.Add(b);
				inputLine=buff.readLine();
			}
			
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.exit(1);
			
		}
		
		
		
	}

	public void showGUI()
	{
		
		gui=new AllBookingGUI(bookings);
		gui.setVisible(true);
		
	}
	
	
	public static void main (String arg[])
	{
		
		AllBookingDemo sld=new AllBookingDemo();
		sld.showGUI();
	
	}
	
}
