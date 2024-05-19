package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;

public class DiaDia {
    private Labirinto labirinto;
    private IO io;

    public DiaDia(Labirinto labirinto, IO io) {
        this.labirinto = labirinto;
        this.io = io;
    }

    public void gioca() {
        // Logica del gioco utilizzando il labirinto corrente
    }

    public static void main(String[] argc) {
        // Creazione di un'istanza di IOConsole
        IO io = new IOConsole();

        // Creazione del labirinto utilizzando LabirintoBuilder
        Labirinto labirinto = new LabirintoBuilder()
            .addStanzaIniziale("LabCampusOne")
            .addStanzaVincente("Biblioteca")
            .addAdiacenza("LabCampusOne", "Biblioteca", "ovest")
            .getLabirinto();

        // Creazione di un'istanza di DiaDia con il labirinto e IOConsole
        DiaDia gioco = new DiaDia(labirinto, io);
        // Avvio del gioco
        gioco.gioca();
    }
}