# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

import urllib3      # Pour la connexion HTTP
import certifi      # Pour la connexion HTTPS
import ftplib       # Pour la connexion FTP
import paramiko     # Pour la connexion SFTP

# ----------------------------------------------
# - Fonctions -
# ----------------------------------------------

# HTTP(S) ------------------------------------------------------------------------------
def http_check(localisation, protocol, account, expectedCode, expectedResult, port):
    """
    Permet de vérifier une URL spécifique qu'elle soit en http ou https et de vérifier
    le bon fonctionnement d'un formulaire de connexion

    :param localisation: ip ou url
    :param protocol: http ou https
    :param account: tuple avec en 0 le username et en 1 le mot de passe
    :param expectedCode: status code de retour attendu
    :param expectedResult: information dans le code attendu (html)
    :param port: (option) port de connexion
    :return:
    """

    # Connexion à la page
    http = urllib3.PoolManager(cert_reqs='CERT_REQUIRED', ca_certs=certifi.where())

    r = http.request(
        'POST',
        protocol+"://"+localisation,
        fields={"page":"login", "login": account[0], "password": account[1]})

    # Code d'erreur de la page attendu (HTTP status)
    status = True if r.status == expectedCode else False

    # On recherche un bout de texte dans le résultat qui confirme la bonne connexion
    expectedResult = False if str(r.data).find(expectedResult) == - 1 else True

    return (status, expectedResult)

# FTP ----------------------------------------------------------------------------------
def ftp_check(localisation, account, expectedCode, expectedResult, port):
    """
    Permet de vérifier une URL spécifique en ftp et de vérifier sa connexion

    :param localisation: ip ou url
    :param protocol: http ou https
    :param account: tuple avec en 0 le username et en 1 le mot de passe
    :param expectedCode: status code de retour attendu
    :param expectedResult: fichier en particulier attendu
    :param port: (option) port de connexion
    :return:
    """

   # Connexion au serveur ftp avec ftplib
    try:

        # Test de connexion
        ftp = ftplib.FTP(localisation)
        ftp.login(user=account[0], passwd=account[1])
        #ftp.cwd('/no-such-dir')

    except ftplib.all_errors as e:

        status = True if expectedCode == int(e.args[0][:3]) else False

    else:

        status = True if expectedCode == 230 else False

    finally:
        # Déconnexion FTP
        ftp.quit()

    expectedResult = True

    return (status, expectedResult)

# SFTP ---------------------------------------------------------------------------------
def sftp_check(localisation, account, expectedCode, expectedResult, port):
    """
    Permet de vérifier une URL spécifique en sftp et de vérifier sa connexion

    :param localisation: ip ou url
    :param protocol: http ou https
    :param account: tuple avec en 0 le username et en 1 le mot de passe
    :param expectedCode: status code de retour attendu
    :param expectedResult: fichier en particulier attendu
    :param port: (option) port de connexion
    :return:
    """

    # Connexion au serveur ftp avec ftplib
    try:

        # Test de connexion
        transport = paramiko.Transport((localisation, port))
        transport.connect(username = account[0], password = account[1])
        sftp = paramiko.SFTPClient.from_transport(transport)

    except paramiko.ssh_exception as e:

        status = False

    else:

        status = True if expectedCode == 230 else False

    finally:
        # Déconnexion FTP
        sftp.close()
        transport.close()

    expectedResult = True

    return (status, expectedResult)

# SSH ----------------------------------------------------------------------------------
def ssh_check(localisation, account, expectedCode, expectedResult, port):
    """
    Permet de vérifier un ip/url spécifique en ssh et de vérifier sa connexion

    :param localisation: ip ou url
    :param protocol: http ou https
    :param account: tuple avec en 0 le username et en 1 le mot de passe
    :param expectedCode: status code de retour attendu
    :param expectedResult: fichier en particulier attendu
    :param port: (option) port de connexion
    :return:
    """

    try:

        client = paramiko.SSHClient()
        client.load_system_host_keys()
        client.set_missing_host_key_policy(paramiko.WarningPolicy)

        client.connect(localisation, port=port, username=account[0], password=account[1])

    except Exception as e:
        status = False

    else:
        status = True

    finally:
        client.close()

    expectedResult = True

    return (status, expectedResult)
