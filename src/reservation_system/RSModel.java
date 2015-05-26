package reservation_system;

import fly_reservation.FRHistory;
import fly_reservation.FlightReservation;
import hotel_reservation.HRHistory;
import hotel_reservation.HotelReservation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import package_reservation.PRHistory;
import package_reservation.PackageReservation;

public class RSModel {
	public DateFormat DATE_FORMAT;
	public DateFormat TIME_FORMAT;
	public DateFormat DATE_TIME_FORMAT;
	public NumberFormat NUMBER_FORMAT;
	public NumberFormat INTEGER_FORMAT;
	public MaskFormatter IP_FORMAT;
	private String ip = "000.000.000.000";
	private String dbUser = "";
	private String dbPass = "";
	
	private User currentUser;
	
	public RSModel(){
		currentUser = null;
		
		DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
		TIME_FORMAT = new SimpleDateFormat("HH:mm");
		DATE_TIME_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		NUMBER_FORMAT = NumberFormat.getNumberInstance();
		NUMBER_FORMAT.setMaximumFractionDigits(2);
		INTEGER_FORMAT = NumberFormat.getIntegerInstance();
		try {
			IP_FORMAT = new MaskFormatter("###.###.###.###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getIp() {
		return ip;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPass() {
		return dbPass;
	}

	public User getCurrentUser(){
		return currentUser;
	}
	
	public boolean login(String username, String password){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from user where username ='" + 
				username + "'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			 
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					
					currentUser = new User(rs.getString("username"),
											rs.getString("password"), 
											rs.getInt("access level"));
					
					connect.close();
					return true;
				}else{
					JOptionPane.showMessageDialog(null,
							"Wrong password!",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,
						"User doesn't exists!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return false;
	}

	public boolean register(User user){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "INSERT INTO user (username,password,`access level`)"
						+ " VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', "
						+ user.getAccessLevel() + ")";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			stat.executeUpdate(query);
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
			return false;
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
			return false;
		}
		return true;
	}
	
	public boolean changePassword(String oldPass, String newPass){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from user where username ='" + 
				currentUser.getUsername() + "'";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			 
			if(rs.next()){
				if(oldPass.equals(rs.getString("password"))){
					
					query = "UPDATE user SET " +
							"password = '" + newPass + "' " +
							"WHERE id = " + rs.getInt("id");
					
					stat.execute(query);
					currentUser.setPassword(newPass);
					
					connect.close();
					return true;
				}else{
					JOptionPane.showMessageDialog(null,
							"Wrong old password!",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null,
						"User doesn't exists!",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return false;
	}
	
	public void addHR(HotelReservation hr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;

		String query = "INSERT INTO `hotel reservation` " + 
				"(`created by`, `created at`, `check in`, `check out`, `hotel/resort`, " +
				"`guest name`, `confirmation number`, `number of adult`, `number of child`," +
				"`number of nights`, `room type`, `number of rooms`," +
				"`breakfast`, `option to pay`, `amount to pay`, `reservation date`, " +
				"`reservation type`, `company`, `payment type`, `receipt number`, " +
				"`pay in - php`, `pay in - krw`, `pay in - date`, `pay out - php`, `pay out - krw`," + 
				"`pay out - date`, `income - php`, `income - krw`, `note`, `status`)" +
				"VALUES (" +
				"'" + currentUser.getUsername() + "'," +
				"'" + DATE_TIME_FORMAT.format(new Date()) + "'," +
				"'" + hr.getCheckIn() + "'," +
				"'" + hr.getCheckOut() + "'," +
				"'" + hr.getHotelOrResort() + "'," +
				"'" + hr.getGuestName() + "'," +
				"'" + hr.getConfirmationNumber() + "'," +
				hr.getNumberOfAdult() + "," +
				hr.getNumberOfChild() + "," +
				hr.getNumberOfNights() + "," +
				"'" + hr.getRoomType() + "'," +
				hr.getNumberOfRooms() + "," +
				"'" + hr.getBreakfast() + "'," +
				"'" + hr.getOptionToPay() + "'," +
				hr.getAmountToPay() + "," +
				"'" + hr.getReservationDate() + "'," +
				"'" + hr.getReservationType() + "'," +
				"'" + hr.getCompany() + "'," +
				"'" + hr.getPaymentType() + "'," +
				"'" + hr.getReceiptNumber() + "'," +
				hr.getPayInPHP() + "," +
				hr.getPayInKRW() + "," +
				"'" + hr.getPayInDate() + "'," +
				hr.getPayOutPHP() + "," +
				hr.getPayOutKRW() + "," +
				"'" + hr.getPayOutDate() + "'," +
				hr.getIncomePHP() + "," +
				hr.getIncomeKRW() + "," +
				"'" + hr.getNote() + "'," +
				"'" + hr.getStatus() + "')";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			stat.execute(query);
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public void updateHR(HotelReservation hr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		boolean edited = false;
		HotelReservation old = getAllHRs("", "", "id", hr.getId()+"").get(0);
		
		String query = "UPDATE `hotel reservation` SET " + 
				"`check in` = '" + hr.getCheckIn() + "'," +
				"`check out` = '" + hr.getCheckOut() + "'," +
				"`hotel/resort` = '" + hr.getHotelOrResort() + "'," +
				"`guest name` = '" + hr.getGuestName() + "'," +
				"`confirmation number` = '" + hr.getConfirmationNumber() + "'," +
				"`number of adult` = " + hr.getNumberOfAdult() + "," +
				"`number of child` = " + hr.getNumberOfChild() + "," +
				"`number of nights` = " + hr.getNumberOfNights() + "," +
				"`room type` = '" + hr.getRoomType() + "'," +
				"`number of rooms` = " + hr.getNumberOfRooms() + "," +
				"`breakfast` = '" + hr.getBreakfast() + "'," +
				"`option to pay` = '" + hr.getOptionToPay() + "'," +
				"`amount to pay` = " + hr.getAmountToPay() + "," +
				"`reservation date` = '" + hr.getReservationDate() + "'," +
				"`reservation type` = '" + hr.getReservationType() + "'," +
				"`company` = '" + hr.getCompany() + "'," +
				"`payment type` = '" + hr.getPaymentType() + "'," +
				"`receipt number` = '" + hr.getReceiptNumber() + "'," +
				"`pay in - php` = " + hr.getPayInPHP() + "," +
				"`pay in - krw` = " + hr.getPayInKRW() + "," +
				"`pay in - date` = '" + hr.getPayInDate() + "'," +
				"`pay out - php` = " + hr.getPayOutPHP() + "," +
				"`pay out - krw` = " + hr.getPayOutKRW() + "," +
				"`pay out - date` = '" + hr.getPayOutDate() + "'," +
				"`income - php` = " + hr.getIncomePHP() + "," +
				"`income - krw` = " + hr.getIncomeKRW() + "," +
				"`note` = '" + hr.getNote() + "'," +
				"`status` = '" + hr.getStatus() + "' " +
				"WHERE id = " + hr.getId();
		
		String query1 = "INSERT INTO `hr history` " +
				"(`hr id`, `name`, `date`, `isCheckInEdited`, `isCheckOutEdited`," +
				"`isHotel/ResortEdited`, `isGuestNameEdited`, `isNumberOfAdultEdited`, " +
				"`isNumberOfChildEdited`, `isNumberOfNightsEdited`, `isRoomTypeEdited`," +
				"`isNumberOfRoomsEdited`, `isOptionToPayEdited`, `isAmountToPayEdited`," +
				"`isReservationDateEdited`, `isReservationTypeEdited`, `isCompanyEdited`," +
				"`isPaymentTypeEdited`, `isReceiptNumberEdited`, `isPayInPHPEdited`," +
				"`isPayInKRWEdited`, `isPayInDateEdited`, `isPayOutPHPEdited`, " + 
				"`isPayOutKRWEdited`, `isPayOutDateEdited`, `isIncomePHPEdited`," +
				"`isIncomeKRWEdited`, `isStatusEdited`, `isConfirmationNumberEdited`, " +
				"`isBreakfastEdited`, `isNoteEdited`) " +
				"VALUES(" +
				old.getId() + ", " +
				"'" + currentUser.getUsername() + "'," +
				"'" + DATE_TIME_FORMAT.format(new Date()) + "'," +
				((edited = edited || !old.getCheckIn().equals(hr.getCheckIn())) && !old.getCheckIn().equals(hr.getCheckIn())) + "," +
                ((edited = edited || !old.getCheckOut().equals(hr.getCheckOut())) && !old.getCheckOut().equals(hr.getCheckOut())) + "," +
                ((edited = edited || !old.getHotelOrResort().equals(hr.getHotelOrResort())) && !old.getHotelOrResort().equals(hr.getHotelOrResort()))+ "," +
                ((edited = edited || !old.getGuestName().equals(hr.getGuestName())) && !old.getGuestName().equals(hr.getGuestName())) + "," +
                ((edited = edited || (old.getNumberOfAdult() != hr.getNumberOfAdult())) && (old.getNumberOfAdult() != hr.getNumberOfAdult()))+ "," +
                ((edited = edited || (old.getNumberOfChild() != hr.getNumberOfChild())) && (old.getNumberOfChild() != hr.getNumberOfChild()))+ "," +
                ((edited = edited || (old.getNumberOfNights() != hr.getNumberOfNights())) && (old.getNumberOfNights() != hr.getNumberOfNights())) + "," +
                ((edited = edited || !old.getRoomType().equals(hr.getRoomType())) && !old.getRoomType().equals(hr.getRoomType())) + "," +
                ((edited = edited || (old.getNumberOfRooms() != hr.getNumberOfRooms())) && (old.getNumberOfRooms() != hr.getNumberOfRooms())) + "," +      
                ((edited = edited || !old.getOptionToPay().equals(hr.getOptionToPay())) && !old.getOptionToPay().equals(hr.getOptionToPay())) + "," +
                ((edited = edited || (old.getAmountToPay() != hr.getAmountToPay())) && (old.getAmountToPay() != hr.getAmountToPay()))+ "," +
                ((edited = edited || !old.getReservationDate().equals(hr.getReservationDate())) && !old.getReservationDate().equals(hr.getReservationDate())) + "," +
                ((edited = edited || !old.getReservationType().equals(hr.getReservationType())) && !old.getReservationType().equals(hr.getReservationType())) + "," +
                ((edited = edited || !old.getCompany().equals(hr.getCompany())) && !old.getCompany().equals(hr.getCompany())) + "," +
                ((edited = edited || !old.getPaymentType().equals(hr.getPaymentType())) && !old.getPaymentType().equals(hr.getPaymentType())) + "," +
                ((edited = edited || !old.getReceiptNumber().equals(hr.getReceiptNumber())) && !old.getReceiptNumber().equals(hr.getReceiptNumber())) + "," +
                ((edited = edited || (old.getPayInPHP() != hr.getPayInPHP())) && (old.getPayInPHP() != hr.getPayInPHP())) + "," +
                ((edited = edited || (old.getPayInKRW() != hr.getPayInKRW())) && (old.getPayInKRW() != hr.getPayInKRW())) + "," +
                ((edited = edited || !old.getPayInDate().equals(hr.getPayInDate())) && !old.getPayInDate().equals(hr.getPayInDate())) + "," +
                ((edited = edited || (old.getPayOutPHP() != hr.getPayOutPHP())) && (old.getPayOutPHP() != hr.getPayOutPHP())) + "," +
                ((edited = edited || (old.getPayOutKRW() != hr.getPayOutKRW())) && (old.getPayOutKRW() != hr.getPayOutKRW())) + "," +
                ((edited = edited || !old.getPayOutDate().equals(hr.getPayOutDate())) && !old.getPayOutDate().equals(hr.getPayOutDate())) + "," +
                ((edited = edited || (old.getIncomePHP() != hr.getIncomePHP())) && (old.getIncomePHP() != hr.getIncomePHP())) + "," +
                ((edited = edited || (old.getIncomeKRW() != hr.getIncomeKRW())) && (old.getIncomeKRW() != hr.getIncomeKRW())) + "," +
                ((edited = edited || !old.getStatus().equals(hr.getStatus())) && !old.getStatus().equals(hr.getStatus()))+ "," +
                ((edited = edited || !old.getConfirmationNumber().equals(hr.getConfirmationNumber())) && !old.getConfirmationNumber().equals(hr.getConfirmationNumber())) + "," +
                ((edited = edited || !old.getBreakfast().equals(hr.getBreakfast())) && !old.getBreakfast().equals(hr.getBreakfast())) + "," +
                ((edited = edited || !old.getNote().equals(hr.getNote())) && !old.getNote().equals(hr.getNote())) +
				")";
		System.out.println("edited?"+edited);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  
			
			if(edited){
				stat.execute(query);
				stat.execute(query1);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public ArrayList<HotelReservation> getAllHRs(){
		ArrayList<HotelReservation> list = new ArrayList<HotelReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `hotel reservation`";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				HotelReservation hr = new HotelReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("check in"),
						rs.getString("check out"),
						rs.getString("hotel/resort"), 
						rs.getString("guest name"),
						rs.getString("confirmation number"),
						rs.getInt("number of adult"), 
						rs.getInt("number of child"), 
						rs.getInt("number of nights"),
						rs.getString("room type"), 
						rs.getInt("number of rooms"),
						rs.getString("breakfast"),
						rs.getString("option to pay"), 
						rs.getDouble("amount to pay"),
						rs.getString("reservation date"), 
						rs.getString("reservation type"),
						rs.getString("company"),
						rs.getString("payment type"),
						rs.getString("receipt number"),
						rs.getDouble("pay in - PHP"), 
						rs.getDouble("pay in - KRW"), 
						rs.getString("pay in - date"), 
						rs.getDouble("pay out - PHP"), 
						rs.getDouble("pay out - KRW"), 
						rs.getString("pay out - date"), 
						rs.getDouble("income - PHP"), 
						rs.getDouble("income - KRW"), 
						rs.getString("note"), 
						rs.getString("status"));
				hr.setId(rs.getInt("id"));
				list.add(hr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public ArrayList<HotelReservation> getAllHRs(String startDate, String endDate,
			String columnName, String value){
		ArrayList<HotelReservation> list = new ArrayList<HotelReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `hotel reservation`";
		boolean isWithStart = false;
		boolean isWithEnd = false;
		
		if(!startDate.isEmpty() || !endDate.isEmpty() || !value.isEmpty()){
			query += "WHERE ";
			
			if(!startDate.isEmpty()){
				isWithStart = true;
				query += "`check in` >= '" + startDate + "' ";
			}
			if(!endDate.isEmpty()){
				if(isWithStart){
					query += " AND ";
				}
				isWithEnd = true;
				query += "`check in` <= '" + endDate + "' ";
			}
			
			if(!value.isEmpty()){
				if(isWithEnd){
					query += " AND ";
				}
				if(columnName.equals("id")){
					query += "`" + columnName + "` = " + Integer.parseInt(value);
				}
				else
					query += "`" + columnName + "` = '" + value + " ' ";
			}
		}
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				HotelReservation hr = new HotelReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("check in"),
						rs.getString("check out"),
						rs.getString("hotel/resort"), 
						rs.getString("guest name"),
						rs.getString("confirmation number"),
						rs.getInt("number of adult"), 
						rs.getInt("number of child"), 
						rs.getInt("number of nights"),
						rs.getString("room type"), 
						rs.getInt("number of rooms"),
						rs.getString("breakfast"),
						rs.getString("option to pay"), 
						rs.getDouble("amount to pay"),
						rs.getString("reservation date"), 
						rs.getString("reservation type"), 
						rs.getString("company"),
						rs.getString("payment type"), 
						rs.getString("receipt number"),
						rs.getDouble("pay in - PHP"), 
						rs.getDouble("pay in - KRW"), 
						rs.getString("pay in - date"), 
						rs.getDouble("pay out - PHP"), 
						rs.getDouble("pay out - KRW"), 
						rs.getString("pay out - date"), 
						rs.getDouble("income - PHP"), 
						rs.getDouble("income - KRW"), 
						rs.getString("note"), 
						rs.getString("status"));
				hr.setId(rs.getInt("id"));
				list.add(hr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public ArrayList<HRHistory> getAllHRHistory(int hrID){
		ArrayList<HRHistory> list = new ArrayList<HRHistory>();

		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `hr history` where `hr id` = " + hrID;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				HRHistory hrh = new HRHistory(
						rs.getString("name"), 
						rs.getString("date"), 
						rs.getBoolean("isCheckInEdited"),
						rs.getBoolean("isCheckOutEdited"),
						rs.getBoolean("isHotel/ResortEdited"),
						rs.getBoolean("isGuestNameEdited"),
						rs.getBoolean("isNumberOfAdultEdited"),
						rs.getBoolean("isNumberOfChildEdited"),
						rs.getBoolean("isNumberOfNightsEdited"),
						rs.getBoolean("isRoomTypeEdited"),
						rs.getBoolean("isNumberOfRoomsEdited"),
						rs.getBoolean("isOptionToPayEdited"),
						rs.getBoolean("isReservationDateEdited"),
						rs.getBoolean("isReservationTypeEdited"),
						rs.getBoolean("isCompanyEdited"),
						rs.getBoolean("isPaymentTypeEdited"),
						rs.getBoolean("isReceiptNumberEdited"),
						rs.getBoolean("isPayInPHPEdited"),
						rs.getBoolean("isPayInKRWEdited"),
						rs.getBoolean("isPayInDateEdited"),
						rs.getBoolean("isPayOutPHPEdited"),
						rs.getBoolean("isPayOutKRWEdited"),
						rs.getBoolean("isPayOutDateEdited"),
						rs.getBoolean("isIncomePHPEdited"),
						rs.getBoolean("isIncomeKRWEdited"),
						rs.getBoolean("isStatusEdited"),
						rs.getBoolean("isConfirmationNumberEdited"),
						rs.getBoolean("isBreakfastEdited"),
						rs.getBoolean("isNoteEdited"));
				list.add(hrh);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public ArrayList<String> getHotelOrResort(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `hotel/resort`";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				list.add(rs.getString("name"));
			}
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public void addHotelOrResort(String name){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `hotel/resort` WHERE name = '" + name + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO `hotel/resort` (name) VALUES ('" + name + "')";
				stat.execute(query);
			}
			
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public ArrayList<String> getReservationType(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `reservation type`";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				list.add(rs.getString("type"));
			}
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
			
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public void addReservationType(String type){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `reservation type` WHERE type = '" + type + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO `reservation type` (type) VALUES ('" + type + "')";
				stat.execute(query);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public ArrayList<String> getPaymentType(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `payment type`";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				list.add(rs.getString("type"));
			}
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		return list;
	}
	
	public void addPaymentType(String type){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `payment type` WHERE type = '" + type + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO `payment type` (type) VALUES ('" + type + "')";
				stat.execute(query);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public void addFR(FlightReservation fr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String variableQuery = "( '" 
				+ currentUser.getUsername() + "'"
				+ ",'" + DATE_TIME_FORMAT.format(new Date()) + "'"
				+ ",'" + fr.getDeparture() + "'"
				+ ",'" + fr.getOrigin() + "'"
				+ ",'" + fr.getDestination() + "'"
				+ ",'" + fr.getFlightNo() + "'"
				+ ",'" + fr.getReservationType() + "'"
				+ ",'" + fr.getPaymentType() + "'"
				+ ",'" + fr.getGuestName() + "'"
				+ ",'" + fr.getGender() + "'"
				+ "," + fr.getNumberOfAdult() + ""
				+ "," + fr.getNumberOfChild() + ""
				+ "," + fr.getPayInPHP() + ""
				+ "," + fr.getPayInKRW() + ""
				+ ",'" + fr.getPayInDate() + "'" 
				+ "," + fr.getPayOutPHP() + ""
				+ "," + fr.getPayOutKRW() + ""
				+ ",'" + fr.getPayOutDate() + "'"
				+ "," + fr.getIncomePHP() + ""
				+ "," + fr.getIncomeKRW() + ""
				+ ",'" + fr.getNote() + "')";
		
		String defaultQuery = "INSERT INTO `flight reservation`("
				+ "`created by`, `created at`, `flight date`, origin, destination,"
				+ "`flight no`, `reservation type`, `payment type`,"
				+ "`guest name`, gender, `number of adult`, `number of child`,"
				+ "`pay in - PHP`, `pay in - KRW`, `pay in - date`, `pay out - PHP`,"
				+ " `pay out - KRW`, `pay out - date`, `income - PHP`, `income - KRW`,"
				+ "note) VALUES " + variableQuery;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			stat.execute(defaultQuery);
			  
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public void updateFR(FlightReservation fr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		boolean edited = false;
        FlightReservation old = getAllFRs("", "", "id", fr.getId()+"").get(0);
        
		String query = "UPDATE `flight reservation` SET " + 
				"`flight date` = '" + fr.getDeparture() + "'," +
				"origin = '" + fr.getOrigin() + "'," + 
				"destination = '" + fr.getDestination() + "'," +
				"`flight no` = '" + fr.getFlightNo() + "'," +
				"`reservation type` = '" + fr.getReservationType() + "'," +
				"`payment type` = '" + fr.getPaymentType() + "'," +
				"`guest name` = '" + fr.getGuestName() + "'," +
				"gender = '" + fr.getGender() + "'," +
				"`number of adult` = " + fr.getNumberOfAdult() + "," +
				"`number of child` = " + fr.getNumberOfChild() + "," +
				"`pay in - PHP` = " + fr.getPayInPHP() + "," +
				"`pay in - KRW` = " + fr.getPayInKRW() + "," +
				"`pay in - date` = '" + fr.getPayInDate() + "'," +
				"`pay out - PHP` = " + fr.getPayOutPHP() + "," +
				"`pay out - KRW` = " + fr.getPayOutKRW() + "," +
				"`pay out - date` = '" + fr.getPayOutDate() + "'," +
				"`income - PHP` = " + fr.getIncomePHP() + "," +
				"`income - KRW` = " + fr.getIncomeKRW() + "," +
				"note = + '" + fr.getNote() + "' WHERE id = " + fr.getId();
		
		String query1 = "INSERT INTO `basecamp`.`fr history` " +
				"(`fr id`, `name`, `date`, `isDepartureEdited`, `isFlightNumberEdited`," +
				"`isOriginEdited`, `isDestinationEdited`, `isReservationTypeEdited`, " +
				"`isPaymentTypeEdited`, `isGuestNameEdited`, `isNumberOfAdultEdited`, " +
				"`isNumberOfChildEdited`, `isGenderEdited`, `isPayInPHPEdited`, `isPayInKRWEdited`," +
				"`isPayInDateEdited`, `isPayOutPHPEdited`, `isPayOutKRWEdited`, `isPayOutDateEdited`," +
				"`isIncomePHPEdited`, `isIncomeKRWEdited`, `isNoteEdited`) " +
				"VALUES (" +
                old.getId() + ", " +
                "'" + currentUser.getUsername() + "'," +
                "'" + DATE_TIME_FORMAT.format(new Date()) + "'," +
                ((edited = edited || !old.getDeparture().equals(fr.getDeparture())) && !old.getDeparture().equals(fr.getDeparture())) + "," +
                ((edited = edited || !old.getFlightNo().equals(fr.getFlightNo())) && !old.getFlightNo().equals(fr.getFlightNo())) + "," +
                ((edited = edited || !old.getOrigin().equals(fr.getOrigin())) && !old.getOrigin().equals(fr.getOrigin())) + "," +
                ((edited = edited || !old.getDestination().equals(fr.getDestination())) && !old.getDestination().equals(fr.getDestination())) + "," +
                ((edited = edited || !old.getReservationType().equals(fr.getReservationType())) && !old.getReservationType().equals(fr.getReservationType())) + "," +
                ((edited = edited || !old.getPaymentType().equals(fr.getPaymentType())) && !old.getPaymentType().equals(fr.getPaymentType())) + "," +
                ((edited = edited || !old.getGuestName().equals(fr.getGuestName())) && !old.getGuestName().equals(fr.getGuestName())) + "," +
                ((edited = edited || (old.getNumberOfAdult() != fr.getNumberOfAdult())) && (old.getNumberOfAdult() != fr.getNumberOfAdult()))+ "," +
                ((edited = edited || (old.getNumberOfChild() != fr.getNumberOfChild())) && (old.getNumberOfChild() != fr.getNumberOfChild()))+ "," +
                ((edited = edited || !old.getGender().equals(fr.getGender())) && !old.getGender().equals(fr.getGender())) + "," +
                ((edited = edited || (old.getPayInPHP() != fr.getPayInPHP())) && (old.getPayInPHP() != fr.getPayInPHP())) + "," +
                ((edited = edited || (old.getPayInKRW() != fr.getPayInKRW())) && (old.getPayInKRW() != fr.getPayInKRW())) + "," +
                ((edited = edited || !old.getPayInDate().equals(fr.getPayInDate())) && !old.getPayInDate().equals(fr.getPayInDate())) + "," +
                ((edited = edited || (old.getPayOutPHP() != fr.getPayOutPHP())) && (old.getPayOutPHP() != fr.getPayOutPHP())) + "," +
                ((edited = edited || (old.getPayOutKRW() != fr.getPayOutKRW())) && (old.getPayOutKRW() != fr.getPayOutKRW())) + "," +
                ((edited = edited || !old.getPayOutDate().equals(fr.getPayOutDate())) && !old.getPayOutDate().equals(fr.getPayOutDate())) + "," +
                ((edited = edited || (old.getIncomePHP() != fr.getIncomePHP())) && (old.getIncomePHP() != fr.getIncomePHP())) + "," +
                ((edited = edited || (old.getIncomeKRW() != fr.getIncomeKRW())) && (old.getIncomeKRW() != fr.getIncomeKRW())) + "," +
                ((edited = edited || !old.getNote().equals(fr.getNote())) && !old.getNote().equals(fr.getNote())) +
                ")";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  
			
			if(edited){
				stat.execute(query);
				stat.execute(query1);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public ArrayList<FlightReservation> getAllFRs(){
		ArrayList<FlightReservation> frs= new ArrayList<FlightReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `flight reservation`";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				FlightReservation fr = new FlightReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("flight date"),
						rs.getString("origin"),
						rs.getString("destination"),
						rs.getString("flight no"),
						rs.getString("reservation type"),
						rs.getString("guest name"),
						rs.getString("payment type"),
						rs.getString("gender"),
						rs.getInt("number of adult"),
						rs.getInt("number of Child"),
						rs.getDouble("pay in - PHP"),
						rs.getDouble("pay in - KRW"),
						rs.getString("pay in - date"),
						rs.getDouble("pay out - PHP"),
						rs.getDouble("pay out - KRW"),
						rs.getString("pay out - date"),
						rs.getDouble("income - PHP"),
						rs.getDouble("income - KRW"),
						rs.getString("note"));
				fr.setId(rs.getInt("id"));
				frs.add(fr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		return frs;
	}
	
	public ArrayList<FlightReservation> getAllFRs(String startDate, String endDate,
			String columnName, String value){
		ArrayList<FlightReservation> frs= new ArrayList<FlightReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `flight reservation`";
		boolean isWithStart = false;
		boolean isWithEnd = false;
		
		if(!startDate.isEmpty() || !endDate.isEmpty() || !value.isEmpty()){
			query += "WHERE ";
			
			if(!startDate.isEmpty()){
				isWithStart = true;
				query += "`flight date` >= '" + startDate + "' ";
			}
			if(!endDate.isEmpty()){
				if(isWithStart){
					query += " AND ";
				}
				isWithEnd = true;
				query += "`flight date` <= '" + endDate + "' ";
			}
			
			if(!value.isEmpty()){
				if(isWithEnd){
					query += " AND ";
				}
				if(columnName.equals("id")){
					query += "`" + columnName + "` = " + Integer.parseInt(value);
				}
				else
					query += "`" + columnName + "` = '" + value + " ' ";
			}
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				FlightReservation fr = new FlightReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("flight date"),
						rs.getString("origin"),
						rs.getString("destination"),
						rs.getString("flight no"),
						rs.getString("reservation type"),
						rs.getString("guest name"),
						rs.getString("payment type"),
						rs.getString("gender"),
						rs.getInt("number of adult"),
						rs.getInt("number of Child"),
						rs.getDouble("pay in - PHP"),
						rs.getDouble("pay in - KRW"),
						rs.getString("pay in - date"),
						rs.getDouble("pay out - PHP"),
						rs.getDouble("pay out - KRW"),
						rs.getString("pay out - date"),
						rs.getDouble("income - PHP"),
						rs.getDouble("income - KRW"),
						rs.getString("note"));
				fr.setId(rs.getInt("id"));
				frs.add(fr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		return frs;
	}

	public ArrayList<FRHistory> getAllFRHistory(int frID){
		ArrayList<FRHistory> list = new ArrayList<FRHistory>();

		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `fr history` where `fr id` = " + frID;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				FRHistory frh = new FRHistory(
						rs.getString("name"), 
						rs.getString("date"), 
						rs.getBoolean("isDepartureEdited"),
						rs.getBoolean("isFlightNumberEdited"),
						rs.getBoolean("isOriginEdited"),
						rs.getBoolean("isDestinationEdited"),
						rs.getBoolean("isReservationTypeEdited"),
						rs.getBoolean("isPaymentTypeEdited"),
						rs.getBoolean("isGuestNameEdited"),
						rs.getBoolean("isNumberOfAdultEdited"),
						rs.getBoolean("isNumberOfChildEdited"),
						rs.getBoolean("isGenderEdited"),
						rs.getBoolean("isPayInPHPEdited"),
						rs.getBoolean("isPayInKRWEdited"),
						rs.getBoolean("isPayInDateEdited"),
						rs.getBoolean("isPayOutPHPEdited"),
						rs.getBoolean("isPayOutKRWEdited"),
						rs.getBoolean("isPayOutDateEdited"),
						rs.getBoolean("isIncomePHPEdited"),
						rs.getBoolean("isIncomeKRWEdited"),
						rs.getBoolean("isNoteEdited"));
				list.add(frh);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public ArrayList<String> getFlightNo(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		String name;
		
		String query = "select name from flight";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			  
			while(rs.next()){
				name = rs.getString("name");
				list.add(name);
			}
			  
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public void addFlight(String name){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from flight WHERE name = '" + name + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO flight (name) VALUES ('" + name + "')";
				stat.execute(query);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public ArrayList<String> getCity(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		String name;
		
		String query = "select name from city";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			  
			while(rs.next()){
				name = rs.getString("name");
				list.add(name);
			}
			  
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public void addCity(String name){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from city WHERE name = '" + name + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO city (name) VALUES ('" + name + "')";
				stat.execute(query);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	public void addPR(PackageReservation pr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String variableQuery = "( '" 
				+ currentUser.getUsername() + "'"
				+ ",'" + DATE_TIME_FORMAT.format(new Date()) + "'"
				+ ",'" + pr.getDate() + "'"
				+ ",'" + pr.getTime() + "'"
				+ ",'" + pr.getType() + "'"
				+ ",'" + pr.getCar() + "'"
				+ ",'" + pr.getReservationType() + "'"
				+ ",'" + pr.getPaymentType() + "'"
				+ ",'" + pr.getGuestName() + "'"
				+ "," + pr.getNumberOfAdult() + ""
				+ "," + pr.getNumberOfChild() + ""
				+ "," + pr.getPayInPHP() + ""
				+ "," + pr.getPayInKRW() + ""
				+ ",'" + pr.getPayInDate() + "'"
				+ "," + pr.getPayOutPHP() + ""
				+ "," + pr.getPayOutKRW() + ""
				+ ",'" + pr.getPayOutDate() + "'"
				+ "," + pr.getIncomePHP() + ""
				+ "," + pr.getIncomeKRW() + ""
				+ ",'" + pr.getNote() + "')";
		
		String defaultQuery = "INSERT INTO `package reservation`("
				+ "`created by`, `created at`, date, time, type, car,"
				+ "`reservation type`, `payment type`, `guest name`,"
				+ "`number of adult`, `number of child`,"
				+ "`pay in - PHP`, `pay in - KRW`, `pay in - date`, `pay out - PHP`,"
				+ "`pay out - KRW`, `pay out - date`, `income - PHP`, `income - KRW`,"
				+ "note) VALUES " + variableQuery;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			stat.execute(defaultQuery);
			  
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public void updatePR(PackageReservation pr){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		boolean edited = false;
        PackageReservation old = getAllPRs("", "", "id", pr.getId()+"").get(0);
        
		String query = "UPDATE `package reservation` SET " + 
				"date = '" + pr.getDate() + "'," +
				"time = '" + pr.getTime() + "'," +
				"type = '" + pr.getType() + "'," +
				"car = '" + pr.getCar() + "'," +
				"`reservation type` = '" + pr.getReservationType() + "'," +
				"`payment type` = '" + pr.getPaymentType() + "'," +
				"`guest name` = '" + pr.getGuestName() + "'," +
				"`number of adult` = " + pr.getNumberOfAdult() + "," +
				"`number of child` = " + pr.getNumberOfChild() + "," +
				"`pay in - PHP` = " + pr.getPayInPHP() + "," +
				"`pay in - KRW` = " + pr.getPayInKRW() + "," +
				"`pay in - date` = '" + pr.getPayInDate() + "'," +
				"`pay out - PHP` = " + pr.getPayOutPHP() + "," +
				"`pay out - KRW` = " + pr.getPayOutKRW() + "," +
				"`pay out - date` = '" + pr.getPayOutDate() + "'," +
				"`income - PHP` = " + pr.getIncomePHP() + "," +
				"`income - KRW` = " + pr.getIncomeKRW() + "," +
				"note = '" + pr.getNote() + "' " +
				"WHERE id = " + pr.getId();
		
		String query1 = "INSERT INTO `basecamp`.`pr history` " +
				"(`pr id`, `name`, `date`, `isDateEdited`, `isTimeEdited`," +
				"`isTypeEdited`, `isCarEdited`, `isPaymentTypeEdited`, " +
				"`isGuestNameEdited`, `isNumberOfAdultEdited`,  `isNumberOfChildEdited`," +
				"`isReservationTypeEdited`, `isPayInPHPEdited`, `isPayInKRWEdited`," +
				"`isPayInDateEdited`, `isPayOutPHPEdited`, `isPayOutKRWEdited`, " +
				"`isPayOutDateEdited`, `isIncomePHPEdited`, `isIncomeKRWEdited`, " +
				"`isNoteEdited`) " +
				"VALUES (" +
                old.getId() + ", " +
                "'" + currentUser.getUsername() + "'," +
                "'" + DATE_TIME_FORMAT.format(new Date()) + "'," +
                ((edited = edited || !old.getDate().equals(pr.getDate())) && !old.getDate().equals(pr.getDate())) + "," +
                ((edited = edited || !old.getTime().equals(pr.getTime())) && !old.getTime().equals(pr.getTime())) + "," +
                ((edited = edited || !old.getType().equals(pr.getType())) && !old.getType().equals(pr.getType())) + "," +
                ((edited = edited || !old.getCar().equals(pr.getCar())) && !old.getCar().equals(pr.getCar())) + "," +
                ((edited = edited || !old.getPaymentType().equals(pr.getPaymentType())) && !old.getPaymentType().equals(pr.getPaymentType())) + "," +
                ((edited = edited || !old.getGuestName().equals(pr.getGuestName())) && !old.getGuestName().equals(pr.getGuestName())) + "," +
                ((edited = edited || (old.getNumberOfAdult() != pr.getNumberOfAdult())) && (old.getNumberOfAdult() != pr.getNumberOfAdult()))+ "," +
                ((edited = edited || (old.getNumberOfChild() != pr.getNumberOfChild())) && (old.getNumberOfChild() != pr.getNumberOfChild()))+ "," +
                ((edited = edited || !old.getReservationType().equals(pr.getReservationType())) && !old.getReservationType().equals(pr.getReservationType())) + "," +
                ((edited = edited || (old.getPayInPHP() != pr.getPayInPHP())) && (old.getPayInPHP() != pr.getPayInPHP())) + "," +
                ((edited = edited || (old.getPayInKRW() != pr.getPayInKRW())) && (old.getPayInKRW() != pr.getPayInKRW())) + "," +
                ((edited = edited || !old.getPayInDate().equals(pr.getPayInDate())) && !old.getPayInDate().equals(pr.getPayInDate())) + "," +
                ((edited = edited || (old.getPayOutPHP() != pr.getPayOutPHP())) && (old.getPayOutPHP() != pr.getPayOutPHP())) + "," +
                ((edited = edited || (old.getPayOutKRW() != pr.getPayOutKRW())) && (old.getPayOutKRW() != pr.getPayOutKRW())) + "," +
                ((edited = edited || !old.getPayOutDate().equals(pr.getPayOutDate())) && !old.getPayOutDate().equals(pr.getPayOutDate())) + "," +
                ((edited = edited || (old.getIncomePHP() != pr.getIncomePHP())) && (old.getIncomePHP() != pr.getIncomePHP())) + "," +
                ((edited = edited || (old.getIncomeKRW() != pr.getIncomeKRW())) && (old.getIncomeKRW() != pr.getIncomeKRW())) + "," +
                ((edited = edited || !old.getNote().equals(pr.getNote())) && !old.getNote().equals(pr.getNote())) +
                ")";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  
			
			if(edited){
				stat.execute(query);
				stat.execute(query1);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	public ArrayList<PackageReservation> getAllPRs(){
		ArrayList<PackageReservation> prs= new ArrayList<PackageReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `package reservation`";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				PackageReservation pr = new PackageReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("date"),
						rs.getString("time"),
						rs.getString("type"),
						rs.getString("car"),
						rs.getString("payment type"),
						rs.getString("guest name"),
						rs.getInt("number of adult"),
						rs.getInt("number of child"),
						rs.getString("reservation type"),
						rs.getDouble("pay in - PHP"),
						rs.getDouble("pay in - KRW"),
						rs.getString("pay in - date"),
						rs.getDouble("pay out - PHP"),
						rs.getDouble("pay out - KRW"),
						rs.getString("pay out - date"),
						rs.getDouble("income - PHP"),
						rs.getDouble("income - KRW"),
						rs.getString("note"));
				pr.setId(rs.getInt("id"));
				prs.add(pr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		return prs;
	}
	
	public ArrayList<PackageReservation> getAllPRs(String startDate, String endDate,
			String columnName, String value){
		ArrayList<PackageReservation> prs= new ArrayList<PackageReservation>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `package reservation`";
		boolean isWithStart = false;
		boolean isWithEnd = false;
		
		if(!startDate.isEmpty() || !endDate.isEmpty() || !value.isEmpty()){
			query += "WHERE ";
			
			if(!startDate.isEmpty()){
				isWithStart = true;
				query += "`date` >= '" + startDate + "' ";
			}
			if(!endDate.isEmpty()){
				if(isWithStart){
					query += " AND ";
				}
				isWithEnd = true;
				query += "`date` <= '" + endDate + "' ";
			}
			
			if(!value.isEmpty()){
				if(isWithEnd){
					query += " AND ";
				}
				if(columnName.equals("id")){
					query += "`" + columnName + "` = " + Integer.parseInt(value);
				}
				else
					query += "`" + columnName + "` = '" + value + " ' ";
			}
		}
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				PackageReservation pr = new PackageReservation(
						rs.getString("created by"),
						rs.getString("created at"),
						rs.getString("date"),
						rs.getString("time"),
						rs.getString("type"),
						rs.getString("car"),
						rs.getString("payment type"),
						rs.getString("guest name"),
						rs.getInt("number of adult"),
						rs.getInt("number of child"),
						rs.getString("reservation type"),
						rs.getDouble("pay in - PHP"),
						rs.getDouble("pay in - KRW"),
						rs.getString("pay in - date"),
						rs.getDouble("pay out - PHP"),
						rs.getDouble("pay out - KRW"),
						rs.getString("pay out - date"),
						rs.getDouble("income - PHP"),
						rs.getDouble("income - KRW"),
						rs.getString("note"));
				pr.setId(rs.getInt("id"));
				prs.add(pr);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		return prs;
	}
	
	public ArrayList<PRHistory> getAllPRHistory(int prID){
		ArrayList<PRHistory> list = new ArrayList<PRHistory>();

		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from `pr history` where `pr id` = " + prID;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()){
				PRHistory prh = new PRHistory(
						rs.getString("name"), 
						rs.getString("date"), 
						rs.getBoolean("isDateEdited"),
						rs.getBoolean("isTimeEdited"),
						rs.getBoolean("isTypeEdited"),
						rs.getBoolean("isCarEdited"),
						rs.getBoolean("isPaymentTypeEdited"),
						rs.getBoolean("isGuestNameEdited"),
						rs.getBoolean("isNumberOfAdultEdited"),
						rs.getBoolean("isNumberOfChildEdited"),
						rs.getBoolean("isReservationTypeEdited"),
						rs.getBoolean("isPayInPHPEdited"),
						rs.getBoolean("isPayInKRWEdited"),
						rs.getBoolean("isPayInDateEdited"),
						rs.getBoolean("isPayOutPHPEdited"),
						rs.getBoolean("isPayOutKRWEdited"),
						rs.getBoolean("isPayOutDateEdited"),
						rs.getBoolean("isIncomePHPEdited"),
						rs.getBoolean("isIncomeKRWEdited"),
						rs.getBoolean("isNoteEdited"));
				list.add(prh);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public ArrayList<String> getCar(){
		ArrayList<String> list = new ArrayList<String>();
		
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		String name;
		
		String query = "select name from car";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			  
			while(rs.next()){
				name = rs.getString("name");
				list.add(name);
			}
			  
			connect.close();
			
			list.sort(new Comparator<String>() {
				public int compare(String a, String b) {
					return a.compareTo(b);
				}
			});
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
		
		return list;
	}
	
	public void addCar(String name){
		String connection = "jdbc:mysql://" + ip + "/basecamp";
		Connection connect;
		Statement stat;
		
		String query = "select * from car WHERE name = '" + name + "'";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(connection, dbUser, dbPass);
			stat = connect.createStatement();  

			ResultSet rs = stat.executeQuery(query);
			
			if(!rs.next()){
				query = "INSERT INTO car (name) VALUES ('" + name + "')";
				stat.execute(query);
			}
			connect.close();
		}catch(SQLException e){
			e.printStackTrace();
			printError(e.getErrorCode());
		}catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
			printError(-1);
		}
	}
	
	public int exportHRVoucher(HotelReservation hr){
		File file = null;
		
		try {
			
			JFrame parentFrame = new JFrame();
			 
			String userDir = System.getProperty("user.home");
			JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
			fileChooser.setDialogTitle("Export voucher to");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
			fileChooser.setFileFilter(filter);
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fileChooser.getSelectedFile();
			    
			    if(file.exists()){
			    	int existing = JOptionPane.showConfirmDialog(null,"The file exists, overwrite?",
			    				"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
			    	if(existing == JOptionPane.NO_OPTION || existing == JOptionPane.CANCEL_OPTION){
		            	return 2;
		            }
			    	else if(existing == JOptionPane.YES_OPTION){
			    		if(!file.getAbsolutePath().contains(".pdf"))
			    			throw new Exception();
			    	}
		            file = new File(file.getAbsolutePath());
			    }
			    else
			    {
			    	if(!file.getAbsolutePath().contains(".pdf"))
			    		file = new File(file.getAbsolutePath()+".pdf");
			    }
				FileOutputStream pdfFileout = new FileOutputStream(file);
				Document doc = new Document();
				PdfPCell firstColumn;
				PdfPCell secondColumn;
				
				PdfWriter.getInstance(doc, pdfFileout);

				doc.addAuthor("Base Camp Tour");
				doc.addTitle("Hotel Reservation Voucher");
				doc.open();

				PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);
		        //cell.setColspan(2);
	            
				Image logo = Image.getInstance(this.getClass().getResource("/Pictures/logo.jpg"));
				logo.scalePercent(70f);
		        doc.add(logo);
				
		        Font headingFont = new Font(Font.FontFamily.COURIER, 32,
	                    Font.BOLD);
		        Paragraph heading = new Paragraph("VOUCHER",headingFont);
		        heading.setAlignment(Paragraph.ALIGN_CENTER);
		        doc.add(heading);
		        
		        doc.add(new Paragraph(" "));
		        
		        //This is printing data
	            firstColumn = new PdfPCell(new Paragraph("HOTEL"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getHotelOrResort()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CHECK-IN/OUT"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getCheckIn() + "\n" +
	            										  hr.getCheckOut()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("GUEST NAME"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getGuestName()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ROOM TYPE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getRoomType()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF NIGHTS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfNights() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF ROOMS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfRooms() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BREAKFAST"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getBreakfast()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF PAX"));
	            secondColumn = new PdfPCell(new Paragraph("ADT: " + hr.getNumberOfAdult() +
	            										  "     " +
	            										  "CHD: " + hr.getNumberOfChild()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CONFIRMATION NO."));
	            secondColumn = new PdfPCell(new Paragraph(hr.getConfirmationNumber()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ISSUED BY"));
	            secondColumn = new PdfPCell(new Paragraph(getCurrentUser().getUsername()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("REMARKS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNote() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("PLEASE PRESENT THIS VOUCHER UPON CHECK-IN"
	            							+ "\n"));
	            firstColumn.setColspan(2);
	            table.addCell(firstColumn);
	            
	            float[] width = new float[] {30f,70f};
	            table.setWidths(width);
	            
		        doc.add(table);
		        
		        doc.add(new Phrase(" "));
		        
		        Image guideline = Image.getInstance(this.getClass().getResource("/Pictures/guideline.jpg"));
				guideline.scalePercent(62f, 42f);
		        doc.add(guideline);
		        
		        Image footer = Image.getInstance(this.getClass().getResource("/Pictures/footer.png"));
				footer.scalePercent(70f, 38f);
		        doc.add(footer);
		        
				doc.close();
				pdfFileout.close();
				return 1;
			}else if(userSelection == JFileChooser.CANCEL_OPTION){
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		return 1;
	}
	
	public int exportHRVoucherWeb(HotelReservation hr){
		File file = null;
		
		try {
			
			JFrame parentFrame = new JFrame();
			 
			String userDir = System.getProperty("user.home");
			JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
			fileChooser.setDialogTitle("Export voucher to");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
			fileChooser.setFileFilter(filter);
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fileChooser.getSelectedFile();
			    
			    if(file.exists()){
			    	int existing = JOptionPane.showConfirmDialog(null,"The file exists, overwrite?",
			    				"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
			    	if(existing == JOptionPane.NO_OPTION || existing == JOptionPane.CANCEL_OPTION){
		            	return 2;
		            }
			    	else if(existing == JOptionPane.YES_OPTION){
			    		if(!file.getAbsolutePath().contains(".pdf"))
			    			throw new Exception();
			    	}
		            file = new File(file.getAbsolutePath());
			    }
			    else
			    {
			    	if(!file.getAbsolutePath().contains(".pdf"))
			    		file = new File(file.getAbsolutePath()+".pdf");
			    }
				FileOutputStream pdfFileout = new FileOutputStream(file);
				Document doc = new Document();
				PdfPCell firstColumn;
				PdfPCell secondColumn;
				
				PdfWriter.getInstance(doc, pdfFileout);

				doc.addAuthor("BASECAMP TOUR");
				doc.addTitle("HOTEL RESERVATION VOUCHER");
				doc.open();

				PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);
		        //cell.setColspan(2);
	            
				Image logo = Image.getInstance(this.getClass().getResource("/Pictures/logo.jpg"));
				logo.scalePercent(70f);
		        doc.add(logo);
				
		        Font headingFont = new Font(Font.FontFamily.COURIER, 32,
	                    Font.BOLD);
		        Paragraph heading = new Paragraph("VOUCHER",headingFont);
		        heading.setAlignment(Paragraph.ALIGN_CENTER);
		        doc.add(heading);
		        
		        doc.add(new Paragraph(" "));
		        
		        //This is printing data
	            firstColumn = new PdfPCell(new Paragraph("HOTEL"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getHotelOrResort()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CHECK-IN/OUT"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getCheckIn() + "\n" +
	            										  hr.getCheckOut()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("GUEST NAME"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getGuestName()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ROOM TYPE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getRoomType()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF NIGHTS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfNights() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF ROOMS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfRooms() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BREAKFAST"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getBreakfast()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO. OF PAX"));
	            secondColumn = new PdfPCell(new Paragraph("ADT: " + hr.getNumberOfAdult() +
	            										  "     " +
	            										  "CHD: " + hr.getNumberOfChild()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CONFIRMATION NO."));
	            secondColumn = new PdfPCell(new Paragraph(hr.getConfirmationNumber()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ISSUED BY"));
	            secondColumn = new PdfPCell(new Paragraph(getCurrentUser().getUsername()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("REMARKS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNote() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("PLEASE PRESENT THIS VOUCHER UPON CHECK-IN"
	            							+ "\n"));
	            firstColumn.setColspan(2);
	            table.addCell(firstColumn);
	            
	            float[] width = new float[] {30f,70f};
	            table.setWidths(width);
	            
		        doc.add(table);
		        
		        doc.add(new Phrase(" "));
		        
		        Image guideline = Image.getInstance(this.getClass().getResource("/Pictures/guidelineWeb.png"));
				guideline.scalePercent(62f, 45f);
		        doc.add(guideline);
		        
		        Image footer = Image.getInstance(this.getClass().getResource("/Pictures/footer.png"));
				footer.scalePercent(70f, 38f);
		        doc.add(footer);
		        
				doc.close();
				pdfFileout.close();
				return 1;
			}else if(userSelection == JFileChooser.CANCEL_OPTION){
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		return 1;
	}
	
	public int exportHRBookingOrder(HotelReservation hr){
		File file = null;
		
		try {
			
			JFrame parentFrame = new JFrame();

			String userDir = System.getProperty("user.home");
			JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
			
			fileChooser.setDialogTitle("Export booking order to");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
			fileChooser.setFileFilter(filter);
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fileChooser.getSelectedFile();
			    
			    if(file.exists()){
			    	int existing = JOptionPane.showConfirmDialog(null,"The file exists, overwrite?",
			    				"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
			    	if(existing == JOptionPane.NO_OPTION || existing == JOptionPane.CANCEL_OPTION){
		            	return 2;
		            }
			    	else if(existing == JOptionPane.YES_OPTION){
			    		if(!file.getAbsolutePath().contains(".pdf"))
			    			throw new Exception();
			    	}
		            file = new File(file.getAbsolutePath());
			    }
			    else
			    {
			    	if(!file.getAbsolutePath().contains(".pdf"))
			    		file = new File(file.getAbsolutePath()+".pdf");
			    }
				FileOutputStream pdfFileout = new FileOutputStream(file);
				Document doc = new Document();
				PdfPCell firstColumn;
				PdfPCell secondColumn;
				
				PdfWriter.getInstance(doc, pdfFileout);

				doc.addAuthor("BASECAMP TOUR");
				doc.addTitle("HOTEL RESERVATION VOUCHER");
				doc.open();

				PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);
		        //cell.setColspan(2);
	            
				Image logo = Image.getInstance(this.getClass().getResource("/Pictures/logo.jpg"));
				logo.scalePercent(70f);
		        doc.add(logo);
				
		        Font headingFont = new Font(Font.FontFamily.COURIER, 32,
	                    Font.BOLD);
		        Paragraph heading = new Paragraph("BOOKING ORDER",headingFont);
		        heading.setAlignment(Paragraph.ALIGN_CENTER);
		        doc.add(heading);
		        
		        doc.add(new Paragraph(" "));
		        
		        //This is printing data
	            firstColumn = new PdfPCell(new Paragraph("HOTEL"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getHotelOrResort()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BOOKING DATE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getReservationDate()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CHECK-IN/OUT"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getCheckIn() + "\n" +
	            										  hr.getCheckOut()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("GUEST NAME"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getGuestName()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ROOM TYPE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getRoomType()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF NIGHTS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfNights() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF ROOMS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfRooms() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BREAKFAST"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getBreakfast()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF PAX"));
	            secondColumn = new PdfPCell(new Paragraph("ADT: " + hr.getNumberOfAdult() +
	            										  "     " +
	            										  "CHD: " + hr.getNumberOfChild()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CONFIRMATION NO"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getConfirmationNumber()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ISSUED BY"));
	            secondColumn = new PdfPCell(new Paragraph(getCurrentUser().getUsername()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("REMARKS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNote() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            float[] width = new float[] {30f,70f};
	            table.setWidths(width);
	            
		        doc.add(table);
		        
		        doc.add(new Phrase(" "));
		        
				doc.close();
				pdfFileout.close();
				return 1;
			}else if(userSelection == JFileChooser.CANCEL_OPTION){
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		return 1;
	}
	
	public int exportHRInvoice(HotelReservation hr){
		File file = null;
		
		try {
			
			JFrame parentFrame = new JFrame();
			
			String userDir = System.getProperty("user.home");
			JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
			
			fileChooser.setDialogTitle("Export invoice to");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
			fileChooser.setFileFilter(filter);
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fileChooser.getSelectedFile();
			    
			    if(file.exists()){
			    	int existing = JOptionPane.showConfirmDialog(null,"The file exists, overwrite?",
			    				"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
			    	if(existing == JOptionPane.NO_OPTION || existing == JOptionPane.CANCEL_OPTION){
		            	return 2;
		            }
			    	else if(existing == JOptionPane.YES_OPTION){
			    		if(!file.getAbsolutePath().contains(".pdf"))
			    			throw new Exception();
			    	}
		            file = new File(file.getAbsolutePath());
			    }
			    else
			    {
			    	if(!file.getAbsolutePath().contains(".pdf"))
			    		file = new File(file.getAbsolutePath()+".pdf");
			    }
				FileOutputStream pdfFileout = new FileOutputStream(file);
				Document doc = new Document();
				PdfPCell firstColumn;
				PdfPCell secondColumn;
				
				PdfWriter.getInstance(doc, pdfFileout);

				doc.addAuthor("BASE CAMP TOUR");
				doc.addTitle("HOTEL RESERVATION VOUCHER");
				doc.open();

				PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);
		        //cell.setColspan(2);
	            
				Image logo = Image.getInstance(this.getClass().getResource("/Pictures/logo.jpg"));
				logo.scalePercent(70f);
		        doc.add(logo);
				
		        Font headingFont = new Font(Font.FontFamily.COURIER, 32,
	                    Font.BOLD);
		        Paragraph heading = new Paragraph("INVOICE",headingFont);
		        heading.setAlignment(Paragraph.ALIGN_CENTER);
		        doc.add(heading);
		        
		        doc.add(new Paragraph(" "));
		        
		        firstColumn = new PdfPCell(new Paragraph("Company"));
		        secondColumn = new PdfPCell(new Paragraph(hr.getCompany()));
		        table.addCell(firstColumn);
		        table.addCell(secondColumn);
		        
		        //This is printing data
	            firstColumn = new PdfPCell(new Paragraph("HOTEL"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getHotelOrResort()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BOOKING DATE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getReservationDate()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CHECK-IN/OUT"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getCheckIn() + "\n" +
	            										  hr.getCheckOut()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("GUEST NAME"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getGuestName()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ROOM TYPE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getRoomType()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF NIGHTS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfNights() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF ROOMS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfRooms() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BREAKFAST"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getBreakfast()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF PAX"));
	            secondColumn = new PdfPCell(new Paragraph("ADT: " + hr.getNumberOfAdult() +
	            										  "     " +
	            										  "CHD: " + hr.getNumberOfChild()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CONFIRMATION NO"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getConfirmationNumber()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ISSUED BY"));
	            secondColumn = new PdfPCell(new Paragraph(getCurrentUser().getUsername()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("OPTION TO PAY"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getOptionToPay()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("REMARKS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNote() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            float[] width = new float[] {30f,70f};
	            table.setWidths(width);
	            
		        doc.add(table);
		        
		        Font normalFont = new Font(FontFamily.HELVETICA, 14, Font.NORMAL);
		        Font boldFont = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
		        
		        Chunk normal = new Chunk("BDO ACCOUNT: # ", normalFont);
          		Chunk bold = new Chunk("003530216725\n", boldFont);
          		doc.add(normal);
          		doc.add(bold);
		        
          		normal = new Chunk("BPI ACCOUNT: # ", normalFont);
          		bold = new Chunk("1603100243\n", boldFont);
          		doc.add(normal);
          		doc.add(bold);
          		
          		normal = new Chunk("ACCOUNT NAME: ", normalFont);
          		bold = new Chunk("BASECAMP INTERNATIOONAL TOUR INC.", boldFont);
          		doc.add(normal);
          		doc.add(bold);
		        
		        doc.add(new Phrase(" "));
		        
				doc.close();
				pdfFileout.close();
				return 1;
			}else if(userSelection == JFileChooser.CANCEL_OPTION){
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		return 1;
	}
	
	public int exportHRInvoiceWeb(HotelReservation hr){
		File file = null;
		
		try {
			
			JFrame parentFrame = new JFrame();
			
			String userDir = System.getProperty("user.home");
			JFileChooser fileChooser = new JFileChooser(userDir +"/Desktop");
			
			fileChooser.setDialogTitle("Export invoice to");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
			fileChooser.setFileFilter(filter);
			
			int userSelection = fileChooser.showSaveDialog(parentFrame);
			
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    file = fileChooser.getSelectedFile();
			    
			    if(file.exists()){
			    	int existing = JOptionPane.showConfirmDialog(null,"The file exists, overwrite?",
			    				"Existing file",JOptionPane.YES_NO_CANCEL_OPTION);
			    	if(existing == JOptionPane.NO_OPTION || existing == JOptionPane.CANCEL_OPTION){
		            	return 2;
		            }
			    	else if(existing == JOptionPane.YES_OPTION){
			    		if(!file.getAbsolutePath().contains(".pdf"))
			    			throw new Exception();
			    	}
		            file = new File(file.getAbsolutePath());
			    }
			    else
			    {
			    	if(!file.getAbsolutePath().contains(".pdf"))
			    		file = new File(file.getAbsolutePath()+".pdf");
			    }
				FileOutputStream pdfFileout = new FileOutputStream(file);
				Document doc = new Document();
				PdfPCell firstColumn;
				PdfPCell secondColumn;
				
				PdfWriter.getInstance(doc, pdfFileout);

				doc.addAuthor("BASECAMP TOUR");
				doc.addTitle("HOTEL RESERVATION VOUCHER");
				doc.open();

				PdfPTable table = new PdfPTable(2);
	            table.setWidthPercentage(100);
		        //cell.setColspan(2);
	            
				Image logo = Image.getInstance(this.getClass().getResource("/Pictures/logo.jpg"));
				logo.scalePercent(70f);
		        doc.add(logo);
				
		        Font headingFont = new Font(Font.FontFamily.COURIER, 32,
	                    Font.BOLD);
		        Paragraph heading = new Paragraph("INVOICE",headingFont);
		        heading.setAlignment(Paragraph.ALIGN_CENTER);
		        doc.add(heading);
		        
		        doc.add(new Paragraph(" "));
		        
		        firstColumn = new PdfPCell(new Paragraph("Company"));
		        secondColumn = new PdfPCell(new Paragraph(hr.getCompany()));
		        table.addCell(firstColumn);
		        table.addCell(secondColumn);
		        
		        //This is printing data
	            firstColumn = new PdfPCell(new Paragraph("HOTEL"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getHotelOrResort()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BOOKING DATE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getReservationDate()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CHECK-IN/OUT"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getCheckIn() + "\n" +
	            										  hr.getCheckOut()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("GUEST NAME"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getGuestName()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ROOM TYPE"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getRoomType()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF NIGHTS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfNights() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF ROOMS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNumberOfRooms() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("BREAKFAST"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getBreakfast()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("NO OF PAX"));
	            secondColumn = new PdfPCell(new Paragraph("ADT: " + hr.getNumberOfAdult() +
	            										  "     " +
	            										  "CHD: " + hr.getNumberOfChild()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("CONFIRMATION NO"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getConfirmationNumber()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("ISSUED BY"));
	            secondColumn = new PdfPCell(new Paragraph(getCurrentUser().getUsername()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("OPTION TO PAY"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getOptionToPay()));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            firstColumn = new PdfPCell(new Paragraph("REMARKS"));
	            secondColumn = new PdfPCell(new Paragraph(hr.getNote() + ""));
	            table.addCell(firstColumn);
	            table.addCell(secondColumn);
	            
	            float[] width = new float[] {30f,70f};
	            table.setWidths(width);
	            
		        doc.add(table);
		        
		        Font normalFont = new Font(FontFamily.HELVETICA, 14, Font.NORMAL);
		        Font boldFont = new Font(FontFamily.HELVETICA, 14, Font.BOLD);
		        
		        Chunk normal = new Chunk("KEB(Korean Exchange Bank): #", normalFont);
          		Chunk bold = new Chunk("253-18-34174-8\n", boldFont);
          		doc.add(normal);
          		doc.add(bold);
          		
          		normal = new Chunk("ACCOUNT NAME: ", normalFont);
          		bold = new Chunk("BASECAMP INTERNATIOONAL TOUR INC.\n", boldFont);
          		doc.add(normal);
          		doc.add(bold);
		        
		        Image guideline = Image.getInstance(this.getClass().getResource("/Pictures/invoiceGuidelineWeb.png"));
				guideline.scalePercent(46.7f, 38f);
		        doc.add(guideline);
		        
		        Image footer = Image.getInstance(this.getClass().getResource("/Pictures/footer.png"));
				footer.scalePercent(70f, 38f);
		        doc.add(footer);
		        
		        doc.add(new Phrase(" "));
		        
				doc.close();
				pdfFileout.close();
				return 1;
			}else if(userSelection == JFileChooser.CANCEL_OPTION){
				return 2;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
		return 1;
	}
	
	public boolean saveServerData(String ip, String username, String password){
		
		File file = null;
		FileWriter fw;
		BufferedWriter bw;
		
		try
		{
			file = new File("serverData.txt");
			    
			    if(!file.exists()){
			    	file.createNewFile();
			    }
				
			    fw = new FileWriter(file.getAbsolutePath());
			    bw = new BufferedWriter(fw);
			    
			    bw.write(ip);
			    bw.newLine();
			    bw.write(username);
			    bw.newLine();
			    bw.write(password);
			    bw.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		this.ip = ip;
		this.dbUser = username;
		this.dbPass = password;
		
		return true;
	}
	
public void loadServerData(){
		
		File file = null;
		FileReader fr;
		BufferedReader br;

		try
		{
			file = new File("serverData.txt");
			    
			    if(file.exists()){
			    	fr = new FileReader(file);
				    br = new BufferedReader(fr);
				    
				    ip = br.readLine();
				    if(ip.length() < 15){
				    	ip = "000.000.000.000";
				    }
				    dbUser = br.readLine();
				    dbPass = br.readLine();
				    
				    br.close();
			    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void printError(int code){
		if(code == 0){
			JOptionPane.showMessageDialog(null,
					"No server found at ip address: \"" + ip + "\".",
					"Connection Error", JOptionPane.ERROR_MESSAGE);
		}else if(code == 1045){
			JOptionPane.showMessageDialog(null,
					"Can't connect to server with username: \""+dbUser+
					"\" , password: \""+dbPass + "\".",
					"Connection Error", JOptionPane.ERROR_MESSAGE);
		}else if(code == 1049){
			JOptionPane.showMessageDialog(null,
					"No database found in server.",
					"Connection Error", JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,
					"Something went wrong in database, please contact the developers.",
					"Connection Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
