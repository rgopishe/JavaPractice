package com.cloudwick.training.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DOMXmlCreateExample {
	Document dom;
	public List<UserModel> userlist = new ArrayList<>();

	public static void main(String[] args) throws ParserConfigurationException, IOException {
		
		DOMXmlCreateExample xml = new DOMXmlCreateExample();
		xml.createDocument();
		xml.populateUsers();
		xml.createXml();
		xml.printXmlContent();
	}

	public void createDocument() throws ParserConfigurationException {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		DocumentBuilder doc = fac.newDocumentBuilder();
		dom = doc.newDocument();

	}
	
	public void populateUsers(){
		UserModel obj = new UserModel();
		obj.setUserid(11);
		obj.setUsername("Fremont");
		obj.setValidity(20);
		obj.setPassword("Fremont");
		userlist.add(obj);
		
		UserModel obj1 = new UserModel();
		obj1.setUserid(12);
		obj1.setUsername("Seattle");
		obj1.setValidity(25);
		obj1.setPassword("Seattle");
		userlist.add(obj1);
		
		UserModel obj2 = new UserModel();
		obj2.setUserid(11);
		obj2.setUsername("Charlotte");
		obj2.setValidity(30);
		obj2.setPassword("charlotte");
		userlist.add(obj2);
		
		
	}
	
	public void createXml(){
		
		//Creating root element
		Element rootel = dom.createElement("Person");
		dom.appendChild(rootel);
		Iterator<UserModel> itr = userlist.iterator();
		while(itr.hasNext()){
			UserModel obj = itr.next();
			//Creating User Element
			Element userel = dom.createElement("User");
			userel.setAttribute("userid", String.valueOf(obj.getUserid()));
			
			Element unel= dom.createElement("username");
			Text untext = dom.createTextNode(obj.getUsername());
			unel.appendChild(untext);
			userel.appendChild(unel);
			
			Element pwel= dom.createElement("password");
			Text pwtext = dom.createTextNode(obj.getPassword());
			pwel.appendChild(pwtext);
			userel.appendChild(pwel);
			
			Element vael= dom.createElement("validity");
			Text vatext = dom.createTextNode(obj.getValidity()+"");
			unel.appendChild(vatext);
			userel.appendChild(vael);
			
			rootel.appendChild(userel);
		}
		
		
	}
	
	public void printXmlContent() throws IOException{
		OutputFormat format = new OutputFormat(dom);
		format.setIndenting(true);
		XMLSerializer serilaize = new XMLSerializer(new FileOutputStream("useroutput.xml"),format);
		serilaize.serialize(dom);
	}
}
