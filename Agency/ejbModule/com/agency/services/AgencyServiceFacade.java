package com.agency.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.agency.enums.OperationType;
import com.agency.enums.ProductType;
import com.agency.model.ProductModel;
import com.agency.model.ResultModel;
import com.agency.operations.CancelOperationType;
import com.agency.operations.IOperationType;
import com.agency.operations.QuoteOperationType;
import com.agency.operations.ReserveOperationType;

/**
 * Session Bean implementation class AgencyServiceFacade
 */
@Stateless
@WebService(serviceName = "AgencyService")
public class AgencyServiceFacade {

	/**
	 * Logger
	 */
	private static final Logger log = Logger
			.getLogger(AgencyServiceFacade.class.getName());

	/**
	 * Default constructor.
	 */
	public AgencyServiceFacade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Process a request to get a product from a specific provider
	 * 
	 * @param product
	 *            Product criteria
	 * @return List of results of a request
	 */
	@WebMethod(operationName = "manageRequest")
	public List<ResultModel> manageRequest(ProductModel product) {
		try {
			log.log(Level.INFO, "Begin search Info");

			int serviceCount = getProductServiceCount(product.getProductType());
			ProductService[] services = new ProductService[serviceCount];
			ProductService service = null;

			// Service Creation (Salves)
			// Product: Package
			if (product.getProductType().equals(ProductType.PACKAGE)) {
				for (int i = 0; i < serviceCount; i++) {
					service = new ProductService();
					service.setOperation(getOperation(product
							.getOperationType()));
					service.setProduct(product);

					services[i] = service;
				}
			}
			// Product: Individual
			else {
				service = new ProductService();
				service.setOperation(getOperation(product.getOperationType()));
				service.setProduct(product);
				services[0] = service;
			}

			// Start services
			for (ProductService slave : services) {
				log.log(Level.INFO, slave.getProduct().getClass().getName()
						+ " thread has begin");
				slave.start();
			}

			// Wait for slaves to die
			for (ProductService slave : services) {
				try {
					slave.join();
				} catch (InterruptedException e) {
					log.log(Level.SEVERE, e.getMessage());
				} finally {
					log.log(Level.INFO, slave.getOperation().getClass()
							.getName()
							+ " thread has died");
				}
			}

			// Process the result
			log.log(Level.INFO, "Begin process results");

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return null;
	}

	/**
	 * Get the number of services include in the request
	 * 
	 * @param productType
	 *            Product type requested
	 * @return Number of services to request: If product type is Package return
	 *         4, else return 1
	 * @throws Exception
	 */
	private int getProductServiceCount(String productType) throws Exception {
		if (productType == null) {
			throw new Exception("Invalid Product Type");
		}
		return productType.equals(ProductType.PACKAGE.getCode()) ? 4 : 1;
	}

	/**
	 * Get the operation type to execute in the service
	 * 
	 * @param operationType
	 *            Operation type requested
	 * @return Instance of a {@link IOperationType}
	 * @throws Exception
	 */
	private IOperationType getOperation(String operationType) throws Exception {
		if (operationType == null) {
			throw new Exception("Invalid Operation Type");
		}

		if (operationType.equals(OperationType.CANCELLATION.getCode())) {
			return new CancelOperationType();
		} else if (operationType.equals(OperationType.QUOTE.getCode())) {
			return new QuoteOperationType();
		} else if (operationType.equals(OperationType.RESERVATION.getCode())) {
			return new ReserveOperationType();
		} else {
			throw new Exception("Operation Type Not Found");
		}
	}

}
