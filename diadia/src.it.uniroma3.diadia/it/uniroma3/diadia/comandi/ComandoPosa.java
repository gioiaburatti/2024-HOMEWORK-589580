package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
    private String oggetto;

    public ComandoPosa(String oggetto) {
        this.oggetto = oggetto;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.oggetto != null) {
            partita.getGiocatore().posaOggetto(this.oggetto);
        } else {
            System.out.println("Devi specificare un oggetto da posare.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.oggetto = parametro;
    }

    @Override
    public String getNome() {
        return "posa";
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

