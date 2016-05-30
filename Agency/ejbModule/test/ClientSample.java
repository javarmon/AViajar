package test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.agency.provider.avianca.AviancaService;
import com.agency.provider.avianca.IAviancaService;
import com.agency.util.DomParserUtil;
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
			String response = port1.quote();
			System.out.println("Server said: " + response);
			
			Document document = DomParserUtil.getXMLDocumentFromString(response);
			NodeList items = DomParserUtil.getNodesByTagName(document, "item");
			int countItems = items.getLength();
			System.out.println("Empresa: "+DomParserUtil.getNodeValue(document, "empresa"));
			
			
			for (int i = 0; i < countItems; i++) {
				System.out.println("Item 1: ");
				System.out.println("ID: " + DomParserUtil.getValueFromLeafNode(items.item(i), "id"));
				System.out.println("Ciudad: " + DomParserUtil.getValueFromLeafNode(items.item(i), "ciudad"));
				System.out.println("Dia: " + DomParserUtil.getValueFromLeafNode(items.item(i), "dia"));
				System.out.println("Costo: " + DomParserUtil.getValueFromLeafNode(items.item(i), "costo"));
			}
			
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
