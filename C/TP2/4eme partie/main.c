#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "my_tests.h"
#include "../TP documentation/src/seatest.c"
#include "../TP documentation/src/seatest.h"

void test_all(void);

int main()
{
    // 1. Fonction isdigit
    printf("TEST 1 : FONCTION isdigit (verifie si une chaine est un chiffre)\n");
    printf("    Est-ce que '1' est un chiffre ? Resultat (1: vrai / 0: faux) : %d\n", my_isdigit('1'));
    printf("    Est-ce que 'a' est un chiffre ? Resultat (1: vrai / 0: faux) : %d\n", my_isdigit('a'));


    // 2. Fonction tolower
    printf("\nTEST 2 : FONCTION toopper (utilise le code d'un caractere)\n");
    printf("    La lettre a (numero 97) donne la lettre numero %d\n", my_toupper('a'));
    printf("    Le caractere [ (numero 91) donne la lettre numero %d\n", my_toupper('['));
    printf("    Le chiffre 1 (numero 49) donne le chiffre numero %d\n", my_toupper('1'));

    // 3. Fonction strlen
    printf("\nTEST 3 : FONCTION strlen (donne la longueur d'une chaine)\n");
    printf("    La chaine 'Ceci est un test' fait %d caracteres\n", my_strlen("Ceci est un test"));

    // 4. Fonction strcpy
    printf("\nTEST 4 : FONCTION strcpy (permet de copier une chaine de caracteres [destination, source])\n");
    char var1[10] = "Test";
    char var2[10];
    my_strcpy(var2, var1);
    printf("    char var1[10] = \"Test\";\n    char var2[10];\n    my_strcopy(var2,var1);\n    La variable var2 vaut \"%s\"\n", var2);

    // 5. Fonction strcat et
    printf("\nTEST 5 : FONCTION strcat (assemble deux chaines de caracteres)\n");
    char var3[30] = "Ceci est ";
    char var4[30] = "un test...";
    my_strcat(var3,var4);
    printf("    char var3[15] = \"Ceci est \";\n    char var4[15] = \"un test...\";\n    Resultat de la fonction strcat stockee dans var3 : \"%s\"\n", var3);

    // 6. Fonction strcmp et strncmp (NON strncmpi, mathlab !)
    printf("\nTEST 6 : FONCTION strcmp et strncmp\n");
    char var5[15] = "Test premier";
    char var6[15] = "Test second";
    char var7[15] = "Test premier";
    printf("    char var5[15] = \"Test premier\";\n    char var6[15] = \"Test second\";\n    char var7[15] = \"Test premier\";\n");
    printf("    Resultat de la fonction my_strcmp avec avec var5 et var6 (0: identiques / nombre: diff. n. ASCII) : %d\n", my_strcmp(var5, var6));
    printf("    Resultat de la fonction my_strcmp avec avec var5 et var7 : %d\n", my_strcmp(var5, var7));

    printf("\nTEST 7 : FONCTION recherche de ponctuation \n");
    printf("    Est-ce que '!' est une ponctuation ? Resultat (1: vrai / 0: faux) : %d\n", my_ponctuation('?'));
    printf("    Est-ce que '?' est une ponctuation ? Resultat (1: vrai / 0: faux) : %d\n", my_ponctuation('!'));
    printf("    Est-ce que 'a' est une ponctuation ? Resultat (1: vrai / 0: faux) : %d\n", my_ponctuation('a'));
    printf("    Est-ce que '1' est une ponctuation ? Resultat (1: vrai / 0: faux) : %d\n", my_ponctuation('1'));

    printf("\n\n");

    run_test(test_all);
    return 0;
}

/* FONCTIONS "MAISON" DE TESTS SUR LES CHAINES DE CARACTERES
 * =========================================================
 */

/* Test si le caractere entre est un chiffre
 * @param n (int) : chaine de caractère d'entrée (si lettre, transformée en numero ascii)
 * @return bool : vrai si un chiffre, faux sinon
 **/
int my_isdigit(int n){
    if(n >= '0' && n <= '9'){
        return 1;
    }
    return 0;
}

/* Permet de récupérer le numéro ascii de la lettre majuscule associée
 * @param caractere (int) : chaine de caractère d'entree (si lettre, transformée en numéro ascii)
 * @return int : numero ascii
 **/
int my_toupper(int caractere){
    if((caractere >= '!' && caractere <= '`') || (caractere >= '{' && caractere <= '~')){
        return caractere;
    }
    return caractere - 32;
}

