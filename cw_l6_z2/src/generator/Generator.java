package generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import instrument.Keyboard;
import instrument.Saksofon;
import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Wokalista;
import repertuar.Piosenka;
import rider.Rider;
import technika.Technik;
import zespol.Zespol;
import muzycy.Saksofonista;
import instrument.Instrument;
import sprzet.Mikrofon;
import repertuar.Krytyk;
import database.Dane;
import database.TextIO;

public class Generator {

	static Muzyk[] muzycy;
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;
	static Instrument[] instrument;
	static Mikrofon[] mikrofony;
	static Piosenka[] baza;
  
	public static void main (String [] args) throws ClassNotFoundException, IOException {


		TextIO.pobierzDane();
		Dane.initializeDatabase();

		
		podstawowy = Dane.getPodstawowy();
		bogatszy = Dane.getBogatszy();
		najbogatszy = Dane.getNajbogatszy();
		technicy = Dane.getTechnicy();
		
		
//		TextIO.zresetujDane();
//		muzycy[0].setImie("Test");
//		Dane.wydrukujMuzykow(muzycy);
		
		

		

		
		Wokalista wokalista = (Wokalista)generateMuzyk("class muzycy.Wokalista");
		Pianista pianista = (Pianista)generateMuzyk("class muzycy.Pianista");
		Saksofonista saksofonista = (Saksofonista)generateMuzyk("class muzycy.Saksofonista");
		Technik technik = generateTechnik(wokalista, pianista, saksofonista);

		
		
		sendBrief(wokalista, pianista, technik, saksofonista);			
//		Zespol.optimalTeam(technicy, muzycy, 1500);

		
//		System.out.println("-----------------");
//		System.out.println("Demonstracja mechanizmu polimorfizmu na przykladzie metody play:");
//		pianista.play(pianista);
//		wokalista.play(wokalista);
		

		
		TextIO.zapiszDane();
	}
	
	
	//generowanie propozycji koncertu
	public static void sendBrief(Wokalista wokalista, Pianista pianista, Technik technik, Saksofonista saksofonista) {
		
		Rider rider = technik.getRider();
		
		System.out.println("Brief koncertu " + wokalista.getImie() + " " + wokalista.getNazwisko() + " przy akompaniamencie " + pianista.getImie() + " " + pianista.getNazwisko()+", "+saksofonista.getImie()+" "+saksofonista.getNazwisko());
		System.out.println("--------------------------------");
		System.out.println("\u001B[31m" +"Stawka zespolu: " + seePrice(wokalista, pianista, saksofonista) + " zl"+ "\u001B[0m");
		System.out.println("Umiejetnosci sumaryczne zespolu w skali 0-15: " + (wokalista.getPoziomUmiejetnosci()+pianista.getPoziomUmiejetnosci()+saksofonista.getPoziomUmiejetnosci()));
		System.out.println("W tym klawiszowiec: " + pianista.getPoziomUmiejetnosci() + "/5 Saksofonista: " + saksofonista.getPoziomUmiejetnosci() + "/5 Wokalista: " + wokalista.getPoziomUmiejetnosci() + "/5");
		System.out.println("Instrument klawiszowca: " + pianista.getStringKeyboard());


		System.out.println("Instrument saksofonisty: "+ saksofonista.getStringSaksofon());
		System.out.println("--------------------------------");
		System.out.println("Szczegoly dotyczace rideru:");
		System.out.print("Mikrofon wokalistki: "); 
		wokalista.wyswietlUlubionyMikrofon();
		System.out.println("Przekaski: " + rider.getPrzekaski());
		System.out.println("W przypadku wyjazdu, minimalny standard hotelu: " + rider.getHotel());
		System.out.println("Minimalne wymiary sceny: " + rider.getStageSize());
		System.out.println("Czy potrzebni handzi? " + rider.isHandsNeeded());
		System.out.println("Technik: " + technik.getImie() + " " + technik.getNazwisko());
		System.out.println("Poziom umiejetnosci technika: " + technik.getPoziom_umiejetnosci() + "/5");
		System.out.println("Preferowany stol: " + technik.getPreferowany_stol());
		System.out.println("Stawka technika: " + technik.getStawka() + " zl");
		System.out.println("--------------------------------");
		System.out.println("\u001B[31m" + "Koszt zespolu: " + (seePrice(wokalista, pianista, saksofonista) + technik.getStawka()) + " zl" + "\u001B[0m");
		System.out.println("--------------------------------");
		System.out.println("Repertuar:");
		wydrukujRepertuar(wokalista, pianista, saksofonista);
		


		
		
	}
	
