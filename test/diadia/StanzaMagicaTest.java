package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaMagica;

public class StanzaMagicaTest {
    private StanzaMagica stanzaMagica;

    @Before
    public void setUp() {
        stanzaMagica = new StanzaMagica("Stanza Magica", 2);
    }

    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("chiave", 2);
        Attrezzo attrezzo2 = new Attrezzo("libro", 3);
        Attrezzo attrezzo3 = new Attrezzo("penna", 1);

        assertTrue(stanzaMagica.addAttrezzo(attrezzo1));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo2));
        assertTrue(stanzaMagica.addAttrezzo(attrezzo3));

        Attrezzo attrezzoModificato = stanzaMagica.getAttrezzo("annep");
        assertEquals("annep", attrezzoModificato.getNome());
        assertEquals(2, attrezzoModificato.getPeso());
    }
}
