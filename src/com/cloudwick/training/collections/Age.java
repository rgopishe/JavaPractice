package com.cloudwick.training.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Age {

	List<String> list = new ArrayList<String>();
	Map<String, Integer> map = new HashMap<String, Integer>();

	private void readContent(String fileName) throws IOException {

		FileReader fr = null;
		BufferedReader bfr = null;
		fr = new FileReader(fileName);
		bfr = new BufferedReader(fr, 50);
		String data = null;
		while ((data = bfr.readLine()) != null) {
			String[] result = data.split(",");
			if (Integer.parseInt(result[4]) >= 20) {
				list.add(result[3]);
			}
		
		}

		//System.out.println(list);

		for (String state : list) {
			// Integer count = map.get(state);
			if (map.containsKey(state))
				map.put(state, map.get(state) + 1);
			else
				map.put(state, 1);
		}

		writeFile(map);

		fr.close();
		bfr.close();

	}

	public static void writeFile(Map<String, Integer> map) throws IOException {
		FileWriter fw = new FileWriter("Age_Output.txt");
		BufferedWriter writer = new BufferedWriter(fw);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			/*
			 * System.out.println("Key : " + entry.getKey() + " Value : " +
			 * entry.getValue());
			 */

			String out = entry.getKey() + "    " + entry.getValue();
			writer.write(out + "\n");
			writer.flush();
		}
		fw.close();
		writer.close();

	}

	/*
	 * private void writeContent(String file) throws IOException { FileWriter fw
	 * = new FileWriter(file); BufferedWriter writer = new BufferedWriter(fw);
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {

		Age rw = new Age();
		rw.readContent("C:/Users/raki2481/Desktop/Age_Details.txt");
	}

}
