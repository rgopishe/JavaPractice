package com.cloudwick.training.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Myclient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1",9000);
		OutputStream out = socket.getOutputStream();
		DataOutputStream dataout = new DataOutputStream(out);
		dataout.writeUTF("this is me !!! ");
		InputStream in =socket.getInputStream();
		DataInputStream datain = new DataInputStream(in);
		System.out.println("Data Received:"+datain.readUTF());
		socket.close();

	}

}
