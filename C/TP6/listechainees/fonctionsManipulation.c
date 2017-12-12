/*************************************************
 * LES FONCTIONS D'AIDES A LA MANIPULATION       *
 *************************************************/

/* Fonction : insertionDebutListe
 * ------------------------------
 * Permet d'insérer un élément en début de liste
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'élément à insérer
 *
 * Retourne l'adresse de l'elément juste inséré
 */
Element* insertionDebut(Ancre *ancre, Element *element){
    return insertionElement(ancre, element, 0);
}

/* Fonction : insertionFinListe
 * ----------------------------
 * Permet d'insérer un élément en fin de liste
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'élément à insérer
 *
 * Retourne l'adresse de l'elément juste inséré
 */
Element* insertionFine(Ancre *ancre, Element *element){
    return insertionElement(ancre, element, -1);
}

/* Fonction : suppressionDebut
 * ---------------------------
 * Permet de supprimer l’élément en première position
 *
 * ancre : ancre de la liste
 *
 * Retourne l'adresse de l'elément juste supprimé
 */
Element* suppressionDebut(Ancre *ancre){
    return suppressionElement(ancre, 0, false);
}

/* Fonction : suppressionFin
 * -------------------------
 * Permet de supprimer l’élément en dernière position
 *
 * ancre : ancre de la liste
 *
 * Retourne l'adresse de l'elément juste supprimé
 */
Element* suppressionFin(Ancre *ancre){
    return suppressionElement(ancre, -1, false);
}

/* Fonction : viderListe
 * ---------------------
 * Permet de supprimer tous les éléments d'une liste et de laisser l'ancre vide
 *
 * ancre : ancre de la liste
 */
void viderListe(Ancre *ancre){
    int i;
    int maximum = ancre->nbrElements;

    for(i = 0; i < maximum; i++){
        suppressionElement(ancre, 0, false);
    }
}

/* Fonction : recuperationPremier
 * ------------------------------
 * Permet de récupérer le premier élément d'une liste chaînée
 *
 * ancre : ancre de la liste
 */
Element* recuperationPremier(Ancre *ancre){
    return ancre->premier;
}

/* Fonction : recuperationDernier
 * ------------------------------
 * Permet de récupérer le dernier élément d'une liste chaînée
 *
 * ancre : ancre de la liste
 */
Element* recuperationDernier(Ancre *ancre){
    return ancre->dernier;
}
