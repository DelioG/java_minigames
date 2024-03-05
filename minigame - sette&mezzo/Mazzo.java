import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Mazzo
{

    // Arraylist dele 40 carte disponibili
    private ArrayList<Carta> mazzo = new ArrayList<>(40);

    // ArrayList di semi disponibili
    private final ArrayList<String> semi = new ArrayList<>( Arrays.asList("Bastoni", "Coppe", "Denari", "Spade") );

    public Mazzo ()
    {
        // Genero il mazzo di 40 carte. 10 carte per ogni seme. Le carte vanno da 1 al 10.

        for (int i = 1; i <= 10; i++)
        {
            Carta cartaBastoni 	= new Carta(i, "Bastoni");
            Carta cartaCoppe 	= new Carta(i, "Coppe");
            Carta cartaDenari	= new Carta(i, "Denari");
            Carta cartaSpade 	= new Carta(i, "Spade");
            mazzo.add(cartaBastoni);
            mazzo.add(cartaCoppe);
            mazzo.add(cartaDenari);
            mazzo.add(cartaSpade);
        }
    }

    public ArrayList<Carta> getMazzo()
    {
        return mazzo;
    }

    public Carta generaCartaRandom()
    {
        // Inizializzo una carta con valore 0 e seme nullo
        // Riassegnerò questi due valori più avanti

        // (While) - Genero un valore randomico per la carta
        // (While) - Genero un valore compreso tra 1 e 4 (per il seme della carta)
        // (While) - Prendo randomicamente un seme da quelli disponibili utilizzando l'intero generato precedentemente

        // (For) - Avvio poi un ciclo for per controllare l'intero mazzo
        // (If ) - Controllo se nel mazzo è ancora disponibile la carta generata
        // (If ) - Se è ancora disponibile nel mazzo...
        // (If ) - Assegno all'oggetto "Carta" il valore generato
        // (If ) - Assegno all'oggetto "Carta" il seme generato
        // (If ) - Rimuovo poi la carta appena generata dal mazzo delle carte disponibili
        // (If ) - Termino il ciclo while

        Carta   cartaDaTirare  = new Carta();
        Integer valore         = 0;
        String  seme           = null;

        Random random    = new Random();
        boolean generato = false;

        do
        {
            valore           = random.nextInt(10) + 1;
            Integer semeTemp = random.nextInt(semi.size());
            seme             = semi.get(semeTemp);

            for (Carta carta : mazzo)
            {
                if ( carta.getValore() == valore && carta.getSeme().equals(seme) )
                {
                    cartaDaTirare.setValore(valore);
                    cartaDaTirare.setSeme(seme);

                    mazzo.remove(cartaDaTirare);

                    generato = true;
                }
            }

        } while (!generato);

        return cartaDaTirare;
    }

}