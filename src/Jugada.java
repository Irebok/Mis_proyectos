import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Jugada {
	int piedrasgrande[];
	int piedraschica[];
	int piedraspares[];
	int piedrasjuego[];
	Pareja pareja1,pareja2;
	private int valorespuntos[]= {31,32,40,37,36,35,34,33};
	int piedrasjugada[];
	int piedra1,piedra2;
	int suma1;
	int suma2;
	
	
	public Jugada(Pareja p1,Pareja p2, int piedras1, int piedras2) {
		pareja1=p1;
		pareja2=p2;
		
		piedrasgrande=resuelvegrande();
		piedraschica=resuelvechica();
		piedraspares=resuelvepares();
		piedrasjuego=resuelvejuego();
		//piedrasjugada[0]=piedrasgrande[0]+piedraschica[0]+piedraspares[0]+piedrasjuego[0]+piedras1;
        //piedrasjugada[1]=piedrasgrande[1]+piedraschica[1]+piedraspares[1]+piedrasjuego[1]+piedras2;
		
		suma1=piedrasgrande[0]+piedraschica[0]+piedraspares[0]+piedrasjuego[0]+piedras1;
        suma2=piedrasgrande[1]+piedraschica[1]+piedraspares[1]+piedrasjuego[1]+piedras2;
      
        piedra1=piedras1;
      piedra2=piedras2;

	}
	
	public int[]  resuelvegrande(){
		int piedras[]= {0,0};
		for (int i=0;i<8;i++) {
		if (pareja1.getlistagrande(i)>pareja2.getlistagrande(i)) {
			piedras[0]=3;
			return piedras;
		}else if(pareja1.getlistagrande(i)<pareja2.getlistagrande(i)) {
			piedras[1]=3;
			return piedras;
		}
		}		
		piedras[1]=1;
		piedras[0]=1;
		return piedras;
		}
	
	public int[] resuelvechica(){
		int piedras[]= {0,0};
		for (int i=7;i>=0;i--) {
		if (pareja1.getlistachica(i)>pareja2.getlistachica(i)) {
			piedras[0]=3;
			return piedras;
		}else if(pareja1.getlistachica(i)<pareja2.getlistachica(i)) {
			piedras[1]=3;
			return piedras;
		}
		}		
		piedras[1]=1;
		piedras[0]=1;
		return piedras;
	}
	public int[] resuelvepares() {
		int piedras[]= {0,0};
		piedras[0]=pareja1.jugador1.calculaPares()+pareja1.jugador2.calculaPares();
		piedras[1]=pareja2.jugador1.calculaPares()+pareja2.jugador2.calculaPares();
		return piedras;
	}
	
	
	
	
	
	
	public int[] resuelvejuego() {
		int piedras[]= {0,0};
		
		

		
		if (pareja1.getOrden().get(0).calculasumaPuntos()==valorespuntos[0]) {
			piedras[0]+=3;
			
		}
		else if(pareja1.getOrden().get(0).getjuego()==true) {
			piedras[0]+=2;
		
		}
		
		if (pareja2.getOrden().get(0).calculasumaPuntos()==valorespuntos[0]) {
			piedras[1]+=3;
			
		}
		else if(pareja2.getOrden().get(0).getjuego()==true) {
			piedras[1]+=2;
			
		}
		
		if (pareja1.getOrden().get(1).calculasumaPuntos()==valorespuntos[0]) {
			piedras[0]+=3;
		
		}
		else if(pareja1.getOrden().get(1).getjuego()==true) {
			piedras[0]+=2;
		
		}
		
		if (pareja2.getOrden().get(1).calculasumaPuntos()==valorespuntos[0]) {
			piedras[1]+=3;
		
		}
		else if(pareja2.getOrden().get(1).getjuego()==true) {
			piedras[1]+=2;
			
		}
		
	
	  
		 if(pareja1.getOrden().get(0).getjuego()==true&&pareja2.getOrden().get(0).getjuego()==false) { 
			piedras[0]+=2; 
		 }
		 
		 if(pareja1.getOrden().get(0).getjuego()==false&&pareja2.getOrden().get(0).getjuego()==true) {
		 piedras[1]+=2; 
			
		
		}
	  
	 
	 
	 
	
		
		if(pareja1.getOrden().get(0).getjuego()==true&&pareja2.getOrden().get(0).getjuego()==true) {
			 for( int i =0;i<8;i++) {
				
				 if(pareja1.getOrden().get(0).calculasumaPuntos()==valorespuntos[i]&&pareja2.getOrden().get(0).calculasumaPuntos()!=valorespuntos[i]) {
					
					piedras[0]+=2; 
					 
					break;
					 
				 }else if(pareja2.getOrden().get(0).calculasumaPuntos()==valorespuntos[i]&&pareja1.getOrden().get(0).calculasumaPuntos()!=valorespuntos[i]) {
				
				    piedras[1]+=2; 
				     	 
				    break;
				    
			 }else if(pareja2.getOrden().get(0).calculasumaPuntos()==pareja1.getOrden().get(0).calculasumaPuntos()){
				 
				 				
				 
				 			if(pareja1.getOrden().get(1).getjuego()==true&&pareja2.getOrden().get(1).getjuego()==false) { 
				 					piedras[0]+=2; 
				 					}
					 
				 			if(pareja1.getOrden().get(1).getjuego()==false&&pareja2.getOrden().get(1).getjuego()==true) {
				 					piedras[1]+=2; 
						
				 					}
				 						
				 			if(pareja1.getOrden().get(1).getjuego()==false&&pareja2.getOrden().get(1).getjuego()==false) {
				 				if(pareja1.getManoPareja()==true) 	piedras[0]+=2; 
				 				if(pareja2.getManoPareja()==true) 	piedras[1]+=2; 
				 					
				 					 
				 				 }
				 
				 
				 			if(pareja1.getOrden().get(1).getjuego()==true&&pareja2.getOrden().get(1).getjuego()==true) {
				 					for( int j =0;j<8;j++) {
						 
				 						if(pareja1.getOrden().get(1).calculasumaPuntos()==valorespuntos[j]&&pareja2.getOrden().get(1).calculasumaPuntos()!=valorespuntos[j]) {
							
				 								piedras[0]+=2; 
				 								break;
							 
				 							}else if(pareja2.getOrden().get(1).calculasumaPuntos()==valorespuntos[j]&&pareja1.getOrden().get(1).calculasumaPuntos()!=valorespuntos[j]) {
							 
							 			 		piedras[1]+=2;
							 			 		break;
							 			 									
				 								}else if(pareja2.getOrden().get(1).calculasumaPuntos()==pareja1.getOrden().get(1).calculasumaPuntos()){
				 
				 										if(pareja1.getManoPareja()==true) 	piedras[0]+=2; 
				 										if(pareja2.getManoPareja()==true) 	piedras[1]+=2; 
				 								}
				 					}				 
				 		 }
			 		 }			
			 	}
		
			 }
			
		  if(pareja1.getOrden().get(0).getjuego()==false&&pareja2.getOrden().get(0).getjuego()==false) {
			  
			  if(pareja1.getOrden().get(0).calculasumaPuntos()>pareja2.getOrden().get(0).calculasumaPuntos())piedras[0]+=1;
			  if(pareja1.getOrden().get(0).calculasumaPuntos()<pareja2.getOrden().get(0).calculasumaPuntos())piedras[1]+=1;
			  if(pareja1.getOrden().get(0).calculasumaPuntos()==pareja2.getOrden().get(0).calculasumaPuntos()) {
	
				  
				  if(pareja1.getOrden().get(1).calculasumaPuntos()>pareja2.getOrden().get(1).calculasumaPuntos())piedras[0]+=1;
				  if(pareja1.getOrden().get(1).calculasumaPuntos()<pareja2.getOrden().get(1).calculasumaPuntos())piedras[1]+=1;
				  if(pareja1.getOrden().get(1).calculasumaPuntos()==pareja2.getOrden().get(1).calculasumaPuntos()) {
	
			  if(pareja1.getManoPareja()==true) 	piedras[0]+=1; 
				if(pareja2.getManoPareja()==true) 	piedras[1]+=1; 
				  }
			  }
			 }
		  
					
		return piedras;
	}
			
	
	
	public void guardaJugadaInicio(Pareja pareja1,Pareja pareja2) throws IOException{
	
		PrintWriter guardado =new PrintWriter(new FileOutputStream("resPartida.txt",true));	
		
		
	
	
		guardado.println(pareja1.getnombrepareja()+": "+ pareja1.jugador1.getnombre()+" y "+ pareja1.jugador2.getnombre()+".");
		guardado.println(pareja2.getnombrepareja()+": "+ pareja2.jugador1.getnombre()+" y "+ pareja2.jugador2.getnombre()+".");
		if(pareja1.jugador1.getmano()==true){
			guardado.println("Mano: "+pareja1.jugador1.getnombre());
		}
		if(pareja1.jugador2.getmano()==true){
			guardado.println("Mano: "+pareja1.jugador2.getnombre());
		}
		if(pareja2.jugador1.getmano()==true){
			guardado.println("Mano: "+pareja2.jugador1.getnombre());
		}
		if(pareja2.jugador2.getmano()==true){
			guardado.println("Mano: "+pareja2.jugador2.getnombre());
		
		}
		    
		guardado.close();
	
	}
	
	public void guardaJugada(Pareja pareja1,Pareja pareja2) throws IOException{
		PrintWriter guardaJugada = new PrintWriter(new FileOutputStream("resPartida.txt",true));
	
		
		    //guardado.println(cartas);
		    if(pareja1.jugador1.getmano()==true)guardaJugada.print("*");
		    if(pareja1.jugador1.getmano()==false)guardaJugada.print("-");
		    guardaJugada.print("(");
		    for(int i=0;i<4;i++) {
		    	guardaJugada.print(pareja1.jugador1.getcartas().get(i).getDenominacion()+""+pareja1.jugador1.getcartas().get(i).getPalo());
		    	if(i!=3)guardaJugada.print(", ");
		    	}
		    guardaJugada.print(")");
		    if(pareja2.jugador1.getmano()==true)guardaJugada.print("*");
		    if(pareja2.jugador1.getmano()==false)guardaJugada.print("-");
		    guardaJugada.print("(");
		    for(int i=0;i<4;i++) {
		    	
		    	guardaJugada.print(pareja2.jugador1.getcartas().get(i).getDenominacion()+""+pareja2.jugador1.getcartas().get(i).getPalo());
		    	if(i!=3)guardaJugada.print(", ");
		    	}
		    guardaJugada.print(")");
		    if(pareja1.jugador2.getmano()==true)guardaJugada.print("*");
		    if(pareja1.jugador2.getmano()==false)guardaJugada.print("-");
		    guardaJugada.print("(");
		    for(int i=0;i<4;i++) {
		    	guardaJugada.print(pareja1.jugador2.getcartas().get(i).getDenominacion()+""+pareja1.jugador2.getcartas().get(i).getPalo());
		    	if(i!=3)guardaJugada.print(", ");
		    	}
		    guardaJugada.print(")");
		    if(pareja2.jugador2.getmano()==true)guardaJugada.print("*");
		    if(pareja2.jugador2.getmano()==false)guardaJugada.print("-");
		    guardaJugada.print("(");
		    for(int i=0;i<4;i++) {
		    	guardaJugada.print(pareja2.jugador2.getcartas().get(i).getDenominacion()+""+pareja2.jugador2.getcartas().get(i).getPalo());
		    	if(i!=3)guardaJugada.print(", ");
		    	}
		    guardaJugada.print(")");
		    guardaJugada.println(" ");
		    
		    guardaJugada.println("Grande "+piedrasgrande[0]+" "+piedrasgrande[1]+" Chica "+piedraschica[0]+" "+piedraschica[1]+" Pares "+piedraspares[0]+" "+piedraspares[1]+" Juego "+piedrasjuego[0]+" "+piedrasjuego[1]+" - "+suma1+" "+suma2);
		    
		   
		    	
		    
		    guardaJugada.close();
		
		}
	
	
	public void guardaJugadaFinal(Pareja pareja1,Pareja pareja2,  int contador) throws IOException{
		
		
		PrintWriter guardaJugadafinal = new PrintWriter(new FileOutputStream("resPartida.txt",true));
		
		
		    //guardado.println(cartas);
		 
		if(suma1<suma2){
			guardaJugadafinal.println("Gana: "+ pareja2.getnombrepareja()+". Número de jugadas: "+contador);
		    }
		    if(suma1>suma2){
		    	guardaJugadafinal.println("Gana: "+pareja1.getnombrepareja()+". Número de jugadas: "+ contador);
		    }
		    if(suma1==suma2){
		    	
		    	guardaJugadafinal.println("Empate");
		  
		    }
		    
		    guardaJugadafinal.close();
		
		}
	
	public void guardaFinal(Pareja pareja1,Pareja pareja2,  int contador) throws IOException{
		
		PrintWriter guardaFinal = new PrintWriter(new FileOutputStream("resPartida.txt",true));
		
		
		    //guardado.println(cartas);
		 
		guardaFinal.println("Partida incompleta. Número total de jugadas: "+contador);
		    
		    guardaFinal.close();
		
		}
	
	
	 	
	
	public int getpiedras1jugada() {
		return suma1;
	}
	
	public int getpiedras2jugada() {
		return suma2;
	}
	
	
	
	
	
}
