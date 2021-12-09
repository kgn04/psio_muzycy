package generator;

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

public class Generator {

	static Muzyk[] muzycy;
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;
	static Instrument[] instrument;
	static Mikrofon[] mikrofony;
	static Piosenka[] baza;

	public static void main (String [] args) {


		initializeRider();
		initializeBazaPiosenek();
		initializeMuzycy();
		initializeTechnik();
		initializeInstrument();
		initializeMikrofon();
		
		Wokalista wokalista = generateWokalista();
		Mikrofon mikrofon = generateMikrofon();
		Pianista pianista = generatePianista();
		Saksofonista saksofonista = generateSaksofonista();
		Keyboard keyboard = generateKeyboard();
		Saksofon saksofon = generateSaksofon();
		Technik technik = generateTechnik(wokalista, pianista, saksofonista);
		
		wokalista.setMikrofon(mikrofon);
		pianista.setKeyboard(keyboard);
		saksofonista.setSaksofon(saksofon);
		
		sendBrief(wokalista, pianista, technik, saksofonista);
		wylosujRepertuar(baza);
		
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

		//wybierz keyboard



		randomNumber = generator.nextInt(mikrofony.length);

		mikrofon = mikrofony[randomNumber];


		return mikrofon;

	}

	
	
	//metody inicjalizujace 'baze danych'
	public static void initializeMuzycy() {

		final int n = 60;
		muzycy = new Muzyk[n];

		/// Pianiści

		muzycy[0] = new Pianista("Jan", "Kowalski", 3, 400, "Pojedynczy", false,wylosujRepertuar(baza));
		muzycy[1] = new Pianista("Malgorzata", "Testowa",4, 500, "Pojedynczy", true,wylosujRepertuar(baza));
		muzycy[2] = new Pianista("Aleksander", "Prawdziwy",4, 900, "Podwójny", false,wylosujRepertuar(baza));
		muzycy[3] = new Pianista("Paweł", "Nowak", 4, 800, "Stolikowy", true,wylosujRepertuar(baza));
		muzycy[4] = new Pianista("Karol", "Wiśniewski", 2, 400, "Typ Z", true,wylosujRepertuar(baza));
		muzycy[5] = new Pianista("Bronisław", "Wójcik", 1, 100, "Podwójny", false,wylosujRepertuar(baza));
		muzycy[6] = new Pianista("Czesław", "Kowalczyk", 2, 300, "Pojedynczy", false,wylosujRepertuar(baza));
		muzycy[7] = new Pianista("Robert", "Lewandowski", 3, 500, "Podwójny", true,wylosujRepertuar(baza));
		muzycy[8] = new Pianista("Filip", "Hajzer", 1, 300, "Stolikowy", true,wylosujRepertuar(baza));
		muzycy[9] = new Pianista("Grzegorz", "Piotrowski", 5, 1200,"Typ Z", true,wylosujRepertuar(baza));
		muzycy[10] = new Pianista("Jerzy", "Mazur", 1, 500, "Pojedynczy", false,wylosujRepertuar(baza));
		muzycy[11] = new Pianista("Kacper", "Wojciechowski", 4, 700, "Podwójny", false,wylosujRepertuar(baza));
		muzycy[12] = new Pianista("Beata", "Krawczyk", 3, 500, "Stolikowy", true,wylosujRepertuar(baza));
		muzycy[13] = new Pianista("Danuta", "Kołodziejczyk", 2, 300,"Typ Z", true,wylosujRepertuar(baza));
		muzycy[14] = new Pianista("Katarzyna", "Grabowska", 3, 700, "Stolikowy",true,wylosujRepertuar(baza));
		muzycy[15] = new Pianista("Zofia", "Król", 1, 200, "Podwójny", false,wylosujRepertuar(baza));
		muzycy[16] = new Pianista("Anna", "Michalska", 5, 1000, "Podwójny", true,wylosujRepertuar(baza));
		muzycy[17] = new Pianista("Julia", "Kaczmarek", 3, 600, "Pojedynczy", false,wylosujRepertuar(baza));
		muzycy[18] = new Pianista("Marzena", "Jankowska", 4, 800, "Podwójny", true,wylosujRepertuar(baza));
		muzycy[19] = new Pianista("Zuzanna", "Zając", 2, 500, "Stolikowy", true,wylosujRepertuar(baza));

		/// Wokaliści

		muzycy[20] = new Wokalista("Janina", "Kowalska", 2, 100, "C3", "D6",wylosujRepertuar(baza));
		muzycy[21] = new Wokalista("Arnold", "Fajny",  4, 600, "F3", "H5",wylosujRepertuar(baza));
		muzycy[22] = new Wokalista("Bartosz", "Górski", 3, 400, "D1", "A3",wylosujRepertuar(baza));
		muzycy[23] = new Wokalista("Bożena", "Malinowska", 1, 100, "H2", "B6",wylosujRepertuar(baza));
		muzycy[24] = new Wokalista("Agnieszka", "Pawlak", 5, 800, "A2", "H7",wylosujRepertuar(baza));
		muzycy[25] = new Wokalista("Edyta", "Nowicka", 4, 700, "C3", "E6",wylosujRepertuar(baza));
		muzycy[26] = new Wokalista("Halina", "Sikora", 3, 500, "F3", "C7",wylosujRepertuar(baza));
		muzycy[27] = new Wokalista("Magdalena", "Witkowski", 2, 300, "C4", "A8",wylosujRepertuar(baza));
		muzycy[28] = new Wokalista("Jolanta", "Baran", 1, 200, "H3", "C4",wylosujRepertuar(baza));
		muzycy[29] = new Wokalista("Elżbieta", "Szewczyk", 4, 700, "A3", "F5",wylosujRepertuar(baza));
		muzycy[30] = new Wokalista("Patrycja", "Szpak", 2, 300, "B4", "C6",wylosujRepertuar(baza));
		muzycy[31] = new Wokalista("Mateusz", "Rutkowski", 3, 500, "A1", "H4",wylosujRepertuar(baza));
		muzycy[32] = new Wokalista("Anastazja", "Ostrowska", 3, 600, "H2", "G5",wylosujRepertuar(baza));
		muzycy[33] = new Wokalista("Patryk", "Pietrzak", 4, 600, "G1", "H3",wylosujRepertuar(baza));
		muzycy[34] = new Wokalista("Łukasz", "Olszański", 1, 200, "C2", "Gis3",wylosujRepertuar(baza));
		muzycy[35] = new Wokalista("Sławomir", "Dudek", 5, 1000, "B1", "C5",wylosujRepertuar(baza));
		muzycy[36] = new Wokalista("Andrzej", "Wróblewski", 2, 300, "B2", "H4",wylosujRepertuar(baza));
		muzycy[37] = new Wokalista("Rafał", "Masny", 4, 600, "D2", "A4",wylosujRepertuar(baza));
		muzycy[38] = new Wokalista("Krzysztof", "Ibisz", 3, 500, "G2", "C5",wylosujRepertuar(baza));
		muzycy[39] = new Wokalista("Cezary", "Wytwer", 1, 100, "A4", "C5",wylosujRepertuar(baza));

		/// Saksofoniści

		muzycy[40] = new Saksofonista("Maria", "Nowak", 4, 1000, false,wylosujRepertuar(baza));
		muzycy[41] = new Saksofonista("Marzena", "Dąbrowska", 2, 500, false,wylosujRepertuar(baza));
		muzycy[42] = new Saksofonista("Jakub", "Zieliński", 3, 800, false,wylosujRepertuar(baza));
		muzycy[43] = new Saksofonista("Andrzej", "Kozłowski", 1, 400, true,wylosujRepertuar(baza));
		muzycy[44] = new Saksofonista("Antoni", "Grajek", 2, 400, false,wylosujRepertuar(baza));
		muzycy[45] = new Saksofonista("Ignacy", "Krawczyk", 4, 900, true,wylosujRepertuar(baza));
		muzycy[46] = new Saksofonista("Laura", "Jasińska", 1, 300, true,wylosujRepertuar(baza));
		muzycy[47] = new Saksofonista("Emilia", "Skowrońska", 5, 1200, false,wylosujRepertuar(baza));
		muzycy[48] = new Saksofonista("Iga", "Kos", 4, 500, false,wylosujRepertuar(baza));
		muzycy[49] = new Saksofonista("Marcelina", "Nogaj", 3, 700, true,wylosujRepertuar(baza));
		muzycy[50] = new Saksofonista("Natalia", "Baranowska", 5, 1100, true,wylosujRepertuar(baza));
		muzycy[51] = new Saksofonista("Michał", "Leszczyński", 4, 600, false,wylosujRepertuar(baza));
		muzycy[52] = new Saksofonista("Dawid", "Zalewski", 1, 100,true,wylosujRepertuar(baza));
		muzycy[53] = new Saksofonista("Agata", "Tomaszewska", 2, 300, false,wylosujRepertuar(baza));
		muzycy[54] = new Saksofonista("Kinga", "Ptak", 4, 700, true,wylosujRepertuar(baza));
		muzycy[55] = new Saksofonista("Marcel", "Zawadzki", 3, 600, true,wylosujRepertuar(baza));
		muzycy[56] = new Saksofonista("Leon", "Chmielewski", 5, 1000, false,wylosujRepertuar(baza));
		muzycy[57] = new Saksofonista("Nikodem", "Sawicki", 1, 400, false,wylosujRepertuar(baza));
		muzycy[58] = new Saksofonista("Maksymilian", "Kalinowski", 2, 400, true,wylosujRepertuar(baza));
		muzycy[59] = new Saksofonista("Miłosz", "Maciejewski", 3, 500, true,wylosujRepertuar(baza));
		
		Krytyk.ocenaUmiejetnosci(muzycy);

	}
	
