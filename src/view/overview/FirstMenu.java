package view.overview;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FirstMenu extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	public FirstMenu() {
		setLayout(null);
		
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
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(258, 371, 89, 23);
		add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(21, 524, 89, 23);
		add(btnRegister);
		
		JButton btnForgotYourPassword = new JButton("Forgot your password?");
		btnForgotYourPassword.setBounds(374, 524, 191, 23);
		add(btnForgotYourPassword);
		
	}
}
