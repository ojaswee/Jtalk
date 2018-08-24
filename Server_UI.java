package Server;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Server_UI {

	JFrame frame;
	private JTextField textFieldServer;
	
	public Server_UI() throws IOException, InterruptedException {
		initialize();
		activateComponents();
	}
	
	private void initialize() throws IOException {	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldServer = new JTextField();
		textFieldServer.setEnabled(true);
		textFieldServer.setEditable(false);
		textFieldServer.setText("Output");
		textFieldServer.setBounds(12, 12, 408, 250);
		frame.getContentPane().add(textFieldServer);
		//textFieldServer.setColumns(10);

	}
	private void activateComponents() throws IOException, InterruptedException {
		Thread serverHandler = new Server_Handler();
		serverHandler.start();
		serverHandler.join();
	}

}
