#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#include <semaphore.h>

void *accion_leer(void *arg);
void *accion_escribir(void *arg);

int teclo;
int teclo2;

int numero_lectores = 0;
int numero_escritores = 0;

sem_t se_no_escritores;

sem_t se_memoria_leer;
sem_t se_memoria_escribir;
sem_t se_papel;
sem_t se_maxi_esc;
sem_t se_maxi_lec;
sem_t se_paso_lector;
sem_t se_iniciar_lector[10];
sem_t se_iniciar_escritor[10];
sem_t se_terminar_lector[20];
sem_t se_terminar_escritor[20];

struct thread_info{
pthread_t id;
int n;
};

int main(int argc, char *argv[]){

struct thread_info *tinfo;

int N1= atoi(argv[1]);
int N2= atoi(argv[2]);
int N3= atoi(argv[3]);
pthread_t id1[N1];
pthread_t id2[N3];
int i;
int j;

tinfo = calloc(N1+N3, sizeof(struct thread_info));

	for(int k = 1; k <= N1; k++){ 
	tinfo[k].id = k;
	tinfo[k].n = k;
	j = pthread_create(&tinfo[k].id, NULL, &accion_leer,&tinfo[k]);
	         if(j != 0){printf("error en creacion");}
	sem_init(&se_iniciar_lector[k],0,0);
	sem_init(&se_terminar_lector[k],0,0);
	}


	for(int k = 1; k <= N3; k++){ 
	tinfo[k].id = k;
	tinfo[k].n = k;
	j = pthread_create(&tinfo[k].id, NULL, &accion_escribir,&tinfo[k]);
	         if(j != 0){printf("error en creacion");}
	sem_init(&se_iniciar_escritor[k],0,0);
	sem_init(&se_terminar_escritor[k],0,0);
	}

sem_init(&se_maxi_lec,0,N2);
sem_init(&se_maxi_esc,0,1);
sem_init(&se_papel,0,1);
sem_init(&se_memoria_leer,0,1);
sem_init(&se_memoria_escribir,0,1);
sem_init(&se_paso_lector,0,1);


printf("\nNumero de lectores: %i",N1);
printf("\nNumero maximo de lectores concurrentes: %i",N2);
printf("\nNumero de escritores: %i",N3);
printf("\nNumero maximo de lectores concurrentes: 1");

	while( teclo != 5){
	printf("\n\n1. Intentar leer");
	printf("\n2. Finalizar leer");
	printf("\n3. Intentar escribir");
	printf("\n4. Finalizar escribir");
	printf("\n5. Salir\n\n");
	scanf("%i",&teclo);

		if(teclo == 1){ 
		printf("\n>Introduzca el numero del lector(de 1 a %i):",N1);
		scanf("%i",&teclo2);
		printf("%i",teclo2);
		sem_post(&se_iniciar_lector[teclo2]);
		
		}else if(teclo == 2){
		printf("\n>Introduzca el numero del lector(de 1 a %i):",N1);
		scanf("%i",&teclo2);
		sem_post(&se_terminar_lector[teclo2]);				
		
		}else if(teclo == 3){
		printf("\n>Introduzca el numero del escritor(de 1 a %i):",N3);
		scanf("%i",&teclo2);
		sem_post(&se_iniciar_escritor[teclo2]);				
		
		}else if(teclo == 4){
		printf("\n>Introduzca el numero del escritor(de 1 a %i):",N3);
		scanf("%i",&teclo2);
		sem_post(&se_terminar_escritor[teclo2]);				
		} 	
	}


printf("\nFIN del codigo principal\n");
return 0;
}

void *accion_leer(void *arg){
struct thread_info *tinfo = arg;
	while(1){
	printf("[Lector %i]-> Esperando a intentar leer...\n",tinfo->n);
	sem_wait(&se_iniciar_lector[tinfo->n]);
	
	sem_wait(&se_memoria_leer);
	numero_lectores++;
	printf("numero lectores: %i\n",numero_lectores);
		if(numero_lectores == 1){sem_post(&se_memoria_leer);
					 sem_wait(&se_papel);
					 sem_post(&se_paso_lector);

						if(numero_escritores>0){
						sem_post(&se_papel);
						sem_wait(&se_no_escritores);				
						sem_wait(&se_papel);						
						}

		}else if(numero_lectores > 1){sem_post(&se_memoria_leer);
					      sem_wait(&se_paso_lector);
					      sem_post(&se_paso_lector);
		}

	printf("[Lector %i]-> Intentando leer...\n",tinfo->n);
	
	sem_wait(&se_maxi_lec);
	
	printf("[Lector %i]-> Leyendo...\n",tinfo->n);

	sem_wait(&se_terminar_lector[tinfo->n]);
	sem_post(&se_maxi_lec);
	
	sem_wait(&se_memoria_leer);
	numero_lectores--;
		if(numero_lectores == 0){ sem_post(&se_papel);}
	sem_post(&se_memoria_leer);	
	
	printf("[Lector %i]-> Fin lectura...\n",tinfo->n);
	}
pthread_exit(NULL);
}



void *accion_escribir(void *arg){
struct thread_info *tinfo = arg;
	while(1){
	printf("[Escritor %i]-> Esperando a intentar escribir...\n",tinfo->n);
	sem_wait(&se_iniciar_escritor[tinfo->n]);
	
	printf("[Escritor %i]-> Intentando escribir...\n",tinfo->n);
	
	sem_wait(&se_memoria_escribir);
	numero_escritores++;
	sem_post(&se_memoria_escribir);
	
	sem_wait(&se_papel);

	sem_wait(&se_memoria_escribir);
	numero_escritores--;
	sem_post(&se_memoria_escribir);

	printf("[Escritor %i]-> Escribiendo...\n",tinfo->n);
	sem_wait(&se_terminar_escritor[tinfo->n]);
	
	sem_wait(&se_memoria_escribir);
	if(numero_escritores == 0){sem_post(&se_no_escritores);}
	sem_post(&se_memoria_escribir);

	sem_post(&se_papel);
	printf("[Escritor %i]-> Fin escritura...\n",tinfo->n);
	}
pthread_exit(NULL);
}

