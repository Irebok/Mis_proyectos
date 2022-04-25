#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

void *filosofo(void *arg);
void *inic_filosofos(void *arg);
int nueva_cola(int id);

struct mensaje{
long tipo;
char texto[1];
};

struct thread_info{
pthread_t id2;
int id;
int n;
};


int teclo;
int teclo2;

sem_t se_filosofo[5];
sem_t se_init;



int main(){

struct thread_info *tinfo;

int tamano;
int tipo = 0;
struct mensaje mimensaje;

int id = msgget(11, 0777 | IPC_CREAT);

tinfo = calloc(5,sizeof(struct thread_info));

	for(int k= 1; k<=5; k++){

	tinfo[k].id = id;
	tinfo[k].n = k;
	tinfo[k].id2 = k;

	int j = pthread_create(&tinfo[k].id2, NULL, &filosofo, &tinfo[k]);
		if(j!=0){printf("Error en creacion");}
	sem_init(&se_filosofo[k],0,0);
	}

pthread_t h = 6;
int j = pthread_create(&h, NULL, &inic_filosofos, &tinfo[5]);
	if(j!=0){printf("Error en creacion");}

sem_init(&se_init,0,0);
	

	while(teclo != 4){
	
	printf("\n\n1.Restaurar cola");
	printf("\n2.Coger tenedor");
	printf("\n3.introducir tenedores");
	printf("\n4.Salir\n");
	scanf("%i",&teclo);
		if(teclo == 2){
		printf("\nSelecciona el filosofo que quieres que coma:");
		scanf("%i",&teclo2);
			sem_post(&se_filosofo[teclo2]);
		printf("\nnueva vuelta\n");
		
		}else if(teclo == 3){
		sem_post(&se_init); 
		}else if(teclo == 1){
		int id = nueva_cola(id);
		}
	}

printf("\nFin del codigo principal\n");
return 0;
}





int nueva_cola(int id){
msgctl(id,IPC_RMID,NULL);
id = msgget(11, 0777 | IPC_CREAT);
return id;
}








void *inic_filosofos(void *arg){
/*
struct mensaje mimensaje;
struct thread_info *tinfo = arg;
	while(1){
		sem_wait(&se_init);
		for(int k = 1;k <= 5; k++){
		mimensaje.tipo = (long)k;	
		int envio = msgsnd(tinfo->id, &mimensaje, sizeof(int),  0);
		}
	printf("Todos los tenedores añadios");
	}
*/}





void *filosofo(void *arg){

printf("primer");

struct thread_info *tinfo = arg;
struct mensaje mimensaje;
int n = tinfo->n;	
int tipo = tinfo->n;
int recibo;
int envio;

printf("\n[Filosofo %i] Creado",tinfo->n);
	
//	while(1){

//	sem_wait(&se_filosofo[tinfo->n]);
	printf("hola");
/*
	printf("\n[Filosofo %i] Preparado para empezar",n);
	recibo = msgrcv(tinfo->id, &mimensaje, sizeof(int), tipo,  0);
	
	printf("\n[Filosofo %i] Tenedor izquierdo %i cogido",n,tipo);
	
	tipo = (tinfo->n)-1;
		if(tipo == 0){
		tipo = 5;
		}

	recibo = msgrcv(tinfo->id, &mimensaje, sizeof(int), tipo,  0);
	printf("\n[Filosofo %i] Tenedor derecho %i cogido",n,tipo);

	printf("\n[Filosofo %i] Comiendo",n);

	sleep(5);
	
	mimensaje.tipo = (long)tipo;
	envio = msgsnd(tinfo->id, &mimensaje, sizeof(int),  0);
	printf("\n[Filosofo %i] Tenedor derecho  %i suelto",mimensaje.tipo);


	mimensaje.tipo = (long)(tipo+1);
		if(mimensaje.tipo == 6){
		mimensaje.tipo = 1;
		}
	
	envio = msgsnd(tinfo->id, &mimensaje, sizeof(int),  0);
	printf("\n[Filosofo %i] Tenedor izquierdo %i suelto",tipo,mimensaje.tipo);

	}	
*/
pthread_exit(NULL);
}
