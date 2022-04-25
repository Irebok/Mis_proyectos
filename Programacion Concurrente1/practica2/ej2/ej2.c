#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>


int contador;
int contador_hijos = 0;
pid_t pid_hijo;
pid_t pid;
int estado;

int main(){


	for (int k = 0; k<3; k++){
	pid_hijo=fork();
		if(pid_hijo == 0){
		printf("Se ha creado el proceso hijo con pid %d\n",getpid());
		sleep(2+k);
		exit(0);
		}
	}
	
	while(contador<3){
	pid = wait(&estado);
		
	printf("El proceso con pid %i y %i ha terminado de forma normal: %i\n",pid,pid_hijo,WEXITSTATUS(estado));
	printf("Contador: %i\n",contador);
	contador++;
	}
	

return 0;
}


