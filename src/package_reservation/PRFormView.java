package package_reservation;

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

public class PRFormView extends JFrame{
	private PackageReservation pr = new PackageReservation();
	
	private JLabel lblDate, lblTime, lblType, lblCar,
		lblReservationType, lblReservationDate, lblOptionToPay, lblAmountToPay,
		lblGuestName, lblNoOfAdult, lblNoOfChild, lblPaymentType, lblPayIn, lblPayInPHP,
		lblPayInKRW, lblPayInDate, lblPayOut , lblPayOutPHP, lblPayOutKRW, lblPayOutDate,
		lblIncome, lblIncomePHP, lblIncomeKRW, lblNote, lblCurrency, lblCurrencyNote,
		lblRemark,lblEdit, lblHistory;
	
	private JTextField tfType, tfGuestName;
	
	JFormattedTextField ftfDate, ftfTime, ftfReservationDate, ftfOptionToPay,
		ftfAmountToPay, ftfNoOfAdult, ftfNoOfChild, ftfPayInPHP, ftfPayInKRW, 
		ftfPayInDate, ftfPayOutPHP, ftfPayOutKRW, ftfPayOutDate, ftfIncomePHP,
		ftfIncomeKRW, ftfCurrency;
	
	private JTextArea taNote, taRemark;
	
	private JList lHistory;
	
	private JComboBox cbCar, cbFlightNo, cbPaymentType, cbReservationType;
	
	private JButton btnAddCar;
	private JButton btnAddRT;
	private JButton btnAddPT;
	
	private JButton btnExportV;
	
	private JButton btnExportVW;
	
	private JButton btnExportIV;
	
	private JButton btnExportIVW;
	
	private JButton btnSave;
	private JButton btnCancel;
	
	private RSModel model;
	
