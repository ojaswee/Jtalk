package Server;


public class Server_Home {

	public static void main(String[] args) {
		try {
			Server_UI window = new Server_UI();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
