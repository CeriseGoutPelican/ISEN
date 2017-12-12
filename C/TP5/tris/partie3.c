/****************************************************
 * 3EME PARTIE : FONCTION QSORT ET RELATION D'ORDRE *
 ****************************************************/

/* Fonction : comparaisonPairsImpairs
 * ----------------------------------
 * Permet d'effectuer une comparaison entre deux �l�ments pass�s en param�tre
 *
 * element1 : premier �l�ment � comparer
 * element2 : deuxi�me �l�ment � comparer
 *
 * retourne : -1 si impair < pair, 0 si pair = impair et 1 si pair > impair
 */
int comparaisonPairsImpairs(const void * a, const void * b){

    int element1 = *(int*) a;
    int element2 = *(int*) b;

    if(element1%2 == 0 && element2%2 != 0)
        return 1;
    if(element1%2 != 0 && element2%2 == 0)
        return -1;
    // Dans ce cas les deux �l�ments sont pairs ou les deux �l�ments sont impairs
    else{
        if(element1%2)
            return comparaison(element1, element2);
        else
            return -1 * comparaison(element1, element2);
    }

}
