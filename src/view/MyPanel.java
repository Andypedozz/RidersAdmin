package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class MyPanel extends JPanel {
	
	private JPanel contentPane;
	
	public abstract void updateFields();
	public abstract void save();
	public abstract void clear();
	
	public MyPanel() {
		this.setLayout(new BorderLayout());
		this.contentPane = new JPanel();
		this.add(contentPane);
	}
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void setTitle(String title) {
		JLabel lblTitle = new JLabel(title);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.add(lblTitle, BorderLayout.NORTH);
	}
	
}
