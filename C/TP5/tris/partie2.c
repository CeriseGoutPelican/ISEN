/*************************************************
 * 2EME PARTIE : LE TRI RAPIDE                   *
 *************************************************/

/* Fonction : triRapide
 * --------------------
 * Permet de trier une liste � l'aide de la m�thode du tri rapide (quickSort)
 * Cette fonction n'est qu'une traduction de la m�thode vue en TD
 *
 * liste : liste 1D m�lang�e � trier
 * minimumIndex : plus petit index de la liste
 * maximumIndex : plus grand index de la liste
 */
void triRapide(float liste[], int minimumIndex, int maximumIndex){
    int pivot;

    if(minimumIndex < maximumIndex){
        pivot = maximumIndex;
        pivot = triRapidePartition(liste, minimumIndex, maximumIndex, pivot);
        triRapide(liste, minimumIndex, pivot - 1);
        triRapide(liste, pivot + 1, maximumIndex);
    }
}

/* Fonction : triRapidePartition
 * -----------------------------
 * Permet de selectionner un pivot et d'inverser tous les �l�ments d'un sous-tableau
 * autour du pivot afin de trier la sous-liste
 *
 * liste : liste 1D m�lang�e � trier
 * minimumIndex : plus petit index de la liste
 * maximumIndex : plus grand index de la liste
 * pivot : pivot pass� par le quicksort
 *
 * retourne : la derni�re position invers�e qui devient le prochain pivot
 */
int triRapidePartition(float liste[], int minimumIndex, int maximumIndex, int pivot){
    int curseurGauche, curseurDroit;
    int valeurPivot = liste[pivot];
    inversionTableau(liste, pivot, maximumIndex);
    curseurGauche = minimumIndex;

    for(curseurDroit = minimumIndex; curseurDroit < maximumIndex; curseurDroit++){
        if(liste[curseurDroit] < valeurPivot){
            inversionTableau(liste, curseurDroit, curseurGauche);
            curseurGauche++;
        }
    }
    inversionTableau(liste, curseurGauche, maximumIndex);
    return curseurGauche;
}

/* Fonction : inversionTableau
 * ---------------------------
 * Permet d'inverser deux �l�ments dans un tableau
 *
 * liste : liste 1D m�lang�e � trier
 * index1 : index du premier �l�ment
 * index2 : index du second �l�ment
 */
void inversionTableau(float liste[], int index1, int index2){
    float elemTemp  = liste[index1];
    liste[index1] = liste[index2];
    liste[index2] = elemTemp;
}
