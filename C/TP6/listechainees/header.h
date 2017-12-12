#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

typedef struct Element Element;
struct Element{
    int contenu;
    Element *suivant;
    Element *precedent;
};

typedef struct Ancre Ancre;
struct Ancre{
    Element *premier;
    Element *dernier;
    int nbrElements;
};

// FONCTIONS BASIQUES
Ancre* creationListe();
Element* creationElement(int contenu);
Element* insertionElement(Ancre *ancre, Element *element, int position);
Element* recuperationElement(Ancre *ancre, int position);
void affichageListe(Ancre *ancre);
int nombreElementsListe(Ancre *ancre);
Element* suppressionElement(Ancre *ancre, int position, bool recuperation);

// FONCTION DE MANIPULATION
Element* insertionDebut(Ancre *ancre, Element *element);
Element* insertionFin(Ancre *ancre, Element *element);
Element* suppressionDebut(Ancre *ancre);
Element* suppressionFin(Ancre *ancre);
void viderListe(Ancre *ancre);
Element* recuperationPremier(Ancre *ancre);
Element* recuperationDernier(Ancre *ancre);

// FONCTIONS AVANCEES
void echangeNoeuds(Ancre *ancre, int position1, int position2);
Element* remplaceNoeud(Ancre *ancre, Element *element, int position);
Ancre* concatenationListe(Ancre *ancre1, Ancre *ancre2);
int rechercheElement(Ancre *ancre, int contenu);

// FONCTIONS BONUS
Ancre* cloneSansDoublons(Ancre *ancre);
Ancre* unionListes(Ancre *ancre1, Ancre *ancre2);
Ancre* intersectionListes(Ancre *ancre1, Ancre *ancre2);
Ancre* testSurListe(Ancre *ancre, bool(*fonction)(int));
bool fonctionTest(int valeur);

bool testPointeur(Element *element);

#endif // HEADER_H_INCLUDED
