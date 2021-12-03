package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import constants.Constants;
import model.Cliente;
import model.Fattura;
import model.Prodotto;
import service.ClienteService;
import service.FatturaService;

public class Market {
	
	private FatturaService fatturaService = new FatturaService();
	private ClienteService clienteService = new ClienteService();
	
	
	private HashMap<Integer, Fattura> fatture = fatturaService.loadFatture();
	private HashMap<String, Cliente> clienti = clienteService.loadClienti();
	
	public void init() {
		String pathDirMarket = Constants.ROOT + Constants.DIVIDER
				+ Constants.DIR_NAME_MARKET;
		File direcoryMarket = new File(pathDirMarket);
		
		if(!direcoryMarket.exists()) {
			direcoryMarket.mkdir();
		}
	}
	
	public void addCliente(Cliente cliente) {
		clienti.put(cliente.getpIVA(), cliente);
	}
	
	public Cliente getCliente(String id) {
		return clienti.get(id);
	}
	
	public HashMap<String, Cliente> getClienti() {
		return clienti;
	}
	
	public void addFattura(Fattura fattura) {
		int numeroFattura = fatture.size() + 1;
		double totale = getTotale(fattura.getProdotti());
		fattura.setNumero(numeroFattura);
		fattura.setTotale(totale);
		fatture.put(fattura.getNumero(), fattura);
	}
	
	public HashMap<Integer, Fattura> getFatture() {
		return fatture;
	}
	
	public void saveAll() {
		fatturaService.saveAll(fatture);
		clienteService.saveAll(clienti);
	}
	
	public List<String> getOpzioni() {
		List<String> opzioni = new ArrayList<String>();
		opzioni.add("[0] - Esci");
		opzioni.add("[1] - Crea Prodotto");
		opzioni.add("[2] - Crea Cliente");
		opzioni.add("[3] - Crea Fattura");
		opzioni.add("[4] - Visualizza Prodotti");
		opzioni.add("[5] - Visualizza Prodotti Venduti");
		opzioni.add("[6] - Visualizza Clienti");
		opzioni.add("[7] - Visualizza Fatture");
		opzioni.add("[8] - Salva tutto");
		return opzioni;
	}
	
	private double getTotale(List<Prodotto> prodotti) {
		double totale = 0;
		double totaleIVA = 0;
		int iva = 22;
		
		for(Prodotto prodotto : prodotti) {
			totale = totale + (prodotto.getPrezzo() * prodotto.getQuantita());
		}
		totaleIVA = (totale / 100) * iva;
		totale = totale + totaleIVA;
		return totale;
	}
}
