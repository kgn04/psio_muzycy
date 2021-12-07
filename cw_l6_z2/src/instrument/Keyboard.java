package instrument;

public class Keyboard extends Instrument
{
    private String klasa; // profesjonalna, srednia
    private String rodzaj_klawiatury; // wazona, dowazana, syntezatorowa, pelna, mloteczkowa
    private String elementy_dodatkowe; // sekwencer, glosniki, pulpit pod nuty, zasilacz sieciowy

    public Keyboard(String producent, int cena, int rok_produkcji, String klasa, String rodzaj_klawiatury, String elementy_dodatkowe)
    {
        super(producent, cena, rok_produkcji);

        this.klasa = klasa;
        this.rodzaj_klawiatury = rodzaj_klawiatury;
        this.elementy_dodatkowe = elementy_dodatkowe;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getRodzaj_klawiatury() {
        return rodzaj_klawiatury;
    }

    public void setRodzaj_klawiatury(String rodzaj_klawiatury) {
        this.rodzaj_klawiatury = rodzaj_klawiatury;
    }

    public String getElementy_dodatkowe() {
        return elementy_dodatkowe;
    }

    public void setElementy_dodatkowe(String elementy_dodatkowe) {
        this.elementy_dodatkowe = elementy_dodatkowe;
    }

    public String getStringKeyboard()
    {
        return  "\tProducent: "+getProducent()+"\tCena: "+getCena()+"\tRok produkcji: "
                +getRok_produkcji()+"\tKlasa: "+getKlasa()+"\tRodzaj klawiatury: "
                +getRodzaj_klawiatury()+"\tElementy dodatkowe: "+getElementy_dodatkowe();
    }
}
