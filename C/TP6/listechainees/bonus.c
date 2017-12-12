/*************************************************
 * LES FONCTIONS BONUS                           *
 *************************************************/

/* Fonction : cloneSansDoublons
 * ----------------------------
 * Permet de retourner une nouvelle liste, clone de la première, mais sans les doublons
 *
 * ancre : header de la liste de travail
 *
 * Retourne la nouvelle liste
 */
Ancre* cloneSansDoublons(Ancre *ancre){
    int i;
    Element *element = ancre->premier;
    Ancre *ancre2 = creationListe();

    insertionElement(ancre2, creationElement(element->contenu), 0); // Ajout du premier élément car la position doit être 0 pour le premier et non -1

    for(i = 0; i < ancre->nbrElements; i++){
        // On vérifie si l'élément à ajouter n'est pas déjà présent dans la nouvelle liste, sinon on passe
        if(rechercheElement(ancre2, element->contenu) == -1){
            insertionElement(ancre2, creationElement(element->contenu), -1);
        }
        element = element->suivant;
    }

    return ancre2;
}

/* Fonction : unionListes
 * ----------------------
 * Permet de retourner une nouvelle liste représentant l’union de deux listes
 *
 * ancre1 : header de la liste de travail
 * ancre2 : header de la seconde liste
 */
Ancre* unionListes(Ancre *ancre1, Ancre *ancre2){
    Ancre *ancre = concatenationListe(ancre1, ancre2);
    return cloneSansDoublons(ancre);
}

/* Fonction : intersectionListes
 * -----------------------------
 * Permet de retourner une nouvelle liste représentant l’union de deux listes
 *
 * ancre1 : header de la liste de travail
 * ancre2 : header de la seconde liste
 */
Ancre* intersectionListes(Ancre *ancre1, Ancre *ancre2){

    int i, maximum;
    Element *element;
    Ancre *intersection = creationListe();

    // On boucle sur la liste la plus grande
    if(ancre1->nbrElements > ancre2->nbrElements){
        maximum = ancre1->nbrElements;
        element = ancre1->premier;
    }
    else{
        maximum = ancre2->nbrElements;
        element = ancre2->premier;
    }

    for(i = 0; i < maximum; i++){
        // On ajoute que les éléments communs à la liste
        if(rechercheElement(ancre1, element->contenu) != -1 && rechercheElement(ancre2, element->contenu) != -1){
            if(intersection->nbrElements == 0)
                insertionElement(intersection, creationElement(element->contenu), 0);
            else
                insertionElement(intersection, creationElement(element->contenu), -1);
        }
        element = element->suivant;
    }
    return intersection;
}


/* Fonction : testSurListe
 * -----------------------
 * Permet de retourner une nouvelle liste composée des éléments de la
 * première liste qui ont passé une fonction de test
 *
 * ancre : header de la liste de travail
 * fonction : pointeur sur la fonction de test
 */
Ancre* testSurListe(Ancre *ancre, bool(*fonction)(int)){
    int i;
    Element *element = ancre->premier;
    Ancre *ancre2 = creationListe();

    for(i = 0; i < ancre->nbrElements; i++){
        if(fonction(element->contenu)){
            if(ancre2->nbrElements == 0)
                insertionElement(ancre2, creationElement(element->contenu), 0);
            else
                insertionElement(ancre2, creationElement(element->contenu), -1);
        }
        element = element->suivant;
    }

    return ancre2;
}

bool fonctionTest(int valeur){
    return valeur % 2;
}

