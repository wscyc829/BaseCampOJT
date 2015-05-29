package hotel_reservation;

public class HotelReservation {
	private int id;
	private String createdBy;
	private String createdAt;
	private String checkIn;
	private String checkOut;
	private String hotelOrResort;
	
	private String guestName;
	private int numberOfAdult;
	private int numberOfChild;
	
	private String roomType;
	private int numberOfRooms;
	private int numberOfNights;

	private String breakfast;
	private String confirmationNumber;
	private String company;
	private String status;
	
	private String reservationType;
	private String reservationDate;
	private String optionToPay;
	private double amountToPay;
	private String optionToFinal;
	private double totalPayment;
	private String paymentType;
	private String receiptNumber;
	private double payInPHP;
	private double payInKRW;
	private String payInDate;
	private double payOutPHP;
	private double payOutKRW;
	private String payOutDate;
	private double incomePHP;
	private double incomeKRW;
	
	private String note;
	private String remark;
	
	public HotelReservation(){
		this.id = -1;
	}

	public HotelReservation(String createdBy, String createdAt, String checkIn,
			String checkOut, String hotelOrResort, String guestName,
			int numberOfAdult, int numberOfChild, String roomType,
			int numberOfRooms, int numberOfNights, String breakfast,
			String confirmationNumber, String company, String status,
			String reservationType, String reservationDate, String optionToPay,
			double amountToPay, String optionToFinal, double totalPayment,
			String paymentType, String receiptNumber, double payInPHP,
			double payInKRW, String payInDate, double payOutPHP,
			double payOutKRW, String payOutDate, double incomePHP,
			double incomeKRW, String note, String remark) {
		this.id = -1;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.hotelOrResort = hotelOrResort;
		this.guestName = guestName;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChild = numberOfChild;
		this.roomType = roomType;
		this.numberOfRooms = numberOfRooms;
		this.numberOfNights = numberOfNights;
		this.breakfast = breakfast;
		this.confirmationNumber = confirmationNumber;
		this.company = company;
		this.status = status;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.optionToPay = optionToPay;
		this.amountToPay = amountToPay;
		this.optionToFinal = optionToFinal;
		this.totalPayment = totalPayment;
		this.paymentType = paymentType;
		this.receiptNumber = receiptNumber;
		this.payInPHP = payInPHP;
		this.payInKRW = payInKRW;
		this.payInDate = payInDate;
		this.payOutPHP = payOutPHP;
		this.payOutKRW = payOutKRW;
		this.payOutDate = payOutDate;
		this.incomePHP = incomePHP;
		this.incomeKRW = incomeKRW;
		this.note = note;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getHotelOrResort() {
		return hotelOrResort;
	}

	public void setHotelOrResort(String hotelOrResort) {
		this.hotelOrResort = hotelOrResort;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public int getNumberOfAdult() {
		return numberOfAdult;
	}

	public void setNumberOfAdult(int numberOfAdult) {
		this.numberOfAdult = numberOfAdult;
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(int numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getOptionToPay() {
		return optionToPay;
	}

	public void setOptionToPay(String optionToPay) {
		this.optionToPay = optionToPay;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}

	public String getOptionToFinal() {
		return optionToFinal;
	}

	public void setOptionToFinal(String optionToFinal) {
		this.optionToFinal = optionToFinal;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getReceiptNumber() {
		return receiptNumber;
	}

	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

	public double getPayInPHP() {
		return payInPHP;
	}

	public void setPayInPHP(double payInPHP) {
		this.payInPHP = payInPHP;
	}

	public double getPayInKRW() {
		return payInKRW;
	}

	public void setPayInKRW(double payInKRW) {
		this.payInKRW = payInKRW;
	}

	public String getPayInDate() {
		return payInDate;
	}

	public void setPayInDate(String payInDate) {
		this.payInDate = payInDate;
	}

	public double getPayOutPHP() {
		return payOutPHP;
	}

	public void setPayOutPHP(double payOutPHP) {
		this.payOutPHP = payOutPHP;
	}

	public double getPayOutKRW() {
		return payOutKRW;
	}

	public void setPayOutKRW(double payOutKRW) {
		this.payOutKRW = payOutKRW;
	}

	public String getPayOutDate() {
		return payOutDate;
	}

	public void setPayOutDate(String payOutDate) {
		this.payOutDate = payOutDate;
	}

	public double getIncomePHP() {
		return incomePHP;
	}

	public void setIncomePHP(double incomePHP) {
		this.incomePHP = incomePHP;
	}

	public double getIncomeKRW() {
		return incomeKRW;
	}

	public void setIncomeKRW(double incomeKRW) {
		this.incomeKRW = incomeKRW;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}