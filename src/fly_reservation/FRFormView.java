package fly_reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import references.AutoCompletion;
import references.JTextFieldHintUI;
import references.MyOwnFocusTraversalPolicy;
import reservation_system.RSModel;

public class FRFormView extends JFrame{
	private FlightReservation fr = new FlightReservation();
	
	private JLabel lblAirline, lblFlightNo, lblDepartureDate, lblDepartureTime, 
		lblArrivalTime, lblOrigin, lblDestination, lblRecordLocator,
		lblReservationType, lblReservationDate, lblOptionToPay, lblAmountToPay,
		lblOptionToFinal, lblTotalPayment, lblGuestName, lblGender, lblNoOfAdult, lblNoOfChild,  lblPaymentType, 
		lblCurrency, lblCurrencyNote,
		lblPayIn, lblPayInPHP, lblPayInKRW, lblPayInDate, 
		lblPayOut , lblPayOutPHP, lblPayOutKRW, lblPayOutDate,
		lblIncome, lblIncomePHP, lblIncomeKRW, lblNote,  
		lblRemark, lblHistory;
	
	private JTextField tfRecordLocator, tfGuestName;
	
	JFormattedTextField ftfDepartureDate, ftfDepartureTime, ftfArrivalTime, 
		ftfReservationDate, ftfOptionToPay, ftfAmountToPay, ftfOptionToFinal,
		ftfTotalPayment, ftfNoOfAdult, ftfNoOfChild, ftfCurrency, ftfPayInPHP,
		ftfPayInKRW, ftfPayInDate, ftfPayOutPHP, ftfPayOutKRW, ftfPayOutDate,
		ftfIncomePHP, ftfIncomeKRW;
	
	private JTextArea taNote, taRemark;
	
	private JList lHistory;
	
	private JComboBox  cbAirline, cbFlightNumber, cbOrigin, cbDestination,
		cbTotalPaymentType, cbReservationType, cbGender, cbPaymentType;
	
	private JButton btnAddAirline;
	private JButton btnAddFlight;
	private JButton btnAddOrigin;
	private JButton btnAddDestination;
	private JButton btnAddRT;
	private JButton btnAddPT;
	
	private JButton btnExportPO;
	
	private JButton btnExportIV;
	
	private JButton btnSave;
	
	private JButton btnCancel;
	
	private RSModel model;
	
	public FRFormView(RSModel model){
		super("Flight Reservation Form");
		setSize(845, 480);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblAirline = new JLabel("Airline");
		lblAirline.setBounds(10, 10, 100, 20);
		add(lblAirline);
		
		lblFlightNo = new JLabel("Flight No.");
		lblFlightNo.setBounds(10, 40, 100, 20);
		add(lblFlightNo);
		
		lblDepartureDate = new JLabel("Departure Date");
		lblDepartureDate.setBounds(10, 70, 100, 20);
		add(lblDepartureDate);
		
		lblDepartureTime = new JLabel("Departure Time");
		lblDepartureTime.setBounds(10, 100, 100, 20);
		add(lblDepartureTime);
		
		lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(10, 130, 100, 20);
		add(lblArrivalTime);
		
		lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(10, 160, 160, 20);
		add(lblOrigin);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 190, 100, 20);
		add(lblDestination);
		
		lblRecordLocator = new JLabel("");
		lblRecordLocator = new JLabel("Record Locator");
		lblRecordLocator.setBounds(10, 220, 100, 20);
		add(lblRecordLocator);
		
		lblReservationType = new JLabel("Reservation Type");
		lblReservationType.setBounds(250, 10, 100, 20);
		add(lblReservationType);
		
		lblReservationDate = new JLabel("Reservation Date");
		lblReservationDate.setBounds(250, 40, 100, 20);
		add(lblReservationDate);
		
		lblOptionToPay = new JLabel("Option To Pay");
		lblOptionToPay.setBounds(250, 70, 100, 20);
		add(lblOptionToPay);
		
		lblAmountToPay = new JLabel("Amount To Pay");
		lblAmountToPay.setBounds(250, 100, 100, 20);
		add(lblAmountToPay);
		
		lblOptionToFinal = new JLabel("Option To Final");
		lblOptionToFinal.setBounds(250, 130, 100, 20);
		add(lblOptionToFinal);
		
		lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setBounds(250, 160, 100, 20);
		add(lblTotalPayment);
		
		lblGuestName = new JLabel("Guest Name");
		lblGuestName.setBounds(250, 190, 100, 20);
		add(lblGuestName);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(250, 220, 100, 20);
		add(lblGender);
		
		lblNoOfAdult = new JLabel("Adult");
		lblNoOfAdult.setBounds(250, 250, 50, 20);
		add(lblNoOfAdult);
		
