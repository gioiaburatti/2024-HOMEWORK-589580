package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPrendi implements Comando {
    private String oggetto;

    public ComandoPrendi(String oggetto) {
        this.oggetto = oggetto;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.oggetto != null) {
            partita.getGiocatore().prendiOggetto(this.oggetto, partita.getStanzaCorrente());
        } else {
            System.out.println("Devi specificare un oggetto da prendere.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.oggetto = parametro;
    }

    @Override
    public String getNome() {
        return "prendi";
    }

    @Override
    public String getParametro() {
        return this.oggetto;
    }

	@Override
	public String setNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}