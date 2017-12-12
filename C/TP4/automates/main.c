#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include "../../TP2/TP documentation/src/seatest.h"
#include "../../TP2/TP documentation/src/seatest.c"
#include "header.h"

float globalValeurSeatest; // Simplement utilisé de manière passive pour les tests unitaires seatests

int main()
{
    run_test(test_all);
    return 0;
}

/*************************************************
 * FONCTIONS DE LA 1ERE PARTIE DU TP             *
 *************************************************/

/* Function : initMatrice
 * ----------------------
 * Permet de créer une matrice dynamiquement de taille lignes x colonnes
 *
 * lignes : nombre de lignes du tableau
 * colonnes : nombre de colonnes du tableau
 *
 * returns : une matrice dynamique
 */
int** initMatrice(int lignes, int colonnes){
    int i;
    // 1. Allocation dynamique de la matrice des états de transition pour l'automate
    int** matrice = (int**) malloc(lignes * sizeof(int*)); // Alloue la mémoire vers 4 pointeurs qui dirigent vers les int des colonnes

    for(i = 0; i < lignes; i++){
        matrice[i] = (int*) malloc(colonnes * sizeof(int));
    }

    return matrice;
}

/* Function : nouvelEtat
 * ---------------------
 * Permet de lire la matrice de transition de l'automate à états finis afin
 * de déterminer l'étape suivante ou la condition d'arrêt (ERRORCODE)
 *
 * matrice : matrice de transition contenant les prochains états
 * element : élément passé de la chaîne à analyser
 * etat : état actuel dans l'automate
 *
 * returns : le prochain état de l'automate ou alors une erreur
 */
int nouvelEtat(int** matrice, char element, int etat){
    if (estChiffre(element))
        return matrice[etat][1];
    if (estSigne(element))
        return matrice[etat][0];
    if (estSeparateur(element))
        return matrice[etat][2];
    if (estExposant(element))
        return matrice[etat][3];
    return ERRORCODE;
}

/* Function : estDecimal
 * ---------------------
 * Permet de vérifier si un nombre est décimal grâce à un automate à état fini
 *
 * chaine : chaine de caractere à tester
 * taille : taille de la chaine de caractères
 *
 * returns : vrai si c'est une chaine, faux sinon
 */
bool estDecimal(char chaine[], int taille){
    int etat = 0;
    int prochainEtat = 0;
    int i;
    int** matriceTransition = initMatrice(5, 3);
    // Pointeurs pour la fonction charToDecimal
    int signe   = 1;
    int *pSigne = &signe;
    float valeur  = 0;
    float *pValeur = &valeur;
    int positionDecimal = 1;
    int *pPositionDecimal = &positionDecimal;
    int** matriceAction = initMatriceAction(5, 3);

    // Remplissage de la matrice avec les éléments des états de transition
    matriceTransition[0][0] = 1;
    matriceTransition[0][1] = 2;
    matriceTransition[0][2] = ERRORCODE;
    matriceTransition[1][0] = ERRORCODE;
    matriceTransition[1][1] = 2;
    matriceTransition[1][2] = ERRORCODE;
    matriceTransition[2][0] = ERRORCODE;
    matriceTransition[2][1] = 2;
    matriceTransition[2][2] = 3;
    matriceTransition[3][0] = ERRORCODE;
    matriceTransition[3][1] = 4;
    matriceTransition[3][2] = ERRORCODE;
    matriceTransition[4][0] = ERRORCODE;
    matriceTransition[4][1] = 4;
    matriceTransition[4][2] = ERRORCODE;

    for(i = 0; i < taille; i++){
        prochainEtat = nouvelEtat(matriceTransition, chaine[i], etat);
        if(prochainEtat == ERRORCODE)
            return false;
        charToDecimalAction(matriceAction, etat, chaine[i], pSigne, pValeur, pPositionDecimal);
        etat = prochainEtat;
    }

    // Mets à jour le nombre décimal porté par pValeur avec le signe
    (*pValeur) *= (*pSigne);
    globalValeurSeatest = *pValeur;

    free(matriceTransition);
    return (etat == 2 || etat == 4);
}

