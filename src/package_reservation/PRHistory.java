package package_reservation;

public class PRHistory {
	private String name;
	private String date;
	private boolean isDateEdited;
	private boolean isTimeEdited;
	private boolean isTypeEdited;
	private boolean isCarEdite;
	private boolean isPaymentTypeEdite;
	private boolean isGuestNameEdited;
	private boolean isNumberOfAdultEdited;
	private boolean isNumberOfChildEdited;
	private boolean isReservationTypeEdite;
	private boolean isPayInPHPEdited;
	private boolean isPayInKRWEdited;
	private boolean isPayInDateEdited;
	private boolean isPayOutPHPEdited;
	private boolean isPayOutKRWEdited;
	private boolean isPayOutDateEdited;
	private boolean isIncomePHPEdited;
	private boolean isIncomeKRWEdited;
	private boolean isNoteEdited;
	public PRHistory(String name, String date, boolean isDateEdited,
			boolean isTimeEdited, boolean isTypeEdited, boolean isCarEdite,
			boolean isPaymentTypeEdite, boolean isGuestNameEdited,
			boolean isNumberOfAdultEdited, boolean isNumberOfChildEdited,
			boolean isReservationTypeEdite, boolean isPayInPHPEdited,
			boolean isPayInKRWEdited, boolean isPayInDateEdited,
			boolean isPayOutPHPEdited, boolean isPayOutKRWEdited,
			boolean isPayOutDateEdited, boolean isIncomePHPEdited,
			boolean isIncomeKRWEdited, boolean isNoteEdited) {
		super();
		this.name = name;
		this.date = date;
		this.isDateEdited = isDateEdited;
		this.isTimeEdited = isTimeEdited;
		this.isTypeEdited = isTypeEdited;
		this.isCarEdite = isCarEdite;
		this.isPaymentTypeEdite = isPaymentTypeEdite;
		this.isGuestNameEdited = isGuestNameEdited;
		this.isNumberOfAdultEdited = isNumberOfAdultEdited;
		this.isNumberOfChildEdited = isNumberOfChildEdited;
		this.isReservationTypeEdite = isReservationTypeEdite;
		this.isPayInPHPEdited = isPayInPHPEdited;
		this.isPayInKRWEdited = isPayInKRWEdited;
		this.isPayInDateEdited = isPayInDateEdited;
		this.isPayOutPHPEdited = isPayOutPHPEdited;
		this.isPayOutKRWEdited = isPayOutKRWEdited;
		this.isPayOutDateEdited = isPayOutDateEdited;
		this.isIncomePHPEdited = isIncomePHPEdited;
		this.isIncomeKRWEdited = isIncomeKRWEdited;
		this.isNoteEdited = isNoteEdited;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isDateEdited() {
		return isDateEdited;
	}
	public void setDateEdited(boolean isDateEdited) {
		this.isDateEdited = isDateEdited;
	}
	public boolean isTimeEdited() {
		return isTimeEdited;
	}
	public void setTimeEdited(boolean isTimeEdited) {
		this.isTimeEdited = isTimeEdited;
	}
	public boolean isTypeEdited() {
		return isTypeEdited;
	}
	public void setTypeEdited(boolean isTypeEdited) {
		this.isTypeEdited = isTypeEdited;
	}
	public boolean isCarEdite() {
		return isCarEdite;
	}
	public void setCarEdite(boolean isCarEdite) {
		this.isCarEdite = isCarEdite;
	}
	public boolean isPaymentTypeEdite() {
		return isPaymentTypeEdite;
	}
	public void setPaymentTypeEdite(boolean isPaymentTypeEdite) {
		this.isPaymentTypeEdite = isPaymentTypeEdite;
	}
	public boolean isGuestNameEdited() {
		return isGuestNameEdited;
	}
	public void setGuestNameEdited(boolean isGuestNameEdited) {
		this.isGuestNameEdited = isGuestNameEdited;
	}
	public boolean isNumberOfAdultEdited() {
		return isNumberOfAdultEdited;
	}
	public void setNumberOfAdultEdited(boolean isNumberOfAdultEdited) {
		this.isNumberOfAdultEdited = isNumberOfAdultEdited;
	}
	public boolean isNumberOfChildEdited() {
		return isNumberOfChildEdited;
	}
	public void setNumberOfChildEdited(boolean isNumberOfChildEdited) {
		this.isNumberOfChildEdited = isNumberOfChildEdited;
	}
	public boolean isReservationTypeEdite() {
		return isReservationTypeEdite;
	}
	public void setReservationTypeEdite(boolean isReservationTypeEdite) {
		this.isReservationTypeEdite = isReservationTypeEdite;
	}
	public boolean isPayInPHPEdited() {
		return isPayInPHPEdited;
	}
	public void setPayInPHPEdited(boolean isPayInPHPEdited) {
		this.isPayInPHPEdited = isPayInPHPEdited;
	}
	public boolean isPayInKRWEdited() {
		return isPayInKRWEdited;
	}
	public void setPayInKRWEdited(boolean isPayInKRWEdited) {
		this.isPayInKRWEdited = isPayInKRWEdited;
	}
	public boolean isPayInDateEdited() {
		return isPayInDateEdited;
	}
	public void setPayInDateEdited(boolean isPayInDateEdited) {
		this.isPayInDateEdited = isPayInDateEdited;
	}
	public boolean isPayOutPHPEdited() {
		return isPayOutPHPEdited;
	}
	public void setPayOutPHPEdited(boolean isPayOutPHPEdited) {
		this.isPayOutPHPEdited = isPayOutPHPEdited;
	}
	public boolean isPayOutKRWEdited() {
		return isPayOutKRWEdited;
	}
	public void setPayOutKRWEdited(boolean isPayOutKRWEdited) {
		this.isPayOutKRWEdited = isPayOutKRWEdited;
	}
	public boolean isPayOutDateEdited() {
		return isPayOutDateEdited;
	}
	public void setPayOutDateEdited(boolean isPayOutDateEdited) {
		this.isPayOutDateEdited = isPayOutDateEdited;
	}
	public boolean isIncomePHPEdited() {
		return isIncomePHPEdited;
	}
	public void setIncomePHPEdited(boolean isIncomePHPEdited) {
		this.isIncomePHPEdited = isIncomePHPEdited;
	}
	public boolean isIncomeKRWEdited() {
		return isIncomeKRWEdited;
	}
	public void setIncomeKRWEdited(boolean isIncomeKRWEdited) {
		this.isIncomeKRWEdited = isIncomeKRWEdited;
	}
	public boolean isNoteEdited() {
		return isNoteEdited;
	}
	public void setNoteEdited(boolean isNoteEdited) {
		this.isNoteEdited = isNoteEdited;
	}
}
