#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

/* Construction d'un type adapté */
struct Statistiques{
    int minimum;
    int maximum;
    float moyenne;
    float ecartType;
};

int minimum_tableau(int tableau[], int taille_tableau);
void moyenne_ecartType_tableau(int tableau[], int taille_tableau, int* minimum, int* maximum, float* moyenne, float* ecartType);
void statistiques_tableau_struct(int tableau[], int taille_tableau, struct Statistiques *stats);
void test_all(void);

#endif // HEADER_H_INCLUDED
