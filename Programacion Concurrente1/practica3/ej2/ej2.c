#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>

int main(){

int key = ftok("/home/inaki/practicas/practica3/ej1/ej1.c",'X');
	if(key == -1){
	printf("Error al generar la key\n");
	return -1;
	}

int id = shmget(key, sizeof(int), IPC_CREAT | 0666);
	if(id == -1){
	printf("Error al generar la id\n");
	return -1;
	}

int *buffer = shmat(id, (void*)0, 0);
	if(buffer == (int*)(-1)){
	printf("Error al enlazar buffer\n");
	return -1;
	}

printf("El contenido del identificado %i es: %i\n", id, *buffer);


if(shmdt(buffer) == -1){
perror("shmdt");
printf("Error al desenlazar el buffer\n");
return -1;
}

return 0;





}
