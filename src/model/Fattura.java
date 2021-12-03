package model;

import java.util.List;

public class Fattura {
	
	private int numero;
	private Cliente cliente;
	private List<Prodotto> prodotti;
	private double totale;
	
	public Fattura() {

	}

	public Fattura(int numero, Cliente cliente, List<Prodotto> prodotti, double totale) {
		this.cliente = cliente;
		this.prodotti = prodotti;
	}
	
	public Fattura(Cliente cliente, List<Prodotto> prodotti) {
		this.cliente = cliente;
		this.prodotti = prodotti;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}

	@Override
	public String toString() {
		return numero + ":" + cliente + ":" + prodotti + ":" + totale;
	}
}