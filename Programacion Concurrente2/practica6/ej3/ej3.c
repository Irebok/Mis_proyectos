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

struct mensaje mimensaje;
int id = atoi(argv[1]);

mimensaje.tipo = 1;
memcpy(mimensaje.texto,argv[2],10);

int envio = msgsnd(id, &mimensaje, sizeof(argv[2]), 0);

if(envio == 0){printf("Envio realizado con exito\n");}

return 0;
}
