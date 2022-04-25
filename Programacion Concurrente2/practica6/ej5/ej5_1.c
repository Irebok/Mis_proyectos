#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char *argv[]){

struct mensaje{
long tipo;
char texto[10];
};

int tamano;
int tipo = 0;
struct mensaje mimensaje;
int id = atoi(argv[1]);

int recibo = msgrcv(id, &mimensaje, tamano, tipo,  0);


if(recibo > 0){
printf("Mensaje recibido con exito\n");
printf("El mensaje de tamaño %i es: %s\n",recibo,mimensaje.texto);

}else{
printf("Error al recibir el mensaje");
}

return 0;
}
