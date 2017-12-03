package simulateurzytho.Humain.Serveur;

/**
 * CLASSE FEMME
 ============
 La classe ServeurFemme est sous-classe dérivant de Serveur et de Humain
 
 RESUME DE CLASSE
 ===============
 Variables : -
 Méthodes  : -

 INFORMATIONS
 ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class ServeurFemme extends Serveur{
    
    private final int coefficientCharme;
    
    /**
     * CONSTRUCTEUR HOMME
     * ==================
     * Permet de construire la classe avec toutes ces caractéristiques
     * 
     * ENTREES
     * =======
     * @param prenom
     *          Prénom d'un humain
     * @param surnom
     *          Surnom d'un humain
     * @param argent
     *          La quantité d'argent que possède un humain
     * @param popularite
     *          La popularité (positive ou négative) d'un humain. Elle évolue avec les actions
     * @param cri 
     *          Le cri d'un humain correspond à ce qu'il hurle dans un moment de joie intense 
     * @param coefficientCharme 
     *          Le coeff de charme d'une serveuse
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public ServeurFemme(String prenom, String surnom, float argent, float popularite, String cri, int coefficientCharme) {
        super(prenom, surnom, argent, popularite, cri);
        
        this.coefficientCharme = coefficientCharme;
    }

    /**
     * ASSESSEUR GET_COEFFICIENT_CHARME
     * ================================
     * Retourne le coef de charme d'une serveuse
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le coefficient de charme d'une serveuse
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public int getCoefficientCharme() {
        return coefficientCharme;
    }
    
}
