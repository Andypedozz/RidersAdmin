package model;

import java.util.LinkedList;
import java.util.List;

public class Rider {
	
	private final int id;
	private final String name;
	private String mezzo;
	private boolean libero;
	private List<Order> assignedOrders;
	
	public Rider(int id, String name, String mezzo, boolean libero) {
		this.id = id;
		this.name = name;
		this.mezzo = mezzo;
		this.libero = libero;
		this.assignedOrders = new LinkedList<Order>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMezzo() {
		return mezzo;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public List<Order> getOrders() {
		return this.assignedOrders;
	}

	public void assignOrder(Order order) {
		this.assignedOrders.add(order);
	}

	public void removeOrder(Order order) {
		this.assignedOrders.remove(order);
	}
}
