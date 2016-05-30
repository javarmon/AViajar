/**
 * 
 */
package com.agency.proxy;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.agency.enums.OperationType;
import com.agency.model.ResultModel;
import com.agency.provider.avianca.AviancaService;
import com.agency.provider.avianca.IAviancaService;
import com.agency.util.DomParserUtil;
import com.agency.util.PropertiesFileUtil;

/**
 * @author jvagas033
 *
 */
public class AviancaProtocolProxy extends AgencyProtocolProxy {

	/**
	 * Logger
	 */
	private static final Logger log = Logger
			.getLogger(AviancaProtocolProxy.class.getName());

	/**
	 * 
	 */
	private String response;

	/**
	 * 
	 */
	private URL wsdlLocation;

	/**
	 * 
	 */
	private QName qName;

	/**
	 * 
	 */
	private IAviancaService port;

	/**
	 * 
	 */
	private boolean successProcess;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.proxy.AgencyProtocolProxy#marshall()
	 */
	@Override
	protected void marshall() throws Exception {
		try {
			// Initialize data
			this.wsdlLocation = new URL(
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.wsdlLocation"));
			this.qName = new QName(
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.targetNamespace"),
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.serviceName"));
			this.successProcess = false;
			this.response = null;

			log.log(Level.INFO, "Create Web Service Client...");
			AviancaService service = new AviancaService(wsdlLocation, qName);

			log.log(Level.INFO, "Create Web Service...");
			this.port = service.getBasicHttpBindingIAviancaService();

		} catch (MalformedURLException e) {
			throw new Exception("Conection provider parameters are broken.");
		} catch (FileNotFoundException e) {
			throw new Exception("Configuration provider file not found.");
		} catch (Exception e) {
			throw new Exception("Problem provider marshall process.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.proxy.AgencyProtocolProxy#unmarshall()
	 */
	@Override
	protected void unmarshall() throws Exception {
		if (this.successProcess) {
			if (getProductModel().getOperationType().equals(
					OperationType.RESERVATION)) {
				unmarshallReserve();
			}
		}
	}

	/**
	 * @throws Exception
	 * 
	 */
	private void unmarshallReserve() throws Exception {
		try {
			Document document = DomParserUtil
					.getXMLDocumentFromString(this.response);
			String companyName = DomParserUtil
					.getNodeValue(document, "empresa");

			// Get available items
			NodeList items = DomParserUtil.getNodesByTagName(document, "item");

			// Build no available product result
			if (items == null || items.getLength() == 0) {

			}
			// Build results with available products
			else {
				for (int i = 0; i < items.getLength(); i++) {
					ResultModel result = new ResultModel(getProductModel(), new Integer(
							DomParserUtil.getValueFromLeafNode(items.item(i),
									"id")), true, companyName, new Double(
							DomParserUtil.getValueFromLeafNode(items.item(i),
									"costo")));
					
					getResults().add(result);
				}
			}

		} catch (Exception e) {
			throw new Exception("Problem unmarshalling reservation", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.proxy.AgencyProtocolProxy#sendRequestReserve()
	 */
	@Override
	protected void sendRequestReserve() throws Exception {
		try {
			log.log(Level.INFO, "Call reserve service operation");
			this.successProcess = port.reserve(-1);
		} catch (Exception e) {
			throw new Exception("Problem executing provider reserve process.",
					e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.proxy.AgencyProtocolProxy#sendRequestQuote()
	 */
	@Override
	protected void sendRequestQuote() throws Exception {
		try {
			log.log(Level.INFO, "Call quote service operation");
			this.response = port.quote();

			if (response == null || response.equals("")) {
				throw new Exception(
						"Invalid response from provider (No data found)");
			}
			this.successProcess = true;
		} catch (Exception e) {
			throw new Exception("Problem executing provider quote process.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agency.proxy.AgencyProtocolProxy#sendRequestCancell()
	 */
	@Override
	protected void sendRequestCancell() throws Exception {
		try {
			log.log(Level.INFO, "Call cancell service operation");
			this.successProcess = port.cancel(-1);
		} catch (Exception e) {
			throw new Exception("Problem executing provider cancell process.",
					e);
		}
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
}
