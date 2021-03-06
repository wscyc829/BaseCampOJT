package reservation_system;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblWelcome = new JLabel("Welcome " + model.getCurrentUser().getUsername() +"!");
		lblWelcome.setBounds(10, 10, 200, 20);
		add(lblWelcome);
			
		btnHotelReservation = new JButton("Hotel Reservation");
		btnHotelReservation.setMnemonic(KeyEvent.VK_H);
		btnHotelReservation.setBounds(75, 50, 200, 20);
		add(btnHotelReservation);
		
		btnFlyReservation = new JButton("Flight Reservation");
		btnFlyReservation.setMnemonic(KeyEvent.VK_F);
		btnFlyReservation.setBounds(75, 80, 200, 20);
		add(btnFlyReservation);
		
		btnPackageReservation = new JButton("Package Reservation");
		btnPackageReservation.setMnemonic(KeyEvent.VK_P);
		btnPackageReservation.setBounds(75, 110, 200, 20);
		add(btnPackageReservation);
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setMnemonic(KeyEvent.VK_C);
		btnChangePassword.setBounds(75, 140, 200, 20);
		add(btnChangePassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setMnemonic(KeyEvent.VK_R);
		btnRegister.setBounds(125, 170, 100, 20);
		add(btnRegister);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setMnemonic(KeyEvent.VK_L);
		btnLogOut.setBounds(260, 10, 80, 20);
		add(btnLogOut);
		
		if(model.getCurrentUser().getAccessLevel() == 0){
			btnRegister.setVisible(false);
		}
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
