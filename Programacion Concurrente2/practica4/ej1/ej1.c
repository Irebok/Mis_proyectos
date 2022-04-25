#include <pthread.h>
#include <stdio.h>

int contador = 0;
char letra;

void *cuenta_teclas();

int main(){
pthread_t h1;

pthread_create(&h1, NULL, cuenta_teclas, NULL);

	while(letra != 'q'){
	sleep(1);
	printf("\nNumero de teclas pulsadas: %i",contador);
	}
printf("\nNumero de teclas totales  pulsadas: %i\n",contador);

return 0;
}



void *cuenta_teclas(){
	printf("\nPresiona una/s tecla/s y/o pulsa enter: ");
	while(letra != 'q'){
	letra = getchar();
	contador++;
	}
return NULL;
}
