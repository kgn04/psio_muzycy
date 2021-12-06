package muzycy;

public abstract class Muzyk extends Osoba{
	

	private String instrument;
	private int poziomUmiejetnosci;
	private int stawka;
	
	public Muzyk(String imie, String nazwisko, String instrument, int poziomUmiejetnosci, int stawka) {
		
		super(imie, nazwisko);
		this.instrument = instrument;
		this.poziomUmiejetnosci = poziomUmiejetnosci;
		this.stawka = stawka;
		
		
	
	}
	
	
	public static void play(Muzyk muzyk) {
		
		System.out.println("Odtwarzam demo muzyka...");
		
		
	}




	public String getInstrument() {
		return instrument;
	}


	public void setInstrument(String instrument) {
		this.instrument = instrument;
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
	
	
	
	
	

}
