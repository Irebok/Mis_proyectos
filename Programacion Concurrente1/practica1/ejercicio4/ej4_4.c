
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <stdio.h>

void redefinir(int sig);
sigset_t mascara;
int fin = 0;
int contador1=0;
int contador2=0;

int main(){

	sigaddset(&mascara,SIGQUIT);
	struct sigaction nueva_accion;
	nueva_accion.sa_handler=redefinir;
	nueva_accion.sa_mask=mascara;
	
	sigaction(15,&nueva_accion,NULL);
	sigaction(12,&nueva_accion,NULL);
	sigaction(10,&nueva_accion,NULL);
	

	while(fin==0){
	pause();
	}

	return 0;


}

void redefinir(int sig){

	if(sig == 10){
	contador1++;
	}	

	if(sig == 12){
	contador2++;
	}

	if(sig == 15){
 	fin=1;
	printf("SIGUSR1: %i SIGUSR2: %i \n",contador1,contador2);
	return;
	}
}
