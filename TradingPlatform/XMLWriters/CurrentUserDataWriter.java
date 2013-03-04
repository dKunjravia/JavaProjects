package com.fdm.XMLWriters;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fdm.UserDataClasses.CurrentUserData;
import com.fdm.Users.User;

public class CurrentUserDataWriter {
	private static CurrentUserData currentUsers;
	private static CurrentUserDataWriter instance;
	
	private CurrentUserDataWriter(CurrentUserData currentUsersData) {
		currentUsers = currentUsersData;
	}
	
	public static CurrentUserDataWriter getInstance(CurrentUserData currentUsersData)
	{
		if(instance == null)
			instance= new CurrentUserDataWriter(currentUsersData);
		return instance;
	}
	
	public void writeData()
	{
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Users");
			doc.appendChild(rootElement);
			
			for (User currentUser: currentUsers.getUserData()) {
				// staff elements
				Element user = doc.createElement("user");
				rootElement.appendChild(user);

				// username elements
				Element username = doc.createElement("username");
				username.appendChild(doc.createTextNode(currentUser.getUsername()));
				user.appendChild(username);

				// password elements
				Element password = doc.createElement("password");
				password.appendChild(doc.createTextNode(currentUser.getPassword()));
				user.appendChild(password);

				// nickname elements
				Element Status = doc.createElement("status");
				Status.appendChild(doc.createTextNode(currentUser.getStatus()));
				user.appendChild(Status);

				// Banned elements
				Element Banned = doc.createElement("banned");
				Banned.appendChild(doc.createTextNode(Boolean.toString(currentUser.isBanned())));
				user.appendChild(Banned);
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("currentUsers.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }

	}
}
