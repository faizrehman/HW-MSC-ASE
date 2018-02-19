package PassengerCheckInApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*Added by Faisal*/
public class CheckInSummaryGUI extends JFrame implements ActionListener {

private CheckInSummaryReport checkInList;
JButton refresh;

JTextArea displayList;


public CheckInSummaryGUI(CheckInSummaryReport list)
{
	/* Added by Faisal*/
	if(list == null) 
	{		
		throw new IllegalArgumentException("CheckInSummaryReport list cannot be blank");
	}
	
	this.checkInList=list;
	setTitle("Check In Summary");
	
	
	 //search panel contains label, text field and button
    JPanel searchPanel = new JPanel();
    searchPanel.setLayout(new GridLayout(1,3));
    searchPanel.add(new JLabel("Press button to refresh the report"));   
    refresh = new JButton("Refresh Report");  
    searchPanel.add(refresh);    
    //specify action when button is pressed
    refresh.addActionListener(this) ;
    
    
  //set up south panel containing 2 previous areas
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(2,1));
    southPanel.add(searchPanel);
   
	Container contentPane  = getContentPane();
	contentPane.setPreferredSize(new Dimension(1000, 300));
	contentPane.add(southPanel, BorderLayout.SOUTH);
	
	displayList = new JTextArea(15,20);
	displayList.setFont(new Font(Font.MONOSPACED,Font.PLAIN,14));
	displayList.setEditable(false);
	scrollPane=new JScrollPane(displayList);
	
	scrollPane.setSize(600, 300);
	
	contentPane.add(scrollPane,BorderLayout.CENTER);

	displayList.setText(checkInList.getCheckInSummaryReport());
	
	pack();
	setVisible(true);
	

}

public void RefreshReport()
{
	displayList.setText(checkInList.getCheckInSummaryReport());
}

JScrollPane scrollPane;	
public void actionPerformed(ActionEvent e) 
{ 
	if (e.getSource() == refresh) {
		displayList.setText(checkInList.getCheckInSummaryReport());
	}
}  

}

