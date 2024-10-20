package model;

import java.util.LinkedList;
import java.util.List;

public class Restaurant {

	private int id;
	private String name;
	private String indirizzo;
	private List<Prodotto> prodotti;
	
	public Restaurant(int id, String name, String indirizzo) {
		super();
		this.id = id;
		this.name = name;
		this.indirizzo = indirizzo;
		this.prodotti = new LinkedList<Prodotto>();
	}
	
	public Restaurant(int id, String name, String indirizzo, List<Prodotto> prodotti) {
		super();
		this.id = id;
		this.name = name;
		this.indirizzo = indirizzo;
		this.prodotti = prodotti;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}
}
