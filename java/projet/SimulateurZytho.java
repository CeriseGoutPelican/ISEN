package simulateurzytho;

import java.util.ArrayList;
import java.util.List;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Humain.Fournisseur;

/**
 * CLASSE SIMULATEUR_ZYTHO
 * =======================
 * Cette classe est la seule compilée au démarage du projet via sa classe main
 * Elle ne fait rien de particulier en elle-même mais est la liaison de toutes
 * les autres classes
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - 
 * Méthodes  : - main()
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class SimulateurZytho {
    
    /**
     * Génération de l'interface d'accueil
     */
    private static Interface ACCUEIL;
    
    /**
     * Génération de l'interface de gestion des stocks
     */
    private static Interface STOCKS;
    
    /**
     * Génération de l'interface de renouvelement des stocks d'une bouteille existante
     */
    private static Interface RENOUVELER;  
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface COMMANDES; 
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface LIVRAISON_COMMANDE;  
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface PAYEMENT_COMMANDE;  
    
    /**
     * Génération de l'interface de la gestion des comptes en banque
     */
    private static Interface COMPTES;
    
    /**
     * Génération de l'interface de la gestion du personnel (barman, serveur, patron)
     */
    private static Interface PERSONNEL;
    
    /**
     * Génération de l'interface contenant la liste des clients et de sa gestion
     */
    private static Interface CLIENTS;
    
    /**
     * Liste de toutes les boissons à la carte
     */
    public static List<Boisson> listeBoissons = new ArrayList<>();
    
    /**
     * Liste de tous les barmen
     */
    public static List<Barman> listeBarmen = new ArrayList<>();
    
    /**
     * Liste de tous les fournisseurs
     */
    public static List<Fournisseur> listeFournisseurs = new ArrayList<>();
    
    /**
     * Liste de toutes les commandes
     */
    public static List<Commande> listeCommandes = new ArrayList<>();
    
    /**
     * Liquidités disponibles
     */
    private static float liquidites = 300;
        
    /**
     * METHODE MAIN
     * ============
     * Méthode principale lancée à la compilation du projet
     * 
     * ENTREES
     * =======
     * @param args
     *          Les arguments passés en entrée du projet (via la console ou autre)
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void main(String[] args) {
        
        // Génération des interfaces
        makeInterface();
        
        // Génération de la carte des boissons
        creationCarte();
        
        // Génération du staff
        generationStaff();
        
        // Affichage de l'écran d'accueil
        AffichageGraphique.affichageInterface(ACCUEIL, null);
        
    }
    
    /**
     * METHODE MAKE_INTERFACE
     * ======================
     * Cette méthode permet de générer les différentes interfaces puis de les 
     * liers avec un lien en arbre parents-enfants
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void makeInterface(){
        ACCUEIL            = new Interface("Accueil du Zytho", "accueil", "Accueil", "planZytho", null, null, null);
        STOCKS             = new Interface("Affichage des stocks", "stocks", "Stocks", null, "affichageStocks", ACCUEIL, null);
        RENOUVELER         = new Interface("Renouveler le stock d'une bouteille", "renouveler", "Renouveler le stock", null, "renouvelerStocks", STOCKS, null);
        COMMANDES          = new Interface("Liste des commandes", "commandes", "Liste des commandes", null, "affichageCommandes", STOCKS, null);
        LIVRAISON_COMMANDE = new Interface("Livraison d'une commande", "livraison", "Livraison", null, "livraisonCommande", COMMANDES, null);
        PAYEMENT_COMMANDE  = new Interface("Payement d'une commande", "payement", "Payement", null, "payementCommande", COMMANDES, null);
        COMPTES            = new Interface("Affichage du compte en banque", "comptes", "Comptes", null, null, ACCUEIL, null);
        PERSONNEL          = new Interface("Gestion du personnel", "personnel", "Gestion personnel", null, null, ACCUEIL, null);
        CLIENTS            = new Interface("Gestion des clients présents dans le bar", "clients", "Liste clients", null, null, ACCUEIL, null);
        
        ACCUEIL.setEnfants(new Interface[]{STOCKS, COMPTES, PERSONNEL, CLIENTS});
        STOCKS.setEnfants(new Interface[]{ACCUEIL, RENOUVELER, COMMANDES});
        RENOUVELER.setEnfants(new Interface[]{STOCKS, COMMANDES});
        COMMANDES.setEnfants(new Interface[]{STOCKS, PAYEMENT_COMMANDE, LIVRAISON_COMMANDE});
        LIVRAISON_COMMANDE.setEnfants(new Interface[]{COMMANDES, STOCKS});
        PAYEMENT_COMMANDE.setEnfants(new Interface[]{COMMANDES, STOCKS});
        COMPTES.setEnfants(new Interface[]{ACCUEIL});
        PERSONNEL.setEnfants(new Interface[]{ACCUEIL});
        CLIENTS.setEnfants(new Interface[]{ACCUEIL});
    } 
    
    /**
     * METHODE CREATION_CARTE
     * ======================
     * Cette méthode permet de créer toute la carte du Zytho directement à la
     * compilation
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void creationCarte() {
        Boisson tripelKarmeliet = new Boisson("Tripel Karmeliet", 1.5f, 2f, 8.4f, 20);
        Boisson kasteelRouge = new Boisson("Kasteel Rouge", 1.5f, 2f, 8f, 20);
        Boisson bush = new Boisson("Bush", 1.5f, 2f, 12f, 20);
        Boisson corbeau = new Boisson("Corbeau", 1.5f, 2f, 9f, 20);
        Boisson blancheDeNamur = new Boisson("Blanche de Namur", 1.5f, 2f, 4.5f, 20);
        Boisson paixDieu = new Boisson("Paix-Dieu", 1.5f, 2f, 10f, 20);
        Boisson chouffe = new Boisson("Chouffe", 1.5f, 2f, 8f, 20);
        Boisson eau = new Boisson("Eau", 0f, 0f, 0f, 100000000);
              
        listeBoissons.add(tripelKarmeliet);
        listeBoissons.add(kasteelRouge);
        listeBoissons.add(bush);
        listeBoissons.add(corbeau);
        listeBoissons.add(blancheDeNamur);
        listeBoissons.add(paixDieu);
        listeBoissons.add(chouffe);
    }
    
    /**
     * METHODE GENERATION_STAFF
     * ========================
     * Cette méthode permet de générer toute l'équipe du bar simplement
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void generationStaff() {
        // Liste barmen
        Barman barman1 = new Barman("Jean", "Mr. J", 20, 10, "A boire pour les assoifés !", "coco");
        listeBarmen.add(barman1);
        
        // Liste fournisseurs
        Fournisseur fournisseur1 = new Fournisseur("Maître Georges", "MG", 0, 1, "Plus de bières ? PLUS DE BIERES !");
        listeFournisseurs.add(fournisseur1);
        
        // Liste serveur.euse.s
        
        // Patron
        
        // A RETIRER !!!
        Commande nouvelleCommande = new Commande(listeBarmen.get(0), listeFournisseurs.get(0), listeBoissons.get(0), 20, false, false);
        SimulateurZytho.listeCommandes.add(nouvelleCommande);
    }
    
    /**
     * METHODE GET_STATISTIQUES
     * ========================
     * Cette méthode permet de récupérer les statistiques du Zytho
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return La liste des statistiques avec les dernières mises à jour
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static float[] getStatistiques() {  
        
        float[] statistiques = {
            0,                                  // Argent dépensé
            liquidites,                         // Argent disponible
            0,                                  // Nombre de clients
            0,                                  // Nombre de serveurs
            Boisson.getQuantiteStocks()};       // Stocks
        
        return statistiques;
    }
        
    /**
     * METHODE GET_LIQUIDITES
     * ======================
     * Cette méthode permet de récupérer les liquidités totales du Zytho
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return l'argent disponible sur les comptes
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static float getLiquidites() {  
        return liquidites;
    }    
    
    /**
     * METHODE SET_LIQUIDITES
     * ======================
     * Cette méthode permet de modifier les liquidites totales du Zytho
     * 
     * ENTREES
     * =======
     * @param modification 
     *          Nombre positif et négatif qui sera ajouté au montant des liquidités
     * 
     * SORTIES
     * =======
     * Aucune sortie 
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void setLiquidites(float modification) {  
        liquidites += modification;
    }
    
}
