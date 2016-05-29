/**
 * 
 */
package com.agency.operations;

import com.agency.model.ProductModel;
import com.agency.model.ResultModel;

/**
 * @author jvagas033
 *
 */
public interface IOperationType {

	/**
	 * Executes a operation depending of the product characteristics
	 * 
	 * @param product
	 *            Product Criteria
	 * @return Result of the operation
	 */
	public ResultModel doOperation(ProductModel product);

}
