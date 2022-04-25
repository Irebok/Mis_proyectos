#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>


void *carv();
void *ram();
void *piq();
void *thi();

int main(){

pthread_t carva;
pthread_t ramos;
pthread_t pique;
pthread_t thiago;

printf("De Gea ");
	 
	pthread_create(&carva, NULL, &carv,NULL);
	pthread_create(&ramos, NULL, &ram,NULL);
	pthread_create(&pique, NULL, &piq,NULL);

printf("Jordi Alba ");
	
	pthread_create(&thiago, NULL, &thi,NULL);

pthread_join(carva,NULL);
pthread_join(ramos,NULL);
pthread_join(pique,NULL);

printf("Busquets ");
printf("Isco ");
printf("Aspas ");

pthread_join(thiago,NULL);

printf("Morata ");
	
printf("\nFIN del codigo principal\n");
return 0;
}

void *carv(){	
printf("Carvajal "); 
pthread_exit(NULL);
}

void *ram(){	
printf("Ramos "); 
pthread_exit(NULL);
}

void *piq(){	
printf("Pique "); 
pthread_exit(NULL);
}

void *thi(){	
printf("Thiago ");
printf("Silva "); 
pthread_exit(NULL);
}
