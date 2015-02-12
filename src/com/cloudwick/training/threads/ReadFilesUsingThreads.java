package com.cloudwick.training.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFilesUsingThreads extends Thread {
	ArrayList<String> list = new ArrayList<String>();

	public void listFilesForFolder(File folder) {
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				// System.out.println("file entries : "+fileEntry);
				listFilesForFolder(fileEntry);
			} else if (fileEntry.isFile()) {
				// System.out.println(fileEntry.getName());
				// System.out.println("files names : "+fileEntry.getAbsolutePath());
				list.add(fileEntry.getAbsolutePath());
			}

		}

	}

	public void run() {
		FileReader fr = null;
		BufferedReader bfr = null;
		for (int i =0; i<list.size();i++){
		try {
			fr = new FileReader(list.get(i));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bfr = new BufferedReader(fr, 50);
		String data = null;
		try {
			while ((data = bfr.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	public static void main(String[] args) {
		ReadFilesUsingThreads obj = new ReadFilesUsingThreads();
		File folder = new File("C:/Users/raki2481/Desktop/Read_Thread");
		obj.listFilesForFolder(folder);
		System.out.println(obj.list);

		for (int i = 0; i < obj.list.size(); i++) {
			int t = obj.list.size();

			ReadFilesUsingThreads obj1 = new ReadFilesUsingThreads();
			obj1.start();

		}
		System.out.println("Thread:" + Thread.currentThread());
	}

}
