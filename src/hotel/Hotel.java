package hotel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Hotel {

	private JFrame frame;
	private JTextField txtDisplay;
	private JTextField ReceiptArea;
	private JTextField txtrice;
	private JTextField txtmatooke;
	private JTextField txtposho;
	private JTextField txtchicken;
	private JTextField txtdrink;
	private JTextField txtcountry;
	
	
	double  firstnum;
	double  secondnum;
	double  result;
	String  operations;
	String  answer;


	double  Nigerian_Naira  =  0.10;
	double  Kenyan_Shilling  =  0.029;
	double  Chinese_Yuan  =  0.0019;
	double  Indian_Rupee  =  0.020;

	private  JLabel  lblclock;
	private JTextField txtclock;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel window = new Hotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public  void  datetime()
	{
		Thread  datetime  =  new  Thread()
		{
			public  void  run()
			{
				try
				{
					for(;;)
					{
						Calendar  cal  =  new  GregorianCalendar();
						int  day   =  cal.get(Calendar.DAY_OF_MONTH);
						int  month  =  cal.get(Calendar.MONTH);
						int  year  =  cal.get(Calendar.YEAR); 

						int  second  =  cal.get(Calendar.SECOND);
						int  minute  =  cal.get(Calendar.MINUTE);
						int  hour  =  cal.get(Calendar.HOUR);

						txtclock.setText("Time:  " +  hour  +  ":"  +  minute  +  ":"  +
								second  +  "        " +  year  +  "/"  +  month  +  "/"  +  day);
						sleep(1000);
					}
				}
				catch(Exception  e)
				{

				}
			}
		};
		datetime.start();
	}


	/**
	 * Create the application.
	 */
	public Hotel() {
		initialize();
		datetime();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.setBounds(0, 0, 825, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(10, 25, 252, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 230, 360);
		panel.add(tabbedPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(85, 107, 47));
		tabbedPane.addTab("Calculator", null, panel_4, null);
		panel_4.setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtDisplay.setColumns(10);
		txtDisplay.setBounds(10, 11, 204, 42);
		panel_4.add(txtDisplay);
		
		JButton btnbackspace = new JButton("<");
		btnbackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String backspace=null;
                 
                 if(txtDisplay.getText().length() > 0) {
                 StringBuilder strb = new StringBuilder (txtDisplay.getText());
                 strb.deleteCharAt(txtDisplay.getText().length() - 1);
                 backspace = strb.toString();
                 txtDisplay.setText(backspace);
			}
			}
		});
		btnbackspace.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnbackspace.setBounds(10, 64, 50, 50);
		panel_4.add(btnbackspace);
		
		JButton btnclear = new JButton("C");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplay.setText(null);
			}
		});
		btnclear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnclear.setBounds(62, 64, 50, 50);
		panel_4.add(btnclear);
		
		JButton btnmodulus = new JButton("%");
		btnmodulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  firstnum = Double.parseDouble(txtDisplay.getText());
				  txtDisplay.setText("");
                  operations = "%" ;
			}
		});
		btnmodulus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnmodulus.setBounds(114, 64, 50, 50);
		panel_4.add(btnmodulus);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
                operations = "+" ;
			}
		});
		btnplus.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnplus.setBounds(166, 64, 50, 50);
		panel_4.add(btnplus);
		
		JButton btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "-" ;
			}
		});
		btnminus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnminus.setBounds(166, 116, 50, 50);
		panel_4.add(btnminus);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn9.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn9.setBounds(114, 116, 50, 50);
		panel_4.add(btn9);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn6.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn6.setBounds(114, 168, 50, 50);
		panel_4.add(btn6);
		
		JButton btnmulti = new JButton("x");
		btnmulti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				operations = "*" ;
			}
		});
		btnmulti.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnmulti.setBounds(166, 168, 50, 50);
		panel_4.add(btnmulti);
		
		JButton btndivide = new JButton("/");
		btndivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
                operations = "/" ;
			}
		});
		btndivide.setFont(new Font("Tahoma", Font.BOLD, 16));
		btndivide.setBounds(166, 220, 50, 50);
		panel_4.add(btndivide);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn3.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn3.setBounds(114, 220, 50, 50);
		panel_4.add(btn3);
		
		JButton btnplusminus = new JButton("\u00B1");
		btnplusminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 double ops = Double.parseDouble(String.valueOf(txtDisplay.getText()));
                 ops =ops * (-1);
                 txtDisplay.setText(String.valueOf(ops));
			}
		});
		btnplusminus.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnplusminus.setBounds(114, 272, 50, 50);
		panel_4.add(btnplusminus);
		
		JButton btnequals = new JButton("=");
		btnequals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
                secondnum = Double.parseDouble(txtDisplay.getText());
                if (operations == "+")
                {
                    result = firstnum + secondnum;
                    answer = String.format("%.1f",result);
                    txtDisplay.setText(answer);
                   
                }
                else if (operations == "-")
                {
                    result = firstnum - secondnum;
                    answer = String.format("%.1f", result);
                    txtDisplay.setText(answer);
                }
               
                else if (operations == "*")
                {
                    result = firstnum * secondnum;
                    answer = String.format("%.1f", result);
                    txtDisplay.setText(answer);
                }
                
                else if (operations == "%")
                {
                    result = firstnum % secondnum;
                    answer = String.format("%.1f", result);
                    txtDisplay.setText(answer);
                }   
               
                else if (operations == "/")
                {
                    result = firstnum / secondnum;
                    answer = String.format("%.1f", result);
                    txtDisplay.setText(answer);
                }
			}
		});
		btnequals.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnequals.setBounds(166, 272, 50, 50);
		panel_4.add(btnequals);
		
		JButton btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplay.getText() + btndot.getText();
				txtDisplay.setText(EnterNumber );
			}
		});
		btndot.setFont(new Font("Tahoma", Font.BOLD, 16));
		btndot.setBounds(62, 272, 50, 50);
		panel_4.add(btndot);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn0.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn0.setBounds(10, 272, 50, 50);
		panel_4.add(btn0);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn1.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn1.setBounds(10, 220, 50, 50);
		panel_4.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn2.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn2.setBounds(62, 220, 50, 50);
		panel_4.add(btn2);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn4.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn4.setBounds(10, 168, 50, 50);
		panel_4.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn5.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn5.setBounds(62, 168, 50, 50);
		panel_4.add(btn5);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn7.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn7.setBounds(10, 116, 50, 50);
		panel_4.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternum = txtDisplay.getText()+btn8.getText();
				txtDisplay.setText(Enternum);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn8.setBounds(62, 116, 50, 50);
		panel_4.add(btn8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_3, null);
		panel_3.setLayout(null);
		
		
		JTextArea ReceiptArea2 = new JTextArea();
		ReceiptArea2.setBackground(Color.WHITE);
		ReceiptArea2.setBounds(10, 11, 205, 310);
		panel_3.add(ReceiptArea2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(127, 255, 212));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setBounds(264, 60, 537, 242);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 11, 81, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setForeground(Color.BLUE);
		lblQty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblQty.setBounds(142, 10, 68, 20);
		panel_1.add(lblQty);
		
		JLabel lblPrice = new JLabel("Price (UGX)");
		lblPrice.setForeground(Color.BLUE);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPrice.setBounds(238, 11, 81, 20);
		panel_1.add(lblPrice);
		
		JLabel lblrice = new JLabel("Rice");
		lblrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrice.setBounds(10, 38, 46, 14);
		panel_1.add(lblrice);
		
		JLabel lblmatooke = new JLabel("Matooke");
		lblmatooke.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmatooke.setBounds(10, 63, 68, 14);
		panel_1.add(lblmatooke);
		
		JLabel lblposho = new JLabel("Posho");
		lblposho.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblposho.setBounds(10, 88, 46, 14);
		panel_1.add(lblposho);
		
		JLabel lblchicken = new JLabel("Chicken");
		lblchicken.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblchicken.setBounds(10, 113, 62, 14);
		panel_1.add(lblchicken);
		
		txtrice = new JTextField();
		txtrice.setBounds(142, 33, 68, 20);
		panel_1.add(txtrice);
		txtrice.setColumns(10);
		
		txtmatooke = new JTextField();
		txtmatooke.setColumns(10);
		txtmatooke.setBounds(142, 57, 68, 20);
		panel_1.add(txtmatooke);
		
		txtposho = new JTextField();
		txtposho.setColumns(10);
		txtposho.setBounds(142, 82, 68, 20);
		panel_1.add(txtposho);
		
		txtchicken = new JTextField();
		txtchicken.setColumns(10);
		txtchicken.setBounds(142, 107, 68, 20);
		panel_1.add(txtchicken);
		
		JLabel label = new JLabel("4000");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(238, 37, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("3500");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(238, 60, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("2500");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(238, 85, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("5000");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(238, 113, 46, 14);
		panel_1.add(label_3);
		
		JComboBox cmbdrink = new JComboBox();
		cmbdrink.setFont(new Font("Tahoma", Font.BOLD, 10));
		cmbdrink.setModel(new DefaultComboBoxModel(new String[] {"Choose a drink", "Coca cola", "Fanta", "Pepsi", "Mirinda"}));
		cmbdrink.setBounds(10, 138, 108, 22);
		panel_1.add(cmbdrink);
		
		txtdrink = new JTextField();
		txtdrink.setColumns(10);
		txtdrink.setBounds(142, 140, 68, 20);
		panel_1.add(txtdrink);
		
		JLabel label_4 = new JLabel("-");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(238, 146, 46, 14);
		panel_1.add(label_4);
		
		JComboBox cmbroom = new JComboBox();
		cmbroom.setFont(new Font("Tahoma", Font.BOLD, 10));
		cmbroom.setModel(new DefaultComboBoxModel(new String[] {"Choose a Room", "1001", "1002", "1003", "VIP"}));
		cmbroom.setBounds(10, 171, 108, 22);
		panel_1.add(cmbroom);
		
		JCheckBox chkdelivery = new JCheckBox("Delivery");
		chkdelivery.setFont(new Font("Tahoma", Font.BOLD, 10));
		chkdelivery.setBounds(142, 171, 81, 23);
		panel_1.add(chkdelivery);
		
		JCheckBox chktax = new JCheckBox("Tax");
		chktax.setFont(new Font("Tahoma", Font.BOLD, 10));
		chktax.setBounds(238, 171, 74, 23);
		panel_1.add(chktax);
		
	
		
		JLabel lblCurrencyConvertor = new JLabel("Currency Convertor");
		lblCurrencyConvertor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencyConvertor.setForeground(Color.BLUE);
		lblCurrencyConvertor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblCurrencyConvertor.setBounds(336, 11, 186, 20);
		panel_1.add(lblCurrencyConvertor);
		
		JComboBox cmbcountry = new JComboBox();
		cmbcountry.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbcountry.setModel(new DefaultComboBoxModel(new String[] {"Country", "Nigeria", "Kenya", "China", "India"}));
		cmbcountry.setBounds(364, 57, 124, 23);
		panel_1.add(cmbcountry);
		
		txtcountry = new JTextField();
		txtcountry.setColumns(10);
		txtcountry.setBounds(364, 107, 125, 22);
		panel_1.add(txtcountry);
		
		JLabel lblconvertanswer = new JLabel("");
		lblconvertanswer.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblconvertanswer.setBounds(364, 152, 124, 23);
		panel_1.add(lblconvertanswer);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//=============CONVERT BUTTON =====================
				double  Uganda_shs  =  Double.parseDouble(txtcountry.getText());

				if (cmbcountry.getSelectedItem().equals("Nigeria"))
				{
					String  Naira  =  String.format("N  %.2f",  Uganda_shs/Nigerian_Naira);
					lblconvertanswer.setText(Naira);
				}

				if (cmbcountry.getSelectedItem().equals("Kenya"))
				{
					String  Shilling  =  String.format("KS  %.2f",  Uganda_shs/Kenyan_Shilling);
					lblconvertanswer.setText(Shilling);
				}

				if (cmbcountry.getSelectedItem().equals("China"))
				{
					String  Yuan  =  String.format("CY  %.2f",  Uganda_shs/Chinese_Yuan);
					lblconvertanswer.setText(Yuan);
				}

				if (cmbcountry.getSelectedItem().equals("India"))
				{
					String  Rupee  =  String.format("INR  %.2f",  Uganda_shs/Indian_Rupee);
					lblconvertanswer.setText(Rupee);
				}	                           

			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConvert.setBounds(348, 204, 81, 23);
		panel_1.add(btnConvert);
		
		JButton btnreset2 = new JButton("Reset");
		btnreset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ================Currency Reset =======================
				lblconvertanswer.setText(null);
				txtcountry.setText(null);
				cmbcountry.setSelectedItem("Country");
			}
		});
		btnreset2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnreset2.setBounds(439, 204, 83, 23);
		panel_1.add(btnreset2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(318, 11, 1, 220);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 167, 309, 2);
		panel_1.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(127, 255, 212));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_2.setBounds(264, 304, 537, 119);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTotalCostOf = new JLabel("Total Cost of Meal");
		lblTotalCostOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalCostOf.setBounds(10, 11, 109, 14);
		panel_2.add(lblTotalCostOf);
		
		JLabel lblTotalCostOf_1 = new JLabel("Total Cost of Drink");
		lblTotalCostOf_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalCostOf_1.setBounds(10, 36, 109, 14);
		panel_2.add(lblTotalCostOf_1);
		
		JLabel lblCostOfDelivery = new JLabel("Cost of Delivery");
		lblCostOfDelivery.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCostOfDelivery.setBounds(10, 61, 109, 14);
		panel_2.add(lblCostOfDelivery);
		
		JLabel lblCostOfRoom = new JLabel("Cost of Room");
		lblCostOfRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCostOfRoom.setBounds(10, 86, 109, 14);
		panel_2.add(lblCostOfRoom);
		
		JLabel lbltotalmeal = new JLabel("");
		lbltotalmeal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lbltotalmeal.setBounds(128, 11, 124, 20);
		panel_2.add(lbltotalmeal);
		
		JLabel lbltotaldrink = new JLabel("");
		lbltotaldrink.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lbltotaldrink.setBounds(128, 36, 124, 20);
		panel_2.add(lbltotaldrink);
		
		JLabel lbldeliverycost = new JLabel("");
		lbldeliverycost.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lbldeliverycost.setBounds(128, 61, 124, 20);
		panel_2.add(lbldeliverycost);
		
		JLabel lblroomcost = new JLabel("");
		lblroomcost.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblroomcost.setBounds(128, 86, 124, 20);
		panel_2.add(lblroomcost);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(319, 11, 1, 101);
		panel_2.add(separator_2);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTax.setBounds(331, 36, 59, 14);
		panel_2.add(lblTax);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubTotal.setBounds(331, 61, 59, 14);
		panel_2.add(lblSubTotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(331, 86, 59, 14);
		panel_2.add(lblTotal);
		
		JLabel lbltax = new JLabel("");
		lbltax.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lbltax.setBounds(401, 36, 109, 20);
		panel_2.add(lbltax);
		
		JLabel lblsubtotal = new JLabel("");
		lblsubtotal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lblsubtotal.setBounds(401, 61, 109, 20);
		panel_2.add(lblsubtotal);
		
		JLabel lbltotal = new JLabel("");
		lbltotal.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		lbltotal.setBounds(401, 86, 109, 20);
		panel_2.add(lbltotal);
		
		txtclock = new JTextField();
		txtclock.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtclock.setBorder(null);
		txtclock.setBackground(new Color(127, 255, 212));
		txtclock.setColumns(10);
		txtclock.setBounds(330, 8, 180, 22);
		panel_2.add(txtclock);
		
		JLabel lblNewLabel = new JLabel("Hotel Management System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(266, 25, 488, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 830, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New ");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Receipt");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double  Invoice1  =  Double.parseDouble(txtrice.getText());
				Double  Invoice2  =  Double.parseDouble(txtmatooke.getText());
				Double  Invoice3  =  Double.parseDouble(txtposho.getText());
				Double  Invoice4  =  Double.parseDouble(txtchicken.getText());
				Double  Invoice5  =  Double.parseDouble(txtdrink.getText());
                
				ReceiptArea2.append("\t\nHotel  Management  System:\n" 	
					+	"\n Rice:  \t\t"	     +	  Invoice1
					+	"\n Matooke:    \t\t"	 +    Invoice2
					+	"\n Posho:    \t\t"		 +    Invoice3
					+  "\n Chicken:        \t\t" +    Invoice4
					+  "\n"  +  cmbdrink.getSelectedItem()  +  " :\t\t"  + Invoice5
					+"\nTotal  : \t\t"                      +        lbltotal.getText()
					+  "\n\nWelcome  and   Thank  you  for  your  patronage"
					);
			
		    	}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reset");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//============================RESET BUTTON ==============================
			
				txtrice.setText(null);
				txtmatooke.setText(null);
				txtposho.setText(null);
				txtchicken.setText(null);
				txtdrink.setText(null);
				lbltotalmeal.setText(null);
				lbltotaldrink.setText(null);
				lbldeliverycost.setText(null);
				lblroomcost.setText(null);
				lbltax.setText(null);
				lblsubtotal.setText(null);
				lbltotal.setText(null);
				txtcountry.setText(null);
				lblconvertanswer.setText(null);
				txtDisplay.setText(null);
				cmbdrink.setSelectedItem("Choose a drink");
				cmbroom.setSelectedItem("Choose a room");
				cmbcountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Convert");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=============CONVERT BUTTON =====================
				double  Uganda_shs  =  Double.parseDouble(txtcountry.getText());

				if (cmbcountry.getSelectedItem().equals("Nigeria"))
				{
					String  Naira  =  String.format("N  %.2f",  Uganda_shs/Nigerian_Naira);
					lblconvertanswer.setText(Naira);
				}

				if (cmbcountry.getSelectedItem().equals("Kenya"))
				{
					String  Shilling  =  String.format("KS  %.2f",  Uganda_shs/Kenyan_Shilling);
					lblconvertanswer.setText(Shilling);
				}

				if (cmbcountry.getSelectedItem().equals("China"))
				{
					String  Yuan  =  String.format("CY  %.2f",  Uganda_shs/Chinese_Yuan);
					lblconvertanswer.setText(Yuan);
				}

				if (cmbcountry.getSelectedItem().equals("India"))
				{
					String  Rupee  =  String.format("INR  %.2f",  Uganda_shs/Indian_Rupee);
					lblconvertanswer.setText(Rupee);
				}	                           

			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Total");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================Tax==============================
				double  pTotal1  =  Double.parseDouble(lbltotalmeal.getText());
				double  pTotal2  =  Double.parseDouble(lbltotaldrink.getText());
				double  pTotal3  =  Double.parseDouble(lbldeliverycost.getText());
				double  pTotal4  =  Double.parseDouble(lblroomcost.getText());
				double  cTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4)/100;

				if(chktax.isSelected())
				{ 
					String  xTotal  =  String.format("%.2f",  cTotal);
					lbltax.setText(xTotal);
				}
				//==========================Total==============================
				double  pTotal5  =  Double.parseDouble(lbltax.getText());

				String  zTaxTotal  =  String.format("UGX %.2f",  pTotal5);
				lbltax.setText(zTaxTotal);

				double  SubTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4);
				String  pSubTotal  =  String.format("UGX %.2f",  SubTotal);
				lblsubtotal.setText(pSubTotal);

				double  xTotal  =  (pTotal1  +  pTotal2  +  pTotal3  +  pTotal4 + pTotal5);
				String  yTotal  =  String.format("UGX %.2f",  xTotal);
				lbltotal.setText(yTotal);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Refresh");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//========================REFRESH BUTTON ===========================
				txtrice.setText(null);
				txtmatooke.setText(null);
				txtposho.setText(null);
				txtchicken.setText(null);
				txtdrink.setText(null);
				lbltotalmeal.setText(null);
				lbltotaldrink.setText(null);
				lbldeliverycost.setText(null);
				lblroomcost.setText(null);
				lbltax.setText(null);
				lblsubtotal.setText(null);
				lbltotal.setText(null);
				txtcountry.setText(null);
				lblconvertanswer.setText(null);
				txtDisplay.setText(null);
				cmbdrink.setSelectedItem("Choose a drink");
				cmbroom.setSelectedItem("Choose a room");
				cmbcountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Exit");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================EXIT BUTTON======================
				System.exit(0);
			}
		});
		mntmNewMenuItem_5.setForeground(Color.RED);
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_6 = new JMenu("Convert");
		mnNewMenu_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//=============CONVERT BUTTON =====================
				double  Uganda_shs  =  Double.parseDouble(txtcountry.getText());

				if (cmbcountry.getSelectedItem().equals("Nigeria"))
				{
					String  Naira  =  String.format("N  %.2f",  Uganda_shs/Nigerian_Naira);
					lblconvertanswer.setText(Naira);
				}

				if (cmbcountry.getSelectedItem().equals("Kenya"))
				{
					String  Shilling  =  String.format("KS  %.2f",  Uganda_shs/Kenyan_Shilling);
					lblconvertanswer.setText(Shilling);
				}

				if (cmbcountry.getSelectedItem().equals("China"))
				{
					String  Yuan  =  String.format("CY  %.2f",  Uganda_shs/Chinese_Yuan);
					lblconvertanswer.setText(Yuan);
				}

				if (cmbcountry.getSelectedItem().equals("India"))
				{
					String  Rupee  =  String.format("INR  %.2f",  Uganda_shs/Indian_Rupee);
					lblconvertanswer.setText(Rupee);
				}	                           
			}
		});
		mnNewMenu_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("Total");
		mnNewMenu_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================Tax==============================
				double  pTotal1  =  Double.parseDouble(lbltotalmeal.getText());
				double  pTotal2  =  Double.parseDouble(lbltotaldrink.getText());
				double  pTotal3  =  Double.parseDouble(lbldeliverycost.getText());
				double  pTotal4  =  Double.parseDouble(lblroomcost.getText());
				double  cTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4)/100;

				if(chktax.isSelected())
				{ 
					String  xTotal  =  String.format("%.2f",  cTotal);
					lbltax.setText(xTotal);
				}
				//==========================Total==============================
				double  pTotal5  =  Double.parseDouble(lbltax.getText());

				String  zTaxTotal  =  String.format("UGX %.2f",  pTotal5);
				lbltax.setText(zTaxTotal);

				double  SubTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4);
				String  pSubTotal  =  String.format("UGX %.2f",  SubTotal);
				lblsubtotal.setText(pSubTotal);

				double  xTotal  =  (pTotal1  +  pTotal2  +  pTotal3  +  pTotal4 + pTotal5);
				String  yTotal  =  String.format("UGX %.2f",  xTotal);
				lbltotal.setText(yTotal);
			}
		});
		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_7);
		
		JMenu mnNewMenu_8 = new JMenu("Reset");
		mnNewMenu_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//========================RESET BUTTON ===========================
				txtrice.setText(null);
				txtmatooke.setText(null);
				txtposho.setText(null);
				txtchicken.setText(null);
				txtdrink.setText(null);
				lbltotalmeal.setText(null);
				lbltotaldrink.setText(null);
				lbldeliverycost.setText(null);
				lblroomcost.setText(null);
				lbltax.setText(null);
				lblsubtotal.setText(null);
				lbltotal.setText(null);
				txtcountry.setText(null);
				lblconvertanswer.setText(null);
				txtDisplay.setText(null);
				cmbdrink.setSelectedItem("Choose a drink");
				cmbroom.setSelectedItem("Choose a room");
				cmbcountry.setSelectedItem("Country");
				ReceiptArea.setText(null);
			}
		});
		mnNewMenu_8.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_8);
		
		JMenu mnNewMenu_9 = new JMenu("Receipt");
		mnNewMenu_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double  Invoice1  =  Double.parseDouble(txtrice.getText());
				Double  Invoice2  =  Double.parseDouble(txtmatooke.getText());
				Double  Invoice3  =  Double.parseDouble(txtposho.getText());
				Double  Invoice4  =  Double.parseDouble(txtchicken.getText());
				Double  Invoice5  =  Double.parseDouble(txtdrink.getText());
                
				ReceiptArea2.append("\t\nHotel  Management  System:\n" 	
					+	"\n Rice:  \t"	     +	  Invoice1
					+	"\n Matooke:    \t"	 +    Invoice2
					+	"\n Posho:    \t\t"		 +    Invoice3
					+  "\n Chicken:        \t\t" +    Invoice4
					+  "\n"  +  cmbdrink.getSelectedItem()  +  " :\t\t"  + Invoice5
					+"\nTotal  : \t\t"                      +        lbltotal.getText()
					+  "\n\nWelcome  and   Thank  you  for  your  patronage"
					);
			
			}
		});
		mnNewMenu_9.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_9);
		
		JMenu mnNewMenu_10 = new JMenu("Exit");
		mnNewMenu_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================EXIT BUTTON======================
				System.exit(0);
			}
		});
		mnNewMenu_10.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_10);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//==========================Drink==============================

				double  Drinks  =  Double.parseDouble(txtdrink.getText());
				double  CocaCola  =  1000*Drinks;
				double  Fanta  =  1000*Drinks;
				double  Pepsi  =  1000*Drinks;
				double  Mirinda  =  1000*Drinks;

				if(cmbdrink.getSelectedItem().equals("Coca cola"))
				{
					String  pCoca_Cola  =  String.format("%.2f",  CocaCola);
					lbltotaldrink.setText(pCoca_Cola);
				}

				if(cmbdrink.getSelectedItem().equals("Fanta"))
				{
					String  pFanta  =  String.format("%.2f",  Fanta);
					lbltotaldrink.setText(pFanta);
				}
				if(cmbdrink.getSelectedItem().equals("Pepsi"))
				{
					String  pPepsi  =  String.format("%.2f",  Pepsi);
					lbltotaldrink.setText(pPepsi);
				}
				if(cmbdrink.getSelectedItem().equals("Mirinda"))
				{
					String  pMirinda  =  String.format("%.2f",  Mirinda);
					lbltotaldrink.setText(pMirinda);
				}

				if(cmbdrink.getSelectedItem().equals("Choose a drink"))
				{
					lbltotaldrink.setText("0.00");
				}
				
				//==========================Meal==============================
				
				double  Rice  =  Double.parseDouble(txtrice.getText());
				double  pRice  =  4000;
				double  getRice;
				getRice  =  (Rice  *  pRice);
				String  TotalFriedRice  =  String.format("%.2f",  getRice);
				lbltotalmeal.setText(TotalFriedRice);
				
				double  Matooke  =  Double.parseDouble(txtmatooke.getText());
				double  pMatooke  =  3500;
				double  getMatooke;
				getMatooke  =  (Matooke  *  pMatooke);
				String  TotalMatooke  =  String.format("%.2f",  getMatooke + getRice);
				lbltotalmeal.setText(TotalMatooke);
				
				double  Posho  =  Double.parseDouble(txtposho.getText());
				double  pPosho  =  2500;
				double  getPosho;
				getPosho  =  (Posho  *  pPosho);
				String  TotalPosho  =  String.format("%.2f",  getPosho + getMatooke + getRice);
				lbltotalmeal.setText(TotalPosho);

				double  Chicken  =  Double.parseDouble(txtchicken.getText());
				double  pChicken  =  5000;
				double  getChicken;
				getChicken  =  (Chicken  *  pChicken);
				String  TotalChicken  =  String.format("%.2f",  getChicken  +  getPosho + getMatooke + getRice);
				lbltotalmeal.setText(TotalChicken);
				
				//==========================Choose a room==============================

				
				double  Room_0  =  0;
				double  Room_1  =  1000;
				double  Room_2  =  2000;
				double  Room_3  =  3000;
				double  Room_4  =  6000;

				if(cmbroom.getSelectedItem().equals("1001"))
				{
					String  pRoom_1  =  String.format("%.2f",  Room_1);
					lblroomcost.setText(pRoom_1);
				}

				if(cmbroom.getSelectedItem().equals("1002"))
				{
					String  pRoom_2  =  String.format("%.2f",  Room_2);
					lblroomcost.setText(pRoom_2);
				}
				if(cmbroom.getSelectedItem().equals("1003"))
				{
					String  pRoom_3  =  String.format("%.2f",  Room_3);
					lblroomcost.setText(pRoom_3);
				}
				if(cmbroom.getSelectedItem().equals("VIP"))
				{
					String  pRoom_4  =  String.format("%.2f",  Room_4);
					lblroomcost.setText(pRoom_4);
				}

				if(cmbroom.getSelectedItem().equals("Choose a Room"))
				{
					String  pRoom_0  =  String.format("%.2f",  Room_0);
					lblroomcost.setText(pRoom_0);
				}
				
				
				//==========================Delivery==============================
				double  cDelivery  =  2000;
				if(chkdelivery.isSelected())
				{
					String  pDelivery  =  String.format("%.2f",  cDelivery);
					lbldeliverycost.setText(pDelivery);
				}
				else
				{
					lbldeliverycost.setText("0.00");
				}
				
				//==========================Tax==============================
				double  pTotal1  =  Double.parseDouble(lbltotalmeal.getText());
				double  pTotal2  =  Double.parseDouble(lbltotaldrink.getText());
				double  pTotal3  =  Double.parseDouble(lbldeliverycost.getText());
				double  pTotal4  =  Double.parseDouble(lblroomcost.getText());
				double  cTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4)/100;

				if(chktax.isSelected())
				{ 
					String  xTotal  =  String.format("%.2f",  cTotal);
					lbltax.setText(xTotal);
				}
				
				//==========================Total==============================
				double  pTotal5  =  Double.parseDouble(lbltax.getText());

				String  zTaxTotal  =  String.format("UGX %.2f",  pTotal5);
				lbltax.setText(zTaxTotal);

				double  SubTotal  =  (pTotal1  +  pTotal2  +  pTotal3 + pTotal4);
				String  pSubTotal  =  String.format("UGX %.2f",  SubTotal);
				lblsubtotal.setText(pSubTotal);

				double  xTotal  =  (pTotal1  +  pTotal2  +  pTotal3  +  pTotal4 + pTotal5);
				String  yTotal  =  String.format("UGX %.2f",  xTotal);
				lbltotal.setText(yTotal);

			}
		});
		btnsubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnsubmit.setBounds(10, 204, 89, 23);
		panel_1.add(btnsubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrice.setText(null);
				txtmatooke.setText(null);
				txtposho.setText(null);
				txtchicken.setText(null);
				txtdrink.setText(null);
				lbltotalmeal.setText(null);
				lbltotaldrink.setText(null);
				lbldeliverycost.setText(null);
				lblroomcost.setText(null);
				lbltax.setText(null);
				lblsubtotal.setText(null);
				lbltotal.setText(null);
				txtcountry.setText(null);
				lblconvertanswer.setText(null);
				txtDisplay.setText(null);
				cmbdrink.setSelectedItem("Choose a drink");
				cmbroom.setSelectedItem("Choose a room");
				cmbcountry.setSelectedItem("Country");
				ReceiptArea.setText(null);

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(109, 204, 89, 23);
		panel_1.add(btnReset);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(318, 158, 1, 2);
		panel_1.add(separator_3);
		
		ReceiptArea = new JTextField();
		ReceiptArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double  Invoice1  =  Double.parseDouble(txtrice.getText());
				Double  Invoice2  =  Double.parseDouble(txtmatooke.getText());
				Double  Invoice3  =  Double.parseDouble(txtposho.getText());
				Double  Invoice4  =  Double.parseDouble(txtchicken.getText());
				Double  Invoice5  =  Double.parseDouble(txtdrink.getText());
                
				ReceiptArea2.append("\t\nHotel  Management  System:\n" 	
					+	"\n Rice:  \t"	     +	  Invoice1
					+	"\n Matooke:    \t"	 +    Invoice2
					+	"\n Posho:    \t\t"		 +    Invoice3
					+  "\n Chicken:        \t\t" +    Invoice4
					+  "\n"  +  cmbdrink.getSelectedItem()  +  " :\t\t"  + Invoice5
					+"\nTotal: \t\t"                      +        lbltotal.getText()
					+  "\n\nWelcome  and   Thank  you  for  your  patronage"
					);
			}
		});
		ReceiptArea.setBackground(Color.WHITE);
		ReceiptArea.setBounds(10, 11, 205, 310);
		panel_3.add(ReceiptArea);
		ReceiptArea.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\PC\\KRD2.jpg"));
		lblNewLabel_2.setBounds(753, 25, 48, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
	}
}
