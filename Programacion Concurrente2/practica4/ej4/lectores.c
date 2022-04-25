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
int teclo2;

sem_t se_maxi;
sem_t se_iniciar[8];
sem_t se_terminar[8];

struct thread_info{
pthread_t id;
int n;
};

int main(int argc, char *argv[]){

struct thread_info *tinfo;

int N1= atoi(argv[1]);
int N2= atoi(argv[2]);
pthread_t id[N1];
int i;
int j;

tinfo = calloc(N1, sizeof(struct thread_info));

	for(int k = 1; k <= N1; k++){ 
	tinfo[k].id = k;
	tinfo[k].n = k;
	j = pthread_create(&tinfo[k].id, NULL, &accion,&tinfo[k]);
	         if(j != 0){printf("error en creacion");}
	sem_init(&se_iniciar[k],0,0);
	sem_init(&se_terminar[k],0,0);
	}
	sem_init(&se_maxi,0,N2);

printf("\nNumero de lectores: %i",N1);
printf("\nNumero maximo de lectores concurrentes: %i",N2);

	while( teclo != 3){
	printf("\n1. Intentar leer");
	printf("\n2. Finalizar leer");
	printf("\n3. Salir\n\n");
	scanf("%i",&teclo);
		if(teclo == 1){ 
		printf("\n>Introduzca el numero del lector(de 1 a %i):",N1);
		scanf("%i",&teclo2);
		sem_post(&se_iniciar[teclo2]);
		
		}else if(teclo == 2){
		printf("\n>Introduzca el numero del lector(de 1 a %i):",N1);
		scanf("%i",&teclo2);
		sem_post(&se_terminar[teclo2]);				
		}
	} 


printf("\nFIN del codigo principal\n");
return 0;
}

void *accion(void *arg){
struct thread_info *tinfo = arg;
	while(1){
	printf("[Lector %i]-> Esperando a intentar leer...\n",tinfo->n);
	sem_wait(&se_iniciar[tinfo->n]);
	printf("[Lector %i]-> Intentando leer...\n",tinfo->n);
	sem_wait(&se_maxi);
	printf("[Lector %i]-> Leyendo...\n",tinfo->n);
	sem_wait(&se_terminar[tinfo->n]);
	sem_post(&se_maxi);
	printf("[Lector %i]-> Fin lectura...\n",tinfo->n);
	}
pthread_exit(NULL);
}


