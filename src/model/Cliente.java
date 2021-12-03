package model;

public class Cliente {
	
	private String ragioneSociale;
	private String sedeLegale;
	private String pIVA;
	
	
	public Cliente() {
	
	}
	
	public Cliente(String ragioneSociale, String sedeLegale, String pIVA) {
		this.ragioneSociale = ragioneSociale;
		this.sedeLegale = sedeLegale;
		this.pIVA = pIVA;
	}
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public String getpIVA() {
		return pIVA;
	}
	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
	}

	@Override
	public String toString() {
		return ragioneSociale + "|" + sedeLegale + "|" + pIVA;
	}
}
