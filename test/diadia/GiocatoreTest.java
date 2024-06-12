package diadia;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;


public class GiocatoreTest {
	
	private Giocatore giocatore;
	
	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}
	
	@Test
	public void testCfuNonFinitiInizioPartita() {
		assertNotEquals(0,this.giocatore.getCfu());
	}
	
	@Test
	public void testCfuIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI,this.giocatore.getCfu());
	}

}
