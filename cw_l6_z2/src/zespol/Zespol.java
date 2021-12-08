package zespol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import muzycy.Muzyk;
import muzycy.Pianista;
import muzycy.Saksofonista;
import muzycy.Wokalista;
import technika.Technik;
import generator.Generator;

public class Zespol {
	
	private Technik technik;
    private Wokalista wokalista;
    private Pianista pianista;
    private Saksofonista saksofonista;

    public Zespol( Technik technik , Wokalista wokalista , Pianista pianista , Saksofonista saksofonista )
    {
        this.technik = technik;
        this.wokalista =  wokalista;
        this.pianista = pianista;
        this.saksofonista = saksofonista;
    }

    public Technik getTechnik() {
        return technik;
    }

    public Wokalista getWokalista() {
        return wokalista;
    }

    public Pianista getPianista() {
        return pianista;
    }

    public Saksofonista getSaksofonista() {
        return saksofonista;
    }
	
	
	public static void optimalTeam(Technik [] technicytmp , Muzyk [] muzycy, int budzet) {
		
		List <Technik> technicy = Arrays.asList(technicytmp);
        List <Wokalista> wokalisci = arrayWokalisci(muzycy);
        List <Pianista> pianisci = arrayPianisci(muzycy);
        List <Saksofonista> saksofonisci  = arraySaksofonisci(muzycy);
        Zespol zespol = wybierzZespol( technicy , wokalisci , pianisci , saksofonisci , budzet );
        
        showOptimalTeam(zespol,budzet);
		
//		if ( zespol == null )
//            System.out.println( "Z danej grupy nie mozna utworzyc zespolu w twoim budzecie!" );
//
//        else System.out.println( "Technik:\n" + zespol.getTechnik().getImie()+ " "+ zespol.getTechnik().getNazwisko()+ "\n\nWokalista:\n" + zespol.getWokalista().toString() + "" + "\n\nPianista:\n" + zespol.getPianista().toString() + "\n\nSaksofonista:\n" + zespol.getSaksofonista().toString());
	}
	
	public static Zespol wybierzZespol( List <Technik> technicy , List <Wokalista> wokalisci , List <Pianista> pianisci , List <Saksofonista> saksofonisci , int budzet )
    {
        int iT=0, iW=0, iP=0, iS=0, suma=0;
       
        for (int i=0; i<technicy.size(); i++)
            for (int j=0; j<wokalisci.size(); j++)
                for (int k=0; k<pianisci.size(); k++)
                    for (int l=0; l<saksofonisci.size(); l++)
                    {
                        boolean czyWBudzecie = ( technicy.get(i).getStawka() + wokalisci.get(j).getStawka() + pianisci.get(k).getStawka() + saksofonisci.get(l).getStawka() <= budzet );
                        int tempSuma = technicy.get(i).getPoziom_umiejetnosci() + wokalisci.get(j).getPoziomUmiejetnosci() + pianisci.get(k).getPoziomUmiejetnosci() + saksofonisci.get(l).getPoziomUmiejetnosci();
                        boolean czyWiekszeUmiejetnosci = ( tempSuma > suma );

                        if ( czyWBudzecie && czyWiekszeUmiejetnosci )
                        {
                            suma = tempSuma;
                            iT = i;
                            iW = j;
                            iP = k;
                            iS = l;
                        }
                    }


        if ( suma == 0 )
            return null;

        else return new Zespol ( technicy.get(iT) , wokalisci.get(iW) , pianisci.get(iP) , saksofonisci.get(iS) );
        
    }

	
	public static List<Pianista> arrayPianisci(Muzyk [] tab) {
    	
		List<Pianista> pianisci = new ArrayList<Pianista>();
    	
		for(int i=0; i<tab.length;i++) {
    		if(tab[i] instanceof Pianista) {
    			pianisci.add((Pianista)tab[i]);
    		}
    	}    
    	((ArrayList<Pianista>) pianisci).trimToSize();
    	return pianisci;
    }
	
	
	public static List<Saksofonista> arraySaksofonisci(Muzyk [] tab) {
    	
		List<Saksofonista> saksofonisci = new ArrayList<Saksofonista>();
    	
		for(int i=0; i<tab.length;i++) {
    		if(tab[i] instanceof Saksofonista) {
    			saksofonisci.add((Saksofonista)tab[i]);
    		}
    	}    	
		((ArrayList<Saksofonista>) saksofonisci).trimToSize();
    	return saksofonisci;
    }
	
	
	public static List<Wokalista> arrayWokalisci(Muzyk [] tab) {
    	
		List<Wokalista> wokalisci = new ArrayList<Wokalista>();
    	
		for(int i=0; i<tab.length;i++) {
    		if(tab[i] instanceof Wokalista) {
    			wokalisci.add((Wokalista)tab[i]);
    		}
    	}    
    	((ArrayList<Wokalista>) wokalisci).trimToSize();
    	return wokalisci;
    }
	
	public static void showOptimalTeam(Zespol zespol, int budzet) {
		
		if ( zespol == null )
            System.out.println( "Z danej grupy nie mozna utworzyc zespolu w twoim budzecie!" );

        else {
        	//int poziomUmiejetnosci= zespol.getTechnik().getPoziom_umiejetnosci()+zespol.getPianista().getPoziomUmiejetnosci()+zespol.getSaksofonista().getPoziomUmiejetnosci()+zespol.getWokalista().getPoziomUmiejetnosci();
        	
        	System.out.println("\n-------------------------");
        	System.out.println("Budzet na nowy zespol: "+budzet+
        			"\nKoszt zespolu wraz z technikiem o mozliwie najwyzszym poziomie umiejetnosci: "+ 
        			(zespol.getTechnik().getStawka()+
            		zespol.getPianista().getStawka()+
            		zespol.getSaksofonista().getStawka()+
            		zespol.getWokalista().getStawka())+
        			
        		"\nPoziom umiejetnosci zespolu wraz z technikiem (w skali 0-20): "+ (zespol.getTechnik().getPoziom_umiejetnosci()+
        		zespol.getPianista().getPoziomUmiejetnosci()+
        		zespol.getSaksofonista().getPoziomUmiejetnosci()+
        		zespol.getWokalista().getPoziomUmiejetnosci()));
        	
System.out.println( "\nTechnik:\n" + zespol.getTechnik().getImie()+ " "+ zespol.getTechnik().getNazwisko()+ 
        			"\n\nWokalista:\n" + zespol.getWokalista().getImie() + " " +zespol.getWokalista().getNazwisko()+ 
        			"\n\nPianista:\n" + zespol.getPianista().getImie()+" "+zespol.getPianista().getNazwisko() + 
        			"\n\nSaksofonista:\n" + zespol.getSaksofonista().getImie()+" "+zespol.getSaksofonista().getNazwisko());
   	
        }
	
		
	}


}
