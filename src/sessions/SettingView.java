package sessions;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import reservation_system.RSModel;

public class SettingView extends JFrame{
	private JLabel lblIPAddress;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	private JFormattedTextField ftfIPAddress;
	private JTextField tfUsername;
	private JTextField tfPassword;
	
	private JButton btnSave;
	private JButton btnCancel;
	
	private RSModel model;
	
	public SettingView(RSModel model){
		super("Setting Page");
	    setLayout(null);
	    setSize(230, 175);
	    setResizable(false);
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());

	    this.model = model;
	    
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    
	    lblIPAddress = new JLabel("IP Address");
	    lblIPAddress.setBounds(10,10,80,20);
	    add(lblIPAddress);
	    
	    lblUsername = new JLabel("DB Username");
	    lblUsername.setBounds(10,50,100,20);
	    add(lblUsername);
	    
	    lblPassword = new JLabel("DB Password");
	    lblPassword.setBounds(10,90,80,20);
	    add(lblPassword);
	    
	    ftfIPAddress = new JFormattedTextField(model.IP_FORMAT);
	    ftfIPAddress.setValue(model.getIp());
	    ftfIPAddress.setBounds(90,10,120,20);
	    add(ftfIPAddress);
	    
	    tfUsername = new JTextField(model.getDbUser());
	    tfUsername.setBounds(90,50,120,20);
	    add(tfUsername);
	    
	    tfPassword = new JTextField(model.getDbPass());
	    tfPassword.setBounds(90,90,120,20);
	    add(tfPassword);
	    
	    btnSave = new JButton("Save");
	    btnSave.setMnemonic(KeyEvent.VK_S);
	    btnSave.setBounds(10,120,100,20);
	    add(btnSave);
	    
	    btnCancel = new JButton("Cancel");
	    btnCancel.setMnemonic(KeyEvent.VK_C);
	    btnCancel.setBounds(115,120,100,20);
	    add(btnCancel);
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
	
	public void setBtnSaveListener(ActionListener listener){
		btnSave.addActionListener(listener);
	}
	
	public void setBtnCancelListener(ActionListener listener){
		btnCancel.addActionListener(listener);
	}
	
	public void updateData(String ip, String username, String password){
		ftfIPAddress.setText(ip);
		tfUsername.setText(username);
		tfPassword.setText(password);
	}
	
	public HashMap<String, String> getAllData(){
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("IP", ftfIPAddress.getText());
		list.put("Username", tfUsername.getText());
		list.put("Password", tfPassword.getText());
		return list;
	}
}
