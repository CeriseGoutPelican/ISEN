import os
import pickle
import time

def readPath(folders):
    """
    Permet de récupérer l'intégralité des fichiers et des sous-dossiers d'un dossier
    indiqué par la variable folders

    :param folders: chemin du dossier d'écoute
    :return: liste de tuple avec les fichiers et sous dossier d'un path à instant t
    """

    folders = os.walk(folders, topdown = True)
    paths = []

    for root, dirs, files in folders:
        # Fichiers
        for name in files:
            info = os.path.join(root, name), os.stat(os.path.join(root, name)).st_mtime
            paths.append(info)
        # Dossiers
        for name in dirs:
            info = os.path.join(root, name), os.stat(os.path.join(root, name)).st_mtime
            paths.append(info)

    return paths

def saveFile(list, fileName):
    """
    Permet de sauvegarder une liste 2D dans un fichier du nom fileName

    :param list: La liste à sauvegarder
    :param fileName: le nom du fichier à enregitrer
    :return:
    """
    with open(fileName, 'wb') as f:
        pickle.dump(list, f)

def readList(fileName):
    """
    Permet de récupérer une liste 2D sauvegardée dans un fichier du nom fileName

    :param fileName: nom du fichier à lire
    :return: la liste
    """
    with open(fileName, 'rb') as f:
        return pickle.load(f)

def comparaison(liste1 = [], liste2 = []):
    """
    Permet de récupérer les éléments modifiés et supprimés sur une liste de tuples

    :param liste1:
    :param liste2:
    :return: liste 2D des éléments ajoutés , liste 2D dés éléments supprimés
    """
    sListe1 = set(liste1)
    sListe2 = set(liste2)

    added = sListe2 - sListe1
    deleted = sListe1 - sListe2

    return added, deleted

def editedFiles(added, deleted):
    """
    Permet de récupérer une liste uniquement avec les modifications

    :param added:
    :param deleted:
    :return:
    """

    # 1. Récupération des index de suppression puis des indexes d'ajouts
    deletedPaths = []
    for e in deleted:
        deletedPaths.append(e[0])

    addedPaths = []
    for e in added:
        addedPaths.append(e[0])

    # 2. Comparaison des éléments édités
    edited = []
    for e in added:
        if e[0] in deletedPaths:
            edited.append(e)

    # 3. Comparaison des éléments édités avec ancienne date
    oldEdited = []
    for e in deleted:
        if e[0] in addedPaths:
            oldEdited.append(e)

    return edited, oldEdited

def displayList(liste):
    """
    Permet d'afficher de manière plus explicite et agréable à l'heure

    :param liste: Liste à afficher
    :return: None
    """
    if liste == None:
        print("None")
    else:
        for e in liste:
            print(e)

def main(delay, watchingPath):
    """
    Fonction principale
    :param delay: temps en seconde entre chaque vérification
    """

    # 1. Récupération des fichiers actuels
    print("Lecture des fichiers...\n")
    workingList = readPath(watchingPath)
    displayList(workingList)

    # 2. Récupération des fichiers sauvegardés
    print("\n"+"-"*60+"\nLecture du fichier sauvegardé...\n")
    savedList = readList("savedList.data")
    displayList(savedList)

    # 3. Sauvegarde de l'état du fichier
    #saveFile(workingList, "savedList.data")

    print("\n"+"-"*60+"\nComparaison des deux ficiers, incluant les metadata...\n")

    added, deleted = comparaison(savedList, workingList)

    edited, oldEdited = editedFiles(added, deleted)

    print("="*100)
    displayList(edited)
    print("\n")
    displayList(oldEdited)
    print("="*100)

    print("\nFichiers et dossiers rajoutés (avant repérage des éditions) :")
    displayList(added)

    print("\nFichiers et dossiers supprimés (avant repérarage des éditions) :")
    displayList(deleted)

    print("\nFichiers édités : ")
    displayList(edited)

    added = added.difference(edited)
    deleted = deleted.difference(oldEdited)

    print("\nFichiers et dossiers rajoutés :")
    displayList(added)

    print("\nFichiers et dossiers supprimés :")
    displayList(deleted)


main(30, "C:/UwAmp/www/comparaison/t1")
