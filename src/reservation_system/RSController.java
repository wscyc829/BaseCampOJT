package reservation_system;

import fly_reservation.FRFormView;
import fly_reservation.FRView;
import fly_reservation.FlightReservation;
import hotel_reservation.HRFormView;
import hotel_reservation.HRView;
import hotel_reservation.HotelReservation;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import package_reservation.PRFormView;
import package_reservation.PRView;
import package_reservation.PackageReservation;

import sessions.ChangePasswordView;
import sessions.LoginView;
import sessions.RegisterView;
import sessions.SettingView;
import javax.swing.plaf.FontUIResource;

public class RSController {
	private RSModel model;
	private RSView mainView;
	private HRView hrView;
	private HRFormView hrfView; 
	private FRView frView;
	private FRFormView frfView;
	private PRView prView;
	private PRFormView prfView;
	private LoginView loginView;
	private RegisterView registerView;
	private SettingView settingView;
	private ChangePasswordView cpView;
	
	public RSController(RSModel model){
		this.model = model;
		
		for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				/*
				int fontSize = 11;
				Hashtable defaults = UIManager.getDefaults();
				Enumeration keys = defaults.keys();
				while (keys.hasMoreElements()) {
					Object key = keys.nextElement();

				    if ((key instanceof String) && (((String) key).endsWith(".font"))) {
				    	FontUIResource font = (FontUIResource) UIManager.get(key);
				        defaults.put (key, new FontUIResource(Font.SANS_SERIF, font.getStyle(), fontSize));
				    }
				    	
				}*/
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
		}
		
