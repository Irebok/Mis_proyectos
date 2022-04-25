
public class ResuelvePares {

	
	
	
	
	
	
	
	public int[] ResuelvePares() {
		int piedras[]= {0,0};
		piedras[0]=pareja1.jugador1.calculaPares()+pareja1.jugador2.calculaPares();
		piedras[1]=pareja2.jugador1.calculaPares()+pareja2.jugador2.calculaPares();
		return piedras;
	}
	
	
}
