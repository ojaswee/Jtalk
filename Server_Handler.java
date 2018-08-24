package Server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Handler extends Thread{
	
	    ServerSocket serverSocket;
		Socket socket;
		
		InputStream inFromClient; 
		DataInputStream inQuestion; 
		
		OutputStream outToClient;
		DataOutputStream outAnswer;
		
		Server_Brain server_ai;
		
		String output;
	   
	   public Server_Handler() throws IOException {
	      serverSocket = new ServerSocket(1000);
	      
	      socket = null;
	      server_ai = new Server_Brain();
	   
	   }

	   public void run() {
		   
		   while(true) {
			   
			   try {
				socket = serverSocket.accept();
				inFromClient = socket.getInputStream();
				inQuestion = new DataInputStream(inFromClient);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			      
			   try {
				outToClient = socket.getOutputStream();
				outAnswer = new DataOutputStream(outToClient);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
			  
			   try {
				output = server_ai.processQuestion(inQuestion.readUTF());
				System.out.printf("Answer is %s \n",output );
				outAnswer.writeUTF(output);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		   }
	   }
	   
	public String getAnswer() throws IOException {
		return output;
	}
	           
}
