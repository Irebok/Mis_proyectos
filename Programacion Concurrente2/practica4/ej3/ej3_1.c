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
char *arg_string;
};

int main(){

int k;
struct thread_info *tinfo;

 tinfo = calloc( 4, sizeof(struct thread_info) );
	if(tinfo == 0){
	printf("fallo en calloc");
	}
printf("De Gea ");
 	pthread_t carva;
	char carvaj = "Carvajal ";
	tinfo[0].id = 0;
	tinfo[0].arg_string = *carvaj ;
	pthread_create(&tinfo[0].id, NULL, &argumentos,&tinfo[0]);

	tinfo[1].id = 1;
	tinfo[1].arg_string = "Ramos ";
	pthread_create(&tinfo[2].id, NULL, &argumentos,&tinfo[1]);

	tinfo[2].id = 2;
	tinfo[2].arg_string = "Pique ";
	pthread_create(&tinfo[2].id, NULL, &argumentos,&tinfo[2]);

printf("Jordi Alba ");
	
	tinfo[3].id = 3;
	tinfo[3].arg_string = "Thiago Silva ";
	pthread_create(&tinfo[4].id, NULL, &argumentos,&tinfo[4]);

pthread_join(tinfo[0].id, NULL);
pthread_join(tinfo[1].id, NULL);
pthread_join(tinfo[2].id, NULL);


printf("Isco ");
printf("Aspas ");

pthread_join(tinfo[3].id, NULL);


printf("Morata ");

printf("\nFIN del codigo principal\n");
pthread_exit(NULL);
return 0;
}

void *argumentos( void *arg ){
struct thread_info *tinfo = arg;	
printf("%s",tinfo->arg_string); 
pthread_exit(NULL);
}
