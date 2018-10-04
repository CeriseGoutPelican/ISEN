# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

# ----------------------------------------------
# - Importation des fichiers projet            -
# ----------------------------------------------

from exo1 import *
from exo2 import *
from tests import *

# ----------------------------------------------
# - Tests unitaires                            -
# ----------------------------------------------

def tests_unitaires():
    """
    Inscrire simplement ici tous les tests unitaires à effectuer

    :return: rien du tout
    """
    test_unitaire(analyse_texte, ('t', 'hello', 3.0), 'hello', 2.234, 't')
    test_unitaire(analyse_texte, ('JE', 'moutarde', 5.0), 'ici', 'JE', 'assez', 13, 'salsifi', 'moutarde', -2.87, True)
    test_unitaire(analyse_texte, "ERROR", -1)
    test_unitaire(analyse_texte, "ERROR")

    test_unitaire(creer_index, {'ami': 4, 'ton': 3, 'est': 2, 'un': 1, 'tonton': 1, 'mon': 1, 'et': 1, 'de': 1}, "ton tonton est ton ami et un ami de ton ami est mon ami")
    test_unitaire(creer_index, {'ami': 4, 'ton': 3, 'est': 2}, "ton tonton est ton ami et un ami de ton ami est mon ami", 3)
    test_unitaire(creer_index, "ERROR")
    test_unitaire(creer_index, "ERROR", 241)
    test_unitaire(creer_index, "ERROR", "ton tonton est ton ami et un ami de ton ami est mon ami", "test")


# ----------------------------------------------
# - Main entry                                 -
# ----------------------------------------------

start_tests(tests_unitaires)
