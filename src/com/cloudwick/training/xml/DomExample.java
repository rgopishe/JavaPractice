package com.cloudwick.training.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExample {

	private Document dom;

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		// TODO Auto-generated method stub
		DomExample eg = new DomExample();
		eg.parseXmlFile();
		eg.processDocument();

	}

	private void parseXmlFile() throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder doc = fac.newDocumentBuilder();
		dom = doc.parse("Person.xml");
	}

	private void processDocument() {
		// Getting root element

		Element rootel = dom.getDocumentElement();

		// Get Nodelist of USer Elements

		NodeList userlist = rootel.getElementsByTagName("User");
		List<UserModel> umlist = new ArrayList<>();
		for (int i = 0; i < userlist.getLength(); i++) {
			Element user = (Element) userlist.item(i);

			// Get userid Attribute
			String id = user.getAttribute("userid");

			// Get username Attribute
			NodeList unamelist = user.getElementsByTagName("username");
			Element unameEl = (Element) unamelist.item(0);
			String uname = unameEl.getFirstChild().getNodeValue();
			//System.out.println("Uname"+uname);

			// Get password Attribute
			NodeList pwdlist = user.getElementsByTagName("password");
			Element pwdEl = (Element) pwdlist.item(0);
			String pwd = pwdEl.getFirstChild().getNodeValue();
			//System.out.println("Password"+pwd);

			// Get validity Attribute
			NodeList validitylist = user.getElementsByTagName("validity");
			Element validityEl = (Element) validitylist.item(0);
			String validity = validityEl.getFirstChild().getNodeValue();
			//System.out.println("Validity " +validity);
			
			UserModel obj = new UserModel();
			obj.setUserid(Integer.parseInt(id));
			obj.setUsername(uname);
			obj.setPassword(pwd);
			obj.setValidity(Integer.parseInt(validity));
			umlist.add(obj);
			//System.out.println("Parsed output is "+obj);

		}

		PersonModel pmlist = new PersonModel();
		pmlist.setUserlist(umlist);
		for(UserModel u : umlist){
			System.out.println(u.toString());
		}
	}

}
