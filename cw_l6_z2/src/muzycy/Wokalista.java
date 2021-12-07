package muzycy;


public class Wokalista extends Muzyk {
	
	private String skalaPoczatek;
	private String skalaKoniec;
	private String ulubionyMikrofon;
	
	public Wokalista(String imie, String nazwisko, int poziomUmiejetnosci, int stawka, String skalaPoczatek, String skalaKoniec, String ulubionyMikrofon) {
		
		super(imie,nazwisko,poziomUmiejetnosci,stawka);
		
		this.skalaPoczatek = skalaPoczatek;
		this.skalaKoniec = skalaKoniec;
		this.ulubionyMikrofon = ulubionyMikrofon;
		
	}
	//metoda przyslonieta z klasy muzyk
	public void play(Wokalista wokalista) {
		
		System.out.println("Odtwarzam demo wokalisty: " + wokalista.getImie() + " " + wokalista.getNazwisko());
	}

	public String getSkalaPoczatek() {
		return skalaPoczatek;
	}

	public void setSkalaPoczatek(String skalaPoczatek) {
		this.skalaPoczatek = skalaPoczatek;
	}

	public String getSkalaKoniec() {
		return skalaKoniec;
	}

	public void setSkalaKoniec(String skalaKoniec) {
		this.skalaKoniec = skalaKoniec;
	}

	public String getUlubionyMikrofon() {
		return ulubionyMikrofon;
	}

	public void setUlubionyMikrofon(String ulubionyMikrofon) {
		this.ulubionyMikrofon = ulubionyMikrofon;
	}


	

}
