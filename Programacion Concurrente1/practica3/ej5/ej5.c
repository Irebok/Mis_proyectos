#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){

int turno;  
int noturno;
	
	if(*argv[1] == 'p'){
	noturno=0;
	turno=1;
	}else{
	turno=0;
	noturno=1;
	}

int key = ftok("/home/inaki/practicas/practica3/ej5/ej5",'X');
	if(key == -1){
	printf("Error al generar la key\n");
	return -1;
	}

int id = shmget(key, sizeof(int), IPC_CREAT | 0600);
	if(id == -1){
	printf("Error al generar la id\n");
	return -1;
	}

int *buffer = shmat(id, (void*)0, 0);
	if(buffer == (int*)(-1)){
	printf("Error al enlazar buffer\n");
	return -1;
	}
	

	printf("Caminando por la habitacion");
	while(1){
	getchar();
	printf("Intentando entrar en la seccion critica\n");
		if(turno == *buffer){
		printf("Dentro de mi seccion critica");
		getchar();
		printf("He salido de mi secciñon critica");
		getchar();
		printf("He accionado el pulsador\n\n");
		*buffer = noturno;
		printf("Caminando por la habitacion");
		}else{
		printf("Puerta cerrada\n");
		}
	}


return 0;





}
