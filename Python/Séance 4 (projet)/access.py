# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

from checks import *

# ----------------------------------------------
# - Fonctions                                  -
# ----------------------------------------------

def access(localisation, protocol, account, expectedCode, expectedResult = "", port = 22):
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

        status, expectedResult = http_check(localisation, protocol, account, expectedCode, expectedResult, port)

    # FTP ----------------------------------------------------------------------------------
    elif protocol == "ftp":

        status, expectedResult = ftp_check(localisation, account, expectedCode, expectedResult, port)

    # SFTP ---------------------------------------------------------------------------------
    # Le protocol SFTP est très différent du FTP ou même du FTPS, c'est en réalité du FTP
    # via un protocole SSH. On utilise la bibliothèque OS independant Paramiko

    elif protocol == "sftp":

        status, expectedResult = sftp_check(localisation, account, expectedCode, expectedResult, port)

    # SSH ----------------------------------------------------------------------------------
    elif protocol == "ssh":

        status, expectedResult = ssh_check(localisation, account, expectedCode, expectedResult, port)

    else:
        status = False
        expectedResult = False

    return status, expectedResult

