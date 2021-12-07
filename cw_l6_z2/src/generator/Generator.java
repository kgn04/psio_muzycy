package generator;

import java.util.Random;

import instrument.Keyboard;
import instrument.Saksofon;
import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Wokalista;
import rider.Rider;
import technika.Technik;
import muzycy.Saksofonista;
import instrument.Instrument;

public class Generator {

	static Muzyk[] muzycy;
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;
	static Instrument[] instrument;

	public static void main(String[] args) {


		initializeRider();
		initializeMuzycy();
		initializeTechnik();
		initializeInstrument();
		
		Wokalista wokalista = generateWokalista();
		Pianista pianista = generatePianista();
		Saksofonista saksofonista = generateSaksofonista();
		Keyboard keyboard = generateKeyboard();
		Saksofon saksofon = generateSaksofon();
		Technik technik = generateTechnik(wokalista, pianista, saksofonista);

		pianista.setKeyboard(keyboard);
		saksofonista.setSaksofon(saksofon);
		
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
		System.out.println("Stawka zespolu: " + seePrice(wokalista, pianista, saksofonista) + " zl");
		System.out.println("Umiejetnosci sumaryczne zespolu w skali 0-15: " + (wokalista.getPoziomUmiejetnosci()+pianista.getPoziomUmiejetnosci()+saksofonista.getPoziomUmiejetnosci()));
		System.out.println("Instrument klawiszowca: " + pianista.getStringKeyboard());


		System.out.println("Instrument saksofonisty: "+ saksofonista.getStringSaksofon());
		System.out.println("-------------------");
		System.out.println("Szczegoly dotyczace rideru:");
		System.out.println("Mikrofon wokalistki: " + wokalista.getUlubionyMikrofon());
		System.out.println("Przekaski: " + rider.getPrzekaski());
		System.out.println("W przypadku wyjazdu, minimalny standard hotelu: " + rider.getHotel());
		System.out.println("Minimalne wymiary sceny: " + rider.getStageSize());
		System.out.println("Czy potrzebni handzi? " + rider.isHandsNeeded());
		System.out.println("Technik: " + technik.getImie() + " " + technik.getNazwisko());
		System.out.println("Poziom umiejetnosci technika: " + technik.getPoziom_umiejetnosci() + "/10");
		System.out.println("Preferowany stol: " + technik.getPreferowany_stol());
		System.out.println("Stawka technika: " + technik.getStawka() + " zl");
		System.out.println("----------------");
		System.out.println("Koszt zespolu: " + (seePrice(wokalista, pianista, saksofonista) + technik.getStawka()) + " zl");

		
		
	}
	
	
	
	//metoda zwracajaca cene wystepu wokalisty i pianisty przeslanego jako parametr
	public static int seePrice(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {

		int price = wokalista.getStawka() + pianista.getStawka() + saksofonista.getStawka();

		return price;
	}
	
	
	

	public static Technik generateTechnik(Wokalista wokalista, Pianista pianista, Saksofonista saksofonista) {
		
		int price = seePrice(wokalista, pianista, saksofonista);
		
		if(price < 1200) {
			return technicy[0];
		} else if (price < 2000) {
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


	
	
	//metody inicjalizujace 'baze danych'
	public static void initializeMuzycy() {
		
		muzycy = new Muzyk[8];
		
		muzycy[0] = new Pianista("Jan", "Kowalski", 3, 200, "Pojedynczy", false);
		muzycy[1] = new Pianista("Malgorzata", "Testowa",4, 500, "Pojedynczy", true);
		muzycy[2] = new Pianista("Aleksander", "Prawdziwy",4, 900, "Podwójny", false);
		muzycy[3] = new Wokalista("Janina", "Kowalska", 2, 150, "C3", "D6", "Shure sm58");
		muzycy[4] = new Wokalista("Arnold", "Fajny",  4, 600, "F3", "H5", "Akg c121");
		muzycy[5] = new Wokalista("Kasia", "Malinowska",5, 1300, "C3", "H6", "Shure sm7b");
		muzycy[6] = new Pianista("Michal", "Kozacki",  5, 2000,  "Podwójny", false);
		muzycy[7] = new Saksofonista("Maria", "Nowak", 4, 1000, false);
		
		
		
	}
	
	public static void initializeRider() {
		
		podstawowy = new Rider("Chipsy, paluszki", "4 gwiazdki", false, "10x5m", 3);
		bogatszy = new Rider("Chipsy, paluszki, kanapki", "4 gwiazdki", false, "15x7m", 4);
		najbogatszy = new Rider("Chipsy, paluszki, kanapki, obiad", "5 gwiazdek", true, "20x20m", 5);
		
		
		
	}
	
	public static void initializeTechnik() {
		
		technicy = new Technik[3];
		
		technicy[0] = new Technik("Adam", "Kowalski", 300, 4, "Behringer X32", podstawowy);
		technicy[1] = new Technik("Pawel", "Testowy", 500, 7, "Yamaha CL5", bogatszy);
		technicy[2] = new Technik("Gawel", "Niepawel", 800, 9, "Soundcraft Si800", najbogatszy);
		
		
	}

	public static void initializeInstrument() {

		instrument = new Instrument[4];

		instrument[0] = new Saksofon("Lupifaro", 2000, 2010, "sporanowy", "B");
		instrument[1] = new Keyboard("yamaha", 1200, 2002, "profasjonalna", "ważona", "sekwencer");
		instrument[2] = new Saksofon("Lupifaro", 5000, 2010, "altowy", "Es");
		instrument[3] = new Keyboard("yamaha", 900, 2010, "srednia", "syntezatorowa", "glosniki");
	}













	}