/* Permet de calculer la longueur d'une chaine de caracteres
 * @param chaine (char) : chaine de caractère d'entree
 * @return int : nombre de caracteres
 **/
int my_strlen(char chaine[]){
    int i = 0;
    while(chaine[i] != '\0'){
        i++;
    }
    return i;
}

/* Permet de mettre le contenu d'une variable dans une autre
 * @param variable (char) : variable dans laquelle on va mettre une valeur donnée
 * @param valeur (char) : contenu de la variable à passer
 * @return void
 **/
void my_strcpy(char variable[], char valeur[]){
    int i = 0;
    // Ecrase les anciens caractères pour les remplacer
    while(valeur[i] != '\0'){
        variable[i] = valeur[i];
        i++;
    }
    // Vide la fin de la variable initiale
    while(variable[i] != '\0'){
        variable[i] = '\0';
        i++;
    }
}


void my_strcat(char variable1[], char variable2[]){
    int i   = 0;
    int len = my_strlen(variable1);
    while(variable2[i] != '\0'){
        variable1[len + i] = variable2[i];
        i++;
    }
}

int my_strcmp(char variable1[], char variable2[]){
    int i = 0;

    while(variable1[i] == variable2[i] && variable1[i] && variable2[i]){
        i++;
    }
    // Si la comparaison est arrivée à la fin des deux chaînes à la fois, elles sont identiques
    if(variable1[i] == '\0' && variable2[i] == '\0'){
        return 0;
    }

    return (variable1[i] - variable2[i]);
}

int my_ponctuation(char caractere){
    int i = 0;
    char ponctuation[] = ".;:!?,-/'()[]";

    while(ponctuation[i] != '\0'){
        if(caractere == ponctuation[i]){
            return 1;
        }
        i++;
    }
    return 0;
}

/* FONCTIONS DE TESTS UNITAIRES SEATEST
 * ====================================
 */

void test_isdigit(void){
    assert_true(my_isdigit('1'));
    assert_true(my_isdigit('9'));
    assert_false(my_isdigit('a'));
    assert_false(my_isdigit('A'));
    assert_false(my_isdigit('#'));
    assert_false(my_isdigit('!'));
}

void test_tolower(void){
    assert_int_equal(65, my_toupper('a'));
    assert_int_equal(90, my_toupper('z'));
    assert_int_equal(71, my_toupper('g'));
    assert_int_equal(33, my_toupper('!'));
    assert_int_equal(49, my_toupper('1'));
}

void test_strlen(void){
    assert_int_equal(16, my_strlen("Ceci est un test"));
    assert_int_equal(50, my_strlen("Une tres tres grande chaine de caracteres a tester"));
    assert_int_equal(1, my_strlen("1"));
    assert_int_equal(0, my_strlen(""));
}

void test_strcopy(void){
    char var1[10] = "Test";
    char var2[10];
    my_strcpy(var2, var1);
    assert_string_equal("Test", var2);
}

void test_strcat(void){
    char var1[30] = "Ceci est ";
    char var2[30] = "un test...";
    strcat(var1, var2);
    assert_string_equal("Ceci est un test...", var1);
}

void test_strcmp(void){
    char var1[15] = "Test premier";
    char var2[15] = "Test second";
    char var3[15] = "Test premier";
    assert_false(my_strcmp(var1, var3));
    assert_true(my_strcmp(var1, var2) != 0);
}

void test_ponctuation(void){
    assert_true(my_ponctuation('.'));
    assert_true(my_ponctuation(';'));
    assert_true(my_ponctuation(':'));
    assert_true(my_ponctuation('!'));
    assert_true(my_ponctuation('?'));
    assert_true(my_ponctuation(','));
    assert_true(my_ponctuation('-'));
    assert_true(my_ponctuation('/'));
    assert_true(my_ponctuation('('));
    assert_true(my_ponctuation(')'));
    assert_true(my_ponctuation('['));
    assert_true(my_ponctuation(']'));
    assert_false(my_ponctuation('a'));
    assert_false(my_ponctuation('A'));
    assert_false(my_ponctuation('0'));
    assert_false(my_ponctuation('#'));
    assert_false(my_ponctuation('*'));
    assert_false(my_ponctuation(' '));
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_isdigit);
        run_test(test_tolower);
        run_test(test_strlen);
        run_test(test_strcopy);
        run_test(test_strcat);
        run_test(test_strcmp);
        run_test(test_ponctuation);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}
