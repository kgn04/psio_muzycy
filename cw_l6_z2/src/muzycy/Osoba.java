package muzycy;

import java.io.Serializable;

abstract public class Osoba implements Serializable{

	private String imie;
	private String nazwisko;
	private int stawka;
	
	public Osoba(String imie, String nazwisko, int stawka) {
		
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stawka = stawka;
	}
	public Osoba() {
		
	}

	public int getStawka() {
		return stawka;
	}
	
	public void setStawka(int stawka) {
		this.stawka = stawka;
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
