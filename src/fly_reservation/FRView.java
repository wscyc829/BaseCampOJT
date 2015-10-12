package fly_reservation;

import hotel_reservation.HotelReservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import references.AutoCompletion;
import references.JTextFieldHintUI;
import references.OwnTableCellRenderer;
import reservation_system.RSModel;

public class FRView extends JFrame{
	private JButton btnAdd;
	
	private JButton btnBack;
	
	private JButton btnSearch;
	
	private JButton btnRefresh;

	private JComboBox cbSearch, cbReservationType, cbFlightNumber;
	
	private JLabel lblSearch, lblDate, lblDash, lblTotalPayIn,
		lblTotalPayOut, lblTotalIncome, lblTotalRows;
	
	private JLabel lblImage;
	
	private JFormattedTextField ftfFromDate, ftfToDate, ftfTotalPayIn, ftfTotalPayOut,
	ftfTotalIncome;
	
	private JTable table;
	
	private JTextField tfSearch;
	
	private RSModel model;
	
	private String[] searchBy = new String[]{
			"Guest Name", "Reservation Type", "Flight Number"};
	
	private String[] columnNames = {"ID", "Created By",
			"Departure Date", "Origin", "Destination", "Flight No",
			"Payment Type", "Guest Name", "Gender", "Adult No",
			"Child No", "Option To Final", "Status", "Pay In - PHP", 
			"Option To Pay", "Pay Out - PHP", "Income - PHP"};
	
