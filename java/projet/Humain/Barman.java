package simulateurzytho.Humain;

import java.util.List;
import simulateurzytho.Boisson;
import simulateurzytho.Humain.Client.Client;
import simulateurzytho.Humain.Serveur.Serveur;

/**
 * CLASSE BARMAN
 * =============
 * Cette classe permet de définir les caractéristiques d'un barman
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
public class Barman extends Humain{

    /**
     * La fin de phrase du barman
     */
    private final String finPhrase;
    
    /**
     * CONSTRUCTEUR HUMAIN
     * ===================
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
     * @param finPhrase
     *          La fin de phrase d'un barman
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Barman(String prenom, String surnom, float argent, float popularite, String cri, String finPhrase) {
        super(prenom, surnom, argent, popularite, cri);
        
        this.finPhrase = finPhrase;
    }

    /**
     * ASSESSEUR GET_FIN_PHRASE
     * ========================
     * Permet de récupérer le mot de fin de phrase d'un barman
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le mot de fin de phrase d'un serveur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getFinPhrase() {
        return finPhrase;
    }
    
    /**
     * METHODE PASSER_COMMANDE
     * =======================
     * Le Barman est le seul pouvant passer commande à un fournisseur
     * 
     * ENTREES
     * =======
     * @param fournisseur 
     *          Le fournisseur à qui envoyer la commande
     * @param boisson
     *          La boisson à commander
     * @param quantite 
     *          La quantité de boisson
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void passerCommande(Fournisseur fournisseur, Boisson boisson, int quantite){
        
    }
    
    /**
     * METHODE RECEVOIR_ARGENT
     * =======================
     * Le Barman est le seul pouvant recevoir l'argent d'un client ou d'un serveur
     * 
     * ENTREES
     * =======
     * @param client 
     *          Client qui lui donne de l'argent
     * @param  argent
     *          L'argent donné par le client
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void recevoirArgent(Client client, int argent){
        
    }    
    
    /**
     * METHODE RECEVOIR_ARGENT
     * =======================
     * Le Barman est le seul pouvant recevoir l'argent d'un client ou d'un serveur
     * Overload de la fonction précédent (qui utilise client)
     * 
     * ENTREES
     * =======
     * @param serveur 
     *          Serveur qui lui donne de l'argent
     * @param  argent
     *          Serveur donné par le client
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void recevoirArgent(Serveur serveur, int argent){
        
    }
    
    /**
     * METHODE TROUVER_BARMAN
     * ======================
     * Permet de trouver un barman
     * 
     * ENTREES
     * =======
     * @param barmen
     *          Liste des barmen
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
    public static Barman trouverBarman(List<Barman> barmen, String recherche){
        
        // Recherche l'interface demandée
        int i =0;for (Barman barman : barmen) {
            if(String.valueOf(barman.getSlug()).equals(recherche)){
                return barmen.get(i);
            }
        i++;}
        
        return null;
    }    
    
}
