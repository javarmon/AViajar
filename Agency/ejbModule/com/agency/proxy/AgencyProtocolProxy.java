/**
 * 
 */
package com.agency.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.agency.enums.OperationType;
import com.agency.model.ProductModel;
import com.agency.model.ResultModel;

/**
 * @author jvagas033
 *
 */
public abstract class AgencyProtocolProxy {
	
	/**
	 * Logger
	 */
	private static final Logger log = Logger
			.getLogger(AgencyProtocolProxy.class.getName());

	/**
	 * 
	 */
	private ProductModel productModel;
	
	/**
	 * 
	 */
	private List<ResultModel> results;

	/**
	 * @param product
	 * @throws Exception 
	 */
	public void performAction(ProductModel product) throws Exception{
		try {
			// Initialize data
			this.productModel = product;
			if (this.results == null) {
				this.results = new ArrayList<ResultModel>();
			} else {
				this.results.clear();
			}
			
			// Locate providers in broker
			log.log(Level.INFO, "Locate available providers.");
			
			// Marshall to provider protocol
			log.log(Level.INFO, "Begin marshall process.");
			marshall();

			// Send request
			log.log(Level.INFO, "Send request to provider.");
			if (product.getOperationType().equals(OperationType.QUOTE.getCode())){
				sendRequestQuote();
			} else if (product.getOperationType().equals(OperationType.CANCELLATION.getCode())) {
				sendRequestCancell();
			} else if (product.getOperationType().equals(OperationType.RESERVATION.getCode())) {
				sendRequestReserve();
			}
			
			// Unmarshalll to Agency standar
			log.log(Level.INFO, "Unmarshall response.");
			unmarshall();
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @throws Exception 
	 * 
	 */
	protected abstract void marshall() throws Exception;

	/**
	 * @throws Exception 
	 * 
	 */
	protected abstract void unmarshall() throws Exception;

	/**
	 * @throws Exception 
	 * 
	 */
	protected abstract void sendRequestReserve() throws Exception;

	/**
	 * @throws Exception 
	 * 
	 */
	protected abstract void sendRequestQuote() throws Exception;

	/**
	 * @throws Exception 
	 * 
	 */
	protected abstract void sendRequestCancell() throws Exception;

	/**
	 * @return the results
	 */
	public List<ResultModel> getResults() {
		return results;
	}

	/**
	 * @param reslts the results to set
	 */
	public void setResults(List<ResultModel> results) {
		this.results = results;
	}

	/**
	 * @return the productModel
	 */
	public ProductModel getProductModel() {
		return productModel;
	}

	/**
	 * @param productModel the productModel to set
	 */
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
}
