/*************************************************
 * LES FONCTIONS BASIQUES                        *
 *************************************************/

/* Fonction : creationListe
 * ------------------------
 * Permet de cr�er une liste cha�n�e vide
 *
 * Retourne l'adresse d'une liste cha�n�e vide (ancre)
 */
Ancre* creationListe(){
    // Utilisation de malloc pour assigner une valeur � liste
    Ancre *liste       = malloc(sizeof(Ancre));
    liste->premier     = NULL;
    liste->dernier     = NULL;
    liste->nbrElements = 0;
    return liste;
}

/* Fonction : creationElement
 * --------------------------
 * Permet de cr�er un �l�ment pour une liste cha�n�e
 *
 * Retourne l'adresse de l'�l�ment
 */
Element* creationElement(int contenu){
    // Utilisation de malloc pour assigner une valeur � liste
    Element *element   = malloc(sizeof(Element));
    element->contenu   = contenu;
    element->precedent = NULL;
    element->suivant   = NULL;
    return element;
}

/* Fonction : insertionElement
 * ---------------------------
 * Permet d'ins�rer un �l�ment avant le -ni�me noeud
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'�l�ment � ins�rer
 * position : position de l'�l�ment � rajouter
 *            (0: premi�re / n: position / -1: derni�re position)
 *
 * Retourne l'adresse de l'el�ment juste ins�r�
 */
Element* insertionElement(Ancre *ancre, Element *element, int position){
    // Derni�re position
    if(position == -1){
        // Mise � jour du dernier �l�ment
        ancre->dernier->suivant = element;
        // Mise � jour du nouvel �l�ment
        element->precedent = ancre->dernier;
        element->suivant   = NULL;
        // Mise � jour de l'ancre
        ancre->dernier = element;
        ancre->nbrElements++;
    }
    // Premi�re position
    if(position == 0){
        // Mise � jour du premier �l�ment
        if(ancre->nbrElements > 0)
            ancre->premier->precedent = element;
        // Mise � jour du nouvel �l�ment
        element->precedent = NULL;
        element->suivant   = ancre->premier;
        // Mise � jour de l'ancre
        ancre->premier = element;
        if(ancre->nbrElements == 0)
            ancre->dernier = element;
        ancre->nbrElements++;
    }
    // N�me position
    if(position > 0){
        Element *tempElement = recuperationElement(ancre, position);
        // Mise � jour de l'�l�ment
        element->precedent = tempElement->precedent;
        element->suivant   = tempElement;
        // Mise � jour de l'�l�ment pr�c�dent
        tempElement->precedent->suivant = element;
        // Mise � jour de l'�l�ment suivant
        tempElement->precedent = element;
        // Mise � jour de l'ancre
        ancre->nbrElements++;
    }
    return element;
}

/* Fonction : recuperationElement
 * ------------------------------
 * Permet de r�cup�rer l��l�ment se trouvant au -ni�me noeud
 *
 * ancre : ancre de la liste
 * position : position de l'�l�ment � rechercher
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
 * Permet de supprimer l��l�ment se trouvant au -ni�me noeud
 *
 * ancre : ancre de la liste
 * position : position de l'�l�ment � supprimer
 * recuperation : lib�re ou non la m�moire de l'�l�ment
 *
 * Retourne l'adresse de l'el�ment juste supprim� (ou NULL si recuperation = false)
 */
Element* suppressionElement(Ancre *ancre, int position, bool recuperation){
    Element *element = ancre->premier;
    int i = 0;

    while(i < position && i <= ancre->nbrElements && i != -1){
        element = element->suivant;
    i++;}

    // Suppression du premier �l�ment
    if(position == 0 && ancre->nbrElements != 1){
        element->suivant->precedent = NULL;
        ancre->premier = element->suivant;
    }
    // Suppression du dernier �l�ment
    if((position >= ancre->nbrElements-1 || position == -1) && ancre->nbrElements != 1){
        element = ancre->dernier;
        element->precedent->suivant = NULL;
        ancre->dernier = element->precedent;
    }
    // Suppression du n-i�me �l�ment
    if(position > 0 && position < ancre->nbrElements-1 && ancre->nbrElements != 1){
        element->precedent->suivant = element->suivant;
        element->suivant->precedent = element->precedent;
    }
    // Suppression du dernier �l�ment pr�sent dans une liste
    if(ancre->nbrElements == 1){
        ancre->dernier = NULL;
        ancre->premier = NULL;
    }

    // Mise � jour de l'�l�ment
    element->suivant   = NULL;
    element->precedent = NULL;

    // Mise � jour de l'ancre
    ancre->nbrElements--;

    // Suppression ou non de l'�l�ment
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
 * ancre : ancre de la liste � afficher
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
 * Permet de compter le nombre d'�l�ments d'une liste
 *
 * ancre : ancre de la liste � compter
 */
int nombreElementsListe(Ancre *ancre){
    Element *element = ancre->premier;
    int i = 0;

    while(element != NULL){
        element = element->suivant;
    i++;}

    return i;
}
