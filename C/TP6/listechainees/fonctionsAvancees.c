/*************************************************
 * LES FONCTIONS AVANCEES                        *
 *************************************************/

/* Fonction : echangeNoeuds
 * ------------------------
 * Permet d'échanger deux noeuds de la liste
 *
 * ancre : ancre de la liste
 * position1 : position du premier élément à échanger
 * position2 : position du second élément à échanger
 */
void echangeNoeuds(Ancre *ancre, int position1, int position2){

    // Destruction des éléments à échanger
    Element *element1 = suppressionElement(ancre, position1, true);
    Element *element2 = suppressionElement(ancre, position2-1, true); // -1 car on vient de supprimer un élément

    // Insertion des éléments à leurs nouveaux emplacements
    insertionElement(ancre, element2, position1);
    if(position2 >= ancre->nbrElements)
        insertionElement(ancre, element1, -1);
    else
        insertionElement(ancre, element1, position2);
}

/* Fonction : remplaceNoeud
 * ------------------------
 * Remplacer l’élément se trouvant au -nième noeud
 *
 * ancre : ancre de la liste
 * element : element à remplacer
 * position : position du second élément à échanger
 */
Element* remplaceNoeud(Ancre *ancre, Element *element, int position){
    if(position == ancre->nbrElements-1)
        position = -1;
    Element *ancienElement = suppressionElement(ancre, position, true);
    insertionElement(ancre, element, position);
    return ancienElement;
}

/* Fonction : concatenationListe
 * -----------------------------
 * Concatène deux listes dans une nouvelle
 *
 * ancre1 : première liste
 * ancre2 : seconde liste
 */
Ancre* concatenationListe(Ancre *ancre1, Ancre *ancre2){
    int i;
    Element *element = ancre2->premier;

    for(i = 0; i < ancre2->nbrElements; i++){
        insertionElement(ancre1, creationElement(element->contenu), -1);
        element = element->suivant;
    }

    viderListe(ancre2);
    return ancre1;
}


/* Fonction : rechercheElement
 * -----------------------------
 * Permet de retourner la position de la première occurrence d’un élément dans la liste
 *
 * ancre : ancre liant la liste sur laquelle porte la recherche
 * contenu : contenu de l'élément à rechercher
 */
int rechercheElement(Ancre *ancre, int contenu){
    int i;
    Element *element = ancre->premier;

    for(i = 0; i < ancre->nbrElements; i++){
        if(element->contenu == contenu)
            return i;
        element = element->suivant;
    }
    return -1;
}
