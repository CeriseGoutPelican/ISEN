import sys

def min_value(liste):
    """Permet de recuperer le plus petit element (nombre) d'une liste"""

    # Pour rechercher le premier element
    first = False

    # Parcours la liste list element par element
    for e in liste:
        if isinstance(e, (int, float, bool)):
            if first == False:
                # Valeure minimale
                min = e

                # Premier element trouve
                first = True
            else:
                # Substitue l'element le plus petit
                if e <= min:
                    min = e

    if first:
        return min
    else:
        return "/!\ Erreur"
        #raise Exception("Il n'y a pas de valeurs numeriques dans la liste")

def min_value_rec(liste):
    """Permet de recuperer le plus petit element (nombre) d'une liste"""

    # Pour rechercher le premier element
    first = False

    # Parcours la liste list element par element
    for e in liste:
        if isinstance(e, (int, float, bool)):
            if first == False:
                # Valeure minimale
                min = e
                # Premier element trouve
                first = True
            else:
                # Substitue l'element le plus petit
                if e <= min:
                    min = e

        elif isinstance(e, list):
            e = min_value_rec(e)
            if first == False:
                # Valeure minimale
                min = e
                # Premier element trouve
                first = True
            else:
                # Substitue l'element le plus petit
                if e <= min:
                    min = e

    return min

# map et filter sont deux éléments interessants en pythons

print(sys.version)
print('-'*50)

list1 = ["hello", -5, False, 1.2323, {"a", 10, "c"}, [-18,45, "abcd"]]
list2 = [1.1, "hello", 10, -True, 1.2323, {"a", 10, "c"}, [18,45, "abcd"]]
list3 = [False]
list4 = ["hello", [-18,45,"abcd"]]
print(min_value_rec(list1))
print(min_value_rec(list2))
print(min_value_rec(list3))
print(min_value_rec(list4))
