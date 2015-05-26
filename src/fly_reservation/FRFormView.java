package fly_reservation;

import hotel_reservation.HRHistory;

import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import references.AutoCompletion;
import references.JTextFieldHintUI;
import reservation_system.RSModel;

public class FRFormView extends JFrame{
	private FlightReservation fr = new FlightReservation();
	
	private JLabel lblDeparture, lblFlightNo, lblOrigin, lblDestination, lblReservationType,
		lblPaymentType, lblGuestName, lblNoOfAdult, lblNoOfChild, lblGender, lblPayIn, lblPayInPHP,
		lblPayInKRW, lblPayInDate, lblPayOut , lblPayOutPHP, lblPayOutKRW, lblPayOutDate,
		lblIncome, lblIncomePHP, lblIncomeKRW, lblNote, lblCurrency, lblCurrencyNote, 
		lblHistory;
	
	private JTextField tfGuestName;
	
	JFormattedTextField ftfPayInPHP, ftfPayInKRW, ftfPayInDate, ftfPayOutPHP,
						ftfPayOutKRW, ftfPayOutDate, ftfIncomePHP, ftfIncomeKRW,
						ftfCurrency, ftfNoOfAdult, ftfNoOfChild, ftfDeparture;
	
	private JTextArea taNote;
	
	private JList lHistory;
	
	private JComboBox  cbFlightNo, cbOrigin, cbDestination, cbReservationType, cbGender,
		cbPaymentType;
	
	private JButton btnAddFlight;
	private JButton btnAddOrigin;
	private JButton btnAddDestination;
	private JButton btnAddRT;
	private JButton btnAddPT;
	private JButton btnSave;
	private JButton btnCancel;
	
	private RSModel model;
	
