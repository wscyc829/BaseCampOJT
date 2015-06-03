package hotel_reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class HRFormView extends JFrame{
	private HotelReservation hr = new HotelReservation();
	
	private JLabel lblCheckIn, lblCheckOut, lblHotelOrResort,
		lblGuestName, lblAttendeeNumuber, lblNoOfAdult, lblNoOfChild, 
		lblRoomType, lblNoOfRooms, lblNoOfNights, lblBreakfast,
		lblConfirmationNumber, lblCompany, lblStatus, 
		lblReservationType, lblReservationDate, lblOptionToPay, 
		lblAmountToPay, lblOptionToFinal, lblTotalPayment, lblPaymentType, lblReceiptNo, lblCurrency, 
		lblCurrencyNote, lblPayIn, lblPayInPHP, lblPayInKRW, lblPayInDate, 
		lblPayOut, lblPayOutPHP, lblPayOutKRW, lblPayOutDate, 
		lblIncome, lblIncomePHP, lblIncomeKRW, 
		lblNote, lblRemark, lblHistory ;
	
	private JFormattedTextField ftfCheckIn, ftfCheckOut, ftfNoOfAdult, ftfNoOfChild,
		ftfNoOfNights, ftfNoOfRooms, ftfReservationDate, ftfOptionToPay, ftfAmountToPay,
		ftfOptionToFinal, ftfTotalPayment, ftfCurrency, ftfPayInPHP, ftfPayInKRW, 
		ftfPayInDate, ftfPayOutPHP, ftfPayOutKRW, ftfPayOutDate, ftfIncomePHP, ftfIncomeKRW;
	
	private JTextField tfGuestName, tfRoomType, tfCompany, tfReceiptNo, tfConfirmationNumber;
	
	private JTextArea taNote, taRemark;
	
	private JList lHistory;
	
	private JComboBox cbHotelOrResort, cbReservationType, cbTotalPaymentType,
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
	
	private JCheckBox btnMark;
	
	private RSModel model;
	
	public HRFormView(RSModel model){
		super("Hotel Reservation Form");
		setSize(725, 640);
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
		
		lblRoomType = new JLabel("Room Type");
		lblRoomType.setBounds(10, 160, 100, 20);
		add(lblRoomType);
		
		lblNoOfRooms = new JLabel("Number of Rooms");
		lblNoOfRooms.setBounds(10, 190, 110, 20);
		add(lblNoOfRooms);
		
		lblNoOfNights = new JLabel("Number of Nights");
		lblNoOfNights.setBounds(10, 220, 100, 20);
		add(lblNoOfNights);
		
		lblBreakfast = new JLabel("Breakfast");
		lblBreakfast.setBounds(10, 250, 100, 20);
		add(lblBreakfast);

		lblConfirmationNumber = new JLabel("Confirmation No.");
		lblConfirmationNumber.setBounds(10, 280, 100, 20);
		add(lblConfirmationNumber);
		
		lblCompany = new JLabel("Company");
		lblCompany.setBounds(10, 310, 100, 20);
		add(lblCompany);
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 340, 100, 20);
		add(lblStatus);
		
		lblReservationType = new JLabel("Reservation Type");
		lblReservationType.setBounds(360, 10, 100, 20);
		add(lblReservationType);
		
		lblReservationDate = new JLabel("Reservation Date");
		lblReservationDate.setBounds(360, 40, 100, 20);
		add(lblReservationDate);
		
		lblOptionToPay = new JLabel("Option To Pay");
		lblOptionToPay.setBounds(360, 70, 100, 20);
		add(lblOptionToPay);
		
		lblAmountToPay = new JLabel("Amount To Pay");
		lblAmountToPay.setBounds(360, 100, 100, 20);
		add(lblAmountToPay);
		
		lblOptionToFinal = new JLabel("Option To Final");
		lblOptionToFinal.setBounds(360, 130, 100, 20);
		add(lblOptionToFinal);
		
		lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setBounds(360, 160, 100, 20);
		add(lblTotalPayment);
		
		lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(360, 190, 100, 20);
		add(lblPaymentType);
		
		lblReceiptNo = new JLabel("Receipt No.");
		lblReceiptNo.setBounds(360, 220, 100, 20);
		add(lblReceiptNo);
		
		lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(360, 250, 100, 20);
		add(lblCurrency);
		
		lblCurrencyNote = new JLabel("(PHP To KRW)");
		lblCurrencyNote.setBounds(560, 250, 100, 20);
		add(lblCurrencyNote);
		
		lblPayIn = new JLabel("Pay In");
		lblPayIn.setBounds(360, 280, 100, 20);
		add(lblPayIn);
		
		lblPayInPHP = new JLabel("PHP");
		lblPayInPHP.setBounds(430, 280, 50, 20);
		add(lblPayInPHP);

		lblPayInKRW = new JLabel("KRW");
		lblPayInKRW.setBounds(580, 280, 50, 20);
		add(lblPayInKRW);
		
		lblPayInDate = new JLabel("Date");
		lblPayInDate.setBounds(430, 310, 100, 20);
		add(lblPayInDate);
		
		lblPayOut = new JLabel("Pay Out");
		lblPayOut.setBounds(360, 340, 100, 20);
		add(lblPayOut);
		
		lblPayOutPHP = new JLabel("PHP");
		lblPayOutPHP.setBounds(430, 340, 50, 20);
		add(lblPayOutPHP);
		
		lblPayOutKRW = new JLabel("KRW");
		lblPayOutKRW.setBounds(580, 340, 30, 20);
		add(lblPayOutKRW);
		
		lblPayOutDate = new JLabel("Date");
		lblPayOutDate.setBounds(430, 370, 50, 20);
		add(lblPayOutDate);
		
		lblIncome = new JLabel("Income");
		lblIncome.setBounds(360, 400, 100, 20);
		add(lblIncome);
		
		lblIncomePHP = new JLabel("PHP");
		lblIncomePHP.setBounds(430, 400, 50, 20);
		add(lblIncomePHP);

		lblIncomeKRW = new JLabel("KRW");
		lblIncomeKRW.setBounds(580, 400, 50, 20);
		add(lblIncomeKRW);
		
		lblNote = new JLabel("Note");
		lblNote.setBounds(10, 370, 100, 20);
		add(lblNote);
		
		lblRemark = new JLabel("Remark");
		lblRemark.setBounds(10, 440, 100, 20);
		add(lblRemark);
		
		lblHistory = new JLabel("Edit History");
		lblHistory.setBounds(10, 510, 100, 20);
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

		tfRoomType = new JTextField("");
		tfRoomType.setName("Room Type");
		tfRoomType.setBounds(120, 160, 120, 20);
		add(tfRoomType);
		
		ftfNoOfRooms = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfRooms.setValue(new Integer(0));
		ftfNoOfRooms.setName("Number Of Rooms");
		ftfNoOfRooms.setBounds(120, 190, 120, 20);
		add(ftfNoOfRooms);
		
		ftfNoOfNights = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfNights.setValue(new Integer(0));
		ftfNoOfNights.setName("Number Of Nights");
		ftfNoOfNights.setBounds(120, 220, 120, 20);
		add(ftfNoOfNights);
		
		cbBreakfast = new JComboBox(new String[]{"Included", "Not Included"});
		cbBreakfast.setName("Breakfast");
		cbBreakfast.setEditable(true);
		new AutoCompletion(cbBreakfast);
		cbBreakfast.setBounds(120, 250, 120, 20);
		add(cbBreakfast);
		
		tfConfirmationNumber = new JTextField("");
		tfConfirmationNumber.setName("Confirmation Number");
		tfConfirmationNumber.setBounds(120, 280, 120, 20);
		add(tfConfirmationNumber);
		
		tfCompany = new JTextField("");
		tfCompany.setName("Company");
		tfCompany.setBounds(120, 310, 120, 20);
		add(tfCompany);
		
		cbStatus = new JComboBox(new String[]{"Not Confirm", "Confirmed", "Paid", "Final", "Cancelled"});
		cbStatus.setName("Status");
		cbStatus.setEditable(true);
		new AutoCompletion(cbStatus);
		cbStatus.setBounds(120, 340, 120, 20);
		add(cbStatus);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setName("Reservation Type");
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(460, 10, 100, 20);
		add(cbReservationType);

		btnAddRT = new JButton("+");
		btnAddRT.setMargin(new Insets(0,0,0,0));
		btnAddRT.setBounds(560, 10, 20, 20);
		add(btnAddRT);
		
		ftfReservationDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfReservationDate.setName("Reservation Date");
		ftfReservationDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfReservationDate.setBounds(460, 40, 120, 20);
		add(ftfReservationDate);
		
		ftfOptionToPay = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToPay.setName("Option To Pay");
		ftfOptionToPay.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToPay.setBounds(460, 70, 120, 20);
		add(ftfOptionToPay);
		
		ftfAmountToPay = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfAmountToPay.setValue(new Double(0));
		ftfAmountToPay.setName("Amount To Pay");
		ftfAmountToPay.setBounds(460, 100, 120, 20);
		add(ftfAmountToPay);
		
		ftfOptionToFinal = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToFinal.setName("Option To Final");
		ftfOptionToFinal.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToFinal.setBounds(460, 130, 120, 20);
		add(ftfOptionToFinal);
		
		ftfTotalPayment = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayment.setValue(new Double(0));
		ftfTotalPayment.setName("Total Payment");
		ftfTotalPayment.setBounds(460, 160, 120, 20);
		add(ftfTotalPayment);
		
		cbTotalPaymentType = new JComboBox(new String[]{"Pesos","Won"});
		cbTotalPaymentType.setName("Total Payment Type");
		cbTotalPaymentType.setBounds(580, 160, 60, 20);
		cbTotalPaymentType.setEditable(true);
		new AutoCompletion(cbTotalPaymentType);
		add(cbTotalPaymentType);
		
		cbPaymentType = new JComboBox(model.getPaymentType().toArray());
		cbPaymentType.setName("Payment Type");
		cbPaymentType.setEditable(true);
		new AutoCompletion(cbPaymentType);
		cbPaymentType.setBounds(460, 190, 100, 20);
		add(cbPaymentType);
		
		btnAddPT = new JButton("+");
		btnAddPT.setMargin(new Insets(0,0,0,0));
		btnAddPT.setBounds(560, 190, 20, 20);
		add(btnAddPT);
		
		tfReceiptNo = new JTextField("");
		tfReceiptNo.setName("Receipt No");
		tfReceiptNo.setBounds(460, 220, 120, 20);
		add(tfReceiptNo);
		
		ftfCurrency = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfCurrency.setValue(new Double(0));
		ftfCurrency.setName("Currency");
		ftfCurrency.setBounds(460, 250, 100, 20);
		add(ftfCurrency);
		
		ftfPayInPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInPHP.setValue(new Double(0));
		ftfPayInPHP.setName("Pay In - PHP");
		ftfPayInPHP.setBounds(460, 280, 100, 20);
		add(ftfPayInPHP);
		
		ftfPayInKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInKRW.setValue(new Double(0));
		ftfPayInKRW.setName("Pay In - KRW");
		ftfPayInKRW.setBounds(610, 280, 100, 20);
		add(ftfPayInKRW);
		
		ftfPayInDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayInDate.setName("Pay In - Date");
		ftfPayInDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayInDate.setBounds(460, 310, 100, 20);
		add(ftfPayInDate);
		
		ftfPayOutPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutPHP.setValue(new Double(0));
		ftfPayOutPHP.setName("Pay Out - PHP");
		ftfPayOutPHP.setBounds(460, 340, 100, 20);
		add(ftfPayOutPHP);
		
		ftfPayOutKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutKRW.setValue(new Double(0));
		ftfPayOutKRW.setName("Pay Out - KRW");
		ftfPayOutKRW.setBounds(610, 340, 100, 20);
		add(ftfPayOutKRW);
		
		ftfPayOutDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayOutDate.setName("Pay Out - Date");
		ftfPayOutDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayOutDate.setBounds(460, 370, 100, 20);
		add(ftfPayOutDate);
		
		ftfIncomePHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomePHP.setValue(new Double(0));
		ftfIncomePHP.setEditable(false);
		ftfIncomePHP.setName("Income - PHP");
		ftfIncomePHP.setBounds(460, 400, 100, 20);
		add(ftfIncomePHP);
		
		ftfIncomeKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomeKRW.setValue(new Double(0));
		ftfIncomeKRW.setEditable(false);
		ftfIncomeKRW.setName("Income - KRW");
		ftfIncomeKRW.setBounds(610, 400, 100, 20);
		add(ftfIncomeKRW);
		
		taNote = new JTextArea("");
		taNote.setName("Note");
		taNote.setLineWrap(true);
		taNote.setWrapStyleWord(false);
		add(taNote);
		
		JScrollPane jp = new JScrollPane(taNote);
		jp.setBounds(120, 370, 220, 60);
		add(jp);
		
		taRemark = new JTextArea("");
		taRemark.setName("Remark");
		taRemark.setLineWrap(true);
		taRemark.setWrapStyleWord(false);
		add(taRemark);
		
		JScrollPane jp1 = new JScrollPane(taRemark);
		jp1.setBounds(120, 440, 220, 60);
		add(jp1);
		
		lHistory = new JList(new DefaultListModel());
		lHistory.setName("History");
		add(lHistory);
		
		JScrollPane jp2 = new JScrollPane(lHistory);
		jp2.setBounds(120, 510, 220, 60);
		add(jp2);
		
		btnExportV = new JButton("Export - Voucher");
		btnExportV.setMnemonic(KeyEvent.VK_V);
		btnExportV.setBounds(510, 430, 200, 20);
		add(btnExportV);
		
		btnExportVW = new JButton("Export - Voucher (Web)");
		btnExportVW.setMnemonic(KeyEvent.VK_W);
		btnExportVW.setBounds(510, 460, 200, 20);
		add(btnExportVW);
		
		btnExportBO = new JButton("Export - Booking Order");
		btnExportBO.setMnemonic(KeyEvent.VK_B);
		btnExportBO.setBounds(510, 490, 200, 20);
		add(btnExportBO);
		
		btnExportIV = new JButton("Export - Invoice");
		btnExportIV.setMnemonic(KeyEvent.VK_I);
		btnExportIV.setBounds(510, 520, 200, 20);
		add(btnExportIV);
		
		btnExportIVW = new JButton("Export - Invoice (Web)");
		btnExportIVW.setMnemonic(KeyEvent.VK_N);
		btnExportIVW.setBounds(510, 550, 200, 20);
		add(btnExportIVW);
		
		btnSave = new JButton("Save");
		btnSave.setMnemonic(KeyEvent.VK_S);
		btnSave.setBounds(175, 580, 100, 20);
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic(KeyEvent.VK_C);
		btnCancel.setBounds(445, 580, 100, 20);
		add(btnCancel);
		
		btnMark = new JCheckBox("Mark");
		btnMark.setBounds(660, 10, 50, 20);
		add(btnMark);
		
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
		
		Vector<Component> order = new Vector<Component>(30);
	    order.add(ftfCheckIn);
	    order.add(ftfCheckOut);
	    order.add(cbHotelOrResort.getEditor().getEditorComponent());
	    order.add(tfGuestName);
	    order.add(ftfNoOfAdult);
	    order.add(ftfNoOfChild);
	    order.add(tfRoomType);
	    order.add(ftfNoOfRooms);
	    order.add(ftfNoOfNights);
	    order.add(cbBreakfast.getEditor().getEditorComponent());
	    order.add(tfConfirmationNumber);
	    order.add(tfCompany);
	    order.add(cbStatus.getEditor().getEditorComponent());
	    order.add(cbReservationType.getEditor().getEditorComponent());
	    order.add(ftfReservationDate);
	    order.add(ftfOptionToPay);
	    order.add(ftfAmountToPay);
	    order.add(ftfOptionToFinal);
	    order.add(ftfTotalPayment);
	    order.add(cbTotalPaymentType.getEditor().getEditorComponent());
	    order.add(cbPaymentType.getEditor().getEditorComponent());
	    order.add(tfReceiptNo);
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
						!tf.getName().equals("Option To Pay") && 
						!tf.getName().equals("Option To Final") &&
						!tf.getName().equals("Company") &&
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
				this.hr.getCreatedAt(),
				ftfCheckIn.getText(), 
				ftfCheckOut.getText(),
				cbHotelOrResort.getSelectedItem().toString(),
				
				tfGuestName.getText(), 
				Integer.parseInt(ftfNoOfAdult.getValue().toString()), 
				Integer.parseInt(ftfNoOfChild.getValue().toString()), 
				
				tfRoomType.getText(), 
				Integer.parseInt(ftfNoOfRooms.getValue().toString()),
				Integer.parseInt(ftfNoOfNights.getValue().toString()),
				cbBreakfast.getSelectedItem().toString(),
				tfConfirmationNumber.getText(),
				tfCompany.getText(),
				cbStatus.getSelectedItem().toString(),
				
				cbReservationType.getSelectedItem().toString(),
				ftfReservationDate.getText(), 
				ftfOptionToPay.getText(),
				Double.parseDouble(ftfAmountToPay.getValue().toString()),
				ftfOptionToFinal.getText(),
				Double.parseDouble(ftfTotalPayment.getValue().toString()),
				cbTotalPaymentType.getSelectedItem().toString(),
				
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
				taRemark.getText(),
				
				btnMark.isSelected());
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
		ftfNoOfAdult.setValue(hr.getNumberOfAdult()); 
		ftfNoOfChild.setValue(hr.getNumberOfChild());
			
		tfRoomType.setText(hr.getRoomType());
		ftfNoOfRooms.setValue(hr.getNumberOfRooms());
		ftfNoOfNights.setValue(hr.getNumberOfNights());
			
		cbBreakfast.setSelectedItem(hr.getBreakfast());
		tfConfirmationNumber.setText(hr.getConfirmationNumber());
		tfCompany.setText(hr.getCompany());
		cbStatus.setSelectedItem(hr.getStatus());
			
		cbReservationType.setSelectedItem(hr.getReservationType());
		ftfReservationDate.setText(hr.getReservationDate());
		ftfOptionToPay.setText(hr.getOptionToPay());
		ftfAmountToPay.setValue(hr.getAmountToPay());
		ftfOptionToFinal.setText(hr.getOptionToFinal());
		ftfTotalPayment.setValue(hr.getTotalPayment());
		cbTotalPaymentType.setSelectedItem(hr.getTotalPaymentType());
			
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
		taRemark.setText(hr.getRemark());
			
		btnMark.setSelected(hr.isMark());
			
		ArrayList<HRHistory> hrhs = model.getAllHRHistory(hr.getId());
		DefaultListModel listmodel = (DefaultListModel) lHistory.getModel();

		if(hr.getId() > 0){
			listmodel.addElement(hr.getCreatedAt() + " Created by: " + hr.getCreatedBy());
		}
			
		for(HRHistory hrh : hrhs){
			listmodel.addElement(hrh.getDate() + " Edited by: " + hrh.getName());
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
			Border cBorder = new JCheckBox().getBorder();
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int i = lHistory.getSelectedIndex();
				
				if(i > 0){
					HRHistory hrh = model.getAllHRHistory(hr.getId()).get(i-1);
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

					if(hrh.isNumberOfNightsEdited()){
						ftfNoOfNights.setBorder(red);
					}
					else{
						ftfNoOfNights.setBorder(tfBorder);
					}
					
					if(hrh.isBreakfastEdited()){
						cbBreakfast.setBorder(red);
					}
					else{
						cbBreakfast.setBorder(cbBorder);
					}
					
					if(hrh.isConfirmationNumberEdited()){
						tfConfirmationNumber.setBorder(red);
					}
					else{
						tfConfirmationNumber.setBorder(tfBorder);
					}
					
					if(hrh.isCompanyEdited()){
						tfCompany.setBorder(red);
					}
					else{
						tfCompany.setBorder(tfBorder);
					}

					if(hrh.isStatusEdited()){
						cbStatus.setBorder(red);
					}
					else{
						cbStatus.setBorder(cbBorder);
					}
					
					if(hrh.isReservationTypeEdited()){
						cbReservationType.setBorder(red);
					}
					else{
						cbReservationType.setBorder(cbBorder);
					}

					if(hrh.isReservationDateEdited()){
						ftfReservationDate.setBorder(red);
					}
					else{
						ftfReservationDate.setBorder(tfBorder);
					}
					
					if(hrh.isOptionToPayEdited()){
						ftfOptionToPay.setBorder(red);
					}
					else{
						ftfOptionToPay.setBorder(tfBorder);
					}
					
					if(hrh.isAmountToPayEdited()){
						ftfAmountToPay.setBorder(red);
					}
					else{
						ftfAmountToPay.setBorder(tfBorder);
					}
					
					if(hrh.isOptionToFinalEdited()){
						ftfOptionToFinal.setBorder(red);
					}
					else{
						ftfOptionToFinal.setBorder(tfBorder);
					}
					
					if(hrh.isTotalPaymentEdited()){
						ftfTotalPayment.setBorder(red);
					}
					else{
						ftfTotalPayment.setBorder(tfBorder);
					}
					
					if(hrh.isTotalPaymentTypeEdited()){
						cbTotalPaymentType.setBorder(red);
					}
					else{
						cbTotalPaymentType.setBorder(cbBorder);
					}
					
					if(hrh.isPaymentTypeEdited()){
						cbPaymentType.setBorder(red);
					}
					else{
						cbPaymentType.setBorder(cbBorder);
					}
					
					if(hrh.isReceiptNumberEdited()){
						tfReceiptNo.setBorder(red);
					}
					else{
						tfReceiptNo.setBorder(tfBorder);
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
					
					if(hrh.isNoteEdited()){
						taNote.setBorder(red);
					}
					else{
						taNote.setBorder(taBorder);
					}
					if(hrh.isRemarkEdited()){
						taRemark.setBorder(red);
					}
					else{
						taRemark.setBorder(taBorder);
					}
					
					if(hrh.isMarkEdited()){
						btnMark.setForeground(Color.red);
					}
					else{
						btnMark.setForeground(Color.black);
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
