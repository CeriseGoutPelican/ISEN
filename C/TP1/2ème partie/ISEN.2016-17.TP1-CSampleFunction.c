 /*--------------------------------------
  Ceci est un sample simple en langage C
 (c) yves.duprat@isen-lille.fr
--------------------------------------*/

// fichier d'include de bibliotheque
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <float.h>
#include <string.h>


// Liste des define du programme
//
// les define sont toujours en majsucules
// Ils correspondent a des constantes
// ou a des mini-fonctions

#ifndef NULL
	#define NULL	0
#endif

#define UCHAR_MIN	0

// Procedure ne renvoit rien
void printEnv(char *env[])
{
// Declaration de variables en premiere colonne
int i ;

	// initialisation de la variable
	i = 0 ;

	// affiche toutes variables d'environnement de l'ordinateur
	while( env[i] != NULL )
		// block du while delimite par un { et }
	{
		printf("Variable # %02d est : %s\n",i+1, env[i]) ;
		i += 1 ; // ++i est aussi possible ;
	}
}

// Procedure (Ne retourne rien) sans parametres
void printDynamicOfAllCTypes()
{
	// declaration et initialisation des variables
	int i = 29000 ;
	long l = 100000000 ;
	float f = 3.14159 ;
	double d = 1.122e89 ;
	unsigned char c = 65 ;

	// Pour un entier signe
	printf("\n-%d- est un entier signe dont le min est: %d et le max est: %d\n",i,INT_MIN,INT_MAX) ;

	// pour un char signe
	printf("'%c' est un char non signe de valeur %d dont le min est: %d et le max est: %d\n",c ,c ,UCHAR_MIN,UCHAR_MAX) ;

    // pour un entier long
    printf("-%d- est un entier long dont le min est: %d et le max est: %d\n",l,LONG_MIN,LONG_MAX);

    // pour un nombre décimal flotant
	printf("-%.5f- est un nombre decimal flotant dont le min est: %d et le max est: %d\n",f,FLT_MIN,FLT_MAX);

    // pour un double
    printf("-%lf- est un nombre double dont le min est: %lf et le max est: %f\n",d,DBL_MIN,DBL_MAX);

	printf("\n");

}

// Fonction renvoie une valeur entiere positive
unsigned long computeFactoriel(int val)
{
// Declaration de variables
int i ;
unsigned long res ;


	// test si val est superieur a 1
	if (val > 1)
	{
		// initialisation de la variable
		res = 1L ;

		// boucle de calcul
		for ( i = 2 ; i <= val ; i += 1)
		{
			// calcul
			res *= i ;
		}
		// valeur de retour de la fonction
		return res ;
	}
	else
		// ici la valeur est inferieure ou egale a 1
	{
		// pas de calcul
		return -1 ;
	}
}

#define  INTREPOFFLOAT(f)   ( *(int*)&(f) )

void Float2Hex(float val)
{
    //val = 3.14159 ;
    printf("Val = %f -> %X\n", val,INTREPOFFLOAT(val) ) ;

}

int PGCD(int a, int b)
{
    int reste ;
    while( b > 0)
        {
        reste = a % b ;
        a =  b ;
        b = reste ;
        }
    return a ;
}

int mypow(int a,int b)
{
int p = a ;
    while( --b >= 1){
       p *= a ;
    }

return p ;
}
