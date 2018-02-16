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
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JLabel msglabel;
	private JButton jButtonCheckIn;
	private JButton jButtonViewReport;
	
	// Constructor of a class
	public CheckInKiosk(){
		
		prepareGUI();
		
		//Populate all bookings from CSV
		boolean retSuccess = PopulateAllBookings();
		if (retSuccess==false)
			System.exit(1);
		
		
		
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
		
		
		headerLabel.setText("Welcome To CheckIn Kiosk");      
	      
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
	      mainFrame.setVisible(true);  
		
		return true;
	}
	
	public boolean PopulateAllBookings()
	{
		// Fetching Data from CSV and initializing and populating bookings object
		
				bookings = new AllBooking();
				BufferedReader buff=null;
				String data []=new String[4];
				
				try {
					buff=new BufferedReader(new FileReader("bin/Bookings.txt"));
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
		
		//JOptionPane.showMessageDialog(rootPane, e.getSource().toString());
		//String actionCommand= e.getActionCommand().tex
		
		if(e.getSource()==jButtonCheckIn)
		{
			JOptionPane.showMessageDialog(rootPane, "Check In Button Clicked");
		}
		if(e.getSource()==jButtonViewReport)
		{
			JOptionPane.showMessageDialog(rootPane, "View Report Button Clicked");
		}
		
	}

}