	public static void initializeRider() {
		
		podstawowy = new Rider("Chipsy, paluszki", "4 gwiazdki", false, "10x5m", 3);
		bogatszy = new Rider("Chipsy, paluszki, kanapki", "4 gwiazdki", false, "15x7m", 4);
		najbogatszy = new Rider("Chipsy, paluszki, kanapki, obiad", "5 gwiazdek", true, "20x20m", 5);
		
		
		
	}
	
	public static void initializeTechnik() {
		
		technicy = new Technik[3];
		
		technicy[0] = new Technik("Adam", "Kowalski", 300, 2, "Behringer X32", podstawowy);
		technicy[1] = new Technik("Pawel", "Testowy", 500, 4, "Yamaha CL5", bogatszy);
		technicy[2] = new Technik("Gawel", "Niepawel", 800, 5, "Soundcraft Si800", najbogatszy);
		
		
	}

	public static void initializeInstrument() {

		final int m = 20;
		instrument = new Instrument[m];

		/// Saksofony

		instrument[0] = new Saksofon("Lupifaro", 2000, 2010, "sopranowy", "B");
		instrument[1] = new Saksofon("Lupifaro", 5000, 2010, "altowy", "Es");
		instrument[2] = new Saksofon("Selmer", 3500, 2012, "basowy", "B");
		instrument[3] = new Saksofon("Keilwerth", 8000, 2021, "tenorowy", "Es");
		instrument[4] = new Saksofon("Conn", 6400, 2017, "altowy", "Es");
		instrument[5] = new Saksofon("SML", 3000, 2009, "sopranowy", "B");
		instrument[6] = new Saksofon("Buescher", 5500, 2016, "tenorowy", "B");
		instrument[7] = new Saksofon("B&S", 1200, 2003, "basowy", "B");
		instrument[8] = new Saksofon("Jupiter", 9200, 2021, "sopranowy", "Es");
		instrument[9] = new Saksofon("Cannonball", 4200, 2014, "tenorowy", "B");

		/// Keyboardy

		instrument[10] = new Keyboard("Yamaha", 1200, 2002, "profesjonalna", "ważona", "sekwencer");
		instrument[11] = new Keyboard("Yamaha", 900, 2010, "srednia", "syntezatorowa", "glosniki");
		instrument[12] = new Keyboard("Casio", 1500, 2012, "profesjonalna", "doważana", "pulpit pod nuty, zasilacz sieciowy");
		instrument[13] = new Keyboard("Korg", 1000, 2016, "srednia", "mloteczkowa", "glosniki, pulpit pod nuty");
		instrument[14] = new Keyboard("Roland", 1300, 2004, "profesjonalna", "syntezatorowa", "zasilacz sieciowy");
		instrument[15] = new Keyboard("Gear4music", 2500, 2021, "srednia", "pelna", "sekwencer, glosniki");
		instrument[16] = new Keyboard("Korg", 1800, 2012, "profesjonalna", "syntezatorowa", "glosniki, sekwencer");
		instrument[17] = new Keyboard("Casio", 2300, 2017, "profesjonalna", "ważona", "pulpit pod nuty");
		instrument[18] = new Keyboard("Roland", 800, 2009, "srenia", "mloteczkowa", "sekwencer");
		instrument[19] = new Keyboard("Gear4music", 3000, 2021, "profesjonalna", "pelna", "sekwencer, pulpit pod nuty, glosniki, zasilacz sieciowy");
	}


