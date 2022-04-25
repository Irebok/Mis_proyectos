import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Partida2 {

		public Partida2() throws IOException {
			Metodo2();
		}

	public void Metodo2() throws IOException{
	
		//int piedrastotales[]={0,0};
		int piedras1=0;
		int piedras2=0;
		boolean mano[]= {false,false,false,false};
		Scanner entrada= null;	
		
		
		PrintWriter guardadofinal = new PrintWriter(new FileOutputStream("resPartida.txt"));	
				entrada=new Scanner  (new FileInputStream("jugadas.txt"));   
			        
				int contador =0;  
		    
				String linea =null;		  
		
				while (entrada.hasNextLine()){    
									
					linea= entrada.nextLine();                    				
	
					 String cartas=linea;
									
						Carta carta1=new Carta(cartas.substring(2,4));
						Carta carta2=new Carta(cartas.substring(6,8));
						Carta carta3=new Carta(cartas.substring(10,12));
						Carta carta4=new Carta(cartas.substring(14,16));
						
						Carta carta5=new Carta(cartas.substring(19,21));
						Carta carta6=new Carta(cartas.substring(23,25));
						Carta carta7=new Carta(cartas.substring(27,29));
						Carta carta8=new Carta(cartas.substring(31,33));
						
						Carta carta9=new Carta(cartas.substring(36,38));
						Carta carta10=new Carta(cartas.substring(40,42));
						Carta carta11=new Carta(cartas.substring(44,46));
						Carta carta12=new Carta(cartas.substring(48,50));
						
						Carta carta13=new Carta(cartas.substring(53,55));
						Carta carta14=new Carta(cartas.substring(57,59));
						Carta carta15=new Carta(cartas.substring(61,63));
						Carta carta16=new Carta(cartas.substring(65,67));
						
						if (contador==0) {
							if(cartas.charAt(0)=='*') mano[0]=true;
							if(cartas.charAt(17)=='*') mano[1]=true;
							if(cartas.charAt(34)=='*') mano[2]=true;
							if(cartas.charAt(51)=='*') mano[3]=true;
						}
						
						Jugador jugador1=new Jugador(100,"Jugador 1A",mano[0],carta1,carta2,carta3,carta4);
						Jugador jugador2=new Jugador(101,"Jugador 1B",mano[1],carta5,carta6,carta7,carta8);
						Jugador jugador3=new Jugador(102,"Jugador 2A",mano[2],carta9,carta10,carta11,carta12);
						Jugador jugador4=new Jugador(103,"Jugador 2B",mano[3],carta13,carta14,carta15,carta16);
						
						Pareja pareja1=new Pareja(11,"Pareja A",jugador1,jugador3);
						Pareja pareja2=new Pareja(22,"Pareja B",jugador2,jugador4);
						
						
						
						    //guardado.println(cartas);
						Jugada jugada1=new Jugada(pareja1,pareja2,piedras1,piedras2);
						
						piedras1=jugada1.getpiedras1jugada();
						piedras2=jugada1.getpiedras2jugada();
						
						if(contador==0) {						
						jugada1.guardaJugadaInicio(pareja1,pareja2);
						}

						jugada1.guardaJugada(pareja1,pareja2);
							
						//guardadofinal.println(contador);
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
				
				if(piedras1<40 && piedras2<40) {					
					guardaFinal(contador);
				}			
				
				guardadofinal.close();
				
				entrada.close();    
			   

	
	}
	
	public static void guardaFinal( int contador) throws IOException{
		
		PrintWriter guardaFinal = new PrintWriter(new FileOutputStream("resPartida.txt",true));
		
		
		    //guardado.println(cartas);
		 
		guardaFinal.println("Partida incompleta. Número total de jugadas: "+contador);
		    
		    guardaFinal.close();
		
		}
	

}