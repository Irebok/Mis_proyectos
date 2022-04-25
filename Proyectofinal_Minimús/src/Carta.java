

public class Carta {
	private char denominacion; //1, 2, 3, 4, 5, 6 , 7, S, C, R
	private char palo; //B, E, C, O
	private int puntos,pares; //1, 4, 5, 6, 7, 10

	
	public Carta (String representacion){
		this.denominacion=representacion.charAt(0);
		this.palo=representacion.charAt(1);
		calculaPuntos();
		calculaPar();
	}
	public char getDenominacion(){
		return denominacion;
	}
	public char getPalo(){
		return palo;
	}
	public int getPuntos(){
		return puntos;
		
	}
	public int getPares(){
		return pares;
		
	}
	private void calculaPuntos(){
		switch(denominacion){
		case '1':
		case '2':
			puntos=1;
			break;
		case '3':
			puntos=10;
			break;
		case '4':
			puntos=4;
			break;
		case '5':
			puntos=5;
			break;
		case '6':
			puntos=6;
			break;
		case '7':
			puntos=7;
			break;
		case 'S':
		case 'C':
		case 'R':
			puntos=10;
			break;
		}	
	}
	private void calculaPar(){
		switch(denominacion){
		case '1':
		case '2':
			pares=1;
			break;
		case '3':
			pares=10;
			break;
		case '4':
			pares=4;
			break;
		case '5':
			pares=5;
			break;
		case '6':
			pares=6;
			break;
		case '7':
			pares=7;
			break;
		case 'S':
			pares=8;
			break;
		case 'C':
			pares=9;
			break;
		case 'R':
			pares=10;
			break;
		}	
	}
	public boolean esUnRey (){
		
		if( denominacion=='R'){
				System.out.println("Es un rey")	;
		}
		return true;
	}
	public boolean esUnAs (){
			
		if (denominacion=='R'){
				System.out.println("Es un as");
		}
		return true;
	}
	
	
	
	
}