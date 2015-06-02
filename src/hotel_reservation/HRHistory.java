package hotel_reservation;

public class HRHistory {
	private String name;
	private String date;
	private boolean isCheckInEdited;
	private boolean isCheckOutEdited;
	private boolean isHotelOrResortEdited;
	private boolean isGuestNameEdited;
	private boolean isNumberOfAdultEdited;
	private boolean isNumberOfChildEdited;
	private boolean isRoomTypeEdited;
	private boolean isNumberOfRoomsEdited;
	private boolean isNumberOfNightsEdited;
	private boolean isBreakfastEdited;
	private boolean isConfirmationNumberEdited;
	private boolean isCompanyEdited;
	private boolean isStatusEdited;
	private boolean isReservationTypeEdited;
	private boolean isReservationDateEdited;
	private boolean isOptionToPayEdited;
	private boolean isAmountToPayEdited;
	private boolean isOptionToFinalEdited;
	private boolean isTotalPaymentEdited;
	private boolean isTotalPaymentTypeEdited;
	
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
	
	private boolean isNoteEdited;
	private boolean isRemarkEdited;
	public HRHistory(String name, String date, boolean isCheckInEdited,
			boolean isCheckOutEdited, boolean isHotelOrResortEdited,
			boolean isGuestNameEdited, boolean isNumberOfAdultEdited,
			boolean isNumberOfChildEdited, boolean isRoomTypeEdited,
			boolean isNumberOfRoomsEdited, boolean isNumberOfNightsEdited,
			boolean isBreakfastEdited, boolean isConfirmationNumberEdited,
			boolean isCompanyEdited, boolean isStatusEdited,
			boolean isReservationTypeEdited, boolean isReservationDateEdited,
			boolean isOptionToPayEdited, boolean isAmountToPayEdited,
			boolean isOptionToFinalEdited, boolean isTotalPaymentEdited,
			boolean isTotalPaymentTypeEdited, boolean isPaymentTypeEdited,
			boolean isReceiptNumberEdited, boolean isPayInPHPEdited,
			boolean isPayInKRWEdited, boolean isPayInDateEdited,
			boolean isPayOutPHPEdited, boolean isPayOutKRWEdited,
			boolean isPayOutDateEdited, boolean isIncomePHPEdited,
			boolean isIncomeKRWEdited, boolean isNoteEdited,
			boolean isRemarkEdited) {
		super();
		this.name = name;
		this.date = date;
		this.isCheckInEdited = isCheckInEdited;
		this.isCheckOutEdited = isCheckOutEdited;
		this.isHotelOrResortEdited = isHotelOrResortEdited;
		this.isGuestNameEdited = isGuestNameEdited;
		this.isNumberOfAdultEdited = isNumberOfAdultEdited;
		this.isNumberOfChildEdited = isNumberOfChildEdited;
		this.isRoomTypeEdited = isRoomTypeEdited;
		this.isNumberOfRoomsEdited = isNumberOfRoomsEdited;
		this.isNumberOfNightsEdited = isNumberOfNightsEdited;
		this.isBreakfastEdited = isBreakfastEdited;
		this.isConfirmationNumberEdited = isConfirmationNumberEdited;
		this.isCompanyEdited = isCompanyEdited;
		this.isStatusEdited = isStatusEdited;
		this.isReservationTypeEdited = isReservationTypeEdited;
		this.isReservationDateEdited = isReservationDateEdited;
		this.isOptionToPayEdited = isOptionToPayEdited;
		this.isAmountToPayEdited = isAmountToPayEdited;
		this.isOptionToFinalEdited = isOptionToFinalEdited;
		this.isTotalPaymentEdited = isTotalPaymentEdited;
		this.isTotalPaymentTypeEdited = isTotalPaymentTypeEdited;
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
	public boolean isCheckInEdited() {
		return isCheckInEdited;
	}
	public void setCheckInEdited(boolean isCheckInEdited) {
		this.isCheckInEdited = isCheckInEdited;
	}
	public boolean isCheckOutEdited() {
		return isCheckOutEdited;
	}
	public void setCheckOutEdited(boolean isCheckOutEdited) {
		this.isCheckOutEdited = isCheckOutEdited;
	}
	public boolean isHotelOrResortEdited() {
		return isHotelOrResortEdited;
	}
	public void setHotelOrResortEdited(boolean isHotelOrResortEdited) {
		this.isHotelOrResortEdited = isHotelOrResortEdited;
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
	public boolean isRoomTypeEdited() {
		return isRoomTypeEdited;
	}
	public void setRoomTypeEdited(boolean isRoomTypeEdited) {
		this.isRoomTypeEdited = isRoomTypeEdited;
	}
	public boolean isNumberOfRoomsEdited() {
		return isNumberOfRoomsEdited;
	}
	public void setNumberOfRoomsEdited(boolean isNumberOfRoomsEdited) {
		this.isNumberOfRoomsEdited = isNumberOfRoomsEdited;
	}
	public boolean isNumberOfNightsEdited() {
		return isNumberOfNightsEdited;
	}
	public void setNumberOfNightsEdited(boolean isNumberOfNightsEdited) {
		this.isNumberOfNightsEdited = isNumberOfNightsEdited;
	}
	public boolean isBreakfastEdited() {
		return isBreakfastEdited;
	}
	public void setBreakfastEdited(boolean isBreakfastEdited) {
		this.isBreakfastEdited = isBreakfastEdited;
	}
	public boolean isConfirmationNumberEdited() {
		return isConfirmationNumberEdited;
	}
	public void setConfirmationNumberEdited(boolean isConfirmationNumberEdited) {
		this.isConfirmationNumberEdited = isConfirmationNumberEdited;
	}
	public boolean isCompanyEdited() {
		return isCompanyEdited;
	}
	public void setCompanyEdited(boolean isCompanyEdited) {
		this.isCompanyEdited = isCompanyEdited;
	}
	public boolean isStatusEdited() {
		return isStatusEdited;
	}
	public void setStatusEdited(boolean isStatusEdited) {
		this.isStatusEdited = isStatusEdited;
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
