/**
 * 
 */
package com.agency.model;

/**
 * @author jvagas033
 *
 */
public class ResultModel {
	
	/**
	 * Product criteria 
	 */
	private ProductModel product;
	
	/**
	 * Number of the product to reserve
	 */
	private int reserveProductId;

	/**
	 * Product available to reserve 
	 */
	private boolean available;
	
	/**
	 * Name of the provider company 
	 */
	private String companyName;
	
	/**
	 * Product Cost in a purchase
	 */
	private double purchaseCost;
	
	/**
	 * Product Cost in a devolution
	 */
	private double devolutionCost;

	/**
	 * New instance of the result model
	 * 
	 * @param product
	 * @param reserveProductId
	 * @param available
	 * @param companyName
	 * @param purchaseCost
	 * @param devolutionCost
	 */
	public ResultModel(ProductModel product, int reserveProductId,
			boolean available, String companyName, double purchaseCost,
			double devolutionCost) {
		super();
		this.product = product;
		this.reserveProductId = reserveProductId;
		this.available = available;
		this.companyName = companyName;
		this.purchaseCost = purchaseCost;
		this.devolutionCost = devolutionCost;
	}

	/**
	 * @return the product
	 */
	public ProductModel getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductModel product) {
		this.product = product;
	}

	/**
	 * @return the reserveProductId
	 */
	public int getReserveProductId() {
		return reserveProductId;
	}

	/**
	 * @param reserveProductId the reserveProductId to set
	 */
	public void setReserveProductId(int reserveProductId) {
		this.reserveProductId = reserveProductId;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the purchaseCost
	 */
	public double getPurchaseCost() {
		return purchaseCost;
	}

	/**
	 * @param purchaseCost the purchaseCost to set
	 */
	public void setPurchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}

	/**
	 * @return the devolutionCost
	 */
	public double getDevolutionCost() {
		return devolutionCost;
	}

	/**
	 * @param devolutionCost the devolutionCost to set
	 */
	public void setDevolutionCost(double devolutionCost) {
		this.devolutionCost = devolutionCost;
	}
	
	

}
