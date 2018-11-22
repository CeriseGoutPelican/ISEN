# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

# ----------------------------------------------
# - Importation des fichiers projet            -
# ----------------------------------------------

from access import *
from tests import *

# ----------------------------------------------
# - Tests unitaires                            -
# ----------------------------------------------

def tests_unitaires():
    """
    Inscrire simplement ici tous les tests unitaires à effectuer

    :return: rien du tout
    """
    # HTTP --------------------------------------
    test_unitaire(access, (True, True), "local.techno-web.fr", "http",  ("admin", "admin"), 200, 'Admin')
    test_unitaire(access, (True, False), "local.techno-web.fr/test.html", "http",  ("admin", "admin"), 404, "Admin")
    test_unitaire(access, (True, False), "local.techno-web.fr", "http",  ("root", "root"), 200, "Admin")
    test_unitaire(access, 'ERROR', "local.techno-web-error.fr", "http",  ("admin", "admin"), 503, "Admin")

    # HTTPS -------------------------------------
    test_unitaire(access, (True, True), "techno-web.fr", "https",  ("Gregoire.GAONACH", "azerty"), 200, "welcome Gregoire")
    test_unitaire(access, "ERROR", "bidon.techno-web.fr", "https",  ("Gregoire.GAONACH", "azerty"), 200, "welcome Gregoire")

    # FTP ---------------------------------------
    test_unitaire(access, (True, True), "ftp.dlptest.com", "ftp",  ("dlpuser@dlptest.com", "e73jzTRTNqCN9PYAAjjn"), 230)
    test_unitaire(access, "ERROR", "ftp.dlptest-error.com", "ftp",  ("dlpuser@dlptest.com", "e73jzTRTNqCN9PYAAjjn"), 230)
    test_unitaire(access, (True, True), "ftp.dlptest.com", "ftp",  ("dlpuser@dlptest.com", "bidon"), 530)

    # SFTP --------------------------------------
    test_unitaire(access, (True, True), "test.rebex.net", "sftp", ("demo", "password"), 230)
    test_unitaire(access, "ERROR", "adresse.bidon", "sftp", ("demo", "password"), 230)
    test_unitaire(access, "ERROR", "test.rebex.net", "sftp", ("demo", "bidon"), 230)

    # SSH ---------------------------------------
    test_unitaire(access, (True, True), "test.rebex.net", "ssh", ("demo", "password"), 230)
    test_unitaire(access, (False, True), "test.rebex.net", "ssh", ("demo", "bidon"), 230)
    test_unitaire(access, (False, True), "adresse.bidon", "ssh", ("demo", "password"), 230)

# ----------------------------------------------
# - Main entry                                 -
# ----------------------------------------------

start_tests(tests_unitaires)
