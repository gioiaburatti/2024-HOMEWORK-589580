package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBuia;

public class StanzaBuiaTest {
    private StanzaBuia stanzaBuia;
    private Attrezzo lanterna;

    @Before
    public void setUp() {
        stanzaBuia = new StanzaBuia("Stanza Buia", "lanterna");
        lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    public void testGetDescrizioneConLanterna() {
        stanzaBuia.addAttrezzo(lanterna);
        assertEquals("Stanza Buia\nAttrezzi nella stanza: lanterna (1kg) \nStanze adiacenti: ", stanzaBuia.getDescrizione());
    }

    @Test
    public void testGetDescrizioneSenzaLanterna() {
        assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
    }
}