		lblNoOfChild = new JLabel("Child");
		lblNoOfChild.setBounds(370, 250, 50, 20);
		add(lblNoOfChild);
		
		lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(480, 10, 100, 20);
		add(lblPaymentType);
		
		lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(480, 40, 100, 20);
		add(lblCurrency);
		
		lblCurrencyNote = new JLabel("(PHP to KRW)");
		lblCurrencyNote.setBounds(680, 40, 100, 20);
		add(lblCurrencyNote);
		
		lblPayIn = new JLabel("Pay In");
		lblPayIn.setBounds(480, 70, 100, 20);
		add(lblPayIn);
		
		lblPayInPHP = new JLabel("PHP");
		lblPayInPHP.setBounds(550, 70, 30, 20);
		add(lblPayInPHP);
		
		lblPayInKRW = new JLabel("KRW");
		lblPayInKRW.setBounds(700, 70, 30, 20);
		add(lblPayInKRW);
		
		lblPayInDate = new JLabel("Date");
		lblPayInDate.setBounds(550, 100, 30, 20);
		add(lblPayInDate);
		
		lblPayOut = new JLabel("Pay Out");
		lblPayOut.setBounds(480, 130, 100, 20);
		add(lblPayOut);
		
		lblPayOutPHP = new JLabel("PHP");
		lblPayOutPHP.setBounds(550, 130, 30, 20);
		add(lblPayOutPHP);
		
		lblPayOutKRW = new JLabel("KRW");
		lblPayOutKRW.setBounds(700, 130, 30, 20);
		add(lblPayOutKRW);
		
		lblPayOutDate = new JLabel("Date");
		lblPayOutDate.setBounds(550, 160, 30, 20);
		add(lblPayOutDate);
		
		lblIncome = new JLabel("Income");
		lblIncome.setBounds(480, 190, 100, 20);
		add(lblIncome);
		
		lblIncomePHP = new JLabel("PHP");
		lblIncomePHP.setBounds(550, 190, 30, 20);
		add(lblIncomePHP);
		
		lblIncomeKRW = new JLabel("KRW");
		lblIncomeKRW.setBounds(700, 190, 30, 20);
		add(lblIncomeKRW);
		
		lblNote = new JLabel("Note");
		lblNote.setBounds(10, 280, 100, 20);
		add(lblNote);
		
		lblRemark = new JLabel("Remark");
		lblRemark.setBounds(10, 350, 100, 20);
		add(lblRemark);
		
		lblHistory = new JLabel("Edit History");
		lblHistory.setBounds(440, 280, 100, 20);
		add(lblHistory);
		
		cbAirline = new JComboBox(model.getAirline().toArray());
		cbAirline.setName("Airline");
		cbAirline.setEditable(true);
		new AutoCompletion(cbAirline);
		cbAirline.setBounds(90, 10, 120, 20);
		add(cbAirline);
		
		btnAddAirline = new JButton("+");
		btnAddAirline.setMargin(new Insets(0,0,0,0));
		btnAddAirline.setBounds(210, 10, 20, 20);
		add(btnAddAirline);
		
		cbFlightNumber = new JComboBox(model.getFlightNo().toArray());
		cbFlightNumber.setName("Flight Number");
		cbFlightNumber.setEditable(true);
		new AutoCompletion(cbFlightNumber);
		cbFlightNumber.setBounds(90, 40, 120, 20);
		add(cbFlightNumber);
		
		btnAddFlight = new JButton("+");
		btnAddFlight.setMargin(new Insets(0,0,0,0));
		btnAddFlight.setBounds(210, 40, 20, 20);
		add(btnAddFlight);
		
		ftfDepartureDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfDepartureDate.setName("Departure Date");
		ftfDepartureDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfDepartureDate.setBounds(90, 70, 140, 20);
		add(ftfDepartureDate);
		
		ftfDepartureTime = new JFormattedTextField(model.TIME_FORMAT);
		ftfDepartureTime.setName("Departure Time");
		ftfDepartureTime.setUI(new JTextFieldHintUI("HH:mm", Color.gray));
		ftfDepartureTime.setBounds(90, 100, 140, 20);
		add(ftfDepartureTime);
		
		ftfArrivalTime = new JFormattedTextField(model.TIME_FORMAT);
		ftfArrivalTime.setName("Arrival Time");
		ftfArrivalTime.setUI(new JTextFieldHintUI("HH:mm", Color.gray));
		ftfArrivalTime.setBounds(90, 130, 140, 20);
		add(ftfArrivalTime);
		
