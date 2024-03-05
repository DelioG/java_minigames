public class Carta
{

    private int valore;
    private String seme;

    public Carta()
    {
        // Utilizzato all'interno del metodo generaCartaRandom(), della classe "Mazzo".
        // Utilizzato per generare una carta dal valore 0 e dal seme nullo.
    }

    public Carta ( int valore, String seme )
    {
        this.valore = valore;
        this.seme   = seme;
    }

    public int getValore ()
    {
        return valore;
    }

    public String getSeme ()
    {
        return seme;
    }

    public void setValore ( int valore )
    {
        this.valore = valore;
    }

    public void setSeme ( String seme )
    {
        this.seme = seme;
    }

}