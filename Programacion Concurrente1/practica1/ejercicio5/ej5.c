
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <stdio.h>

void redefinir(int sig);
void comienza_movimiento();
int fin = 0;
int contador1=0;
int contador2=0;
int piso_max;
int piso_actual = 0;
int moviendo = 0;
int T_PISO = 2;

int main(int arg,char *argv[]){
	
	piso_max = atoi(argv[1]);

	struct sigaction nueva_accion;
	nueva_accion.sa_handler=redefinir;

	sigaction(10,&nueva_accion,NULL);
	sigaction(12,&nueva_accion,NULL);	
	sigaction(3,&nueva_accion,NULL);
	sigaction(14,&nueva_accion,NULL);
	

	while(fin==0){
	pause();
	
	if (moviendo==1){

		for (int k=0;k<1000000000;k++){
		}
	}
	}

	return 0;


}



void redefinir(int sig){

	switch(sig){

	case 10:
	if(moviendo==1){
	return;
	}
	if(piso_actual!=piso_max){
	piso_actual++;
	contador1++;
	printf("Está subiendo un piso\n");
	comienza_movimiento();
	}else{
	printf("No puede subir más pisos\n");
	}
	break;	


	case 12:
	if (moviendo==1){
	return;
	}
	if(piso_actual!=0){
	piso_actual--;
	contador2++;
	printf("Está bajando un piso\n");
	comienza_movimiento();
	}else{
	printf("No puede bajar más pisos\n");
	}
	break;

	case 14:	
	moviendo=0;	
	printf("El ascensor ha llegado al piso %i \n",piso_actual);
	break;

	case 3:
 	fin=1;
	printf("Ha subido %i veces y bajado %i veces\n",contador1,contador2);
	printf("El piso actual es: %i\n",piso_actual);
	

	return;
	
	
	}
}




void comienza_movimiento(){
moviendo=1;
alarm(T_PISO);
return;

}
