package simulateurzytho;

import java.util.LinkedList;
import java.util.List;
import static simulateurzytho.AffichageGraphique.floatToString;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Humain.Fournisseur;

/**
 * CLASSE BOISSON
 * ==============
 * Cette classe permet la création et la mise à jour des différentes boissons
 * proposées à la carte.
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
public class Boisson{

    /**
     * Nom de la boisson
     */
    private final String nom;
    
    /**
     * Slug du nom de la boisson pour utilisation dans la console
     */
    private final String slug;
    
    /**
     * Prix d'achat de la boisson chez le fournisseur
     */
    private final float prixAchat;
    
    /**
     * Prix de vente de la boisson au Zytho
     */
    private final float prixVente;
    
    /**
     * Degré d'alcool de la boisson
     */
    private final float degreAlcool;
    
    /**
     * Quantité disponible en nombre de bouteilles
     */
    private int quantiteDisponible;
    
    /**
     * CONSTRUCTEUR BOISSON
     * ====================
     * Permet de construire la classe
     * 
     * ENTREES
     * =======
     * @param nom
     *          Nom de la boisson
     * @param prixAchat
     *          Prix d'achat de la boisson chez le fournisseur
     * @param prixVente 
     *          Prix de vente de la boisson au Zytho
     * @param degreAlcool 
     *          Degré d'alcool de la boisson
     * @param quantiteDisponible 
     *          Quantité disponible en nombre de bouteilles
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Boisson(String nom, float prixAchat, float prixVente, float degreAlcool, int quantiteDisponible){
        this.nom = nom;
        this.slug = AffichageGraphique.slug(nom);
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.degreAlcool = degreAlcool;
        this.quantiteDisponible = quantiteDisponible;
    }

    /**
     * ASSESSEUR GET_NOM
     * =================
     * Retourne le nom de la boisson
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le nom de la boisson
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getNom(){
        return nom;
    }

    /**
     * ASSESSEUR GET_SLUG
     * ==================
     * Retourne le slug correspondant au nom de la boisson
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le slug
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getSlug(){
        return slug;
    }
    
    /**
     * ASSESSEUR GET_PRIX_ACHAT
     * ========================
     * Retourne le prix de d'achat de la boisson chez le fournisseur
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le prix d'achat de la boisson chez le fournisseur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public float getPrixAchat(){
        return prixAchat;
    }
    
    /**
     * ASSESSEUR GET_PRIX_VENTE
     * ========================
     * Retourne le prix de vente
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le prix de vente de la boisson
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public float getPrixVente(){
        return prixVente;
    }
    
    /**
     * ASSESSEUR GET_DEGRE_ALCOOL
     * ==========================
     * Retourne le nom de l'interface
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le degré d'alcool présent dans la boisson
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public float getDegrealcool(){
        return degreAlcool;
    }
    
    /**
     * ASSESSEUR GET_QUANTITE_DOSPONIBLE
     * =================================
     * Retourne la quantité, en nombre de bouteilles, disponible
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return nom Le nombre de bouteilles encore disponibles à l'achat
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public int getQuantitedisponible(){
        return quantiteDisponible;
    }
    
    /**
     * METHODE GET_QUANTITE_STOCKS
     * =============================
     * Retourne la quantité totale de bières disponible dans les stocks
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return le nombre totale de bouteilles
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public static int getQuantiteStocks(){
        List boissons = SimulateurZytho.listeBoissons;
        int stocks = 0;
        
        Boisson forceBoisson;
        for (Object boisson : boissons){
            forceBoisson = (Boisson) boisson;
            stocks += forceBoisson.getQuantitedisponible();
        }
        
        return stocks;
    }
    
    /**
     * METHODE GET_LISTE_BOISSONS
     * ==========================
     * Retourne la liste des boissons sous forme 1- Boisson 1 2- Boisson 2...
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return la liste des boissons
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public static String getListeBoisson(){
        List boissons = SimulateurZytho.listeBoissons;
        String listeBoissons = "";
        
        Boisson forceBoisson;
        int i=0;for (Object boisson : boissons){
            forceBoisson = (Boisson) boisson;
            listeBoissons += i + "- " + forceBoisson.getNom() + " ";
        i++;}
        
        return listeBoissons;
    }
    
    /**
     * MUTATEUR SET_QUANTITE_DISPONIBLE
     * ================================
     * Permet de modifier le stock d'une boisson
     * 
     * ENTREES
     * =======
     * @param nbrBouteilles
     *          Le nombre de nouvelles bouteilles
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public void setQuantiteDisponible(int nbrBouteilles){
        this.quantiteDisponible += nbrBouteilles;
    }
    
    /**
     * METHODE RENOUVELER_STOCKS
     * ===========================
     * Permet de renouveler les stocks d'une boisson en particulier
     * 
     * ENTREES
     * =======
     * @param arguments
     *          Arguments sous forme d'une liste de String {nomBarman nomFournisseur nomBoisson quantite} 
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public static void renouvelerStocks(String[] arguments){
        
        if(arguments.length < 4){
            System.out.println(AffichageGraphique.RED + "Il manque des arguments pour créer une nouvelle commande." + AffichageGraphique.RESET);
        } else {
            // Recherche du barman
            Barman barman = Barman.trouverBarman(SimulateurZytho.listeBarmen, arguments[0]);

            // Recherche du fournisseur
            Fournisseur fournisseur = Fournisseur.trouverFournisseur(SimulateurZytho.listeFournisseurs, arguments[1]);

            // Recherche de la boisson
            Boisson boisson = trouverBoisson(SimulateurZytho.listeBoissons, arguments[2]);


            if(barman == null || fournisseur == null || boisson == null || !arguments[3].matches("^\\d+$")){
                System.out.println(AffichageGraphique.RED + "Impossible de passer commande avec ces arguments, merci de vérifier." + AffichageGraphique.RESET);
            } else {
                Commande nouvelleCommande = new Commande(barman, fournisseur, boisson, Integer.parseInt(arguments[3]), false, false);
                SimulateurZytho.listeCommandes.add(nouvelleCommande);

                TableList tl = new TableList(9, "#", "Quantité", "Boisson", "Prix unitaire", "Passé par", "Fournisseur", "Livré ?", "Payé ?", "Total");
                tl.addRow(
                        floatToString(SimulateurZytho.listeCommandes.size()-1, "00"),
                        String.valueOf(nouvelleCommande.getQuantite()),
                        nouvelleCommande.getBoisson().getNom(),
                        floatToString(nouvelleCommande.getBoisson().getPrixAchat(), "0.00")+"€",
                        nouvelleCommande.getBarman().getPrenom(),
                        nouvelleCommande.getFournisseur().getPrenom(),
                        AffichageGraphique.vraiFaux(nouvelleCommande.getEtatLivraison()),
                        AffichageGraphique.vraiFaux(nouvelleCommande.getEtatPayement()),
                        floatToString(nouvelleCommande.getPrix(),"00.00")+"€");
                tl.print();
            }            
        }    
        
    }
    
    /**
     * METHODE TROUVER_BOISSON
     * =======================
     * Permet de trouver un barman
     * 
     * ENTREES
     * =======
     * @param boissons
     *          Liste des boissons à rechercher
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
    public static Boisson trouverBoisson(List<Boisson> boissons, String recherche){
               
        // Recherche l'interface demandée
        int i =0;for (Boisson boisson : boissons) {
            if(String.valueOf(boisson.getSlug()).equals(recherche)){
                return boissons.get(i);
            }
        i++;}
        
        return null;
    }       

}