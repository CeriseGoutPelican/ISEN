# ----------------------------------------------
# - Toutes les fonctions                       -
# ----------------------------------------------

def analyse_texte(*args):
    """
    Permet de calculer la plus petite chaîne, la plus grand chaîne et la longueur moyenne des chaîne de
    caractères d’un nombre variable de valeurs

    :param args: Variables de tous types qui seront pris en compte pour le calcul de la fonction, pas de nombre prédef.
    :return: plus petite chaine, plus grande chaine, moyenne de caractères
    """

    mini    = None
    maxi    = None
    moy     = 0
    nb_elem = 0

    # Parcourt des arguements
    for arg in args:

        if isinstance(arg, str):

            size = len(arg)

            # Mise à jour du minimum
            if mini == None or size <= len(mini):
                mini = arg

            # Mise à jour du maximum
            if maxi == None or size >= len(maxi):
                maxi = arg

            # Mise à jour de la moyenne
            moy += size
            nb_elem += 1

    # Gestion des erreurs
    if nb_elem == 0:
        raise ValueError('Aucun argument valide passé')

    return mini, maxi, moy / nb_elem