		cbOrigin = new JComboBox(model.getCity().toArray());
		cbOrigin.setName("Origin");
		cbOrigin.setEditable(true);
		new AutoCompletion(cbOrigin);
		cbOrigin.setBounds(90, 160, 120, 20);
		add(cbOrigin);
		
		btnAddOrigin = new JButton("+");
		btnAddOrigin.setMargin(new Insets(0,0,0,0));
		btnAddOrigin.setBounds(210, 160, 20, 20);
		add(btnAddOrigin);
		
		cbDestination = new JComboBox(model.getCity().toArray());
		cbDestination.setName("Destination");
		cbDestination.setEditable(true);
		new AutoCompletion(cbDestination);
		cbDestination.setBounds(90, 190, 120, 20);
		add(cbDestination);
		
		btnAddDestination = new JButton("+");
		btnAddDestination.setMargin(new Insets(0,0,0,0));
		btnAddDestination.setBounds(210, 190, 20, 20);
		add(btnAddDestination);
		
		tfRecordLocator = new JTextField("");
		tfRecordLocator.setName("Record Locator");
		tfRecordLocator.setBounds(90, 220, 140, 20);
		add(tfRecordLocator);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(340, 10, 100, 20);
		cbReservationType.setName("Reservation Type");
		add(cbReservationType);
		
		btnAddRT = new JButton("+");
		btnAddRT.setMargin(new Insets(0,0,0,0));
		btnAddRT.setBounds(440, 10, 20, 20);
		add(btnAddRT);
		
		ftfReservationDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfReservationDate.setName("Reservation Date");
		ftfReservationDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfReservationDate.setBounds(340, 40, 120, 20);
		add(ftfReservationDate);
		
		ftfOptionToPay = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToPay.setName("Option To Pay");
		ftfOptionToPay.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToPay.setBounds(340, 70, 120, 20);
		add(ftfOptionToPay);
		
		ftfAmountToPay = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfAmountToPay.setName("Amount To Pay");
		ftfAmountToPay.setValue(new Double(0));
		ftfAmountToPay.setBounds(340, 100, 120, 20);
		add(ftfAmountToPay);
		
		ftfOptionToFinal = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToFinal.setName("Option To Final");
		ftfOptionToFinal.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToFinal.setBounds(340, 130, 120, 20);
		add(ftfOptionToFinal);
		
		ftfTotalPayment = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayment.setName("Total Payment");
		ftfTotalPayment.setValue(new Double(0));
		ftfTotalPayment.setBounds(340, 160, 120, 20);
		add(ftfTotalPayment);
		
		cbTotalPaymentType = new JComboBox(new String[]{"Pesos", "Won"});
		cbTotalPaymentType.setName("Total Payment Type");
		cbTotalPaymentType.setBounds(460, 160, 60, 20);
		cbTotalPaymentType.setEditable(true);
		new AutoCompletion(cbTotalPaymentType);
		add(cbTotalPaymentType);
		
		tfGuestName = new JTextField();
		tfGuestName.setName("Guest Name");
		tfGuestName.setBounds(340, 190, 120, 20);
		add(tfGuestName);
		
		cbGender = new JComboBox(new String[]{"Male","Female"});
		cbGender.setEditable(true);
		new AutoCompletion(cbGender);
		cbGender.setBounds(340, 220, 120, 20);
		cbGender.setName("Gender");
		add(cbGender);
		
		ftfNoOfAdult = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfAdult.setValue(new Integer(0));
		ftfNoOfAdult.setBounds(290, 250, 50, 20);
		ftfNoOfAdult.setName("Number of Adult");
		add(ftfNoOfAdult);
		
		ftfNoOfChild = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfChild.setValue(new Integer(0));
		ftfNoOfChild.setBounds(410, 250, 50, 20);
		ftfNoOfChild.setName("Number of Child");
		add(ftfNoOfChild);
		
		cbPaymentType = new JComboBox(model.getPaymentType().toArray());
		cbPaymentType.setEditable(true);
		new AutoCompletion(cbPaymentType);
		cbPaymentType.setBounds(580, 10, 80, 20);
		cbPaymentType.setName("Payment Type");
		add(cbPaymentType);
		
		btnAddPT = new JButton("+");
		btnAddPT.setMargin(new Insets(0,0,0,0));
		btnAddPT.setBounds(660, 10, 20, 20);
		add(btnAddPT);
		
		ftfCurrency = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfCurrency.setValue(new Double(0));
		ftfCurrency.setUI(new JTextFieldHintUI("PHP to KRW", Color.gray));
		ftfCurrency.setBounds(580, 40, 100, 20);
		ftfCurrency.setName("Currency");
		add(ftfCurrency);
		
		ftfPayInPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInPHP.setValue(new Double(0));
		ftfPayInPHP.setBounds(580, 70, 100, 20);
		ftfPayInPHP.setName("Pay In - PHP");
		add(ftfPayInPHP);
		
		ftfPayInKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInKRW.setValue(new Double(0));
		ftfPayInKRW.setBounds(730, 70, 100, 20);
		ftfPayInKRW.setName("Pay In - KRW");
		add(ftfPayInKRW);
		
		ftfPayInDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayInDate.setName("Pay In - Date");
		ftfPayInDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayInDate.setBounds(580, 100, 100, 20);
		add(ftfPayInDate);
		
		ftfPayOutPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutPHP.setValue(new Double(0));
		ftfPayOutPHP.setBounds(580, 130, 100, 20);
		ftfPayOutPHP.setName("Pay Out - PHP");
		add(ftfPayOutPHP);
		
		ftfPayOutKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutKRW.setValue(new Double(0));
		ftfPayOutKRW.setBounds(730, 130, 100, 20);
		ftfPayOutKRW.setName("Pay Out - KRW");
		add(ftfPayOutKRW);
		
		ftfPayOutDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayOutDate.setName("Pay Out - Date");
		ftfPayOutDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayOutDate.setBounds(580, 160, 100, 20);
		add(ftfPayOutDate);
		
		ftfIncomePHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomePHP.setEditable(false);
		ftfIncomePHP.setValue(new Double(0));
		ftfIncomePHP.setBounds(580, 190, 100, 20);
		ftfIncomePHP.setName("Income - PHP");
		add(ftfIncomePHP);
		
		ftfIncomeKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomeKRW.setEditable(false);
		ftfIncomeKRW.setValue(new Double(0));
		ftfIncomeKRW.setBounds(730, 190, 100, 20);
		ftfIncomeKRW.setName("Income - KRW");
		add(ftfIncomeKRW);
		
		taNote = new JTextArea("");
		taNote.setName("Note");
		taNote.setLineWrap(true);
		taNote.setWrapStyleWord(false);
		
		JScrollPane jp = new JScrollPane(taNote);
		jp.setBounds(90, 280, 310, 60);
		add(jp);
		
		taRemark = new JTextArea("");
		taRemark.setName("Remark");
		taRemark.setLineWrap(true);
		taRemark.setWrapStyleWord(false);
		
		JScrollPane jp1 = new JScrollPane(taRemark);
		jp1.setBounds(90, 350, 310, 60);
		add(jp1);
		
		lHistory = new JList(new DefaultListModel());
		lHistory.setName("History");
		
		JScrollPane jp2 = new JScrollPane(lHistory);
		jp2.setBounds(520, 280, 310, 60);
		add(jp2);
		
		btnExportPO = new JButton("Export - Purchase Order");
		btnExportPO.setMnemonic(KeyEvent.VK_P);
		btnExportPO.setBounds(575, 350, 200, 20);
		add(btnExportPO);
		
		btnExportIV = new JButton("Export - Invoice");
		btnExportIV.setMnemonic(KeyEvent.VK_I);
		btnExportIV.setBounds(575, 380, 200, 20);
		add(btnExportIV);
		
		btnSave = new JButton("Save");
		btnSave.setMnemonic(KeyEvent.VK_S);
		btnSave.setBounds(335, 420, 90, 20);
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic(KeyEvent.VK_C);
		btnCancel.setBounds(440, 420, 90, 20);
		add(btnCancel);
		
		listeners();
		
		if(model.getCurrentUser().getAccessLevel() == 0){
			lblPayOut.setVisible(false);
			lblPayOutPHP.setVisible(false);
			lblPayOutKRW.setVisible(false);
			lblPayOutDate.setVisible(false);
			
			lblIncome.setVisible(false);
			lblIncomePHP.setVisible(false);
			lblIncomeKRW.setVisible(false);
			
			ftfPayOutPHP.setVisible(false);
			ftfPayOutKRW.setVisible(false);
			ftfPayOutDate.setVisible(false);
			
			ftfIncomePHP.setVisible(false);
			ftfIncomeKRW.setVisible(false);
		}
		
