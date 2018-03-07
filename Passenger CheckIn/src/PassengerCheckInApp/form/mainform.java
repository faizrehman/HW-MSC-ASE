package PassengerCheckInApp.form;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainform extends JFrame {

	private JPanel contentPane;
	private JTable table_allPassanger;
	private String[] allPassangercolumnNames;
	private Object[][] allPassangerData=new Object[][] {{"Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)}} ;
	
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainform frame = new mainform();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainform() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(15, 25));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(15);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Lsit of all Passanger");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		allPassangercolumnNames = new String[] {"First Name","Last Name","Sport","# of Years","Vegetarian"};
		
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};

		table_allPassanger = new JTable(allPassangerData, allPassangercolumnNames);
		table_allPassanger.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table_allPassanger.setSize(new Dimension(100, 200));
		panel_1.add(table_allPassanger);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignOnBaseline(true);
		panel_1.add(panel);
		
		JButton btnCounter = new JButton("Counter 1");
		btnCounter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
//				Checkin ck=new Checkin();
//				ck.setVisible(true);
			}
		});
		panel.add(btnCounter);
		
		JButton btnNewPassnger = new JButton("Counter 2");
		btnNewPassnger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnNewPassnger);
		
		JButton btnNewButton = new JButton("Counter 3");
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
//		table_1 = new JTable(data, allPassangercolumnNames);
//		panel_1.add(table_1);
	}

}
