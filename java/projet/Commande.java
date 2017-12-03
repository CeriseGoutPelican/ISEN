package simulateurzytho;

import java.util.List;
import static simulateurzytho.AffichageGraphique.floatToString;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Humain.Fournisseur;

/**
 * CLASSE COMMANDE
 * ===============
 * Cette classe permet de créer une commande avec toutes les informations 
 * nécessaires
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
public class Commande {
    
    /**
     * Barman qui a passé la commande
     */
    private final Barman barman;
    
    /**
     * Fournisseur où la commande est passée
     */
    private final Fournisseur fournisseur;
    
    /**
     * Boisson à commander
     */
    private final Boisson boisson;
    
    /**
     * Quantité de boisson à commander
     */
    private final int quantite;
    
    /**
     * Etat de la livraison actuelle (True = livré, False = non livré)
     */
    private boolean etatLivraison;
    
    /**
     * Etat du payement (True = payé, False = non payé)
     */
    private boolean etatPayement;
    
    /**
     * CONSTRUCTEUR COMMANDE
     * =====================
     * Permet de construire la classe avec toutes ces caractéristiques
     * 
     * ENTREES
     * =======
     * @param barman
     *          Barman qui a passé la commande
     * @param fournisseur
     *          Fournisseur où la commande est passée
     * @param boisson
     *          Boisson à commander
     * @param quantite
     *          Quantité de boisson à commander
     * @param etatLivraison
     *          Etat de la livraison actuelle
     * @param etatPayement 
     *          Etat du payement
     */
    public Commande(Barman barman, Fournisseur fournisseur, Boisson boisson, int quantite, boolean etatLivraison, boolean etatPayement){
        this.barman = barman;
        this.fournisseur = fournisseur;
        this.boisson = boisson;
        this.quantite = quantite;
        this.etatLivraison = etatLivraison;
        this.etatPayement = etatPayement;
    }

    /**
     * ASSESSEUR GET_BARMAN
     * ====================
     * Retourne le barman ayant passé la commande
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le barman
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Barman getBarman() {
        return barman;
    }

    /**
     * ASSESSEUR GET_FOURNISSEUR
     * =========================
     * Retourne le fournisseur de la commande
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le fournisseur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     * ASSESSEUR GET_BOISSON
     * =====================
     * Retourne la boisson à commander
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la boisson
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Boisson getBoisson() {
        return boisson;
    }

    /**
     * ASSESSEUR GET_QUANTITE
     * ======================
     * Retourne la quantite de bouteilles à commander
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la quantité de bouteilles
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * ASSESSEUR GET_ETAT_LIVRAISON
     * ============================
     * Retourne l'état de la livraison
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne l'état de la livraison
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public boolean getEtatLivraison(){
        return etatLivraison;
    }

    /**
     * ASSESSEUR GET_ETAT_PAYEMENT
     * ===========================
     * Retourne l'état du payement
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne l'état du payement
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public boolean getEtatPayement(){
        return etatPayement;
    }

    /**
     * ASSESSEUR GET_PRIX
     * ==================
     * Retourne le prix de la commande
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le prix total de la commande
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public float getPrix(){
        return boisson.getPrixAchat()*quantite;
    }  
    
    /**
     * MUTATEUR SET_ETAT_LIVRAISON
     * ===========================
     * Permet de modifier l'état d'une livraison
     * 
     * ENTREES
     * =======
     * @param etat
     *          Le nouvel état de la livraison
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public void setEtatLivraison(boolean etat){
        this.etatLivraison = etat;
    }   
    
    /**
     * MUTATEUR SET_ETAT_PAYEMENT
     * ==========================
     * Permet de modifier l'état de payement d'une commande
     * 
     * ENTREES
     * =======
     * @param etat
     *          Le nouvel état du payement
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public void setEtatPayement(boolean etat){
        this.etatPayement = etat;
    }    
    
}
