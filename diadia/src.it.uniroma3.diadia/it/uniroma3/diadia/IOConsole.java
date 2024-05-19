package it.uniroma3.diadia;
import java.util.Scanner;
class IOConsole implements IO {
    public void mostraMessaggio(String messaggio) {
        System.out.println(messaggio);
    }

    public String leggiRiga() {
        try (Scanner scanner = new Scanner(System.in)) {
			return scanner.nextLine();
		}
    }
}