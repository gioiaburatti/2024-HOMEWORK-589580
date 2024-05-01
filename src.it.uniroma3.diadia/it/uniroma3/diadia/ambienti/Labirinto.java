package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Labirinto {
	private Stanza entrata;
	private Stanza uscita;

	
	private Stanza stanzaCorrente;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	public Labirinto(Stanza uscita, Stanza entrata) {
		creaStanze();
		this.stanzaCorrente = entrata;
		this.entrata = entrata;
		this.uscita = uscita;
	}
	


	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.entrata = atrio;  
		this.uscita = biblioteca;
    }

	public Giocatore getGiocatore() {
		return giocatore;
	}
	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Stanza getUscita() {
		return uscita;
	}
	
	public Stanza getEntrata() {
		return entrata;
	}
	
	public void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}

	public Stanza getStanzaIniziale() {
		// TODO Auto-generated method stub
		return null;
	}
	
}