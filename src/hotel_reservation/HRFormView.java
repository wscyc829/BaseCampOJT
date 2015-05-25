package hotel_reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import references.AutoCompletion;
import references.JTextFieldHintUI;
import reservation_system.RSModel;

public class HRFormView extends JFrame{
	private HotelReservation hr = new HotelReservation();
	
	private JLabel lblCheckIn, lblCheckOut, lblHotelOrResort,
		lblGuestName, lblAttendeeNumuber, lblNoOfAdult, lblNoOfChild, 
		lblNoOfNights, lblRoomType, lblNoOfRooms, lblOptionToPay, lblReservationDate, 
		lblReservationType, lblCompany, lblPaymentType, lblReceiptNo, lblCurrency, lblCurrencyNote,
		lblPayIn, lblPayInPHP, lblPayInKRW, lblPayInDate, 
		lblPayOut, lblPayOutPHP, lblPayOutKRW, lblPayOutDate, 
		lblIncome, lblIncomePHP, lblIncomeKRW, lblNote, lblStatus, lblConfirmationNumber,
		lblBreakfast, lblHistory;
	
	private JFormattedTextField ftfCheckIn, ftfCheckOut, ftfNoOfAdult, ftfNoOfChild,
		ftfNoOfNights, ftfNoOfRooms, ftfOptionToPay, ftfReservationDate, ftfCurrency, ftfPayInPHP, ftfPayInKRW,
		ftfPayInDate, ftfPayOutPHP, ftfPayOutKRW, ftfPayOutDate, ftfIncomePHP,
		ftfIncomeKRW;
	
	private JTextField tfGuestName, tfRoomType, tfCompany, tfReceiptNo, tfConfirmationNumber;
	
	private JTextArea taNote;
	
	private JList lHistory;
	
	private JComboBox cbHotelOrResort, cbReservationType,
		cbPaymentType, cbStatus, cbBreakfast;
	
	private JButton btnAddHR;
	
	private JButton btnAddRT;
	
	private JButton btnAddPT;
	
	private JButton btnExportV;
	
	private JButton btnExportVW;
	
	private JButton btnExportBO;
	
	private JButton btnExportIV;
	
	private JButton btnExportIVW;
	
	private JButton btnSave;
	
	private JButton btnCancel;
	
	private RSModel model;
	
