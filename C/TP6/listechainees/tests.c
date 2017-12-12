/*************************************************
 * TESTS UNITAIRES AVEC SEATESTS                 *
 *************************************************/

void test_creationListe(void){
    Ancre *liste = creationListe();
    assert_int_equal(0, liste->nbrElements);
    assert_false(testPointeur(liste->premier));
    assert_false(testPointeur(liste->dernier));
}

bool testPointeur(Element *element){
    if(element)
        return true;
    return false;
}

void test_insertionElement(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(5), -1);
    insertionElement(liste, creationElement(2), 1);
    insertionElement(liste, creationElement(4), 3);
    insertionElement(liste, creationElement(0), 0);

    int i;
    Element *element = liste->premier;
    int verification[6] = {0, 1, 2, 3, 4, 5};
    for(i = 0; i < 6; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }

    assert_int_equal(6, liste->nbrElements);
    assert_int_equal(0, liste->premier->contenu);
    assert_int_equal(5, liste->dernier->contenu);
}

void test_recuperationElement(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(-10.55), 0);
    insertionElement(liste, creationElement(0), -1);
    insertionElement(liste, creationElement(25000), -1);

    assert_int_equal(-10.55, recuperationElement(liste, 0)->contenu);
    assert_float_equal(0, recuperationElement(liste, 1)->contenu,0);
    assert_int_equal(25000, recuperationElement(liste, 2)->contenu);
}

void test_suppressionElement(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(4), -1);

    suppressionElement(liste, 1, false);
    suppressionElement(liste, -1, false);
    Element *element = suppressionElement(liste, 0, true);

    assert_int_equal(1, liste->nbrElements);
    assert_int_equal(3, liste->premier->contenu);
    assert_int_equal(3, liste->dernier->contenu);
    assert_int_equal(1, element->contenu);
    free(element);
}

void test_nombreElementsListe(void){
    Ancre *liste = creationListe();
    assert_int_equal(0, nombreElementsListe(liste));
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(4), -1);
    assert_int_equal(4, nombreElementsListe(liste));
}

void test_viderListe(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    viderListe(liste);
    assert_int_equal(0, liste->nbrElements);
    assert_false(testPointeur(liste->premier));
    assert_false(testPointeur(liste->dernier));
}

void test_echangeNoeuds(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(4), -1);
    insertionElement(liste, creationElement(5), -1);

    echangeNoeuds(liste, 0, 4);
    echangeNoeuds(liste, 1, 3);
    echangeNoeuds(liste, 0, 1);

    int i;
    Element *element = liste->premier;
    int verification[5] = {4, 5, 3, 2, 1};
    for(i = 0; i < 5; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_remplaceNoeud(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(3), -1);

    remplaceNoeud(liste, creationElement(25), 0);
    remplaceNoeud(liste, creationElement(10), 1);
    remplaceNoeud(liste, creationElement(-10), 2);

    int i;
    Element *element = liste->premier;
    int verification[3] = {25, 10, -10};
    for(i = 0; i < 3; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_concatenationListe(void){
    Ancre *liste1 = creationListe();
    insertionElement(liste1, creationElement(1), 0);
    insertionElement(liste1, creationElement(2), -1);
    insertionElement(liste1, creationElement(3), -1);
    insertionElement(liste1, creationElement(4), -1);

    Ancre *liste2 = creationListe();
    insertionElement(liste2, creationElement(4), 0);
    insertionElement(liste2, creationElement(5), -1);
    insertionElement(liste2, creationElement(6), -1);
    insertionElement(liste2, creationElement(7), -1);
    liste1 = concatenationListe(liste1, liste2);

    int i;
    Element *element = liste1->premier;
    int verification[8] = {1, 2, 3, 4, 4, 5, 6, 7};
    for(i = 0; i < 8; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_rechercheElement(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(0), 0);
    insertionElement(liste, creationElement(-22.3), -1);
    insertionElement(liste, creationElement(10), -1);
    insertionElement(liste, creationElement(2091), -1);
    insertionElement(liste, creationElement(0), -1);

    assert_int_equal(2, rechercheElement(liste, 10));
    assert_int_equal(0, rechercheElement(liste, 0));
    assert_int_equal(3, rechercheElement(liste, 2091));
    assert_int_equal(1, rechercheElement(liste, -22.3));
}

void test_cloneSansDoublons(void){
    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(2), 0);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(5), -1);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(13), -1);
    insertionElement(liste, creationElement(13), -1);
    insertionElement(liste, creationElement(0), -1);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(42), -1);

    liste = cloneSansDoublons(liste);

    int i;
    Element *element = liste->premier;
    int verification[6] = {2, 3, 5, 13, 0, 42};
    for(i = 0; i < 6; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_unionListes(void){

    Ancre *liste1 = creationListe();
    insertionElement(liste1, creationElement(1), 0);
    insertionElement(liste1, creationElement(2), -1);
    insertionElement(liste1, creationElement(3), -1);

    Ancre *liste2 = creationListe();
    insertionElement(liste2, creationElement(2), 0);
    insertionElement(liste2, creationElement(3), -1);
    insertionElement(liste2, creationElement(4), -1);

    liste1 = unionListes(liste1, liste2);

    int i;
    Element *element = liste1->premier;
    int verification[4] = {1, 2, 3, 4};
    for(i = 0; i < 4; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_intersectionListes(void){

    Ancre *liste1 = creationListe();
    insertionElement(liste1, creationElement(1), 0);
    insertionElement(liste1, creationElement(2), -1);
    insertionElement(liste1, creationElement(3), -1);
    insertionElement(liste1, creationElement(4), -1);

    Ancre *liste2 = creationListe();
    insertionElement(liste2, creationElement(2), 0);
    insertionElement(liste2, creationElement(3), -1);
    insertionElement(liste2, creationElement(4), -1);
    insertionElement(liste2, creationElement(5), -1);

    liste1 = intersectionListes(liste1, liste2);

    int i;
    Element *element = liste1->premier;
    int verification[3] = {2, 3, 4};
    for(i = 0; i < 3; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_testSurListe(void){

    Ancre *liste = creationListe();
    insertionElement(liste, creationElement(1), 0);
    insertionElement(liste, creationElement(2), -1);
    insertionElement(liste, creationElement(3), -1);
    insertionElement(liste, creationElement(4), -1);
    insertionElement(liste, creationElement(5), -1);
    insertionElement(liste, creationElement(6), -1);
    insertionElement(liste, creationElement(7), -1);

    liste = testSurListe(liste, fonctionTest);

    int i;
    Element *element = liste->premier;
    int verification[4] = {1, 3, 5, 7};
    for(i = 0; i < 4; i++){
        assert_int_equal(verification[i], element->contenu);
        element = element->suivant;
    }
}

void test_fixture_string(void){
    test_fixture_start();
        run_test(test_creationListe);
        run_test(test_insertionElement);
        run_test(test_recuperationElement);
        run_test(test_suppressionElement);
        run_test(test_nombreElementsListe);
        run_test(test_viderListe);
        run_test(test_echangeNoeuds);
        run_test(test_remplaceNoeud);
        run_test(test_concatenationListe);
        run_test(test_rechercheElement);
        run_test(test_cloneSansDoublons);
        run_test(test_unionListes);
        run_test(test_intersectionListes);
        run_test(test_testSurListe);
    test_fixture_end();
}

void test_all(void){
    test_fixture_string();
}
