package comandi;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class ComandoVaiTest {
    private Partita partita;

    @Before
    public void setUp() {
        LabirintoBuilder builder = new LabirintoBuilder();
        Labirinto labirinto = builder
            .addStanzaIniziale("Aula1")
            .addStanzaVincente("Aula4")
            .addAdiacenza("Aula1", "Aula2", "nord")
            .addAdiacenza("Aula2", "Aula3", "est")
            .addAdiacenza("Aula3", "Aula4", "sud")
            .getLabirinto();
        IOConsole io = new IOConsole();
        partita = new Partita(labirinto, io);
    }

    @Test
    public void testComandoVai() {
        // Verifica che il comando "vai" cambi stanza correttamente
        assertEquals("Aula1", partita.getStanzaCorrente().getNome());
        partita.esegui("vai nord");
        assertEquals("Aula2", partita.getStanzaCorrente().getNome());
        partita.esegui("vai est");
        assertEquals("Aula3", partita.getStanzaCorrente().getNome());
        partita.esegui("vai sud");
        assertEquals("Aula4", partita.getStanzaCorrente().getNome());
    }

    @Test
    public void testComandoVaiInesistente() {
        // Verifica che il comando "vai" non funzioni se la direzione non è valida
        assertEquals("Aula1", partita.getStanzaCorrente().getNome());
        partita.esegui("vai ovest");
        assertEquals("Aula1", partita.getStanzaCorrente().getNome());
        assertTrue(partita.getMessaggio().contains("Direzione non valida"));
    }
}