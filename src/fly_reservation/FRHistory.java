package fly_reservation;

public class FRHistory {
	private String name;
	private String date;
	private boolean isDepartureEdited;
	private boolean isFlightNumberEdited;
	private boolean isOriginEdited;
	private boolean isDestinationEdite;
	private boolean isReservationTypeEdite;
	private boolean isPaymentTypeEdite;
	private boolean isGuestNameEdited;
	private boolean isNumberOfAdultEdited;
	private boolean isNumberOfChildEdited;
	private boolean isGenderrEdited;
	private boolean isPayInPHPEdited;
	private boolean isPayInKRWEdited;
	private boolean isPayInDateEdited;
	private boolean isPayOutPHPEdited;
	private boolean isPayOutKRWEdited;
	private boolean isPayOutDateEdited;
	private boolean isIncomePHPEdited;
	private boolean isIncomeKRWEdited;
	private boolean isNoteEdited;
	
	public FRHistory(String name, String date, boolean isDepartureEdited,
			boolean isFlightNumberEdited, boolean isOriginEdited,
			boolean isDestinationEdite, boolean isReservationTypeEdite,
			boolean isPaymentTypeEdite, boolean isGuestNameEdited,
			boolean isNumberOfAdultEdited, boolean isNumberOfChildEdited,
			boolean isGenderrEdited, boolean isPayInPHPEdited,
			boolean isPayInKRWEdited, boolean isPayInDateEdited,
			boolean isPayOutPHPEdited, boolean isPayOutKRWEdited,
			boolean isPayOutDateEdited, boolean isIncomePHPEdited,
			boolean isIncomeKRWEdited, boolean isNoteEdited) {
		this.name = name;
		this.date = date;
		this.isDepartureEdited = isDepartureEdited;
		this.isFlightNumberEdited = isFlightNumberEdited;
		this.isOriginEdited = isOriginEdited;
		this.isDestinationEdite = isDestinationEdite;
		this.isReservationTypeEdite = isReservationTypeEdite;
		this.isPaymentTypeEdite = isPaymentTypeEdite;
		this.isGuestNameEdited = isGuestNameEdited;
		this.isNumberOfAdultEdited = isNumberOfAdultEdited;
		this.isNumberOfChildEdited = isNumberOfChildEdited;
		this.isGenderrEdited = isGenderrEdited;
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
	
	public boolean isNoteEdited() {
		return isNoteEdited;
	}

	public void setNoteEdited(boolean isNoteEdited) {
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
	public boolean isDepartureEdited() {
		return isDepartureEdited;
	}
	public void setDepartureEdited(boolean isDepartureEdited) {
		this.isDepartureEdited = isDepartureEdited;
	}
	public boolean isFlightNumberEdited() {
		return isFlightNumberEdited;
	}
	public void setFlightNumberEdited(boolean isFlightNumberEdited) {
		this.isFlightNumberEdited = isFlightNumberEdited;
	}
	public boolean isOriginEdited() {
		return isOriginEdited;
	}
	public void setOriginEdited(boolean isOriginEdited) {
		this.isOriginEdited = isOriginEdited;
	}
	public boolean isDestinationEdite() {
		return isDestinationEdite;
	}
	public void setDestinationEdite(boolean isDestinationEdite) {
		this.isDestinationEdite = isDestinationEdite;
	}
	public boolean isReservationTypeEdite() {
		return isReservationTypeEdite;
	}
	public void setReservationTypeEdite(boolean isReservationTypeEdite) {
		this.isReservationTypeEdite = isReservationTypeEdite;
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
	public boolean isGenderrEdited() {
		return isGenderrEdited;
	}
	public void setGenderrEdited(boolean isGenderrEdited) {
		this.isGenderrEdited = isGenderrEdited;
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
}
