#include <sys/shm.h>
#include <sys/ipc.h>
#include <stdio.h>
#include <stdlib.h>

int main(){

int key = ftok("/home/inaki/practicas/practica3/ej3/ej3_1.c",'X');
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

if( shmctl(id, IPC_RMID, NULL)  == -1){
perror("shmdt");
printf("Error al destruir un segmento\n");
return -1;
}
printf("Segmento destruido\n");

return 0;





}
