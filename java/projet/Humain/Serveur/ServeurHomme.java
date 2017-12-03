package simulateurzytho.Humain.Serveur;

/**
 * CLASSE HOMME
 ============
 La classe ServeurHomme est sous-classe dérivant de Serveur et de Humain
 
 RESUME DE CLASSE
 ===============
 Variables : -
 Méthodes  : -

 INFORMATIONS
 ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class ServeurHomme extends Serveur{
    
    private final int tailleBiceps;
    
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
     * @param tailleBiceps 
     *          La taille du biceps d'un serveur homme
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public ServeurHomme(String prenom, String surnom, float argent, float popularite, String cri, int tailleBiceps) {
        super(prenom, surnom, argent, popularite, cri);
        
        this.tailleBiceps = tailleBiceps;
    }

    /**
     * ASSESSEUR GET_TAILLE_BICEPS
     * ===========================
     * Retourne la taille du biceps d'un serveur
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la taille du biceps d'un serveur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public int getTailleBiceps() {
        return tailleBiceps;
    }
    
}
