package com.cloudwick.training.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CaliforniaNames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader bfr = null;
		// String first_name = null;
		// String last_name = null;

		fr = new FileReader("C:/Users/raki2481/Desktop/names.txt");
		bfr = new BufferedReader(fr, 50);
		String data = null;
		FileWriter fw = new FileWriter("output.txt");
		BufferedWriter writer = new BufferedWriter(fw);

		while ((data = bfr.readLine()) != null) {
			String[] result = data.split(",");
			if (result[3].contains("94536")) {
				// first_name = result[1];
				// last_name = result[2];
				String total = result[1] + "," + result[2];
				// System.out.println("total is :" + total);
				writer.write(total + "\n");
				writer.flush();

			}

		}
		writer.close();
		fw.close();
		fr.close();
		bfr.close();

	}

}
