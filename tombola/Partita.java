package tombola;

import java.util.ArrayList;
import java.util.Random;

public class Partita {

	private ArrayList<Giocatore> giocatori = new ArrayList<>();
	private ArrayList<Integer> tabellone = new ArrayList<>();

	public Partita() {

	}

	public ArrayList<Giocatore> getGiocatori() {
		return giocatori;
	}

	public ArrayList<Integer> getTabellone() {
		return tabellone;
	}

	/* Aggiunge giocatori alla partita */
	public void aggiungiGiocatore(Giocatore giocatore) {
		giocatori.add(giocatore);
	}

	/* Genera un numero casuale per il tabellone */
	public int generaNumeroCasuale() {

		Random random = new Random();
		int n = 0;
		boolean flag = false;

		while (flag != true)
		{
			n = random.nextInt(90) + 1;
			
			if (!tabellone.contains(n))		// Controlla se il numero generato è stato già generato precedentemente ("chiamato")
			{
				tabellone.add(n);
				flag = true;
			}
		}

		return n;
	}

}