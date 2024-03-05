import java.util.ArrayList;

public class Giocatore
{

    // Contiene carte generate randomicamente o "tirate" ed assegnate al giocatore
    private ArrayList<Carta> carteGiocatore = new ArrayList<>();

    private double sommaCarteGiocatore = 0;

    private boolean sballato = false;

    public Giocatore()
    {

    }

    public ArrayList<Carta> getCarteGiocatore()
    {
        return carteGiocatore;
    }

    public double getSommaCarteGiocatore()
    {
        return sommaCarteGiocatore;
    }

    public boolean isSballato()
    {
        return sballato;
    }

    // Questo metodo aggiunge la carta generata nel metodo "main", all'arraylist "carteGiocatore"
    // Esegue poi operazioni aggiuntive...
    public void tiraCarta(Carta carta)
    {
        // Come prima cosa aggiungo la carta generata al mazzo del giocatore

        // Controllo poi il valore della carta...
        // 1 (If) - In caso di matta (10 di denari)
        // 2 (If) - In caso di carta con valore compreso tra 1 e 7
        // 3 (if) - In caso di mezza figura

        // Infine controllo se il giocatore ha sballato o meno

        carteGiocatore.add(carta);

        if ( carta.getValore() == 10 && carta.getSeme().equals("Denari") )
        {
            sommaCarteGiocatore = 7.5;
        }
        else if (carta.getValore() > 0 && carta.getValore() <= 7)
        {
            sommaCarteGiocatore += carta.getValore();
        }
        else if (carta.getValore() > 7 && carta.getValore() <= 10)
        {
            sommaCarteGiocatore += 0.5;
        }

        checkIfSballato();
    }

    // Questo metodo viene richiamato ogni volta che viene "tirata" una carta al giocatore (metodo "tiraCarta").
    // Controlla se il giocatore in questione ha sballato o meno.
    public void checkIfSballato()
    {
        if (sommaCarteGiocatore > 7.5)
            this.sballato = true;
        else
            this.sballato = false;
    }

}