/* Function : estChiffre
 * ---------------------
 * Vérifie si le caractere entré est un chiffre
 *
 * chaine : chaine de caractère d'entrée (si lettre, transformée en numero ascii)
 *
 * return : vrai si un chiffre, faux sinon
 **/
bool estChiffre(int chaine){
    if(chaine >= '0' && chaine <= '9'){
        return true;
    }
    return false;
}

/* Function : estSigne
 * ---------------------
 * Vérifie si le caractere entré est un signe (- ou +)
 *
 * chaine : chaine de caractère d'entrée
 *
 * return : vrai si un signe, faux sinon
 **/
bool estSigne(char chaine){
    if(chaine == '-' || chaine == '+'){
        return true;
    }
    return false;
}

/* Function : estSeparateur
 * ---------------------
 * Vérifie si le caractere entré est un séparateur (. ou ,)
 *
 * chaine : chaine de caractère d'entrée
 *
 * return : vrai si un séparateur, faux sinon
 **/
bool estSeparateur(char chaine){
    if(chaine == '.' || chaine == ','){
        return true;
    }
    return false;
}

/* Function : estExosant
 * ---------------------
 * Vérifie si le caractere entré est un exposant (e ou E)
 *
 * chaine : chaine de caractère d'entrée
 *
 * return : vrai si un exposant, faux sinon
 **/
bool estExposant(char chaine){
    if(chaine == 'e' || chaine == 'E'){
        return true;
    }
    return false;
}





/*************************************************
 * FONCTIONS DE LA 2ND PARTIE DU TP              *
 *************************************************/

/* Function : charToDecimal
 * ------------------------
 * Transforme une chaine de caractère en entier (arrêt à un séparateur)
 * Ainsi pour avoir un flotant stocké dans une chaine, il faut récupérer la
 * partie entière puis la partie décimale avant de les assembler.
 *
 * chaine : chaine de caractere à tester
 * taille : taille de la chaine de caractères
 * decimal : si vrai, retourne la valeur décilame de la chaine, sinon, la partie entière
 *
 * returns : l'entier correspondant
 */
int charToDecimal(char chaine[], int taille, bool decimal){
    int i = 0;
    int resultat;
    int premierCaractere = 0;
    bool arret = false;

    // On avance le curseur de 1 s'il y a un bit de signe
    if(estSigne(chaine[0]) && decimal == false)
        premierCaractere++;

    // Si l'utilisateur demande à récupérer la partie décimale, on place le curseur plus loin
    if(decimal){
        while(estSeparateur(chaine[i]) == false && chaine[i] != '\0')
            i++;
        premierCaractere += i+1;
    }

    i = 1 + premierCaractere;
    resultat = chaine[premierCaractere] - '0'; // Permet de transformer un caractère en chiffre

    while(arret == false){
        resultat = resultat * 10 + (chaine[i] - '0');
        i++;
        // Vérification du caractère suivant :
        if(estSeparateur(chaine[i]) || chaine[i] == '\0')
            arret = true;
    }
    return resultat;
}

/* Function : initMatriceAction
 * ----------------------------
 * Permet de remplir directement la matrice d'action associée à l'automate
 * à état fini de estDecimal
 *
 * returns : la matrice d'action associée
 */
int** initMatriceAction(){
    int** matriceAction = initMatrice(5, 3);

    // Remplissage de la matrice avec les éléments des états de transition
    matriceAction[0][0] = 1;
    matriceAction[0][1] = 2;
    matriceAction[0][2] = 0;
    matriceAction[1][0] = 0;
    matriceAction[1][1] = 2;
    matriceAction[1][2] = 0;
    matriceAction[2][0] = 0;
    matriceAction[2][1] = 2;
    matriceAction[2][2] = 0;
    matriceAction[3][0] = 0;
    matriceAction[3][1] = 3;
    matriceAction[3][2] = 0;
    matriceAction[4][0] = 0;
    matriceAction[4][1] = 3;
    matriceAction[4][2] = 0;

    return matriceAction;
}

