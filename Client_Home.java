package Client;

public class Client_Home {

	public static void main(String[] args) {
		try {
			Client_UI window = new Client_UI();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
