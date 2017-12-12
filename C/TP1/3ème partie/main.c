#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int intToBinary(int N);
int SignedBinary(int N);

int main()
{
    printf("77 en entier non signe : %d \n", intToBinary(77));
    printf("77 en entier non signe : %u \n\n", intToBinary(SignedBinary(77)));

    unsigned int var = 77;
    unsigned int var2 = ~var;

    printf("%u : %u\n\n", var, var2);

    var = 101101;
    var2 = ~var;

    printf("%u : %u\n\n", var, var2);

    return 0;
}

/* Permet de passer d'un nombre en base 10 à un nombre en base 2
*  @param int N : nombre a convertir en binaire
*  @param bool signe : si le nombre est à retourner signe ou non
*/
int intToBinary(int N){
    // Conditions d'arrêts de la fonction
    if(N == 1 || N == 0){
        return N;
    }
    else{
        // Retour récursif
        return (N%2) + 10 * intToBinary(N / 2);
    }
}

int SignedBinary(int N){
    // On inverse et on ajoute 1
    N = ~N;
    return (N);
}

