package generator;

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
import muzycy.Saksofonista;
import instrument.Instrument;
import sprzet.Mikrofon;
import repertuar.Krytyk;
import database.Dane;

public class Generator {

	static Muzyk[] muzycy = Dane.getMuzycy();
	static Rider podstawowy = Dane.getPodstawowy();
	static Rider bogatszy = Dane.getBogatszy();
	static Rider najbogatszy = Dane.getNajbogatszy();
	static Technik[] technicy = Dane.getTechnicy();
	static Instrument[] instrument = Dane.getInstrument();
	static Mikrofon[] mikrofony = Dane.getMikrofony();
	static Piosenka[] baza = Dane.getBaza();

	public static void main (String [] args) {

		Dane.initializeDatabase();
		instrument = Dane.getInstrument();
		mikrofony = Dane.getMikrofony();
		baza = Dane.getBaza();
		muzycy = Dane.getMuzycy();
		podstawowy = Dane.getPodstawowy();
		bogatszy = Dane.getBogatszy();
		najbogatszy = Dane.getNajbogatszy();
		technicy = Dane.getTechnicy();

		Dane.przydzielInstrumenty();
		
		
		Wokalista wokalista = generateWokalista();
		Pianista pianista = generatePianista();
		Saksofonista saksofonista = generateSaksofonista();
		Technik technik = generateTechnik(wokalista, pianista, saksofonista);

		
		
		sendBrief(wokalista, pianista, technik, saksofonista);
		
		
//		System.out.println("-----------------");
//		System.out.println("Demonstracja mechanizmu polimorfizmu na przykladzie metody play:");
//		pianista.play(pianista);
//		wokalista.play(wokalista);
		
		
	}
	
	
	//generowanie propozycji koncertu
	public static void sendBrief(Wokalista wokalista, Pianista pianista, Technik technik, Saksofonista saksofonista) {
		
		Rider rider = technik.getRider();
		
		System.out.println("Brief koncertu " + wokalista.getImie() + " " + wokalista.getNazwisko() + " przy akompaniamencie " + pianista.getImie() + " " + pianista.getNazwisko()+", "+saksofonista.getImie()+" "+saksofonista.getNazwisko());
		System.out.println("--------------------------------");
		System.out.println("\u001B[31m" +"Stawka zespolu: " + seePrice(wokalista, pianista, saksofonista) + " zl"+ "\u001B[0m");
		System.out.println("Umiejetnosci sumaryczne zespolu w skali 0-15: " + (wokalista.getPoziomUmiejetnosci()+pianista.getPoziomUmiejetnosci()+saksofonista.getPoziomUmiejetnosci()));
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
	
	
	
	//generowanie przypadkowego trio i wydrukowanie imienia i nazwiska
	public static void generateTrio() {
		
		Wokalista wokalista = generateWokalista();
		Pianista pianista = generatePianista();
		Saksofonista saksofonista = generateSaksofonista();
		
		System.out.println("Wygenerowano trio:");
		System.out.println("Pianista: " + pianista.getImie() + " " + pianista.getNazwisko());
		System.out.println("Wokalista: " + wokalista.getImie() + " " + wokalista.getNazwisko());
		System.out.println("Saksofonista: "+saksofonista.getImie()+" "+saksofonista.getNazwisko());
		
		
		
	}
	
	//generowanie przypadkowego wokalisty
	public static Wokalista generateWokalista() {
		
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

	}

	//generowanie losowego keyboarda
	public static Keyboard generateKeyboard() {

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

	}

	public static Mikrofon generateMikrofon() {

		Random generator = new Random();
		Mikrofon mikrofon;
		int randomNumber = generator.nextInt(mikrofony.length);

		//wybierz mikrofon

		randomNumber = generator.nextInt(mikrofony.length);

		mikrofon = mikrofony[randomNumber];


		return mikrofon;

	

	}
	







}