	public FRFormView(RSModel model){
		super("Flight Reservation Form");
		setSize(875,360);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblDeparture = new JLabel("Departure Date");
		lblDeparture.setBounds(10, 10, 100, 20);
		add(lblDeparture);
		
		lblFlightNo = new JLabel("Flight No.");
		lblFlightNo.setBounds(10, 40, 100, 20);
		add(lblFlightNo);
		
		lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(10, 70, 100, 20);
		add(lblOrigin);
		
		lblDestination = new JLabel("Destination");
		lblDestination.setBounds(10, 100, 100, 20);
		add(lblDestination);
		
		lblReservationType = new JLabel("Reservation Type");
		lblReservationType.setBounds(10, 130, 100, 20);
		add(lblReservationType);
		
		lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(280, 10, 100, 20);
		add(lblPaymentType);
		
		lblGuestName = new JLabel("Guest Name");
		lblGuestName.setBounds(280, 40, 100, 20);
		add(lblGuestName);
		
		lblNoOfAdult = new JLabel("Adult");
		lblNoOfAdult.setBounds(280, 70, 50, 20);
		add(lblNoOfAdult);
		
		lblNoOfChild = new JLabel("Child");
		lblNoOfChild.setBounds(390, 70, 50, 20);
		add(lblNoOfChild);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(280, 100, 100, 20);
		add(lblGender);
		
		lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(510, 10, 100, 20);
		add(lblCurrency);
		
		lblCurrencyNote = new JLabel("(PHP to KRW)");
		lblCurrencyNote.setBounds(710, 10, 100, 20);
		add(lblCurrencyNote);
		
		lblPayIn = new JLabel("Pay In");
		lblPayIn.setBounds(510, 40, 100, 20);
		add(lblPayIn);
		
		lblPayInPHP = new JLabel("PHP");
		lblPayInPHP.setBounds(580, 40, 30, 20);
		add(lblPayInPHP);
		
		lblPayInKRW = new JLabel("KRW");
		lblPayInKRW.setBounds(730, 40, 30, 20);
		add(lblPayInKRW);
		
		lblPayInDate = new JLabel("Date");
		lblPayInDate.setBounds(580, 70, 30, 20);
		add(lblPayInDate);
		
		lblPayOut = new JLabel("Pay Out");
		lblPayOut.setBounds(510, 100, 100, 20);
		add(lblPayOut);
		
		lblPayOutPHP = new JLabel("PHP");
		lblPayOutPHP.setBounds(580, 100, 30, 20);
		add(lblPayOutPHP);
		
		lblPayOutKRW = new JLabel("KRW");
		lblPayOutKRW.setBounds(730, 100, 30, 20);
		add(lblPayOutKRW);
		
		lblPayOutDate = new JLabel("Date");
		lblPayOutDate.setBounds(580, 130, 30, 20);
		add(lblPayOutDate);
		
		lblIncome = new JLabel("Income");
		lblIncome.setBounds(510, 160, 100, 20);
		add(lblIncome);
		
		lblIncomePHP = new JLabel("PHP");
		lblIncomePHP.setBounds(580, 160, 30, 20);
		add(lblIncomePHP);
		
		lblIncomeKRW = new JLabel("KRW");
		lblIncomeKRW.setBounds(730, 160, 30, 20);
		add(lblIncomeKRW);
		
		lblNote = new JLabel("Note");
		lblNote.setBounds(10, 190, 100, 20);
		add(lblNote);
		
		lblHistory = new JLabel("Edit History");
		lblHistory.setBounds(480, 190, 100, 20);
		add(lblHistory);
		
		ftfDeparture = new JFormattedTextField(model.DATE_FORMAT);
		ftfDeparture.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfDeparture.setBounds(120,10,140,20);
		ftfDeparture.setName("Departure Date");
		add(ftfDeparture);
		
		cbFlightNo = new JComboBox(model.getFlightNo().toArray());
		cbFlightNo.setEditable(true);
		new AutoCompletion(cbFlightNo);
		cbFlightNo.setBounds(120, 40, 120, 20);
		cbFlightNo.setName("Flight No.");
		add(cbFlightNo);
		
		btnAddFlight = new JButton("+");
		btnAddFlight.setMargin(new Insets(0,0,0,0));
		btnAddFlight.setBounds(240, 40, 20, 20);
		add(btnAddFlight);
		
		cbOrigin = new JComboBox(model.getCity().toArray());
		cbOrigin.setEditable(true);
		new AutoCompletion(cbOrigin);
		cbOrigin.setBounds(120, 70, 120, 20);
		cbOrigin.setName("Origin");
		add(cbOrigin);
		
		btnAddOrigin = new JButton("+");
		btnAddOrigin.setMargin(new Insets(0,0,0,0));
		btnAddOrigin.setBounds(240, 70, 20, 20);
		add(btnAddOrigin);
		
		cbDestination = new JComboBox(model.getCity().toArray());
		cbDestination.setEditable(true);
		new AutoCompletion(cbDestination);
		cbDestination.setBounds(120, 100, 120, 20);
		cbDestination.setName("Destination");
		add(cbDestination);
		
		btnAddDestination = new JButton("+");
		btnAddDestination.setMargin(new Insets(0,0,0,0));
		btnAddDestination.setBounds(240, 100, 20, 20);
		add(btnAddDestination);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(120, 130, 120, 20);
		cbReservationType.setName("Reservation Type");
		add(cbReservationType);
		
		btnAddRT = new JButton("+");
		btnAddRT.setMargin(new Insets(0,0,0,0));
		btnAddRT.setBounds(240, 130, 20, 20);
		add(btnAddRT);
		
		cbPaymentType = new JComboBox(model.getPaymentType().toArray());
		cbPaymentType.setEditable(true);
		new AutoCompletion(cbPaymentType);
		cbPaymentType.setBounds(370, 10, 100, 20);
		cbPaymentType.setName("Payment Type");
		add(cbPaymentType);
		
		btnAddPT = new JButton("+");
		btnAddPT.setMargin(new Insets(0,0,0,0));
		btnAddPT.setBounds(470, 10, 20, 20);
		add(btnAddPT);
		
		tfGuestName = new JTextField();
		tfGuestName.setBounds(370, 40, 120, 20);
		tfGuestName.setName("Guest Name");
		add(tfGuestName);
		
		ftfNoOfAdult = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfAdult.setValue(new Integer(0));
		ftfNoOfAdult.setBounds(320, 70, 50, 20);
		ftfNoOfAdult.setName("Number of Adult");
		add(ftfNoOfAdult);
		
		ftfNoOfChild = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfChild.setValue(new Integer(0));
		ftfNoOfChild.setBounds(440, 70, 50, 20);
		ftfNoOfChild.setName("Number of Child");
		add(ftfNoOfChild);
		
		cbGender = new JComboBox(new String[]{"Male","Female"});
		cbGender.setEditable(true);
		new AutoCompletion(cbGender);
		cbGender.setBounds(370, 100, 120, 20);
		cbGender.setName("Gender");
		add(cbGender);
		
		ftfCurrency = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfCurrency.setValue(new Double(0));
		ftfCurrency.setUI(new JTextFieldHintUI("PHP to KRW", Color.gray));
		ftfCurrency.setBounds(610, 10, 100, 20);
		ftfCurrency.setName("Currency");
		add(ftfCurrency);
		
		ftfPayInPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInPHP.setValue(new Double(0));
		ftfPayInPHP.setBounds(610, 40, 100, 20);
		ftfPayInPHP.setName("Pay In - PHP");
		add(ftfPayInPHP);
		
		ftfPayInKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInKRW.setValue(new Double(0));
		ftfPayInKRW.setBounds(760, 40, 100, 20);
		ftfPayInKRW.setName("Pay In - KRW");
		add(ftfPayInKRW);
		
		ftfPayInDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayInDate.setName("Pay In - Date");
		ftfPayInDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayInDate.setBounds(610, 70, 100, 20);
		add(ftfPayInDate);
		
		ftfPayOutPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutPHP.setValue(new Double(0));
		ftfPayOutPHP.setBounds(610, 100, 100, 20);
		ftfPayOutPHP.setName("Pay Out - PHP");
		add(ftfPayOutPHP);
		
		ftfPayOutKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutKRW.setValue(new Double(0));
		ftfPayOutKRW.setBounds(760, 100, 100, 20);
		ftfPayOutKRW.setName("Pay Out - KRW");
		add(ftfPayOutKRW);
		
		ftfPayOutDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayOutDate.setName("Pay Out - Date");
		ftfPayOutDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayOutDate.setBounds(610, 130, 100, 20);
		add(ftfPayOutDate);
		
		ftfIncomePHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomePHP.setEditable(false);
		ftfIncomePHP.setValue(new Double(0));
		ftfIncomePHP.setBounds(610, 160, 100, 20);
		ftfIncomePHP.setName("Income - PHP");
		add(ftfIncomePHP);
		
		ftfIncomeKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomeKRW.setEditable(false);
		ftfIncomeKRW.setValue(new Double(0));
		ftfIncomeKRW.setBounds(760, 160, 100, 20);
		ftfIncomeKRW.setName("Income - KRW");
		add(ftfIncomeKRW);
		
		taNote = new JTextArea("");
		taNote.setName("Note");
		taNote.setLineWrap(true);
		taNote.setWrapStyleWord(false);
		
		JScrollPane jp = new JScrollPane(taNote);
		jp.setBounds(120, 190, 300, 100);
		add(jp);
		
		lHistory = new JList(new DefaultListModel());
		lHistory.setName("History");
		
		JScrollPane jp1 = new JScrollPane(lHistory);
		jp1.setBounds(560, 190, 300, 100);
		add(jp1);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(335, 300, 90, 20);
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(440, 300, 90, 20);
		add(btnCancel);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
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
				if(!tf.getName().equals("Currency") && 
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
				ftfDeparture.getText(), 
				cbOrigin.getSelectedItem().toString(), 
				cbDestination.getSelectedItem().toString(), 
				cbFlightNo.getSelectedItem().toString(), 
				cbReservationType.getSelectedItem().toString(),
				tfGuestName.getText(),
				cbPaymentType.getSelectedItem().toString(), 
				cbGender.getSelectedItem().toString(), 
				Integer.parseInt(ftfNoOfAdult.getValue().toString()), 
				Integer.parseInt(ftfNoOfChild.getValue().toString()), 
				Double.parseDouble(ftfPayInPHP.getValue().toString()), 
				Double.parseDouble(ftfPayInKRW.getValue().toString()), 
				ftfPayInDate.getText(),
				Double.parseDouble(ftfPayOutPHP.getValue().toString()), 
				Double.parseDouble(ftfPayOutKRW.getValue().toString()), 
				ftfPayOutDate.getText(),
				Double.parseDouble(ftfIncomePHP.getValue().toString()), 
				Double.parseDouble(ftfIncomeKRW.getValue().toString()), 
				taNote.getText());

		fr.setId(this.fr.getId());

		return fr;
	}
	