	public FRView(RSModel model){
		super("Flight Reservation");
		setSize(1200, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		
		lblImage = new JLabel(getImageIcon("/Pictures/tableLogo.png", 320, 50));
		lblImage.setBounds(850, 10, 420, 50);
		add(lblImage);
		
		btnAdd = new JButton("Add");
		btnAdd.setMnemonic(KeyEvent.VK_A);
		btnAdd.setBounds(10, 10, 100, 20);
		add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.setMnemonic(KeyEvent.VK_B);
		btnBack.setBounds(120, 10, 100, 20);
		add(btnBack);
		
		lblSearch = new JLabel("Search by :");
		lblSearch.setBounds(250, 10, 70, 20);
		add(lblSearch);
		
		lblDate = new JLabel("From - To (By Departure)");
		lblDate.setBounds(250, 40, 150, 20);
		add(lblDate);
		
		lblDash = new JLabel("-");
		lblDash.setBounds(500, 40, 20, 20);
		add(lblDash);
		
		cbSearch = new JComboBox(searchBy);
		cbSearch.setBounds(320, 10, 130, 20);
		add(cbSearch);
		
		tfSearch = new JTextField("");
		tfSearch.setBounds(460, 10, 200, 20);
		add(tfSearch);
		
		cbReservationType = new JComboBox(model.getReservationType().toArray());
		cbReservationType.setName("Reservation Type");
		cbReservationType.setEditable(true);
		new AutoCompletion(cbReservationType);
		cbReservationType.setBounds(460, 10, 200, 20);
		add(cbReservationType);
		
		cbFlightNumber = new JComboBox(model.getFlightNo().toArray());
		cbFlightNumber.setName("Flight Number");
		cbFlightNumber.setEditable(true);
		new AutoCompletion(cbFlightNumber);
		cbFlightNumber.setBounds(460, 10, 200, 20);
		add(cbFlightNumber);
		
		ftfFromDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfFromDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfFromDate.setBounds(400, 40, 100, 20);
		add(ftfFromDate);
		
		ftfToDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfToDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfToDate.setBounds(505, 40, 100, 20);
		add(ftfToDate);
		
		btnSearch = new JButton("Search");
		btnSearch.setMnemonic(KeyEvent.VK_S);
		btnSearch.setBounds(700, 10, 100, 20);
		add(btnSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setMnemonic(KeyEvent.VK_R);
		btnRefresh.setBounds(820, 10, 100, 20);
		add(btnRefresh);
		
		ArrayList<FlightReservation> flights = model.getAllFRs();
		
		String[][] data = new String[flights.size()][columnNames.length];
		
		table = new JTable(data, columnNames);
		
		DefaultTableModel tablemodel = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class<?> getColumnClass(int column) {
            	if(getRowCount() > 0){
            		return getValueAt(0, column).getClass();
            	}
            	else if(column == 0 || column == 9 || column == 10){
            		return Integer.class;
            	}
            	else if(column == 13 || column == 15 || column == 16){
            		return Double.class;
            	}
            	return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tablemodel){
			@Override
		    public Component prepareRenderer(TableCellRenderer renderer,
		                                       int row, int col)
		    {
		    	Component comp = super.prepareRenderer(renderer, row, col);
		        ((JLabel) comp).setHorizontalAlignment(JLabel.RIGHT);
		    	return comp;
			}
		};
		
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultRenderer(String.class, new OwnTableCellRenderer());
		table.setDefaultRenderer(Double.class, new OwnTableCellRenderer());
		table.setDefaultRenderer(Integer.class, new OwnTableCellRenderer());
		
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 70, 1175, 460);
		add(scrollPane);
		
		lblTotalPayIn = new JLabel("Total Pay In:");
		lblTotalPayIn.setBounds(140, 540, 100, 20);
		add(lblTotalPayIn);
		
		ftfTotalPayIn = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayIn.setEditable(false);
		ftfTotalPayIn.setBounds(240, 540, 100, 20);
		add(ftfTotalPayIn);
		
		lblTotalPayOut = new JLabel("Total Pay Out:");
		lblTotalPayOut.setBounds(480, 540, 100, 20);
		add(lblTotalPayOut);
		
		ftfTotalPayOut = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayOut.setEditable(false);
		ftfTotalPayOut.setBounds(580, 540, 100, 20);
		add(ftfTotalPayOut);
		
		lblTotalIncome= new JLabel("Total Income:");
		lblTotalIncome.setBounds(820, 540, 100, 20);
		add(lblTotalIncome);
		
		ftfTotalIncome = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalIncome.setEditable(false);
		ftfTotalIncome.setBounds(920, 540, 100, 20);
		add(ftfTotalIncome);
		
		lblTotalRows = new JLabel("");
		lblTotalRows.setBounds(10, 540, 100, 20);
		add(lblTotalRows);
		
		if(model.getCurrentUser().getAccessLevel() == 0){
			table.removeColumn(table.getColumnModel().getColumn(table.getColumnCount()-1));
			table.removeColumn(table.getColumnModel().getColumn(table.getColumnCount()-1));
            
			lblTotalPayIn.setVisible(false);
            lblTotalPayOut.setVisible(false);
            lblTotalIncome.setVisible(false);
            
            ftfTotalPayIn.setVisible(false);
            ftfTotalPayOut.setVisible(false);
            ftfTotalIncome.setVisible(false);
        }

		updateView(model.getAllFRs());
		listeners();
	}
	
	public Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
	    		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    
	    return resizedImg;
	}
	
