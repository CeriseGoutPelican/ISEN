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
    test_unitaire(access, (True, True), "local.techno-web.fr", "http",  ("admin", "admin"), 200, "Admin")
    test_unitaire(access, (True, True), "home447549752.1and1-data.host", "sftp",  ("", ""), 200, "Admin")

    u71641068

# ----------------------------------------------
# - Main entry                                 -
# ----------------------------------------------

start_tests(tests_unitaires)