	public void updateView(FlightReservation fr){
		this.fr = fr;

		ftfDeparture.setText(fr.getDeparture()); 
		cbOrigin.setSelectedItem(fr.getOrigin()); 
		cbDestination.setSelectedItem(fr.getDestination()); 
		cbFlightNo.setSelectedItem(fr.getFlightNo()); 
		cbReservationType.setSelectedItem(fr.getReservationType());
		tfGuestName.setText(fr.getGuestName());
		cbPaymentType.setSelectedItem(fr.getPaymentType()); 
		cbGender.setSelectedItem(fr.getGender());
		ftfNoOfAdult.setValue(fr.getNumberOfAdult()); 
		ftfNoOfChild.setValue(fr.getNumberOfChild()); 
		ftfPayInPHP.setValue(fr.getPayInPHP()); 
		ftfPayInKRW.setValue(fr.getPayInKRW());
		ftfPayInDate.setText(fr.getPayInDate());
		ftfPayOutPHP.setValue(fr.getPayOutPHP()); 
		ftfPayOutKRW.setValue(fr.getPayOutKRW());
		ftfPayOutDate.setText(fr.getPayOutDate());
		ftfIncomePHP.setValue(fr.getIncomePHP()); 
		ftfIncomeKRW.setValue(fr.getIncomeKRW());
		taNote.setText(fr.getNote());
		
		ArrayList<FRHistory> frhs = model.getAllFRHistory(fr.getId());
		DefaultListModel listmodel = (DefaultListModel) lHistory.getModel();
		
		if(fr.getId() > 0){
			listmodel.addElement(fr.getCreatedAt() + " Created by: " + fr.getCreatedBy());
		}

		for(FRHistory frh : frhs){
			listmodel.addElement(frh.getDate() + " Edited by: " + frh.getName());
		}
	}
	
