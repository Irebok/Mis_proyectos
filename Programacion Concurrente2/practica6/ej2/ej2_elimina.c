#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>


int main(int argc, char* argv[]){

int id = atoi(argv[1]);

int resul = msgctl(id, IPC_RMID , NULL);
	if( resul == 0){
	printf("Eliminado el buzon con id: %i\n",id); 
	}
return 0;
}
