#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#include <semaphore.h>

void *accion(void *arg);

int teclo;

struct thread_info{
int n;
};

int main(int argc, char *argv[]){

struct thread_info *tinfo;

int N1= atoi(argv[1]);
int N2= atoi(argv[2]);
int i;
int j;
pthread_t id[N1];

 tinfo = calloc (N1, sizeof(struct thread_info)); 
	for(int k = 1; k <= N1; k++){ 
	tinfo[k].n = k;
	j = pthread_create(&id[k], NULL, &accion,&tinfo[k]);
	         if(j != 0){printf("error en creacion");}
	}


printf("\nNumero de lectores: %i",N1);
printf("\nNumero maximo de lectores concurrentes: %i",N2);

	while( teclo != 3){
	printf("\n1. Intentar leer");
	printf("\n2. Finalizar leer");
	printf("\n3. Salir\n");
	scanf("%i",&teclo);
		if(teclo == 2){ 
		printf("\n>Introduzca el numero del lector(de 1 a N1");
		scanf("%i",&teclo);
		
		}else if(teclo == 2){
		printf("\n>Introduzca el numero del lector(de 1 a N1");
		scanf("%i",&teclo);
					
		}
	} 


printf("\nFIN del codigo principal\n");
return 0;
}

void *accion(void *arg){
struct thread_info *tinfo = arg;
	while(1){
	printf("[\nLector %i]-> Esperando a intentar leer...",tinfo->n);
	}
pthread_exit(NULL);
}