/* Function : charToDecimalAction
 * ------------------------------
 * Créer le nombre flotant associé au tableau testé dans la machine à état fini estDecimal
 * au fur et à mesure des tests à l'aide de pointeurs
 *
 * matriceAction : matrice d'action associée donnant le type de l'élément testé
 * element : élément passé de la chaîne à transformer
 * etat : état actuel dans l'automate
 * (pointeur) pSigne : contient le signe du float
 * (pointeur) pValeur : contient le float construit au fur et à mesure
 * (pointeur) pPositionDecimale : contient la position du curseur pour la construction de la partie décimale (puissance de 10)
 *
 * returns : l'entier correspondant
 */
int charToDecimalAction(int **matriceAction, int etat, char element, int* pSigne, float* pValeur, int* pPositionDecimale){
    int prochainEtat = nouvelEtat(matriceAction, element, etat);

    // Si le premier caractere est un signe, on stocke l'information dans le pointeur correspondant
    if (prochainEtat == 1){
        if(element == '-'){
            *pSigne = -1;
        }
    }

    // Si l'on se trouve dans la partie entière
    if (prochainEtat == 2){
        *pValeur = *pValeur * 10 + (element - '0');
    }

    // Si l'on se trouve dans la partie décimale
    if (prochainEtat == 3){
        (*pValeur) += (element - '0') / pow(10, *pPositionDecimale);
        (*pPositionDecimale)++;
    }

    return 0;
}






/*************************************************
 * FONCTIONS DE LA 3EME PARTIE DU TP             *
 *************************************************/

/* Function : estDecimalExposant
 * -----------------------------
 * Permet de vérifier si un nombre est décimal grâce à un automate à état fini
 *
 * chaine : chaine de caractere à tester
 * taille : taille de la chaine de caractères
 *
 * returns : vrai si c'est un décimal avec exposant, faux sinon
 */
bool estDecimalExposant(char chaine[], int taille){
    int etat = 0;
    int prochainEtat = 0;
    int i;
    int** matriceTransition = initMatrice(8, 4);
    // Pointeurs pour la fonction charToDecimal
    int signe             = 1;
    int *pSigne           = &signe;
    float valeur          = 0;
    float *pValeur        = &valeur;
    int positionDecimal   = 1;
    int *pPositionDecimal = &positionDecimal;
    int signeExposant     = 1;
    int *pSigneExposant   = &signeExposant;
    int exposant          = 0;
    int *pExposant        = &exposant;
    int **matriceAction   = initMatriceActionExposant(8, 4);

    // Remplissage de la matrice avec les éléments des états de transition
    matriceTransition[0][0] = 1;
    matriceTransition[0][1] = 2;
    matriceTransition[0][2] = ERRORCODE;
    matriceTransition[0][4] = ERRORCODE;
    matriceTransition[1][0] = ERRORCODE;
    matriceTransition[1][1] = 2;
    matriceTransition[1][2] = ERRORCODE;
    matriceTransition[1][3] = ERRORCODE;
    matriceTransition[2][0] = ERRORCODE;
    matriceTransition[2][1] = 2;
    matriceTransition[2][2] = 3;
    matriceTransition[2][3] = 5;
    matriceTransition[3][0] = ERRORCODE;
    matriceTransition[3][1] = 4;
    matriceTransition[3][2] = ERRORCODE;
    matriceTransition[3][3] = ERRORCODE;
    matriceTransition[4][0] = ERRORCODE;
    matriceTransition[4][1] = 4;
    matriceTransition[4][2] = ERRORCODE;
    matriceTransition[4][3] = 5;
    matriceTransition[5][0] = 6;
    matriceTransition[5][1] = 7;
    matriceTransition[5][2] = ERRORCODE;
    matriceTransition[5][3] = ERRORCODE;
    matriceTransition[6][0] = ERRORCODE;
    matriceTransition[6][1] = 7;
    matriceTransition[6][2] = ERRORCODE;
    matriceTransition[6][3] = ERRORCODE;
    matriceTransition[7][0] = ERRORCODE;
    matriceTransition[7][1] = 7;
    matriceTransition[7][2] = ERRORCODE;
    matriceTransition[7][3] = ERRORCODE;

    for(i = 0; i < taille; i++){
        prochainEtat = nouvelEtat(matriceTransition, chaine[i], etat);
        if(prochainEtat == ERRORCODE)
            return false;
        expToDecimalAction(matriceAction, etat, chaine[i], pSigne, pValeur, pPositionDecimal, pSigneExposant, pExposant);
        etat = prochainEtat;
    }

    // Mets à jour le nombre décimal porté par pValeur avec le signe
    (*pValeur) *= (*pSigne);
    (*pValeur) *= pow(10, (*pSigneExposant) * (*pExposant));
    globalValeurSeatest = *pValeur;

    free(matriceTransition);
    return (etat == 2 || etat == 4 || etat == 7);
}