		Vector<Component> order = new Vector<Component>(20);
	    order.add(cbAirline.getEditor().getEditorComponent());
	    order.add(cbFlightNumber.getEditor().getEditorComponent());
	    order.add(ftfDepartureDate);
	    order.add(ftfDepartureTime);
	    order.add(ftfArrivalTime);
	    order.add(cbOrigin.getEditor().getEditorComponent());
	    order.add(cbDestination.getEditor().getEditorComponent());
	    order.add(tfRecordLocator);
	    order.add(cbReservationType.getEditor().getEditorComponent());
	    order.add(ftfReservationDate);
	    order.add(ftfOptionToPay);
	    order.add(ftfAmountToPay);
	    order.add(ftfOptionToFinal);
	    order.add(ftfTotalPayment);
	    order.add(cbTotalPaymentType.getEditor().getEditorComponent());
	    order.add(tfGuestName);
	    order.add(cbGender.getEditor().getEditorComponent());
	    order.add(ftfNoOfAdult);
	    order.add(ftfNoOfChild);
	    order.add(cbPaymentType.getEditor().getEditorComponent());
	    order.add(ftfCurrency);
	    order.add(ftfPayInPHP);
	    order.add(ftfPayInKRW);
	    order.add(ftfPayInDate);
	    order.add(ftfPayOutPHP);
	    order.add(ftfPayOutKRW);
	    order.add(ftfPayOutDate);
	    order.add(ftfIncomePHP);
	    order.add(ftfIncomeKRW);
	    
	    MyOwnFocusTraversalPolicy newPolicy = new MyOwnFocusTraversalPolicy(order);
		
