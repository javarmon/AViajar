/**
 * 
 */
package com.soycliente.enumeration;

/**
 * @author jvagas033
 *
 */
public enum CalendarMonth {
	JANUARY("01", "Enero"),
	FEBRUARY("02", "Febrero"),
	MARCH("03", "Marzo"),
	APRIL("04", "Abril"),
	MAY("05", "Mayo"),
	JUNE("06", "Junio"),
	JULY("07", "Julio"),
	AUGUST("08", "Agosto"),
	SEPTEMBER("09", "Septiembre"),
	OCTOBER("10", "Obtubre"),
	NOVEMBER("11", "Novimebre"),
	DECEMBER("12", "Diciembre")
	;
	
	/**
	 * Number of month
	 */
	private String number;
	
	/**
	 * Name of month
	 */
	private String month;
	
	/**
	 * @param number
	 * @param month
	 */
	CalendarMonth (String number, String month){
		this.number = number;
		this.month = month;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString(){
		return this.month;
	}
}
