package model;

public class Prodotto {
	private int id;
	private String name;
	private int quantita;
	private double prezzo;
	private String descrizione;
	
	public Prodotto(int id, String name, int quantita, double prezzo) {
		this.id = id;
		this.name = name;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	public Prodotto(int id, String name, double prezzo, String descrizione) {
		this.id = id;
		this.name = name;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescrizione() {
		return this.descrizione;
	}
}
