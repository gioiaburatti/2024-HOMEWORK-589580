package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.ArrayList;
import java.util.*;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
public class Borsa {
	
	 private SortedSet<Attrezzo> contenuto;

	    // Costruttore e altri metodi della classe

	    public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
	        SortedSet<Attrezzo> setOrdinatoPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
	        setOrdinatoPerPeso.addAll(contenuto);
	        return setOrdinatoPerPeso;
	    }
	    
    private Map<String, Attrezzo> attrezzi;
    private int pesoMax;

    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new HashMap<>();
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.pesoMax)
            return false;
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.get(nomeAttrezzo);
    }

    public int getPeso() {
        return this.attrezzi.values().stream().mapToInt(Attrezzo::getPeso).sum();
    }
    
    // Aggiungere gli altri metodi esistenti della classe
public List<Attrezzo> getContenutoOrdinatoPerPeso() {
    List<Attrezzo> listaOrdinata = new ArrayList<>(this.attrezzi.values());
    listaOrdinata.sort(Comparator.comparingInt(Attrezzo::getPeso)
                                  .thenComparing(Attrezzo::getNome));
    return listaOrdinata;
}

public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
    SortedSet<Attrezzo> setOrdinato = new TreeSet<>(Comparator.comparing(Attrezzo::getNome));
    setOrdinato.addAll(this.attrezzi.values());
    return setOrdinato;
}

public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
    Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();
    for (Attrezzo attrezzo : this.attrezzi.values()) {
        mappa.computeIfAbsent(attrezzo.getPeso(), k -> new HashSet<>()).add(attrezzo);
    }
    return mappa;
}

public void guardaContenutoBorsa() {
    System.out.println("Contenuto della borsa ordinato per peso:");
    for (Attrezzo attrezzo : this.getContenutoOrdinatoPerPeso()) {
        System.out.println(attrezzo);
    }
    
    System.out.println("\nContenuto della borsa ordinato per nome:");
    for (Attrezzo attrezzo : this.getContenutoOrdinatoPerNome()) {
        System.out.println(attrezzo);
    }
    
    System.out.println("\nContenuto della borsa raggruppato per peso:");
    for (Map.Entry<Integer, Set<Attrezzo>> entry : this.getContenutoRaggruppatoPerPeso().entrySet()) {
        System.out.println("Peso " + entry.getKey() + ": " + entry.getValue());
    }
}}