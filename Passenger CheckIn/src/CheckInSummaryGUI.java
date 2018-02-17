import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*Added by Faisal*/
public class CheckInSummaryGUI extends JFrame implements ActionListener {

private CheckInSummary checkInList;



JTextArea displayList;
JTextField searchField;

public CheckInSummaryGUI(CheckInSummary list)
{
	this.checkInList=list;
	setTitle("CheckIn");
	
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	JPanel searchPanel =new JPanel();
	searchPanel.setLayout(new GridLayout(1, 4));
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

	displayList.setText(checkInList.getCheckInSummary());
	
	pack();
	setVisible(true);
	

}

JTextField result;

JButton searchbutton;
JScrollPane scrollPane;

public void actionPerformed(ActionEvent e)
{
//displayList.setText(checkInList.BookingDetails());
}



public static void main (String arg[])
{
		
	//CheckInSummaryGUI sld=new CheckInSummaryGUI();
	//sld.showGUI();

	
}
	
	
}
