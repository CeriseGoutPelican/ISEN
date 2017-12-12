/*************************************************
 * 1ERE PARTIE : TRIS SIMPLES                    *
 *************************************************/

/* Fonction : triABulles
 * ---------------------
 * Permet de trier une liste à l'aide de la méthode du tri à bulles
 *
 * liste : liste 1D mélangée à trier
 * taille : nombre d'éléments contenus dans la liste
 */
void triABulles(float liste[], int taille){
    int i, y;
    float elementTemp;

    for(i = 0; i < taille - 1; i++){
        for(y = 0; y < taille - 1; y++){
            if(liste[y] > liste[y+1]){
                elementTemp = liste[y];
                liste[y]    = liste[y+1];
                liste[y+1]  = elementTemp;
            }
        }
    }
}

/* Fonction : triInsertion
 * -----------------------
 * Permet de trier une liste à l'aide de la méthode du tri insertion
 *
 * liste : liste 1D mélangée à trier
 * taille : nombre d'éléments contenus dans la liste
 */
void triInsertion(float liste[], int taille){
    int i, y;
    float elementTemp;

    for(i = 1; i < taille; i++){
        elementTemp = liste[i];
        y = i;

        // Tant que l'élément actuel est inférieur à tous les éléments du dessous
        // et qu'il n'est pas à la première position, on effectue un décalage de tous les éléments
        // puis on insère l'élément (elementTemp) à sa bonne place
        while(y > 0 && liste[y - 1] > elementTemp){
            liste[y] = liste[y - 1];
            y--;
        }
        liste[y] = elementTemp;
    }
}

/* Fonction : triInsertionDichotomique
 * -----------------------------------
 * Permet de trier une liste à l'aide de la méthode du tri insertion
 * Utilisation de la méthode par insertion
 *
 * liste : liste 1D mélangée à trier
 * taille : nombre d'éléments contenus dans la liste
 * recursivite : true, utilise la recherche de rang récursive, false, utilise la version linéaire
 */
void triInsertionDichotomique(float liste[], int taille, float recursivite){
    int i, j, indiceElement;
    float valeurElement;

    // Parcourt de la liste élément par élément
    for(i = 1; i < taille; i++){

        // On vérifie qu'il y a au moins un décalage à faire
        // (Elements non dans l'ordre)
        if(comparaison(liste[i - 1], liste[i]) == 1){

            // Appel récursif ou séquentiel
            if(recursivite)
                indiceElement = rechercheDichotomiqueRecursive(liste, 0, i, liste[i]);
            else
                indiceElement = rechercheDichotomique(liste, i, liste[i]);

            valeurElement = liste[i];

            // Décalage de tous les éléments
            for(j = i-1; j >= indiceElement; j--){
                liste[j + 1] = liste[j];
            }

            // Insertion de l'élément une fois tous les autres décalés
            liste[indiceElement] = valeurElement;

        }
    }
}

/* Fonction : rechercheDichotomique
 * --------------------------------
 * Permet de récupérer le rang (l'index) d'un élément dans un tableau
 * grâce à une recherche dichotomique non récursive.
 *
 * liste : liste 1D mélangée à trier
 * taille : nombre d'éléments contenus dans la liste
 * element : valeur de l'élément à rechercher
 *
 * retourne : l'indice de l'élément à rechercher
 */
int rechercheDichotomique(float liste[], int taille, float element){
    int pivot;
    int indexDebut = 0;
    int indexFin   = taille;

    while(indexDebut != indexFin){
        pivot = (indexDebut + indexFin) / 2;

        if(comparaison(element, liste[pivot]) == -1)
            indexFin = pivot;
        else
            indexDebut = pivot + 1;
    }
    return indexDebut;
}

/* Fonction : rechercheDichotomiqueRecursive
 * -----------------------------------------
 * Permet de récupérer le rang (l'index) d'un élément dans un tableau
 * grâce à une recherche dichotomique récursive.
 *
 * liste : liste 1D mélangée à trier
 * indexDebut :index du début du tableau à traiter
 * indexFin :index de fin du tableau à traiter
 * element : valeur de l'élément à rechercher
 *
 * retourne : l'indice de l'élément à rechercher
 */
int rechercheDichotomiqueRecursive(float liste[], int indexDebut, int indexFin, float element){
    int pivot;

    // Condition d'arrêt
    if(indexDebut == indexFin){
        return indexDebut;
    } else {
        pivot = (indexDebut + indexFin) / 2;

        if(comparaison(element, liste[pivot]) == -1)
            return rechercheDichotomiqueRecursive(liste, indexDebut, pivot, element);
        else
            return rechercheDichotomiqueRecursive(liste, pivot + 1, indexFin, element);
    }
}

/* Fonction : comparaison
 * ----------------------
 * Permet d'effectuer une comparaison entre deux éléments passés en paramètre
 *
 * element1 : premier élément à comparer
 * element2 : deuxième élément à comparer
 *
 * retourne : -1 si element1 < element2, 0 si élément1 = element2 et 1 si element1 > element2
 */
int comparaison(float element1, float element2){
    if(element1 > element2)
        return 1;
    if(element1 < element2)
        return -1;
    else
        return 0;
}
