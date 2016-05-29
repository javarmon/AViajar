/**
 * 
 */
package com.agency.enums;

/**
 * Product Type For AViajar agency , consisting of a group of three small
 * letters to represent what the customer wants to buy
 * @author jvagas033
 *
 */
public enum ProductType {
	AIR_TICKETS("bol","Tiquetes A�reos"),
	GROUND_TRANSPORTATION("tra","Traslado Terrestre"),
	LODGING("alo","Alojamiento"),
	TOUR("pas","Paseo Tur�stico"),
	PACKAGE("paq","Paquete Tur�stico");
	
	/**
	 * Code Product Type
	 */
	private final String code;

	/**
	 * Description Product Type
	 */
	private final String description;

	/**
	 * Defines a Product Type
	 * 
	 * @param code
	 *            Code Product Type
	 * @param description
	 *            Description Product Type
	 */
	ProductType(String code, String description) {
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
