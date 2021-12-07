package instrument;

public abstract class Instrument {
    private String producent;
    private int cena;
    private int rok_produkcji;


    public Instrument(String producent, int cena, int rok_produkcji)
    {
        this.producent = producent;
        this.cena = cena;
        this.rok_produkcji = rok_produkcji;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    /*public void playAnInstrument(Instrument instrument)
    {
        System.out.println("Muzyk gra na instrumencie!");
    }*/

}
