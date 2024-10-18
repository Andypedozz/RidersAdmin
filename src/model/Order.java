package model;

import java.util.List;

public class Order {
	private final int id;
	private final String ristorante;
	private String ritiro;
	private String consegna;
	private String indirizzo;
	private boolean completed;
	private List<Prodotto> listaProdotti;
	
	public Order(int id, String ristorante, String ritiro, String consegna, String indirizzo) {
		super();
		this.id = id;
		this.ristorante = ristorante;
		this.ritiro = ritiro;
		this.consegna = consegna;
		this.indirizzo = indirizzo;
		this.completed = false;
	}
	
	public Order(int id, String ristorante, String ritiro, String consegna, String indirizzo, boolean completed) {
		super();
		this.id = id;
		this.ristorante = ristorante;
		this.ritiro = ritiro;
		this.consegna = consegna;
		this.indirizzo = indirizzo;
		this.completed = completed;
	}
	
	public List<Prodotto> getListaProdotti() {
		return this.listaProdotti;
	}

	public int getId() {
		return id;
	}

	public String getRistorante() {
		return ristorante;
	}

	public String getRitiro() {
		return ritiro;
	}

	public String getConsegna() {
		return consegna;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setRitiro(String ritiro) {
		this.ritiro = ritiro;
	}

	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		return this.id == ((Order) obj).getId();
	}

	public boolean isCompleted() {
		return this.completed;
	}

	public void setCompleted(boolean b) {
		this.completed = b;
	}
}
