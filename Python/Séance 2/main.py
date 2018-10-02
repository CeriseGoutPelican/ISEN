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
            info = os.stat(os.path.join(root, name)).st_mtime, os.path.join(root, name)
            paths.append(info)
        # Dossiers
        for name in dirs:
            info = os.stat(os.path.join(root, name)).st_mtime, os.path.join(root, name)
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
    liste1_path = list2To1(liste1, 1)
    liste2_path = list2To1(liste2, 1)

    deleted = set(liste1_path).difference(liste2_path)
    added = set(liste2_path).difference(liste1_path)

    return added, deleted

def list2To1(liste, index):
    finalList = []
    for e in liste:
        finalList.append(e[index])

    return finalList

def intersection(liste1, liste2):

    if len(liste1) < len(liste2):
        liste1, liste2 = liste2, liste1

    liste3 = []

    for i in range(len(liste1)):
        print('>'+str(i))
        print(liste1[0][0])
        if liste1[i][1] == liste2[i][1]:
            liste3.append(liste1[1])

    # [value for value in liste1 if value in liste2]
    return liste3

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

def newLog(list):
    """
    Permet d'adapter une liste à un log facile à lire
    :param list: liste 2D
    :return: liste 1D lisible par un utilisateur
    """
    print()

def main(delay):
    """
    Fonction principale qui permet de monitorer un dossier dans le temps

    :param delay: temps en seconde entre deux analyses du dossier
    :return: None
    """
    # 1. Récupération des fichiers actuels
    print("Lecture des fichiers...\n")
    workingList = readPath("C:/UwAmp/www/comparaison/t1")
    displayList(workingList)

    # 2. Récupération des fichiers sauvegardés
    print("\n"+"-"*60+"\nLecture du fichier sauvegardé...\n")
    savedList = readList("savedList.data")
    displayList(savedList)

    # 3. Création d'une liste de logs
    logs = readList("logs.data")

    # 4. Sauvegarde du log

    time.sleep(delay)

    main(delay)

# print("\n"+"-"*60+"\nSauvegarde du fichier... "  + str(saveFile(workingList, "savedList.data")))

# 1. Récupération des fichiers actuels
print("Lecture des fichiers...\n")
workingList = readPath("C:/UwAmp/www/comparaison/t1")
displayList(workingList)

# 2. Récupération des fichiers sauvegardés
print("\n"+"-"*60+"\nLecture du fichier sauvegardé...\n")
savedList = readList("savedList.data")
displayList(savedList)

print("\n"+"-"*60+"\nComparaison des deux ficiers, incluant les metadata...\n")

added = []
deleted = []
added, deleted = comparaison(savedList, workingList)

print("Fichiers et dossiers rajoutés :")
displayList(added)
print("\nFichiers et dossiers supprimés :")
displayList(deleted)
