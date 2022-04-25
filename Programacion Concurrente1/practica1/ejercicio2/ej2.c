#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <stdlib.h>

int main(int arg, char *argv[]) {

int pid = atoi(argv[1]);
int sig = atoi(argv[2]);

kill(pid,sig);
return 0;

}
