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
	private PanelOrdersAndRiders ordersAndRiders;
	private ConsolePanel console;
	
	public MainMenu() {
		this.controller = Controller.getInstance();
		this.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		// adding main panels
		JPanel leftUpper = new JPanel();
		this.getContentPane().add(leftUpper);
		leftUpper.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel rightUpper = new JPanel();
		this.getContentPane().add(rightUpper);
		rightUpper.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel leftLower = new JPanel();
		this.getContentPane().add(leftLower);
		
		JPanel rightLower = new JPanel();
		this.getContentPane().add(rightLower);
		rightLower.setLayout(new GridLayout(1, 0, 0, 0));
		
		// adding
		ordersAndRiders = new PanelOrdersAndRiders();
		leftUpper.add(ordersAndRiders);
		
		this.console = new ConsolePanel();
		rightLower.add(this.console);
		updateFields();

	}
	
	public PanelOrdersAndRiders getOrdersAndRidersPanel() {
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
