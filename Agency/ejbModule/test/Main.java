/**
 * 
 */
package test;

import java.util.List;

import com.agency.enums.OperationType;
import com.agency.enums.ProductType;
import com.agency.model.ProductModel;
import com.agency.model.ResultModel;
import com.agency.services.AgencyServiceFacade;

/**
 * @author jvagas033
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductModel product = new ProductModel(OperationType.QUOTE.getCode(),
				ProductType.PACKAGE.getCode(), "medellin", "01/01/2016",
				"01/01/2016");
		
		AgencyServiceFacade serviceFacade = new AgencyServiceFacade();
		List<ResultModel> results = serviceFacade.manageRequest(product);

	}

}
