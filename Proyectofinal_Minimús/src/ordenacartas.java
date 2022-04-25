import java.util.Comparator;

public class ordenacartas implements Comparator<Carta> {
	public int compare(Carta carta1,Carta carta2){
		
			
	
			if(carta1.getPuntos()==10 && carta2.getPuntos()==10 ) {
			if (carta1.getDenominacion()=='C' && carta2.getDenominacion()=='S') return 1;
			if (carta1.getDenominacion()=='S'&& carta2.getDenominacion()=='C') return -1;
			if ((carta1.getDenominacion()=='R'||carta1.getDenominacion()=='3')&& carta2.getDenominacion()=='S') return 1;
			if (carta1.getDenominacion()=='S'&& (carta2.getDenominacion()=='R'||carta2.getDenominacion()=='3')) return -1;
			if (carta1.getDenominacion()=='C'&& (carta2.getDenominacion()=='R'||carta2.getDenominacion()=='3')) return -1;
			if ((carta1.getDenominacion()=='R'||carta1.getDenominacion()=='3')&& carta2.getDenominacion()=='C') return 1;
			if (carta1.getDenominacion()=='R'&&carta2.getDenominacion()=='3') return -1;
			
			}else {
			if((carta1.getDenominacion()=='1'||carta1.getDenominacion()=='2'||carta1.getDenominacion()=='4'||carta1.getDenominacion()=='5'||carta1.getDenominacion()=='6'||carta1.getDenominacion()=='7')&&(carta2.getDenominacion()=='3'))return-1;
			if((carta2.getDenominacion()=='1'||carta2.getDenominacion()=='2'||carta2.getDenominacion()=='4'||carta2.getDenominacion()=='5'||carta2.getDenominacion()=='6'||carta2.getDenominacion()=='7')&&(carta1.getDenominacion()=='3'))return 1;
			if(carta1.getDenominacion()>carta2.getDenominacion())  return  1;
			if(carta1.getDenominacion()<carta2.getDenominacion()) return -1;
			}
			if(carta1.getDenominacion()==carta2.getDenominacion()) {
			if (carta1.getPalo()<carta2.getPalo()) return -1;
			else return 1;}return 0;
	  		}

}
