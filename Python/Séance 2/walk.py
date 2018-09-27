import logging
import os
import datetime

def walk(path1 = None, path2 = None, depth = 5,  debug = False):
    """
    La fonction Walk permet de lister les fichiers et sous dossiers presents dans un dossier donne.
    La fonction renvoie une liste contenant tous les fichiers

    :param str path: le document racine ou commencer la recursivite
    :param int depth: le nombre de recursivite maximal
    :param bool debug: active les logs de debug ou non
    :return: une liste sous la forme {{"dossier 1", "fichier 1", "fichier 2"}, {"dossier 2", "fichier 1"}}
    """

    # Récupération des deux chemins à comparer (sera à remplacer après pour le folder 2 qui sera directement une liste)
    folder_1 = os.walk(path1, topdown = True)
    folder_2 = os.walk(path2, topdown = True)

    def getContent(folders = [], previousList = None):
        paths = []

        for root, dirs, files in folders:
            # Fichiers
            for name in files:
                info = os.stat(os.path.join(root, name)).st_mtime, os.path.join(root, name)
                paths.append(info)
            # Dossiers
            for name in dirs:
                info = os.stat(os.path.join(root, name)).st_mtime, os.path.join(root, name)
                paths.append(info)

        return paths

    # Le path_x permet de vérifier les ajouts et retraits de fichiers
    paths_1 = getContent(folder_1)
    paths_2 = getContent(folder_2)

    paths_2 = [(1537455656.208525, 'C:/UwAmp/www/comparaison/t1\\fichier 1.txt'),
(1537455693.6704814, 'C:/UwAmp/www/comparaison/t1\\dossier 1'),
(1537458105.4714508, 'C:/UwAmp/www/comparaison/t1\\dossier 2'),
(1537455656.208526, 'C:/UwAmp/www/comparaison/t1\\dossier 1\\fichier 1-1.txt'),
(1537455707.5764258, 'C:/UwAmp/www/comparaison/t1\\dossier 1\\dossier 1-1'),
(1537455656.208526, 'C:/UwAmp/www/comparaison/t1\\dossier 1\\dossier 1-1\\fichier 1-1-1.txt'),
(1537455656.208526, 'C:/UwAmp/www/comparaison/t1\\dossier 2\\fichier 2-1.txt')]

    # A supprimer plus tard / juste pour les tests
    # paths_2[:] = [s.replace('t2', 't1') for s in paths_2]

    displayList(paths_1)
    print("-"*60)
    displayList(paths_2)
    print("="*60)
    print("="*60)
    print("Ajouts : ")
    map1 = map(tuple, paths_1)
    map2 = map(tuple, paths_2)
    added = set(map2) - set(map1)
    substracted = set(map1) - set(map2)
    displayList(added)
    print("Retraits : ")
    displayList(substracted)
    print("="*60)
    print("Intersection : ")
    displayList(set(map1).intersection(set(map2)))
    displayList(set(map2).intersection(set(map1)))

def displayList(liste):
    for e in liste:
        print(e)

# Tests
walk("C:/UwAmp/www/comparaison/t1", "C:/UwAmp/www/comparaison/t2", 5, False)

