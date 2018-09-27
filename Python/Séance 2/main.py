import os
import pickle
from datetime import datetime
import time

def readPath(folders, depth):
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

            print(name)
            print(name.count(os.sep))
            print(os.sep)

            if name.count(os.sep) >= depth:
                info = os.path.join(root, name), os.stat(os.path.join(root, name)).st_mtime
                paths.append(info)
        # Dossiers
        for name in dirs:

            print(name)
            print(name.count(os.sep))
            print(os.sep)
            
            if name.count(os.sep) >= depth:
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
    scores = []
    if os.path.getsize(fileName) > 0:
        with open(fileName, "rb") as f:
            unpickler = pickle.Unpickler(f)
            scores = unpickler.load()
    return scores

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

def category(liste, categoryName):
    liste = list(liste)
    for i in range(len(liste)):
        liste[i] = list(liste[i])
        liste[i].append(categoryName)
    return liste

def intelligibleDate(liste):
    for i in range(len(liste)):
        ts = int(liste[i][1])
        liste[i][1] = datetime.utcfromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')

    return liste

def saveLogs(logs, file = "logs.data"):
    # Sauvegarde du fichier logs
    f = open(file, "a+")
    for e in logs:
        f.write("The file '"+e[0]+"' has been " + e[2] + " the " + e[1] + "\n")
    f.close()

def watch(watchingPath, logsPath, delay = 15, depth = 5, debug = False):
    """
    Fonction principale
    :param delay: temps en seconde entre chaque vérification
    """

    # 1. Récupération des fichiers actuels
    workingList = readPath(watchingPath, depth)

    if debug:
        print("-"*60)
        print("FICHIERS ACTUELS : ")
        displayList(workingList)
        print("-"*60)

    # 2. Récupération des fichiers sauvegardés
    savedList = readList("savedList.data")

    if debug:
        print("-"*60)
        print("FICHIERS D'IL Y A " + str(delay) + "s : ")
        displayList(workingList)
        print("-"*60)

    # 3. Sauvegarde de l'état du fichier
    saveFile(workingList, "savedList.data")

    added, deleted = comparaison(savedList, workingList)
    edited, oldEdited = editedFiles(added, deleted)

    # Retraits des valeurs en double + ajout d'un élément de catégorie
    added = category(added.difference(edited), "added")
    deleted = category(deleted.difference(oldEdited), "deleted")
    edited = category(edited, "edited")

    # Merge + trie par ordre chronologique
    logs = added + deleted + edited
    logs = sorted(logs,key=lambda x: x[1])

    # timestamp to date time
    logs = intelligibleDate(logs)

    if debug:
        print("-"*60)
        print("LOGS FINAUX : ")
        displayList(logs)
        print("-"*60)
    saveLogs(logs, logsPath)

    print("\nWatching...\n")
    time.sleep(delay)
    watch(watchingPath, logsPath, delay, depth, debug)

watch("C:/UwAmp/www/comparaison/t1", "logs.data", 15, 5, True)
