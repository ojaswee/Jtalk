package Server;


import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Server_UI {

	JFrame frame;
	private JTextField textFieldClientOutput;
	
	Server_Handler serverHandler;
	
	public Server_UI() throws IOException {
		initialize();
		activateComponents();
	}
	
	private void initialize() throws IOException {	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldClientOutput = new JTextField();
		textFieldClientOutput.setEnabled(true);
		textFieldClientOutput.setEditable(false);
		textFieldClientOutput.setText("Output");
		textFieldClientOutput.setBounds(12, 127, 408, 100);
		frame.getContentPane().add(textFieldClientOutput);
		textFieldClientOutput.setColumns(10);

	}
	private void activateComponents() throws IOException {
		serverHandler = new Server_Handler();
	}
}
