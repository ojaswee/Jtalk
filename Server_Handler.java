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
		
		Server_Brain server_ai;
		

	   
	   public Server_Handler() throws IOException {
	      serverSocket = new ServerSocket(1000);
	      
	      socket = null;
	      server_ai = new Server_Brain();
	   
	      
	      checkQuestion();
		   
		  socket.close();
		  serverSocket.close();
	   }

	   public void checkQuestion() throws IOException {
		   
		   while(true) {
			   
			   socket = serverSocket.accept();
			      
			   inFromClient = socket.getInputStream();
			   inQuestion = new DataInputStream(inFromClient);
			      
			      
			   outToClient = socket.getOutputStream();
	           outAnswer = new DataOutputStream(outToClient);
			  
			   outAnswer.writeUTF(server_ai.processQuestion(inQuestion.readUTF()));
		  
		   }
	   }
	           
}
