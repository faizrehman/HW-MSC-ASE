import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AllBookingGUI extends JFrame implements ActionListener
{
private AllBooking bookingList;

//GUI components
	
JTextArea displayList;
JTextField searchField;

public AllBookingGUI(AllBooking list)
{
	this.bookingList=list;
	setTitle("Bookings");
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	JPanel searchPanel =new JPanel();
	searchPanel.setLayout(new GridLayout(1, 3));
	searchPanel.add(new JLabel("Booking Reference"));
	searchField = new JTextField(5);
	searchPanel.add(searchField);
	
	searchbutton=new JButton("Search");
	searchPanel.add(searchbutton);
	
	searchbutton.addActionListener(this);
	
	result=new JTextField(25);
	result.setEditable(false);
	
	JPanel southPanel=new JPanel();
	southPanel.setLayout(new GridLayout(2, 1));
	southPanel.add(searchPanel);
	
	southPanel.add(result);
	
	Container contentPane  = getContentPane();
	contentPane.add(southPanel, BorderLayout.SOUTH);
	
	displayList = new JTextArea(15,20);
	displayList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,14));
	displayList.setEditable(false);
	scrollPane=new JScrollPane(displayList);
	
	contentPane.add(scrollPane,BorderLayout.CENTER);
	
	pack();
	setVisible(true);
	

}

JTextField result;

JButton searchbutton;
JScrollPane scrollPane;

public void actionPerformed(ActionEvent e)
{
	displayList.setText(bookingList.BookingDetails());
}

}
