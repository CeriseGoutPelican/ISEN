/*************************************************
 * LES FONCTIONS BASIQUES                        *
 *************************************************/

/* Fonction : creationListe
 * ------------------------
 * Permet de créer une liste chaînée vide
 *
 * Retourne l'adresse d'une liste chaînée vide (ancre)
 */
Ancre* creationListe(){
    // Utilisation de malloc pour assigner une valeur à liste
    Ancre *liste       = malloc(sizeof(Ancre));
    liste->premier     = NULL;
    liste->dernier     = NULL;
    liste->nbrElements = 0;
    return liste;
}

/* Fonction : creationElement
 * --------------------------
 * Permet de créer un élément pour une liste chaînée
 *
 * Retourne l'adresse de l'élément
 */
Element* creationElement(int contenu){
    // Utilisation de malloc pour assigner une valeur à liste
    Element *element   = malloc(sizeof(Element));
    element->contenu   = contenu;
    element->precedent = NULL;
    element->suivant   = NULL;
    return element;
}

/* Fonction : insertionElement
 * ---------------------------
 * Permet d'insérer un élément avant le -nième noeud
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'élément à insérer
 * position : position de l'élément à rajouter
 *            (0: première / n: position / -1: dernière position)
 *
 * Retourne l'adresse de l'elément juste inséré
 */
Element* insertionElement(Ancre *ancre, Element *element, int position){
    // Dernière position
    if(position == -1){
        // Mise à jour du dernier élément
        ancre->dernier->suivant = element;
        // Mise à jour du nouvel élément
        element->precedent = ancre->dernier;
        element->suivant   = NULL;
        // Mise à jour de l'ancre
        ancre->dernier = element;
        ancre->nbrElements++;
    }
    // Première position
    if(position == 0){
        // Mise à jour du premier élément
        if(ancre->nbrElements > 0)
            ancre->premier->precedent = element;
        // Mise à jour du nouvel élément
        element->precedent = NULL;
        element->suivant   = ancre->premier;
        // Mise à jour de l'ancre
        ancre->premier = element;
        if(ancre->nbrElements == 0)
            ancre->dernier = element;
        ancre->nbrElements++;
    }
    // Nème position
    if(position > 0){
        Element *tempElement = recuperationElement(ancre, position);
        // Mise à jour de l'élément
        element->precedent = tempElement->precedent;
        element->suivant   = tempElement;
        // Mise à jour de l'élément précédent
        tempElement->precedent->suivant = element;
        // Mise à jour de l'élément suivant
        tempElement->precedent = element;
        // Mise à jour de l'ancre
        ancre->nbrElements++;
    }
    return element;
}

/* Fonction : recuperationElement
 * ------------------------------
 * Permet de récupérer l’élément se trouvant au -nième noeud
 *
 * ancre : ancre de la liste
 * position : position de l'élément à rechercher
 */
Element* recuperationElement(Ancre *ancre, int position){
    Element *element = ancre->premier;
    int i = 0;

    while(i < position){
        element = element->suivant;
    i++;}

    return element;
}

/* Fonction : suppressionElement
 * -----------------------------
 * Permet de supprimer l’élément se trouvant au -nième noeud
 *
 * ancre : ancre de la liste
 * position : position de l'élément à supprimer
 * recuperation : libère ou non la mémoire de l'élément
 *
 * Retourne l'adresse de l'elément juste supprimé (ou NULL si recuperation = false)
 */
Element* suppressionElement(Ancre *ancre, int position, bool recuperation){
    Element *element = ancre->premier;
    int i = 0;

    while(i < position && i <= ancre->nbrElements && i != -1){
        element = element->suivant;
    i++;}

    // Suppression du premier élément
    if(position == 0 && ancre->nbrElements != 1){
        element->suivant->precedent = NULL;
        ancre->premier = element->suivant;
    }
    // Suppression du dernier élément
    if((position >= ancre->nbrElements-1 || position == -1) && ancre->nbrElements != 1){
        element = ancre->dernier;
        element->precedent->suivant = NULL;
        ancre->dernier = element->precedent;
    }
    // Suppression du n-ième élément
    if(position > 0 && position < ancre->nbrElements-1 && ancre->nbrElements != 1){
        element->precedent->suivant = element->suivant;
        element->suivant->precedent = element->precedent;
    }
    // Suppression du dernier élément présent dans une liste
    if(ancre->nbrElements == 1){
        ancre->dernier = NULL;
        ancre->premier = NULL;
    }

    // Mise à jour de l'élément
    element->suivant   = NULL;
    element->precedent = NULL;

    // Mise à jour de l'ancre
    ancre->nbrElements--;

    // Suppression ou non de l'élément
    if(recuperation == true){
        return element;
    } else {
        free(element);
        return NULL;
    }
}

/* Fonction : affichageListe
 * -------------------------
 * Permet d'afficher proprement une liste dans la console
 *
 * ancre : ancre de la liste à afficher
 */
void affichageListe(Ancre *ancre){
    int i;
    Element *element = ancre->premier;

    printf("\nAFFICHAGE DE LA LISTE\n");
    printf("=====================\n");
    printf("ANCRE :\n");
    if(ancre->premier != NULL)
        printf("- Premier element   : %d\n", ancre->premier->contenu);
    else
        printf("- Premier element   : NULL\n");
    if(ancre->dernier != NULL)
        printf("- Dernier element   : %d\n", ancre->dernier->contenu);
    else
        printf("- Dernier element   : NULL\n");
    printf("- Nombre d'elements : %d\n", ancre->nbrElements);
    printf("  (controle : %d)\n",nombreElementsListe(ancre));

    if(ancre->nbrElements > 0){
        printf("\nLISTE DES ELEMENTS :\n");
        for(i = 0; i < ancre->nbrElements; i++){
            printf("- [%d] => %d\n", i, element->contenu);

            element = element->suivant;
        }
    }
    printf("=====================\n");
}


/* Fonction : nombreElementsListe
 * ------------------------------
 * Permet de compter le nombre d'éléments d'une liste
 *
 * ancre : ancre de la liste à compter
 */
int nombreElementsListe(Ancre *ancre){
    Element *element = ancre->premier;
    int i = 0;

    while(element != NULL){
        element = element->suivant;
    i++;}

    return i;
}
