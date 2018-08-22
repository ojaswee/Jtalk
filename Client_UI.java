package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Client_UI {
	

	JFrame frame;
	private JTextField textFieldClientInput;
	private JTextField textFieldClientOutput;
	private JButton btnClientSubmit;
	
	Client_Handler clientHandler; 
	
	
	
	public Client_UI() throws UnknownHostException, IOException {
		initialize();
		activateComponents();
		
		clientHandler = new Client_Handler();
	}
	
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldClientInput = new JTextField();
		textFieldClientInput.setText("hello from client");
		textFieldClientInput.setBounds(12, 13, 408, 100);
		frame.getContentPane().add(textFieldClientInput);
		textFieldClientInput.setColumns(10);
		
		textFieldClientOutput = new JTextField();
		textFieldClientOutput.setEnabled(false);
		textFieldClientOutput.setEditable(false);
		textFieldClientOutput.setText("Output");
		textFieldClientOutput.setBounds(12, 127, 408, 100);
		frame.getContentPane().add(textFieldClientOutput);
		textFieldClientOutput.setColumns(10);
		
		btnClientSubmit = new JButton("Submit");
		btnClientSubmit.setBounds(34, 246, 97, 25);
		frame.getContentPane().add(btnClientSubmit);
		
	}
	private void activateComponents() {

		
		btnClientSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					submitButtonClicked();
				} catch (Exception e1) {
					System.out.println("Error in connction");
					e1.printStackTrace();
				}
			}
		});
		
	}

	public void submitButtonClicked() throws IOException {
		String clientQuestion = textFieldClientInput.getText();
		
		clientHandler.setClientQuestion(clientQuestion);
		
	}

}
