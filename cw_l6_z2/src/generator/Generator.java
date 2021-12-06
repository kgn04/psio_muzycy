package generator;

import java.util.Random;

import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Wokalista;
import rider.Rider;
import muzycy.Technik;

public class Generator {
	
	static Muzyk[] muzycy;
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;

	public static void main(String[] args) {
		
		initializeRider();
		initializeMuzycy();
		initializeTechnik();
		
		Wokalista wokalista = generateWokalista();
		Pianista pianista = generatePianista();
		Technik technik = generateTechnik(wokalista, pianista);
		
		sendBrief(wokalista, pianista, technik);
		
//		System.out.println("-----------------");
//		System.out.println("Demonstracja mechanizmu polimorfizmu na przykladzie metody play:");
//		pianista.play(pianista);
//		wokalista.play(wokalista);
		
		

	}
	
	
	//generowanie propozycji koncertu
	public static void sendBrief(Wokalista wokalista, Pianista pianista, Technik technik) {
		
		Rider rider = technik.getRider();
		
		System.out.println("Brief koncertu " + wokalista.getImie() + " " + wokalista.getNazwisko() + " przy akompaniamencie " + pianista.getImie() + " " + pianista.getNazwisko());
		System.out.println("--------------------------------");
		System.out.println("Stawka zespolu: " + seePrice(wokalista, pianista) + " zl");
		System.out.println("Umiejetnosci sumaryczne zespolu w skali 0-10: " + (wokalista.getPoziomUmiejetnosci()+pianista.getPoziomUmiejetnosci()));
		System.out.println("Instrument klawiszowca: " + pianista.getModelInstrumentu());
		
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
		System.out.println("Koszt zespolu: " + (seePrice(wokalista, pianista) + technik.getStawka()) + " zl");

		
		
	}
	
	
	
	//metoda zwracajaca cene wystepu wokalisty i pianisty przeslanego jako parametr
	public static int seePrice(Wokalista wokalista, Pianista pianista) {

		int price = wokalista.getStawka() + pianista.getStawka();

		return price;
	}
	
	
	

	public static Technik generateTechnik(Wokalista wokalista, Pianista pianista) {
		
		int price = seePrice(wokalista, pianista);
		
		if(price < 1200) {
			return technicy[0];
		} else if (price < 2000) {
			return technicy[1];
		} else {
			return technicy[2];
		}
		
		
		
	}
	
	
	
	//generowanie przypadkowej pary i wydrukowanie imienia i nazwiska
	public static void generatePair() {
		
		Wokalista wokalista = generateWokalista();
		Pianista pianista = generatePianista();
		
		System.out.println("Wygenerowano duet:");
		System.out.println("Pianista: " + pianista.getImie() + " " + pianista.getNazwisko());
		System.out.println("Wokalista: " + wokalista.getImie() + " " + wokalista.getNazwisko());
		
		
		
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
	
	
	
	
	//metody inicjalizujace 'baze danych'
	public static void initializeMuzycy() {
		
		muzycy = new Muzyk[7];
		
		muzycy[0] = new Pianista("Jan", "Kowalski", "Syntezator", 3, 200, "Nord Stage 2", "Pojedynczy", false);
		muzycy[1] = new Pianista("Malgorzata", "Testowa", "Pianino elektroniczne", 4, 500, "Roland d50", "Pojedynczy", true);
		muzycy[2] = new Pianista("Aleksander", "Prawdziwy", "Syntezatory", 4, 900, "Yamaha DX7 + Nord Grand 2", "Podwójny", false);
		muzycy[3] = new Wokalista("Janina", "Kowalska", "Wokal", 2, 150, "C3", "D6", "Shure sm58");
		muzycy[4] = new Wokalista("Arnold", "Fajny", "Wokal", 4, 600, "F3", "H5", "Akg c121");
		muzycy[5] = new Wokalista("Kasia", "Malinowska", "Wokal + tamburyn", 5, 1300, "C3", "H6", "Shure sm7b");
		muzycy[6] = new Pianista("Michal", "Kozacki", "Synezator + pianino", 5, 2000, "Nord Stage piano 6 + Nord Electro 6d", "Podwójny", false);
		
		
		
		
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
	



	
	
	

	
	
	
	
}
