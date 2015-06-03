package hotel_reservation;

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
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import references.AutoCompletion;
import references.JTextFieldHintUI;
import references.OwnTableCellRenderer;
import reservation_system.RSModel;

public class HRView extends JFrame{
	private JButton btnAdd;
	
	private JButton btnBack;
	private JButton btnSearch;
	private JButton btnRefresh;

	private JButton btnPrint;
	private JButton btnPrintBilling;
	
	private JLabel lblSearch, lblDate, lblDash, lblTotalPayIn, lblTotalPayOut, lblTotalIncome;
	
	private JLabel lblImage;
	
	private JComboBox cbSearch, cbHotelOrResort;
	
	private JTextField tfSearch;
	
	private JFormattedTextField ftfFromDate, ftfToDate, ftfTotalPayIn, ftfTotalPayOut,
		ftfTotalIncome;
	
	
	private JTable table;

	private ArrayList<HotelReservation> hrs;
	private RSModel model;
	
	public HRView(RSModel model){
		super("Hotel Reservation");
		setSize(1200,600);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Pictures/icon.png")).getImage());
		
		this.model = model;
		hrs = new ArrayList<HotelReservation>();
		
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
		
		lblDate = new JLabel("From - To (By Check In)");
		lblDate.setBounds(250, 40, 150, 20);
		add(lblDate);
		
		lblDash = new JLabel("-");
		lblDash.setBounds(500, 40, 20, 20);
		add(lblDash);
		
		cbSearch = new JComboBox(new String[]{"N/A", "Hotel/Resort", "Guest Name", "Status", "Reservation Type", "Reservation Date"});
		cbSearch.setBounds(320, 10, 130, 20);
		add(cbSearch);
		
		tfSearch = new JTextField("");
		tfSearch.setBounds(460, 10, 200, 20);
		add(tfSearch);
		
		cbHotelOrResort = new JComboBox(model.getHotelOrResort().toArray());
		cbHotelOrResort.setName("Hotel/Resort");
		cbHotelOrResort.setEditable(true);
		new AutoCompletion(cbHotelOrResort);
		cbHotelOrResort.setBounds(460, 10, 200, 20);
		add(cbHotelOrResort);
		
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
		
		btnPrint = new JButton("Print");
		btnPrint.setMnemonic(KeyEvent.VK_P);
		btnPrint.setBounds(700, 40, 100, 20);
		add(btnPrint);
		
		btnPrintBilling = new JButton("Print Billing");
		btnPrintBilling.setMnemonic(KeyEvent.VK_B);
		btnPrintBilling.setBounds(820, 40, 100, 20);
		add(btnPrintBilling);
		
		String[] columnNames = {"ID", "No.", "Created By", "Check In", "Check Out", 
				"Reservation Date", "Hotel/Resort", "Guest Name", "Room Type", 
				"No Of Rooms", "Reservation Type", "Payment Type", "Option To Final",
				"Status", "Pay In - PHP", "Opt To Pay", "Pay Out - PHP", "Income - PHP",
				"isMark"};
		
		ArrayList<HotelReservation> list = model.getAllHRs();
		String[][] data = new String[list.size()][columnNames.length];
		
		DefaultTableModel tablemodel = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class<?> getColumnClass(int column) {
            	if(getRowCount() > 0){
            		return getValueAt(0, column).getClass();
            	}
            	else if(column == 0 || column == 1 || column == 9){
            		return Integer.class;
            	}
            	else if(column == 14 || column == 16 || column == 17){
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
		table.removeColumn(table.getColumnModel().getColumn(0));
		table.removeColumn(table.getColumnModel().getColumn(table.getColumnCount()-1));
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 70, 1175, 460);
		add(scrollPane);
		
		lblTotalPayIn = new JLabel("Total Pay In:");
		lblTotalPayIn.setBounds(140, 540, 100, 20);
		add(lblTotalPayIn);
		
		ftfTotalPayIn = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayIn.setValue(new Double(0));
		ftfTotalPayIn.setBounds(240, 540, 100, 20);
		ftfTotalPayIn.setEditable(false);
		add(ftfTotalPayIn);
		
		lblTotalPayOut = new JLabel("Total Pay Out:");
		lblTotalPayOut.setBounds(480, 540, 100, 20);
		add(lblTotalPayOut);
		
		ftfTotalPayOut = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalPayOut.setValue(new Double(0));
		ftfTotalPayOut.setBounds(580, 540, 100, 20);
		ftfTotalPayOut.setEditable(false);
		add(ftfTotalPayOut);
		
		lblTotalIncome= new JLabel("Total Income:");
		lblTotalIncome.setBounds(820, 540, 100, 20);
		add(lblTotalIncome);
		
		ftfTotalIncome = new JFormattedTextField(model.NUMBER_FORMAT);
		ftfTotalIncome.setValue(new Double(0));
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
		
		this.hrs = model.getAllHRs();
		updateView(this.hrs);
		
		listeners();
	}
	
	public ArrayList<HotelReservation> getHrs() {
		return hrs;
	}


	public void setHrs(ArrayList<HotelReservation> hrs) {
		this.hrs = hrs;
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
	
	public void setBtnPrintListener(ActionListener listener){
		btnPrint.addActionListener(listener);
	}
	public void setBtnPrintBillingListener(ActionListener listener){
		btnPrintBilling.addActionListener(listener);
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
		if(cbSearch.getSelectedItem().toString().equals("Hotel/Resort")){
			if(cbHotelOrResort.getSelectedIndex() > -1){
				map.put("value", cbHotelOrResort.getSelectedItem().toString());
			}
			else
				map.put("value", "");
		}
		else if(cbSearch.getSelectedItem().toString().equals("N/A")){
			map.put("value", "");
		}
		else{
			map.put("value", tfSearch.getText());
		}
		return map;
	}
	
	public void updateView(ArrayList<HotelReservation> hrs){
		DefaultTableModel tablemodel = (DefaultTableModel)table.getModel();
		tablemodel.setRowCount(0);
		
		int i=0;
		
		double totalPayIn = 0, totalPayOut = 0, totalIncome = 0;
		
		for(HotelReservation hr : hrs){
			Object[] r = {
					hr.getId(),
					(i+1),
					hr.getCreatedBy(),
					hr.getCheckIn(),
					hr.getCheckOut(),
					hr.getReservationDate(),
					hr.getHotelOrResort(),
					hr.getGuestName(),
					hr.getRoomType(),
					hr.getNumberOfRooms(),
					hr.getReservationType(),
					hr.getPaymentType(),
					hr.getOptionToFinal(),
					hr.getStatus(),
					hr.getPayInPHP(),
					hr.getOptionToPay(),
					hr.getPayOutPHP(),
					hr.getIncomePHP(),
					hr.isMark()
			};

			tablemodel.addRow(r);
			i++;
			
			if(!hr.getStatus().equals("Cancelled")){
				totalPayIn += hr.getPayInPHP();
				totalPayOut += hr.getPayOutPHP();
				totalIncome += hr.getIncomePHP();
			}
		}
		ftfTotalPayIn.setValue(totalPayIn);
		ftfTotalPayOut.setValue(totalPayOut);
		ftfTotalIncome.setValue(totalIncome);
		

		for (int column = 0; column < table.getColumnCount(); column++)
		{
		    TableColumn tableColumn = table.getColumnModel().getColumn(column);
		    //int preferredWidth = tableColumn.getMinWidth();
		    int preferredWidth = 70;
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
	
	public void listeners(){
		cbSearch.setSelectedIndex(-1);
		cbSearch.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				if(cbSearch.getSelectedItem().toString().equals("N/A")){
					btnPrintBilling.setVisible(false);
					tfSearch.setVisible(false);
					cbHotelOrResort.setVisible(false);
				}
				else if(cbSearch.getSelectedItem().toString().equals("Hotel/Resort")){
					btnPrintBilling.setVisible(true);
					tfSearch.setVisible(false);
					cbHotelOrResort.setVisible(true);
				}
				else{
					btnPrintBilling.setVisible(false);
					cbHotelOrResort.setVisible(false);
					tfSearch.setVisible(true);
					tfSearch.setText("");
				}
			}
		});
		
		cbSearch.setSelectedIndex(0);
	}
	
	public int getHRSelectedID(int row){
		int modelNo = (Integer) table.getValueAt(row, 0);

		for(int i=0;i<table.getModel().getRowCount();i++){
			if((Integer)table.getModel().getValueAt(i, 1) == modelNo){
				return (Integer) table.getModel().getValueAt(i, 0);
			}
		}
		return 0;
	}
}
