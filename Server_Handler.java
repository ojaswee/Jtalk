package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Handler {
	
	    ServerSocket serverSocket;
		Socket socket;
		
		InputStream inFromClient; 
		DataInputStream inQuestion; 
		
		OutputStream outToClient;
		DataOutputStream outAnswer;
		

	   
	   public Server_Handler() throws IOException {
	      serverSocket = new ServerSocket(1000);
	      socket = serverSocket.accept();
	      
	      inFromClient = socket.getInputStream();
	      inQuestion = new DataInputStream(inFromClient);
	      
	      
	      outToClient = socket.getOutputStream();
	      outAnswer = new DataOutputStream(outToClient);
	      
	      checkQuestion();
	   }

	   public void checkQuestion() throws IOException {
		   
		   while(true) {
			   System.out.println("inside checkquestion");
			   System.out.println(inQuestion.readUTF());
			   outAnswer.writeChars("hello from server");
		   }
		  
		   
	   }
	           
}