		model.loadServerData();
		loginScreen();
	}
	
	public void loginScreen(){
		loginView = new LoginView(model);
		loginView.setBtnLoginListener(new LBtnloginListener());
		loginView.setBtnQuitListener(new LBtnQuitListener());
		loginView.setBtnSettingListener(new LBtnSettingListener());
		loginView.setTextFieldFocusListener(new TextFieldFocusListener());
		loginView.setTextFieldDocumentListener(new TextDocumentListener());
		loginView.setVisible(true);
	}
	
	public void registerScreen(){
		registerView = new RegisterView(model);
		registerView.setBtnRegisterListener(new RBtnRegisterListener());
		registerView.setBtnCancelListener(new RBtnCancelListener());
		registerView.setTextFieldFocusListener(new TextFieldFocusListener());
		registerView.setTextFieldDocumentListener(new TextDocumentListener());
		registerView.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
		        registerView.dispose();
		        mainScreen();
		    }
		});
		registerView.setVisible(true);
	}
	
	public void settingScreen(){
		model.loadServerData();
		settingView = new SettingView(model);
		settingView.setBtnSaveListener(new SBtnSaveListener());
		settingView.setBtnCancelListener(new SBtnCancelListener());
		settingView.setTextFieldFocusListener(new TextFieldFocusListener());
		settingView.setTextFieldDocumentListener(new TextDocumentListener());
		settingView.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
		        settingView.dispose();
		        loginScreen();
		    }
		});
		settingView.setVisible(true);
	}
	
	public void cpScreen(){
		cpView = new ChangePasswordView(model);
		cpView.setBtnSaveListener(new CPBtnSaveListener());
		cpView.setBtnCancelListener(new CPBtnCancelListener());
		cpView.setTextFieldFocusListener(new TextFieldFocusListener());
		cpView.setTextFieldDocumentListener(new TextDocumentListener());
		cpView.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
				cpView.dispose();
		        mainScreen();
		    }
		});
		cpView.setVisible(true);
	}
	
	public void mainScreen(){
		mainView = new RSView(model);
		mainView.setBtnLogOutListener(new RSBtnLogOutListener());
		mainView.setBtnRegisterListener(new RSBtnRegisterListener());
		mainView.setBtnHRListener(new RSBtnHRListener());
		mainView.setBtnFRListener(new RSBtnFRListener());
		mainView.setBtnPRListener(new RSBtnPRListener());
		mainView.setBtnChangePasswordListener(new RSBtnChangePasswordListener());
		mainView.setVisible(true);
	}
	
	public void hrScreen(){
		hrView = new HRView(model);
		hrView.setBtnAddListener(new HRBtnAddListener());
		hrView.setBtnBackListener(new HRBtnBackListener());
		hrView.setBtnSearchListener(new HRBtnSearchListener());
		hrView.setBtnRefreshListener(new HRBtnRefreshListener());
		hrView.setBtnPrintListener(new HRBtnPrintListener());
		hrView.setTextFieldFocusListener(new TextFieldFocusListener());
		hrView.setTextFieldDocumentListener(new TextDocumentListener());
		hrView.setTableSelectListener(new HRTableSelectListener());
		hrView.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
		        hrView.dispose();
		        mainScreen();
		    }
		});
		hrView.setVisible(true);
	}
	
	public void hrfScreen(){
		hrfView = new HRFormView(model);
		hrfView.setBtnAddHRListener(new HRFBtnAddHRListener());
		hrfView.setBtnAddRTListener(new HRFBtnAddRTListener());
		hrfView.setBtnAddPTListener(new HRFBtnAddPTListener());
		hrfView.setBtnExportVListener(new HRBtnExportVListener());
		hrfView.setBtnExportVWListener(new HRBtnExportVWListener());
		hrfView.setBtnExportBOListener(new HRBtnExportBOListener());
		hrfView.setBtnExportIVListener(new HRBtnExportIVListener());
		hrfView.setBtnExportIVWListener(new HRBtnExportIVWListener());
		hrfView.setBtnSaveListener(new HRFBtnSaveListener());
		hrfView.setBtnCancelListener(new HRFBtnCancelListener());
		hrfView.setTextFieldFocusListener(new TextFieldFocusListener());
		hrfView.setTextFieldDocumentListener(new TextDocumentListener());
		hrfView.setTextAreaDocumentListener(new TextDocumentListener());
		hrfView.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		        hrfView.dispose();
		        hrScreen();  
		    }
		});
		hrfView.setVisible(true);
	}
	
	public void frScreen(){
		frView = new FRView(model);
		frView.setBtnAddListener(new FRBtnAddListener());
		frView.setBtnBackListener(new FRBtnBackListener());
		frView.setBtnSearchListener(new FRBtnSearchListener());
		frView.setBtnRefreshListener(new FRBtnRefreshListener());
		frView.setTextFieldFocusListener(new TextFieldFocusListener());
		frView.setTextFieldDocumentListener(new TextDocumentListener());
		frView.setTableSelectListener(new FRTableSelectListener());
		frView.addWindowListener(new WindowAdapter() {
			@Override
		    public void windowClosing(WindowEvent windowEvent) {
		        frView.dispose();
		        mainScreen();
		    }
		});
		frView.setVisible(true);
	}
	
	public void frfScreen(){
		frfView = new FRFormView(model);
		frfView.setBtnAddAirlineListener(new FRFBtnAddAirlineListener());
		frfView.setBtnAddFlightListener(new FRFBtnAddFlightListener());
		frfView.setBtnAddOriginListener(new FRFBtnAddCityListener());
		frfView.setBtnAddDestinationListener(new FRFBtnAddCityListener());
		frfView.setBtnAddRTListener(new FRFBtnAddRTListener());
		frfView.setBtnAddPTListener(new FRFBtnAddPTListener());
		frfView.setBtnExportIVListener(new FRBtnExportIVListener());
		frfView.setBtnExportPOListener(new FRBtnExportPOListener());
		frfView.setBtnSaveListener(new FRFBtnSaveListener());
		frfView.setBtnCancelListener(new FRFBtnCancelListener());
		frfView.setTextFieldFocusListener(new TextFieldFocusListener());
		frfView.setTextFieldDocumentListener(new TextDocumentListener());
		frfView.setTextAreaDocumentListener(new TextDocumentListener());
		frfView.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	frfView.dispose();
		        frScreen();  
		    }
		});
		frfView.setVisible(true);
	}
	
	public void prScreen(){
		prView = new PRView(model);
		prView.setBtnAddListener(new PRBtnAddListener());
		prView.setBtnBackListener(new PRBtnBackListener());
		prView.setBtnSearchListener(new PRBtnSearchListener());
		prView.setBtnRefreshListener(new PRBtnRefreshListener());
		prView.setTextFieldFocusListener(new TextFieldFocusListener());
		prView.setTextFieldDocumentListener(new TextDocumentListener());
		prView.setTableSelectListener(new PRTableSelectListener());
		prView.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	prView.dispose();
		        mainScreen();  
		    }
		});
		prView.setVisible(true);
	}
	
	public void prfScreen(){
		prfView = new PRFormView(model);
		prfView.setBtnAddCarListener(new PRFBtnAddCarListener());
		prfView.setBtnAddRTListener(new PRFBtnAddRTListener());
		prfView.setBtnAddPTListener(new PRFBtnAddPTListener());
		prfView.setBtnSaveListener(new PRFBtnSaveListener());
		prfView.setBtnCancelListener(new PRFBtnCancelListener());
		
		prfView.setBtnExportVListener(new PRBtnExportVListener());
		prfView.setBtnExportVWListener(new PRBtnExportVWListener());
		prfView.setBtnExportIVListener(new PRBtnExportIVListener());
		prfView.setBtnExportIVWListener(new PRBtnExportIVWListener());
		
		prfView.setTextFieldFocusListener(new TextFieldFocusListener());
		prfView.setTextFieldDocumentListener(new TextDocumentListener());
		prfView.setTextAreaDocumentListener(new TextDocumentListener());
		prfView.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	prfView.dispose();
		        prScreen();  
		    }
		});
		prfView.setVisible(true);
	}
	
	class LBtnloginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			HashMap<String, String> data = loginView.getAllData();
			String username = data.get("username");
			String password = data.get("password");
				
			if(model.login(username, password)){
				loginView.dispose();
				mainScreen();
			}
		}
	}
	
	class LBtnQuitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class LBtnSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			loginView.dispose();
			settingScreen();
		}
	}
	
	class SBtnSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			HashMap<String, String> data = settingView.getAllData();
			
			if(model.saveServerData(data.get("IP"), data.get("Username"), data.get("Password"))){
				settingView.dispose();
				loginScreen();
			}
		}
	}

	class SBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			settingView.dispose();
			loginScreen();
		}
	}
	
	class CPBtnSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(cpView.isInputValid()){
				HashMap<String, String> data = cpView.getAllData();
				
				if(model.changePassword(data.get("Old password"), data.get("New password"))){
					cpView.dispose();
					mainScreen();
				}
			}
		}
	}
	
	class CPBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			cpView.dispose();
			mainScreen();
		}
	}
	
	class RSBtnRegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			registerScreen();
		}
	}
	class RSBtnLogOutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			loginScreen();
		}
	}
	
	class RSBtnHRListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			hrScreen();
		}
	}
	
	class RSBtnFRListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			frScreen();
		}
	}
	
	class RSBtnPRListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			prScreen();
		}
	}
	
	class RSBtnChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			mainView.dispose();
			cpScreen();
		}
	}
	
	class RBtnRegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(registerView.isInputValid()){
				User user = registerView.getAllData();
				model.register(user);
				registerView.dispose();
				mainScreen();
			}
		}
	}
	
	class RBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			registerView.dispose();
			mainScreen();
		}
	}
	
	class HRBtnAddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			hrView.dispose();
			hrfScreen();
		}
	}
	
	class HRBtnBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			hrView.dispose();
			mainScreen();
		}
	}
	
	class HRBtnSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			HashMap<String, String> map = hrView.getAllData();
			ArrayList<HotelReservation> hrs = model.getAllHRs(
												map.get("start"), 
												map.get("end"), 
												map.get("column name"), 
												map.get("value"));
			hrView.updateView(hrs);
			hrView.setHrs(hrs);
		}
	}
	
	class HRBtnRefreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			hrView.updateView(model.getAllHRs());
		}
	}
	
	class HRBtnPrintListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ArrayList<HotelReservation> hrs = hrView.getHrs();
			
			if(hrs.size() > 0){
				int error = model.exportHRS(hrs);
					
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
														  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
						//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"No data to print",
							 "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	class HRFBtnAddHRListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = JOptionPane.showInputDialog("Add New Hotel/Resort", input);
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addHotelOrResort(input);
				hrfView.updateHotelOrResort(model.getHotelOrResort());
			}
		}
	}
	
	class HRFBtnAddRTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Reservation Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addReservationType(input);
				hrfView.updateReservationType(model.getReservationType());
			}
		}
	}
	
	class HRFBtnAddPTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Payment Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addPaymentType(input);
				hrfView.updatePaymentType(model.getPaymentType());
			}
		}
	}
	
	class HRBtnExportVListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				int error = model.exportHRVoucher(hr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class HRBtnExportVWListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				int error = model.exportHRVoucherWeb(hr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class HRBtnExportBOListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				int error = model.exportHRBookingOrder(hr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class HRBtnExportIVListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				int error = model.exportHRInvoice(hr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	class HRBtnExportIVWListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				int error = model.exportHRInvoiceWeb(hr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class HRFBtnSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(hrfView.isInputValid()){
				HotelReservation hr = hrfView.getAllData();
				
				if(hrfView.getAllData().getId() == -1){
					model.addHR(hr);
				}else{
					model.updateHR(hr);
				}
				hrfView.dispose();
				hrScreen();
			}
		}
	}

	class HRFBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			hrfView.dispose();
			hrScreen();
		}
	}
	
	class FRBtnAddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frView.dispose();
			frfScreen();
		}
	}
	
	class FRBtnBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frView.dispose();
			mainScreen();
		}
	}
	
	class FRBtnSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			HashMap<String, String> map = frView.getAllData();
			ArrayList<FlightReservation> frs = model.getAllFRs(
												map.get("start"), 
												map.get("end"), 
												map.get("column name"), 
												map.get("value"));
			frView.updateView(frs);
		}
	}
	
	class FRBtnRefreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frView.updateView(model.getAllFRs());
		}
	}
	
	class FRFBtnAddAirlineListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Airline", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addAirline(input);
				frfView.updateAirline(model.getAirline());
			}
		}
	}
	
	class FRFBtnAddFlightListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Flight", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addFlight(input);
				frfView.updateFlight(model.getFlightNo());
			}
		}
	}
	
	class FRFBtnAddCityListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New City", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addCity(input);
				frfView.updateCity(model.getCity());
			}
		}
	}
	
	class FRFBtnAddRTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Reservation Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addReservationType(input);
				frfView.updateReservationType(model.getReservationType());
			}
		}
	}
	
	class FRFBtnAddPTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Payment Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addPaymentType(input);
				frfView.updatePaymentType(model.getPaymentType());
			}
		}
	}
	
	class FRBtnExportPOListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(frfView.isInputValid()){
				FlightReservation fr = frfView.getAllData();
				int error = model.exportFRPurchaseOrder(fr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class FRBtnExportIVListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(frfView.isInputValid()){
				FlightReservation fr = frfView.getAllData();
				int error = model.exportFRInvoice(fr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class FRFBtnSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(frfView.isInputValid()){
				FlightReservation fr = frfView.getAllData();

				if(fr.getId() == -1){
					model.addFR(fr);
				}else{
					model.updateFR(fr);
				}

				frfView.dispose();
				frScreen();
			}
		}
	}
	
	class FRFBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frfView.dispose();
			frScreen();
		}
	}
	
	class PRBtnAddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			prView.dispose();
			prfScreen();
		}
	}
	class PRBtnBackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			prView.dispose();
			mainScreen();
		}
	}
	
	class PRBtnSearchListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			HashMap<String, String> map = prView.getAllData();
			ArrayList<PackageReservation> prs = model.getAllPRs(
												map.get("start"), 
												map.get("end"), 
												map.get("column name"), 
												map.get("value"));
			prView.updateView(prs);
		}
	}
	
	class PRBtnRefreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			prView.updateView(model.getAllPRs());
		}
	}
	
	class PRFBtnAddCarListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Car", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addCar(input);
				prfView.updateCar(model.getCar());
			}
		}
	}
	
	class PRFBtnAddRTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();
		
			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Reservation Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addReservationType(input);
				prfView.updateReservationType(model.getReservationType());
			}
		}
	}
	
	class PRFBtnAddPTListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane jp = new JOptionPane();

			String input = "";
			String message = "";
			
			do{
				input = jp.showInputDialog("Add New Payment Type", input);
				
				message = "";
	    		
				if(input != null){
		    		if(input.contains("'")){
		    			message += "(\') ";
		    		}
		    		if(input.contains("\\")){
		    			message += "(\\)";
		    		}
		    		
		    		if(!message.equals("")){
			    		JOptionPane.showMessageDialog(null,
		    					"Invalid Sysmbol " + message,
		    					"Error", JOptionPane.ERROR_MESSAGE);
			    		input = input.replaceAll("'", "");
			    		input = input.replaceAll(Pattern.quote("\\"), "");
		    		}
		    		if(input.equals("")){
						message = " ";
					}
				}
			}while(!message.equals("") && input != null);
			
			if(input != null){
				model.addPaymentType(input);
				prfView.updatePaymentType(model.getPaymentType());
			}
		}
	}
	
	class PRBtnExportVListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(prfView.isInputValid()){
				PackageReservation pr = prfView.getAllData();
				int error = model.exportPRVoucher(pr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class PRBtnExportVWListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(prfView.isInputValid()){
				PackageReservation pr = prfView.getAllData();
				int error = model.exportPRVoucherWeb(pr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class PRBtnExportIVListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(prfView.isInputValid()){
				PackageReservation pr = prfView.getAllData();
				int error = model.exportPRInvoice(pr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	class PRBtnExportIVWListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(prfView.isInputValid()){
				PackageReservation pr = prfView.getAllData();
				int error = model.exportPRInvoiceWeb(pr);
				if(error == 1)
					JOptionPane.showMessageDialog(null, "File created Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
				else if(error == 3)
					JOptionPane.showMessageDialog(null,"Wrong file type or file is in used by other application",
												  "Save failed", JOptionPane.ERROR_MESSAGE);
				else if(error == 2){
					//JOptionPane.showMessageDialog(null, "Cancelled going back to form", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	class PRFBtnSaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(prfView.isInputValid()){
				PackageReservation pr = prfView.getAllData();
				
				if(prfView.getAllData().getId() == -1){
					model.addPR(pr);
				}else{
					model.updatePR(pr);
				}
				prfView.dispose();
				prScreen();
			}
		}
	}
	
	class PRFBtnCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			prfView.dispose();
			prScreen();
		}
	}
	
	
	class TextFieldFocusListener implements FocusListener{

		public void focusLost(final FocusEvent e) {	
		}
		
		public void focusGained(final FocusEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable(){
		    	public void run(){
		    		JTextField tf = (JTextField)e.getSource();
		    		tf.selectAll();
		        }
		    });
		}
	}
	
	class TextDocumentListener implements DocumentListener{

		public void changedUpdate(DocumentEvent arg0) {}

		public void insertUpdate(final DocumentEvent e) {
			SwingUtilities.invokeLater(new Runnable(){
		    	public void run(){
					try {
						Document ta = (Document)e.getDocument();
						String s = ta.getText(0, ta.getLength());
						String message = "";
			    		
			    		if(s.contains("'")){
			    			message += "(\') ";
			    		}
			    		if(s.contains("\\")){
			    			message += "(\\)";
			    		}
			    		
			    		if(!message.equals("")){
				    		JOptionPane.showMessageDialog(null,
			    					"Invalid Sysmbol " + message,
			    					"Error", JOptionPane.ERROR_MESSAGE);
				    		s = s.replaceAll("'", "");
				    		s = s.replaceAll(Pattern.quote("\\"), "");
				    		
				    		ta.remove(0, ta.getLength());
							ta.insertString(0, s, null);
			    		}
					} catch (BadLocationException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		        }
		    });
		}

		public void removeUpdate(DocumentEvent arg0) {}
	}
	
	class HRTableSelectListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			int i = ((ListSelectionModel)e.getSource()).getLeadSelectionIndex();
			int id = hrView.getHRSelectedID(i);
			
			hrView.dispose();
			hrfScreen();
			hrfView.updateView(model.getAllHRs("","","id", id+"").get(0));
		}
	}
	
	class FRTableSelectListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			int i = ((ListSelectionModel)e.getSource()).getLeadSelectionIndex();
			int id = frView.getFRSelectedID(i);
			
			frfScreen();
			frfView.updateView(model.getAllFRs("","","id", id+"").get(0));
			frView.dispose();
		}
	}
	
	class PRTableSelectListener implements ListSelectionListener{

		public void valueChanged(ListSelectionEvent e) {
			int i = ((ListSelectionModel)e.getSource()).getLeadSelectionIndex();
			prfScreen();
			prfView.updateView(model.getAllPRs().get(i));
			prView.dispose();
		}
	}
}