/* Function : initMatriceActionExposant
 * ------------------------------------
 * Permet de remplir directement la matrice d'action associée à l'automate
 * à état fini de estDecimalExposant
 *
 * returns : la matrice d'action associée
 */
int** initMatriceActionExposant(){
    int** matriceAction = initMatrice(8, 4);

    // Remplissage de la matrice avec les éléments des états de transition
    matriceAction[0][0] = 1; // ETAT 0
    matriceAction[0][1] = 2;
    matriceAction[0][2] = 0;
    matriceAction[0][4] = 0;
    matriceAction[1][0] = 0; // ETAT 1
    matriceAction[1][1] = 2;
    matriceAction[1][2] = 0;
    matriceAction[1][3] = 0;
    matriceAction[2][0] = 0; // ETAT 2
    matriceAction[2][1] = 2;
    matriceAction[2][2] = 0;
    matriceAction[2][3] = 0;
    matriceAction[3][0] = 0; // ETAT 3
    matriceAction[3][1] = 3;
    matriceAction[3][2] = 0;
    matriceAction[3][3] = 0;
    matriceAction[4][0] = 0; // ETAT 4
    matriceAction[4][1] = 3;
    matriceAction[4][2] = 0;
    matriceAction[4][3] = 0;
    matriceAction[5][0] = 4; // ETAT 5
    matriceAction[5][1] = 5;
    matriceAction[5][2] = 0;
    matriceAction[5][3] = 0;
    matriceAction[6][0] = 0; // ETAT 6
    matriceAction[6][1] = 5;
    matriceAction[6][2] = 0;
    matriceAction[6][3] = 0;
    matriceAction[7][0] = 0; // ETAT 7
    matriceAction[7][1] = 5;
    matriceAction[7][2] = 0;
    matriceAction[7][3] = 0;

    return matriceAction;
}

/* Function : expToDecimalAction
 * -----------------------------
 * Créer le nombre flotant associé au tableau testé dans la machine à état fini estDecimalExposant
 * au fur et à mesure des tests à l'aide de pointeurs
 *
 * matriceAction : matrice d'action associée donnant le type de l'élément testé
 * element : élément passé de la chaîne à transformer
 * etat : état actuel dans l'automate
 * (pointeur) pSigne : contient le signe du float
 * (pointeur) pValeur : contient le float construit au fur et à mesure
 * (pointeur) pPositionDecimale : contient la position du curseur pour la construction de la partie décimale (puissance de 10)
 * (pointeur) pSigneExposant : contient le signe de l'exposant
 * (pointeur) pExposant : contient l'exposant complet
 *
 * returns : l'entier correspondant
 */
int expToDecimalAction(int **matriceAction, int etat, char element, int* pSigne, float* pValeur, int* pPositionDecimale, int* pSigneExposant, int* pExposant){
    int prochainEtat = nouvelEtat(matriceAction, element, etat);

    // Si le premier caractere est un signe, on stocke l'information dans le pointeur correspondant
    if(prochainEtat == 1){
        if(element == '-'){
            *pSigne = -1;
        }
    }

    // Si l'on se trouve dans la partie entière
    if (prochainEtat == 2){
        *pValeur = *pValeur * 10 + (element - '0');
    }

    // Si l'on se trouve dans la partie décimale
    if (prochainEtat == 3){
        (*pValeur) += (element - '0') / pow(10, *pPositionDecimale);
        (*pPositionDecimale)++;
    }

    // Si l'on se trouve dans la partie exposant :
    // on note le type d'opération (exposant négatif division)
    if (prochainEtat == 4){
        if(element == '-'){
            *pSigneExposant = -1;
        }
    }

    // Si l'on se trouve dans la partie exposant :
    if (prochainEtat == 5){
        *pExposant = *pExposant * 10 + (element - '0');
    }

    return 0;
}





