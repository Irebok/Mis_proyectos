#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/types.h>
#include <string.h>
#include <stdlib.h>


int main(int argc, char *argv[]){



	for (int k=0; k<argc; k++){
	printf("%s ",argv[k]);	
	}


sleep(2);
return 0;	
}


