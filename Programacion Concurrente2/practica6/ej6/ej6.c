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

struct tenedor{
long tipo;
char texto[1];
};

struct thread_info{
pthread_t id_hilo;
int id[6];
int n;
};


int teclo;
int teclo2;

sem_t se_filosofo[5];
sem_t se_init;



void borrar(int id[6]){
for (int k =1; k<=5; k++){
int solucion = msgctl(id[k],IPC_RMID,NULL);
 if(solucion == 0){printf("Cola %i borrada correctamente\n",k);}	
	}
}



int main(){

struct thread_info *tinfo;

int tamano;
int tipo = 0;
struct tenedor tenedor[5];
int id[6];
 id[1] = msgget(1, 0777 | IPC_CREAT);
 id[2] = msgget(2, 0777 | IPC_CREAT);
 id[3] = msgget(3, 0777 | IPC_CREAT);
 id[4] = msgget(4, 0777 | IPC_CREAT);
 id[5] = msgget(5, 0777 | IPC_CREAT);
 
 borrar(id);
 
 id[1] = msgget(1, 0777 | IPC_CREAT);
 id[2] = msgget(2, 0777 | IPC_CREAT);
 id[3] = msgget(3, 0777 | IPC_CREAT);
 id[4] = msgget(4, 0777 | IPC_CREAT);
 id[5] = msgget(5, 0777 | IPC_CREAT);
 

tinfo = calloc(6,sizeof(struct thread_info));

	for(int k= 1; k<=5; k++){
		for(int m=1; m<=5;m++){
		tinfo[k].id[m] = id[m];
		}
	tinfo[k].n = k;
	tinfo[k].id_hilo = k;

	int j = pthread_create(&tinfo[k].id_hilo, NULL, &filosofo, &tinfo[k]);
		if(j!=0){printf("Error en creacion");}
	sem_init(&se_filosofo[k],0,0);
	}

pthread_t h = 6;
int j = pthread_create(&h, NULL, &inic_filosofos, &tinfo[5]);
	if(j!=0){printf("Error en creacion");}

sem_init(&se_init,0,0);
	

	while(teclo != 4){
	
	printf("\n1.Restaurar cola");
	printf("\n2.Coger tenedor");
	printf("\n3.Introducir tenedores");
	printf("\n4.Salir");
	printf("\n5.Ver colas\n\n");
	scanf("%i",&teclo);
		if(teclo == 2){
		printf("\nSelecciona el filosofo que quieres que coma:");
		scanf("%i",&teclo2);
			sem_post(&se_filosofo[teclo2]);
		
		}else if(teclo == 3){
		sem_post(&se_init); 
	      /*}else if(teclo == 1){
		id[]  = nueva_cola(id,n);
	      */}else if(teclo == 5){
		system("ipcs -q");
		}
	}

printf("\nFin del codigo principal\n");
return 0;
}




/*
int[5]  nueva_cola(int id[5]){
	
	for (int k =1; k<=5; k++){
	int solucion = msgctl(id[k],IPC_RMID,NULL);	
	if(solucion == 0){printf("\ncola borrada correctamente");}
	
	id[k] = msgget(k, 0777 | IPC_CREAT);
	if(tinfo.id[k] > 0){printf("\nCola creada correctamente");}
	}
return id;
}*/








void *inic_filosofos(void *arg){

struct tenedor mitenedor[6];
struct thread_info *tinfo = arg;
	while(1){
		sem_wait(&se_init);
		for(int k = 1;k <= 5; k++){
		mitenedor[k].tipo = k;	
		int envio = msgsnd(tinfo->id[k], &mitenedor[k], sizeof(int),  0);
		}
	printf("\nTodos los tenedores añadios\n");
	}
}





void *filosofo(void *arg){


struct thread_info *tinfo = arg;
struct tenedor mitenedor[6];
int n = tinfo->n;	
int tipo = tinfo->n;
int recibo;
int envio;

printf("[Filosofo %i] Creado\n",tinfo->n);
	
	while(1){

	sem_wait(&se_filosofo[tinfo->n]);

	printf("[Filosofo %i] Preparado para empezar",n);
	recibo = msgrcv(tinfo->id[tipo], &mitenedor[tipo], sizeof(int), 0,  0);

	printf("\n[Filosofo %i] Tenedor izquierdo %i cogido",n,tipo);
	
	tipo = (tinfo->n)-1;
		if(tipo == 0){
		tipo = 5;
		}
	recibo = msgrcv(tinfo->id[tipo], &mitenedor[tipo], sizeof(int), 0,  0);

	printf("\n[Filosofo %i] Tenedor derecho %i cogido",n,tipo);

	printf("\n[Filosofo %i] Comiendo",n);

	sleep(4);
	
	int s = tipo;
	mitenedor[s].tipo=tipo;
	envio = msgsnd(tinfo->id[s], &mitenedor[s], sizeof(int),  0);
	//if(envio==0){printf("[Filosofo %i] Tenedor derecho %i  soltado",n,s);} 
	
	int ant	= s;
	s = (tipo + 1);
		if ( s==6 ){
		s = 1;
		}
	mitenedor[s].tipo = tipo;
				
	envio = msgsnd(tinfo->id[s], &mitenedor[s], sizeof(int),  0);	
	//if(envio==0){printf("[Filosofo %i] Tenedor izquierdp %i  soltado",n,s);} 
	
	printf("\n[Filosofo %i] Ha soltado los 2 tenedores(%i,%i)",n,ant,s);





	}	

pthread_exit(NULL);
}
