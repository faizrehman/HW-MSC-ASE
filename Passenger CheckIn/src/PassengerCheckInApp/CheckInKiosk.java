package PassengerCheckInApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author faizanrehman
 *
 */
public class CheckInKiosk extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	private AllBooking bookings;
	private AllFlight flights;
	private CheckInSummaryReport checkInSummary;
	private CheckInSummaryGUI ViewReport;
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JButton jButtonCheckIn;
	private JButton jButtonViewReport;
	
	// Constructor of a class
	public CheckInKiosk() throws IllegalArgumentException{
		
		/* Modified by Amer*/
		
		String bookingsPath="/Users/amer/git/HW-MSC-ASE/Passenger CheckIn/bin/Bookings_MOCK_DATA500.txt";
		String flightsPath="/Users/amer/git/HW-MSC-ASE/Passenger CheckIn/bin/FlightsInfo_MOCK_DATA50.txt";
		
//		String bookingsPath,flightsPath="";
		
//		Scanner reader = new Scanner(System.in);  // Reading from System.in
//		
//		//read the booking file path
//		System.out.println("Enter a Bookings file Path: ");
//		bookingsPath = reader.nextLine(); // Scans the input as a string.
//		System.out.println("Selected booking file path " + bookingsPath);
//		
//		//read the flight path
//		System.out.println("Enter a Flights file Path: ");
//		flightsPath =reader.nextLine(); // Scans  the input as a string.
//		System.out.println("Selected flights file Path " + flightsPath);
//		
//		//once finished close the reader
//		reader.close(); 
		
		
		if(bookingsPath.trim().length() == 0 || flightsPath.trim().length() == 0) 
		{
			
			throw new IllegalArgumentException("the files path Cannot be blank");
		}
		
		//Populate all bookings from CSV
		boolean retSuccessBookings = PopulateAllBookings(bookingsPath);
		boolean retSuccessFlights = PopulateAllFlights(flightsPath);
		
		if (retSuccessBookings==false || retSuccessFlights ==false)
			System.exit(1);
		
     	prepareGUI();
	}
	
	private void prepareGUI(){
	      mainFrame = new JFrame("Check-In Kiosk");
	      mainFrame.setSize(300,300);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,100);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	
	//Create a Welcome screen with options: Check-In, View Report
	public boolean ShowWelcomeGUI()
	{
		
		
		headerLabel.setText("Welcome To Check-In Kiosk");      
	      
	      JPanel panel = new JPanel();
	      panel.setBackground(Color.darkGray);
	      panel.setSize(300,500);
	      GridLayout layout = new GridLayout(0,2);
	      layout.setHgap(10);
	      layout.setVgap(10);
	      
	      panel.setLayout(layout);   
	      
	      jButtonCheckIn=new JButton("Check-In");
	      jButtonCheckIn.setActionCommand("Check-In");
	      jButtonCheckIn.addActionListener(this);
	  	
	      panel.add(jButtonCheckIn);
	      
	      jButtonViewReport=new JButton("View Report");
	      jButtonViewReport.setName("ViewReport");
	      jButtonViewReport.addActionListener(this);
	      jButtonViewReport.setActionCommand("View Report");
	      panel.add(jButtonViewReport); 
	     
	      controlPanel.add(panel);
	      mainFrame.setLocationRelativeTo(null);

	      mainFrame.setVisible(true);  
		
		return true;
	}
	
	public boolean PopulateAllBookings(String filePath)
	{
		// Fetching Data from CSV and initializing and populating bookings object
		
				bookings = new AllBooking();
				Passenger PassengerData;
				int PassengerId=0;
				BufferedReader buff=null;
				String data []=new String[4];
				
				try {
					buff=new BufferedReader(new FileReader(filePath));
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
						String FlightCode = data[2].length() == 0 ? "" : data[3];
						String CheckIn = data[3].length() == 0 ? "" : data[4];
						
						/* Added by Amer*/
//						Iterator<Booking> items = bookings.getAllBookings().values().iterator();
//						boolean Passengerexist;
//						while (items.hasNext()) {
//						if(PassengerFName+" " + PassengerLName ==items.next().getPassenger().getPassengerFullName()){
//							Passengerexist=true;
//							continue; 			
//							}
//						
//										}
						
						PassengerId+=1;
						PassengerData = new Passenger(PassengerId, PassengerFName, PassengerLName);		
						Booking b = new Booking(bookingReference, PassengerData,FlightCode,Boolean.getBoolean(CheckIn));
						
						/* Added by Amer*/
						try {
							bookings.Add(b);
						} catch (Exception e) {
							System.out.println( e.getMessage() + ".  booking ref :  " + b.getBookingReference() + " has not added");
							b=null;
						}

						
						inputLine=buff.readLine();
						} 
						/* Added by Amer*/
						else {
							System.out.println("the booking files is not correct format, please check the formate and then rerun the application");
							System.exit(ERROR);
						}
						
					}
					
					
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
	
	public boolean PopulateAllFlights(String filePath)
	{
		// Fetching Data from CSV and initializing and populating bookings object
		
				flights = new AllFlight();
				
				Carrier carrierData;
				int carrierId=0;
				
				BufferedReader buff=null;
				String data []=new String[4];
				
				try {
					buff=new BufferedReader(new FileReader(filePath));
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
						/* Added by Amer*/
						carrierId+=1;
						carrierData = new Carrier(carrierId,CarrierName );	
						Flight b = new Flight(FlightCode,carrierData,FlightTime,Integer.parseInt(MaxAllowedWeight),Integer.parseInt(ExtraChargePerKg));
						flights.Add(b);
						inputLine=buff.readLine();
						
						}
						/* Added by Amer*/
						else {
							System.out.println("the Flight file is not correct format, please check the formate and then rerun the application");
							System.exit(ERROR);
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckInKiosk welcomeDemo = new CheckInKiosk();  
		welcomeDemo.ShowWelcomeGUI();     

	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==jButtonCheckIn)
		{
			 String[] labels = { "Last Name", "Booking Reference", "Baggage Weight", "Baggage Dimensions" };
			    char[] mnemonics = { 'F', 'M', 'L', 'A' };
			    int[] widths = { 15, 15, 8, 12 };
			    String[] descs = { "Last Name", "Booking Reference", "Baggage Weight", "Dimensions" };

			    final CheckInGUI form = new CheckInGUI(labels, mnemonics, widths, descs);

			    JFrame f = new JFrame("Passeneger Check-In");
			    f.getContentPane().add(form, BorderLayout.NORTH);
			    JPanel p = new JPanel();
			    
			    JButton submit = new JButton("Submit Form");  
			    submit.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent e) {
				    	 
				    	  try
				    	  {
				    	  Booking retbooking=bookings.IsValidBooking(form.getText(1).toUpperCase(), form.getText(0));
				    	  
				    	  if(retbooking!=null)
				    	  {
				    		  				    		  
				    		  Flight fl = flights.getAllFlights().get(retbooking.getFlightCode());
				    		  Integer weightDifference=Integer.parseInt(form.getText(2)) - fl.getMaxAllowedWeight();
				    		  Integer extraChargePerKg = fl.getExtraChargePerKg();
				    		  if(weightDifference>0)
				    		  {
				    			  Integer extracharge = weightDifference * extraChargePerKg;
				    			  String answer =            
				    			          JOptionPane.showInputDialog 
				    			          ( "Baggage weight exceed by " + weightDifference.toString() + "KG?, Extra Luggage cost will be " + extracharge +" $, Write yes if you want to pay and "
				    			          		+ "proceed with this weight" );
				    			  
				    			  if(answer == null || (answer != null && ("".equals(answer))))   
				    			  {
				    			    return;  
				    			  }
				    			  if (!answer.equals("yes"))
				    			  {
				    				  JOptionPane.showMessageDialog(rootPane, "Kindly adjust your baggage weight and Check-In again.");
						    		  f.setVisible(false);
						    		  return;
						    	 
				    			  }
				    		  }
				    		  
				    		  
				    		  bookings.UpdateCheckInStatus(form.getText(1).toUpperCase(),Integer.parseInt(form.getText(2)),form.getText(3));
				    		  if(ViewReport!=null)
				    			  ViewReport.RefreshReport();
				    		  
				    		  JOptionPane.showMessageDialog(rootPane, "Checked In successfully");
				    		  f.setVisible(false);
				    	  
				    	  }
				    	  else
				    	  {
				    		  JOptionPane.showMessageDialog(rootPane, "Please enter a valid Booking details");
				    		  
				    	  }
				    	  
				    	  System.out.println(bookings.BookingDetails());
				      }
				    	  catch(InValidCheckInException ex)
				    	  {
				    		  JOptionPane.showMessageDialog(null, ex.getMessage(),"Alert", JOptionPane.ERROR_MESSAGE);
				    	  }
				    	  catch(NumberFormatException ex)
				    	  {
				    		  JOptionPane.showMessageDialog(null,"Baggage Weight and Dimension should be in number format","Alert", JOptionPane.ERROR_MESSAGE);

				    	  }
				    	  catch(IllegalStateException ex)
				    	  {
				    		  
				    		  JOptionPane.showMessageDialog(rootPane, ex.getMessage());
						    	  
				    	  }
				    	  
				    	  finally{}
				    	  
				      }
				    });
			    
			    p.add(submit);
			    f.getContentPane().add(p, BorderLayout.SOUTH);
			    f.pack();
			    f.setLocationRelativeTo(null);
			    f.setVisible(true);
			   
		}
		if(e.getSource()==jButtonViewReport)
		{
			
			
			checkInSummary=new CheckInSummaryReport(bookings, flights);
			ViewReport=new CheckInSummaryGUI(checkInSummary);
		 	ViewReport.setVisible(true);
		 	
		}
		
	}

}
