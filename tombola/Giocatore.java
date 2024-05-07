package tombola;

import java.util.ArrayList;

public class Giocatore {

	private String nome;
	private ArrayList<Cartella> cartelle = new ArrayList<>();

	public Giocatore(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public ArrayList<Cartella> getCartelle() {
		return this.cartelle;
	}

	/* Aggiunge cartelle al giocatore */
	public void aggiungiCartella(Cartella cartella) {
		cartelle.add(cartella);
	}

	/* Controlla se il numero generato è inserito all'interno delle cartelle dei rispettivi giocatori */
	public void controlloCartelle(int numeroDaVerificare) {
		for (int i = 0; i < cartelle.size(); i++)
			cartelle.get(i).checkNumeroSePresente(numeroDaVerificare);
	}

}