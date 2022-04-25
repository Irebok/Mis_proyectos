#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>


int contador = 0;
int contador_hijos = 0;
pid_t pid_hijo[2];
pid_t pid;
int estado;
char texto[20]; 

int main(int argc, char *argv[]){


	for (int k = 0; k<3; k++){
	pid_hijo[k] = fork();
	sprintf(texto,"%i",k);
		if(pid_hijo[k] == 0){
		printf("Se ha creado el proceso hijo con pid %d\n",getpid());
			if(argc == 2){
			execl("hijo",argv[1],texto,NULL);
			}else if(argc == 3){
			execl("hijo",argv[1],argv[2],texto,NULL);
			}else{
			execl("hijo",argv[1],argv[2],argv[3],texto,NULL);
			}
		exit(0);

		}
	}
	
	while(contador<3){
	pid = waitpid(pid_hijo[contador],&estado,0);
		if(WIFEXITED(estado)){	
		printf("\nEl proceso con pid %i ha terminado de forma normal: %i\n",pid,WEXITSTATUS(estado));
		printf("Contador: %i\n",contador);
		contador++;
		}
	}
	

return 0;
}


