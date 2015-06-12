package fly_reservation;

public class FRHistory {
	private String name;
	private String date;
	private boolean isAirlineEdited;
	private boolean isFlightNumberEdited;
	private boolean isDepartureDateEdited;
	private boolean isDepartureTimeEdited;
	private boolean isArrivalTimeEdited;
	private boolean isOriginEdited;
	private boolean isDestinationEdited;
	private boolean isRecordLocatorEdited;
	
	private boolean isReservationTypeEdited;
	private boolean isReservationDateEdited;
	private boolean isOptionToPayEdited;
	private boolean isAmountToPayEdited;
	private boolean isOptionToFinalEdited;
	private boolean isTotalPaymentEdited;
	private boolean isTotalPaymentTypeEdited;
	
	private boolean isGuestNameEdited;
	private boolean isGenderEdited;
	private boolean isNumberOfAdultEdited;
	private boolean isNumberOfChildEdited;
	
	private boolean isPaymentTypeEdited;
	private boolean isReceiptNumberEdited;
	
	private boolean isPayInPHPEdited;
	private boolean isPayInKRWEdited;
	private boolean isPayInDateEdited;
	private boolean isPayOutPHPEdited;
	private boolean isPayOutKRWEdited;
	private boolean isPayOutDateEdited;
	private boolean isIncomePHPEdited;
	private boolean isIncomeKRWEdited;
	
	private boolean isStatusEdited;
	
	private boolean isNoteEdited;
	private boolean isRemarkEdited;
	
