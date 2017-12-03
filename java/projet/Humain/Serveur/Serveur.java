package simulateurzytho.Humain.Serveur;

import simulateurzytho.Humain.Humain;

/**
 * CLASSE SERVEUR
 * ==============
 * Un serveur est un humain qui peut servir dans le bar
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : -
 * Méthodes  : -
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class Serveur extends Humain{
    
    /**
     * CONSTRUCTEUR SERVEUR
     * ====================
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
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Serveur(String prenom, String surnom, float argent, float popularite, String cri) {
        super(prenom, surnom, argent, popularite, cri);
    }
    
}
