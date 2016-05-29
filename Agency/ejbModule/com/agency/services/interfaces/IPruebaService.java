/**
 * 
 */
package com.agency.services.interfaces;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author jvagas033
 *
 */
@Remote
@WebService(serviceName="PruebaService")
public interface IPruebaService {

	@WebMethod(operationName="serviceMethod")
	public void serviceMethod(String abc);
}
