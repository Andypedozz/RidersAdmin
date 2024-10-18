package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Global {
	
	public static void showWarning(String message) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, message);
	}
	
	public static void showError(String error) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, error);
	}
	
	public static boolean showConfirm(String message) {
		boolean exit = false;
		JFrame frame = new JFrame();
		int exitValue = JOptionPane.showConfirmDialog(frame, message);
		if(exitValue == 0) {
			exit = true;
		}else {
			exit = false;
		}
		return exit;
	}
	
	public static void showMessage(String message) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, message);
	}
	
}
