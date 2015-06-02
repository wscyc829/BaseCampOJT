package sessions;

import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentListener;

import reservation_system.RSModel;

public class LoginView extends JFrame{
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JLabel label1;
	private JLabel label2;
	private JButton btnLogin;
	private JButton btnQuit;
	private JButton btnSetting;
	
	private RSModel model;
	
	public LoginView(RSModel model){
		super("Login Page");
	    setLayout(null);
	    setSize(230, 165);
	    setResizable(false);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());

	    this.model = model;
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    
	    label1 = new JLabel("Username");
	    label1.setBounds(10,10,80,20);
	    add(label1);
	    
	    label2 = new JLabel("Password");
	    label2.setBounds(10,50,80,20);
	    add(label2);
	    
	    tfUsername = new JTextField(10);
	    tfUsername.setBounds(90,10,120,20);
	    add(tfUsername);
	    
	    pfPassword = new JPasswordField(10);
	    pfPassword.setBounds(90,50,120,20);
	    add(pfPassword);
	    
	    btnLogin = new JButton("Login");
	    btnLogin.setBounds(30,80,80,20);
	    add(btnLogin);
	    
	    btnQuit = new JButton("Quit");
	    btnQuit.setBounds(120,80,80,20);
	    add(btnQuit);
	    
	    btnSetting = new JButton("Setting");
	    btnSetting.setBounds(75,110,80,20);
	    add(btnSetting);
	    
	    listeners();
	}

	public void setBtnLoginListener(ActionListener listener){
		btnLogin.addActionListener(listener);
	}
	
	public void setBtnQuitListener(ActionListener listener){
		btnQuit.addActionListener(listener);
	}
	
	public void setBtnSettingListener(ActionListener listener){
		btnSetting.addActionListener(listener);
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
	
	public HashMap<String, String> getAllData(){
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("username", tfUsername.getText());
		data.put("password", new String(pfPassword.getPassword()));
		
		return data;
	}
	
	public void listeners(){
		tfUsername.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == e.VK_ENTER){
					tfUsername.requestFocus(false);
					pfPassword.requestFocus();
				}
			}
			public void keyTyped(KeyEvent e) {}
			
			public void keyReleased(KeyEvent e) {}
		});
		
		pfPassword.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == e.VK_ENTER){
					btnLogin.doClick();
				}
			}
			
			public void keyTyped(KeyEvent arg0) { }
			
			public void keyReleased(KeyEvent arg0) { }
		});
	}
}
