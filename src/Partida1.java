import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida1 {
	public Partida1() throws IOException {
		Metodo1();
	}

	public void Metodo1() throws IOException{
		int piedras1=0;
		int piedras2=0;
		boolean mano[]= {false,false,false,false};
		
		
		int i=0;
		int j=0;
		
		
		
		String nombres[]= {"Jugador 1A","Jugador 1B","Jugador 2A","Jugador 2B"};
		int ids[] = {1000,1000,1000,1000};
		int idsPareja[]={1000,1000};
		int idsJugador1Pareja[]={1000,1000};	
		int idsJugador2Pareja[]={1000,1000};		
		String nombreParejas[]= {"Pareja A","Pareja B"};
		System.out.println(ids.length);
		boolean truePareja[] = {false,false};
		Scanner entrada= null;	
	
	    entrada=new Scanner  (new FileInputStream("jugadas.txt")); 
	    int contador =0;  
	    	  

		while (entrada.hasNextLine()){  
		
		    String linea = entrada.nextLine();
		    
		
		    if(linea.startsWith("J")) {
		
				String[] partej = linea.split(" ",3);
			
				int idjugador  = new Integer(partej[1]);				
				String nombrej = partej[2]; 
				
			
				if(idjugador!=ids[0]&&idjugador!=ids[1]&&idjugador!=ids[2]&&idjugador!=ids[3]&&i<4) {

			        ids[i]=idjugador;
			        nombres[i]=nombrej;
			        System.out.println(ids[i]);
					System.out.println(nombres[i]);					
			        i++;
				}
		    }	
		    
	    
			if(linea.startsWith("P")) {
		
				String[] partep = linea.split(" ",5);
				
				int idPareja = new Integer(partep[1]); 		
				int idJugador1 = new Integer(partep[2]); 	
				int idJugador2 = new Integer(partep[3]); 	
				String nombrePareja =partep[4]; 	
							
				
				boolean parejaNoRepetida=false;
				boolean jugadoresNoRepetidos=false;
				boolean jugadoresExistentes=false;
				
		        if(idsPareja[0]!=idPareja&&idsPareja[1]!=idPareja) {
		            parejaNoRepetida=true;
		        }
		        if(idsJugador1Pareja[0]!=idJugador1&&idsJugador1Pareja[1]!=idJugador1&&idsJugador2Pareja[0]!=idJugador1&&idsJugador2Pareja[1]!=idJugador1&&idsJugador1Pareja[0]!=idJugador2&&idsJugador1Pareja[1]!=idJugador2&&idsJugador2Pareja[0]!=idJugador2&&idsJugador2Pareja[1]!=idJugador2) {
		            jugadoresNoRepetidos=true;
		        }
		        if((idJugador1==ids[0]||idJugador1==ids[1]||idJugador1==ids[2]||idJugador1==ids[3])&& (idJugador2==ids[0]||idJugador2==ids[1]||idJugador2==ids[2]||idJugador2==ids[3])) {
		            jugadoresExistentes=true;
		        }

		            if(parejaNoRepetida==true&&jugadoresNoRepetidos==true&&jugadoresExistentes==true&&j<2) {
		            nombreParejas[j]=nombrePareja;
		            idsPareja[j]=idPareja;
		            System.out.println(idsPareja[j]);
		            if(j==0) {
		            	 idsJugador1Pareja[0]=idJugador1;	          
				         idsJugador2Pareja[0]=idJugador2;
				         System.out.println(idsJugador1Pareja[0]);	
						 System.out.println(idsJugador2Pareja[0]);	
		            }
		            if(j==1 ) {
		            	idsJugador1Pareja[1]=idJugador1;	          
		            	idsJugador2Pareja[1]=idJugador2;
		            	System.out.println(idsJugador1Pareja[1]);	
						System.out.println(idsJugador2Pareja[1]);	
		            }	
		            System.out.println(nombreParejas[j]);	
		            truePareja[j]=true;
		            j++;		          
		        }
			}
		}
		PrintWriter guardadofinal = new PrintWriter(new FileOutputStream("resPartida.txt"));	
		while(piedras1<40 || piedras2<40) {
			
			if (contador==0) {
				 mano[0]=true;
				 mano[1]=false;
				 mano[2]=false;
				 mano[3]=false;
			}
			
			Baraja baraja1 = new Baraja();	 
			baraja1.Barajar();
			ArrayList<Carta> cartasJugada = new ArrayList<Carta>();
			cartasJugada=baraja1.ObtenerNcartas(16);
			
			Jugador jugador1=new Jugador(ids[0],nombres[0],mano[0],cartasJugada.get(0),cartasJugada.get(1),cartasJugada.get(2),cartasJugada.get(3));
			Jugador jugador2=new Jugador(ids[0],nombres[1],mano[1],cartasJugada.get(4),cartasJugada.get(5),cartasJugada.get(6),cartasJugada.get(7));
			Jugador jugador3=new Jugador(ids[0],nombres[2],mano[2],cartasJugada.get(8),cartasJugada.get(9),cartasJugada.get(10),cartasJugada.get(11));
			Jugador jugador4=new Jugador(ids[0],nombres[3],mano[3],cartasJugada.get(12),cartasJugada.get(13),cartasJugada.get(14),cartasJugada.get(15));
			
			Pareja pareja1=new Pareja(idsPareja[0],nombreParejas[0],jugador1,jugador3);
			Pareja pareja2=new Pareja(idsPareja[1],nombreParejas[1],jugador2,jugador4);
		 
			Jugada jugada1=new Jugada(pareja1,pareja2,piedras1,piedras2);
			
			piedras1=jugada1.getpiedras1jugada();
			piedras2=jugada1.getpiedras2jugada();
			
			if(contador==0) {						
			jugada1.guardaJugadaInicio(pareja1,pareja2);
			}

			jugada1.guardaJugada(pareja1,pareja2);
						
			contador+=1;
	
			if(mano[0]==true) {
				mano[0]=false;
				mano[1]=true;
			}else if(mano[1]==true) {
				mano[1]=false;
				mano[2]=true;
			}else if(mano[2]==true) {
				mano[2]=false;
				mano[3]=true;
			}else if(mano[3]==true) {
				mano[3]=false;
				mano[0]=true;
			}	
			if(piedras1>=40 || piedras2>=40){ 
				
				jugada1.guardaJugadaFinal(pareja1,pareja2,contador);
				break;
				}
			
		}
		guardadofinal.close();	
					  
	}
	
}

