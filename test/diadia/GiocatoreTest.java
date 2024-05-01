package diadia;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore g = new Giocatore(null, 0);
	
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g.getCFU());
	}
	
	@Test
	public void testSetCfu() {
		g.setCFU(3);
		assertEquals(3, g.getCFU());
	}

	@Test
	public void testGetBorsaDefault() {
		assertNotNull(g.getBorsa());
	}
}
