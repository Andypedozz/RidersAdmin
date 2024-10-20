package model;

import java.util.LinkedList;
import java.util.List;

public class Order {
	private final int id;
	private String nomeCognome;
	private final String ristorante;
	private String ritiro;
	private String consegna;
	private String indirizzo;
	private int cap;
	private String email;
	private String tel;
	private boolean completed;
	private List<Prodotto> listaProdotti;
	private String note;
	
	public Order(int id, String nomeCognome, String ristorante, String ritiro, String consegna, String indirizzo, int cap, String email, String tel, List<Prodotto> prodotti, String note, boolean completed) {
		this.id = id;
		this.nomeCognome = nomeCognome;
		this.ristorante = ristorante;
		this.ritiro = ritiro;
		this.consegna = consegna;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.email = email;
		this.tel = tel;
		this.listaProdotti = prodotti;
		this.note = note;
		this.completed = completed;
	}
	
	
	
	public String getNomeCognome() {
		return nomeCognome;
	}

	public int getCap() {
		return cap;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
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
	
	public String getNote() {
		return this.note;
	}
}
