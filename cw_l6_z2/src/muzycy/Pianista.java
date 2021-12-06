package muzycy;



public class Pianista extends Muzyk {
	
	private String modelInstrumentu;
	private String rodzajStatywu;
	private boolean czySpiewa;
	
	
	public Pianista(String imie, String nazwisko, String instrument, int poziomUmiejetnosci, int stawka, String modelInstrumentu, String rodzajStatywu, boolean czySpiewa) {
		
		super(imie,nazwisko,instrument,poziomUmiejetnosci,stawka);
		this.modelInstrumentu = modelInstrumentu;
		this.rodzajStatywu = rodzajStatywu;
		this.czySpiewa = czySpiewa;
		
	}
	//metoda przyslonieta z klasy muzyk
	public void play(Pianista pianista) {
		
		System.out.println("Odtwarzam demo pianisty: " + pianista.getImie() + " " + pianista.getNazwisko());
	}


	public String getModelInstrumentu() {
		return modelInstrumentu;
	}


	public void setModelInstrumentu(String modelInstrumentu) {
		this.modelInstrumentu = modelInstrumentu;
	}


	public String getRodzajStatywu() {
		return rodzajStatywu;
	}


	public void setRodzajStatywu(String rodzajStatywu) {
		this.rodzajStatywu = rodzajStatywu;
	}


	public boolean isCzySpiewa() {
		return czySpiewa;
	}


	public void setCzySpiewa(boolean czySpiewa) {
		this.czySpiewa = czySpiewa;
	}



	
	
	
	

}
