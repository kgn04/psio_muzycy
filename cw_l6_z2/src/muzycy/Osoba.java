package muzycy;

import java.io.Serializable;

abstract public class Osoba implements Serializable{

	private String imie;
	private String nazwisko;
	
	public Osoba(String imie, String nazwisko) {
		
		this.imie = imie;
		this.nazwisko = nazwisko;
		
	}
	public Osoba() {
		
	}





	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getNazwisko() {
		return nazwisko;
	}


	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

}
