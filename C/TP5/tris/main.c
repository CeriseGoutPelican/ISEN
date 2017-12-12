#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include "header.h"
// Inclusion des fichiers de tests unitaires
#include "../../TP2/TP documentation/src/seatest.h"
#include "../../TP2/TP documentation/src/seatest.c"
#include "testsUnitaires.c"
// Inclusion des différentes parties
#include "partie1.c"
#include "partie2.c"
#include "partie3.c"
#include "autres.c"

int main()
{
    float liste[] = {44, 0, 100, -10, -10.5, 0, 10};
    printf("============= TRI A BULLE ============\n");
    afficheListe(liste, 7);
    triABulles(liste, 7);
    afficheListe(liste, 7);

    float liste2[] = {44, 0, 100, -10, -10.5, 0, 10};
    printf("\n====== TRI INSERTION SEQUENTIEL =======\n");
    afficheListe(liste2, 7);
    triInsertion(liste2, 7);
    afficheListe(liste2, 7);

    float liste3[] = {44, 0, 100, -10, -10.5, 0, 10};
    printf("\n===== TRI INSERTION DICHOTOMIQUE ======\n");
    afficheListe(liste3, 7);
    triInsertionDichotomique(liste3, 7, false);
    afficheListe(liste3, 7);

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    printf("\n= TRI INSERTION DICHOTOMIQUE RECURSIF =\n");
    afficheListe(liste4, 7);
    triInsertionDichotomique(liste4, 7, true);
    afficheListe(liste4, 7);

    float liste5[] = {44, 0, 100, -10, -10.5, 0, 10};
    printf("\n============= TRI RAPIDE ==============\n");
    afficheListe(liste5, 7);
    triRapide(liste5, 0, 6);
    afficheListe(liste5, 7);

    int liste7[] = {5, 7, 4, 2, 1, 8, 9, 3, 6};
    printf("\n========== TRI PAIRS/IMPAIRS ==========\n");
    afficheListeInt(liste7, 9);
    qsort(liste7, 9, sizeof(int), comparaisonPairsImpairs);
    afficheListeInt(liste7, 9);

    printf("\n\n\n");
    run_test(test_all);
    return 0;
}
