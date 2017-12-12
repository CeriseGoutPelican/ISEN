#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

void test_all(void);
void triABulles(float liste[], int taille);
void afficheListe(float liste[], int taille);
void afficheListeInt(int liste[], int taille);

void triInsertion(float liste[], int taille);
void triInsertionDichotomique(float liste[], int taille, float recursivite);
int rechercheDichotomique(float liste[], int taille, float element);
int rechercheDichotomiqueRecursive(float liste[], int indexDebut, int indexFin, float element);
int comparaison(float element1, float element2);

void triRapide(float liste[], int minimumIndex, int maximumIndex);
int triRapidePartition(float liste[], int minimumIndex, int maximumIndex, int pivot);
void inversionTableau(float liste[], int index1, int index2);

int comparaisonPairsImpairs(const void * element1, const void * element2);

int cmp_tab(float *tab1, float *tab2, int taille);
int cmp_tab_int(int *tab1, int *tab2, int taille);


#endif // HEADER_H_INCLUDED
