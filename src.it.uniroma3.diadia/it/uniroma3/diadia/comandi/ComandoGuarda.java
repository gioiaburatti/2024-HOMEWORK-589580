package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Partita;


public class ComandoGuarda implements Comando {
    @Override
    public void esegui(Partita partita) {
        System.out.println(partita.getStanzaCorrente().getDescrizione());
        System.out.println(partita.getGiocatore().getCFU());
    }

    @Override
    public String getNome() {
        return "guarda";
    }

    @Override
    public String getParametro() {
        return null;
    }

    @Override
    public void setParametro(String parametro) {
        
    }

	@Override
	public String setNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}

  