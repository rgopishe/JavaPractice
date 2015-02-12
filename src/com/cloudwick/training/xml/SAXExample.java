package com.cloudwick.training.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXExample extends DefaultHandler {
	
	List<UserModel> userlist = new ArrayList<>();
	PersonModel personobj;
	UserModel userobj;
	String data;

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		SAXExample seg = new SAXExample();
		seg.parseXml();
		seg.printResults();
		
		

	}

	private void parseXml() throws SAXException, IOException, ParserConfigurationException{
		SAXParserFactory fac = SAXParserFactory.newInstance();
		SAXParser parser = fac.newSAXParser();
		parser.parse("Person.xml", this);
	}
	
	public void startElement(String uri, String localname, String qname , Attributes attributes){
		//System.out.println("start");
		if(qname.equals("Person")){
			personobj = new PersonModel();
			
		}
		if (qname.equals("User")){
			//System.out.println("setting user");
			userobj = new UserModel();
			userobj.setUserid(Integer.parseInt(attributes.getValue("userid")));
		}
	}
	
	public void characters(char[] ch, int start , int length){
		data = new String(ch,start,length);
		
	}
	
	public void endElement(String uri, String localname, String qname){
		if (qname.equals("username")){
			
			userobj.setUsername(data);
		}else if (qname.equals("password")){
			userobj.setPassword(data);
		}else if (qname.equals("validity")){
			userobj.setValidity(Integer.parseInt(data));
		}else if (qname.equals("User")){
			userlist.add(userobj);
			
		}else if (qname.equals("Person")){
			personobj.setUserlist(userlist);
		}
		

	}
	public void printResults(){
		for (UserModel l : userlist){
			System.out.println(l.toString());
		}
		
	}
}
