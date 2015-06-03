package sessions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;

import reservation_system.RSModel;

public class ChangePasswordView extends JFrame{
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	
	private JTextField tfOldPassword;
	private JTextField tfNewPassword;
	
	private JButton btnSave;
	private JButton btnCancel;
	
	private RSModel model;
	
	public ChangePasswordView(RSModel model){
		super("Change Password Page");
	    setLayout(null);
	    setSize(300, 140);
	    setResizable(false);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());

	    this.model = model;
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    
	    lblOldPassword = new JLabel("Old Password");
	    lblOldPassword.setBounds(30,10,100,20);
	    add(lblOldPassword);
	    
	    lblNewPassword = new JLabel("New Password");
	    lblNewPassword.setBounds(30,50,100,20);
	    add(lblNewPassword);
	    
	    tfOldPassword = new JTextField("");
	    tfOldPassword.setName("Old Password");
	    tfOldPassword.setBounds(140,10,120,20);
	    add(tfOldPassword);
	    
	    tfNewPassword = new JTextField("");
	    tfNewPassword.setName("New Password");
	    tfNewPassword.setBounds(140,50,120,20);
	    add(tfNewPassword);
	    
	    btnSave = new JButton("Save");
	    btnSave.setMnemonic(KeyEvent.VK_S);
	    btnSave.setBounds(30,80,100,20);
	    add(btnSave);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setMnemonic(KeyEvent.VK_C);
	    btnCancel.setBounds(160,80,100,20);
	    add(btnCancel);
	}
	
	public void setBtnSaveListener(ActionListener listener){
		btnSave.addActionListener(listener);
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
	
	public HashMap<String, String> getAllData(){
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("Old password", tfOldPassword.getText());
		list.put("New password", tfNewPassword.getText());
		return list;
	}
}

