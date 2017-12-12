#include <stdio.h>
#include <stdlib.h>

int sommeNEntiers(int N);

int main()
{
    printf("Somme des N premiers entiers positifs : %d\n", sommeNEntiers(25));
    return 0;
}

/* Permet de sommer les N premiers entiers */
int sommeNEntiers(int N)
{
    int i, resultat = 0;

    for(i = 1; i <= N; i++){
        resultat += i;
    }

    return resultat;
}
