import java.util.ArrayList;

public class Pareja {
	private int idpareja;//entre 0 y 999
	private String nombrepareja;//adena de caracteres de longitude variable
	private int idjugador1;
	private int idjugador2;
	private int listagrande[];
	private int listachica[];
	private int valorespuntos[]= {31,32,40,37,36,35,34,33};
	private ArrayList<Jugador> Orden= new ArrayList<Jugador>();
	private boolean manoPareja=false;
	Jugador jugador1,jugador2;
	
	public Pareja(int idpareja, String nombrepareja,Jugador j1,Jugador j2) {
		this.idpareja=idpareja;
		this.nombrepareja=nombrepareja;
		jugador1=j1;
		jugador2=j2;
		idjugador1=jugador1.getid();
		idjugador2=jugador2.getid();
		listagrande=grande();
		listachica=chica();
		if(jugador1.getmano()==true||jugador2.getmano()==true) {
			manoPareja=true;
			
			
			
		
			
			
		}
		Ordenar();

	}
	public int getidpareja(){
		return idpareja;
	}
	public String getnombrepareja(){
		return nombrepareja;
	}


	
	
	public void Ordenar(){
	 if(jugador1.getjuego()==true&&jugador2.getjuego()==true) {
		 for( int i =0;i<8;i++) {
			 if(jugador1.calculasumaPuntos()==valorespuntos[i]) {
				 this.Orden.add(jugador1);
				 this.Orden.add(jugador2);
			 }else if(jugador2.calculasumaPuntos()==valorespuntos[i])
				 this.Orden.add(jugador2);
			 	 this.Orden.add(jugador1);
		 }
		 
	 }else if(jugador1.getjuego()==true&&jugador2.getjuego()==false) { 
		 this.Orden.add(jugador1);
	 	this.Orden.add(jugador2);
	 }
	 else if(jugador1.getjuego()==false&&jugador2.getjuego()==true) {
		 this.Orden.add(jugador2);
		 this.Orden.add(jugador1);
	 }
	 
	 else if(jugador1.getjuego()==false&&jugador2.getjuego()==false) {
		 
		 if(jugador1.calculasumaPuntos()>=jugador2.calculasumaPuntos()) { 
			 this.Orden.add(jugador1);
		 	this.Orden.add(jugador2);
		 }
		 if(jugador1.calculasumaPuntos()<jugador2.calculasumaPuntos())  {
			 this.Orden.add(jugador2);
		 	this.Orden.add(jugador1);
		 }
	 
	}

} 





	public int[]  grande(){
		for (int i=0;i<8;i++) {
		if (jugador1.getlistavalores(i)>jugador2.getlistavalores(i)) {
			return jugador1.getlistavalores();
		}if(jugador1.getlistavalores(i)<jugador2.getlistavalores(i)) {
			return jugador2.getlistavalores();
		}
		}		
		return jugador1.getlistavalores();
		}
	public int[]  chica(){
		for (int i=7;i>=0;i--) {
		if (jugador1.getlistavalores(i)>jugador2.getlistavalores(i)) {
			return jugador1.getlistavalores();
		}if(jugador1.getlistavalores(i)<jugador2.getlistavalores(i)) {
			return jugador2.getlistavalores();
		}
		}		
		return jugador1.getlistavalores();
		}
	
	
	public int getlistagrande(int i) {
		return listagrande[i];
	
	}

	public int[] getlistagrande() {
		return listagrande;
	
	}
	public int getlistachica(int i) {
		return listachica[i];
	
	}

	public int[] getlistachica() {
		return listachica;
	
	}

	public ArrayList<Jugador> getOrden() {
		return this.Orden;
	
	}
	public boolean getManoPareja() {
		return manoPareja;
	
	}
	
	
}
