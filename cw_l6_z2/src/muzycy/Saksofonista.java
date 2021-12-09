package muzycy;
import instrument.Keyboard;
import instrument.Saksofon;
import repertuar.Piosenka;

public class Saksofonista extends Muzyk
{
    private boolean czySiedzi;
    private Saksofon saksofon = null;


    public Saksofonista(String imie, String nazwisko, int poziomUmiejetnosci, int stawka, boolean czySiedzi, Piosenka[]tab) {

        super(imie, nazwisko,poziomUmiejetnosci, stawka,tab);

        this.czySiedzi = czySiedzi;



    }

    public boolean isCzySiedzi() {
        return czySiedzi;
    }

    public void setCzySiedzi(boolean czySiedzi) {
        this.czySiedzi = czySiedzi;
    }

    public String getStringSaksofon()
    {
        return saksofon.getStringSaksofon();
    }

    public void setSaksofon(Saksofon saksofon)
    {
        this.saksofon = saksofon;
    }

}
