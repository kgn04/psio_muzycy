package repertuar;

import java.io.Serializable;

public class Piosenka implements Serializable{

    private String tytul;
    private String gatunek;
    private String rokWydania;

    public Piosenka(String tytul,String gatunek,String rokWydania) {
        this.tytul=tytul;
        this.gatunek=gatunek;
        this.rokWydania=rokWydania;
    }
    
    
    @Override
    public String toString() {
		
    	return this.tytul + " , " + this.gatunek + " , Rok wydania: " + this.rokWydania;
    }
    

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(String rokWydania) {
        this.rokWydania = rokWydania;
    }






}
