#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

// CONSTANTE DE TYPE INT POUR L'ERREUR
const int ERRORCODE = -1;

// LISTE DES FONCTIONS
int** initMatrice(int lignes, int colonnes);
int nouvelEtat(int** matrice, char element, int etat);
bool estDecimal(char chaine[], int taille);
bool estChiffre(int chaine);
bool estSigne(char chaine);
bool estSeparateur(char chaine);
void test_all(void);
int** initMatriceAction();
int charToDecimalAction(int **matriceAction, int etat, char element, int *pSigne, float *pValeur, int *pPositionDecimale);
bool estExposant(char chaine);
bool estDecimalExposant(char chaine[], int taille);
int** initMatriceActionExposant();
int expToDecimalAction(int **matriceAction, int etat, char element, int* pSigne, float* pValeur, int* pPositionDecimale, int* pSigneExposant, int* pExposant);

#endif // HEADER_H_INCLUDED
