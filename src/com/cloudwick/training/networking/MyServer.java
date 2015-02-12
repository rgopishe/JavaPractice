package com.cloudwick.training.networking;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer extends Thread {

	private ServerSocket server;

	public MyServer(int port) throws IOException {
		server = new ServerSocket(port);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyServer server = new MyServer(9000);
		server.start();

	}

	public void run() {

		while(true){
			try {
				Socket sock = server.accept();
				InputStream in = sock.getInputStream();
				DataInputStream data = new DataInputStream(in);
				System.out.println("Conn Received:"+data.readUTF());
				OutputStream out = sock.getOutputStream();
				DataOutputStream dataout = new DataOutputStream(out);
				dataout.writeUTF("Thanks token is 21");
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
