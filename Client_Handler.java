package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_Handler {
	
	Socket socket;
	OutputStream outToServer;
	DataOutputStream outQuestion;
	
	InputStream inFromServer; 
	DataInputStream inAnswer; 
	
	
	public Client_Handler() throws UnknownHostException, IOException {
		System.out.println("I am in client handler");
		socket = new Socket("127.0.0.1",1000);
		outToServer = socket.getOutputStream();
		outQuestion = new DataOutputStream(outToServer);
		
		
		inFromServer = socket.getInputStream();
		inAnswer = new DataInputStream(inFromServer);
	}

	public void setClientQuestion(String cq) {
		try {
			outQuestion.writeUTF(cq);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getServerAnswer() throws IOException {
		
		return  inAnswer.readUTF();
		 
	}
}
