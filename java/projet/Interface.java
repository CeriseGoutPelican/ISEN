package simulateurzytho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CLASSE INTERFACE
 * ================
 * Cette classe permet de gérer les différentes interfaces de l'application.
 * Ce n'est pas une classe d'affichage graphique mais d'organisation.
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - 
 * Méthodes  : - 
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1
 */
public class Interface{

    /**
     * Nom de l'interface
     */
    private final String nom;
    
    /**
     * Raccourcis pour accéder à l'interface : mot entré par l'utilisateur
     */
    private final String raccourcis;
    
    /**
     * Petite phrase d'instruction pour l'affichage de la navigation
     */
    private final String legende;
    
    /**
     * Petite phrase d'instruction pour l'affichage de la navigation
     */
    private final String asciiART;
    
    /**
     * Nom de la fonction à executer
     */
    private final String fonctionAffichage;
    
    /**
     * Interface parent (retour en arrière) 
     */
    private final Interface parent;
    
    /**
     * Liste des interfaces enfants (avancer dans la navigation)
     */
    private final List<Interface> enfants;

    /**
     * CONSTRUCTEUR INTERFACE
     * ======================
     * Permet de construire la classe
     * 
     * ENTREES
     * =======
     * @param nom
     *          Nom de l'interface
     * @param raccourcis
     *          Raccourcis pour accéder à l'interface : mot entré par l'utilisateur
     * @param legende
     *          Petite phrase d'instruction pour l'affichage de la navigation
     * @param asciiART 
     *          Nom du fichier .asciiART à afficher, mettre null s'il ne faut rien afficher
     * @param fonctionAffichage 
     *          Fonction à exécuter lors de l'affichage de l'interface
     * @param parent
     *          Interface parent (retour en arrière) 
     * @param enfants 
     *          Liste des interfaces enfants (avancer dans la navigation)
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Interface(String nom, String raccourcis, String legende, String asciiART, String fonctionAffichage, Interface parent, List<Interface> enfants){
        this.nom = nom;
        this.raccourcis = raccourcis;
        this.legende = legende;
        this.asciiART = asciiART;
        this.fonctionAffichage = fonctionAffichage;
        this.parent = parent;
        this.enfants = enfants = new ArrayList<>();
    }

    /**
     * ASSESSEUR GET_NOM
     * =================
     * Retourne le nom de l'interface
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le nom de l'interface
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * ASSESSEUR GET_RACCOURCIS
     * ========================
     * Retourne le mot correspondant à l'entrée que l'utilisateur doit écrire
     * pour accéder à l'interface
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le raccourcis utilisateur sous forme d'un mot
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getRaccourcis(){
        return raccourcis;
    }
    
    /**
     * ASSESSEUR GET_LEGENDE
     * =====================
     * Retourne la légende utilisée pour construire la navigation
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le légende de navigation
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getLegende(){
        return legende;
    }
        
    /**
     * ASSESSEUR GET_ASCII_ART
     * =======================
     * Retourne l'interface Ascii Art
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return chemin du fichier .asciiART 
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getAsciiArt(){
        return asciiART;
    }
        
    /**
     * ASSESSEUR GET_FONTION_AFFICHAGE
     * ===============================
     * Retourne le nom de la fonction à executer lors de l'affichage
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return chemin du fichier .asciiART 
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getFonctionAffichage(){
        return fonctionAffichage;
    }
    
    /**
     * ASSESSEUR GET_ENFANTS
     * =====================
     * Retourne l'intégralité de la navigation (les enfants) sous forme 
     * d'un string déjà formaté
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Un string formaté des enfants pour la navifation "[raccourcis] Légende [rac..."
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public Interface[] getEnfants(){
        return enfants.toArray(new Interface[enfants.size()]);
    }
    
    /**
     * MUTATEUR SET_ENFANTS
     * ====================
     * Ajoute un nouvel élément à la liste des enfants d'un élément
     * 
     * ENTREES
     * =======
     * @param nouvelEnfant 
     *          Nouvel élément enfant comme référence pour l'arbre
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setEnfants(Interface nouvelEnfant){
        this.enfants.add(nouvelEnfant);
    }
    
    /**
     * MUTATEUR SET_ENFANTS
     * ====================
     * Ajoute un nouvel élément à la liste des enfants d'un élément
     * Classe surchargée
     * @see {@link #setEnfants(Interface)}
     * 
     * ENTREES
     * =======
     * @param nouveauxEnfants 
     *          Nouveaux éléments enfant sous forme d'une liste comme référence pour l'arbre
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setEnfants(Interface[] nouveauxEnfants){
        this.enfants.addAll(Arrays.asList(nouveauxEnfants));
    }
    
    /**
     * METHODE DISPLAY_ENFANTS
     * =======================
     * Retourne l'intégralité de la navigation (les enfants) sous forme 
     * d'un string déjà formaté
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Un string formaté des enfants pour la navifation "[raccourcis] Légende [rac..."
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String displayEnfants(){
        
        String output = "";
        
        for (Interface tmp : enfants) {
            output += "[" + AffichageGraphique.YELLOW + tmp.getRaccourcis() + AffichageGraphique.RESET + "] " + tmp.getLegende() + " ";
        }
        
        return output;
    }    
    
    /**
     * METHODE TROUVER_INTERFACE
     * =========================
     * Permet de trouver la bonne interface que l'utilisateur demande avec 
     * le racourcis clavier 
     * 
     * ENTREES
     * =======
     * @param interfaces
     *          Liste des interfaces enfants dans lesquels rechercher
     * @param recherche
     *          Caractère ascii de référence à rechercher
     * 
     * SORTIES
     * =======
     * @return l'interface demandée

     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static Interface trouverInterface(Interface[] interfaces, String recherche){
        
        // Recherche l'interface demandée
        int i =0;for (Interface aInterface : interfaces) {
            if(String.valueOf(aInterface.getRaccourcis()).equals(recherche)){
                return interfaces[i];
            }
        i++;}
        
        return null;
    }

}