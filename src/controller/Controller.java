package controller;

import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
		fetchRiders();
		this.view = new View();
	}
	
	private void fetchRiders() {
		List<Rider> riders = new LinkedList<Rider>();
		riders.add(new Rider(0, "Andrea", "Auto", true));
		riders.add(new Rider(1, "Luca", "Scooter", true));
		riders.add(new Rider(2, "Gianmarco", "Moto", true));
		riders.add(new Rider(3, "Federica", "Mono", true));
		riders.add(new Rider(4, "Giacomo", "Bici", true));
		riders.add(new Rider(5, "Lucia", "Auto", true));
		riders.add(new Rider(6, "Giulio", "Auto", true));
		riders.add(new Rider(7, "Maria", "Scooter", true));
		riders.add(new Rider(8, "Francesco", "Auto", true));
		riders.add(new Rider(9, "Mattia", "Moto", true));
		this.model.loadRiders(riders);
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
		if(result) {
			this.view.getMainMenu().getConsolePanel().append("Deleted order "+order.getId());
		}else {
			this.view.getMainMenu().getConsolePanel().append("Error in HTTP delete request");
		}
	}

	public void setCompleted(Order order) {
		Order order1 = this.model.getOrder(order.getId());
		order1.setCompleted(true);
		this.view.getMainMenu().getConsolePanel().append("Set order "+order.getId()+" as completed");
	}
	
}