	public ImageIcon getImageIcon(String url, int width, int height){
		Image temp;
		ImageIcon tempImageIcon = null;
		
		try {
			temp = ImageIO.read(this.getClass().getResource(url));
			temp = getScaledImage(temp, width, height);
			tempImageIcon = new ImageIcon(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tempImageIcon;
	}
	
	public void setTextFieldFocusListener(FocusListener listener){
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JFormattedTextField.class) ||
					c.getClass().equals(JTextField.class) ){
				((JTextField)c).addFocusListener(listener);
			}
		}
	}
	
	public void setTextFieldDocumentListener(DocumentListener listener){
		for(Component c:getContentPane().getComponents()){
			if(c.getClass().equals(JFormattedTextField.class) || 
					c.getClass().equals(JTextField.class) ){
				((JTextField)c).getDocument().addDocumentListener(listener);
			}
		}
	}
	
	public void setBtnAddListener(ActionListener listener){
		btnAdd.addActionListener(listener);
	}
	
	public void setBtnBackListener(ActionListener listener){
		btnBack.addActionListener(listener);
	}
	
	public void setBtnSearchListener(ActionListener listener){
		btnSearch.addActionListener(listener);
	}
	
	public void setBtnRefreshListener(ActionListener listener){
		btnRefresh.addActionListener(listener);
	}
	
	public void setTableSelectListener(ListSelectionListener listener){
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel.addListSelectionListener(listener);
	}
	
	public HashMap<String, String> getAllData(){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("start", ftfFromDate.getText());
		map.put("end", ftfToDate.getText());
		map.put("column name", cbSearch.getSelectedItem().toString());
		
		if(cbSearch.getSelectedItem().toString().equals("Reservation Type")){
			if(cbReservationType.getSelectedIndex() > -1){
				map.put("value", cbReservationType.getSelectedItem().toString());
			}
			else
				map.put("value", "");
		}
		else if(cbSearch.getSelectedItem().toString().equals("Flight Number")){
			if(cbFlightNumber.getSelectedIndex() > -1){
				map.put("value", cbFlightNumber.getSelectedItem().toString());
			}
			else
				map.put("value", "");
		}
		else{
			map.put("value", tfSearch.getText());
		}
		
		return map;
	}
	
	public void updateView(ArrayList<FlightReservation> frs){
		DefaultTableModel tablemodel = (DefaultTableModel)table.getModel();
		tablemodel.setRowCount(0);
		
		int i=0;
		
		double totalPayIn = 0, totalPayOut = 0, totalIncome = 0;
		
		for(FlightReservation fr : frs){
			Object[] r = {
					fr.getId(),
					fr.getCreatedBy(),
					fr.getDepartureDate(),
					fr.getOrigin(),
					fr.getDestination(),
					fr.getFlightNumber(),
					fr.getPaymentType(),
					fr.getGuestName(),
					fr.getGender(),
					model.INTEGER_FORMAT.format(fr.getNumberOfAdult()),
					model.INTEGER_FORMAT.format(fr.getNumberOfChild()),
					fr.getOptionToFinal(),
					fr.getStatus(),
					model.NUMBER_FORMAT.format(fr.getPayInPHP()),
					fr.getOptionToPay(),
					model.NUMBER_FORMAT.format(fr.getPayOutPHP()),
					model.NUMBER_FORMAT.format(fr.getIncomePHP())
			};
			
			tablemodel.addRow(r);
			i++;
			totalPayIn += fr.getPayInPHP();
			totalPayOut += fr.getPayOutPHP();
			totalIncome += fr.getIncomePHP();
		}
		
		ftfTotalPayIn.setValue(totalPayIn);
		ftfTotalPayOut.setValue(totalPayOut);
		ftfTotalIncome.setValue(totalIncome);
		
		lblTotalRows.setText(i + " rows");
		
		for (int column = 0; column < table.getColumnCount(); column++) {
			
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    int preferredWidth = 74;
		    int maxWidth = tableColumn.getMaxWidth();

		    for (int row = 0; row < table.getRowCount(); row++) {
		    	
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);

		        //  We've exceeded the maximum width, no need to check other rows

		        if (preferredWidth >= maxWidth) {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }

		    tableColumn.setPreferredWidth( preferredWidth );
		}
	}
	
	public void listeners(){
		cbSearch.setSelectedIndex(-1);
		cbSearch.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				if(cbSearch.getSelectedItem().toString().equals("N/A")){
					cbReservationType.setVisible(false);
					cbFlightNumber.setVisible(false);
					tfSearch.setVisible(false);
				}
				else if(cbSearch.getSelectedItem().toString().equals("Reservation Type")){
					cbReservationType.setVisible(true);
					cbFlightNumber.setVisible(false);
					tfSearch.setVisible(false);
				}
				else if(cbSearch.getSelectedItem().toString().equals("Flight Number")){
					cbReservationType.setVisible(false);
					cbFlightNumber.setVisible(true);
					tfSearch.setVisible(false);
				}
				else{
					cbReservationType.setVisible(false);
					cbFlightNumber.setVisible(false);
					tfSearch.setVisible(true);
					tfSearch.setText("");
				}
			}
		});
		
		cbSearch.setSelectedIndex(0);
	}
	
	public int getFRSelectedID(int row){
		int id = (Integer) table.getValueAt(row, 0);
		
		/*
		for(int i=0;i<table.getModel().getRowCount();i++){
			if((Integer)table.getModel().getValueAt(i, 1) == modelNo){
				return (Integer) table.getModel().getValueAt(i, 0);
			}
		}*/
		return id;
	}
}
