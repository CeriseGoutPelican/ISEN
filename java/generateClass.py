import sys

className = "Client"
extend    = "Humains"
extendedVar = [["String", "prenom"], 
               ["String","surnom"], 
               ["float", "porteMonnaie"], 
               ["float", "popularite"], 
               ["String", "cri"]]
variables   = [["String", "boissonFavorite"], 
               ["String","boissonFavoriteBis"], 
               ["float", "alcoolemie"], 
               ["float", "estRegulier"], 
               ["float", "totalDepense"]]

# Commentaire ------------------------------------------------------------------
print "/**"
print " * Description"
print " * "
print " * @author Gregoire Gaonach"
print " * @version 0.1"
print " */"

# Creation de la classe --------------------------------------------------------
print "public class " + className + (" extends " + extend if len(extend) > 0 else "") + "{"

print ""

# Definition des variables -----------------------------------------------------
for i in variables:
    print "    private " + i[0] + " " + i[1] + ";"
    
# Constructeur -----------------------------------------------------------------
print("\n    // CONSTRUCTEURS")
sys.stdout.write('    public ' + className + "(")

# Variables de la classe mere
if len(extend) > 0:
    for i in extendedVar:
        sys.stdout.write(i[0] + " " + i[1] + ", ")
    
for i in variables:
    sys.stdout.write(i[0] + " " + i[1] + (", " if i[1] != variables[-1][1] else ""))
sys.stdout.write('){\n')

# Super de la classe mere
if len(extend) > 0:
    sys.stdout.write("        super(")
    for i in extendedVar:
        sys.stdout.write(i[1] + (", " if i[1] != extendedVar[-1][1] else ""))
    print ");\n"
    
for i in variables:
    print "        this." + i[1] + " = " + i[1] + ";"
    
print "    }"

# Assesseurs -------------------------------------------------------------------
print("\n    // ASSESSEURS")
for i in variables:
    print "    public " + i[0] + " get" + i[1].title() + "(){"
    print "        return " + i[1] + ";"
    print "    }"

print "\n}"