	public void updateFlight(ArrayList<String> list){
		cbFlightNo.removeAllItems();
		
		for(String name : list){
			cbFlightNo.addItem(name);
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
					
					if(frh.isDepartureEdited()){
						ftfDeparture.setBorder(red);
					}
					else{
						ftfDeparture.setBorder(tfBorder);
					}
					if(frh.isFlightNumberEdited()){
						cbFlightNo.setBorder(red);
					}
					else{
						cbFlightNo.setBorder(cbBorder);
					}
					if(frh.isOriginEdited()){
						cbOrigin.setBorder(red);
					}
					else{
						cbOrigin.setBorder(cbBorder);
					}
					if(frh.isDestinationEdite()){
						cbDestination.setBorder(red);
					}
					else{
						cbDestination.setBorder(cbBorder);
					}
					if(frh.isReservationTypeEdite()){
						cbReservationType.setBorder(red);
					}
					else{
						cbReservationType.setBorder(cbBorder);
					}
					if(frh.isPaymentTypeEdite()){
						cbPaymentType.setBorder(red);
					}
					else{
						cbPaymentType.setBorder(cbBorder);
					}
					if(frh.isGuestNameEdited()){
						tfGuestName.setBorder(red);
					}
					else{
						tfGuestName.setBorder(tfBorder);
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
					if(frh.isGenderrEdited()){
						cbGender.setBorder(red);
					}
					else{
						cbGender.setBorder(cbBorder);
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
