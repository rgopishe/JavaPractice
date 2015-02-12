package com.cloudwick.training.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressionExample {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fos = new FileOutputStream("USer.zip");
		ZipOutputStream zip = new ZipOutputStream(fos);
		ZipEntry entry = new ZipEntry("input.txt");
		zip.putNextEntry(entry);
		FileInputStream fis = new FileInputStream("input.txt");
		int data =0;
		while((data =fis.read())!=-1){
			//System.out.print((char)data);
			zip.write(data);
			
		}
		fis.close();
		zip.closeEntry();
		zip.close();
	}

}
