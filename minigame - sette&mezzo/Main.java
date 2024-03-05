import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        // Inizializzo tutti gli oggetti che che serviranno più avanti nel codice
        // Aggiungo il giocatore ed il banco alla partita
        // Genero e tiro poi la prima carta per il giocatore...

        Scanner scanner     = new Scanner(System.in);
        Partita partita     = new Partita();
        Giocatore giocatore = new Giocatore();
        Giocatore banco     = new Giocatore();
        Mazzo mazzo         = new Mazzo();

        partita.aggiungiGiocatore(giocatore);
        partita.aggiungiGiocatore(banco);

        System.out.println("--------------------------------------------------    ");
        System.out.println("       		    PARTITA INIZIATA                      ");
        System.out.println("--------------------------------------------------    ");

        giocatore.tiraCarta(mazzo.generaCartaRandom());
        System.out.println("\nLE TUE CARTE: " + partita.stampaCarteGiocatore(giocatore));

        int scelta = 0;

        // Avvio un ciclo while sino a quando il giocatore non ha "sballato"...
        cicloWhileGiocatore:
        do
        {

            System.out.print("\nDIGITA 1 PER TIRARE, 2 PER STARE: ");
            scelta = scanner.nextInt();

            switch (scelta)
            {

                case 1:
                    giocatore.tiraCarta(mazzo.generaCartaRandom());
                    System.out.println("\nLE TUE CARTE: " + partita.stampaCarteGiocatore(giocatore));
                    break;

                case 2:
                    break cicloWhileGiocatore;

                default:
                    System.out.println("\nERRORE: PER FAVORE RIAVVIA IL PROGRAMMA ED INSERISCI UNA SCELTA VALIDA!");
                    System.exit(0);

            }

        } while ( !partita.getGiocatori().get(0).isSballato() );

        // Se il giocatore con le sue carte non ha superato il valore di 7.5, gioca il banco.
        if ( giocatore.isSballato() )
        {
            System.out.println("\nHAI SBALLATO!");
        }
        else
        {
            System.out.println("\n--------------------------------------------------");
            System.out.println("    		GIOCA IL BANCO                 		    ");
            System.out.println("--------------------------------------------------  ");

            banco.tiraCarta( mazzo.generaCartaRandom() );
            System.out.println( "\nCARTE BANCO : " + partita.stampaCarteGiocatore(banco) );

            // Questa è una sorta di "intelligenza artificiale" del banco
            // Continua il ciclo fin quando il banco non ha "sballato" o vinto
            ciclowhilebanco:
            while ( !partita.getGiocatori().get(1).isSballato() )
            {
                if ( banco.getSommaCarteGiocatore() == giocatore.getSommaCarteGiocatore() && banco.getSommaCarteGiocatore() == 7.5 )
                {
                    System.out.println("\nPAREGGIO!	");
                    break ciclowhilebanco;
                }
                else if ( banco.getSommaCarteGiocatore() > giocatore.getSommaCarteGiocatore() && banco.getSommaCarteGiocatore() <= 7.5 )
                {
                    System.out.println("\nHAI PERSO! IL BANCO HA VINTO...");
                    break ciclowhilebanco;
                }
                else
                {
                    while ( banco.getSommaCarteGiocatore() <= giocatore.getSommaCarteGiocatore() )
                    {
                        banco.tiraCarta( mazzo.generaCartaRandom() );
                        System.out.println( "\nCARTE BANCO : " + partita.stampaCarteGiocatore(banco) );
                    }
                }
            }

            // Controllo se il banco ha sballato
            if (banco.isSballato())
            {
                System.out.println("\nHAI VINTO! IL BANCO HA SBALLATO...");
            }
        }

    }
}