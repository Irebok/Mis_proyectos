
#include <unistd.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <stdio.h>

int fin=0;
int pid;
void accion(int n);

int main(int arg, char *argv[]){
	
	pid = atoi(argv[1]);
	int boton = 0;

	printf("Seleccione el boton deseado:\n 1) Subir\n 2) Bajar\n 3) Salir \n");
		
	while(fin==0){
	printf("Su selección es: ");
	scanf("%d",&boton);
	printf("\n");
	accion(boton);
	}

	return 0;

}

void accion(int n){

	switch(n){
	
	case 1: 
	kill(pid,10);
	break;

	case 2:
	kill(pid,12);
	break;
	
	case 3:
	kill(pid,3);
	fin=1;
	break;
	
	default:
	printf("Seleccione una respuesta valida\n");
	return;
	}	
}

