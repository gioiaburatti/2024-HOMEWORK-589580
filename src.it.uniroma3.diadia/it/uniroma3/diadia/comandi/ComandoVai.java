package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando {
    private String direzione;

    public ComandoVai(String direzione) {
        this.direzione = direzione;
    }

    @Override
    public void esegui(Partita partita) {
        if (this.direzione != null) {
            partita.getGiocatore().sposta(this.direzione);
        } else {
            System.out.println("Dove vuoi andare? Devi specificare una direzione.");
        }
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }

	@Override
	public String setNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}
