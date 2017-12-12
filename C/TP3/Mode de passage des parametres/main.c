#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../../TP2/TP documentation/src/seatest.h"
#include "../../TP2/TP documentation/src/seatest.c"
#include "header.h"

int main()
{
    run_test(test_all);
    return 0;
}

/* Permet de récupérer le minimum d'un tableau d'entiers
 */
int minimum_tableau(int tableau[], int taille_tableau){

    int minimum = tableau[0];
    int i       = 1;

    // On parcourt le tableau dans le sens croissant
    for(i = 1; i <= taille_tableau - 1; i++){
        if(tableau[i] <= minimum){
            minimum = tableau[i];
        }
    }

    return minimum;

}

/* Permet de récupérer le minimum d'un tableau d'entiers
 */
void statistiques_tableau(int tableau[], int taille_tableau, int* minimum, int* maximum, float* moyenne, float* ecartType){

    *minimum   = tableau[0];
    *maximum   = tableau[0];
    *moyenne   = 0;
    *ecartType = 0;
    int i          = 1;

    // On parcourt le tableau dans le sens croissant
    for(i = 0; i < taille_tableau; i++){
        if(tableau[i] <= *minimum){
            *minimum = tableau[i];
        }
        if(tableau[i] >= *maximum){
            *maximum = tableau[i];
        }
        *moyenne += tableau[i];
    }

    *moyenne /= taille_tableau;

    for(i = 0; i <= taille_tableau - 1; i++){
        *ecartType += (tableau[i] - *moyenne)*(tableau[i] - *moyenne);
    }

    *ecartType /= taille_tableau;
    *ecartType = sqrt(*ecartType);

}

/* Permet de récupérer le minimum d'un tableau d'entiers
 */
void statistiques_tableau_struct(int tableau[], int taille_tableau, struct Statistiques *stats){

    stats->minimum   = tableau[0];
    stats->maximum   = tableau[0];
    stats->moyenne   = 0;
    stats->ecartType = 0;
    int i           = 1;

    // On parcourt le tableau dans le sens croissant
    for(i = 0; i < taille_tableau; i++){
        if(tableau[i] <= stats->minimum){
            stats->minimum = tableau[i];
        }
        if(tableau[i] >= stats->maximum){
            stats->maximum = tableau[i];
        }
        stats->moyenne += tableau[i];
    }

    stats->moyenne /= taille_tableau;

    for(i = 0; i <= taille_tableau - 1; i++){
        stats->ecartType += (tableau[i] - stats->moyenne)*(tableau[i] - stats->moyenne);
    }

    stats->ecartType /= taille_tableau;
    stats->ecartType = sqrt(stats->ecartType);

}

/*********************************
 * TESTS UNITAIRES AVEC SEATESTS *
 *********************************/

void test_minimum(void){
    int tableau1[] = {1,2,3,4,5,6};
    assert_int_equal(minimum_tableau(tableau1, 6), 1);
    int tableau2[] = {-10, 3, 0, 100, -123};
    assert_int_equal(minimum_tableau(tableau2, 5), -123);
    int tableau3[] = {73,0,49,0,0,0,3,-0};
    assert_int_equal(minimum_tableau(tableau3, 8), 0);
    int tableau4[] = {19093};
    assert_int_equal(minimum_tableau(tableau4, 1), 19093);
}

void test_minMaxMoyEtype(void){
    int tableau1[] = {1,2,3,4,5,6};
    int minimum, maximum;
    float moyenne, ecartType;
    statistiques_tableau(tableau1, 6, &minimum, &maximum, &moyenne, &ecartType);
    assert_int_equal(minimum, 1);
    assert_int_equal(maximum, 6);
    assert_float_equal(moyenne, 3.5, 2);
    assert_float_equal(ecartType, 1.70880075, 11);
    int tableau2[] = {-10, 3, 0, 100, -123};
    statistiques_tableau(tableau2, 5, &minimum, &maximum, &moyenne, &ecartType);
    assert_int_equal(minimum, -123);
    assert_int_equal(maximum, 100);
    assert_float_equal(moyenne, -6, 2);
    assert_float_equal(ecartType, 70.79265499, 11);
}

void test_minMaxMoyEtypeStruct(void){
    int tableau1[] = {1,2,3,4,5,6};
    struct Statistiques stats;
    statistiques_tableau_struct(tableau1, 6, &stats);
    assert_int_equal(stats.minimum, 1);
    assert_int_equal(stats.maximum, 6);
    assert_float_equal(stats.moyenne, 3.5, 2);
    assert_float_equal(stats.ecartType, 1.70880075, 11);
    int tableau2[] = {-10, 3, 0, 100, -123};
    statistiques_tableau_struct(tableau2, 5, &stats);
    assert_int_equal(stats.minimum, -123);
    assert_int_equal(stats.maximum, 100);
    assert_float_equal(stats.moyenne, -6, 2);
    assert_float_equal(stats.   ecartType, 70.79265499, 11);
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_minimum);
        run_test(test_minMaxMoyEtype);
        run_test(test_minMaxMoyEtypeStruct);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}
