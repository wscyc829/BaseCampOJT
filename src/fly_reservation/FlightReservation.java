package fly_reservation;

public class FlightReservation {
	private int id;
	private String createdBy;
	private String createdAt;
	
	private String airline;
	private String flightNumber;
	private String departureDate;
	private String departureTime;
	private String arrivalTime;
	private String origin;
	private String destination;
	private String recordLocator;
	
	private String reservationType;
	private String reservationDate;
	private String optionToPay;
	private double amountToPay;
	private String optionToFinal;
	private double totalPayment;
	private String totalPaymentType;
	
	private String guestName;
	private String gender;
	private int numberOfAdult;
	private int numberOfChild;
	
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
	
	private String status;
	
	private String note;
	private String remark;
	
	public FlightReservation(){
		this.id = -1;
	}

	public FlightReservation(String createdBy, String createdAt,
			String airline, String flightNumber, String departureDate,
			String departureTime, String arrivalTime, String origin,
			String destination, String recordLocator, String reservationType,
			String reservationDate, String optionToPay, double amountToPay,
			String optionToFinal, double totalPayment, String totalPaymentType,
			String guestName, String gender, int numberOfAdult,
			int numberOfChild, String paymentType, String receiptNumber, 
			double payInPHP, double payInKRW, String payInDate, double payOutPHP,
			double payOutKRW, String payOutDate, double incomePHP,
			double incomeKRW, String status, String note, String remark) {
		this.id = -1;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		this.recordLocator = recordLocator;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.optionToPay = optionToPay;
		this.amountToPay = amountToPay;
		this.optionToFinal = optionToFinal;
		this.totalPayment = totalPayment;
		this.totalPaymentType = totalPaymentType;
		this.guestName = guestName;
		this.gender = gender;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChild = numberOfChild;
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
		this.status = status;
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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRecordLocator() {
		return recordLocator;
	}

	public void setRecordLocator(String recordLocator) {
		this.recordLocator = recordLocator;
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

	public String getTotalPaymentType() {
		return totalPaymentType;
	}

	public void setTotalPaymentType(String totalPaymentType) {
		this.totalPaymentType = totalPaymentType;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
