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

import com.fdm.UserDataClasses.BannedUserData;
import com.fdm.Users.User;

public class BannedUserDataReader {
	private BannedUserData bannedUsers;
	
	private static BannedUserDataReader instance;
	
	private BannedUserDataReader(BannedUserData bannedUsersData)
	{
		bannedUsers= bannedUsersData;
	}
	
	public static BannedUserDataReader getInstance(BannedUserData bannedUsersData) {
		if(instance == null)
			instance= new BannedUserDataReader(bannedUsersData);
		return instance;
	}
	
	public void parseUserData()
	{
		try {
			DocumentBuilderFactory documentBuilderFactoryObject = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilderObject = documentBuilderFactoryObject.newDocumentBuilder();
			Document bannedUserdocument = documentBuilderObject.parse(new File("bannedUsers.xml"));
			bannedUserdocument.getDocumentElement().normalize();
			NodeList userList = bannedUserdocument.getElementsByTagName("user");
			populateUserData(userList);
			
		} catch (SAXParseException err) {
			System.out.println(err.getMessage());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	private void populateUserData(NodeList userList)
	{
		User newUser;
		for (int index = 0; index < userList.getLength(); index++) {
			Node usertNode = userList.item(index);
			if (usertNode.getNodeType() == Node.ELEMENT_NODE) {
				newUser= new User();
				Element firstElement = (Element) usertNode;
				
				newUser.setUsername(getUsername(firstElement));
				
				newUser.setPassword(getPassword(firstElement));
				
				newUser.setStatus(getStatus(firstElement));
				
				newUser.setBanned(Boolean.getBoolean(getBanned(firstElement)));
				
				bannedUsers.addUser(newUser);
			} // end of if clause
		} // end of for loop with variable s
	}
	
	private String getUsername(Element firstElement)
	{
		NodeList usernameList = firstElement.getElementsByTagName("username");
		Element usernameElement = (Element) usernameList.item(0);
		NodeList textUsernameList = usernameElement.getChildNodes();
		return ((Node) textUsernameList.item(0)).getNodeValue().trim();
	}
	
	private String getPassword(Element firstElement)
	{
		NodeList passwordList = firstElement.getElementsByTagName("password");
		Element passwordElement = (Element) passwordList.item(0);
		NodeList textPasswordList = passwordElement.getChildNodes();
		return (((Node) textPasswordList.item(0)).getNodeValue().trim());
	}

	private String getStatus(Element firstElement)
	{
		NodeList statusList = firstElement.getElementsByTagName("status");
		Element statusElement = (Element) statusList.item(0);
		NodeList textStatusList = statusElement.getChildNodes();
		return ((Node) textStatusList.item(0)).getNodeValue().trim();
	}

	private String getBanned(Element firstElement)
	{
		NodeList bannedList = firstElement.getElementsByTagName("banned");
		Element bannedElement = (Element) bannedList.item(0);
		NodeList textBannedList = bannedElement.getChildNodes();
		return ((Node) textBannedList.item(0)).getNodeValue().trim();
	}
}
