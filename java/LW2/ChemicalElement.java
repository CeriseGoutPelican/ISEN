/**
 * LABWORK 2 - NIVEAU M1 - ISEN LILLE
 * 
 * Ce document a été rédigé dans le cadre du cours de programmation
 * Java sous la supervision de monsieur Morelle
 * 
 * @author  Grégoire Gaonach
 * @date    29-09-2017
 * @version 0.1
 */

package labwork2;

/**
 * Cette classe répond au premier exercice du LW1 bis
 *      1 - Tableau périodique
 */
public class ChemicalElement extends LabWork2{

    private final int    number;
    private final String name;
    private final String symbol;
    
    /**
     * Permet de définir un array de booleans donnant l'information si
     * un élément est un métal de transition ou non (grâce à l'index)
     */
    private static final boolean[] TRANSITION_METAL_ARRAY = new boolean[118];
    static{       
        for (int i = 0; i < TRANSITION_METAL_ARRAY.length; i++) {
            if ((i >= 21 && i <= 30) || (i >= 39 && i <= 48) || (i >= 72 && i <= 80) || (i >= 104 && i <= 112) || i == 57 || i == 89){
                TRANSITION_METAL_ARRAY[i] = true;
            }
        }
    }
    
    // CONSTRUCTEUR
    public ChemicalElement(int number, String name, String symbol){
        this.number   = number;
        this.name     = name;
        this.symbol   = symbol;
    }
    
    // ACCESSEURS
    public int getNumber(){
        return number;
    }
    public String getName(){
        return name;
    }
    public String getSymbol(){
        return symbol;
    }
    
    public static void main(String[] args) {
        // Construction des éléments
        ChemicalElement H  = new ChemicalElement(1,  "Hydrogène", "H");
        ChemicalElement He = new ChemicalElement(2,  "Hélium",    "He");
        ChemicalElement Li = new ChemicalElement(3,  "Lithium",   "Li");
        ChemicalElement Be = new ChemicalElement(4,  "Béryllium", "Be");
        ChemicalElement B  = new ChemicalElement(5,  "Bore",      "B");
        ChemicalElement C  = new ChemicalElement(6,  "Carbone",   "C");
        ChemicalElement N  = new ChemicalElement(7,  "Azote",     "N");
        ChemicalElement O  = new ChemicalElement(8,  "Oxygène",   "O");
        ChemicalElement F  = new ChemicalElement(9,  "Fluor",     "F");
        ChemicalElement Ne = new ChemicalElement(10, "Néon",      "Ne");
        ChemicalElement Na = new ChemicalElement(11, "Sodium",    "Na");
        ChemicalElement Mg = new ChemicalElement(12, "Magnesium", "Mg");
        ChemicalElement Al = new ChemicalElement(13, "Aluminium", "Al");
        ChemicalElement Si = new ChemicalElement(14, "Silicium",  "Si");
        ChemicalElement P  = new ChemicalElement(15, "Phosphore", "P");
        ChemicalElement S  = new ChemicalElement(16, "Soufre",    "S");
        ChemicalElement Cl = new ChemicalElement(17, "Chlore",    "Cl");
        ChemicalElement Ar = new ChemicalElement(18, "Argon",     "Ar");
        ChemicalElement K = new ChemicalElement(19,  "Potasium",   "K");
        ChemicalElement Zn = new ChemicalElement(30, "Zinc",      "Zn");
        ChemicalElement Ga = new ChemicalElement(31, "Gallium",   "Ga");
       
        System.out.println("");
        H.displayElement();
        K.displayElement();
        Zn.displayElement();
        Ga.displayElement();
    }
    
    /**
     * Cette méthode permet l'affichage d'un élément du tableau périodique avec
     * différentes informations comme son numéro atomique, son symbole, son nom
     * ou encore sa catégorie chimique.
     */
    public void displayElement(){
        System.out.println("+-----------+");
        System.out.printf("| " + this.getNumber()); blank(10-String.valueOf(this.getNumber()).length()); System.out.println("|");
        System.out.printf("|   " + this.getSymbol()); blank(8-this.getSymbol().length()); System.out.println("|");
        System.out.println("|           |");
        System.out.printf("| " + this.getName()); blank(10-this.getName().length()); System.out.println("|");
        System.out.println("+-----------+");
        String categoryName = this.categoryName();
        if (categoryName != null) {
            System.out.println("L'élément est un "+categoryName+". \n");
        } else {
            System.out.println("L'élément n'appartient à aucune grande catégorie.\n");
        }
        
    }
    
    /**
     * Cette méthode permet juste d'afficher "total" espaces blancs
     * 
     * @param total le nombre d'espace blancs souhaités
     */
    public static void blank(int total){
        for (int i = 0; i < total; i++) {
            System.out.printf(" ");
        }
    }
    
    /**
     * Méthode permettant de savoir si un élément est un alkali ou non
     * @return vrai si l'élément est un alkali
     */
    public boolean alkaliMetals(){
        switch(this.getNumber()){
            case 3:
                return true;
            case 11:
                return true;
            case 19:
                return true;
            case 37:
                return true;
            case 55:
                return true;
            case 87:
                return true;
        }
        return false;
    }
    
    /**
     * Méthode permettant de savoir si un élément est un métal de transition ou non
     * @return vrai si l'élément est un métal de transition
     */    
    public boolean transitionMetals(){             
        return TRANSITION_METAL_ARRAY[this.getNumber()];
    }
 
    /**
     * Méthode permettant de savoir si un élément est un métal pauvre ou non
     * @return vrai si l'élément est un métal pauvre
     */
    public boolean postTransitionMetals(){
        int n = this.getNumber();
        return ((n >= 30 && n <= 31) || (n >= 48 && n <= 50) || (n >= 80 && n <= 83));
    }
    
    /**
     * Méthode permettant de récupérer le nom de la grande catégorie de l'élément
     * @return un String avec le nom de la catégorie de l'élément, null s'il n'a aucune catégorie
     */
    public String categoryName(){
        if (this.alkaliMetals()){
            return "Alcalin";
        } else if (this.transitionMetals()){
            return "métal de transition";
        } else if (this.postTransitionMetals()){
            return "métal pauvre";
        }
        return null;
    }
    
}
