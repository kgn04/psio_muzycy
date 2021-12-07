package instrument;

public class Saksofon extends Instrument {

    private String rodzaj; // sporanowy, altowy, tenorowy, barytonowy
    private String stroj_muzyczny; // B, Es

    public Saksofon(String producent, int cena, int rok_produkcji, String rodzaj, String stroj_muzyczny)
    {
        super(producent, cena, rok_produkcji);

        this.rodzaj = rodzaj;
        this.stroj_muzyczny = stroj_muzyczny;
    }

    public String getStroj_muzyczny() {
        return stroj_muzyczny;
    }

    public void setStroj_muzyczny(String stroj_muzyczny) {
        this.stroj_muzyczny = stroj_muzyczny;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getStringSaksofon()
    {
        return "Producent: "+getProducent()+"\tCena: "+getCena()+"\tRok produkcji: "+getRok_produkcji()
                +"\tRodzaj: "+getRodzaj()+"\tStrój muzyczny: "+getStroj_muzyczny();
    }


}

