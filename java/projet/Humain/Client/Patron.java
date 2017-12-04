package simulateurzytho.Humain.Client;

import simulateurzytho.AffichageGraphique;
import simulateurzytho.Boisson;
import simulateurzytho.Caisse;
import simulateurzytho.Commande;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Log;
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
public class Patron extends Homme{
    
    /**
     * CONSTRUCTEUR PATRON
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
     * @param boissonFavorite 
     *          La boisson favorite d'un client
     * @param boissonFavoriteBis 
     *          La boisson de favorité de secours d'un client
     * @param alcoolemie 
     *          Le taux d'alcoolémie d'un client
     * @param regularite 
     *          Le taux de régularité d'un client
     * @param totalDepenses
     *          Les dépenses totale en euro d'un client
     * @param couleurTshirt 
     *          La couleur du tshirt porté par l'homme
     * @param qualificatifServeur 
     *          Le petit mot utilisé par le client homme pour s'adresser à une serveuse 
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Patron(String prenom, String surnom, float argent, float popularite, String cri, Boisson boissonFavorite, Boisson boissonFavoriteBis, float alcoolemie, float regularite, float totalDepenses, String couleurTshirt, String qualificatifServeur) {
        super(prenom, surnom, argent, popularite, cri, boissonFavorite, boissonFavoriteBis, alcoolemie, regularite, totalDepenses, couleurTshirt, qualificatifServeur);
    }
    
    /**
     * METHODE PAYEMENT_COMMANDE
     * =========================
     * Permet de payer un fournisseur
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
    public static void payementCommande(String[] arguments){
        
        try{
            // On recherche la commande en question
            Commande commande = SimulateurZytho.listeCommandes.get(Integer.parseInt(arguments[0]));

            // On vérifie si la commande a déjà été payée
            if(commande.getEtatPayement()){
                System.out.println(AffichageGraphique.RED + "La commande n°" + arguments[0] + " a déjà été payée." + AffichageGraphique.RESET); 
            } else {
                // On met à jour les stocks
                if(SimulateurZytho.bar.getLiquidites() - commande.getPrix() <= 0){
                    System.out.println(AffichageGraphique.RED+"Impossible d'effectuer le payement pour cette commande ! Il n'y a pas assez d'argent sur les comptes. "+AffichageGraphique.RESET);
                } else {
                    SimulateurZytho.bar.setLiquidites(-1*commande.getPrix());

                    // On change le statut de la commande
                    commande.setEtatPayement(true);

                    System.out.println("\nLe payement de "+AffichageGraphique.floatToString(commande.getPrix(), "0.00")+"€ pour "+commande.getFournisseur().getPrenom()+" a bien été effectué pour la commande n°"+arguments[0]+".\n" + AffichageGraphique.RESET);
                } 
            }
 
        } catch(Exception e){
            System.out.println(AffichageGraphique.RED + "La commande n'a pas été trouvée" + AffichageGraphique.RESET);  
        }
        
    } 

     /**
     * METHODE VIDER_CAISSE
     * ====================
     * Permet de récupérer le modifier le contenu de la caisse
     * 
     * ENTREES
     * =======
     * @param barman 
     *          Le barman qui donne 
     * @param caisse
     *          La caisse à vider
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void viderCaisser(Barman barman, Caisse caisse) {
        caisse.setArgentCaisse(-1*caisse.getArgentCaisse());
        
        new Log(this.getPrenom() + "vide la caisse avec l'aide de "+ barman.getPrenom() +" pour un montant de " + caisse.getArgentCaisse() + "€");
    }
    
}
