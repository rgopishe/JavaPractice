package com.cloudwick.training.json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExample {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONExample jeg = new JSONExample();
		jeg.createJSON();
		jeg.parseJSON();
		jeg.complexJSON();
	}

	public void createJSON() throws IOException {
		JSONObject obj = new JSONObject();
		obj.put("name", "Rakesh");
		obj.put("age", "26");
		JSONArray arr = new JSONArray();
		arr.add("Abc");
		arr.add("Xyz");
		obj.put("aliases", arr);
		FileWriter fw = new FileWriter("input.json");
		fw.write(obj.toJSONString());
		fw.flush();
		fw.close();

	}

	public void parseJSON() throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader fr = new FileReader("input.json");
		Object obj = parser.parse(fr);
		JSONObject jsonObj = (JSONObject) obj;
		System.out.println("Name:" + jsonObj.get("name"));
		System.out.println("Age" + jsonObj.get("age"));

		JSONArray arr = (JSONArray) jsonObj.get("aliases");
		Iterator<String> itr = arr.iterator();
		while (itr.hasNext()) {
			System.out.println("Aliases:" + itr.next());
		}
	}

	public void complexJSON() throws IOException {
		StringWriter writer = new StringWriter();
		JSONObject obj = new JSONObject();
		LinkedHashMap map = new LinkedHashMap();
		LinkedList list = new LinkedList();
		obj.put("name", "Fremont");
		list.add("1");
		list.add("2");
		obj.put("datalist", list);
		map.put("key1", "data1");
		map.put("key2", "data2");
		obj.put("dataMap", map);
		obj.writeJSONString(writer);
		System.out.println("JSON:" + writer.toString());

	}
}
