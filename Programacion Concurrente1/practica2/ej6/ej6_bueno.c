#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>
#include <stdlib.h>


int contador_defensas = 0;
pid_t defensas[4]={1, 1, 1, 1};
pid_t pid_salida;
pid_t pid_salida2;
int thiago;
int busq;
int repetir;
int fin_thiago;
int fin_extremo_izquierdo=0;

int main(){
printf("\n");

printf("De Gea ");


defensas[0] = fork();
	if(defensas[0] == 0){
	execl("hijo","Carvajal ",NULL); 
	exit(0);
	}

defensas[1] = fork();		
	if(defensas[1] == 0){
	execl("hijo","Ramos ",NULL); 
	exit(0);
	}

defensas[2] = fork();
	if(defensas[2] == 0){
	execl("hijo","Jordi Alba ",NULL); 
	exit(0);
	}

printf("Piqué "); 
	
		
while(contador_defensas!=3){

pid_salida = wait(NULL);

	if(defensas[1] == pid_salida || defensas[0] == pid_salida || pid_salida == defensas[2]){
	contador_defensas++;
//	printf(" Contador:%i ",contador_defensas);
	}
	
	if(defensas[2]=pid_salida){
		if(repetir==0){
		repetir=1;
		thiago=fork();
			if (thiago==0){	
			execl("hijo","Thiago Silva ",NULL); 	
			exit(0);
			}
		}
	}
	
	if(pid_salida==thiago){
	fin_extremo_izquierdo=1;
	}

}

printf("Busquets ");
printf("Isco ");
printf("Aspas ");



while(fin_extremo_izquierdo==0){

	pid_salida2=wait(0);

	if(pid_salida2==thiago){
	fin_extremo_izquierdo=1;
	}
}

printf("Morata\n ");	

return 0;
}


