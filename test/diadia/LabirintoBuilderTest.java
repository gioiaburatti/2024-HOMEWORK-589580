import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
    
    private LabirintoBuilder labirintoBuilder;

    @Before
    public void setUp() {
        labirintoBuilder = new LabirintoBuilder();
    }

    @Test
    public void testAggiuntaStanza() {
        assertNotNull(labirintoBuilder);
        labirintoBuilder.addStanza("Stanza1");
        assertNotNull(labirintoBuilder.getLabirinto().getStanza("Stanza1"));
    }

    @Test
    public void testAggiuntaAdiacenza() {
        assertNotNull(labirintoBuilder);
        labirintoBuilder.addStanza("Stanza1").addStanza("Stanza2");
        labirintoBuilder.addAdiacenza("Stanza1", "Stanza2", "nord");
        assertNotNull(labirintoBuilder.getLabirinto().getStanza("Stanza1").getStanzaAdiacente("nord"));
    }

    @Test
    public void testImpostaStanzaIniziale() {
        assertNotNull(labirintoBuilder);
        labirintoBuilder.addStanza("Stanza1").setStanzaIniziale("Stanza1");
        assertEquals("Stanza1", labirintoBuilder.getLabirinto().getStanzaIniziale().getNome());
    }

    @Test
    public void testImpostaStanzaVincente() {
        assertNotNull(labirintoBuilder);
        labirintoBuilder.addStanza("Stanza1").setStanzaVincente("Stanza1");
        assertEquals("Stanza1", labirintoBuilder.getLabirinto().getStanzaCorrente().getNome());
    }
}