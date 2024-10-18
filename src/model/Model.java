package model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Model {

	private HashMap<Integer, Order> orders;
	private HashMap<Integer, Rider> riders;
	private HashMap<Integer, Restaurant> restaurants;
	
	public Model() {
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
	public boolean deleteOrder(Order order) {
		boolean result = false;
		try {
			URL url = new URL("http://localhost:3001/orders/delete/"+order.getId());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.connect();
			
			// Getting the response code
			int responseCode = conn.getResponseCode();
			if(responseCode == 200) {
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 *  Deletes the order only from the fetched data
	 */
	public void removeOrder(Order order) {
		this.orders.remove(order.getId());
	}

	public void loadOrders(List<Order> orders) {
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
}
