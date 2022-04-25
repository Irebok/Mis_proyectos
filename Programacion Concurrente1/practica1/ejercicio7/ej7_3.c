
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <stdio.h>

int fin=0;
int pid;
void redefinir(int n);
int T_PISO=4;

int main(int arg, char *argv[]){
	
	pid=atoi(argv[1]);
	struct sigaction nueva_accion;
	nueva_accion.sa_handler=redefinir;
	sigaction(10,&nueva_accion,NULL);

	while(fin==0){
	pause();
	}

	return 0;

}

void redefinir(int sig){

	if(sig=10){
	sleep(T_PISO);
	printf("Ha llegado el ascensor");
	kill(pid,14);
	}

}
