package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.Map;

public class IOSimulator {
    private Map<Integer, String> messages;

    public IOSimulator() {
        this.messages = new HashMap<>();
    }

    public String readLine() {
        // Simulazione della lettura di una riga
        return "Comando eseguito correttamente.";
    }

    public void print(String message) {
        // Simulazione della stampa di un messaggio
        System.out.println(message);
    }

    public void recordMessage(int lineNumber, String message) {
        messages.put(lineNumber, message);
    }

    public String getMessageForLine(int lineNumber) {
        return messages.get(lineNumber);
    }
}