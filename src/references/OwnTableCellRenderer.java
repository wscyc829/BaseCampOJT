package references;

import java.awt.Color;
import java.awt.Component;
import javax.swing.table.*;
import javax.swing.*;

public class OwnTableCellRenderer extends DefaultTableCellRenderer {

	    public Component getTableCellRendererComponent(JTable table, 
	                                                   Object value,
	                                                   boolean isSelected,
	                                                   boolean hasFocus, 
	                                                   int row, 
	                                                   int column) {
	        setBackground(Color.white);
	        setForeground(Color.black);
	        
	        TableCellRenderer renderer;
	        TableModel model = table.getModel();
	        int modelRow = table.getRowSorter().convertRowIndexToModel(row);
	        int columnStatusPosition = 13;
	        String statusColumnValue = (String) model.getValueAt(modelRow, columnStatusPosition);
	        
	        if (statusColumnValue.equals("Cancelled")) {
	        	setOpaque(true);
	            setBackground(Color.decode("#FF7373"));
	            setForeground(Color.WHITE);
	        }
	        else if(statusColumnValue.equals("Paid")){
	        	setOpaque(true);
	            setBackground(Color.decode("#2EB82E"));
	            setForeground(Color.WHITE);
	        }
	        else {
	        	setOpaque(false);
	        }
	        
	        boolean isMark = Boolean.valueOf(model.getValueAt(modelRow, model.getColumnCount()-1).toString());
	        
	        if(isMark){
	        	setBorder(BorderFactory.createLineBorder(Color.yellow));
	        }
	        else{
	        	setBorder(null);
	        }
	        
	        setText(value != null ? value.toString() : "");
	        return this;
	    }
	}