# ----------------------------------------------
# - Importation des bibliothèques & constantes -
# ----------------------------------------------

# ----------------------------------------------
# - Importation des fichiers projet            -
# ----------------------------------------------

from access import *
from files import *
import sys
import argparse
import os

# ----------------------------------------------
# - Point d'entrée de l'application            -
# ----------------------------------------------

def main(infos):
    print("File : ", infos)

    accesToCheck = readingFile(infos)

    # Pour tous les sites distants à tester listés dans le fichier
    for c in accesToCheck:

        c = str(c).split("|")
        l = c[0].split("://")

        localisation = l[1]
        protocol     = l[0]
        account      = c[1].split(",")
        expectedCode = c[2]
        expectedResult = c[3].rstrip()

        try:
            print(loggingAccess([localisation, account[0]], access(localisation, protocol,  account, int(expectedCode), expectedResult)))
        except Exception as e:
            print(loggingAccess([localisation, account[0]], (False, False)))

def parseargs(parser):
    """
    """
    #params
    parser.add_argument('--access', required = True, dest="access", type = str, help = 'Path to the file countaining every website, ftp, etc. to watch')

    return parser.parse_args(sys.argv[1:])

if __name__ == "__main__":
    """
    main entry
    """
    # parser
    parser = argparse.ArgumentParser(description='Process some integers.')
    args = parseargs(parser)

    # Go
    os.chdir('..')
    main(args.access)



