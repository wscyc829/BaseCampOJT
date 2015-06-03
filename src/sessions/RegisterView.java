package sessions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;

import reservation_system.RSModel;
import reservation_system.User;

public class RegisterView extends JFrame{
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblAccessLevel;
	
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JComboBox cbAccessLevel;
	
	private JButton btnRegister, btnCancel;
	
	private RSModel model;
	
	public RegisterView(RSModel model){
		super("Registration Page");
	    setLayout(null);
	    setSize(270, 200);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());

	    this.model = model;
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    
	    lblUsername = new JLabel("Username");
	    lblUsername.setBounds(20,10,80,20);
	    add(lblUsername);
	    
	    lblPassword = new JLabel("Password");
	    lblPassword.setBounds(20,50,80,20);
	    add(lblPassword);
	    
	    lblAccessLevel = new JLabel("Access Level");
	    lblAccessLevel.setBounds(20,90,80,20);
	    add(lblAccessLevel);
	    
	    tfUsername = new JTextField(10);
	    tfUsername.setName("Username");
	    tfUsername.setBounds(105,10,130,20);
	    add(tfUsername);
	    
	    tfPassword = new JTextField(10);
	    tfPassword.setName("Password");
	    tfPassword.setBounds(105,50,130,20);
	    add(tfPassword);
	    
	    cbAccessLevel = new JComboBox(new String[]{"0 - Employee level", "1 - Admin level"});
	    cbAccessLevel.setBounds(105,90,130,20);
	    add(cbAccessLevel);
	    
	    btnRegister = new JButton("Register");
	    btnRegister.setMnemonic(KeyEvent.VK_R);
	    btnRegister.setBounds(20,130,100,20);
	    add(btnRegister);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setMnemonic(KeyEvent.VK_C);
	    btnCancel.setBounds(135,130,100,20);
	    add(btnCancel);
	}
	
	public void setBtnRegisterListener(ActionListener listener){
		btnRegister.addActionListener(listener);
	}
	
	public void setBtnCancelListener(ActionListener listener){
		btnCancel.addActionListener(listener);
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
	
	public boolean isInputValid(){
		Border red = BorderFactory.createLineBorder(Color.red);
		Border tfBorder = new JTextField().getBorder();
		Border cbBorder = new JComboBox().getBorder();
		String message = "";
		
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JTextField.class) ||
					c.getClass().equals(JFormattedTextField.class)){
				
				JTextField tf = (JTextField)c;
				
				if(tf.getText().length() == 0){
					
					tf.setBorder(red);
					message += tf.getName() + "\n";
				}
				else{
					tf.setBorder(tfBorder);
				}
			}
		}

		if(message.length() > 0){
			JOptionPane.showMessageDialog(this,
					"Please input the following: \n" + message,
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public User getAllData(){
		User user = new User(tfUsername.getText(), 
				tfPassword.getText(), 
				cbAccessLevel.getSelectedIndex());
		
		return user;
	}
}
