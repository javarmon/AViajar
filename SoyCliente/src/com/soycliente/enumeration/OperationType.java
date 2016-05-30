/**
 * 
 */
package com.soycliente.enumeration;

/**
 * Operation Type for AViajar agency , consisting of a group of three small
 * letters to represent what the customer wants to do
 * 
 * @author jvagas033
 *
 */
public enum OperationType {
	QUOTE("cot", "Cotización"), 
	RESERVATION("res", "Reserva"), 
	CANCELLATION("can", "Cancelación");

	/**
	 * Code Operation Type
	 */
	private final String code;

	/**
	 * Description Operation Type
	 */
	private final String description;

	/**
	 * Defines a Operation Type
	 * 
	 * @param code
	 *            Code Operation Type
	 * @param description
	 *            Description Operation Type
	 */
	OperationType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString(){
		return this.description;
	}
	
}
