/*************************************************
 * 1ERE PARTIE : TRIS SIMPLES                    *
 *************************************************/

/* Fonction : triABulles
 * ---------------------
 * Permet de trier une liste � l'aide de la m�thode du tri � bulles
 *
 * liste : liste 1D m�lang�e � trier
 * taille : nombre d'�l�ments contenus dans la liste
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
 * Permet de trier une liste � l'aide de la m�thode du tri insertion
 *
 * liste : liste 1D m�lang�e � trier
 * taille : nombre d'�l�ments contenus dans la liste
 */
void triInsertion(float liste[], int taille){
    int i, y;
    float elementTemp;

    for(i = 1; i < taille; i++){
        elementTemp = liste[i];
        y = i;

        // Tant que l'�l�ment actuel est inf�rieur � tous les �l�ments du dessous
        // et qu'il n'est pas � la premi�re position, on effectue un d�calage de tous les �l�ments
        // puis on ins�re l'�l�ment (elementTemp) � sa bonne place
        while(y > 0 && liste[y - 1] > elementTemp){
            liste[y] = liste[y - 1];
            y--;
        }
        liste[y] = elementTemp;
    }
}

/* Fonction : triInsertionDichotomique
 * -----------------------------------
 * Permet de trier une liste � l'aide de la m�thode du tri insertion
 * Utilisation de la m�thode par insertion
 *
 * liste : liste 1D m�lang�e � trier
 * taille : nombre d'�l�ments contenus dans la liste
 * recursivite : true, utilise la recherche de rang r�cursive, false, utilise la version lin�aire
 */
void triInsertionDichotomique(float liste[], int taille, float recursivite){
    int i, j, indiceElement;
    float valeurElement;

    // Parcourt de la liste �l�ment par �l�ment
    for(i = 1; i < taille; i++){

        // On v�rifie qu'il y a au moins un d�calage � faire
        // (Elements non dans l'ordre)
        if(comparaison(liste[i - 1], liste[i]) == 1){

            // Appel r�cursif ou s�quentiel
            if(recursivite)
                indiceElement = rechercheDichotomiqueRecursive(liste, 0, i, liste[i]);
            else
                indiceElement = rechercheDichotomique(liste, i, liste[i]);

            valeurElement = liste[i];

            // D�calage de tous les �l�ments
            for(j = i-1; j >= indiceElement; j--){
                liste[j + 1] = liste[j];
            }

            // Insertion de l'�l�ment une fois tous les autres d�cal�s
            liste[indiceElement] = valeurElement;

        }
    }
}

/* Fonction : rechercheDichotomique
 * --------------------------------
 * Permet de r�cup�rer le rang (l'index) d'un �l�ment dans un tableau
 * gr�ce � une recherche dichotomique non r�cursive.
 *
 * liste : liste 1D m�lang�e � trier
 * taille : nombre d'�l�ments contenus dans la liste
 * element : valeur de l'�l�ment � rechercher
 *
 * retourne : l'indice de l'�l�ment � rechercher
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
 * Permet de r�cup�rer le rang (l'index) d'un �l�ment dans un tableau
 * gr�ce � une recherche dichotomique r�cursive.
 *
 * liste : liste 1D m�lang�e � trier
 * indexDebut :index du d�but du tableau � traiter
 * indexFin :index de fin du tableau � traiter
 * element : valeur de l'�l�ment � rechercher
 *
 * retourne : l'indice de l'�l�ment � rechercher
 */
int rechercheDichotomiqueRecursive(float liste[], int indexDebut, int indexFin, float element){
    int pivot;

    // Condition d'arr�t
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
 * Permet d'effectuer une comparaison entre deux �l�ments pass�s en param�tre
 *
 * element1 : premier �l�ment � comparer
 * element2 : deuxi�me �l�ment � comparer
 *
 * retourne : -1 si element1 < element2, 0 si �l�ment1 = element2 et 1 si element1 > element2
 */
int comparaison(float element1, float element2){
    if(element1 > element2)
        return 1;
    if(element1 < element2)
        return -1;
    else
        return 0;
}
