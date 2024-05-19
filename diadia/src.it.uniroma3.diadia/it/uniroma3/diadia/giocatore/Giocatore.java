package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ambienti.Stanza;

public class Giocatore {
	private int CFU;
	private Borsa borsa;
	
	public Giocatore(Borsa borsa, int CFU) {
		this.borsa = borsa;
		this.CFU = CFU;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	 
	public int getCFU() {
		return CFU;	
	} 
	
	  
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	 
	public void setCFU(int cFU) {
		CFU = cFU;
	}

	 public void sposta(String direzione) {
	        
	    }

	    public void prendiOggetto(String oggetto, Stanza stanzaCorrente) {
	       
	    }

	    public void posaOggetto(String oggetto) {
	        
	    }

		public boolean possiedeOggetto(String string) {
			
			return false;
		}

}