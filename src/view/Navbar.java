package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class Navbar extends JPanel {

	private static final int N_BUTTONS = 4;
	
	private JScrollPane scrollPane;
	private JButton mainMenu;
	private JButton orders;
	private JButton riders;
	private JButton restaurants;
	
	public Navbar() {
		mainMenu = new JButton("Generale");
		orders = new JButton("Ordini");
		riders = new JButton("Rider");
		restaurants = new JButton("Ristoranti");
		
		JPanel contentPanel = new JPanel();
		GridLayout gl_contentPanel = new GridLayout(4, 1);
		gl_contentPanel.setVgap(10);
		contentPanel.setLayout(gl_contentPanel);
		contentPanel.add(mainMenu);
		contentPanel.add(orders);
		contentPanel.add(riders);
		contentPanel.add(restaurants);
		
		scrollPane = new JScrollPane(contentPanel);
		this.add(scrollPane);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	public JButton getOverviewBtn() {
		return this.mainMenu;
	}
	
	public JButton getOrdersBtn() {
		return this.orders;
	}
	
	public JButton getRidersBtn() {
		return this.riders;
	}
	
	public JButton getRestaurantsBtn() {
		return this.restaurants;
	}
}
