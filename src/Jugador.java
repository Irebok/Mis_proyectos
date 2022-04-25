import java.util.ArrayList;
import java.util.Collections;

public class Jugador {
	private int id;//entre 0 y 999
	private String nombre;//cadena de caracteres de longitude variable
	private boolean mano,juego;
	private ArrayList<Carta> cartas= new ArrayList<Carta>();  
	private int listavalores[]= {0,0,0,0,0,0,0,0};
	Carta carta1,carta2,carta3,carta4;
	
	public Jugador(int id, String nombre,boolean mano,Carta c1,Carta c2,Carta c3,Carta c4){
		this.id=id;
		this.nombre=nombre;
		carta1=c1;
		carta2=c2;
		carta3=c3;
		carta4=c4;
		this.cartas.add (carta1); 
		this.cartas.add (carta2); 
		this.cartas.add (carta3); 
		this.cartas.add (carta4); 
		Collections.sort(cartas,new ordenacartas());
		this.mano=mano;
		
		if(carta1.getPuntos() +carta2.getPuntos() + carta3.getPuntos() + carta4.getPuntos()>=31) juego=true;
		else juego=false;
		
		
		//contador de valores
		 for(int i=0;i<cartas.size();i++){
		     if(  cartas.get(i).getDenominacion() =='R'||  cartas.get(i).getDenominacion() =='3') {
		    	 listavalores[0]=listavalores[0]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='C') {
		    	 listavalores[1]=listavalores[1]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='S') {
		    	 listavalores[2]=listavalores[2]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='7') {
		    	 listavalores[3]=listavalores[3]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='6') {
		    	 listavalores[4]=listavalores[4]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='5') {
		    	 listavalores[5]=listavalores[5]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='4') {
		    	 listavalores[6]=listavalores[6]+1;
		     }
		     if(  cartas.get(i).getDenominacion() =='1'||  cartas.get(i).getDenominacion() =='2') {
		    	 listavalores[7]=listavalores[7]+1;
		     }
		 }
		
		
		 
		 
		 
		 
		
		//calculasumaPuntos();
	}
	
	
	public int calculaPares() {
			
		if(cartas.get(0).getPares()==cartas.get(1).getPares()&&cartas.get(0).getPares()==cartas.get(2).getPares()&&cartas.get(0).getPares()==cartas.get(3).getPares()) return 3;
		else {
			if(cartas.get(0).getPares()==cartas.get(1).getPares()&&cartas.get(0).getPares()==cartas.get(2).getPares())   return 2;
			if(cartas.get(0).getPares()==cartas.get(1).getPares()&&cartas.get(0).getPares()==cartas.get(3).getPares())   return 2;
			if(cartas.get(1).getPares()==cartas.get(2).getPares()&&cartas.get(1).getPares()==cartas.get(3).getPares())   return 2;
			if(cartas.get(0).getPares()==cartas.get(2).getPares()&&cartas.get(0).getPares()==cartas.get(3).getPares())   return 2;
			else {	
				if(cartas.get(0).getPares()==cartas.get(1).getPares()&&cartas.get(2).getPares()==cartas.get(3).getPares())   return 3;
				if(cartas.get(0).getPares()==cartas.get(1).getPares()&&cartas.get(2).getPares()!=cartas.get(3).getPares())   return 1;
				if(cartas.get(0).getPares()!=cartas.get(1).getPares()&&cartas.get(2).getPares()==cartas.get(3).getPares())   return 1;
				if(cartas.get(0).getPares()==cartas.get(2).getPares()&&cartas.get(1).getPares()==cartas.get(3).getPares())   return 3;
				if(cartas.get(0).getPares()==cartas.get(2).getPares()&&cartas.get(1).getPares()!=cartas.get(3).getPares())   return 1;
				if(cartas.get(0).getPares()!=cartas.get(2).getPares()&&cartas.get(1).getPares()==cartas.get(3).getPares())   return 1;
				if(cartas.get(0).getPares()==cartas.get(3).getPares()&&cartas.get(1).getPares()==cartas.get(2).getPares())   return 3;
				if(cartas.get(0).getPares()==cartas.get(3).getPares()&&cartas.get(1).getPares()!=cartas.get(2).getPares())   return 1;
				if(cartas.get(0).getPares()!=cartas.get(3).getPares()&&cartas.get(1).getPares()==cartas.get(2).getPares())   return 1;	
			}
		}			
		return 0;
	}
	
	
	
	
	
	
	
	public int getid(){
		return id;
	}
	public boolean getmano(){
		return mano;
	}
	public String getnombre(){
		return nombre;
	}
	public int calculasumaPuntos(){
		int calculo=carta1.getPuntos() +carta2.getPuntos() + carta3.getPuntos() + carta4.getPuntos();
		
	 return  calculo;
	 
	}
	
	public int getlistavalores(int i) {
		return listavalores[i];
	
		
	}

	public int[] getlistavalores() {
		return this.listavalores;
	
	}
	public ArrayList<Carta> getcartas() {
		return this.cartas;
	
	}
	
	public boolean getjuego() {
		return juego;
	}
	
}
