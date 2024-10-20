package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controller.Controller;
import view.orders.PanelOrders;
import view.overview.FirstMenu;
import view.overview.MainMenu;
import view.restaurants.PanelRestaurants;
import view.riders.PanelRiders;

public class View extends JFrame {
	private Controller controller;
	private TopToolbar toolbar;
	private Navbar navbar;
	private JPanel contentPanel;
	private MainMenu mainMenu;
	private PanelOrders ordersMenu;
	private PanelRiders ridersMenu;
	private PanelRestaurants restaurantsMenu;
	
	public View() {
		this.controller = Controller.getInstance();
		this.setTitle("RidersApp");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1200,900);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		getContentPanel().setLayout(new GridLayout(1,1));
		this.getContentPane().setLayout(new BorderLayout());
		
		toolbar = new TopToolbar();
		this.getContentPane().add(toolbar, BorderLayout.NORTH);
		this.getContentPane().add(getNavbar(), BorderLayout.WEST);
		this.getContentPane().add(getContentPanel(), BorderLayout.CENTER);
		this.mainMenu();
		initListeners();
	}
	
	private void initListeners() {
		this.navbar.getOverviewBtn().addActionListener(e -> {
			mainMenu();
		});
		
		this.navbar.getOrdersBtn().addActionListener(e -> {
			ordersMenu();
		});
		
		this.navbar.getRidersBtn().addActionListener(e -> {
			ridersMenu();
		});
		
		this.navbar.getRestaurantsBtn().addActionListener(e -> {
			restaurantsMenu();
		});
	}
	
	public void firstMenu() {
		this.setScreen(new FirstMenu());
	}
	
	public void mainMenu() {
		this.mainMenu = new MainMenu();
		this.setScreen(this.mainMenu);
	}
	
	public void ordersMenu() {
		this.ordersMenu = new PanelOrders();
		this.setScreen(this.ordersMenu);
	}
	
	public void ridersMenu() {
		this.ridersMenu = new PanelRiders();
		this.setScreen(this.ridersMenu);
	}
	
	public void restaurantsMenu() {
		this.restaurantsMenu = new PanelRestaurants();
		this.setScreen(this.restaurantsMenu);
	}
	
	private void setScreen(JPanel panel) {
		this.contentPanel.removeAll();
		this.contentPanel.add(panel);
		this.revalidate();
	}
	
	public MainMenu getMainMenu() {
		return this.mainMenu;
	}
	
	private Navbar getNavbar() {
		if(this.navbar == null) {
			this.navbar = new Navbar();
		}
		return this.navbar;
	}
	
	private JPanel getContentPanel() {
		if(this.contentPanel == null) {
			this.contentPanel = new JPanel();
		}
		return this.contentPanel;
	}
}
