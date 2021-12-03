package model;

public class Prodotto {
	
	private int id; 
	private String marca;
	private String modello;
	private int quantita;
	private double prezzo;
	
	
	public Prodotto() {
		
	}

	public Prodotto(int id, String marca, String modello, int quantita, double prezzo) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	public Prodotto(String marca, String modello, int quantita, double prezzo) {
		this.marca = marca;
		this.modello = modello;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
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

	@Override
	public String toString() {
		return id + "|" + marca + "|" + modello + "|" + quantita + "|" + prezzo;
	}
}
	
	
