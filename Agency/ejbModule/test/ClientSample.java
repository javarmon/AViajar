package test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.agency.provider.avianca.*;
import com.agency.util.PropertiesFileUtil;

public class ClientSample {

	public static void main(String[] args) {

		try {
			URL wsdlLocation = new URL(
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.wsdlLocation"));
			QName qName = new QName(
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.targetNamespace"),
					PropertiesFileUtil
							.getProviderConfigPropertyValue("provider.avianca.serviceName"));

			System.out.println("***********************");
			System.out.println("Create Web Service Client...");
			AviancaService service1 = new AviancaService(wsdlLocation, qName);
			System.out.println("Create Web Service...");
			IAviancaService port1 = service1
					.getBasicHttpBindingIAviancaService();
			System.out.println("Call Web Service Operation...");
			System.out.println("Server said: " + port1.quote());
			// System.out.println("Server said: " + port1.reserve(null));
			// //Please input the parameters instead of 'null' for the upper
			// method!
			//
			// System.out.println("Server said: " + port1.cancel(null));
			// //Please input the parameters instead of 'null' for the upper
			// method!
			//
			// System.out.println("Create Web Service...");
			// IAviancaService port2 =
			// service1.getBasicHttpBindingIAviancaService();
			// System.out.println("Call Web Service Operation...");
			// System.out.println("Server said: " + port2.quote());
			// System.out.println("Server said: " + port2.reserve(null));
			// //Please input the parameters instead of 'null' for the upper
			// method!
			//
			// System.out.println("Server said: " + port2.cancel(null));
			// //Please input the parameters instead of 'null' for the upper
			// method!
			//
			// System.out.println("***********************");
			// System.out.println("Call Over!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
