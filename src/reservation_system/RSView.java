package reservation_system;

import java.awt.event.ActionListener;

import javax.swing.*;

import com.itextpdf.text.Image;

public class RSView extends JFrame{
	private JButton btnLogOut;
	private JButton btnHotelReservation;
	
	private JButton btnFlyReservation;
	
	private JButton btnPackageReservation;
	
	private JButton btnChangePassword;
	
	private JButton btnRegister;
	
	private JLabel lblWelcome;
	
	private RSModel model;
	
	public RSView(RSModel model){
		super("Base Camp Reservation System");
		setSize(350,230);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblWelcome = new JLabel("Welcome " + model.getCurrentUser().getUsername() +"!");
		lblWelcome.setBounds(10, 10, 200, 20);
		add(lblWelcome);
			
		btnHotelReservation = new JButton("Hotel Reservation");
		btnHotelReservation.setBounds(75, 50, 200, 20);
		add(btnHotelReservation);
		
		btnFlyReservation = new JButton("Flight Reservation");
		btnFlyReservation.setBounds(75, 80, 200, 20);
		add(btnFlyReservation);
		
		btnPackageReservation = new JButton("Package Reservation");
		btnPackageReservation.setBounds(75, 110, 200, 20);
		add(btnPackageReservation);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(75, 140, 200, 20);
		add(btnChangePassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(125, 170, 100, 20);
		add(btnRegister);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(260, 10, 80, 20);
		add(btnLogOut);
		
		if(model.getCurrentUser().getAccessLevel() == 0){
			btnRegister.setVisible(false);
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setBtnLogOutListener(ActionListener listener){
		btnLogOut.addActionListener(listener);
	}
	
	public void setBtnHRListener(ActionListener listener){
		btnHotelReservation.addActionListener(listener);
	}
	
	public void setBtnFRListener(ActionListener listener){
		btnFlyReservation.addActionListener(listener);
	}
	
	public void setBtnPRListener(ActionListener listener){
		btnPackageReservation.addActionListener(listener);
	}
	
	public void setBtnRegisterListener(ActionListener listener){
		btnRegister.addActionListener(listener);
	}
	
	public void setBtnChangePasswordListener(ActionListener listener){
		btnChangePassword.addActionListener(listener);
	}
}
