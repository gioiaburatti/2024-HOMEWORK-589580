package diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

    private Borsa borsa;

    @Before
    public void setUp() {
        borsa = new Borsa(0);
        borsa.addAttrezzo(new Attrezzo("martello", 5));
        borsa.addAttrezzo(new Attrezzo("cacciavite", 5));
        borsa.addAttrezzo(new Attrezzo("piombo", 10));
        borsa.addAttrezzo(new Attrezzo("ps", 5));
        borsa.addAttrezzo(new Attrezzo("piuma", 1));
        borsa.addAttrezzo(new Attrezzo("libro", 5));
    }

    @Test
    public void testGetContenutoOrdinatoPerPeso() {
        borsa.addAttrezzo(new Attrezzo("piombo", 10));
        borsa.addAttrezzo(new Attrezzo("ps", 5));
        borsa.addAttrezzo(new Attrezzo("piuma", 1));
        borsa.addAttrezzo(new Attrezzo("libro", 5));

        List<Attrezzo> contenuto = borsa.getContenutoOrdinatoPerPeso();
        assertEquals(4, contenuto.size());
        assertEquals("piuma", contenuto.get(0).getNome());
        assertEquals("ps", contenuto.get(1).getNome());
        assertEquals("libro", contenuto.get(2).getNome());
        assertEquals("piombo", contenuto.get(3).getNome());
    }

    @Test
    public void testGetContenutoOrdinatoPerNome() {
        borsa.addAttrezzo(new Attrezzo("piombo", 10));
        borsa.addAttrezzo(new Attrezzo("ps", 5));
        borsa.addAttrezzo(new Attrezzo("piuma", 1));
        borsa.addAttrezzo(new Attrezzo("libro", 5));

        Set<Attrezzo> contenuto = borsa.getContenutoOrdinatoPerNome();
        assertEquals(4, contenuto.size());
        assertTrue(contenuto.contains(new Attrezzo("libro", 5)));
        assertTrue(contenuto.contains(new Attrezzo("piombo", 10)));
        assertTrue(contenuto.contains(new Attrezzo("piuma", 1)));
        assertTrue(contenuto.contains(new Attrezzo("ps", 5)));
    }

    @Test
    public void testGetContenutoRaggruppatoPerPeso() {
        borsa.addAttrezzo(new Attrezzo("piombo", 10));
        borsa.addAttrezzo(new Attrezzo("ps", 5));
        borsa.addAttrezzo(new Attrezzo("piuma", 1));
        borsa.addAttrezzo(new Attrezzo("libro", 5));

        Map<Integer, Set<Attrezzo>> raggruppatoPerPeso = borsa.getContenutoRaggruppatoPerPeso();
        assertEquals(3, raggruppatoPerPeso.size());
        assertTrue(raggruppatoPerPeso.containsKey(1));
        assertTrue(raggruppatoPerPeso.containsKey(5));
        assertTrue(raggruppatoPerPeso.containsKey(10));
        assertEquals(1, raggruppatoPerPeso.get(1).size());
        assertEquals(2, raggruppatoPerPeso.get(5).size());
        assertEquals(1, raggruppatoPerPeso.get(10).size());
    }

    @Test
    public void testGetSortedSetOrdinatoPerPeso() {
        borsa.addAttrezzo(new Attrezzo("piombo", 10));
        borsa.addAttrezzo(new Attrezzo("ps", 5));
        borsa.addAttrezzo(new Attrezzo("piuma", 1));
        borsa.addAttrezzo(new Attrezzo("libro", 5));

        SortedSet<Attrezzo> sortedSet = borsa.getSortedSetOrdinatoPerPeso();
        assertEquals(4, sortedSet.size());
        assertEquals("piuma", sortedSet.first().getNome());
        assertEquals("piombo", sortedSet.last().getNome());
    }

    @Test
    public void testAttrezziDistintiStessoPeso() {
        borsa.addAttrezzo(new Attrezzo("martello", 5));
        borsa.addAttrezzo(new Attrezzo("cacciavite", 5));

        SortedSet<Attrezzo> setOrdinatoPerPeso = borsa.getSortedSetOrdinatoPerPeso();
        assertEquals(2, setOrdinatoPerPeso.size());
        assertFalse(setOrdinatoPerPeso.first().equals(setOrdinatoPerPeso.last()));
    }


}