package JUnitTests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.junit.*;

import PassengerCheckInApp.*;

import org.junit.Test;

public class AllBookingTest {

	private AllBooking bookings;
	private AllFlight flights;
	
	@Before
	public void setUp() {
		
		PopulateAllBookings();
		PopulateAllFlights();
	 
	}

	public boolean PopulateAllBookings()
	{
		// Fetching Data from CSV and initializing and populating bookings object
		
				bookings = new AllBooking();
				Passenger PassengerData;
				int PassengerId=0;
				
				BufferedReader buff=null;
				String data []=new String[4];
				
				try {
					buff=new BufferedReader(new FileReader("bin/Bookings.txt"));
					String inputLine=buff.readLine();
					while(inputLine !=null) {
						data=inputLine.split(",");
						/* Added by Faisal*/
						int variableCount = data.length;
						
						if(variableCount == 5) 
						{
						
						String bookingReference = data[0].length() == 0 ? "" : data[0];
						String PassengerFName = data[1].length() == 0 ? "" : data[1];
						String PassengerLName = data[2].length() == 0 ? "" : data[2];
						String FlightCode = data[2].length() == 0 ? "" : data[2];
						String CheckIn = data[3].length() == 0 ? "" : data[3];
						
						/* Added by Amer*/
						PassengerId+=1;
						PassengerData = new Passenger(PassengerId, PassengerFName, PassengerLName);
						
						Booking b = new Booking(bookingReference, PassengerData,FlightCode,Boolean.getBoolean(CheckIn));
						bookings.Add(b);
						inputLine=buff.readLine();
						}
					}
					buff.close();
					
				}
				catch(FileNotFoundException e)
				{
					System.out.println(e.getMessage());
					return false;
					
					
				}
				catch(IllegalArgumentException e) 
				{

					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Booking found with in valid parametes","Alert", JOptionPane.ERROR_MESSAGE);
			    	return false;
					
				}
				catch(IOException e)
				{
					e.printStackTrace();
					return false;
					
					
				}

				return true;
		
	}
		
	public boolean PopulateAllFlights()
	{
		// Fetching Data from CSV and initializing and populating bookings object
		
				flights = new AllFlight();
				BufferedReader buff=null;
				String data []=new String[4];
				
				try {
					buff=new BufferedReader(new FileReader("bin/FlightsInfo.txt"));
					String inputLine=buff.readLine();
					while(inputLine !=null) {
						data=inputLine.split(",");
						/* Added by Faisal*/
						int variableCount = data.length;
						
						if(variableCount == 5) 
						{
							String FlightCode = data[0].length() == 0 ? "" : data[0];
							String CarrierName = data[1].length() == 0 ? "" : data[1];
							String FlightTime = data[2].length() == 0 ? "" : data[2];
							String MaxAllowedWeight = data[3].length() == 0 ? "" : data[3];	
							String ExtraChargePerKg = data[4].length() == 0 ? "" : data[4];
							
						Flight b = new Flight(FlightCode,CarrierName,FlightTime,Integer.parseInt(MaxAllowedWeight),Integer.parseInt(ExtraChargePerKg));
						flights.Add(b);
						inputLine=buff.readLine();
						
						}
					}
					/*Added by Faisal*/
					buff.close();
				}
				catch(FileNotFoundException e)
				{
					System.out.println(e.getMessage());
					return false;
					
					
				}
				catch(IllegalArgumentException e) 
				{

					e.printStackTrace();
					JOptionPane.showMessageDialog(null,"Flight Info with in valid parametes","Alert", JOptionPane.ERROR_MESSAGE);
			    	return false;
					
				}
				catch(IOException e)
				{
					e.printStackTrace();
					return false;
					
					
				}
				
				return true;
		
	}
	
	
	@Test
	public void testValidBookings() {
		String BookingReference="BRN001";
		String PassengerName="rree";
		assertEquals(bookings.getAllBookings().get(BookingReference), bookings.IsValidBooking(BookingReference, PassengerName));
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testInValidBookings() {
		String BookingReference="InvalidNumber";
		String PassengerName="Faizan";
		assertEquals(null, bookings.IsValidBooking(BookingReference, PassengerName));
	}

	@Test(expected = IllegalStateException.class)
	public  void blackBookingReferenceSupplied() {
	  bookings.IsValidBooking("", "");
	}
	
	@Test(expected = InValidCheckInException.class)
	public  void invalidBaggageDimensions() throws InValidCheckInException {
	  bookings.getAllBookings().get("BRN001").SetCheckedIn(30, "20abc");
	}
	
	@Test(expected = InValidCheckInException.class)
	public  void invalidCheckInWeight() throws InValidCheckInException {
	  bookings.getAllBookings().get("BRN001").SetCheckedIn(120, "20x20x20");
	}

	

}
