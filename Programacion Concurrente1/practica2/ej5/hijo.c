#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>
#include <stdlib.h>


int main(int argc, char *argv[]){

	printf("El proceso hijo con pid %i imprime la cadena: ",getpid());

	for (int k=0; k<(argc-1); k++){
	printf("%s ",argv[k]);	
	}
	printf("\n");

sleep(2 + atoi(argv[argc-1]));
return 0;	
}


