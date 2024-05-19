package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Stanza {
    private String nome;
    private Map<String, Stanza> stanzeAdiacenti;
    private Map<String, Attrezzo> attrezzi;

    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get(direzione);
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (!this.attrezzi.containsKey(attrezzo.getNome())) {
            this.attrezzi.put(attrezzo.getNome(), attrezzo);
            return true;
        }
        return false;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.get(nomeAttrezzo);
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.attrezzi.containsKey(nomeAttrezzo);
    }

    public String getDescrizione() {
        StringBuilder descrizione = new StringBuilder();
        descrizione.append(this.nome);
        descrizione.append("\nAttrezzi nella stanza: ");
        for (Attrezzo a : this.attrezzi.values()) {
            descrizione.append(a.toString()).append(" ");
        }
        descrizione.append("\nStanze adiacenti: ");
        for (String direzione : this.stanzeAdiacenti.keySet()) {
            descrizione.append(direzione).append(" ");
        }
        return descrizione.toString();
    }
}