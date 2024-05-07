package tombola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Cartella {

	private int id;
	private ArrayList<Integer> cartella = new ArrayList<>();
	private ArrayList<Boolean> numeriCartellaChiamati = new ArrayList<>(Collections.nCopies(15, false));

	public Cartella(int id) {
		this.id = id;
		generaNumeriCartella();
	}

	public int getId() {
		return this.id;
	}

	public ArrayList<Integer> getNumeriCartella() {
		return this.cartella;
	}

	public ArrayList<Boolean> getNumeriCartellaChiamati() {
		return this.numeriCartellaChiamati;
	}

	/* Popola la cartella con numeri casuali */
	public void generaNumeriCartella() {
		Random random = new Random();

		while (cartella.size() <= 14) 
		{
			int randomNumber = random.nextInt(90) + 1;
			if (!cartella.contains(randomNumber))
				cartella.add(randomNumber);
		}
	}

	/* Verifcia se il numero passato come parametro è contenuto all'interno della cartella */
	public boolean checkNumeroSePresente(int nVerifica) {
		if (cartella.contains(nVerifica)) 
		{
			/* Nel caso il numero passato sia contenuto in cartella, modifico il corrispettivo index in numeriCartellaChiamate e lo setto su TRUE. */
			numeriCartellaChiamati.set(cartella.indexOf(nVerifica), true);
			return true;
		} 
		else 
		{
			return false;
		}
	}

	// METODO PER STAMPARE I NUMERI CONTENUTI ALL'INTERNO DELLA CARTELLA
	public String stampaCartella() {
		String s = "";

		for (int i = 0; i < 15; i++) 
		{
			if (numeriCartellaChiamati.get(i) == true) 
			{
				if (i == 0) 				// Se è il primo numero stampo senza il trattino
					s = s.concat("[X]");
				else 						// A partire dal secondo numero stampo con un trattino accanto
					s = s.concat(" - [X]");
			}
			else
			{
				int nTmp = cartella.get(i);
				if (i == 0)
					s = s.concat("[" + nTmp + "]");
				else
					s = s.concat(" - [" + nTmp + "]");
			}
		}

		return s;
	}

}