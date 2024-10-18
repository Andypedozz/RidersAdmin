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
		fetchOrders();
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

	public void fetchOrders() {
		try {
			URL url = new URL("http://localhost:3001/orders");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			// Getting the response code
			int responseCode = conn.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: "+ responseCode);
			}else {
				String inline = "";
				Scanner scanner = new Scanner(url.openStream());
				
				// Write all the JSON data into a string
				while(scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				
				scanner.close();
				
				JSONParser parse = new JSONParser();
				JSONArray jsonOrders = (JSONArray) parse.parse(inline);
				List<Order> orders = new LinkedList<Order>();
				for(int i = 0; i < jsonOrders.size(); i++) {
					JSONObject jsonOrder = (JSONObject) jsonOrders.get(i);
					int id = Integer.valueOf((String)jsonOrder.get("id"));
					String restaurant = (String) jsonOrder.get("ristorante");
					String ritiro = (String) jsonOrder.get("ritiro");
					String consegna = (String) jsonOrder.get("consegna");
					String indirizzo = (String) jsonOrder.get("indirizzo");
					Order order = new Order(id, restaurant, ritiro, consegna, indirizzo);
					orders.add(order);
				}
				this.model.loadOrders(orders);
			}
		}catch(Exception e) {
			Global.showWarning("API di caricamento dati non attiva o connessione assente!");
		}
	}
	
	private void readOrdersJson() {
		String fileName = "orders.json";
		JSONParser parser = new JSONParser();

		try {
			FileReader reader = new FileReader(fileName);
			Object obj = parser.parse(reader);
			JSONArray jsonOrders = (JSONArray) obj;
			List<Order> orders = new LinkedList<Order>();
			for(int i = 0; i < jsonOrders.size(); i++) {
				JSONObject jsonOrder = (JSONObject) jsonOrders.get(i);
				int id = Integer.valueOf((String)jsonOrder.get("id"));
				String restaurant = (String) jsonOrder.get("ristorante");
				String ritiro = (String) jsonOrder.get("ritiro");
				String consegna = (String) jsonOrder.get("consegna");
				String indirizzo = (String) jsonOrder.get("indirizzo");
				Order order = new Order(id, restaurant, ritiro, consegna, indirizzo);
				orders.add(order);
			}
			this.model.loadOrders(orders);
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	
	public void removeOrder(Order order) {
		boolean result = this.model.deleteOrder(order);
		if(result) {
			this.model.getOrders().remove(order.getId());
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
