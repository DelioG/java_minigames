import java.util.ArrayList;

public class Partita
{
    
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_CYAN  = "\u001B[36m";

    // Questo ArrayList contiene i giocatori che prendono parte alla partita: il giocatore ed il banco.
    private ArrayList<Giocatore> giocatori = new ArrayList<>();

    public Partita()
    {

    }

    public ArrayList<Giocatore> getGiocatori ()
    {
        return giocatori;
    }

    public void aggiungiGiocatore (Giocatore giocatore)
    {
        giocatori.add(giocatore);
    }


    // Questo metodo viene richiamato all'interno del metodo "main"
    // Viene utlizzato per stamapre le carte del giocatore
    public StringBuilder stampaCarteGiocatore (Giocatore giocatore)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < giocatore.getCarteGiocatore().size(); i++)
        {
            stringBuilder.append
                    (
                            TEXT_CYAN + "[" +
                                    giocatore.getCarteGiocatore().get(i).getValore()
                                    + " di " +
                                    giocatore.getCarteGiocatore().get(i).getSeme()
                                    + "] " + TEXT_RESET
                    );
        }

        stringBuilder.append("\nVALORE CARTE: " + TEXT_CYAN + "[" + giocatore.getSommaCarteGiocatore() + "]" + TEXT_RESET);
        return stringBuilder;
    }
    
}