	public HRFormView(RSModel model){
		super("Hotel Reservation Form");
		setSize(725, 570);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblCheckIn = new JLabel("Check In");
		lblCheckIn.setBounds(10, 10, 100, 20);
		add(lblCheckIn);
		
		lblCheckOut = new JLabel("Check Out");
		lblCheckOut.setBounds(10, 40, 100, 20);
		add(lblCheckOut);
		
		lblHotelOrResort = new JLabel("Hotel/Resort");
		lblHotelOrResort.setBounds(10, 70, 100, 20);
		add(lblHotelOrResort);
		
		lblGuestName = new JLabel("Guest Name");
		lblGuestName.setBounds(10, 100, 100, 20);
		add(lblGuestName);
		
		lblAttendeeNumuber = new JLabel("Attendee Number");
		lblAttendeeNumuber.setBounds(10, 130, 100, 20);
		add(lblAttendeeNumuber);
		
		lblNoOfAdult = new JLabel("Adult");
		lblNoOfAdult.setBounds(180, 130, 50, 20);
		add(lblNoOfAdult);
		
		lblNoOfChild = new JLabel("Child");
		lblNoOfChild.setBounds(300, 130, 50, 20);
		add(lblNoOfChild);
		
		lblNoOfNights = new JLabel("Number of Nights");
		lblNoOfNights.setBounds(10, 160, 100, 20);
		add(lblNoOfNights);
		
		lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(10, 190, 100, 20);
		add(lblRoomType);
		
		lblNoOfRooms = new JLabel("Number of Rooms");
		lblNoOfRooms.setBounds(10, 220, 110, 20);
		add(lblNoOfRooms);
		
		lblOptionToPay = new JLabel("Option To Pay");
		lblOptionToPay.setBounds(10, 250, 100, 20);
		add(lblOptionToPay);
		
		lblReservationDate = new JLabel("Reservation Date");
		lblReservationDate.setBounds(10, 280, 100, 20);
		add(lblReservationDate);
		
		lblReservationType = new JLabel("Reservation Type");
		lblReservationType.setBounds(10, 310, 100, 20);
		add(lblReservationType);
		
		lblCompany = new JLabel("Company");
		lblCompany.setBounds(10, 340, 100, 20);
		add(lblCompany);
		
		lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(360, 10, 100, 20);
		add(lblPaymentType);
		
		lblReceiptNo = new JLabel("Receipt No.");
		lblReceiptNo.setBounds(360, 40, 100, 20);
		add(lblReceiptNo);
		
		lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(360, 70, 100, 20);
		add(lblCurrency);
		
		lblCurrencyNote = new JLabel("(PHP To KRW)");
		lblCurrencyNote.setBounds(560, 70, 100, 20);
		add(lblCurrencyNote);
		
		lblPayIn = new JLabel("Pay In");
		lblPayIn.setBounds(360, 100, 100, 20);
		add(lblPayIn);
		
		lblPayInPHP = new JLabel("PHP");
		lblPayInPHP.setBounds(430, 100, 50, 20);
		add(lblPayInPHP);

		lblPayInKRW = new JLabel("KRW");
		lblPayInKRW.setBounds(580, 100, 50, 20);
		add(lblPayInKRW);
		
		lblPayInDate = new JLabel("Date");
		lblPayInDate.setBounds(430, 130, 100, 20);
		add(lblPayInDate);
		
		lblPayOut = new JLabel("Pay Out");
		lblPayOut.setBounds(360, 160, 100, 20);
		add(lblPayOut);
		
		lblPayOutPHP = new JLabel("PHP");
		lblPayOutPHP.setBounds(430, 160, 50, 20);
		add(lblPayOutPHP);
		
		lblPayOutKRW = new JLabel("KRW");
		lblPayOutKRW.setBounds(580, 160, 30, 20);
		add(lblPayOutKRW);
		
		lblPayOutDate = new JLabel("Date");
		lblPayOutDate.setBounds(430, 190, 50, 20);
		add(lblPayOutDate);
		
		lblIncome = new JLabel("Income");
		lblIncome.setBounds(360, 220, 100, 20);
		add(lblIncome);
		
		lblIncomePHP = new JLabel("PHP");
		lblIncomePHP.setBounds(430, 220, 50, 20);
		add(lblIncomePHP);

		lblIncomeKRW = new JLabel("KRW");
		lblIncomeKRW.setBounds(580, 220, 50, 20);
		add(lblIncomeKRW);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(360, 250, 100, 20);
		add(lblStatus);
		
		lblConfirmationNumber = new JLabel("Confirmation No.");
		lblConfirmationNumber.setBounds(360, 280, 100, 20);
		add(lblConfirmationNumber);
		
		lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(360, 310, 100, 20);
		add(lblBreakfast);
		
		lblNote = new JLabel("Note");
		lblNote.setBounds(10, 370, 100, 20);
		add(lblNote);
		
		lblHistory = new JLabel("Edit History");
		lblHistory.setBounds(10, 450, 100, 20);
		add(lblHistory);
		
		ftfCheckIn = new JFormattedTextField(model.DATE_FORMAT);
		ftfCheckIn.setName("Check In");
		ftfCheckIn.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfCheckIn.setBounds(120, 10, 120, 20);
		add(ftfCheckIn);
		
		ftfCheckOut = new JFormattedTextField(model.DATE_FORMAT);
		ftfCheckOut.setName("Check Out");
		ftfCheckOut.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfCheckOut.setBounds(120, 40, 120, 20);
		add(ftfCheckOut);
		
		cbHotelOrResort = new JComboBox(model.getHotelOrResort().toArray());
		cbHotelOrResort.setName("Hotel/Resort");
		cbHotelOrResort.setEditable(true);
		new AutoCompletion(cbHotelOrResort);
		cbHotelOrResort.setBounds(120, 70, 200, 20);
		add(cbHotelOrResort);
		
		btnAddHR = new JButton("+");
		btnAddHR.setMargin(new Insets(0,0,0,0));
		btnAddHR.setBounds(320, 70, 20, 20);
		add(btnAddHR);
		
		tfGuestName = new JTextField("");
		tfGuestName.setName("Guest Name");
		tfGuestName.setBounds(120, 100, 120, 20);
		add(tfGuestName);
		
		ftfNoOfAdult = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfAdult.setValue(new Integer(0));
		ftfNoOfAdult.setName("Number Of Adult");
		ftfNoOfAdult.setBounds(120, 130, 50, 20);
		add(ftfNoOfAdult);
		
		ftfNoOfChild = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfChild.setValue(new Integer(0));
		ftfNoOfChild.setName("Number Of Child");
		ftfNoOfChild.setBounds(240, 130, 50, 20);
		add(ftfNoOfChild);
		
		ftfNoOfNights = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfNights.setValue(new Integer(0));
		ftfNoOfNights.setName("Number Of Nights");
		ftfNoOfNights.setBounds(120, 160, 120, 20);
		add(ftfNoOfNights);
		
		tfRoomType = new JTextField("");
		tfRoomType.setName("Room Type");
		tfRoomType.setBounds(120, 190, 120, 20);
		add(tfRoomType);
		
		ftfNoOfRooms = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfRooms.setValue(new Integer(0));
		ftfNoOfRooms.setName("Number Of Rooms");
		ftfNoOfRooms.setBounds(120, 220, 120, 20);
		add(ftfNoOfRooms);
		
		ftfOptionToPay = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToPay.setName("Option To Pay");
		ftfOptionToPay.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToPay.setBounds(120, 250, 120, 20);
		add(ftfOptionToPay);
		
		ftfReservationDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfReservationDate.setName("Reservation Date");
		ftfReservationDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfReservationDate.setBounds(120, 280, 120, 20);
		add(ftfReservationDate);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setName("Reservation Type");
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(120, 310, 100, 20);
		add(cbReservationType);
		
		btnAddRT = new JButton("+");
		btnAddRT.setMargin(new Insets(0,0,0,0));
		btnAddRT.setBounds(220, 310, 20, 20);
		add(btnAddRT);
		
		tfCompany = new JTextField("");
		tfCompany.setName("Company");
		tfCompany.setBounds(120, 340, 120, 20);
		add(tfCompany);
		
		cbPaymentType = new JComboBox(model.getPaymentType().toArray());
		cbPaymentType.setName("Payment Type");
		cbPaymentType.setEditable(true);
		new AutoCompletion(cbPaymentType);
		cbPaymentType.setBounds(460, 10, 80, 20);
		add(cbPaymentType);
		
		btnAddPT = new JButton("+");
		btnAddPT.setMargin(new Insets(0,0,0,0));
		btnAddPT.setBounds(540, 10, 20, 20);
		add(btnAddPT);
		
		tfReceiptNo = new JTextField("");
		tfReceiptNo.setName("Receipt No");
		tfReceiptNo.setBounds(460, 40, 100, 20);
		add(tfReceiptNo);
		
		ftfCurrency = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfCurrency.setValue(new Integer(0));
		ftfCurrency.setName("Currency");
		ftfCurrency.setBounds(460, 70, 100, 20);
		add(ftfCurrency);
		
		ftfPayInPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInPHP.setValue(new Double(0));
		ftfPayInPHP.setName("Pay In - PHP");
		ftfPayInPHP.setBounds(460, 100, 100, 20);
		add(ftfPayInPHP);
		
		ftfPayInKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInKRW.setValue(new Double(0));
		ftfPayInKRW.setName("Pay In - KRW");
		ftfPayInKRW.setBounds(610, 100, 100, 20);
		add(ftfPayInKRW);
		
		ftfPayInDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayInDate.setName("Pay In - Date");
		ftfPayInDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayInDate.setBounds(460, 130, 100, 20);
		add(ftfPayInDate);
		
		ftfPayOutPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutPHP.setValue(new Double(0));
		ftfPayOutPHP.setName("Pay Out - PHP");
		ftfPayOutPHP.setBounds(460, 160, 100, 20);
		add(ftfPayOutPHP);
		
		ftfPayOutKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutKRW.setValue(new Double(0));
		ftfPayOutKRW.setName("Pay Out - KRW");
		ftfPayOutKRW.setBounds(610, 160, 100, 20);
		add(ftfPayOutKRW);
		
		ftfPayOutDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayOutDate.setName("Pay Out - Date");
		ftfPayOutDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayOutDate.setBounds(460, 190, 100, 20);
		add(ftfPayOutDate);
		
		ftfIncomePHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomePHP.setEditable(false);
		ftfIncomePHP.setValue(new Double(0));
		ftfIncomePHP.setName("Income - PHP");
		ftfIncomePHP.setBounds(460, 220, 100, 20);
		add(ftfIncomePHP);
		
		ftfIncomeKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomeKRW.setEditable(false);
		ftfIncomeKRW.setValue(new Double(0));
		ftfIncomeKRW.setName("Income - KRW");
		ftfIncomeKRW.setBounds(610, 220, 100, 20);
		add(ftfIncomeKRW);
		
		cbStatus = new JComboBox(new String[]{"Not Confirm", "Confirmed", "Cancelled"});
		cbStatus.setName("Status");
		cbStatus.setEditable(true);
		new AutoCompletion(cbStatus);
		cbStatus.setBounds(460, 250, 100, 20);
		add(cbStatus);
		
		tfConfirmationNumber = new JTextField("");
		tfConfirmationNumber.setName("Confirmation Number");
		tfConfirmationNumber.setBounds(460, 280, 100, 20);
		add(tfConfirmationNumber);
		
		cbBreakfast = new JComboBox(new String[]{"Included", "Not Included"});
		cbBreakfast.setName("Breakfast");
		cbBreakfast.setEditable(true);
		new AutoCompletion(cbBreakfast);
		cbBreakfast.setBounds(460, 310, 100, 20);
		add(cbBreakfast);
		
		taNote = new JTextArea("");
		taNote.setName("Note");
		taNote.setLineWrap(true);
		taNote.setWrapStyleWord(false);
		add(taNote);
		
		JScrollPane jp = new JScrollPane(taNote);
		jp.setBounds(120, 370, 380, 70);
		add(jp);

		lHistory = new JList(new DefaultListModel());
		lHistory.setName("History");
		lHistory.setBounds(120, 450, 380, 60);
		add(lHistory);

		btnExportV = new JButton("Export - Voucher");
		btnExportV.setBounds(510, 370, 200, 20);
		add(btnExportV);
		
		btnExportVW = new JButton("Export - Voucher (Web)");
		btnExportVW.setBounds(510, 400, 200, 20);
		add(btnExportVW);
		
		btnExportBO = new JButton("Export - Booking Order");
		btnExportBO.setBounds(510, 430, 200, 20);
		add(btnExportBO);
		
		btnExportIV = new JButton("Export - Invoice");
		btnExportIV.setBounds(510, 460, 200, 20);
		add(btnExportIV);
		
		btnExportIVW = new JButton("Export - Invoice (Web)");
		btnExportIVW.setBounds(510, 490, 200, 20);
		add(btnExportIVW);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(175, 520, 100, 20);
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(445, 520, 100, 20);
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
	
	public void setBtnAddHRListener(ActionListener listener){
		btnAddHR.addActionListener(listener);
	}
	
	public void setBtnAddRTListener(ActionListener listener){
		btnAddRT.addActionListener(listener);
	}
	
	public void setBtnAddPTListener(ActionListener listener){
		btnAddPT.addActionListener(listener);
	}
	
	public void setBtnExportVListener(ActionListener listener){
		btnExportV.addActionListener(listener);
	}
	
	public void setBtnExportVWListener(ActionListener listener){
		btnExportVW.addActionListener(listener);
	}
	
	public void setBtnExportBOListener(ActionListener listener){
		btnExportBO.addActionListener(listener);
	}
	
	public void setBtnExportIVListener(ActionListener listener){
		btnExportIV.addActionListener(listener);
	}
	
	public void setBtnExportIVWListener(ActionListener listener){
		btnExportIVW.addActionListener(listener);
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
		
		for(Component c : getContentPane().getComponents()){
			if(c.getClass().equals(JTextField.class) ||
					c.getClass().equals(JFormattedTextField.class)){
				
				JTextField tf = (JTextField)c;
				
				if(!tf.getName().equals("Currency") && !tf.getName().equals("Receipt No") &&
						!tf.getName().equals("Option To Pay") && !tf.getName().equals("Company") &&
						!tf.getName().equals("Pay In - PHP") && !tf.getName().equals("Pay In - KRW") &&
						!tf.getName().equals("Pay In - Date") &&
						!tf.getName().equals("Pay Out - PHP") && !tf.getName().equals("Pay Out - KRW") &&
						!tf.getName().equals("Pay Out - Date") &&
						!tf.getName().equals("Income - PHP") && !tf.getName().equals("Income - KRW") &&
						!tf.getName().equals("Confirmation Number") && tf.getText().length() == 0){
					
					
					tf.setBorder(red);
					
					message += tf.getName() + "\n";
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
	
	public HotelReservation getAllData(){

		HotelReservation hr = new HotelReservation(
				this.hr.getCreatedBy(),
				ftfCheckIn.getText(), 
				ftfCheckOut.getText(),
				cbHotelOrResort.getSelectedItem().toString(),
				tfGuestName.getText(), 
				tfConfirmationNumber.getText(),
				Integer.parseInt(ftfNoOfAdult.getValue().toString()), 
				Integer.parseInt(ftfNoOfChild.getValue().toString()), 
				Integer.parseInt(ftfNoOfNights.getValue().toString()),
				tfRoomType.getText(), 
				Integer.parseInt(ftfNoOfRooms.getValue().toString()),
				cbBreakfast.getSelectedItem().toString(),
				ftfOptionToPay.getText(),
				ftfReservationDate.getText(), 
				cbReservationType.getSelectedItem().toString(),
				tfCompany.getText(),
				cbPaymentType.getSelectedItem().toString(),
				tfReceiptNo.getText(),
				Double.parseDouble(ftfPayInPHP.getValue().toString()),
				Double.parseDouble(ftfPayInKRW.getValue().toString()), 
				ftfPayInDate.getText(), 
				Double.parseDouble(ftfPayOutPHP.getValue().toString()), 
				Double.parseDouble(ftfPayOutKRW.getValue().toString()),
				ftfPayOutDate.getText(), 
				Double.parseDouble(ftfIncomePHP.getValue().toString()),
				Double.parseDouble(ftfIncomeKRW.getValue().toString()), 
				taNote.getText(), 
				cbStatus.getSelectedItem().toString());
		hr.setId(this.hr.getId());
		
		return hr;
	}
	
	public void updateView(HotelReservation hr){
		this.hr = hr;
		//update all data
		ftfCheckIn.setText(hr.getCheckIn()); 
		ftfCheckOut.setText(hr.getCheckOut());
		cbHotelOrResort.setSelectedItem(hr.getHotelOrResort());
		tfGuestName.setText(hr.getGuestName());
		tfConfirmationNumber.setText(hr.getConfirmationNumber());
		ftfNoOfAdult.setValue(hr.getNumberOfAdult()); 
		ftfNoOfChild.setValue(hr.getNumberOfChild());
		ftfNoOfNights.setValue(hr.getNumberOfNights());
		tfRoomType.setText(hr.getRoomType());
		ftfNoOfRooms.setValue(hr.getNumberOfRooms());
		cbBreakfast.setSelectedItem(hr.getBreakfast());
		ftfOptionToPay.setText(hr.getOptionToPay());
		ftfReservationDate.setText(hr.getReservationDate());
		cbReservationType.setSelectedItem(hr.getReservationType());
		tfCompany.setText(hr.getCompany());
		cbPaymentType.setSelectedItem(hr.getPaymentType());
		tfReceiptNo.setText(hr.getReceiptNumber());
		ftfPayInPHP.setValue(hr.getPayInPHP());
		ftfPayInKRW.setValue(hr.getPayInKRW()); 
		ftfPayInDate.setText(hr.getPayInDate()); 
		ftfPayOutPHP.setValue(hr.getPayOutPHP()); 
		ftfPayOutKRW.setValue(hr.getPayOutKRW());
		ftfPayOutDate.setText(hr.getPayOutDate()); 
		ftfIncomePHP.setValue(hr.getIncomePHP());
		ftfIncomeKRW.setValue(hr.getIncomeKRW()); 
		taNote.setText(hr.getNote());
		cbStatus.setSelectedItem(hr.getStatus());
		
		ArrayList<HRHistory> hrhs = model.getAllHRHistory(hr.getId());
		DefaultListModel listmodel = (DefaultListModel) lHistory.getModel();
		
		for(HRHistory hrh : hrhs){
			listmodel.addElement(hrh.getDate() + " " + hrh.getName());
		}
	}
	
	public void updateHotelOrResort(ArrayList<String> list){
		cbHotelOrResort.removeAllItems();
		
		for(String name : list){
			cbHotelOrResort.addItem(name);
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
		
		cbPaymentType.setSelectedIndex(-1);
		cbPaymentType.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(cbPaymentType.getSelectedItem().toString().equals("Cash")){
					lblReceiptNo.setVisible(true);
					tfReceiptNo.setVisible(true);
				}
				else{
					lblReceiptNo.setVisible(false);
					tfReceiptNo.setVisible(false);
					tfReceiptNo.setText("");
				}
			}
		});
		
		if(model.getPaymentType().size() > 0){
			cbPaymentType.setSelectedIndex(0);
		}
		
		lHistory.addListSelectionListener(new ListSelectionListener(){
			Border red = BorderFactory.createLineBorder(Color.red);
			Border tfBorder = new JTextField().getBorder();
			Border cbBorder = new JComboBox().getBorder();
			Border taBorder = new JTextArea().getBorder();
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int i = lHistory.getSelectedIndex();
				HRHistory hrh = model.getAllHRHistory(hr.getId()).get(i);
				
				if(hrh.isCheckInEdited()){
					ftfCheckIn.setBorder(red);
				}
				else{
					ftfCheckIn.setBorder(tfBorder);
				}
				if(hrh.isCheckOutEdited()){
					ftfCheckOut.setBorder(red);
				}
				else{
					ftfCheckOut.setBorder(tfBorder);
				}
				if(hrh.isHotelOrResortEdited()){
					cbHotelOrResort.setBorder(red);
				}
				else{
					cbHotelOrResort.setBorder(cbBorder);
				}
				if(hrh.isGuestNameEdited()){
					tfGuestName.setBorder(red);
				}
				else{
					tfGuestName.setBorder(tfBorder);
				}
				if(hrh.isNumberOfAdultEdited()){
					ftfNoOfAdult.setBorder(red);
				}
				else{
					ftfNoOfAdult.setBorder(tfBorder);
				}
				if(hrh.isNumberOfChildEdited()){
					ftfNoOfChild.setBorder(red);
				}
				else{
					ftfNoOfChild.setBorder(tfBorder);
				}
				if(hrh.isNumberOfNightsEdited()){
					ftfNoOfNights.setBorder(red);
				}
				else{
					ftfNoOfNights.setBorder(tfBorder);
				}
				if(hrh.isRoomTypeEdited()){
					tfRoomType.setBorder(red);
				}
				else{
					tfRoomType.setBorder(tfBorder);
				}
				if(hrh.isNumberOfRoomsEdited()){
					ftfNoOfRooms.setBorder(red);
				}
				else{
					ftfNoOfRooms.setBorder(tfBorder);
				}
				if(hrh.isOptionToPayEdited()){
					ftfOptionToPay.setBorder(red);
				}
				else{
					ftfOptionToPay.setBorder(tfBorder);
				}
				if(hrh.isReservationDateEdited()){
					ftfReservationDate.setBorder(red);
				}
				else{
					ftfReservationDate.setBorder(tfBorder);
				}
				if(hrh.isReservationTypeEdited()){
					cbReservationType.setBorder(red);
				}
				else{
					cbReservationType.setBorder(cbBorder);
				}
				if(hrh.isCompanyEdited()){
					tfCompany.setBorder(red);
				}
				else{
					tfCompany.setBorder(tfBorder);
				}
				if(hrh.isPaymentTypeEdited()){
					cbPaymentType.setBorder(red);
				}
				else{
					cbPaymentType.setBorder(cbBorder);
				}
				if(hrh.isPayInPHPEdited()){
					ftfPayInPHP.setBorder(red);
				}
				else{
					ftfPayInPHP.setBorder(tfBorder);
				}
				if(hrh.isPayInKRWEdited()){
					ftfPayInKRW.setBorder(red);
				}
				else{
					ftfPayInKRW.setBorder(tfBorder);
				}
				if(hrh.isPayInDateEdited()){
					ftfPayInDate.setBorder(red);
				}
				else{
					ftfPayInDate.setBorder(tfBorder);
				}
				if(hrh.isPayOutPHPEdited()){
					ftfPayOutPHP.setBorder(red);
				}
				else{
					ftfPayOutPHP.setBorder(tfBorder);
				}
				if(hrh.isPayOutKRWEdited()){
					ftfPayOutKRW.setBorder(red);
				}
				else{
					ftfPayOutKRW.setBorder(tfBorder);
				}
				if(hrh.isPayOutDateEdited()){
					ftfPayOutDate.setBorder(red);
				}
				else{
					ftfPayOutDate.setBorder(tfBorder);
				}
				if(hrh.isIncomePHPEdited()){
					ftfIncomePHP.setBorder(red);
				}
				else{
					ftfIncomePHP.setBorder(tfBorder);
				}
				if(hrh.isIncomeKRWEdited()){
					ftfIncomeKRW.setBorder(red);
				}
				else{
					ftfIncomeKRW.setBorder(tfBorder);
				}
				if(hrh.isStatusEdited()){
					cbStatus.setBorder(red);
				}
				else{
					cbStatus.setBorder(cbBorder);
				}
				if(hrh.isConfirmationNumberEdited()){
					tfConfirmationNumber.setBorder(red);
				}
				else{
					tfConfirmationNumber.setBorder(tfBorder);
				}
				if(hrh.isPayOutPHPEdited()){
					ftfPayOutPHP.setBorder(red);
				}
				else{
					ftfPayOutPHP.setBorder(tfBorder);
				}
				if(hrh.isBreakfastEdited()){
					cbBreakfast.setBorder(red);
				}
				else{
					cbBreakfast.setBorder(cbBorder);
				}
				if(hrh.isNoteEdited()){
					taNote.setBorder(red);
				}
				else{
					taNote.setBorder(taBorder);
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