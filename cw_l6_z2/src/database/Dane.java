package database;

import instrument.Instrument;
import instrument.Keyboard;
import instrument.Saksofon;
import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import repertuar.Krytyk;
import repertuar.Piosenka;
import rider.Rider;
import sprzet.Mikrofon;
import technika.Technik;

import java.util.Random;

import generator.Generator;

public class Dane {
	
	static Muzyk[] muzycy;
	static Instrument[] instrument;
	static Mikrofon[] mikrofony;
	static Piosenka[] baza;
	static Rider podstawowy;
	static Rider bogatszy;
	static Rider najbogatszy;
	static Technik[] technicy;
	
	
	public static void initializeDatabase() {
		
		initializeBazaPiosenek();
		initializeMuzycy();
		initializeRider();
		initializeTechnik();

		
		//hotfix
		poprawCeneMuzykow(muzycy);	
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
		
		
		
		initializeInstrument();
		initializeMikrofon();
		

		
		
		Krytyk.ocenaUmiejetnosci(muzycy);
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
		baza=new Piosenka[16];

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
		baza[11]=new Piosenka("Bohemian rhapsody","rock","1975");
		baza[12]=new Piosenka("Mniej niż zero","pop-rock","1981");
		baza[13]=new Piosenka("Kryzysowa nazeczona","soft rock","1983");
		baza[14]=new Piosenka("Bad romance","pop","2009");
		baza[15]=new Piosenka("Shallow","pop","2018");
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
	
	
	public static void przydzielInstrumenty() {
		
		for(int i=0; i<Generator.getMuzycy().length; i++) {
			
			if((Generator.getMuzycy()[i]) instanceof Wokalista) {
				
				Mikrofon mikrofon = Generator.generateMikrofon();
				
				((Wokalista)(Generator.getMuzycy()[i])).setMikrofon(mikrofon);
			}
			
			if((Generator.getMuzycy()[i]) instanceof Saksofonista) {
				Saksofon saksofon = Generator.generateSaksofon();
				((Saksofonista)(Generator.getMuzycy()[i])).setSaksofon(saksofon);
			}
			
			if((Generator.getMuzycy()[i]) instanceof Pianista) {
				Keyboard keyboard = Generator.generateKeyboard();
				((Pianista)(Generator.getMuzycy()[i])).setKeyboard(keyboard);
			}
		}
		
	}
	
	public static Piosenka[] wylosujRepertuar(Piosenka[] P){
		Random generator= new Random();
		Piosenka[] repertuar= new Piosenka[generator.nextInt(15)+1];
		for(int i=0;i<repertuar.length;i++){
			repertuar[i]=P[i];
		}
		return repertuar;
	}
	
	public static void poprawCeneMuzykow(Muzyk[] muzycy) {
		
		//hotfix
		for(int i = 0; i < muzycy.length; i++) {
			
			muzycy[i].setStawka(300*muzycy[i].getPoziomUmiejetnosci());
	
		}
		
	}
	
	public static void wydrukujMuzykow(Muzyk[] muzycy) {
		for(int i = 0; i< muzycy.length; i++) {
			
			System.out.println(muzycy[i]);
		}
	}
	
	
	
	
	
	
	public static Rider getPodstawowy() {
		return podstawowy;
	}

	public static Rider getBogatszy() {
		return bogatszy;
	}

	public static Rider getNajbogatszy() {
		return najbogatszy;
	}

	public static Technik[] getTechnicy() {
		return technicy;
	}
	
	public static Muzyk[] getMuzycy() {
		return muzycy;
	}

	public static void setMuzycy(Muzyk[] muzycy) {
		Dane.muzycy = muzycy;
	}

	public static Instrument[] getInstrument() {
		return instrument;
	}

	public static void setInstrument(Instrument[] instrument) {
		Dane.instrument = instrument;
	}

	public static Mikrofon[] getMikrofony() {
		return mikrofony;
	}

	public static void setMikrofony(Mikrofon[] mikrofony) {
		Dane.mikrofony = mikrofony;
	}

	public static Piosenka[] getBaza() {
		return baza;
	}

	public static void setBaza(Piosenka[] baza) {
		Dane.baza = baza;
	}

}
