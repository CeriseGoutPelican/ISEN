package simulateurzytho.Humain.Client;

import simulateurzytho.AffichageGraphique;
import simulateurzytho.Boisson;
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
public class Patron extends Homme{
    
    
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
                if(SimulateurZytho.getLiquidites() - commande.getPrix() <= 0){
                    System.out.println(AffichageGraphique.RED+"Impossible d'effectuer le payement pour cette commande ! Il n'y a pas assez d'argent sur les comptes. "+AffichageGraphique.RESET);
                } else {
                    SimulateurZytho.setLiquidites(-1*commande.getPrix());

                    // On change le statut de la commande
                    commande.setEtatPayement(true);

                    System.out.println("\nLe payement de "+AffichageGraphique.floatToString(commande.getPrix(), "0.00")+"€ pour "+commande.getFournisseur().getPrenom()+" a bien été effectué pour la commande n°"+arguments[0]+".\n" + AffichageGraphique.RESET);
                } 
            }
 
        } catch(Exception e){
            System.out.println(AffichageGraphique.RED + "La commande n'a pas été trouvée" + AffichageGraphique.RESET);  
        }

        
    }     
    
}
