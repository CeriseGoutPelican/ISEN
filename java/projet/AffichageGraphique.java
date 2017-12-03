package simulateurzytho;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import simulateurzytho.Humain.Barman;
import simulateurzytho.Humain.Client.Client;
import simulateurzytho.Humain.Client.Femme;
import simulateurzytho.Humain.Client.Homme;
import simulateurzytho.Humain.Client.Patron;
import simulateurzytho.Humain.Fournisseur;
import simulateurzytho.Humain.Humain;
import simulateurzytho.Humain.Serveur.Serveur;
import simulateurzytho.Humain.Serveur.ServeurFemme;
import simulateurzytho.Humain.Serveur.ServeurHomme;

/**
 * CLASSE AFFICHAGEGRAPHIQUE
 * =========================
 * Cette classe regroupe les éléments de l'interface graphique du simulateur
 * incluant les dessins en ASCII pour une facilité et une aisance d'utiliation
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
public class AffichageGraphique {
    
    // Gestion des couleurs pour la console
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");    
    
    /**
     * METHODE PRESS_ANY_KEY_TO_CONTINUE
     * =================================
     * Cette méthode permet de changer d'interface en appuyant sur n'importe
     * quelle touche du clavier
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void pressAnyKeyToContinue()
    { 
           System.out.println(" Appuyez sur une touche pour continuer...");
           try
           {
               System.in.read();
               clearScreen();
           }  
           catch(IOException e)
           {}  
    }    
    
    /**
     * METHODE CLEAR_SCREEN
     * ====================
     * Cette méthode permet de "vider" l'écran de la console afin d'afficher
     * une nouvelle interface. L'effacement n'étant pas réellement possible, 
     * on se contente de forcer le scroll
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void clearScreen() {  
        for(int i = 0; i < 30; i++)
            System.out.println("\n");
    }

    /**
     * METHODE SEPARATION
     * ==================
     * Cette méthode permet de simplement écrire une ligne de séparation dans
     * l'interface. Elle n'a pour utilité qu'esthétique.
     * 
     * ENTREES
     * =======
     * Aucune
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void separation(){
        System.out.println("+----------------------------------------------------------------------------------------------------------------------+");
    }
    
    /**
     * METHODE LIGNES
     * ==============
     * Cette méthode permet juste d'afficher des sauts de ligne.
     * Elle permet simplement d'éviter de surcharger les affichages
     * d'interface avec énormement de \n
     * 
     * ENTREES
     * =======
     * @param nbr
     *          Le nombre de lignes à sauter
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void lignes(int nbr){
        for (int i = 0; i < nbr; i++) {
            System.out.println(" ");
        }
    }
    
    /**
     * METHODE TITRE
     * =============
     * Cette méthode permet d'afficher et de mettre en forme un titre dans
     * un interface
     * 
     * ENTREES
     * =======
     * @param titre
     *          Le titre à mettre en forme et à afficher
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void titre(String titre){
        for (int i = 0; i < 60-(titre.length()/2); i++) {
            System.out.printf(" ");
        }
        System.out.printf(titre.toUpperCase());
    }
    
    /**
     * METHODE IMPORTATION_ASCII
     * =========================
     * Cette méthode permet d'importer, à partir d'un fichier .asciiART
     * un dessin à afficher
     * 
     * ENTREES
     * =======
     * @param nomFichier
     *          Le nom du fichier .asciiART à importer
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void importationASCII(String nomFichier){
        // Essai d'ouverture du fichier
        try (BufferedReader in = new BufferedReader(new FileReader("./src/simulateurzytho/files/ascii/"+nomFichier+".asciiART"))) {
            String ligne;
            // Affichage ligne par ligne
            while((ligne = in.readLine()) != null)
            {
                System.out.println(ligne);
            }
        }
        catch(IOException e)
        {
            System.out.println(RED+"Impossible d'ouvrir le fichier './src/simulateurzytho/files/ascii/"+nomFichier+".asciiART'"+RESET);
        }  
    }
    
    /**
     * METHODE AFFICHAGE_INTERFACE
     * ===========================
     * Cette méthode permet d'afficher une interface, n'importe laquelle, 
     * simplement
     * 
     * ENTREES
     * =======
     * @param interfaceActuelle 
     *          Le nom de l'interface à afficher
     * @param arguments
     *          Liste des arguments supplémentaires passés à l'interface
     * 
     * SORTIES
     * =======
     * Aucune
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    static public void affichageInterface(Interface interfaceActuelle, String[] arguments){
        // Affichage du titre
        separation();
        titre(interfaceActuelle.getNom());
        lignes(1);
        separation();
        
        // Affichage des statistiques si besoin
        float[] statistiques = SimulateurZytho.getStatistiques();
        if(statistiques.length > 0){
            System.out.printf("Argent caisse : " + YELLOW + floatToString(statistiques[0], "000") + "€" + RESET + " - ");
            System.out.printf("Argent disponible : " + YELLOW + floatToString(statistiques[1], "000") + "€" + RESET + " - ");
            System.out.printf("Nombre de clients : " + YELLOW + floatToString(statistiques[2], "000") + RESET + " - ");
            System.out.printf("Nombre de serveurs : " + YELLOW + floatToString(statistiques[3], "000") + RESET + " - ");
            System.out.printf("Stocks : " + YELLOW + floatToString(statistiques[4], "000") + RESET);
            
            lignes(2);
        }
        
        // Affichage d'une zone de dessin ASCII si demandé
        if(interfaceActuelle.getAsciiArt() != null){
            importationASCII(interfaceActuelle.getAsciiArt());
        }
        
        // Affichage de la fonction liée à l'interface si demandé
        if(interfaceActuelle.getFonctionAffichage() != null){
            fonctionUtilisation(interfaceActuelle.getFonctionAffichage(), arguments);
        }
        
        // Affichage de la navigation
        lignes(1);
        System.out.println(interfaceActuelle.displayEnfants());
        
        // Attente de l'instruction utilisateur
        separation();
        instructionUtilisateur(interfaceActuelle.getEnfants());
    }
    
    /**
     * METHODE FLOAT_TO_STRING
     * =======================
     * Cette méthode permet de passer d'un float à un string et d'imposer un 
     * format particulier
     * Par exemple avec le format "00.0" le float 2 sera écrit 02.0 et le
     * nombre 2.5 secra écrit 02.5.
     * 
     * ENTREES
     * =======
     * @param f
     *          Le nombre à traiter
     * @param format
     *          Le format souhaité sous forme "0.0"
     * 
     * SORTIES
     * =======
     * @return un string formaté sous la forme demandée
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static String floatToString(float f, String format){
        
        DecimalFormat formatter = new DecimalFormat(format);      

        return formatter.format(f);
        
    }
    
    /**
     * METHODE INSTRUCTION_UTILISATEUR
     * ===============================
     * Cette méthode permet de récupérer l'instruction entrée par un utilisateur
     * est de l'interprété correctement (changement d'interface ou alors action
     * sur une classe particulière)
     * 
     * ENTREES
     * =======
     * @param enfants
     *          L'intégralité des interfaces enfants d'une interface (navigation)
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void instructionUtilisateur(Interface[] enfants){
             
        // Demande à l'utilisateur une nouvelle interface
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
                      
        String raccourcis = input.nextLine();
        
        // On vérifie si l'utilisateur écrit des instructions supplémentaires pour une interface
        String[] parts = raccourcis.split(" ");

        Interface nextInterface = Interface.trouverInterface(enfants, parts[0]);
        
        if(nextInterface == null){
            System.out.println(RED + "Impossible de charger cette interface." + RESET);
            instructionUtilisateur(enfants);
        }

        clearScreen();
        affichageInterface(nextInterface, Arrays.copyOfRange(parts, 1, parts.length));
    }
        
    /**
     * METHODE FONCTION_UTILISATION
     * ============================
     * Cette méthode permet d'executer une fonction en particulière liée à une
     * interface donnée
     * 
     * ENTREES
     * =======
     * @param fonction
     *          Nom de la fonction à exécuter
     * @param arguments
     *          Arguments passés à la fonction
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void fonctionUtilisation(String fonction, String[] arguments){

        switch(fonction){
            case "affichageStocks":
                affichageStocks();
            break;
            case "renouvelerStocks":
                Boisson.renouvelerStocks(arguments);
            break;
            case "affichageCommandes":
                affichageCommandes();
            break;
            case "livraisonCommande":
                Fournisseur.livraisonCommande(arguments);
            break;
            case "payementCommande":
                Patron.payementCommande(arguments);
            break;
            case "affichagePersonnel":
                affichagePersonnel();
            break;
            case "affichageClients":
                affichageClients();
            break;
            case "generationPersonnages":
                Humain.generationPersonnages(arguments);
            break;
            case "creationPersonnage":
                Humain.creationPersonnage(arguments);
            break;
            case "fermerProgramme":
                System.exit(0);
            break;
            case "erreur":
                System.out.println(RED + arguments[0] + RESET);
            break;
        }
        
    }
    
    /**
     * METHODE AFFICHAGE_STOCKS
     * ========================
     * Cette méthode permet d'afficher les stocks disponibles du Zytho
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void affichageStocks(){
        
        // Création du tableau des stocks
        List boissons = SimulateurZytho.listeBoissons;
        TableList tl = new TableList(8, "#", "Nom de la boisson", "Console", "Deg. alcool", "Prix achat", "Prix vente", "Marge totale", "Quantité");
        Boisson forceBoisson;
        int i=0;for (Object boisson : boissons){
            forceBoisson = (Boisson) boisson;
            tl.addRow(
                    floatToString(i, "00"),
                    forceBoisson.getNom(), 
                    forceBoisson.getSlug(), 
                    String.valueOf(forceBoisson.getDegrealcool()), 
                    floatToString(forceBoisson.getPrixAchat(), "0.00"+"€"),
                    floatToString(forceBoisson.getPrixVente(), "0.00"+"€"),
                    floatToString(forceBoisson.getPrixVente()-forceBoisson.getPrixAchat(), "0.00"+"€"),
                    String.valueOf(forceBoisson.getQuantitedisponible()));
        i++;}
        tl.print();
        
        System.out.println("");
        
        // Création du tableau des fournisseurs
        List fournisseurs = SimulateurZytho.listeFournisseurs;
        TableList tl_2 = new TableList(3, "#", "Nom du fournisseur", "Console");
        Fournisseur forceFournisseur;
        i=0;for (Object fournisseur : fournisseurs){
            forceFournisseur = (Fournisseur) fournisseur;
            tl_2.addRow(
                    floatToString(i, "00"),
                    forceFournisseur.getPrenom(), 
                    forceFournisseur.getSlug());
        i++;}
        tl_2.print();  
        
        System.out.println("");
        
        // Création du tableau des barmen
        List barmen = SimulateurZytho.listeBarmen;
        TableList tl_3 = new TableList(3, "#", "Nom du barman", "Console");
        Barman forceBarman;
        i=0;for (Object barman : barmen){
            forceBarman = (Barman) barman;
            tl_3.addRow(
                    floatToString(i, "00"),
                    forceBarman.getPrenom(), 
                    forceBarman.getSlug());
        i++;}
        tl_3.print();     
        
        forceBoisson = (Boisson) boissons.get(0);
        forceFournisseur = (Fournisseur) fournisseurs.get(0);
        forceBarman = (Barman) barmen.get(0);
        System.out.println(PURPLE +"\nPour commander 10 " + forceBoisson.getNom() + " : 'renouveler "+forceBarman.getSlug()+" "+forceFournisseur.getSlug()+" "+forceBoisson.getSlug()+" 10'." + RESET);
                     
    }
    
    /**
     * METHODE AFFICHAGE_COMMANDES
     * ===========================
     * Cette méthode permet d'afficher les commandes et leur état
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void affichageCommandes(){
        
        // Création du tableau 
        List commandes = SimulateurZytho.listeCommandes;
        TableList tl = new TableList(9, "#", "Quantité", "Boisson", "Prix unitaire", "Passé par", "Fournisseur", "Livré ?", "Payé ?", "Total");
        Commande forceCommande;
        int i=0;for (Object commande : commandes){
            forceCommande = (Commande) commande;
            tl.addRow(
                    floatToString(i, "00"),
                    String.valueOf(forceCommande.getQuantite()),
                    forceCommande.getBoisson().getNom(),
                    floatToString(forceCommande.getBoisson().getPrixAchat(), "0.00")+"€",
                    forceCommande.getBarman().getPrenom(),
                    forceCommande.getFournisseur().getPrenom(),
                    AffichageGraphique.vraiFaux(forceCommande.getEtatLivraison()),
                    AffichageGraphique.vraiFaux(forceCommande.getEtatPayement()),
                    floatToString(forceCommande.getPrix(),"00.00")+"€");
        i++;}
        tl.print();
        
        System.out.println(PURPLE +"\nPayement commande : 'payement nbr' " + RESET + " / " + PURPLE + "Livraison commande : 'livraison nbr'" + RESET);
        
    }  
    
    /**
     * METHODE AFFICHAGE_PERSONNEL
     * ===========================
     * Cette méthode permet d'afficher l'intégralité du personnel
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void affichagePersonnel(){
                
        System.out.println(YELLOW + "PATRON (1)" + RESET);
        // Création du tableau du patron
        TableList tl = new TableList(12, "Nom", "Surnom", "Argent", "Pop.", "Cri", "Boisson 1", "Boisson 2", "Alc.", "Regt.", "Depenses", "T-shirt", "Qualif.");
            tl.addRow(
                    SimulateurZytho.patron.getPrenom(),
                    SimulateurZytho.patron.getSurnom(),
                    floatToString(SimulateurZytho.patron.getArgent(), "0.00"+"€"),
                    floatToString(SimulateurZytho.patron.getPopularite(), "0"),
                    SimulateurZytho.patron.getCri().substring(0, Math.min(SimulateurZytho.patron.getCri().length(), 7))+"...",
                    SimulateurZytho.patron.getBoissonfavorite().getNom(),
                    SimulateurZytho.patron.getBoissonfavorite().getNom(),
                    floatToString(SimulateurZytho.patron.getAlcoolemie(), "00"),
                    floatToString(SimulateurZytho.patron.getRegularite(), "00"),
                    floatToString(SimulateurZytho.patron.getTotalDepenses(), "0.00"+"€"),
                    SimulateurZytho.patron.getCouleurtshirt(),
                    SimulateurZytho.patron.getQualificatifserveur());
        tl.print();
        
       
        // Création du tableau des barmen
        List barmen = SimulateurZytho.listeBarmen;
        System.out.println(YELLOW + "\nBARMEN ("+barmen.size()+")" + RESET);
        TableList tl_2 = new TableList(7, "#", "Nom", "Surnom", "Argent", "Pop.", "Cri", "Fin phrase");
        Barman forceBarman;
        int i=0;for (Object barman : barmen){
            forceBarman = (Barman) barman;
            tl_2.addRow(
                    floatToString(i, "00"),
                    forceBarman.getPrenom(),
                    forceBarman.getSurnom(),
                    floatToString(forceBarman.getArgent(), "0.00"+"€"),
                    floatToString(forceBarman.getPopularite(), "0"),
                    forceBarman.getCri().substring(0, Math.min(forceBarman.getCri().length(), 10))+"...",
                    forceBarman.getFinPhrase());
        i++;}
        tl_2.print();
        
        // Création du tableau des serveurs
        List serveurs = SimulateurZytho.listeServeurs;
        System.out.println(YELLOW + "\nSERVEUR.EUSE.S ("+serveurs.size()+")" + RESET);
        TableList tl_3 = new TableList(7, "#", "Nom", "Surnom", "Argent", "Pop.", "Cri", "[B]iceps/[C]harme");
        ServeurHomme forceServeur;
        ServeurFemme forceServeuse;
        i=0;for (Object serveur : serveurs){
            if (serveur instanceof ServeurHomme){
                forceServeur = (ServeurHomme) serveur;
                tl_3.addRow(
                        floatToString(i, "00"),
                        forceServeur.getPrenom(),
                        forceServeur.getSurnom(),
                        floatToString(forceServeur.getArgent(), "0.00"+"€"),
                        floatToString(forceServeur.getPopularite(), "0"),
                        forceServeur.getCri().substring(0, Math.min(forceServeur.getCri().length(), 10))+"...",
                        forceServeur.getTailleBiceps() + " [B]");
            } else {
                forceServeuse = (ServeurFemme) serveur;
                tl_3.addRow(
                        floatToString(i, "00"),
                        forceServeuse.getPrenom(),
                        forceServeuse.getSurnom(),
                        floatToString(forceServeuse.getArgent(), "0.00"+"€"),
                        floatToString(forceServeuse.getPopularite(), "0"),
                        forceServeuse.getCri().substring(0, Math.min(forceServeuse.getCri().length(), 10))+"...",
                        forceServeuse.getCoefficientCharme()+" [C]");
            }
        i++;}
        tl_3.print();
            
        // Création du tableau des fournisseurs
        List fournisseurs = SimulateurZytho.listeFournisseurs;
        System.out.println(YELLOW + "\nFOURNISSEURS ("+fournisseurs.size()+")" + RESET);
        TableList tl_4 = new TableList(6, "#", "Nom", "Surnom", "Argent", "Pop.", "Cri");
        Fournisseur forceFournisseur;
        i=0;for (Object fournisseur : fournisseurs){
            forceFournisseur = (Fournisseur) fournisseur;
            tl_4.addRow(
                    floatToString(i, "00"),
                    forceFournisseur.getPrenom(),
                    forceFournisseur.getSurnom(),
                    floatToString(forceFournisseur.getArgent(), "0.00"+"€"),
                    floatToString(forceFournisseur.getPopularite(), "0"),
                    forceFournisseur.getCri().substring(0, Math.min(forceFournisseur.getCri().length(), 10))+"...");
        i++;}
        tl_4.print();  
        
        System.out.println(PURPLE +"\nGénération de N serveurs : 'generationPerso serveur N' " + RESET + " / " + PURPLE + "Création d'un serveur : 'creationPerso serveur'" + RESET);
        System.out.println(PURPLE +"Peuvent être passé en argument : client, cliente, serveur, serveuse, patron, barman, fournisseur (Un seul patron sera généré)" + RESET);
       
    }
    

    
    /**
     * METHODE AFFICHAGE_CLIENTS
     * =========================
     * Cette méthode permet d'afficher la liste des clients
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static void affichageClients(){
        
        // Création du tableau 
        List clients = SimulateurZytho.listeClients;
        System.out.println(YELLOW + "CLIENT.E.S ("+clients.size()+")" + RESET);
        TableList tl = new TableList(13, "#", "Nom", "Surnom", "Argent", "Pop.", "Cri", "Boisson 1", "Boisson 2", "Alc.", "Regt.", "Depenses", "[T]-shirt/[B]ijoux", "Qual.");
        Homme forceClient;
        Femme forceCliente;
        int i=0;for (Object client : clients){
            if (client instanceof Homme){
                forceClient = (Homme) client;
                tl.addRow(
                        floatToString(i, "00"),
                        forceClient.getPrenom(),
                        forceClient.getSurnom(),
                        floatToString(forceClient.getArgent(), "0.00"+"€"),
                        floatToString(forceClient.getPopularite(), "0"),
                        forceClient.getCri().substring(0, Math.min(forceClient.getCri().length(), 7))+"...",
                        forceClient.getBoissonfavorite().getNom(),
                        forceClient.getBoissonfavoritebis().getNom(),
                        floatToString(forceClient.getAlcoolemie(), "00"),
                        floatToString(forceClient.getRegularite(), "00"),
                        floatToString(forceClient.getTotalDepenses(), "0.00"+"€"),
                        forceClient.getCouleurtshirt()+" [T]",
                        forceClient.getQualificatifserveur());
            } else {
                forceCliente = (Femme) client;
                tl.addRow(
                        floatToString(i, "00"),
                        forceCliente.getPrenom(),
                        forceCliente.getSurnom(),
                        floatToString(forceCliente.getArgent(), "0.00"+"€"),
                        floatToString(forceCliente.getPopularite(), "0"),
                        forceCliente.getCri().substring(0, Math.min(forceCliente.getCri().length(), 7))+"...",
                        forceCliente.getBoissonfavorite().getNom(),
                        forceCliente.getBoissonfavorite().getNom(),
                        floatToString(forceCliente.getAlcoolemie(), "00"),
                        floatToString(forceCliente.getRegularite(), "00"),
                        floatToString(forceCliente.getTotalDepenses(), "0.00"+"€"),
                        forceCliente.getBijoux()+" [B]",
                        forceCliente.getQualificatifserveur());
            }
        i++;}
        tl.print();
        
        System.out.println(PURPLE +"\nGénération de N clients : 'generationPerso client N' " + RESET + " / " + PURPLE + "Création d'un client : 'creationPerso client'" + RESET);
        System.out.println(PURPLE +"Peuvent être passé en argument : client, cliente, serveur, serveuse, patron, barman, fournisseur (Un seul patron sera généré)" + RESET);
    }      
    
    /**
     * METHODE SLUG
     * ============
     * Cette méthode permet de générer et de retourner un slug façon camelCasee
     * 
     * ENTREES
     * =======
     * @param variable Variable d'entrée à normaliser
     * 
     * SORTIES
     * =======
     * @return le slug correspondant à la viariable d'entrée
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public static String slug(String variable){
        
        String finalString = "";
        // Retrait des tirets
        variable = variable.replaceAll("[\\s\\-()]", " ");
        // Retrait des caractères spéciaux
        variable = Normalizer.normalize(variable, Normalizer.Form.NFD);
        variable = variable.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        
        String[] parts = variable.split(" ");
       
        int i =0;for (String part : parts) {
            
            part = part.toLowerCase();
            
            if(i>0){
                part = part.substring(0, 1).toUpperCase() + part.substring(1);
            }
            
            finalString += part;
            
        i++;}
        
        return finalString;
        
    }   
    
    /**
     * METHODE VRAI_FAUX
     * =================
     * Retourne un string "Oui" si vrai, "Non" si faux
     * 
     * ENTREES
     * =======
     * @param bool
     *          Boolean vrai ou faux
     * 
     * SORTIES
     * =======
     * @return Oui ou Non suivant la valeur du boolean
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public static String vraiFaux(boolean bool){
        if(bool){
            return "Oui";
        } 
        return "Non";
    }
    
}
