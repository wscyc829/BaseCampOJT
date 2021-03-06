package package_reservation;

public class PackageReservation {
	private int id;
	private String createdBy;
	private String createdAt;
	private String date;
	private String time;
	private String type;
	private String car;
	
	private String guestName;
	private int numberOfAdult;
	private int numberOfChild;
	
	private String reservationType;
	private String reservationDate;
	private String optionToPay;
	private double amountToPay;
	private String optionToFinal;
	private double totalPayment;
	private String totalPaymentType;

	private String status;

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
	
	public PackageReservation(){
		this.id = -1;
	}

	public PackageReservation(String createdBy, String createdAt, String date,
			String time, String type, String car, String guestName, 
			int numberOfAdult, int numberOfChild,String reservationType,
			String reservationDate, String optionToPay, double amountToPay,
			String optionToFinal, double totalPayment, String totalPaymentType,
			String status, String paymentType, String receiptNumber, double payInPHP, 
			double payInKRW, String payInDate, double payOutPHP, double payOutKRW,
			String payOutDate, double incomePHP, double incomeKRW, 
			String note, String remark) {
		this.id = -1;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.date = date;
		this.time = time;
		this.type = type;
		this.car = car;
		
		this.guestName = guestName;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChild = numberOfChild;
		
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.optionToPay = optionToPay;
		this.amountToPay = amountToPay;
		this.optionToFinal = optionToFinal;
		this.totalPayment = totalPayment;
		this.totalPaymentType = totalPaymentType;
		
		this.status = status;
		
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
