#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>


void *argumentos(void *arg);

struct thread_info {
pthread_t id;
int n;
char *arg_string;
};

int main(int argc, char *argv[]){

struct thread_info *tinfo;

 tinfo = calloc( (argc-1), sizeof(struct thread_info) );
if(tinfo == 0){
printf("fallo en calloc");
}
printf("%i",tinfo);
	for(int k = 0; k < (argc-1); k++){ 
	tinfo[k].id = k;
	tinfo[k].n = (k+1);
	tinfo[k].arg_string = argv[k+1];
	pthread_create(&tinfo[k].id, NULL, &argumentos,&tinfo[k]);
	printf("\n%i %s ",tinfo[k].n, tinfo[k].arg_string);
	}
printf("\nFIN del codigo principal\n");
pthread_exit(NULL);
return 0;
}

void *argumentos(void *arg){
struct thread_info *tinfo = arg;	
printf("El argumento %i es: %s\n", tinfo->n, tinfo->arg_string); 
return NULL;
}