	public PRFormView(RSModel model){
		super("Package Reservation Form");
		setSize(805,480);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(10, 10, 40, 20);
		add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setBounds(10, 40, 40, 20);
		add(lblTime);
		
		lblType = new JLabel("Type");
		lblType.setBounds(10, 70, 40, 20);
		add(lblType);
		
		lblCar = new JLabel("Car");
		lblCar.setBounds(10, 100, 40, 20);
		add(lblCar);
		
		lblReservationType = new JLabel("Reservation Type");
		lblReservationType.setBounds(190, 10, 100, 20);
		add(lblReservationType);
		
		lblReservationDate = new JLabel("Reservation Date");
		lblReservationDate.setBounds(190, 40, 100, 20);
		add(lblReservationDate);
		
		lblOptionToPay = new JLabel("Option To Pay");
		lblOptionToPay.setBounds(190, 70, 100, 20);
		add(lblOptionToPay);
		
		lblAmountToPay = new JLabel("Amount To Pay");
		lblAmountToPay.setBounds(190, 100, 100, 20);
		add(lblAmountToPay);
		
		lblGuestName = new JLabel("Guest Name");
		lblGuestName.setBounds(190, 130, 100, 20);
		add(lblGuestName);
		
		lblNoOfAdult = new JLabel("Adult");
		lblNoOfAdult.setBounds(190, 160, 50, 20);
		add(lblNoOfAdult);
		
		lblNoOfChild = new JLabel("Child");
		lblNoOfChild.setBounds(330, 160, 50, 20);
		add(lblNoOfChild);
		
		lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(440, 10, 100, 20);
		add(lblPaymentType);
		
		lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(440, 40, 100, 20);
		add(lblCurrency);
		
		lblCurrencyNote = new JLabel("(PHP to KRW)");
		lblCurrencyNote.setBounds(640, 40, 100, 20);
		add(lblCurrencyNote);
		
		lblPayIn = new JLabel("Pay In");
		lblPayIn.setBounds(440, 70, 100, 20);
		add(lblPayIn);
		
		lblPayInPHP = new JLabel("PHP");
		lblPayInPHP.setBounds(510, 70, 30, 20);
		add(lblPayInPHP);
		
		lblPayInKRW = new JLabel("KRW");
		lblPayInKRW.setBounds(660, 70, 30, 20);
		add(lblPayInKRW);
		
		lblPayInDate = new JLabel("Date");
		lblPayInDate.setBounds(510, 100, 100, 20);
		add(lblPayInDate);
		
		lblPayOut = new JLabel("Pay Out");
		lblPayOut.setBounds(440, 130, 100, 20);
		add(lblPayOut);
		
		lblPayOutPHP = new JLabel("PHP");
		lblPayOutPHP.setBounds(510, 130, 30, 20);
		add(lblPayOutPHP);
		
		lblPayOutKRW = new JLabel("KRW");
		lblPayOutKRW.setBounds(660, 130, 30, 20);
		add(lblPayOutKRW);
		
		lblPayOutDate = new JLabel("Date");
		lblPayOutDate.setBounds(510, 160, 100, 20);
		add(lblPayOutDate);
		
		lblIncome = new JLabel("Income");
		lblIncome.setBounds(440, 190, 100, 20);
		add(lblIncome);
		
		lblIncomePHP = new JLabel("PHP");
		lblIncomePHP.setBounds(510, 190, 30, 20);
		add(lblIncomePHP);
		
		lblIncomeKRW = new JLabel("KRW");
		lblIncomeKRW.setBounds(660, 190, 30, 20);
		add(lblIncomeKRW);
		
		lblNote = new JLabel("Note");
		lblNote.setBounds(10, 220, 40, 20);
		add(lblNote);
		
		lblRemark = new JLabel("Remark");
		lblRemark.setBounds(10, 290, 40, 20);
		add(lblRemark);
		
		lblEdit = new JLabel("Edit");
		lblEdit.setBounds(10, 360, 100, 20);
		add(lblEdit);
		
		lblHistory = new JLabel("History");
		lblHistory.setBounds(10, 380, 100, 20);
		add(lblHistory);
		
		ftfDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfDate.setBounds(50,10,120,20);
		ftfDate.setName("Date");
		add(ftfDate);
		
		ftfTime = new JFormattedTextField(model.TIME_FORMAT);
		ftfTime.setUI(new JTextFieldHintUI("HH:mm", Color.gray));
		ftfTime.setBounds(50,40,120,20);
		ftfTime.setName("Time");
		add(ftfTime);
		
		tfType = new JTextField("");
		tfType.setBounds(50, 70, 120, 20);
		tfType.setName("Type");
		add(tfType);
		
		cbCar = new JComboBox(model.getCar().toArray());
		cbCar.setEditable(true);
		new AutoCompletion(cbCar);
		cbCar.setBounds(50, 100, 100, 20);
		cbCar.setName("Car");
		add(cbCar);
		
		btnAddCar = new JButton("+");
		btnAddCar.setMargin(new Insets(0,0,0,0));
		btnAddCar.setBounds(150, 100, 20, 20);
		add(btnAddCar);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(300, 10, 100, 20);
		cbReservationType.setName("Reservation Type");
		add(cbReservationType);
		
		btnAddRT = new JButton("+");
		btnAddRT.setMargin(new Insets(0,0,0,0));
		btnAddRT.setBounds(400, 10, 20, 20);
		add(btnAddRT);
		
		ftfReservationDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfReservationDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfReservationDate.setBounds(300, 40, 120, 20);
		ftfReservationDate.setName("Reservation Date");
		add(ftfReservationDate);
		
		ftfOptionToPay = new JFormattedTextField(model.DATE_FORMAT);
		ftfOptionToPay.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfOptionToPay.setBounds(300, 70, 120, 20);
		ftfOptionToPay.setName("Option To Pay");
		add(ftfOptionToPay);
		
		ftfAmountToPay = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfAmountToPay.setValue(new Double(0));
		ftfAmountToPay.setBounds(300, 100, 120, 20);
		ftfAmountToPay.setName("Amount To Pay");
		add(ftfAmountToPay);
		
		tfGuestName = new JTextField();
		tfGuestName.setBounds(300, 130, 120, 20);
		tfGuestName.setName("Guest Name");
		add(tfGuestName);
		
		ftfNoOfAdult = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfAdult.setValue(new Integer(0));
		ftfNoOfAdult.setBounds(230, 160, 50, 20);
		ftfNoOfAdult.setName("Number of Adult");
		add(ftfNoOfAdult);
		
		ftfNoOfChild = new JFormattedTextField(model.INTEGER_FORMAT);
		ftfNoOfChild.setValue(new Integer(0));
		ftfNoOfChild.setBounds(370, 160, 50, 20);
		ftfNoOfChild.setName("Number of Child");
		add(ftfNoOfChild);
		
		cbPaymentType = new JComboBox(model.getPaymentType().toArray());
		cbPaymentType.setEditable(true);
		new AutoCompletion(cbPaymentType);
		cbPaymentType.setBounds(540, 10, 100, 20);
		cbPaymentType.setName("Payment Type");
		add(cbPaymentType);

		btnAddPT = new JButton("+");
		btnAddPT.setMargin(new Insets(0,0,0,0));
		btnAddPT.setBounds(640, 10, 20, 20);
		add(btnAddPT);
		
		ftfCurrency = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfCurrency.setValue(new Double(0));
		ftfCurrency.setBounds(540, 40, 100, 20);
		ftfCurrency.setName("Currency");
		add(ftfCurrency);
		
		ftfPayInPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInPHP.setValue(new Double(0));
		ftfPayInPHP.setBounds(540, 70, 100, 20);
		ftfPayInPHP.setName("Pay In - PHP");
		add(ftfPayInPHP);
		
		ftfPayInKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayInKRW.setValue(new Double(0));
		ftfPayInKRW.setBounds(690, 70, 100, 20);
		ftfPayInKRW.setName("Pay In - KRW");
		add(ftfPayInKRW);
		
		ftfPayInDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayInDate.setName("Pay In - Date");
		ftfPayInDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayInDate.setBounds(540, 100, 100, 20);
		add(ftfPayInDate);
		
		ftfPayOutPHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutPHP.setValue(new Double(0));
		ftfPayOutPHP.setBounds(540, 130, 100, 20);
		ftfPayOutPHP.setName("Pay Out - PHP");
		add(ftfPayOutPHP);
		
		ftfPayOutKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfPayOutKRW.setValue(new Double(0));
		ftfPayOutKRW.setBounds(690, 130, 100, 20);
		ftfPayOutKRW.setName("Pay Out - KRW");
		add(ftfPayOutKRW);
		
		ftfPayOutDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfPayOutDate.setName("Pay Out - Date");
		ftfPayOutDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfPayOutDate.setBounds(540, 160, 100, 20);
		add(ftfPayOutDate);
		
		ftfIncomePHP = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomePHP.setEditable(false);
		ftfIncomePHP.setValue(new Double(0));
		ftfIncomePHP.setBounds(540, 190, 100, 20);
		ftfIncomePHP.setName("Income - PHP");
		add(ftfIncomePHP);
		
		ftfIncomeKRW = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfIncomeKRW.setEditable(false);
		ftfIncomeKRW.setValue(new Double(0));
		ftfIncomeKRW.setBounds(690, 190, 100, 20);
		ftfIncomeKRW.setName("Income - KRW");
		add(ftfIncomeKRW);
		
		taNote = new JTextArea("");
		taNote.setName("Note");
		taNote.setLineWrap(true);
		
		taNote.setWrapStyleWord(false);
		JScrollPane jp = new JScrollPane(taNote);
		jp.setBounds(50, 220, 370, 60);
		add(jp);
		
		taRemark = new JTextArea("");
		taRemark.setName("Remark");
		taRemark.setLineWrap(true);
		taRemark.setWrapStyleWord(false);
		
		JScrollPane jp1 = new JScrollPane(taRemark);
		jp1.setBounds(50, 290, 370, 60);
		add(jp1);
		
		lHistory = new JList(new DefaultListModel());
		lHistory.setName("History");
		
		JScrollPane jp2 = new JScrollPane(lHistory);
		jp2.setBounds(50, 360, 370, 60);
		add(jp2);
		
		btnExportV = new JButton("Export - Voucher");
		btnExportV.setBounds(510, 220, 200, 20);
		add(btnExportV);
		
		btnExportVW = new JButton("Export - Voucher (Web)");
		btnExportVW.setBounds(510, 250, 200, 20);
		add(btnExportVW);
		
		btnExportIV = new JButton("Export - Invoice");
		btnExportIV.setBounds(510, 280, 200, 20);
		add(btnExportIV);
		
		btnExportIVW = new JButton("Export - Invoice (Web)");
		btnExportIVW.setBounds(510, 310, 200, 20);
		add(btnExportIVW);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(300, 430, 90, 20);
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(400, 430, 90, 20);
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
		taRemark.getDocument().addDocumentListener(listener);
	}
	