/*************************************************
 * TESTS UNITAIRES AVEC SEATESTS                 *
 *************************************************/

void test_isDigital(void){
    char chaine[] = "45";
    assert_int_equal(estDecimal(chaine, 2), 1);
    assert_float_equal(45, globalValeurSeatest, 0);

    strcpy(chaine, "-45");
    assert_int_equal(estDecimal(chaine, 3), 1);
    assert_float_equal(-45, globalValeurSeatest, 0);

    strcpy(chaine, "-0.002");
    assert_int_equal(estDecimal(chaine, 6), 1);
    assert_float_equal(-0.002, globalValeurSeatest, 0);

    strcpy(chaine, "+15");
    assert_int_equal(estDecimal(chaine, 3), 1);
    assert_float_equal(15, globalValeurSeatest, 0);

    strcpy(chaine, "17.007");
    assert_int_equal(estDecimal(chaine, 6), 1);
    assert_float_equal(17.007, globalValeurSeatest, 0);

    strcpy(chaine, ".0+002");
    assert_int_equal(estDecimal(chaine, 6), 0);

    strcpy(chaine, "0.2.2");
    assert_int_equal(estDecimal(chaine, 5), 0);

    strcpy(chaine, "45b");
    assert_int_equal(estDecimal(chaine, 3), 0);

    strcpy(chaine, "+.005");
    assert_int_equal(estDecimal(chaine, 5), 0);

    strcpy(chaine, "-59.");
    assert_int_equal(estDecimal(chaine, 4), 0);
    assert_float_equal(-59, globalValeurSeatest, 0);
}
void test_charToDecimal(void){
    char chaine[] = "45.33";
    assert_int_equal(charToDecimal(chaine, 5, false), 45);
    assert_int_equal(charToDecimal(chaine, 5, true), 33);
    strcpy(chaine, "-23.948201");
    assert_int_equal(charToDecimal(chaine, 10, false), 23);
    assert_int_equal(charToDecimal(chaine, 10, true), 948201);
}
void test_isDigitalExposant(void){
    char chaine[] = "45E3";
    assert_int_equal(estDecimalExposant(chaine, 4), 1);
    assert_float_equal(45000, globalValeurSeatest, 0);

    strcpy(chaine, "-45E3");
    assert_int_equal(estDecimalExposant(chaine, 5), 1);
    assert_float_equal(-45000, globalValeurSeatest, 0);

    strcpy(chaine, "-45E-3");
    assert_int_equal(estDecimalExposant(chaine, 6), 1);
    assert_float_equal(-0.045, globalValeurSeatest, 0);

    strcpy(chaine, "45E-3");
    assert_int_equal(estDecimalExposant(chaine, 5), 1);
    assert_float_equal(0.045, globalValeurSeatest, 0);

    strcpy(chaine, "45E+3");
    assert_int_equal(estDecimalExposant(chaine, 5), 1);
    assert_float_equal(45000, globalValeurSeatest, 0);

    strcpy(chaine, "4b5E+3");
    assert_int_equal(estDecimalExposant(chaine, 6), 0);

    strcpy(chaine, "45.2E1");
    assert_int_equal(estDecimalExposant(chaine, 6), 1);
    assert_float_equal(452, globalValeurSeatest, 0);

    strcpy(chaine, "-45.2E-2");
    assert_int_equal(estDecimalExposant(chaine, 8), 1);
    assert_float_equal(-0.452, globalValeurSeatest, 0.000001);
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_isDigital);
        run_test(test_charToDecimal);
        run_test(test_isDigitalExposant);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}

