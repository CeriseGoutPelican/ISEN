from loggingParams import *

# ----------------------------------------------
# - Tests unitaires                            -
# ----------------------------------------------

def test_unitaire(function, retour, *args):
    """
    Permet d'effectuer un test unitaire sur une fonction par rapport à un retour attendu

    :param function: fonction à tester
    :param retour: retour attendu tel que fonction(args) == retour
    :param args: arguments à faire passer dans la fonction
    :return: bool quand à la réussite du test
    """

    global nbr_tests, nbr_erreurs
    nbr_tests += 1

    texte = str(function.__name__) + str(args)

    try:

        if(function(*args) == retour):
            logging.info("Le test unitaire s'est bien déroulé pour " + texte)
            return True
        else:
            logging.error("Le test unitaire a échoué pour " + texte)
            nbr_erreurs += 1
            return False

    except:

        if retour == "ERROR":
            logging.info("Le test unitaire s'est bien déroulé pour " + texte)
            return True
        else:
            logging.error("Le test unitaire a échoué pour " + texte)
            nbr_erreurs += 1
            return False

def start_tests(tests_unitaires):
    """
    Permet de lancer l'intégralité des tests unitaires du programme

    :return: rien du tout
    """

    logging.info("========================= DEBUT DES TESTS UNITAIRES =========================")

    global nbr_tests, nbr_erreurs
    nbr_tests   = 0
    nbr_erreurs = 0

    tests_unitaires()

    logging.info(" ")
    logging.info("Nombre de tests : "+str(nbr_tests)+" / passés : "+str(nbr_tests-nbr_erreurs)+" / erreurs : "+str(nbr_erreurs))
    logging.info("=============================================================================")
