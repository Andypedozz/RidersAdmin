package model;

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

import controller.Global;

public class Model {

	private HashMap<Integer, Order> orders;
	private HashMap<Integer, Rider> riders;
	private HashMap<Integer, Restaurant> restaurants;
	private boolean apiMode;
	
	public Model() {
		this.apiMode = true;
		this.orders = new HashMap<Integer, Order>();
		this.riders = new HashMap<Integer, Rider>();
		this.restaurants = new HashMap<Integer, Restaurant>();
	}
	
	public HashMap<Integer, Order> getOrders() {
		return this.orders;
	}

	public void assignOrder(Order order, Rider rider) {
		// TODO Auto-generated method stub
		if(order != null && rider != null) {
			rider.assignOrder(order);
		}
	}

	public HashMap<Integer, Rider> getRiders() {
		return this.riders;
	}

	public HashMap<Integer,Restaurant> getRestaurants() {
		return this.restaurants;
	}

	public List<Rider> getFreeRiders() {
		List<Rider> freeRiders = new LinkedList<Rider>();
		this.riders.forEach((id,rider) -> {
			if(rider.isLibero()) {
				freeRiders.add(rider);
			}
		});
		return freeRiders;
	}
	
	/**
	 * 	Deletes the order from the shared API Db
	 */
	public boolean removeOrder(Order order) {
		boolean result = false;
		if(apiMode) {
			try {
				URL url = new URL("http://localhost:3001/orders/delete/"+order.getId());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.connect();
				
				// Getting the response code
				int responseCode = conn.getResponseCode();
				if(responseCode == 200) {
					result = true;
					this.orders.remove(order.getId());
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			this.orders.remove(order.getId());
			result = true;
		}
		return result;
	}
	
	private void loadOrders(List<Order> orders) {
		orders.forEach((order) -> {
			this.orders.put(order.getId(), order);
		});
	}

	public void loadRestaurants(List<Restaurant> restaurants) {
		restaurants.forEach((restaurant) -> {
			this.restaurants.put(restaurant.getId(), restaurant);
		});
	}

	public void loadRiders(List<Rider> riders) {
		riders.forEach((rider) -> {
			this.riders.put(rider.getId(), rider);
		});
	}

	public Order getOrder(int id) {
		return this.orders.get(id);
	}
	
	public boolean isApiMode() {
		return this.apiMode;
	}
	
	public void setApiMode(boolean b) {
		this.apiMode = b;
	}
	

	public void loadOrdersData() {
		if(this.apiMode) {
			fetchOrders();
		}else {
			readOrdersJson();
		}
	}
	
	private void fetchOrders() {
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
				loadOrders(orders);
			}
		}catch(Exception e) {
			Global.showWarning("API di caricamento dati non attiva o connessione assente!");
		}
	}
	
	private void readOrdersJson() {
		String fileName = "resources\\db\\orders.json";
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
				JSONArray productsOrder = (JSONArray) jsonOrder.get("prodotti");
				List<Prodotto> prodotti = new LinkedList<Prodotto>();
				for(int j = 0; j < productsOrder.size(); j++) {
					JSONObject product = (JSONObject) productsOrder.get(j);
					int idProdotto = Integer.parseInt((String) product.get("id"));
					String nome = (String) product.get("nome");
					int quantita = Integer.valueOf((String) product.get("quantita"));
					double prezzo = Double.parseDouble((String) product.get("prezzo"));
					Prodotto prodotto = new Prodotto(idProdotto, nome, quantita, prezzo);
					prodotti.add(prodotto);
				}
				String note = (String) jsonOrder.get("note");
				Order order = new Order(id, restaurant, ritiro, consegna, indirizzo, false, prodotti,note);
				orders.add(order);
			}
			loadOrders(orders);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void loadRidersData() {
		if(this.apiMode) {
			fetchRiders();
		}else {
			readRidersJson();
		}
	}
	
	public void loadRestaurantsData() {
		if(this.apiMode) {
			fetchRestaurants();
		}else {
			readRestaurantsJson();
		}
	}

	private void fetchRestaurants() {
		
	}

	private void fetchRiders() {
		
	}
	
	private void readRidersJson() {
		String fileName = "resources\\db\\riders.json";
		JSONParser parser = new JSONParser();

		try {
			FileReader reader = new FileReader(fileName);
			Object obj = parser.parse(reader);
			JSONArray jsonRiders = (JSONArray) obj;
			List<Rider> riders = new LinkedList<Rider>();
			for(int i = 0; i < jsonRiders.size(); i++) {
				JSONObject jsonRider = (JSONObject) jsonRiders.get(i);
				int id = Integer.valueOf((String)jsonRider.get("id"));
				String nome = (String) jsonRider.get("nome");
				String mezzo = (String) jsonRider.get("mezzo");
				boolean libero = Boolean.valueOf((String) jsonRider.get("libero"));
				Rider rider = new Rider(id, nome, mezzo, libero);
				riders.add(rider);
			}
			loadRiders(riders);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readRestaurantsJson() {
		String fileName = "resources\\db\\restaurants.json";
		JSONParser parser = new JSONParser();

		try {
			FileReader reader = new FileReader(fileName);
			Object obj = parser.parse(reader);
			JSONArray jsonRestaurants = (JSONArray) obj;
			List<Restaurant> restaurants = new LinkedList<Restaurant>();
			for(int i = 0; i < jsonRestaurants.size(); i++) {
				JSONObject jsonRestaurant = (JSONObject) jsonRestaurants.get(i);
				int idRistorante = Integer.valueOf((String)jsonRestaurant.get("id"));
				String name = (String) jsonRestaurant.get("nome");
				String indirizzo = (String) jsonRestaurant.get("indirizzo");
				JSONArray productsOrder = (JSONArray) jsonRestaurant.get("prodotti");
				List<Prodotto> prodotti = new LinkedList<Prodotto>();
				for(int j = 0; j < productsOrder.size(); j++) {
					JSONObject product = (JSONObject) productsOrder.get(j);
					int idProdotto = Integer.valueOf((String) product.get("id"));
					String nome = (String) product.get("nome");
					double prezzo = Double.parseDouble((String) product.get("prezzo"));
					String descrizione = (String) product.get("descrizione");
					Prodotto prodotto = new Prodotto(idProdotto, nome, prezzo, descrizione);
					prodotti.add(prodotto);
				}
				Restaurant restaurant = new Restaurant(idRistorante, name, indirizzo, prodotti);
				restaurants.add(restaurant);
			}
			loadRestaurants(restaurants);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
