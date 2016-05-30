/**
 * 
 */
package com.soycliente.enumeration;

/**
 * Calendar day of a specific month
 * 
 * @author jvagas033
 *
 */
public enum CalendarDay {
	FIRST("01"), SECOND("02"), THIRD("03"), FOURTH("04"), FIFTH("05"), SIXTH("06"), SEVENTH("07"), EIGHT("08"), NINETH("09"), TENTH("10"), ELEVENTH("11"), 
	TWELFTH("12"), THIRTEENTH("13"), FOURTEENTH("14"), FIFTEENTH("15"), SIXTEENTH("16"), SEVENTEENTH("17"), EIGHTEENTH("18"), NINETEENTH("19"), 
	TWENTIETH("20"), TWENTY_FIRST("21"), TWENTY_SECOND("22"), TWENTY_THIRD("23"), TWENTY_FOURTH("24"), TWENTY_FIFTH("25"), TWENTY_SIXTH("26"), 
	TWENTY_SEVENTH("27"), TWENTY_EIGHT("28"), TWENTY_NINETH("29"), THIRTIETH("30"), THIRTY_FIRST("31");
	
	/**
	 * Number of day of in a month
	 */
	private String day;
	
	/**
	 * Defines a new Calendar Day
	 * @param day
	 */
	CalendarDay(String day){
		this.day = day;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString(){
		return this.day;
	}
	
}
