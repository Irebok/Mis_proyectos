import java.util.ArrayList;
import java.util.Collections;

public class Baraja {

	ArrayList<Carta> baraja = new ArrayList<Carta>();    
	ArrayList<Carta> repartidas = new ArrayList<Carta>();   
	// Guardar sav =new Guardar();
	public  Baraja() {
			
	//	baraja.removeAll();
		baraja.add(new Carta("1B")); 
		baraja.add(new Carta("2B")); 
		baraja.add(new Carta("3B")); 
		baraja.add(new Carta("4B")); 
		baraja.add(new Carta("5B")); 
		baraja.add(new Carta("6B")); 
		baraja.add(new Carta("7B")); 
		baraja.add(new Carta("SB")); 
		baraja.add(new Carta("CB")); 
		baraja.add(new Carta("RB")); 
		
		baraja.add(new Carta("1C")); 
		baraja.add(new Carta("2C")); 
		baraja.add(new Carta("3C")); 
		baraja.add(new Carta("4C")); 
		baraja.add(new Carta("5C")); 
		baraja.add(new Carta("6C")); 
		baraja.add(new Carta("7C")); 
		baraja.add(new Carta("SC")); 
		baraja.add(new Carta("CC")); 
		baraja.add(new Carta("RC")); 
		
		
		baraja.add(new Carta("1E")); 
		baraja.add(new Carta("2E")); 
		baraja.add(new Carta("3E")); 
		baraja.add(new Carta("4E")); 
		baraja.add(new Carta("5E")); 
		baraja.add(new Carta("6E")); 
		baraja.add(new Carta("7E")); 
		baraja.add(new Carta("SE")); 
		baraja.add(new Carta("CE")); 
		baraja.add(new Carta("RE")); 
		
		
		baraja.add(new Carta("1O")); 
		baraja.add(new Carta("2O")); 
		baraja.add(new Carta("3O")); 
		baraja.add(new Carta("4O")); 
		baraja.add(new Carta("5O")); 
		baraja.add(new Carta("6O")); 
		baraja.add(new Carta("7O")); 
		baraja.add(new Carta("SO")); 
		baraja.add(new Carta("CO")); 
		baraja.add(new Carta("RO")); 
		
		
		
	}
	
	 public void crearbaraja(){
		    for(int i=0;i<baraja.size();i++){
		      //  System.out.print(baraja.get(i).getDenominacion()+""+baraja.get(i).getPalo());
		        if(i<(baraja.size()-1)){
		      //    System.out.print(" ");
		        }else{
		      //    System.out.print("\n");
		        }
		        }
		}
	
	public void Barajar() {
		
		Collections.shuffle(baraja); 
		 for(int i=0;i<baraja.size();i++){
		 //       System.out.print(baraja.get(i).getDenominacion()+""+baraja.get(i).getPalo());
		        if(i<(baraja.size()-1)){
		     //     System.out.print(" ");
		        }else{
		     //     System.out.print("\n");
		        }
		        }
		
	
	}
	public ArrayList<Carta> ObtenerNcartas(int j) {
		for(int i=0;i<j;i++){
		    this.repartidas.add(this.baraja.get(0));
		    this.baraja.remove(0);
		    
		}
		for(int i=0;i<repartidas.size();i++){
	      //  System.out.print(repartidas.get(i).getDenominacion()+""+repartidas.get(i).getPalo());
	        if(i<(repartidas.size()-1)){
	     //     System.out.print(" ");
	        }else{
	      //    System.out.print("\n");
	        }
	        }
		return repartidas;
		
	}	
	public void ResetBaraja() {
		  for(int t=0;t<repartidas.size();t++){
		        this.baraja.add(this.repartidas.get(t));
		    }
		    this.repartidas.removeAll(baraja);
		    for(int y=0;y<baraja.size();y++){
		      //  System.out.print(baraja.get(y).getDenominacion()+""+baraja.get(y).getPalo());
		        if(y<(baraja.size()-1)){
		        //  System.out.print(" ");
		        }else{
		        //  System.out.print("\n");
		        }
		        }
		
	}	
	public void Ordenar() {
		Collections.sort(baraja,new ordenacartas());
	    for(int j=0;j<baraja.size();j++){
	        System.out.print(baraja.get(j).getDenominacion()+""+baraja.get(j).getPalo());
	        if(j<(baraja.size()-1)){
	          System.out.print(" ");
	        }else{
	          System.out.print("\n");
	        }
	        }
	 }
		
}	
		
	
	

