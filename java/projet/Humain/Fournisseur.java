package simulateurzytho.Humain;

import java.io.IOException;
import java.util.List;
import simulateurzytho.AffichageGraphique;
import simulateurzytho.Commande;
import simulateurzytho.SimulateurZytho;

/**
 * CLASSE FOURNISSEUR
 * ==================
 * Cette classe permet de définir plus spécifiquement ce qu'est un fournisseur
 * et lui donner les droits et autorisations nécessaires
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
public class Fournisseur extends Humain{
    
    /**
     * CONSTRUCTEUR FOURNISSEUR
     * ========================
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
    public Fournisseur(String prenom, String surnom, float argent, float popularite, String cri) {
        super(prenom, surnom, argent, popularite, cri);
    }
    
    /**
     * METHODE TROUVER_FOURNISSEUR
     * ===========================
     * Permet de trouver un fournisseur
     * 
     * ENTREES
     * =======
     * @param fournisseurs
     *          Liste des fournisseurs
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
    public static Fournisseur trouverFournisseur(List<Fournisseur> fournisseurs, String recherche){
        
        // Recherche l'interface demandée
        int i =0;for (Fournisseur fournisseur : fournisseurs) {
            if(String.valueOf(fournisseur.getSlug()).equals(recherche)){
                return fournisseurs.get(i);
            }
        i++;}
        
        return null;
    } 
    
    /**
     * METHODE LIVRAISON_COMMANDE
     * ==========================
     * Permet de livrer une commande
     * 
     * ENTREES
     * =======
     * @param arguments
     *          Liste des arguments passés par l'utilisateur
     * 
     * SORTIES
     * =======
     * Aucune sortie

     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void livraisonCommande(String[] arguments){
        
        // On recherche la commande en question
        try{
            Commande commande = SimulateurZytho.listeCommandes.get(Integer.parseInt(arguments[0]));
            
            // On vérifie si la commande a déjà été livrée
            if(commande.getEtatLivraison()){
                System.out.println(AffichageGraphique.RED + "La commande n°" + arguments[0] + " a déjà été livrée." + AffichageGraphique.RESET); 
            } else {
            
                // On met à jour les stocks
                commande.getBoisson().setQuantiteDisponible(commande.getQuantite());

                // On change le statut de la commande
                commande.setEtatLivraison(true);

                System.out.println(AffichageGraphique.GREEN + "\nLa commande de "+commande.getQuantite()+" "+commande.getBoisson().getNom()+" vient d'être livrée avec succès par "+commande.getFournisseur().getPrenom()+" !\n" + AffichageGraphique.RESET);

            }
      } catch(Exception e){
              System.out.println(AffichageGraphique.RED + "La commande n'a pas été trouvée" + AffichageGraphique.RESET);  
        }
  
    } 
    
}
