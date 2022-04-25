#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>

void redefinir(int sig);
int contador = 0;
int contador_hijos = 0;
pid_t pid_hijo;

int main(){

struct sigaction nueva_accion;
nueva_accion.sa_handler=redefinir;
sigaction(17,&nueva_accion,NULL);

	for (int k = 0; k<3; k++){
	pid_hijo=fork();
	printf("Se ha creado el proceso hijo con pid %d\n",pid_hijo);
	}
	
	if(pid_hijo == 0){
	sleep(2);
	return 0;
	}
	
	while(contador<3){
	pause();
	}

return 0;
}


void redefinir(int sig){

	if(sig == 17){
	printf("Se ha terminado un proceso hijo con pid %d\n",pid_hijo);
	contador++;
	}
return;
}
