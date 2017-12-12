#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "../TP documentation/src/seatest.c"
#include "../TP documentation/src/seatest.h"

void test_all(void);

int main()
{
    // 1. Fonction isdigit
    printf("TEST 1 : FONCTION isdigit (verifie si une chaine est un chiffre)\n");
    printf("    Est-ce que '1' est un chiffre ? Resultat (1: vrai / 0: faux) : %d\n", isdigit('1'));
    printf("    Est-ce que 'a' est un chiffre ? Resultat (1: vrai / 0: faux) : %d\n", isdigit('a'));


    // 2. Fonction tolower
    printf("\nTEST 2 : FONCTION tolower (utilise le code d'un caractere)\n");
    printf("    La lettre A (numero 65) donne la lettre numero %d\n", tolower('A'));
    printf("    Le chiffre 1 (numero 49) donne le chiffre numero %d\n", tolower('1'));

    // 3. Fonction strlen
    printf("\nTEST 3 : FONCTION strlen (donne la longueur d'une chaine)\n");
    printf("    La chaine 'Ceci est un test' fait %d caracteres\n", strlen("Ceci est un test"));

    // 4. Fonction strcpy
    printf("\nTEST 4 : FONCTION strcpy (permet de copier une chaine de caracteres [destination, source])\n");
    char var1[10] = "Test";
    char var2[10];
    printf("    char var1[10] = \"Test\";\n    char var2[10];\n    strcopy(var2,var1);\n    La variable var2 vaut \"%s\"\n", strcpy(var2, var1));

    // 5. Fonction strcat et strncat
    printf("\nTEST 5 : FONCTION strcat et strncat (assemble deux chaines de caracteres, la 2nd retire les n derniers caracteres)\n");
    char var3[15] = "Ceci est ";
    char var4[15] = "un test...";
    printf("    char var3[15] = \"Ceci est \";\n    char var4[15] = \"un test...\";\n    Resultat de la fonction strcat stockee dans var3 : \"%s\"\n", strcat(var3,var4));
    strcpy(var3, "Ceci est ");
    printf("    Resultat de la fonction strncat avec n = 5 : \"%s\"\n", strncat(var3,var4, 5));

    // 6. Fonction strcmp et strncmp (NON strncmpi, mathlab !)
    printf("\nTEST 6 : FONCTION strcmp et strncmp (compare deux chaines de caracteres, la 2nd compare les n premiers caracteres)\n");
    char var5[15] = "Test premier";
    char var6[15] = "Test second";
    char var7[15] = "Test premier";
    printf("    char var5[15] = \"Test premier\";\n    char var6[15] = \"Test second\";\n    char var7[15] = \"Test premier\";\n");
    printf("    Resultat de la fonction strcmp avec avec var5 et var6 (0: identiques / nombre: diff. n. ASCII) : %d\n", strcmp(var5, var6));
    printf("    Resultat de la fonction strcmp avec avec var5 et var7 : %d\n", strcmp(var5, var7));
    printf("    Resultat de la fonction strncmp avec avec var5 et var6 (n = 2) : %d\n", strncmp(var5, var6, 5));
    printf("    Resultat de la fonction strncmp avec avec var5 et var6 (n = 10) : %d\n", strncmp(var5, var6, 6));

    printf("\n\n");

    run_test(test_all);
    return 0;
}


void test_isdigit(void){
    assert_true(isdigit('1'));
    assert_false(isdigit('a'));
}

void test_tolower(void){
    assert_int_equal(97, tolower('A'));
    assert_int_equal(49, tolower('1'));
}

void test_strlen(void){
    assert_int_equal(16, strlen("Ceci est un test"));
}

void test_strcopy(void){
    char var1[10] = "Test";
    char var2[10];
    strcpy(var2, var1);
    assert_string_equal("Test", var2);
}

void test_strcat(void){
    char var1[15] = "Ceci est ";
    char var2[15] = "un test...";
    assert_string_equal("Ceci est un test...", strcat(var1, var2));
    strcpy(var1, "Ceci est ");
    assert_string_equal("Ceci est un te", strncat(var1, var2, 5));
}

void test_strcmp(void){
    char var1[15] = "Test premier";
    char var2[15] = "Test second";
    char var3[15] = "Test premier";
    assert_int_equal(strcmp(var1, var3), 0);
    assert_int_equal(strncmp(var1, var3,5), 0);
    //assert_string_equal(strcmp(var1, var2), 0);
    //assert_string_equal(strncmp(var1, var3,6), 0);
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_isdigit);
        run_test(test_tolower);
        run_test(test_strlen);
        run_test(test_strcopy);
        run_test(test_strcat);
        run_test(test_strcmp);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}