	    this.setFocusTraversalPolicy(newPolicy);
	}
	
	public void setTextFieldFocusListener(FocusListener listener){
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JFormattedTextField.class) || c.getClass().equals(JTextField.class) ){
				((JTextField)c).addFocusListener(listener);
			}
		}
	}
	
	public void setTextFieldDocumentListener(DocumentListener listener){
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JFormattedTextField.class) || c.getClass().equals(JTextField.class) ){
				((JTextField)c).getDocument().addDocumentListener(listener);
			}
		}
	}
	
	public void setTextAreaDocumentListener(DocumentListener listener){
		taNote.getDocument().addDocumentListener(listener);
		taRemark.getDocument().addDocumentListener(listener);
	}
	
	public void setBtnAddAirlineListener(ActionListener listener){
		btnAddAirline.addActionListener(listener);
	}
	
	public void setBtnAddFlightListener(ActionListener listener){
		btnAddFlight.addActionListener(listener);
	}
	
	public void setBtnAddOriginListener(ActionListener listener){
		btnAddOrigin.addActionListener(listener);
	}
	
	public void setBtnAddDestinationListener(ActionListener listener){
		btnAddDestination.addActionListener(listener);
	}
	
	public void setBtnAddRTListener(ActionListener listener){
		btnAddRT.addActionListener(listener);
	}
	
	public void setBtnExportPOListener(ActionListener listener){
		btnExportPO.addActionListener(listener);
	}
	
	public void setBtnExportIVListener(ActionListener listener){
		btnExportIV.addActionListener(listener);
	}
	
	public void setBtnAddPTListener(ActionListener listener){
		btnAddPT.addActionListener(listener);
	}
	public void setBtnSaveListener(ActionListener listener){
		btnSave.addActionListener(listener);
	}
	
	public void setBtnCancelListener(ActionListener listener){
		btnCancel.addActionListener(listener);
	}
	
	public boolean isInputValid(){
		Border red = BorderFactory.createLineBorder(Color.red);
		Border tfBorder = new JTextField().getBorder();
		Border cbBorder = new JComboBox().getBorder();
		String message = "";
		
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JTextField.class) || 
				c.getClass().equals(JFormattedTextField.class)){
				
				JTextField tf = (JTextField)c;
				if(!tf.getName().equals("Record Locator") && !tf.getName().equals("Option To Pay") &&
						!tf.getName().equals("Option To Final") && 
						!tf.getName().equals("Currency") && 
						!tf.getName().equals("Pay In - PHP") && !tf.getName().equals("Pay In - KRW") &&
						!tf.getName().equals("Pay In - Date") &&
						!tf.getName().equals("Pay Out - PHP") && !tf.getName().equals("Pay Out - KRW") &&
						!tf.getName().equals("Pay Out - Date") &&
						!tf.getName().equals("Income - PHP") && !tf.getName().equals("Income - KRW") &&
						tf.getText().length() == 0){
					
					message += tf.getName() + "\n";
					
					tf.setBorder(red);
				}
				else{
					tf.setBorder(tfBorder);
				}
			}
			else if(c.getClass().equals(JComboBox.class)){
				JComboBox cb = (JComboBox)c;
				
				if(cb.getSelectedIndex() == -1){
					message += cb.getName() + "\n";
					cb.setBorder(red);
				}
				else{
					cb.setBorder(cbBorder);
				}
			}
		}
		
		if(!message.equals("")){
			JOptionPane.showMessageDialog(this,
					"Please fill the following:\n"+message,
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public FlightReservation getAllData(){
		FlightReservation fr = new FlightReservation(
				this.fr.getCreatedBy(),
				this.fr.getCreatedAt(),
				cbAirline.getSelectedItem().toString(),
				cbFlightNumber.getSelectedItem().toString(), 
				ftfDepartureDate.getText(), 
				ftfDepartureTime.getText(),
				ftfArrivalTime.getText(),
				cbOrigin.getSelectedItem().toString(), 
				cbDestination.getSelectedItem().toString(), 
				tfRecordLocator.getText(),
				
				cbReservationType.getSelectedItem().toString(),
				ftfReservationDate.getText(),
				ftfOptionToPay.getText(),
				Double.parseDouble(ftfAmountToPay.getValue().toString()),
				ftfOptionToFinal.getText(),
				Double.parseDouble(ftfTotalPayment.getValue().toString()),
				cbTotalPaymentType.getSelectedItem().toString(),
				
				tfGuestName.getText(),
				cbGender.getSelectedItem().toString(), 
				Integer.parseInt(ftfNoOfAdult.getValue().toString()), 
				Integer.parseInt(ftfNoOfChild.getValue().toString()), 
				cbPaymentType.getSelectedItem().toString(),
				Double.parseDouble(ftfPayInPHP.getValue().toString()), 
				Double.parseDouble(ftfPayInKRW.getValue().toString()), 
				ftfPayInDate.getText(),
				Double.parseDouble(ftfPayOutPHP.getValue().toString()), 
				Double.parseDouble(ftfPayOutKRW.getValue().toString()), 
				ftfPayOutDate.getText(),
				Double.parseDouble(ftfIncomePHP.getValue().toString()), 
				Double.parseDouble(ftfIncomeKRW.getValue().toString()), 
				taNote.getText(),
				taRemark.getText());

		fr.setId(this.fr.getId());

		return fr;
	}
	
	public void updateView(FlightReservation fr){
		this.fr = fr;
		
		cbAirline.setSelectedItem(fr.getAirline());
		cbFlightNumber.setSelectedItem(fr.getFlightNumber());
		ftfDepartureDate.setText(fr.getDepartureDate()); 
		ftfDepartureTime.setText(fr.getDepartureTime());
		ftfArrivalTime.setText(fr.getArrivalTime());
		
		cbOrigin.setSelectedItem(fr.getOrigin()); 
		cbDestination.setSelectedItem(fr.getDestination()); 
		tfRecordLocator.setText(fr.getRecordLocator());
		
		cbReservationType.setSelectedItem(fr.getReservationType());
		ftfReservationDate.setText(fr.getReservationDate());
		ftfOptionToPay.setText(fr.getOptionToPay());
		ftfAmountToPay.setValue(fr.getAmountToPay());
		ftfOptionToFinal.setText(fr.getOptionToFinal());
		ftfTotalPayment.setValue(fr.getTotalPayment());
		cbTotalPaymentType.setSelectedItem(fr.getTotalPaymentType());
		
		tfGuestName.setText(fr.getGuestName());
		cbGender.setSelectedItem(fr.getGender());
		ftfNoOfAdult.setValue(fr.getNumberOfAdult()); 
		ftfNoOfChild.setValue(fr.getNumberOfChild());
		
		cbPaymentType.setSelectedItem(fr.getPaymentType()); 
		ftfPayInPHP.setValue(fr.getPayInPHP()); 
		ftfPayInKRW.setValue(fr.getPayInKRW());
		ftfPayInDate.setText(fr.getPayInDate());
		ftfPayOutPHP.setValue(fr.getPayOutPHP()); 
		ftfPayOutKRW.setValue(fr.getPayOutKRW());
		ftfPayOutDate.setText(fr.getPayOutDate());
		ftfIncomePHP.setValue(fr.getIncomePHP()); 
		ftfIncomeKRW.setValue(fr.getIncomeKRW());
		
		taNote.setText(fr.getNote());
		taRemark.setText(fr.getRemark());
		
		ArrayList<FRHistory> frhs = model.getAllFRHistory(fr.getId());
		DefaultListModel listmodel = (DefaultListModel) lHistory.getModel();
		
		if(fr.getId() > 0){
			listmodel.addElement(fr.getCreatedAt() + " Created by: " + fr.getCreatedBy());
		}

		for(FRHistory frh : frhs){
			listmodel.addElement(frh.getDate() + " Edited by: " + frh.getName());
		}
	}
	
	public void updateAirline(ArrayList<String> list){
		cbAirline.removeAllItems();
		
		for(String name : list){
			cbAirline.addItem(name);
		}
	}
	
	public void updateFlight(ArrayList<String> list){
		cbFlightNumber.removeAllItems();
		
		for(String name : list){
			cbFlightNumber.addItem(name);
		}
	}
	
	public void updateCity(ArrayList<String> list){
		cbOrigin.removeAllItems();
		cbDestination.removeAllItems();
		
		for(String name : list){
			cbOrigin.addItem(name);
			cbDestination.addItem(name);
		}
	}
	
	public void updateReservationType(ArrayList<String> list){
		cbReservationType.removeAllItems();
		
		for(String name : list){
			cbReservationType.addItem(name);
		}
	}
	
	public void updatePaymentType(ArrayList<String> list){
		cbPaymentType.removeAllItems();
		
		for(String name : list){
			cbPaymentType.addItem(name);
		}
	}

	public void listeners(){
		setAllEditable(false);
		
		ftfCurrency.addFocusListener(new FocusListener() {
			private double old;
			
			public void focusLost(FocusEvent arg0) {

				try{
					double currency = Double.parseDouble(ftfCurrency.getText().replaceAll(",", ""));
					
					if(currency == 0){
						setAllEditable(false);
					}
					else if(currency > 0){
						setAllEditable(true);
					}else{
						ftfCurrency.setValue(old);
					}
				
				}catch(Exception e){
					ftfCurrency.setValue(old);
				}
			}
			
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				old = Double.parseDouble(ftfCurrency.getText().replaceAll(",", ""));
			}
		});
		
		setAutoConvertListener(ftfPayInPHP, ftfPayInKRW);
		setAutoConvertListener(ftfPayOutPHP, ftfPayOutKRW);
		
		lHistory.addListSelectionListener(new ListSelectionListener(){
			Border red = BorderFactory.createLineBorder(Color.red);
			Border tfBorder = new JTextField().getBorder();
			Border cbBorder = new JComboBox().getBorder();
			Border taBorder = new JTextArea().getBorder();
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int i = lHistory.getSelectedIndex();
				
				if(i > 0){
					FRHistory frh = model.getAllFRHistory(fr.getId()).get(i-1);
					
					if(frh.isAirlineEdited()){
						cbAirline.setBorder(red);
					}
					else{
						cbAirline.setBorder(cbBorder);
					}
					
					if(frh.isFlightNumberEdited()){
						cbFlightNumber.setBorder(red);
					}
					else{
						cbFlightNumber.setBorder(cbBorder);
					}
					
					if(frh.isDepartureDateEdited()){
						ftfDepartureDate.setBorder(red);
					}
					else{
						ftfDepartureDate.setBorder(tfBorder);
					}
					
					if(frh.isDepartureTimeEdited()){
						ftfDepartureTime.setBorder(red);
					}
					else{
						ftfDepartureTime.setBorder(tfBorder);
					}
					
					if(frh.isArrivalTimeEdited()){
						ftfArrivalTime.setBorder(red);
					}
					else{
						ftfArrivalTime.setBorder(tfBorder);
					}
					
					if(frh.isOriginEdited()){
						cbOrigin.setBorder(red);
					}
					else{
						cbOrigin.setBorder(cbBorder);
					}
					
					if(frh.isDestinationEdited()){
						cbDestination.setBorder(red);
					}
					else{
						cbDestination.setBorder(cbBorder);
					}
					
					if(frh.isRecordLocatorEdited()){
						tfRecordLocator.setBorder(red);
					}
					else{
						tfRecordLocator.setBorder(tfBorder);
					}
					
					if(frh.isReservationTypeEdited()){
						cbReservationType.setBorder(red);
					}
					else{
						cbReservationType.setBorder(cbBorder);
					}
					
					if(frh.isReservationDateEdited()){
						ftfReservationDate.setBorder(red);
					}
					else{
						ftfReservationDate.setBorder(tfBorder);
					}
					
					if(frh.isOptionToPayEdited()){
						ftfOptionToPay.setBorder(red);
					}
					else{
						ftfOptionToPay.setBorder(tfBorder);
					}
					
					if(frh.isAmountToPayEdited()){
						ftfAmountToPay.setBorder(red);
					}
					else{
						ftfAmountToPay.setBorder(tfBorder);
					}
					
					if(frh.isOptionToFinalEdited()){
						ftfOptionToFinal.setBorder(red);
					}
					else{
						ftfOptionToFinal.setBorder(tfBorder);
					}
					
					if(frh.isTotalPaymentEdited()){
						ftfTotalPayment.setBorder(red);
					}
					else{
						ftfTotalPayment.setBorder(tfBorder);
					}
					
					if(frh.isTotalPaymentTypeEdited()){
						cbTotalPaymentType.setBorder(red);
					}
					else{
						cbTotalPaymentType.setBorder(cbBorder);
					}
					
					if(frh.isGuestNameEdited()){
						tfGuestName.setBorder(red);
					}
					else{
						tfGuestName.setBorder(tfBorder);
					}
					
					if(frh.isGenderEdited()){
						cbGender.setBorder(red);
					}
					else{
						cbGender.setBorder(cbBorder);
					}
					
					if(frh.isNumberOfAdultEdited()){
						ftfNoOfAdult.setBorder(red);
					}
					else{
						ftfNoOfAdult.setBorder(tfBorder);
					}
					
					if(frh.isNumberOfChildEdited()){
						ftfNoOfChild.setBorder(red);
					}
					else{
						ftfNoOfChild.setBorder(tfBorder);
					}
					
					if(frh.isPaymentTypeEdited()){
						cbPaymentType.setBorder(red);
					}
					else{
						cbPaymentType.setBorder(cbBorder);
					}
					
					if(frh.isPayInPHPEdited()){
						ftfPayInPHP.setBorder(red);
					}
					else{
						ftfPayInPHP.setBorder(tfBorder);
					}
					
					if(frh.isPayInKRWEdited()){
						ftfPayInKRW.setBorder(red);
					}
					else{
						ftfPayInKRW.setBorder(tfBorder);
					}
					
					if(frh.isPayInDateEdited()){
						ftfPayInDate.setBorder(red);
					}
					else{
						ftfPayInDate.setBorder(tfBorder);
					}
					
					if(frh.isPayOutPHPEdited()){
						ftfPayOutPHP.setBorder(red);
					}
					else{
						ftfPayOutPHP.setBorder(tfBorder);
					}
					
					if(frh.isPayOutKRWEdited()){
						ftfPayOutKRW.setBorder(red);
					}
					else{
						ftfPayOutKRW.setBorder(tfBorder);
					}
					
					if(frh.isPayOutDateEdited()){
						ftfPayOutDate.setBorder(red);
					}
					else{
						ftfPayOutDate.setBorder(tfBorder);
					}
					
					if(frh.isIncomePHPEdited()){
						ftfIncomePHP.setBorder(red);
					}
					else{
						ftfIncomePHP.setBorder(tfBorder);
					}
					
					if(frh.isIncomeKRWEdited()){
						ftfIncomeKRW.setBorder(red);
					}
					else{
						ftfIncomeKRW.setBorder(tfBorder);
					}
					
					if(frh.isNoteEdited()){
						taNote.setBorder(red);
					}
					else{
						taNote.setBorder(taBorder);
					}
					
					if(frh.isRemarkEdited()){
						taRemark.setBorder(red);
					}
					else{
						taRemark.setBorder(taBorder);
					}
				}
			}});
	}
	
	public void setAutoConvertListener(final JFormattedTextField ftfphp, final JFormattedTextField ftfkrw){		
		
		ftfphp.addFocusListener(new FocusListener() {
			private double oldValue;
			
			public void focusLost(FocusEvent arg0) {
				try{
					double php = Double.parseDouble(ftfphp.getText().replaceAll(",", ""));
					double currency = Double.parseDouble(ftfCurrency.getValue().toString());
					
					if(currency > 0){
						double krw = php * currency;
						ftfkrw.setValue(krw);
						computeIncome();
					}
				}catch(Exception e){
					ftfphp.setValue(oldValue);
				}
			}
			
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				oldValue = Double.parseDouble(ftfphp.getText().replaceAll(",", ""));
			}
		});
		
		ftfkrw.addFocusListener(new FocusListener() {
			private double oldValue;
			
			public void focusLost(FocusEvent arg0) {
				try{
					double krw = Double.parseDouble(ftfkrw.getText().replaceAll(",", ""));
					double currency = Double.parseDouble(ftfCurrency.getValue().toString());
					
					if(currency > 0){
						double php = krw / currency;
						ftfphp.setValue(php);
						computeIncome();
					}
				}catch(Exception e){
					ftfkrw.setValue(oldValue);
				}
			}
			
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				oldValue = Double.parseDouble(ftfkrw.getText().replaceAll(",", ""));
			}
		});
		
	}
	
	public void setAllEditable(boolean b){
		ftfPayInPHP.setEditable(b);
		ftfPayInKRW.setEditable(b);
		ftfPayOutPHP.setEditable(b);
		ftfPayOutKRW.setEditable(b);
	}
	
	public void computeIncome(){
		double php = Double.parseDouble(ftfPayInPHP.getText().replaceAll(",", "")) 
			- Double.parseDouble(ftfPayOutPHP.getText().replaceAll(",", ""));;
		double krw = Double.parseDouble(ftfPayInKRW.getText().replaceAll(",", "")) 
			- Double.parseDouble(ftfPayOutKRW.getText().replaceAll(",", ""));;
			
		ftfIncomePHP.setValue(php);
		ftfIncomeKRW.setValue(krw);
	}
}
