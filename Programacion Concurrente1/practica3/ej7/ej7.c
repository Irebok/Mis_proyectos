#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){

int abierta = 1;  
int cerrada = 0;
int yo;
int otro;
	
	if(*argv[1] == 'p'){;
	yo=1;
	otro=0;
	}else{
	yo=0;
	otro=1;
	}

int key = ftok("/home/inaki/practicas/practica3/ej7/ej7",'X');
	if(key == -1){
	printf("Error al generar la key\n");
	return -1;
	}

int id = shmget(key, 2*sizeof(int), IPC_CREAT | 0600);
	if(id == -1){
	printf("Error al generar la id\n");
	return -1;
	}

int *buffer = shmat(id, (int*)0, 0);
	if(buffer == (int*)(-1)){
	printf("Error al enlazar buffer\n");
	return -1;
	}
	
buffer[0] = abierta;
buffer[1] = abierta;

	printf("Caminando por la habitacion");
	getchar();
	printf("Dentro del pasillo");
	getchar();
	printf("He accionado el pulsador");
	buffer[otro] =cerrada;
	while(1){
	getchar();
	printf("Intentando entrar en la seccion critica\n");
		if(buffer[yo] == abierta){
		printf("Dentro de mi seccion critica");
		getchar();
		printf("He salido de mi seccion critica");
		getchar();
		printf("He accionado el pulsador\n\n");
		buffer[otro] = abierta;
		printf("Caminando por la habitacion");
		getchar();
		printf("Dentro del pasillo");
		getchar();
		printf("He accionado el pulsador");
		buffer[otro] =cerrada;
		}else{
		printf("Puerta cerrada\n");
		}
	}


return 0;





}
