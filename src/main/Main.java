package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import constants.Constants;
import model.Cliente;
import model.Fattura;
import model.Prodotto;
import service.FatturaService;

public class Main {

	public static void main(String[] args) {
		Market market = new Market();
		market.init();
		Magazzino magazzino = new Magazzino();
		
		int scelta = 0;
		int scelta3;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("---Opzioni:");
			for(String opzione : market.getOpzioni()) {
				System.out.println(opzione);
			}
			try {
				scelta = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			switch(scelta) {
			
			case 1:
				//crea prodotto
				System.out.println("===Crea prodotto===");
				System.out.println("--- Inserisci marca:");
				String marca = scanner.nextLine();
				System.out.println("--- Inserisci modello:");
				String modello = scanner.nextLine();
				System.out.println("--- Inserisci quantita:");
				int quantita = Integer.parseInt(scanner.nextLine());
				System.out.println("--- Inserisci prezzo:");
				double prezzo = Double.parseDouble(scanner.nextLine());
				magazzino.addProdotto(new Prodotto(marca, modello, quantita, prezzo));
				break;
			case 2:
				//crea cliente
				System.out.println("===Crea cliente===");
				System.out.println("--- Inserisci ragione sociale:");
				String ragioneSociale = scanner.nextLine();
				System.out.println("--- Inserisci sede legale:");
				String sedeLegale = scanner.nextLine();
				System.out.println("--- Inserisci P.IVA");
				String pIVA = scanner.nextLine();
				market.addCliente(new Cliente(ragioneSociale, sedeLegale, pIVA));
				break;
			case 3:
				//crea fattura
				System.out.println("===Crea fattura===");
				List<Cliente> clienti = new ArrayList<Cliente>(market.getClienti().values());
				System.out.println("===Lista dei clienti:");
				for(Cliente cliente : clienti) {
					System.out.println("- " + cliente.toString());
				}
				System.out.println("---Inserisci P.IVA del cliente:");
				String idCliente = scanner.nextLine();
				Cliente cliente = market.getCliente(idCliente);
				
				System.out.println("===Lista dei prodotti:");
				for(Prodotto prodotto : magazzino.getProdotti()) {
					System.out.println("- " + prodotto.toString());
				}
				
				int scelta2 = 0;
				int idProdotto;
				List<Prodotto> prodottiVenduti = new ArrayList<Prodotto>();
				
				do {
					System.out.println("--- Inserisci id di prodotto o inserisci 0 per salvare fattura:");
					try {
						scelta2 = Integer.parseInt(scanner.nextLine());
						idProdotto = scelta2;
						if(idProdotto != 0) {
							Prodotto p = magazzino.getProdotto(idProdotto);
							System.out.println("--- Inserisci quantita:");
							int quantitaProdottoVenduto = Integer.parseInt(scanner.nextLine());
							p.setQuantita(quantitaProdottoVenduto);
							prodottiVenduti.add(p);
						}
					}catch (NumberFormatException e) {
						e.printStackTrace();
					}
				} while(scelta2 != 0);
				magazzino.addProdottiVenduti(prodottiVenduti);
				market.addFattura(new Fattura(cliente, prodottiVenduti));
				break;
			case 4:
				//Visualizza Prodotti
				System.out.println("===Lista dei prodotti:");
				for(Prodotto prodotto : magazzino.getProdotti()) {
					System.out.println(prodotto.toString());
				}
				break;
			case 5:
				System.out.println("===Lista dei prodotti venduti:");
				//Visualizza Prodotti Venduti
				for(Prodotto prodotto : magazzino.getProdottiVenduti()) {
					System.out.println(prodotto.toString());
				}
				break;
			case 6:
				//Visualizza Clienti
				System.out.println("===Lista dei clienti:");
				for(Cliente c : market.getClienti().values()) {
					System.out.println(c.toString());
				}
				break;
			case 7:
				//Visualizza Fatture
				System.out.println("===Lista dei fatture:");
				for(Fattura f : market.getFatture().values()) {
					System.out.println(f.toString());
				}
				break;
				
			case 8:
				System.out.println("Salvare?");
				System.out.println("1 - SI");
				System.out.println("2 - NO");
				scelta3 = Integer.parseInt(scanner.nextLine());
				
				switch(scelta3) {
				
				case 1:
					magazzino.saveAll();
					market.saveAll();
					System.out.println("Hai salvato...");
					break;
				case 2:
					System.out.println("Non hai salvato...");
					break;
				}
				break;
				
				case 0:
					System.out.println("Salva prima di uscire?");
					System.out.println("1 - SI");
					System.out.println("2 - NO");
					scelta3 = Integer.parseInt(scanner.nextLine());
					
					switch(scelta3) {
					
					case 1:
						magazzino.saveAll();
						market.saveAll();
						System.out.println("Hai salvato...");
						break;
					case 2:
						System.out.println("Non hai salvato...");
						break;
					}
					break;
				
				default:
					System.out.println("...Errore input...");
			}
		} while(scelta != 0);
		
		scanner.close();
		System.out.println("Sei uscito!");
	}
}
