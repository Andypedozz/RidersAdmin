package controller;

import java.util.HashMap;
import java.util.List;
import model.Model;
import model.Order;
import model.Restaurant;
import model.Rider;
import view.View;

public class Controller {
	private static Controller INSTANCE;
	private Model model;
	private View view;
	
	private Controller() {}
	
	public static Controller getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Controller();
		}
		return INSTANCE;
	}
	
	public void start() {
		this.model = new Model();
		this.model.setApiMode(false);
		this.model.loadOrdersData();
		this.model.loadRidersData();
		this.model.loadRestaurantsData();
		this.view = new View();
	}
	
	public HashMap<Integer, Order> getOrders() {
		return this.model.getOrders();
	}
	
	public HashMap<Integer, Rider> getRiders() {
		return this.model.getRiders();
	}
	
	public HashMap<Integer, Restaurant> getRestaurants() {
		return this.model.getRestaurants();
	}
	
	public List<Rider> getFreeRiders() {
		return this.model.getFreeRiders();
	}
	
	public void loadOrders() {
		this.model.loadOrdersData();
	}
	
	public void removeOrder(Order order) {
		boolean result = this.model.removeOrder(order);
	}

	public void setCompleted(Order order) {
		Order order1 = this.model.getOrder(order.getId());
		order1.setCompleted(true);
	}
	
}
