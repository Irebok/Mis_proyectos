#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>


int main(){

int id = msgget( 11, 0777 | IPC_CREAT);

printf(" El identificador de mi buzon es: %i\n",id);



return 0;
}
