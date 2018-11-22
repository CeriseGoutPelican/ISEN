import os
import datetime

def readingFile(path):

    # Reading the file
    try:
        content = open(os.path.join(os.path.dirname(__file__), path), "r")
        return content.readlines()

    except Exception as e:
        print("Erreur : pas de fichier trouvé !")
        return None

def loggingAccess(test, callback):

    now = datetime.datetime.now()
    date = now.strftime("%d/%m/%Y %H:%M")

    # Tout s'est bien passé
    if callback == (True, True):
        log = "[REUSSI] ["+date+"] Connexion réussie pour l'adresse " + test[0] + " avec l'utilisateur " + test[1]
    elif callback == (False, True):
        log = "[ATTENTION] ["+date+"] Connexion réussie pour l'adresse " + test[0] + " mais erreur de connexion avec l'utilisateur " + test[1]
    else:
        log = "[ERREUR] ["+date+"] Connexion échouée pour l'adresse " + test[0] + " avec l'utilisateur " + test[1]

    return log
