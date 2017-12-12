/*====================================================================================
 * TP de C n°6 : Listes chaînées
 *
 * Auteurs : Grégoire Gaonach et Alexandre Leyer
 *
 * ISEN LILLE - Promo 60 - CSI3 - 7 décembre 2016
 *==================================================================================*/

// Système
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <stdbool.h>
// Tests unitaires
#include "seatest.h"
#include "seatest.c"
// Inclusion des fichiers du projet
#include "header.h"
#include "fonctionsBasiques.c"
#include "fonctionsManipulation.c"
#include "fonctionsAvancees.c"
#include "bonus.c"
#include "tests.c"

int main(){

    printf("======================== CREATION D'UNE LISTE ========================\n");

    Ancre *listeChainee = creationListe();
    affichageListe(listeChainee);

    printf("\n========================== AJOUT D'ELEMENTS ==========================\n");

    insertionElement(listeChainee, creationElement(4), 0);
    insertionElement(listeChainee, creationElement(-2), -1);
    insertionElement(listeChainee, creationElement(0), 1);
    insertionElement(listeChainee, creationElement(25000), -1);
    insertionElement(listeChainee, creationElement(42), 3);
    affichageListe(listeChainee);

    printf("\n========================= ECHANGE D'ELEMENTS =========================\n");

    echangeNoeuds(listeChainee, 2, 4);
    affichageListe(listeChainee);

    printf("\n======================= REMPLACEMENT D'ELEMENTS ======================\n");

    remplaceNoeud(listeChainee, creationElement(69), 3);
    affichageListe(listeChainee);

    printf("\n======================= SUPPRESSION D'ELEMENTS =======================\n");

    suppressionElement(listeChainee, 1, false);
    affichageListe(listeChainee);

    printf("\n==================== CONCATENATION DE DEUX LISTES ====================\n");

    printf("SECONDE LISTE :");
    Ancre *listeChainee2 = creationListe();
    insertionElement(listeChainee2, creationElement(1), 0);
    insertionElement(listeChainee2, creationElement(2), -1);
    insertionElement(listeChainee2, creationElement(3), -1);
    insertionElement(listeChainee2, creationElement(5), -1);
    insertionElement(listeChainee2, creationElement(8), -1);
    insertionElement(listeChainee2, creationElement(13), -1);
    affichageListe(listeChainee2);

    printf("\nLES DEUX LISTES ASSEMBLEES :");
    concatenationListe(listeChainee, listeChainee2);
    affichageListe(listeChainee);

    printf("\n========================== RECHERCHE ELEMENT =========================\n");

    printf("\nRecherche de '3' dans la liste concatenee, resultat en position %d\n", rechercheElement(listeChainee, 3));
    printf("\nRecherche de '13' dans la liste concatenee, resultat en position %d\n", rechercheElement(listeChainee, 13));
    printf("\nRecherche de '4' dans la liste concatenee, resultat en position %d\n", rechercheElement(listeChainee, 4));

    printf("\n=========================== VIDER UNE LISTE ==========================\n");

    viderListe(listeChainee);
    affichageListe(listeChainee);

    printf("\n========================= SUPPRIMER DOUBLONS =========================\n");

    insertionElement(listeChainee, creationElement(2), 0);
    insertionElement(listeChainee, creationElement(3), -1);
    insertionElement(listeChainee, creationElement(5), -1);
    insertionElement(listeChainee, creationElement(3), -1);
    insertionElement(listeChainee, creationElement(13), -1);
    insertionElement(listeChainee, creationElement(13), -1);
    insertionElement(listeChainee, creationElement(0), -1);
    insertionElement(listeChainee, creationElement(2), -1);
    insertionElement(listeChainee, creationElement(42), -1);
    printf("AVANT SUPPRESSION DES DOUBLONS :");
    affichageListe(listeChainee);

    listeChainee2 = cloneSansDoublons(listeChainee);
    printf("\nAPRES SUPPRESSION :");
    affichageListe(listeChainee2);

    printf("\n=========================== UNION DE LISTES ==========================\n");

    viderListe(listeChainee);
    insertionElement(listeChainee, creationElement(1), 0);
    insertionElement(listeChainee, creationElement(2), -1);
    insertionElement(listeChainee, creationElement(3), -1);
    affichageListe(listeChainee);
    viderListe(listeChainee2);
    insertionElement(listeChainee2, creationElement(2), 0);
    insertionElement(listeChainee2, creationElement(3), -1);
    insertionElement(listeChainee2, creationElement(4), -1);
    affichageListe(listeChainee2);

    printf("\nUNION DES DEUX LISTES PRECEDENTES :");
    listeChainee = unionListes(listeChainee, listeChainee2);
    affichageListe(listeChainee);

    printf("\n======================== INTERSECTION DE LISTES ======================\n");

    viderListe(listeChainee);
    insertionElement(listeChainee, creationElement(1), 0);
    insertionElement(listeChainee, creationElement(2), -1);
    insertionElement(listeChainee, creationElement(3), -1);
    insertionElement(listeChainee, creationElement(4), -1);
    affichageListe(listeChainee);
    viderListe(listeChainee2);
    insertionElement(listeChainee2, creationElement(2), 0);
    insertionElement(listeChainee2, creationElement(3), -1);
    insertionElement(listeChainee2, creationElement(4), -1);
    insertionElement(listeChainee2, creationElement(5), -1);
    affichageListe(listeChainee2);

    printf("\nINTERSECTION DES DEUX LISTES PRECEDENTES :");
    listeChainee = intersectionListes(listeChainee, listeChainee2);
    affichageListe(listeChainee);


    printf("\n============================ TEST SUR LISTE ==========================\n");

    viderListe(listeChainee);
    insertionElement(listeChainee, creationElement(1), 0);
    insertionElement(listeChainee, creationElement(2), -1);
    insertionElement(listeChainee, creationElement(3), -1);
    insertionElement(listeChainee, creationElement(4), -1);
    insertionElement(listeChainee, creationElement(5), -1);
    insertionElement(listeChainee, creationElement(6), -1);
    insertionElement(listeChainee, creationElement(7), -1);
    affichageListe(listeChainee);

    printf("\nAPRES PASSAGE DU TEST SUR LA LISTE (test si impair) :");
    listeChainee = testSurListe(listeChainee, fonctionTest);
    affichageListe(listeChainee);

    printf("\n===================== RESULTAT DES TESTS UNITAIRE ==================\n\n");

    run_test(test_all);

    printf("================================= FIN ================================\n");

    return 0;
}

