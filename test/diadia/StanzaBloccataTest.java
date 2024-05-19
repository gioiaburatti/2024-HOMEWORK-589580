package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaBloccataTest {
    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaLibera;
    private Attrezzo piedeDiPorco;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("Stanza Bloccata", "nord", "piedediporco");
        stanzaLibera = new Stanza("Stanza Libera");
        piedeDiPorco = new Attrezzo("piedediporco", 2);
        stanzaBloccata.impostaStanzaAdiacente("nord", stanzaLibera);
    }

    @Test
    public void testGetStanzaAdiacenteBloccata() {
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetStanzaAdiacenteSbloccata() {
        stanzaBloccata.addAttrezzo(piedeDiPorco);
        assertEquals(stanzaLibera, stanzaBloccata.getStanzaAdiacente("nord"));
    }

    @Test
    public void testGetDescrizioneBloccata() {
        assertEquals("La direzione nord è bloccata, ti serve piedediporco per aprirla.", stanzaBloccata.getDescrizione());
    }

    @Test
    public void testGetDescrizioneSbloccata() {
        stanzaBloccata.addAttrezzo(piedeDiPorco);
        assertEquals("Stanza Bloccata\nAttrezzi nella stanza: piedediporco (2kg) \nStanze adiacenti: nord ", stanzaBloccata.getDescrizione());
    }
}