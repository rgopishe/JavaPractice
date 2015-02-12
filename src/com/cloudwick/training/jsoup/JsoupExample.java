package com.cloudwick.training.jsoup;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupExample {

	
	public final static Logger log = Logger.getLogger(JsoupExample.class);
	/*Parsing HTML Links */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure("cloudwick.properties");
		
		
		log.debug("Get message for parsing");
		Document doc = (Document) Jsoup.connect("http://google.com").get();
		String title = doc.title();
		//System.out.println("Title :"+title);
		//System.out.println("HTML :"+doc.html());
		
		//Fetch hyperlinks
		
		Elements links = doc.select("a[href]");
		for (Element el : links){
			//System.out.println( "Link:" +el.attr("href"));
			//System.out.println("Link Text values:"+el.text());
			log.info("Link:" +el.attr("href"));
			
		}
		
		//Fetching all the images
		//~ is given coz u ll get a value from the src.... to convert that value to regular expression v give "~"
		
		Elements el2 = doc.select("img[src~=(?i)\\.(png|jpeg|gif|jpg)]");
		
		for (Element ele : el2){
			//System.out.println("source :"+ele.attr("src"));
			//System.out.println("height :"+ele.attr("height"));
			//System.out.println("height :"+ele.attr("width"));
			log.info("source :"+ele.attr("src"));
			
		}
	}

}