	public FRHistory(String name, String date, boolean isAirlineEdited,
			boolean isFlightNumberEdited, boolean isDepartureDateEdited,
			boolean isDepartureTimeEdited, boolean isArrivalTimeEdited,
			boolean isOriginEdited, boolean isDestinationEdited,
			boolean isRecordLocatorEdited, boolean isReservationTypeEdited,
			boolean isReservationDateEdited, boolean isOptionToPayEdited,
			boolean isAmountToPayEdited, boolean isOptionToFinalEdited,
			boolean isTotalPaymentEdited, boolean isTotalPaymentTypeEdited,
			boolean isGuestNameEdited, boolean isGenderEdited,
			boolean isNumberOfAdultEdited, boolean isNumberOfChildEdited,
			boolean isPaymentTypeEdited, boolean isReceiptNumberEdited,
			boolean isPayInPHPEdited, boolean isPayInKRWEdited, 
			boolean isPayInDateEdited, boolean isPayOutPHPEdited, 
			boolean isPayOutKRWEdited, boolean isPayOutDateEdited, 
			boolean isIncomePHPEdited, boolean isIncomeKRWEdited,
			boolean isStatusEdited, boolean isNoteEdited,
			boolean isRemarkEdited) {

		this.name = name;
		this.date = date;
		this.isAirlineEdited = isAirlineEdited;
		this.isFlightNumberEdited = isFlightNumberEdited;
		this.isDepartureDateEdited = isDepartureDateEdited;
		this.isDepartureTimeEdited = isDepartureTimeEdited;
		this.isArrivalTimeEdited = isArrivalTimeEdited;
		this.isOriginEdited = isOriginEdited;
		this.isDestinationEdited = isDestinationEdited;
		this.isRecordLocatorEdited = isRecordLocatorEdited;
		
		this.isReservationTypeEdited = isReservationTypeEdited;
		this.isReservationDateEdited = isReservationDateEdited;
		this.isOptionToPayEdited = isOptionToPayEdited;
		this.isAmountToPayEdited = isAmountToPayEdited;
		this.isOptionToFinalEdited = isOptionToFinalEdited;
		this.isTotalPaymentEdited = isTotalPaymentEdited;
		this.isTotalPaymentTypeEdited = isTotalPaymentTypeEdited;
		
		this.isGuestNameEdited = isGuestNameEdited;
		this.isGenderEdited = isGenderEdited;
		this.isNumberOfAdultEdited = isNumberOfAdultEdited;
		this.isNumberOfChildEdited = isNumberOfChildEdited;
		
		this.isPaymentTypeEdited = isPaymentTypeEdited;
		this.isReceiptNumberEdited = isReceiptNumberEdited;
		
		this.isPayInPHPEdited = isPayInPHPEdited;
		this.isPayInKRWEdited = isPayInKRWEdited;
		this.isPayInDateEdited = isPayInDateEdited;
		this.isPayOutPHPEdited = isPayOutPHPEdited;
		this.isPayOutKRWEdited = isPayOutKRWEdited;
		this.isPayOutDateEdited = isPayOutDateEdited;
		this.isIncomePHPEdited = isIncomePHPEdited;
		this.isIncomeKRWEdited = isIncomeKRWEdited;
		
		this.isStatusEdited = isStatusEdited;
		
		this.isNoteEdited = isNoteEdited;
		this.isRemarkEdited = isRemarkEdited;
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
	public boolean isAirlineEdited() {
		return isAirlineEdited;
	}
	public void setAirlineEdited(boolean isAirlineEdited) {
		this.isAirlineEdited = isAirlineEdited;
	}
	public boolean isFlightNumberEdited() {
		return isFlightNumberEdited;
	}
	public void setFlightNumberEdited(boolean isFlightNumberEdited) {
		this.isFlightNumberEdited = isFlightNumberEdited;
	}
	public boolean isDepartureDateEdited() {
		return isDepartureDateEdited;
	}
	public void setDepartureDateEdited(boolean isDepartureDateEdited) {
		this.isDepartureDateEdited = isDepartureDateEdited;
	}
	public boolean isDepartureTimeEdited() {
		return isDepartureTimeEdited;
	}
	public void setDepartureTimeEdited(boolean isDepartureTimeEdited) {
		this.isDepartureTimeEdited = isDepartureTimeEdited;
	}
	public boolean isArrivalTimeEdited() {
		return isArrivalTimeEdited;
	}
	public void setArrivalTimeEdited(boolean isArrivalTimeEdited) {
		this.isArrivalTimeEdited = isArrivalTimeEdited;
	}
	public boolean isOriginEdited() {
		return isOriginEdited;
	}
	public void setOriginEdited(boolean isOriginEdited) {
		this.isOriginEdited = isOriginEdited;
	}
	public boolean isDestinationEdited() {
		return isDestinationEdited;
	}
	public void setDestinationEdited(boolean isDestinationEdited) {
		this.isDestinationEdited = isDestinationEdited;
	}
	public boolean isRecordLocatorEdited() {
		return isRecordLocatorEdited;
	}
	public void setRecordLocatorEdited(boolean isRecordLocatorEdited) {
		this.isRecordLocatorEdited = isRecordLocatorEdited;
	}
	public boolean isReservationTypeEdited() {
		return isReservationTypeEdited;
	}
	public void setReservationTypeEdited(boolean isReservationTypeEdited) {
		this.isReservationTypeEdited = isReservationTypeEdited;
	}
	public boolean isReservationDateEdited() {
		return isReservationDateEdited;
	}
	public void setReservationDateEdited(boolean isReservationDateEdited) {
		this.isReservationDateEdited = isReservationDateEdited;
	}
	public boolean isOptionToPayEdited() {
		return isOptionToPayEdited;
	}
	public void setOptionToPayEdited(boolean isOptionToPayEdited) {
		this.isOptionToPayEdited = isOptionToPayEdited;
	}
	public boolean isAmountToPayEdited() {
		return isAmountToPayEdited;
	}
	public void setAmountToPayEdited(boolean isAmountToPayEdited) {
		this.isAmountToPayEdited = isAmountToPayEdited;
	}
	public boolean isOptionToFinalEdited() {
		return isOptionToFinalEdited;
	}
	public void setOptionToFinalEdited(boolean isOptionToFinalEdited) {
		this.isOptionToFinalEdited = isOptionToFinalEdited;
	}
	public boolean isTotalPaymentEdited() {
		return isTotalPaymentEdited;
	}
	public void setTotalPaymentEdited(boolean isTotalPaymentEdited) {
		this.isTotalPaymentEdited = isTotalPaymentEdited;
	}
	public boolean isTotalPaymentTypeEdited() {
		return isTotalPaymentTypeEdited;
	}
	public void setTotalPaymentTypeEdited(boolean isTotalPaymentTypeEdited) {
		this.isTotalPaymentTypeEdited = isTotalPaymentTypeEdited;
	}
	public boolean isGuestNameEdited() {
		return isGuestNameEdited;
	}
	public void setGuestNameEdited(boolean isGuestNameEdited) {
		this.isGuestNameEdited = isGuestNameEdited;
	}
	public boolean isGenderEdited() {
		return isGenderEdited;
	}
	public void setGenderEdited(boolean isGenderEdited) {
		this.isGenderEdited = isGenderEdited;
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
	public boolean isPaymentTypeEdited() {
		return isPaymentTypeEdited;
	}
	public void setPaymentTypeEdited(boolean isPaymentTypeEdited) {
		this.isPaymentTypeEdited = isPaymentTypeEdited;
	}
	public boolean isReceiptNumberEdited() {
		return isReceiptNumberEdited;
	}
	public void setReceiptNumberEdited(boolean isReceiptNumberEdited) {
		this.isReceiptNumberEdited = isReceiptNumberEdited;
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
	public boolean isStatusEdited() {
		return isStatusEdited;
	}
	public void setStatusEdited(boolean isStatusEdited) {
		this.isStatusEdited = isStatusEdited;
	}
	public boolean isNoteEdited() {
		return isNoteEdited;
	}
	public void setNoteEdited(boolean isNoteEdited) {
		this.isNoteEdited = isNoteEdited;
	}
	public boolean isRemarkEdited() {
		return isRemarkEdited;
	}
	public void setRemarkEdited(boolean isRemarkEdited) {
		this.isRemarkEdited = isRemarkEdited;
	}
}
