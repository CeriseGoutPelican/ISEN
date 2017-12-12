/*************************************************
 * TESTS UNITAIRES AVEC SEATESTS                 *
 *************************************************/

void test_bulle(void){
    float liste[] = {1};
    float listeT[] = {1};
    triABulles(liste, 1);
    assert_true(cmp_tab(liste, listeT, 1));

    float liste2[] = {-10, 10};
    float listeT2[] = {-10, 10};
    triABulles(liste2, 2);
    assert_true(cmp_tab(liste2, listeT2, 2));

    float liste3[] = {0, 0, 0};
    float listeT3[] = {0, 0, 0};
    triABulles(liste3, 3);
    assert_true(cmp_tab(liste3, listeT3, 3));

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    float listeT4[] = {-10.5, -10, 0, 0, 10, 44, 100};
    triABulles(liste4, 7);
    assert_true(cmp_tab(liste4, listeT4, 7));
}

void test_insertion_seq(void){
    float liste[] = {1};
    float listeT[] = {1};
    triInsertion(liste, 1);
    assert_true(cmp_tab(liste, listeT, 1));

    float liste2[] = {-10, 10};
    float listeT2[] = {-10, 10};
    triInsertion(liste2, 2);
    assert_true(cmp_tab(liste2, listeT2, 2));

    float liste3[] = {0, 0, 0};
    float listeT3[] = {0, 0, 0};
    triInsertion(liste3, 3);
    assert_true(cmp_tab(liste3, listeT3, 3));

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    float listeT4[] = {-10.5, -10, 0, 0, 10, 44, 100};
    triInsertion(liste4, 7);
    assert_true(cmp_tab(liste4, listeT4, 7));
}

void test_insertion_dicho(void){
    float liste[] = {1};
    float listeT[] = {1};
    triInsertionDichotomique(liste, 1, false);
    assert_true(cmp_tab(liste, listeT, 1));

    float liste2[] = {-10, 10};
    float listeT2[] = {-10, 10};
    triInsertionDichotomique(liste2, 2, false);
    assert_true(cmp_tab(liste2, listeT2, 2));

    float liste3[] = {0, 0, 0};
    float listeT3[] = {0, 0, 0};
    triInsertionDichotomique(liste3, 3, false);
    assert_true(cmp_tab(liste3, listeT3, 3));

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    float listeT4[] = {-10.5, -10, 0, 0, 10, 44, 100};
    triInsertionDichotomique(liste4, 7, false);
    assert_true(cmp_tab(liste4, listeT4, 7));
}

void test_insertion_dicho_recu(void){
    float liste[] = {1};
    float listeT[] = {1};
    triInsertionDichotomique(liste, 1, true);
    assert_true(cmp_tab(liste, listeT, 1));

    float liste2[] = {-10, 10};
    float listeT2[] = {-10, 10};
    triInsertionDichotomique(liste2, 2, true);
    assert_true(cmp_tab(liste2, listeT2, 2));

    float liste3[] = {0, 0, 0};
    float listeT3[] = {0, 0, 0};
    triInsertionDichotomique(liste3, 3, true);
    assert_true(cmp_tab(liste3, listeT3, 3));

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    float listeT4[] = {-10.5, -10, 0, 0, 10, 44, 100};
    triInsertionDichotomique(liste4, 7, true);
    assert_true(cmp_tab(liste4, listeT4, 7));
}

void test_rapide(void){
    float liste[] = {1};
    float listeT[] = {1};
    triRapide(liste, 0, 0);
    assert_true(cmp_tab(liste, listeT, 1));

    float liste2[] = {-10, 10};
    float listeT2[] = {-10, 10};
    triRapide(liste2, 0, 1);
    assert_true(cmp_tab(liste2, listeT2, 2));

    float liste3[] = {0, 0, 0};
    float listeT3[] = {0, 0, 0};
    triRapide(liste3, 0, 2);
    assert_true(cmp_tab(liste3, listeT3, 3));

    float liste4[] = {44, 0, 100, -10, -10.5, 0, 10};
    float listeT4[] = {-10.5, -10, 0, 0, 10, 44, 100};
    triRapide(liste4, 0, 6);
    assert_true(cmp_tab(liste4, listeT4, 7));
}

void test_PairsImpairs(void){
    int liste[] = {5, 7, 4, 0, 2, 1, 8, 9, 3, 6};
    int listeT[] = {1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
    qsort(liste, 10, sizeof(int), comparaisonPairsImpairs);
    assert_true(cmp_tab_int(liste, listeT, 1));
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_bulle);
        run_test(test_insertion_seq);
        run_test(test_insertion_dicho);
        run_test(test_insertion_dicho_recu);
        run_test(test_rapide);
        run_test(test_PairsImpairs);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}
