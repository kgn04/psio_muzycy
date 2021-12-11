package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import generator.Generator;
import instrument.Instrument;
import muzycy.Muzyk;
import repertuar.Piosenka;
import sprzet.Mikrofon;

public class TextIO {
	
	public static void zresetujDane() {
		//metoda przywracajaca dane do poziomu z tablic w dane.java
		
		Generator.setMuzycy(Dane.getMuzycy());
		Generator.setMikrofony(Dane.getMikrofony());
		Generator.setBaza(Dane.getBaza());
		Generator.setInstrument(Dane.getInstrument());
		Dane.przydzielInstrumenty();
		zapiszDane();
		System.out.println("Zresetowano baze danych");
		
	}
	
	
	
	public static void pobierzDane() throws ClassNotFoundException, IOException {
		
		//metoda pobierajaca dane z odpowiednich txt
		Generator.setMuzycy((Muzyk[]) odczytajZPliku("dbMuzycy.txt"));
		Generator.setMikrofony((Mikrofon[]) odczytajZPliku("dbMikrofony.txt"));
		Generator.setBaza((Piosenka[]) odczytajZPliku("dbPiosenka.txt"));
		Generator.setInstrument((Instrument[]) odczytajZPliku("dbInstrument.txt"));
		
	}
	
	
	public static void zapiszDane() {
		
		//metoda zapisujaca aktualny stan wszystkich obiektów
		System.out.println("---------------------");
		System.out.println("Zapisywanie bazy danych...");
		zapiszDoPliku(Generator.getMuzycy(), "dbMuzycy.txt");
		zapiszDoPliku(Generator.getInstrument(), "dbInstrument.txt");
		zapiszDoPliku(Generator.getMikrofony(), "dbMikrofony.txt");
		zapiszDoPliku(Generator.getBaza(), "dbPiosenka.txt");
		
	}
	
	
    public static void zapiszDoPliku(Object[] serObj, String filename) {
    	 
    	File file = new File(filename);
    	
        try {
 
            FileOutputStream fileOut = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            fileOut.close();
            objectOut.close();
            System.out.println("Pomyślnie zapisano " + filename);
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static Object[] odczytajZPliku(String filename) throws ClassNotFoundException, IOException {
    	
    	File file = new File(filename);
    	Object[] muzycy;
    	
    	FileInputStream fileIn = new FileInputStream(file.getAbsolutePath());
    	ObjectInputStream objectIn = new ObjectInputStream(fileIn);
    	muzycy = (Object[]) objectIn.readObject();
    	fileIn.close();
    	objectIn.close();
    	return muzycy;
    }


	
//    public Muzyk[] ReadObjectFromFile(String filepath) {
//    	 
//    	filepath = db.getAbsolutePath();
//        try {
// 
//            FileInputStream fileIn = new FileInputStream(filepath);
//            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
// 
//            Muzyk[] obj = (Muzyk[]) objectIn.readObject();
// 
//            System.out.println("The Object has been read from the file");
//            objectIn.close();
//            System.out.println((obj[10].getImie() + obj[10].getNazwisko() + obj[10].getPoziomUmiejetnosci() + obj[10].getStawka() + obj[10].getRepertuar()));
//            return obj;
// 
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
	
	

}
