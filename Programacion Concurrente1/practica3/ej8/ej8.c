#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){

int abierta = 1;  
int cerrada = 0;
int yo_seccion;
int otro_seccion;
	
	if(*argv[1] == 'p'){;
	yo_seccion=0;
	otro_seccion=1;

	}else{
	yo_seccion=1;
	otro_seccion=0;
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

	while(1){
	printf("Caminando por la habitacion");
	getchar();
	printf("Dentro del pasillo");
	getchar();
	printf("He accionado el pulsador");
	buffer[otro_seccion] = cerrada;
	getchar();
	printf("Intentando entrar en la seccion critica\n");

		if(buffer[yo_seccion] == abierta){
		printf("Dentro de mi seccion critica");
		getchar();
		printf("He salido de mi seccion critica");
		getchar();
		printf("He accionado el pulsador\n\n");
		buffer[otro_seccion] = abierta;

		}else{
		printf("Puerta cerrada\n");
		printf("Saliendo del pasillo");
		getchar();
		printf("He accionado el pulsador\n");
		buffer[otro_seccion] =abierta;

		}
	}


return 0;





}
