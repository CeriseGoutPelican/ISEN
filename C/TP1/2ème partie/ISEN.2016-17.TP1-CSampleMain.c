/*--------------------------------------
  Ceci est un sample simple en langage C
 (c) yves.duprat@isen-lille.fr
--------------------------------------*/

// fichier d'include de bibliotheque
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <float.h>

// fichier d'include local
#include "ISEN.2016-17.TP1-CSample.h"

// Fonction principale qui correspond au point d'entree du programme
int main(int argc, char *argv[], char *env[])
{
// declaration de variable
int val ;
float f = 7.6 ; // 3.14159 ;

	// Debut de programme
	puts("Welcome aboard ..... \n") ;

	// Tester la valeur de argc qui correspond au nombre de parametres du programme
	switch(argc)
	{
		// pas de paramÔøΩtres
		case NO_ARG :
			// appel de la procedure qui affiche toutes les variables d'environement de la machine
			printEnv(env) ;

			// appel de la procÔøΩdure qui affiche la dynamique des types
			printDynamicOfAllCTypes() ;
			break ;

		case ONE_ARG :
			// appel de la fonction qui calcule le factoriel d'un nombre
			val = atoi( argv[1]) ;
            printf("Le factoriel de %d est %ld\n",val, computeFactoriel(val) ) ;
			break ;

		default:
            puts("ce programme prend 0 ou 1 parametre maximum qui correspond a une valeur numerique\n") ;
			break ;
	}

        // test float
        Float2Hex(f) ;

        int a = 81 ;
        int b = 27 ;
        printf("PGCD(%d,%d)=%d\n",a,b,PGCD(a,b)) ;

        // Test mypow
        printf("%d ** %d = %d\n", 3,5 ,mypow(3,5)) ;
	// fin de programme
	puts("This is the end ..... \n") ;
	return -1 ;
}
