package com.fdm.XMLReaders;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;

public class RequestDataReader {
	RequestData requestData= RequestData.getInstance();
	public void parseRequestData()
	{
		try {
			DocumentBuilderFactory documentBuilderFactoryObject = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilderObject = documentBuilderFactoryObject.newDocumentBuilder();
			Document currenUserdocument = documentBuilderObject.parse(new File("requestData.xml"));
			currenUserdocument.getDocumentElement().normalize();
			NodeList requestList = currenUserdocument.getElementsByTagName("request");
			populateUserData(requestList);
			
		} catch (SAXParseException err) {
			System.out.println(err.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private void populateUserData(NodeList requestList)
	{
		Requests newRequest;
		for (int index = 0; index < requestList.getLength(); index++) {
			Node requestNode = requestList.item(index);
			if (requestNode.getNodeType() == Node.ELEMENT_NODE) {
				newRequest= new Requests();
				Element firstElement = (Element) requestNode;
				
				newRequest.setUsername(getUsername(firstElement));
				
				newRequest.setAdminName(getAdminName(firstElement));
				
				newRequest.setStatus(getStatus(firstElement));
				
				newRequest.setRequestText(getRequestText(firstElement));
				
				requestData.addRequest(newRequest);
			} // end of if clause
		} // end of for loop with variable s
	}
	
	private String getUsername(Element firstElement)
	{
		NodeList usenameList = firstElement.getElementsByTagName("username");
		Element usernameElement = (Element) usenameList.item(0);
		NodeList textUsernameList = usernameElement.getChildNodes();
		return ((Node) textUsernameList.item(0)).getNodeValue().trim();
	}
	
	private String getAdminName(Element firstElement)
	{
		NodeList adminList = firstElement.getElementsByTagName("admin");
		Element adminElement = (Element) adminList.item(0);
		NodeList textAdminList = adminElement.getChildNodes();
		return (((Node) textAdminList.item(0)).getNodeValue().trim());
	}

	private String getStatus(Element firstElement)
	{
		NodeList statusList = firstElement.getElementsByTagName("status");
		Element statusElement = (Element) statusList.item(0);
		NodeList textStatusList = statusElement.getChildNodes();
		return ((Node) textStatusList.item(0)).getNodeValue().trim();
	}

	private String getRequestText(Element firstElement)
	{
		NodeList requestTextList = firstElement.getElementsByTagName("requestText");
		Element requestTextElement = (Element) requestTextList.item(0);
		NodeList textRequestTextList = requestTextElement.getChildNodes();
		return ((Node) textRequestTextList.item(0)).getNodeValue().trim();
	}

}
