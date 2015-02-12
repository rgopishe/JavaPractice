package com.cloudwick.training.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamExample {

	private void createMyFile(String fileName) throws DuplicateFileException,
			IOException {
		File obj = new File(fileName);
		if (obj.exists()) {
			throw new DuplicateFileException("Please provide file name");
		} else {
			obj.createNewFile();
		}
	}

	private void writeContent(String file) {
		FileOutputStream fos = null;
		String data = "I live in Charlotte";
		try {
			fos = new FileOutputStream(file);
			fos.write(data.getBytes());
			fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void readContent(String fileName) throws IOException {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		fis = new FileInputStream(fileName);
		bis = new BufferedInputStream(fis,50);
		int data =0;
		while((data =bis.read())!=-1){
			System.out.print((char)data);
			
		}
		bis.close();
		fis.close();
		
	}

	public static void main(String[] args) throws DuplicateFileException,
			IOException {
		// TODO Auto-generated method stub
		FileStreamExample inp = new FileStreamExample();
		// inp.createMyFile("input.txt");
		//inp.writeContent("input.txt");
		inp.readContent("input.txt");
	}

}
