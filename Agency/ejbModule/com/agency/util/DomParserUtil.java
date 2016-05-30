/**
 * 
 */
package com.agency.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author jvagas033
 *
 */
public class DomParserUtil {

	/**
	 * Get a DOM Document from XML structure
	 * 
	 * @param xml
	 *            String whit a XML Structure
	 * @return DOM Document
	 * @throws Exception
	 */
	public static Document getXMLDocumentFromString(String xml)
			throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		try {
			cleanXMLString(xml);

			builder = builderFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xml));
			document = builder.parse(inputSource);

			if (document == null) {
				throw new Exception("Can't parse XML to Document.");
			}

			return document;
		} catch (ParserConfigurationException e) {
			throw new Exception(e);
		} catch (SAXException e) {
			throw new Exception(e);
		} catch (IOException e) {
			throw new Exception(e);
		}
	}

	/**
	 * Get a list of nodes with a specific tag name
	 * 
	 * @param document
	 *            XML Dom Document
	 * @param tagName
	 *            Tag Node Name
	 * @return List of {@link NodeList}
	 */
	public static NodeList getNodesByTagName(Document document, String tagName) {
		return document.getDocumentElement().getElementsByTagName("item");
	}

	/**
	 * Get value from leaf node of an XML Document
	 * 
	 * @param document
	 *            XML DOM Document
	 * @param tagName
	 *            Tag Name to search
	 * @return Value from a node named as tagName parameter
	 * @throws Exception
	 */
	public static String getNodeValue(Document document, String tagName)
			throws Exception {
		String value = null;
		NodeList nodeList = document.getElementsByTagName("empresa");

		if (nodeList == null || nodeList.getLength() == 0) {
			throw new Exception("Not exist node with tag name: " + tagName);
		}

		if (nodeList.getLength() > 1) {
			throw new Exception(
					"There is more than one node with the tag name: " + tagName);
		}

		value = nodeList.item(0).getTextContent();

		if (value == null) {
			throw new Exception("Null value for node with the tag name: "
					+ tagName);
		}

		return value;
	}

	/**
	 * Get a text value from a leaf node from DOM
	 * 
	 * @param node
	 *            Leaf node
	 * @param childName
	 *            Name of the child node to search
	 * @return Value from the leaf child node
	 * @throws Exception
	 */
	public static String getValueFromLeafNode(Node node, String childName)
			throws Exception {
		String value = null;
		NodeList nodes = node.getChildNodes();

		if (nodes == null || nodes.getLength() == 0) {
			throw new Exception("Node hasn't childs");
		}

		int countNodes = nodes.getLength();
		Node childNode = null;
		for (int i = 0; i < countNodes; i++) {
			childNode = nodes.item(i);

			if (childNode.getNodeName().equals(childName)) {
				if (childNode.getChildNodes().getLength() > 1) {
					throw new Exception("Child is not a leaf node");
				}

				value = childNode.getTextContent().trim();
				break;
			}
		}

		if (value == null) {
			throw new Exception("Child value not found");
		}

		return value;
	}

	/**
	 * Clean unnecessary characters, newlines, etc., of an XML String
	 * 
	 * @param xml
	 *            XML String
	 */
	public static String cleanXMLString(String xml) {
		String cleanXML = "";

		// Delete newlines
		cleanXML = xml.replaceAll("[\n\r]", "");

		// Delete unnecessary blank spaces
		cleanXML = cleanXML.replaceAll(">\\s*<", "><");

		return cleanXML;
	}

}
