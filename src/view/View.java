package view;

import controller.Controller;

public class View {
	private Controller controller;
	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	
	public View() {
		this.controller = Controller.getInstance();
		showMainFrame();
	}
	
	public void showLogin() {
		this.loginDialog = new LoginDialog();
	}
	
	public void showMainFrame() {
		this.mainFrame = new MainFrame();
	}
	
}
