/*************************************************
 * LES FONCTIONS D'AIDES A LA MANIPULATION       *
 *************************************************/

/* Fonction : insertionDebutListe
 * ------------------------------
 * Permet d'ins�rer un �l�ment en d�but de liste
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'�l�ment � ins�rer
 *
 * Retourne l'adresse de l'el�ment juste ins�r�
 */
Element* insertionDebut(Ancre *ancre, Element *element){
    return insertionElement(ancre, element, 0);
}

/* Fonction : insertionFinListe
 * ----------------------------
 * Permet d'ins�rer un �l�ment en fin de liste
 *
 * ancre : ancre de la liste
 * element : pointeur sur l'�l�ment � ins�rer
 *
 * Retourne l'adresse de l'el�ment juste ins�r�
 */
Element* insertionFine(Ancre *ancre, Element *element){
    return insertionElement(ancre, element, -1);
}

/* Fonction : suppressionDebut
 * ---------------------------
 * Permet de supprimer l��l�ment en premi�re position
 *
 * ancre : ancre de la liste
 *
 * Retourne l'adresse de l'el�ment juste supprim�
 */
Element* suppressionDebut(Ancre *ancre){
    return suppressionElement(ancre, 0, false);
}

/* Fonction : suppressionFin
 * -------------------------
 * Permet de supprimer l��l�ment en derni�re position
 *
 * ancre : ancre de la liste
 *
 * Retourne l'adresse de l'el�ment juste supprim�
 */
Element* suppressionFin(Ancre *ancre){
    return suppressionElement(ancre, -1, false);
}

/* Fonction : viderListe
 * ---------------------
 * Permet de supprimer tous les �l�ments d'une liste et de laisser l'ancre vide
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
 * Permet de r�cup�rer le premier �l�ment d'une liste cha�n�e
 *
 * ancre : ancre de la liste
 */
Element* recuperationPremier(Ancre *ancre){
    return ancre->premier;
}

/* Fonction : recuperationDernier
 * ------------------------------
 * Permet de r�cup�rer le dernier �l�ment d'une liste cha�n�e
 *
 * ancre : ancre de la liste
 */
Element* recuperationDernier(Ancre *ancre){
    return ancre->dernier;
}
