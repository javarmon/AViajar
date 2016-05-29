/**
 * 
 */
package com.agency.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.agency.model.ProductModel;
import com.agency.model.ResultModel;
import com.agency.operations.IOperationType;

/**
 * @author jvagas033
 *
 */
public class ProductService extends Thread {

	/**
	 * Logger 
	 */
	private static final Logger log = Logger.getLogger(ProductService.class.getName());
	
	/**
	 * The thread is done
	 */
	private boolean done = false;
	
	/**
	 * Product criteria info
	 */
	private ProductModel product;
	
	/**
	 * Operation type to execute
	 */
	private IOperationType operation;
	
	/**
	 * Provider's operation execution result
	 */
	private ResultModel result;
	

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		this.result = executeOperation();
		this.done = result != null; 
	}
	
	/**
	 * Halt threat excecution
	 */
	public void halt () {
		log.log(Level.INFO, "End operation: " + this.operation.getClass().getName());
		this.done = true;
	}
	
	/**
	 * Execute a specific product operation type
	 * 
	 * @return Available product to buy; if there aren't
	 *         products, return null
	 */
	public ResultModel executeOperation(){
		ResultModel result = this.operation.doOperation(getProduct());
		halt();
		return result;
	}
	
	/**
	 * @return the operation
	 */
	public IOperationType getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(IOperationType operation) {
		this.operation = operation;
	}

	/**
	 * @return the result
	 */
	public ResultModel getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(ResultModel result) {
		this.result = result;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
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
}
