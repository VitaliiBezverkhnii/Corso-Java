package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import constants.Constants;
import database.FileDB;
import model.Prodotto;

public class ProdottoService extends ServiceApp {
	
	private String pathDir = Constants.ROOT + Constants.DIVIDER
			+ Constants.DIR_NAME_MARKET + Constants.DIVIDER
			+ Constants.DIR_NAME_MAGAZZINO + Constants.DIVIDER;
	
	private String fileProdotti = Constants.FILE_NAME_PRODOTTI;
	private String fileProdottiVenduti = Constants.FILE_NAME_PRODOTTI_VENDUTI;
	
	public HashMap<Integer, Prodotto> loadProdotti() {
		HashMap<Integer, Prodotto> prodotti = new HashMap<Integer, Prodotto>();
		String path = pathDir + fileProdotti;
		
		List<String> prodottiIn = getDb().read(path);
		
		if(prodottiIn.size() > 0 && prodotti != null) {
		Iterator<String> iterator = prodottiIn.iterator();
		
		while(iterator.hasNext()) {
			String[] values = iterator.next().split("\\|");
			int id = Integer.parseInt(values[0]);
			String marca = values[1];
			String modello = values[2];
			int quantita = Integer.parseInt(values[3]);
			double prezzo = Double.parseDouble(values[4]);
			prodotti.put(id, new Prodotto(id, marca, modello, quantita, prezzo));
		}
		
		}
		return prodotti;
	}
	
	public List<Prodotto> loadProdottiVenduti() {
		List<Prodotto> prodottiVenduti = new ArrayList<Prodotto>();
		
		String path = pathDir + fileProdottiVenduti;
		
		List<String> strings = getDb().read(path);
		
		if(strings.size() > 0) {
		Iterator<String> iterator = strings.iterator();
		
		while(iterator.hasNext()) {
			String[] values = iterator.next().split("\\|");
			int id = Integer.parseInt(values[0]);
			String marca = values[1];
			String modello = values[2];
			int quantita = Integer.parseInt(values[3]);
			double prezzo = Double.parseDouble(values[4]);
			prodottiVenduti.add(new Prodotto(id, marca, modello, quantita, prezzo));
		}
		
		}
		return prodottiVenduti;
	}
	
	public void saveAll(HashMap<Integer, Prodotto> prodotti, List<Prodotto> prodottiVenduti) {
		getDb().write(pathDir, fileProdotti, new ArrayList<Object>(prodotti.values()));
		getDb().write(pathDir, fileProdottiVenduti, new ArrayList<Object>(prodottiVenduti));
	}
}
