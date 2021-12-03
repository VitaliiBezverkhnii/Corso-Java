package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import constants.Constants;
import database.FileDB;
import model.Cliente;
import model.Fattura;
import model.Prodotto;

public class FatturaService extends ServiceApp {
	
	private String pathDir = Constants.ROOT + Constants.DIVIDER
			+ Constants.DIR_NAME_MARKET + Constants.DIVIDER;
	
	private String fileFatture = Constants.FILE_NAME_FATTURE;
	
	public HashMap<Integer, Fattura> loadFatture() {
		
		HashMap<Integer, Fattura> fatture = new HashMap<Integer, Fattura>();
		String path = pathDir + fileFatture;
		
		List<String> prodottiIn = getDb().read(path);
		
		if(prodottiIn.size() > 0 && fatture != null) {
			
		Iterator<String> iterator = prodottiIn.iterator();
		
		while(iterator.hasNext()) {
			String[] values = iterator.next().split(":");
			int numero = Integer.parseInt(values[0]);
			Cliente cliente = parseCliente(values[1]);
			List<Prodotto> prodotti = parseProdotti(values[2]);
			double totale = Double.parseDouble(values[3]);
			fatture.put(numero, new Fattura(numero, cliente, prodotti, totale));
		}
		
		}
		return fatture;
	}
	
	public void saveAll(HashMap<Integer, Fattura> fatture) {
		getDb().write(pathDir, fileFatture, new ArrayList<Object>(fatture.values()));
	}
	
	private Cliente parseCliente(String str) {
		String[] clienteElements = str.split("\\|");
		String ragioneSociale = clienteElements[0];
		String sedeLegale = clienteElements[1];
		String pIva = clienteElements[2];
		return new Cliente(ragioneSociale, sedeLegale, pIva);
	}

	private List<Prodotto> parseProdotti(String str) {
		
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		
		String strProdotti = str;
		strProdotti = strProdotti.substring(1, strProdotti.length() - 1);
		String[] elementsArrayProdotti = strProdotti.split(",");
		
		for(String elementArrayProdotti : elementsArrayProdotti) {
			String[] elementsProdotto = elementArrayProdotti.split("\\|");
			int id = Integer.parseInt(elementsProdotto[0].trim());
			String marca = elementsProdotto[1];
			String modello = elementsProdotto[2];
			int quantita = Integer.parseInt(elementsProdotto[3]);
			double prezzo = Double.parseDouble(elementsProdotto[4]);
			prodotti.add(new Prodotto(id, marca, modello, quantita, prezzo));
		}
		
		return prodotti;
	}
}