	//wydrukuj liste zawierajaca utwory wszystkich muzyków, bez powtórzeń
	public static void wydrukujRepertuar(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {
		
		ArrayList<Piosenka> repertuar = new ArrayList<Piosenka>();
		
		repertuar.addAll(Arrays.asList(wokalista.getRepertuar()));
		
		for(int i = 0; i < pianista.getRepertuar().length; i++) {
			
			if(repertuar.contains(pianista.getRepertuar()[i]) == false) {
				repertuar.add(pianista.getRepertuar()[i]);
			}
			
		}
		for(int i = 0; i < saksofonista.getRepertuar().length; i++) {
			
			if(repertuar.contains(saksofonista.getRepertuar()[i]) == false) {
				repertuar.add(saksofonista.getRepertuar()[i]);
			}
			
		}
		
	//drukowanie
		
		System.out.println("Liczba utworów mozliwych do zagrania: " + repertuar.size());
		
		for(int i = 0; i < repertuar.size(); i++) {
			
			System.out.println(repertuar.get(i));
			
			
		}
		
		
	}
	
	
	
	
	//metoda zwracajaca cene wystepu wokalisty i pianisty przeslanego jako parametr
	public static int seePrice(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {

		int price = wokalista.getStawka() + pianista.getStawka() + saksofonista.getStawka();

		return price;
	}
	
	
	
	//przydzielenie technika w zależności od budżetu
	public static Technik generateTechnik(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {
		
		int price = seePrice(wokalista, pianista, saksofonista);
		
		if(price < 1800) {
			return technicy[0];
		} else if (price < 2500) {
			return technicy[1];
		} else {
			return technicy[2];
		}
		
		
		
	}
	
	//zastepuje metody generateWokaliska, generatePianista, generateSaksofonista
	public static Muzyk generateMuzyk(String jakiMuzyk) //format wprowadzania: "class packageName.className" na przyklad "class muzycy.Pianista"
	{
		Random generator = new Random();
		int randomNumber;
		
		do
		{
			randomNumber = generator.nextInt(muzycy.length);
			
		}while(!(muzycy[randomNumber].getClass().toString().equals(jakiMuzyk)));
		
		return muzycy[randomNumber];
	}

	
	//generowanie przypadkowego wokalisty
	/*public static Wokalista generateWokalista() {
		
		Random generator = new Random();
		Wokalista wokalista;
		int randomNumber = generator.nextInt(muzycy.length);
		
		//wybierz wokaliste
		
		while(!(muzycy[randomNumber] instanceof Wokalista)) {
			
			randomNumber = generator.nextInt(muzycy.length);
			
		}
		wokalista = (Wokalista) muzycy[randomNumber];
				
		
		
		return wokalista;
		
	}
	
	//generowanie przypadkowego pianisty
	public static Pianista generatePianista() {
		
		Random generator = new Random();
		Pianista pianista;
		int randomNumber = generator.nextInt(muzycy.length);		
		
		//wybierz pianista
		
		while(!(muzycy[randomNumber] instanceof Pianista)) {
			
			randomNumber = generator.nextInt(muzycy.length);
		
		}
		pianista = (Pianista) muzycy[randomNumber];		
		
		
		
		return pianista;
		
	}
	//generowanie losowego saksofonisty
	public static Saksofonista generateSaksofonista() {

		Random generator = new Random();
		Saksofonista saksofonista;
		int randomNumber = generator.nextInt(muzycy.length);

		//wybierz saksofoniste

		while (!(muzycy[randomNumber] instanceof Saksofonista)) {

			randomNumber = generator.nextInt(muzycy.length);

		}
		saksofonista = (Saksofonista) muzycy[randomNumber];


		return saksofonista;

	} */

	//zastepuje generateKeyboard i generateSaksofon
	public static Instrument generateInstrument(String jakiInstrument) //format wprowadzania: "class packageName.className" na przyklad "class instrument.Keyboard"
	{
		Random generator = new Random();
		int randomNumber;
		
		do{
			
			randomNumber = generator.nextInt(instrument.length);
			
		}while(!(instrument[randomNumber].getClass().toString().equals(jakiInstrument)));
		
		return instrument[randomNumber];
	}
	
	//generowanie losowego keyboarda
	/*public static Keyboard generateKeyboard() {

		Random generator = new Random();
		Keyboard keyboard;
		int randomNumber = generator.nextInt(instrument.length);

		//wybierz keyboard

		while (!(instrument[randomNumber] instanceof Keyboard)) {

			randomNumber = generator.nextInt(instrument.length);

		}
		keyboard = (Keyboard) instrument[randomNumber];


		return keyboard;

	}

	//generowanie losowego saksofonu
	public static Saksofon generateSaksofon() {

		Random generator = new Random();
		Saksofon saksofon;
		int randomNumber = generator.nextInt(instrument.length);

		//wybierz saksofon

		while (!(instrument[randomNumber] instanceof Saksofon)) {

			randomNumber = generator.nextInt(instrument.length);

		}
		saksofon = (Saksofon) instrument[randomNumber];


		return saksofon;

	} */
	
	//generowanie losowego mikrofonu
	public static Mikrofon generateMikrofon() {

		Random generator = new Random();
		Mikrofon mikrofon;
		int randomNumber = generator.nextInt(mikrofony.length);

		//wybierz mikrofon

		randomNumber = generator.nextInt(mikrofony.length);

		mikrofon = mikrofony[randomNumber];


		return mikrofon;

	

	}
	
	//generowanie przypadkowego trio i wydrukowanie imienia i nazwiska, metoda nieużywana
	public static void generateTrio() {
		
		Wokalista wokalista = (Wokalista)generateMuzyk("class muzycy.Wokalista");
		Pianista pianista = (Pianista)generateMuzyk("class muzycy.Pianista");
		Saksofonista saksofonista = (Saksofonista)generateMuzyk("class muzycy.Saksofonista");
		
		System.out.println("Wygenerowano trio:");
		System.out.println("Pianista: " + pianista.getImie() + " " + pianista.getNazwisko());
		System.out.println("Wokalista: " + wokalista.getImie() + " " + wokalista.getNazwisko());
		System.out.println("Saksofonista: "+saksofonista.getImie()+" "+saksofonista.getNazwisko());
		
		
		
	}
	



	public static Muzyk[] getMuzycy() {
		return muzycy;
	}


	public static void setMuzycy(Muzyk[] muzycy) {
		Generator.muzycy = muzycy;
	}


	public static Instrument[] getInstrument() {
		return instrument;
	}


	public static void setInstrument(Instrument[] instrument) {
		Generator.instrument = instrument;
	}


	public static Mikrofon[] getMikrofony() {
		return mikrofony;
	}


	public static void setMikrofony(Mikrofon[] mikrofony) {
		Generator.mikrofony = mikrofony;
	}


	public static Piosenka[] getBaza() {
		return baza;
	}


	public static void setBaza(Piosenka[] baza) {
		Generator.baza = baza;
	}
	
	






}
