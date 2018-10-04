def creer_index(chaine = False, nbr_elements = False):
    """
    La fonction prend comme paramètre entrant une chaîne de caractère et renvoie un dictionnaire dont :
    • les clés seront constituées de chaque mot distinct contenu dans la chaîne en entrée
    • leur valeur respective, du nombre de fois ou le mot apparaît dans la chaîne en entrée.

    :param chaine: chaine de caractère
    :return: un dictionnaire avec le nombre d'occurence de chaque mot
    """
    # Gestion des erreurs
    if isinstance(chaine, str) == False:
        raise ValueError("La chaine passée est soit vide soit du mauvais type (doit être un string)")
    if nbr_elements != False and isinstance(nbr_elements, int) == False:
        raise ValueError("Le nombre d'éléments doit être de type integer")

    # Création des variables
    dictionnaire = {}
    chaine = chaine.split()

    # Parcourt de la chaîne mot à mot
    for e in chaine:
        try:
            dictionnaire[e] += 1
        except:
            dictionnaire[e] = 1

    # Tri du dictionnaire avec la fonction sort
    # /!\ Ce tri transforme le dictionnaire en liste 2D de tuples
    tri = sorted(((value, key) for (key,value) in dictionnaire.items()), reverse = True)

    # A partir de la liste de tuples, on créer un deuxième dictionnaire trié
    dictionnaire_trie = {}
    i = 1
    for (k,v) in tri:

        if nbr_elements == False or i <= nbr_elements:
            dictionnaire_trie[v] = k

        i+=1

    return dictionnaire_trie