	public void setBtnAddCarListener(ActionListener listener){
		btnAddCar.addActionListener(listener);
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
				
				if(!tf.getName().equals("Option To Pay") && !tf.getName().equals("Currency") && 
						!tf.getName().equals("Pay In - PHP") && !tf.getName().equals("Pay In - KRW") &&
						!tf.getName().equals("Pay In - Date") &&
						!tf.getName().equals("Pay Out - PHP") && !tf.getName().equals("Pay Out - KRW") &&
						!tf.getName().equals("Pay Out - Date") &&
						!tf.getName().equals("Income - PHP") && !tf.getName().equals("Income - KRW") &&
						tf.getText().length() == 0){
					
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
	
	public PackageReservation getAllData(){
		PackageReservation pr = new PackageReservation(
				this.pr.getCreatedBy(),
				this.pr.getCreatedAt(),
				ftfDate.getText(), 
				ftfTime.getText(), 
				tfType.getText(), 
				cbCar.getSelectedItem().toString(), 
				cbReservationType.getSelectedItem().toString(),
				ftfReservationDate.getText(),
				ftfOptionToPay.getText(),
				Double.parseDouble(ftfAmountToPay.getValue().toString()),
				tfGuestName.getText(),
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
		pr.setId(this.pr.getId());
		return pr;
	}
	
	public void updateView(PackageReservation pr){
		this.pr = pr;
		//update all data
		ftfDate.setText(pr.getDate());
		ftfTime.setText(pr.getTime());
		tfType.setText(pr.getType());
		cbCar.setSelectedItem(pr.getCar());
		cbReservationType.setSelectedItem(pr.getReservationType());
		ftfReservationDate.setText(pr.getReservationDate());
		ftfOptionToPay.setText(pr.getOptionToPay());
		ftfAmountToPay.setValue(pr.getAmountToPay());
		tfGuestName.setText(pr.getGuestName());
		ftfNoOfAdult.setValue(pr.getNumberOfAdult()); 
		ftfNoOfChild.setValue(pr.getNumberOfChild());;	
		cbPaymentType.setSelectedItem(pr.getPaymentType());
		ftfPayInPHP.setValue(pr.getPayInPHP());
		ftfPayInKRW.setValue(pr.getPayInKRW()); 
		ftfPayInDate.setText(pr.getPayInDate());
		ftfPayOutPHP.setValue(pr.getPayOutPHP()); 
		ftfPayOutKRW.setValue(pr.getPayOutKRW());
		ftfPayOutDate.setText(pr.getPayOutDate());
		ftfIncomePHP.setValue(pr.getIncomePHP());
		ftfIncomeKRW.setValue(pr.getIncomeKRW()); 
		taNote.setText(pr.getNote());
		taRemark.setText(pr.getRemark());
		
		ArrayList<PRHistory> prhs = model.getAllPRHistory(pr.getId());
		DefaultListModel listmodel = (DefaultListModel) lHistory.getModel();
		
		if(pr.getId() > 0){
			listmodel.addElement(pr.getCreatedAt() + " Created by: " + pr.getCreatedBy());
		}

		for(PRHistory prh : prhs){
			listmodel.addElement(prh.getDate() + " Edited by: " + prh.getName());
		}
	}
	
	public void updateCar(ArrayList<String> list){
		cbCar.removeAllItems();
		
		for(String name : list){
			cbCar.addItem(name);
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
					PRHistory prh = model.getAllPRHistory(pr.getId()).get(i-1);
					
					if(prh.isDateEdited()){
						ftfDate.setBorder(red);
					}
					else{
						ftfDate.setBorder(tfBorder);
					}
					
					if(prh.isTimeEdited()){
						ftfTime.setBorder(red);
					}
					else{
						ftfTime.setBorder(tfBorder);
					}
					
					if(prh.isTypeEdited()){
						tfType.setBorder(red);
					}
					else{
						tfType.setBorder(tfBorder);
					}
					
					if(prh.isCarEdited()){
						cbCar.setBorder(red);
					}
					else{
						cbCar.setBorder(cbBorder);
					}
					
					if(prh.isReservationTypeEdited()){
						cbReservationType.setBorder(red);
					}
					else{
						cbReservationType.setBorder(cbBorder);
					}
					
					if(prh.isReservationDateEdited()){
						ftfReservationDate.setBorder(red);
					}
					else{
						ftfReservationDate.setBorder(tfBorder);
					}
					
					if(prh.isOptionToPayEdited()){
						ftfOptionToPay.setBorder(red);
					}
					else{
						ftfOptionToPay.setBorder(tfBorder);
					}
					
					if(prh.isAmountToPayEdited()){
						ftfAmountToPay.setBorder(red);
					}
					else{
						ftfAmountToPay.setBorder(tfBorder);
					}
					
					if(prh.isGuestNameEdited()){
						tfGuestName.setBorder(red);
					}
					else{
						tfGuestName.setBorder(tfBorder);
					}
					
					if(prh.isNumberOfAdultEdited()){
						ftfNoOfAdult.setBorder(red);
					}
					else{
						ftfNoOfAdult.setBorder(tfBorder);
					}
					
					if(prh.isNumberOfChildEdited()){
						ftfNoOfChild.setBorder(red);
					}
					else{
						ftfNoOfChild.setBorder(tfBorder);
					}
					
					if(prh.isPaymentTypeEdited()){
						cbPaymentType.setBorder(red);
					}
					else{
						cbPaymentType.setBorder(cbBorder);
					}
					
					if(prh.isPayInPHPEdited()){
						ftfPayInPHP.setBorder(red);
					}
					else{
						ftfPayInPHP.setBorder(tfBorder);
					}
					if(prh.isPayInKRWEdited()){
						ftfPayInKRW.setBorder(red);
					}
					else{
						ftfPayInKRW.setBorder(tfBorder);
					}
					if(prh.isPayInDateEdited()){
						ftfPayInDate.setBorder(red);
					}
					else{
						ftfPayInDate.setBorder(tfBorder);
					}
					if(prh.isPayOutPHPEdited()){
						ftfPayOutPHP.setBorder(red);
					}
					else{
						ftfPayOutPHP.setBorder(tfBorder);
					}
					if(prh.isPayOutKRWEdited()){
						ftfPayOutKRW.setBorder(red);
					}
					else{
						ftfPayOutKRW.setBorder(tfBorder);
					}
					if(prh.isPayOutDateEdited()){
						ftfPayOutDate.setBorder(red);
					}
					else{
						ftfPayOutDate.setBorder(tfBorder);
					}
					if(prh.isIncomePHPEdited()){
						ftfIncomePHP.setBorder(red);
					}
					else{
						ftfIncomePHP.setBorder(tfBorder);
					}
					if(prh.isIncomeKRWEdited()){
						ftfIncomeKRW.setBorder(red);
					}
					else{
						ftfIncomeKRW.setBorder(tfBorder);
					}
					if(prh.isNoteEdited()){
						taNote.setBorder(red);
					}
					else{
						taNote.setBorder(taBorder);
					}
					
					if(prh.isRemarkEdited()){
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