	public static void initializeMikrofon() {

		final int k = 10;
		mikrofony = new Mikrofon[k];
		
		mikrofony[0] = new Mikrofon("Sennheiser", "e835", true);
		mikrofony[1] = new Mikrofon("Carol", "GS-607", false);
		mikrofony[2] = new Mikrofon("BEHRINGER", "8500", true);
		mikrofony[3] = new Mikrofon("Rode", "NT-USB", false);
		mikrofony[4] = new Mikrofon("Sontronics", "SOLO", true);
		mikrofony[5] = new Mikrofon("AKG", "WMS40", true);
		mikrofony[6] = new Mikrofon("Shure", "SM 58", true);
		mikrofony[7] = new Mikrofon("Blitzwolf", "TR458", false);
		mikrofony[8] = new Mikrofon("AKG", "C-544L", true);
		mikrofony[9] = new Mikrofon("ICHOS", "5900626834223", false);
	}
	public static void initializeBazaPiosenek(){
		baza=new Piosenka[15];

		baza[0]=new Piosenka("Cheri cheri lady","pop","1982");
		baza[1]=new Piosenka("Ooop!...I did it again","pop","2000");
		baza[2]=new Piosenka("Circus","pop","2008");
		baza[3]=new Piosenka("Toxic","pop","2003");
		baza[4]=new Piosenka("Umbrella","pop","2008");
		baza[5]=new Piosenka("505","rock","2007");
		baza[6]=new Piosenka("Let the Bad Times Roll","rock","2021");
		baza[7]=new Piosenka("Africa","pop","1985");
		baza[8]=new Piosenka("California","rock alternatywny","1999");
		baza[9]=new Piosenka("Cant't stop","rock alternatywny","2002");
		baza[10]=new Piosenka("We will rock you","rock","1977");
		baza[10]=new Piosenka("Bohemian rhapsody","rock","1975");
		baza[10]=new Piosenka("Mniej niż zero","pop-rock","1981");
		baza[10]=new Piosenka("Kryzysowa nazeczona","soft rock","1983");
		baza[10]=new Piosenka("Bad romance","pop","2009");
		baza[10]=new Piosenka("Shallow","pop","2018");
	}
	public static Piosenka[] wylosujRepertuar(Piosenka[] P){
		Random generator= new Random();
		Piosenka[] repertuar= new Piosenka[generator.nextInt(15)+1];
		for(int i=0;i<repertuar.length;i++){
			repertuar[i]=P[i];
		}
		return repertuar;
	}



}
