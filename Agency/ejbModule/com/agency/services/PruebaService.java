package com.agency.services;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.agency.services.interfaces.IPruebaService;

/**
 * Session Bean implementation class PruebaService
 */
@Stateless
@WebService(serviceName="PruebaService")
public class PruebaService{

    /**
     * Default constructor. 
     */
    public PruebaService() {
        // TODO Auto-generated constructor stub
    }

	@WebMethod(operationName="serviceMethod")
	public void serviceMethod(String abc) {
		// TODO Auto-generated method stub
		
	}
    
}
