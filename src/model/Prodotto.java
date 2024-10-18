package model;

public class Prodotto {
	private String name;
	private int quantita;
	private double prezzo;
	
	public Prodotto(String name, int quantita, double prezzo) {
		super();
		this.name = name;
		this.quantita = quantita;
		this.prezzo = prezzo;
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
}
