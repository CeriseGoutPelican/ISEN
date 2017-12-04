package simulateurzytho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Humain.Client.Patron;
import simulateurzytho.Humain.Fournisseur;
import simulateurzytho.Humain.Serveur.ServeurFemme;
import simulateurzytho.Humain.Serveur.ServeurHomme;

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
    public static Bar bar;
    
    /**
     * Génération de l'interface d'accueil
     */
    private static Interface accueil;
    
    /**
     * Génération de l'interface de gestion des stocks
     */
    private static Interface stocks;
    
    /**
     * Génération de l'interface de renouvelement des stocks d'une bouteille existante
     */
    private static Interface renouveler;  
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface commandes; 
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface livraison_commande;  
    
    /**
     * Génération de l'interface qui liste l'intégralité des commandes
     */
    private static Interface payement_commande;  
    
    /**
     * Génération de l'interface de la gestion des comptes en banque
     */
    private static Interface comptes;
    
    /**
     * Génération de l'interface de la gestion du personnel (barman, serveur, patron)
     */
    private static Interface personnel;
    
    /**
     * Génération de l'interface contenant la liste des clients et de sa gestion
     */
    private static Interface clients;
    
    /**
     * Génération de l'interface de génération aléatoire de personnages
     */
    private static Interface generation_perso;
    
    /**
     * Génération de l'interface de création d'un personnage
     */
    private static Interface creation_perso;
    
    /**
     * Ferme le programme
     */
    private static Interface exit;
    
    /**
     * Interface d'erreyr
     */
    public static Interface erreur;
    
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
     * Liste de tous les Clients
     */
    public static List<Object> listeClients = new ArrayList<>();
    
    /**
     * Liste de tous les Serveurs
     */
    public static List<Object> listeServeurs = new ArrayList<>();
    
    /**
     * Patron du bar
     */
    public static Patron patron;
    
    /**
     * Liste de toutes les commandes
     */
    public static List<Commande> listeCommandes = new ArrayList<>();
        
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
        
        // Création du bar
        bar = new Bar("Zytho", 300);
        
        // Génération des interfaces
        makeInterface();
        
        // Génération de la carte des boissons
        creationCarte();
        
        // Génération du staff
        generationStaff();
        
        // Affichage de l'écran d'accueil
        AffichageGraphique.affichageInterface(accueil, null);
        
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
        accueil            = new Interface("Accueil : " + bar.getNom(), "accueil", "Accueil", "planZytho", null, null, null);
        stocks             = new Interface("Affichage des stocks", "stocks", "Stocks", null, "affichageStocks", accueil, null);
        renouveler         = new Interface("Renouveler le stock d'une bouteille", "renouveler", "Renouveler le stock", null, "renouvelerStocks", stocks, null);
        commandes          = new Interface("Liste des commandes", "commandes", "Liste des commandes", null, "affichageCommandes", stocks, null);
        livraison_commande = new Interface("Livraison d'une commande", "livraison", "Livraison", null, "livraisonCommande", commandes, null);
        payement_commande  = new Interface("Payement d'une commande", "payement", "Payement", null, "payementCommande", commandes, null);
        comptes            = new Interface("Affichage du compte en banque", "comptes", "Comptes", null, null, accueil, null);
        personnel          = new Interface("Gestion du personnel", "personnel", "Liste du personnel", null, "affichagePersonnel", accueil, null);
        clients            = new Interface("Gestion des clients", "clients", "Liste des clients", null, "affichageClients", accueil, null);
        generation_perso   = new Interface("Génération aléatoire d'un personnage", "generationPerso", "Génération de personnages", null, "generationPersonnages", accueil, null);
        creation_perso     = new Interface("Création d'un personnage", "creationPerso", "Création de personnages", null, "creationPersonnage", accueil, null);
        exit               = new Interface("Fermeture", "exit", "Fermer", null, "fermerProgramme", null, null);
        erreur             = new Interface("Erreur !", "exit", "Fermer", null, "erreur", null, null);
        
        accueil.setEnfants(new Interface[]{stocks, comptes, personnel, clients, exit});
        stocks.setEnfants(new Interface[]{accueil, renouveler, commandes, exit});
        renouveler.setEnfants(new Interface[]{stocks, commandes, exit});
        commandes.setEnfants(new Interface[]{stocks, payement_commande, livraison_commande, exit});
        livraison_commande.setEnfants(new Interface[]{commandes, stocks, exit});
        payement_commande.setEnfants(new Interface[]{commandes, stocks, exit});
        comptes.setEnfants(new Interface[]{accueil, exit});
        personnel.setEnfants(new Interface[]{accueil, generation_perso, creation_perso, exit});
        clients.setEnfants(new Interface[]{accueil, generation_perso, creation_perso, exit});
        generation_perso.setEnfants(new Interface[]{clients, personnel, exit});
        creation_perso.setEnfants(new Interface[]{clients, personnel, exit});
        erreur.setEnfants(new Interface[]{accueil, exit});
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
        ServeurHomme serveur1 = new ServeurHomme("Charles", "Charly", 10, 15, "Allez Charlotte !", 10);
        ServeurFemme serveur2 = new ServeurFemme("Charlotte", "Charlotte aux fraises", 10, 15, "Allez Charly !", 40);
        listeServeurs.add(serveur1);
        listeServeurs.add(serveur2);  
        
        // Patron
        patron = new Patron("Corentin", "Coco", 50, 20, "ALLEZ LES DRAKK'ISEN !", listeBoissons.get(0), listeBoissons.get(1), 0, 100, 0, "Noir", "Mon beau");      
        
        // Juste une commande de départ pour tester
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
            0,                                  // Argent caisse
            bar.getLiquidites(),                // Argent disponible
            listeClients.size(),                // Nombre de clients
            listeServeurs.size(),               // Nombre de serveurs
            Boisson.getQuantiteStocks()};       // Stocks
        
        return statistiques;
    } 
    
    /**
     * METHODE SELECTION_ALEATOIRE
     * ===========================
     * Cette méthode permet de sélectionner de manière aléatoire un ligne
     * d'un fichier texte et de la renvoyer sous forme d'une chaîne de 
     * caractères
     * 
     * ENTREES
     * =======
     * @param nomFichier
     *          Nom du document à récupérer de manière aléatoire
     * 
     * SORTIES
     * =======
     * @return La ligne sélectionnée aléatoirement
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static String selectionAleatoire(String nomFichier){
        // Essai d'ouverture du fichier
        try (BufferedReader in = new BufferedReader(new FileReader("./src/simulateurzytho/files/rand/"+nomFichier+".txt"))) {
            String ligne;
            ArrayList<String> selection = new ArrayList<>();
            // Affichage ligne par ligne
            while((ligne = in.readLine()) != null)
            {
                selection.add(ligne);
            }
            Random rand = new Random();
            int randomIndex = rand.nextInt(selection.size());
            
            return selection.get(randomIndex);
        }
        catch(IOException e)
        {
            System.out.println(AffichageGraphique.RED+"Impossible d'ouvrir le fichier './src/simulateurzytho/files/rand/"+nomFichier+".txt'"+AffichageGraphique.RESET);
            return null;
        }  
    } 
    
}
