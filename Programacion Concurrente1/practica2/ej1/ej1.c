#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>

void redefinir(int sig);
int contador = 0;
int contador_hijos;
pid_t pid_hijo;

int main(){

printf("Padre con pid %i\n",getpid());
		

	for(contador_hijos=0; contador_hijos<3; contador_hijos++){
	pid_hijo = fork();
	
		if (pid_hijo == 0){
		printf("Se ha creado un proceso hijo con pid %i\n",getpid());
		printf("Numero de hijos: %i\n",contador_hijos);
		sleep(2+contador_hijos);
		printf("Se ha terminado un proceso hijo con pid %d\n",getpid());
		return 0;
		}
	}

struct sigaction nueva_accion;
nueva_accion.sa_handler=redefinir;
sigaction(17,&nueva_accion,NULL);
	
	while(contador<3){
	pause();
	}
printf("Se finaliza el proceso padre\n");
return 0;
}


void redefinir(int sig){

	if(sig == 17){
	contador++;
	}
return;
}
