# Séance 3 : Python

Description de l'ensemble des fichiers présents dans le dossier

| Nom du fichier   | Description du fichier                                                                                      |
|------------------|-------------------------------------------------------------------------------------------------------------|
| exo1.py          | Fonction correspondant à l'exercice n°1                                                                     |
| exo2.py          | Fonction correspondant à l'exercice n°2                                                                     |
| loggingParams.py | Paramètres par défaut pour bien configurer le logging                                                       |
| main.py          | Point d'entrée du programme, là où sont démarrés les tests unitaires et où sont appelés les autres fichiers |
| tests.py         | Fichier avec les fonctions pour la bonne gestion des tests unitaires                                        |

Retour de la console au démarage du fichier main.py :

```
04/10/2018 18:13:20 -     INFO : 3.6.6 (v3.6.6:4cf1f54eb7, Jun 27 2018, 03:37:03) [MSC v.1900 64 bit (AMD64)]
04/10/2018 18:13:20 -     INFO : ========================= DEBUT DES TESTS UNITAIRES =========================
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour analyse_texte('hello', 2.234, 't')
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour analyse_texte('ici', 'JE', 'assez', 13, 'salsifi', 'moutarde', -2.87, True)
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour analyse_texte(-1,)
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour analyse_texte()
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour creer_index('ton tonton est ton ami et un ami de ton ami est mon ami',)
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour creer_index('ton tonton est ton ami et un ami de ton ami est mon ami', 3)
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour creer_index()
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour creer_index(241,)
04/10/2018 18:13:20 -     INFO : Le test unitaire s'est bien déroulé pour creer_index('ton tonton est ton ami et un ami de ton ami est mon ami', 'test')
04/10/2018 18:13:20 -     INFO :  
04/10/2018 18:13:20 -     INFO : Nombre de tests : 9 / passés : 9 / erreurs : 0
04/10/2018 18:13:20 -     INFO : =============================================================================

Process finished with exit code 0

```
