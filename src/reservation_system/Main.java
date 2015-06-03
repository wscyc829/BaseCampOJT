package reservation_system;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		try{
			RSModel model = new RSModel();
			RSController controller = new RSController(model);	
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,
					"Something went wrong, please contact the developer.", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}
}


