package package_reservation;

public class PackageReservation {
	private int id;
	
	private String date;
	private String time;
	private String type;
	private String car;
	private String paymentType;
	private String guestName;
	
	private int numberOfAdult;
	private int numberOfChild;
	
	private String reservationType;
	
	private double payInPHP;
	private double payInKRW;
	private String payInDate;
	
	private double payOutPHP;
	private double payOutKRW;
	private String payOutDate;
	
	private double incomePHP;
	private double incomeKRW;
	
	private String note;
	
	public PackageReservation(){
		this.id = -1;
	}

	public PackageReservation(String date, String time, String type,
			String car, String paymentType, String guestName,
			int numberOfAdult, int numberOfChild, String reservationType,
			double payInPHP, double payInKRW, String payInDate,
			double payOutPHP, double payOutKRW, String payOutDate,
			double incomePHP, double incomeKRW, String note) {
		this.id = -1;
		this.date = date;
		this.time = time;
		this.type = type;
		this.car = car;
		this.paymentType = paymentType;
		this.guestName = guestName;
		this.numberOfAdult = numberOfAdult;
		this.numberOfChild = numberOfChild;
		this.reservationType = reservationType;
		this.payInPHP = payInPHP;
		this.payInKRW = payInKRW;
		this.payInDate = payInDate;
		this.payOutPHP = payOutPHP;
		this.payOutKRW = payOutKRW;
		this.payOutDate = payOutDate;
		this.incomePHP = incomePHP;
		this.incomeKRW = incomeKRW;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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
}
