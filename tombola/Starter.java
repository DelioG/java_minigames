package tombola;

public class Starter {
	
	public static final String TEXT_RESET 	= "\u001B[0m";
	public static final String TEXT_CYAN 	= "\u001B[36m";
	
	public static void main(String[] args) {
		
		Giocatore giocatore1 = new Giocatore("Sanny");
		Cartella cartella1 = new Cartella(1);
		Cartella cartella2 = new Cartella(2);
		giocatore1.aggiungiCartella(cartella1);
		giocatore1.aggiungiCartella(cartella2);
		
		Giocatore giocatore2 = new Giocatore("Delio");
		Cartella cartella3 = new Cartella(1);
		Cartella cartella4 = new Cartella(2);
		giocatore2.aggiungiCartella(cartella3);
		giocatore2.aggiungiCartella(cartella4);
		
		Partita partita = new Partita();
		partita.aggiungiGiocatore(giocatore1);
		partita.aggiungiGiocatore(giocatore2);

		System.out.println("ECCO I GIOCATORI CHE PARTECIPANO ALLA TOMBOLATA: ");
		System.out.println();

		for (int i = 0; i < partita.getGiocatori().size(); i++)
		{
			System.out.println(TEXT_CYAN + partita.getGiocatori().get(i).getNome() + TEXT_RESET);

			for (int j = 0; j < partita.getGiocatori().get(i).getCartelle().size(); j++) 
			{
				/* Stampo l'id della cartella ed i relativi numeri contenuti in essa */
				System.out.println(
						"- Cartella n. [" + TEXT_CYAN + partita.getGiocatori().get(i).getCartelle().get(j).getId() + TEXT_RESET + "]: " +
								partita.getGiocatori().get(i).getCartelle().get(j).stampaCartella());
			}
			
		}
		
		System.out.println("-------------------------------------------------");
		
		/*
		 * CONTROLLO IL VINCITORE 
		 * 
		 * 1) Anzitutto avvio un ciclo che viene eseguito fin quando non c'è un vincitore.
		 * 2) Genero il numero casuale che verrà aggiunto al tabellone.
		 * 3) Avvio un ciclo for per quanti giocatori ci sono in partita.
		 * 4) Avvio un secondo ciclo for per quante cartelle possiede il rispettivo giocatore.
		 * 5) Controllo se il numero generato è presente all'interno di una cartella del giocatore.
		 * 6) Se la cartella ciclata non contiene alcun false, c'è un vincitore.
		 * 7) Altrimenti procedo a stampare la cartella cancellando "[X]" il numero chiamato (generato).
		 */

		boolean vincitore = false;
		int ultimoNumero = 0;
		String nomeVincitore = "";

		System.out.println("\nSTAMPA DELLE CARTELLE DEI GIOCATORI, SE I NUMERI GENERATI SONO PRESENTI SU DI ESSE");
		System.out.println();

		while (!vincitore) 
		{

			int x = partita.generaNumeroCasuale();

			for (int i = 0; i < partita.getGiocatori().size(); i++) 
			{

				for (int j = 0; j < partita.getGiocatori().get(i).getCartelle().size(); j++) 
				{

					if (partita.getGiocatori().get(i).getCartelle().get(j).checkNumeroSePresente(x)) 
					{

						if (!partita.getGiocatori().get(i).getCartelle().get(j).getNumeriCartellaChiamati()
								.contains(false)) 
						{
							vincitore = true;
							nomeVincitore = nomeVincitore.concat(partita.getGiocatori().get(i).getNome());
							ultimoNumero = x;
							break;
						} 
						else 
						{
							System.out.println("Giocatore: [" + TEXT_CYAN + partita.getGiocatori().get(i).getNome()
									+ TEXT_RESET + "] -> Cartella: [" + TEXT_CYAN + partita.getGiocatori().get(i).getCartelle().get(j).getId()
									+ TEXT_RESET + "] -> Numeri: "
									+ partita.getGiocatori().get(i).getCartelle().get(j).stampaCartella());
						}

					}

				}

			}

		}

		System.out.println("-------------------------------------------------");
		System.out.println("\nULTIMO NUMERO CHIAMATO: " + ultimoNumero);
		System.out.println("\nIL NOME DEL VINCITORE E': " + TEXT_CYAN + nomeVincitore + TEXT_RESET );
		System.out.println("\nI NUMERI CHIAMATI SONO I SEGUENTI: " + partita.getTabellone());

	}
}