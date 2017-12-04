
package simulateurzytho;

import simulateurzytho.Humain.Client.Patron;

/**
 * CLASSE CAISSE
 * ============
 * La classe caisse contient l'argent payé par les clients mis dans la caisse
 * par le barman
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
public class Caisse {
    
    private int argentCaisse;

    /**
     * CONSTRUCTEUR CAISSE
     * ===================
     * Permet de construire la caisse
     * 
     * ENTREES
     * =======
     * @param argentCaisse 
     *          L'argent total contenu dans la caisse
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Caisse(int argentCaisse) {
        this.argentCaisse = argentCaisse;
    }

    /**
     * ASSESSEUR GET_ARGENT_CAISSE
     * ===========================
     * Permet de récupérer le nom du bar
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le montant de la caisse
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */  
    public int getArgentCaisse() {
        return argentCaisse;
    }

     /**
     * MUTATEUR SET_ARGENT_CAISSE
     * ==========================
     * Permet de récupérer le modifier le contenu de la caisse
     * 
     * ENTREES
     * =======
     * @param argentCaisse  
     *          L'argent à mettre à jour dans la caisse (négatif pour retirer, positif)
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setArgentCaisse(int argentCaisse) {
        this.argentCaisse += argentCaisse;
    }   
    
}
