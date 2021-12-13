package muzycy;

import java.io.Serializable;

import repertuar.Piosenka;

public abstract class Muzyk extends Osoba implements Serializable{

	private int poziomUmiejetnosci;

	private Piosenka[] repertuar ;
	
	public Muzyk(String imie, String nazwisko, int stawka,int poziomUmiejetnosci, Piosenka[] repertuar) {
		
		super(imie, nazwisko,stawka);

		this.poziomUmiejetnosci = poziomUmiejetnosci;

		this.repertuar=repertuar;
		
		
	
	}
	public Muzyk() {
		
	}
	public static void play(Muzyk muzyk) {
		
		System.out.println("Odtwarzam demo muzyka...");
		
		
	}


	@Override
	public String toString() {
		return "Muzyk " + this.getImie() + " " + this.getNazwisko();
	}


	public int getPoziomUmiejetnosci() {
		return poziomUmiejetnosci;
	}


	public void setPoziomUmiejetnosci(int poziomUmiejetnosci) {
		this.poziomUmiejetnosci = poziomUmiejetnosci;
	}





	public void setStawka(int stawka) {
		this.stawka = stawka;
	}


	public Piosenka[] getRepertuar() {
		return repertuar;
	}

	public void setRepertuar(Piosenka[] repertuar) {
		this.repertuar = repertuar;
	}
}
