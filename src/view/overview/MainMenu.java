package view.overview;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import controller.Controller;
import view.MyPanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

public class MainMenu extends MyPanel {
	private Controller controller;
	private OrdersAndRidersPanel ordersAndRiders;
	private ConsolePanel console;
	
	public MainMenu() {
		this.controller = Controller.getInstance();
		setLayout(new GridLayout(2, 2, 0, 0));
		
		// adding main panels
		JPanel leftUpper = new JPanel();
		leftUpper.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(leftUpper);
		leftUpper.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel rightUpper = new JPanel();
		rightUpper.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(rightUpper);
		rightUpper.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel leftLower = new JPanel();
		leftLower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(leftLower);
		
		JPanel rightLower = new JPanel();
		rightLower.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(rightLower);
		rightLower.setLayout(new GridLayout(1, 0, 0, 0));
		
		// adding
		ordersAndRiders = new OrdersAndRidersPanel();
		leftUpper.add(ordersAndRiders);
		
		this.console = new ConsolePanel();
		rightLower.add(this.console);
		updateFields();

	}
	
	public OrdersAndRidersPanel getOrdersAndRidersPanel() {
		return this.ordersAndRiders;
	}
	
	public ConsolePanel getConsolePanel() {
		return this.console;
	}

	@Override
	public void updateFields() {
		this.ordersAndRiders.updateFields();
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}