package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Prodotto;
import service.ProdottoService;

public class Magazzino {
	
	private ProdottoService service = new ProdottoService();
	
	private HashMap<Integer, Prodotto> prodotti = service.loadProdotti();
	private List<Prodotto> prodottiVenduti = service.loadProdottiVenduti();

	public void addProdotto(Prodotto prodotto) {
		int id = prodotti.size() + 1;
		prodotto.setId(id);
		prodotti.put(prodotto.getId(), prodotto);
	}
	
	public void removeProdotto(int id) {
		prodotti.remove(id);
	}
	
	public Prodotto getProdotto(int id) {
		return prodotti.get(id);
	}
	
	public List<Prodotto> getProdotti() {
		return new ArrayList<Prodotto>(prodotti.values());
	}
	
	public void addProdottiVenduti(List<Prodotto> prodottiVenduti) {
		this.prodottiVenduti.addAll(prodottiVenduti);
	}
	
	public List<Prodotto> getProdottiVenduti() {
		return prodottiVenduti;
	}
	
	public void saveAll() {
		service.saveAll(prodotti, prodottiVenduti);
	}
	
//	private void getQuantitaProdotto() {
//		HashMap<Integer, Prodotto> tmpProdotti = new HashMap<Integer, Prodotto>();
//		HashMap<Integer, Integer> tmpQuantita = new HashMap<Integer, Integer>();
	//
//		  for (Prodotto prodotto: prodottiVenduti) {
//			  tmpProdotti.put(prodotto.getId(), prodotto);
//			  
//		      if (tmpQuantita.containsKey(prodotto.getId()))
//		    	  tmpQuantita.put(prodotto.getId(), tmpQuantita.get(prodotto.getId()) + 1);
//		      else
//		    	  tmpQuantita.put(prodotto.getId(), 1);
//		  }
//		  Set<Integer> set = tmpQuantita.keySet();
//		  
//		  for(Integer i : set) {
//			  tmpProdotti.get(i).setQuantita(tmpQuantita.get(i));
//		  }
//	}

	
}