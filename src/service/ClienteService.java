package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import constants.Constants;
import database.FileDB;
import model.Cliente;
import model.Prodotto;

public class ClienteService extends ServiceApp {
	
	private String pathDir = Constants.ROOT + Constants.DIVIDER
			+ Constants.DIR_NAME_MARKET + Constants.DIVIDER;
	
	private String fileClienti = Constants.FILE_NAME_CLIENTI;

	public HashMap<String, Cliente> loadClienti() {
		HashMap<String, Cliente> clienti = new HashMap<String, Cliente>();
		String path = pathDir + fileClienti;
		
		List<String> prodottiIn = getDb().read(path);
		
		if(prodottiIn.size() > 0 && clienti != null) {
		Iterator<String> iterator = prodottiIn.iterator();
		
		while(iterator.hasNext()) {
			String[] values = iterator.next().split("\\|");
			String ragioneSociale = values[0];
			String sedeLegale = values[1];
			String pIVA = values[2];
			clienti.put(pIVA, new Cliente(ragioneSociale, sedeLegale, pIVA));
		}
		
		}
		return clienti;
	}

	public void saveAll(HashMap<String, Cliente> clienti) {
		getDb().write(pathDir, fileClienti, new ArrayList<Object>(clienti.values()));
	}
}
