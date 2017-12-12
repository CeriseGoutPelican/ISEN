/* Fonction : afficheListe
 * -----------------------
 * Permet d'afficher le contenu d'une liste, ne retourne rien
 *
 * liste : liste 1D mélangée à trier
 * taille : nombre d'éléments contenus dans la liste
 */
void afficheListe(float liste[], int taille){
    int i;

    printf("Liste : {");
    for(i = 0; i < taille; i++){
        printf("%g%s", liste[i], i<taille-1?", ":"");
    }
    printf("}\n");
}

/* Exactement pareil qu'avant mais avec du int à la place de float
 * A voir s'il est possible d'avoir une fonction avec deux types différents
 */
void afficheListeInt(int liste[], int taille){
    int i;

    printf("Liste : {");
    for(i = 0; i < taille; i++){
        printf("%d%s", liste[i], i<taille-1?", ":"");
    }
    printf("}\n");
}

/* Fonction : cmp_tab
 * ------------------
 * Permet de comparer élément par élément un tableau : à utiliser pour seatests
 *
 * tab1 : liste 1D à comparer
 * tab2 : liste 1D à comparer
 * taille : taille du tableau
 */
int cmp_tab(float *tab1, float *tab2, int taille){
     int i;
     for(i=0;i<taille;i++) {
       if (tab1[i]!=tab2[i]) return 0;
     }
     return 1;
}
int cmp_tab_int(int *tab1, int *tab2, int taille){
     int i;
     for(i=0;i<taille;i++) {
       if (tab1[i]!=tab2[i]) return 0;
     }
     return 1;
}
