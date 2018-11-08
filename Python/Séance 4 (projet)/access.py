# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

import urllib3
import ftplib

# ----------------------------------------------
# - Fonctions -
# ----------------------------------------------

def access(localisation, protocol, account, expectedCode, expectedResult):
    """
    Permet d'accéder à une machine distante à l'aide de différents protocoles comme HTTP(S), (S)FTP et SSH

    :param localisation: Localisation (IP/Adresse) de la machine distante
    :param protocol: type de protocole à utiliser (HTTP.S, S.FTP, SSH)
    :param account: tuple nom d'utilisateur / mot de passe
    :param expectedCode: code de retour du serveur (ex: 2xx pour un serveur)
    :param expectedResult: chaine de caractère à vérifier dans le retour

    :return: un tuple de booleans (Si l'expectedCode est bon, si l'expectedResult est bon)
    """

    # Switch des protocoles
    # HTTP(S) ------------------------------------------------------------------------------
    if protocol == "http" or protocol == "https":

        # Connexion à la page
        http = urllib3.PoolManager()

        r = http.request(
            'POST',
            protocol+"://"+localisation,
            fields={"page":"login", "login": account[0], "password": account[1]})

        # Code d'erreur de la page attendu (HTTP status)
        status = True if r.status == expectedCode else False

        # On recherche un bout de texte dans le résultat qui confirme la bonne connexion
        expectedResult = False if str(r.data).find(expectedResult) == - 1 else True

    # (S)FTP -------------------------------------------------------------------------------
    elif protocol == "ftp" or protocol == "sftp":


        status = False
        expectedResult = False

    # SSH ----------------------------------------------------------------------------------
    elif protocol == "ssh":
        status = False
        expectedResult = False

    return status, expectedResult

