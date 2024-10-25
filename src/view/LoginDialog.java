package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;

public class LoginDialog extends JFrame {
	private Controller controller;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnRegister;
	private JButton btnForgotYourPassword;
	
	public LoginDialog() {
		this.controller = Controller.getInstance();
		setSize(600,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("Login");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(273, 64, 46, 14);
		add(lblTitle);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(247, 134, 100, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(247, 253, 100, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(209, 170, 176, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 288, 176, 20);
		add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(258, 371, 89, 23);
		add(btnLogin);
		
		btnRegister = new JButton("Registrati");
		btnRegister.setBounds(21, 524, 89, 23);
		add(btnRegister);
		
		btnForgotYourPassword = new JButton("Password dimenticata?");
		btnForgotYourPassword.setBounds(374, 524, 191, 23);
		add(btnForgotYourPassword);
		
		setVisible(true);
		initListeners();
	}
	
	private void initListeners() {
		this.btnLogin.addActionListener(e -> {
			
		});
		
		this.btnRegister.addActionListener(e -> {
			
		});
	}
	
}
