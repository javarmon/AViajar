package com.agency.enums;

/**
 * Cities available to travel.
 * 
 * @author jvagas033
 *
 */
public enum City {
	ARAUCA			("ara", "Arauca"),
	ARMENIA			("arm", "Armenia"),
	BARRANQUILLA	("bar", "Barranquilla"),
	BUCARAMANGA		("buc", "Bucaramanga"),
	CALI			("cal", "Cali"),
	CARTAGENA		("car", "Cartagena"),
	CUCUTA			("cuc", "C�cuta"),
	FLORENCIA		("flo", "Florencia"),
	IBAGUE			("iba", "Ibagu�"),
	LETICIA			("let", "Leticia"),
	MANIZALES		("man", "Manizales"),
	MEDELLIN		("med", "Medell�n"),
	MITU			("mit", "Mit�"),
	MOCOA			("moc", "Mocoa"),
	MONTERIA		("mon", "Monter�a"),
	NEIVA			("nei", "Neiva"),
	PASTO			("pas", "Pasto"),
	PEREIRA			("per", "Pereira"),
	POPAYAN			("pop", "Popay�n"),
	PTO_CARRENO		("pue", "Puerto Carre�o"),
	QUIBDO			("qui", "Quibdo"),
	RIOACHA			("rio", "Rioacha"),
	SANTA_MARTA		("san", "Santa Marta"),
	SINCELEJO		("sin", "Sincelejo"),
	TUNJA			("tun", "Tunja"),
	VALLEDUPAR		("val", "Valledupar"),
	VILLAVICENCIO	("vil", "Villavicencio")
	;

	/**
	 * Code City
	 */
	private final String code;

	/**
	 * Name City
	 */
	private final String name;

	/**
	 * Defines a City
	 * 
	 * @param code
	 *            Code City
	 * @param name
	 *            Name City
	 */
	City(String code, String name) {
		this.code = code;
		this.name = name;
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
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString(){
		return this.name;
	}
}
