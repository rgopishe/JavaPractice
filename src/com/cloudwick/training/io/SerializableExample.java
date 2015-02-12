package com.cloudwick.training.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		SerializableExample  ser = new SerializableExample();
		ser.serializeData();	
		ser.deserializeData();

	}
	
	private void serializeData() throws IOException{
		UserSerialize obj = new UserSerialize();
		obj.setSsn(1234);
		obj.setName("Fremont");
		
		FileOutputStream fos = new FileOutputStream("Serialize.txt");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(obj);
		fos.flush();
		fos.close();
		out.close();
	}




private void deserializeData() throws IOException, ClassNotFoundException{
	
	FileInputStream fis = new FileInputStream("Serialize.txt");
	ObjectInputStream oin = new ObjectInputStream(fis);
	Object O = oin.readObject();
	if (O instanceof UserSerialize){	
	
	
	System.out.println(((UserSerialize) O).getName());
	System.out.println(((UserSerialize) O).getSsn());
	}
	
	fis.close();
	oin.close();
}

}