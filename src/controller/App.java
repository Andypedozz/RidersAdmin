package controller;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controller controller = Controller.getInstance();
		controller.start();
	}
}
