package repertuar;

import muzycy.Osoba;
import muzycy.Muzyk;

public class Krytyk extends Osoba{

	//abce
	//TODO ficzer krytyka
	public Krytyk(String imie, String nazwisko) {
		super(imie, nazwisko);

		
	}

	public static void ocenaUmiejetnosci(Muzyk[] tab) //ocena umiejetnosci danego muzyka na podstawie tego jak wypada na tle calej reszty
	{
		double sredniaLiczba=0,procent;
		int i,dodatkowePkt;
		
		for(i=0;i<tab.length;i++) //liczenie sredniej ilosci znanych piosenek wsrod muzykow
		{
			if(tab[i].getRepertuar()!=null)
			{
				tab[i].setPoziomUmiejetnosci(3);
				sredniaLiczba+=tab[i].getRepertuar().length;
			}
			else if (tab[i].getRepertuar()==null || tab[i].getRepertuar().length==0)
			{
				tab[i].setPoziomUmiejetnosci(1);
			}
		}
		
		sredniaLiczba/= (double)tab.length;
		
		if(sredniaLiczba!=0)
		{
			for(i=0;i<tab.length;i++) //przydzielanie kazdemu muzykowi dodatkowych punktow na podstawie tego czy zna wiecej/mniej piosenek od sredniej
			{
				if(tab[i].getRepertuar()!=null || tab[i].getRepertuar().length!=0)
				{
					procent =((tab[i].getRepertuar().length-sredniaLiczba)/sredniaLiczba)*100;
					
					if(Math.abs(procent)==0)
					{
						dodatkowePkt=0;
					}
					else if(Math.abs(procent)<=50)
					{
						dodatkowePkt = procent>0 ? 1 : -1;
					}
					else
					{
						dodatkowePkt = procent>0 ? 2 : -2;
					}
					
					tab[i].setPoziomUmiejetnosci(tab[i].getPoziomUmiejetnosci()+dodatkowePkt);
				}
				
			}
		}
	}
	
	
	
}
