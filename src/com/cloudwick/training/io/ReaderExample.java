package com.cloudwick.training.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader bfr = null;
		//BufferedWriter bwr = null;
		//String text  = "I live in Charlotte";

		fr = new FileReader("input.txt");
		bfr = new BufferedReader(fr, 50);
		String data = null;
		while ((data = bfr.readLine()) != null) {
			System.out.println(data);
		}
		fr.close();
		bfr.close();

	}

}
