package fly_reservation;

import hotel_reservation.HotelReservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import references.JTextFieldHintUI;
import reservation_system.RSModel;

public class FRView extends JFrame{
	private JButton btnAdd;
	private JButton btnBack;
	private JButton btnSearch;
	private JButton btnRefresh;
	
	private JLabel lblSearch, lblDate, lblDash, lblTotalPayIn, lblTotalPayOut, lblTotalIncome;
	
	private JLabel lblImage;
	
	private JComboBox cbSearch;
	
	private JTextField tfSearch;
	
	private JFormattedTextField ftfFromDate, ftfToDate, ftfTotalPayIn, ftfTotalPayOut,
		ftfTotalIncome;
	
	private JTable table;
	
	private RSModel model;
	
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
		btnAdd.setBounds(10, 10, 100, 20);
		add(btnAdd);
		
		btnBack = new JButton("Back");
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
		
		cbSearch = new JComboBox(new String[]{"Guest Name", "Reservation Type", "Flight No"});
		cbSearch.setBounds(320, 10, 130, 20);
		add(cbSearch);
		
		tfSearch = new JTextField("");
		tfSearch.setBounds(460, 10, 200, 20);
		add(tfSearch);
		
		ftfFromDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfFromDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfFromDate.setBounds(400, 40, 100, 20);
		add(ftfFromDate);
		
		ftfToDate = new JFormattedTextField(model.DATE_FORMAT);
		ftfToDate.setUI(new JTextFieldHintUI("yyyy/mm/dd", Color.gray));
		ftfToDate.setBounds(505, 40, 100, 20);
		add(ftfToDate);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(700, 10, 100, 20);
		add(btnSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(820, 10, 100, 20);
		add(btnRefresh);
		
		String[] columnNames = {"ID", "No.", "Created By", "Departure Date", "Origin", "Destination", "Flight No",
								"Payment Type", "Guest Name", "Gender", "Adult No",
								"Child No", "Pay In - PHP", "Pay Out - PHP", "Income - PHP"};
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
            	else if(column == 0 || column == 1 || column == 9 || column == 10){
            		return Integer.class;
            	}
            	else if(column == 11 || column == 12 || column == 13){
            		return Double.class;
            	}
            	return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tablemodel);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 70, 1180, 460);
		add(scrollPane);
		
		lblTotalPayIn = new JLabel("Total Pay In:");
		lblTotalPayIn.setBounds(140, 540, 100, 20);
		add(lblTotalPayIn);
		
		ftfTotalPayIn = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayIn.setBounds(240, 540, 100, 20);
		ftfTotalPayIn.setEditable(false);
		add(ftfTotalPayIn);
		
		lblTotalPayOut = new JLabel("Total Pay Out:");
		lblTotalPayOut.setBounds(480, 540, 100, 20);
		add(lblTotalPayOut);
		
		ftfTotalPayOut = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayOut.setBounds(580, 540, 100, 20);
		ftfTotalPayOut.setEditable(false);
		add(ftfTotalPayOut);
		
		lblTotalIncome= new JLabel("Total Income:");
		lblTotalIncome.setBounds(820, 540, 100, 20);
		add(lblTotalIncome);
		
		ftfTotalIncome = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalIncome.setBounds(920, 540, 100, 20);
		ftfTotalIncome.setEditable(false);
		add(ftfTotalIncome);
		
		if(model.getCurrentUser().getAccessLevel() == 0){
			table.removeColumn(table.getColumnModel().getColumn(table.getColumnCount()-1));
			table.removeColumn(table.getColumnModel().getColumn(table.getColumnCount()-1));
            
            lblTotalPayOut.setVisible(false);
            lblTotalIncome.setVisible(false);
            
            ftfTotalPayOut.setVisible(false);
            ftfTotalIncome.setVisible(false);
        }

		updateView(model.getAllFRs());
	}
	
	public Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempImageIcon;
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
		map.put("value", tfSearch.getText());
		
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
					(i+1),
					fr.getCreatedBy(),
					fr.getDepartureDate(),
					fr.getOrigin(),
					fr.getDestination(),
					fr.getFlightNumber(),
					fr.getPaymentType(),
					fr.getGuestName(),
					fr.getGender(),
					fr.getNumberOfAdult(),
					fr.getNumberOfChild(),
					fr.getPayInPHP(),
					fr.getPayOutPHP(),
					fr.getPayOutPHP()
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
		
		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    
		    int preferredWidth = 980/table.getColumnCount();
		    int maxWidth = tableColumn.getMaxWidth();

		    for (int row = 0; row < table.getRowCount(); row++)
		    {
		        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
		        Component c = table.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);

		        //  We've exceeded the maximum width, no need to check other rows

		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }

		    tableColumn.setPreferredWidth( preferredWidth );
		}
	}
	
	public int getFRSelectedID(int row){
		int modelNo = (Integer) table.getValueAt(row, 0);

		for(int i=0;i<table.getModel().getRowCount();i++){
			if((Integer)table.getModel().getValueAt(i, 1) == modelNo){
				return (Integer) table.getModel().getValueAt(i, 0);
			}
		}
		return 0;
	}
}
