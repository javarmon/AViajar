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
public class QuoteOperationType implements IOperationType {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.operations.IOperationType#doOperation(com.agency.model.
	 * ProductModel)
	 */
	@Override
	public ResultModel doOperation(ProductModel product) {
		// Locate providers to the broker.
		
		// For each provider:
		// 1. Marshall the input parameters
		// 2. Execute service provider
		// 3. Unmarshalll the response
		// 4. Do additional operation
		// 5. Return result
		return null;
	}

}
