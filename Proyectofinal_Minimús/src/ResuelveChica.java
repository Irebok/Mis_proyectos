
public class ResuelveChica {
	
	private	int piedras[]= {0,0};
	private	Pareja pareja1;
	private Pareja pareja2;
	
	public int[] ResuelveChica(Pareja p1,Pareja p2){
		
		pareja1=p1;
		pareja2=p2;
		
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
	
	
	
public int[] getpiedras() {
		
		return piedras;
	}
	
	
	
}
