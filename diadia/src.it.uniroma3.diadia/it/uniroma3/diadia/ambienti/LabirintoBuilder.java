package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.ambienti.Stanza;

import java.util.HashMap;
import java.util.Map;

public class LabirintoBuilder {
    private Labirinto labirinto;
    private Map<String, Stanza> stanze;

    public LabirintoBuilder() {
        this.labirinto = new Labirinto();
        this.stanze = new HashMap<>();
    }

    public LabirintoBuilder addStanza(String nomeStanza) {
        Stanza stanza = new Stanza(nomeStanza);
        this.stanze.put(nomeStanza, stanza);
        return this;
    }

    public LabirintoBuilder addAdiacenza(String stanza1, String stanza2, String direzione) {
        Stanza s1 = this.stanze.get(stanza1);
        Stanza s2 = this.stanze.get(stanza2);
        s1.impostaStanzaAdiacente(direzione, s2);
        s2.impostaStanzaAdiacente(direzioneOpposta(direzione), s1); // Aggiunge l'adiacenza inversa
        return this;
    }

    private String direzioneOpposta(String direzione) {
        switch (direzione) {
            case "nord": return "sud";
            case "sud": return "nord";
            case "est": return "ovest";
            case "ovest": return "est";
            default: throw new IllegalArgumentException("Direzione non valida: " + direzione);
        }
    }

    public LabirintoBuilder setStanzaIniziale(String nomeStanza) {
        Stanza stanzaIniziale = this.stanze.get(nomeStanza);
        this.labirinto.setStanzaIniziale(stanzaIniziale);
        return this;
    }

    public LabirintoBuilder setStanzaVincente(String nomeStanza) {
        Stanza stanzaVincente = this.stanze.get(nomeStanza);
        this.labirinto.setStanzaCorrente(stanzaVincente);
        return this;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }
}
