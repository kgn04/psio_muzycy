package muzycy;

import rider.Rider;

public class Technik extends Osoba{
	
	private int stawka;
	private int poziom_umiejetnosci;
	private String preferowany_stol;
	Rider rider;
	
	
	public Technik(String imie, String nazwisko, int stawka, int poziom_umiejetnosci, String preferowany_stol, Rider rider){
		
		super(imie, nazwisko);
		this.stawka = stawka;
		this.poziom_umiejetnosci = poziom_umiejetnosci;
		this.preferowany_stol = preferowany_stol;
		this.rider = rider;
		
		
		
	}


	public int getStawka() {
		return stawka;
	}


	public void setStawka(int stawka) {
		this.stawka = stawka;
	}


	public int getPoziom_umiejetnosci() {
		return poziom_umiejetnosci;
	}


	public void setPoziom_umiejetnosci(int poziom_umiejetnosci) {
		this.poziom_umiejetnosci = poziom_umiejetnosci;
	}


	public String getPreferowany_stol() {
		return preferowany_stol;
	}


	public void setPreferowany_stol(String preferowany_stol) {
		this.preferowany_stol = preferowany_stol;
	}


	public Rider getRider() {
		return rider;
	}


	public void setRider(Rider rider) {
		this.rider = rider;
	}
	
	
	
	

}
