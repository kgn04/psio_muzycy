package muzycy;

import repertuar.Piosenka;

public abstract class Muzyk extends Osoba{

	private int poziomUmiejetnosci;
	private int stawka;
	private Piosenka[] repertuar ;
	
	public Muzyk(String imie, String nazwisko, int poziomUmiejetnosci, int stawka,Piosenka[] repertuar) {
		
		super(imie, nazwisko);

		this.poziomUmiejetnosci = poziomUmiejetnosci;
		this.stawka = stawka;
		this.repertuar=repertuar;
		
		
	
	}
	public static void play(Muzyk muzyk) {
		
		System.out.println("Odtwarzam demo muzyka...");
		
		
	}





	public int getPoziomUmiejetnosci() {
		return poziomUmiejetnosci;
	}


	public void setPoziomUmiejetnosci(int poziomUmiejetnosci) {
		this.poziomUmiejetnosci = poziomUmiejetnosci;
	}


	public int getStawka() {
		return stawka;
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
