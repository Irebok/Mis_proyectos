#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <stdio.h>

int vector[64];
int fin = 0;
void redefinir(int sig);

int main(){

	struct sigaction nueva_accion;
	nueva_accion.sa_handler=redefinir;

	for( int k=1; k<65; k++){
	sigaction(k,&nueva_accion,NULL);		
	}	

	while(fin==0){
	pause();
	}


	return 0;

}


void redefinir(int sig){
	
	vector[sig]=1;
	
	if (sig==15){
	fin=1;
	printf("Vector final: ");
		for(int k=1; k<65; k++){
		printf("%i",vector[k]);
		}
	printf("\n");
	return;
	}

}	
