package Server;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server_UI {

	JFrame frame;
	public JTextArea textFieldServer;
	
	public Server_UI() throws IOException, InterruptedException {
		initialize();
		activateComponents();
	}
	
	private void initialize() throws IOException {	
		frame = new JFrame("Server");
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldServer = new JTextArea();
		textFieldServer.setEnabled(true);
		textFieldServer.setEditable(false);
		textFieldServer.setText("Output");
		textFieldServer.setBounds(12, 12, 408, 250);
		frame.getContentPane().add(textFieldServer);
		//textFieldServer.setColumns(10);

	}
	private void activateComponents() throws IOException, InterruptedException {
		Thread serverHandler = new Server_Handler(this);
		serverHandler.start();
	}
   
}
