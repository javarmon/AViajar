/**
 * 
 */
package com.agency.model;


/**
 * @author jvagas033
 *
 */
public class ProductModel {

	/**
	 * can: Cancel, res: Reserve, cot:Quote
	 */
	private String operationType;

	/**
	 * bol: Flight Service, tra: Transport Service, alo: Hotel Service, pas:
	 * Tour Service, paq: Hole Package
	 */
	private String productType;
	
	/**
	 * Name of city
	 */
	private String city;
	
	/**
	 * Begin date in dd/mm/aa format
	 */
	private String beginDate;
	
	/**
	 * End date in dd/mm/aa format
	 */
	private String endDate;
	
	
	/**
	 * New instance of Product Agency Model
	 *  
	 * @param operationType
	 * @param productType
	 * @param city
	 * @param beginDate
	 * @param endDate
	 */
	public ProductModel(String operationType, String productType, String city,
			String beginDate, String endDate) {
		super();
		this.operationType = operationType;
		this.productType = productType;
		this.city = city;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	/**
	 * @return the operationType
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType the operationType to set
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the beginDate
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
