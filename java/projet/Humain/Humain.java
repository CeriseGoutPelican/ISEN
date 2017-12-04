package simulateurzytho.Humain;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Arrays;
import java.util.Scanner;
import simulateurzytho.AffichageGraphique;
import simulateurzytho.Boisson;
import simulateurzytho.Humain.Client.Femme;
import simulateurzytho.Humain.Client.Homme;
import simulateurzytho.Humain.Client.Patron;
import simulateurzytho.Humain.Serveur.ServeurHomme;
import simulateurzytho.Log;
import simulateurzytho.SimulateurZytho;

/**
 * CLASSE HUMAIN
 * =============
 * Cette classe regroupe l'intégralité des carractéristiques communes de toutes
 * les personnes présentes dans le bar
 * 
 * RESUME DE CLASSE
 * ===============
 * Variables : - prenom
 *             - slug
 *             - surnom
 *             - argent
 *             - popularite
 *             - cri
 * Méthodes  : - parler()
 *             - boire()
 *             - payer()
 *             - offrirVerre()
 *             - sePresenter()
 *
 * INFORMATIONS
 * ============
 * @author Grégoire Gaonach
 * @version 1.0
 */
public class Humain {
    
    /**
     * Prénom d'un humain
     */
    private final String prenom;
    
    /**
     * Slug du prénom
     */
    private final String slug;
    
    /**
     * Surnom d'un humain
     */
    private final String surnom;
    
    /**
     * La quantité d'argent que possède un humain
     */
    private float argent;
    
    /**
     * La popularité (positive ou négative) d'un humain. Elle évolue avec les actions
     */
    private float popularite;
    
    /**
     * Le cri d'un humain correspond à ce qu'il hurle dans un moment de joie intense !
     */
    private final String cri;
    
    /**
     * CONSTRUCTEUR HUMAIN
     * ===================
     * Permet de construire la classe avec toutes ces caractéristiques
     * 
     * ENTREES
     * =======
     * @param prenom
     *          Prénom d'un humain
     * @param slug
     *          Slug du prénom
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
    public Humain(String prenom, String surnom, float argent, float popularite, String cri){
        this.prenom = prenom;
        this.slug = AffichageGraphique.slug(prenom);
        this.surnom = surnom;
        this.argent = argent;
        this.popularite = popularite;
        this.cri = cri;
    }
    
    /**
     * ASSESSEUR GET_PRENOM
     * ====================
     * Permet de récupérer le prénom d'un humain
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le prenom de l'humain
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getPrenom(){
        return prenom;
    }   

    /**
     * ASSESSEUR GET_SLUG
     * ==================
     * Retourne le slug correspondant au prénom
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
     * ASSESSEUR GET_SURNOM
     * ====================
     * Permet de récupérer le surnom d'un humain
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le surnom de l'humain
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getSurnom(){
        return surnom;
    }
        
    /**
     * ASSESSEUR GET_ARGENT
     * ====================
     * Permet de récupérer la quantité d'argent d'un humain
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la quanité d'argent de l'humain
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public float getArgent(){
        return argent;
    }
        
    /**
     * ASSESSEUR GET_POPULARITE
     * ========================
     * Permet de récupérer le niveau de popularité d'un humain
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le niveau de popularité d'un humain
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public float getPopularite(){
        return popularite;
    }
        
    /**
     * ASSESSEUR GET_CRI
     * =================
     * Permet de récupérer le cri caractéristique d'un humain
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le cri de l'humain
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getCri(){
        return cri;
    }
    
    /**
     * MUTATEUR SET_ARGENT
     * ===================
     * Permet mettre à jour la quantité d'argent d'un client, que ce soit en
     * positif ou en négatif
     * 
     * ENTREES
     * =======
     * @param argent
     *          Quantité d'argent à ajouter ou à soustraire du compte 
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public void setArgent(float argent){
        this.argent += argent;
    }
    
    /**
     * MUTATEUR SET_POPULARITE
     * =======================
     * Permet d'augmenter ou de diminuer la popularité d'un humain
     * 
     * ENTREES
     * =======
     * @param popularite
     *          Nombre de points de popularité perdu ou gagné
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */ 
    public void setPopularite(float popularite){
        this.popularite += popularite;
    }
    
    /**
     * METHODE GENERATION_PERSONNAGES
     * ==============================
     * Cette classe permet de générer de manière aléatoire un personnage, quel
     * que soit ses attributs
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
    public static void generationPersonnages(String[] arguments){
        
        try{
        
            if(!arguments[1].matches("^\\d+$") || !Arrays.asList(new String[]{"client", "cliente", "patron", "serveur", "serveuse", "barman", "fournisseur"}).contains(arguments[0])){

                System.out.println(AffichageGraphique.RED + "Le nombre de personnages à générer aléatoirement n'est pas correct OU le type de génération n'est pas bon." + AffichageGraphique.RESET);

            } else {

                // On créer autant de personnages que nécessaire
                int max = 0;
                if("patron".equals(arguments[0])){
                    max = 1;
                } else {
                    max = Integer.parseInt(arguments[1]);
                }
                for (int i = 0; i < max; i++) {

                    // Génération des caractéristiques Humain
                    // Sélection d'un prénom (musculin else feminin)
                    String cPrenom;
                    if("client".equals(arguments[0]) || "serveur".equals(arguments[0]) || "barman".equals(arguments[0]) || "patron".equals(arguments[0])){
                        cPrenom = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("prenomsGarcon"));
                    } else {
                        cPrenom = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("prenomsFille"));
                    }
                    // Sélection d'un surnom
                    String cSurnom = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("surnoms"));
                    // Sélection d'une quantité d'argent (entre 0€ et 100€)
                    float cArgent = 0 + (int)(Math.random() * 100);
                    // Sélection d'un côte de popularite (entre 0 et 20)
                    float cPopularite = 0 + (int)(Math.random() * 20);
                    // Sélection d'un cri de guerre
                    String cCri = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("cris"));

                    // Génération des caractéristiques suivant le type de création puis enregistrement
                    switch(arguments[0]){
                        case "client":
                        case "cliente":
                        case "patron":
                            // Génération d'une boisson favorite
                            Boisson cBoisson1 = SimulateurZytho.listeBoissons.get((0 + (int)(Math.random() * SimulateurZytho.listeBoissons.size())));
                            // Génération d'une boisson favorite 2
                            Boisson cBoisson2 = SimulateurZytho.listeBoissons.get((0 + (int)(Math.random() * SimulateurZytho.listeBoissons.size())));
                            // Génération d'un taux d'alcoolemie
                            float cAlcoolemie = (0 + (int)(Math.random() * 100))/10;
                            // Génération d'un niveau de regularite
                            float cRegularite = (0 + (int)(Math.random() * 50));
                            // Génération du nombre de dépenses totales (entre 0 et 50€)
                            float cTotalDepenses = (0 + (int)(Math.random() * 500))/10;
                            // Génération qualificatif serveur
                            String cQualificatif = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("qualificatifs"));

                            // Séparation client/cliente pour le dernier agument
                            if("client".equals(arguments[0]) || "patron".equals(arguments[0])){
                                // Génératio aléatoire d'un couleur de tshirt
                                String cCouleurTshirt = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("couleurs"));

                                // Séparation client/patron
                                if("client".equals(arguments[0])){
                                    SimulateurZytho.listeClients.add(new Homme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cCouleurTshirt, cQualificatif)); 
                                    System.out.println(AffichageGraphique.GREEN + "Le client n°"+i+" a bien été généré !" + AffichageGraphique.RESET);
                                } else {
                                    SimulateurZytho.patron = new Patron(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cCouleurTshirt, cQualificatif); 
                                    System.out.println(AffichageGraphique.GREEN + "Le patron généré a remplacé l'ancien patron du bar qui a quitté l'établissement en pestant !" + AffichageGraphique.RESET);
                                }
                            } else if("cliente".equals(arguments[0])) {
                                // Génération aléatoire d'un type de bijoux
                                String cBijoux = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("bijoux"));
                                SimulateurZytho.listeClients.add(new Femme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cBijoux, cQualificatif)); 
                                System.out.println(AffichageGraphique.GREEN + "La cliente n°"+i+" a.ont bien été généré !" + AffichageGraphique.RESET);
                            } 
                        break;
                        case "serveur":
                            int cBiceps = (0 + (int)(Math.random() * 50));
                            SimulateurZytho.listeServeurs.add(new ServeurHomme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBiceps));
                            System.out.println(AffichageGraphique.GREEN + "Le serveur n°"+i+" a bien été généré !" + AffichageGraphique.RESET);
                        break;
                        case "serveuse":
                            int cCharme = (0 + (int)(Math.random() * 50));
                            SimulateurZytho.listeServeurs.add(new ServeurHomme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cCharme));
                            System.out.println(AffichageGraphique.GREEN + "La serveuse n°"+i+" a bien été généré !" + AffichageGraphique.RESET);
                        break;
                        case "barman":
                            String finPhrase = "coco";
                            SimulateurZytho.listeBarmen.add(new Barman(cPrenom, cSurnom, cArgent, cPopularite, cCri, finPhrase));
                            System.out.println(AffichageGraphique.GREEN + "Le barman n°"+i+" a bien été généré !" + AffichageGraphique.RESET);
                        break;
                        case "fournisseur":
                            SimulateurZytho.listeFournisseurs.add(new Fournisseur(cPrenom, cSurnom, cArgent, cPopularite, cCri));
                            System.out.println(AffichageGraphique.GREEN + "Le fournisseur n°"+i+" a bien été généré !" + AffichageGraphique.RESET);
                        break;

                    }
                }

            }

        } catch(Exception e){
            System.out.println(AffichageGraphique.RED + "Il manque des arguments." + AffichageGraphique.RESET);
        }
         
    } 
    
    /**
     * METHODE CREATION_PERSONNAGE
     * ===========================
     * Cette classe permet de générer de manière aléatoire un personnage, quel
     * que soit ses attributs
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
    public static void creationPersonnage(String[] arguments){
        
        try{
            
            if(!Arrays.asList(new String[]{"client", "cliente", "patron", "serveur", "serveuse", "barman", "fournisseur"}).contains(arguments[0])){

                System.out.println(AffichageGraphique.RED + "Le type d'argument n'est pas bon." + AffichageGraphique.RESET);

            } else {

                Scanner input = new Scanner(System.in);

                // Génération des caractéristiques Humain
                System.out.print("Prénom ?\n> ");
                String cPrenom = input.nextLine();
                // Sélection d'un surnom
                System.out.print("Surnom ?\n> ");
                String cSurnom = input.nextLine();
                // Sélection d'une quantité d'argent (entre 0€ et 100€)
                System.out.print("Quantité d'argent (nombre décimal) ?\n> ");
                float cArgent = Float.parseFloat(input.nextLine());
                // Sélection d'un côte de popularite (entre 0 et 20)
                System.out.print("Taux de popularité (nombre décimal) ?\n> ");
                float cPopularite = Float.parseFloat(input.nextLine());
                // Sélection d'un cri de guerre
                System.out.print("Cri ?\n> ");
                String cCri = input.nextLine();

                // Génération des caractéristiques suivant le type de création puis enregistrement
                switch(arguments[0]){
                    case "client":
                    case "cliente":
                    case "patron":
                        // Génération d'une boisson favorite
                        System.out.print("Boisson favorite (Ecrire le numéro : "+Boisson.getListeBoisson()+") ?\n> ");
                        int boisson1 = Integer.parseInt(input.nextLine());
                        if(boisson1 < 0 || boisson1 > SimulateurZytho.listeBoissons.size()){
                            AffichageGraphique.clearScreen();
                            AffichageGraphique.affichageInterface(SimulateurZytho.erreur, new String[]{"Le numéro de la bière indiqué n'est pas correct !"});
                        }
                        Boisson cBoisson1 = SimulateurZytho.listeBoissons.get((0 + (int)(Math.random() * SimulateurZytho.listeBoissons.size())));
                        // Génération d'une boisson favorite 2
                        System.out.print("Boisson de secours (Ecrire le numéro : "+Boisson.getListeBoisson()+") ?\n> ");
                        int boisson2 = Integer.parseInt(input.nextLine());
                        if(boisson2 < 0 || boisson2 > SimulateurZytho.listeBoissons.size()){
                            AffichageGraphique.clearScreen();
                            AffichageGraphique.affichageInterface(SimulateurZytho.erreur, new String[]{"Le numéro de la bière indiqué n'est pas correct !"});
                        }
                        Boisson cBoisson2 = SimulateurZytho.listeBoissons.get((0 + (int)(Math.random() * SimulateurZytho.listeBoissons.size())));
                        // Génération d'un taux d'alcoolemie
                        System.out.print("Taux d'alcoolemie (nombre décimal) ?\n> ");
                        float cAlcoolemie = Float.parseFloat(input.nextLine());
                        // Génération d'un niveau de regularite
                        System.out.print("Taux de régularité (nombre décimal) ?\n> ");
                        float cRegularite = Float.parseFloat(input.nextLine());
                        // Génération du nombre de dépenses totales (entre 0 et 50€)
                        System.out.print("Dépenses total dans le bar (nombre décimal) ?\n> ");
                        float cTotalDepenses = Float.parseFloat(input.nextLine());
                        // Génération qualificatif serveur
                        System.out.print("Qualificatif (comment le personnage interpelle un.e serveur.euse ?\n> ");
                        String cQualificatif = StringUtils.capitalize(SimulateurZytho.selectionAleatoire("qualificatifs"));

                        // Séparation client/cliente pour le dernier agument
                        if("client".equals(arguments[0]) || "patron".equals(arguments[0])){
                            // Génératio aléatoire d'un couleur de tshirt
                            System.out.print("Couleur du t-shirt ?\n> ");
                            String cCouleurTshirt = input.nextLine();

                            // Séparation client/patron
                            if("client".equals(arguments[0])){
                                SimulateurZytho.listeClients.add(new Homme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cCouleurTshirt, cQualificatif)); 
                                System.out.println(AffichageGraphique.GREEN + "Le clienta bien été crée" + AffichageGraphique.RESET);
                            } else {
                                SimulateurZytho.patron = new Patron(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cCouleurTshirt, cQualificatif); 
                                System.out.println(AffichageGraphique.GREEN + "Le patron généré a remplacé l'ancien patron du bar qui a quitté l'établissement en pestant !" + AffichageGraphique.RESET);
                            }
                        } else if("cliente".equals(arguments[0])) {
                            // Génération aléatoire d'un type de bijoux
                            System.out.print("Type de bijoux ?\n> ");
                            String cBijoux = input.nextLine();
                            SimulateurZytho.listeClients.add(new Femme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBoisson1, cBoisson2, cAlcoolemie, cRegularite, cTotalDepenses, cBijoux, cQualificatif)); 
                            System.out.println(AffichageGraphique.GREEN + "La cliente a bien été crée !" + AffichageGraphique.RESET);
                        } 
                    break;
                    case "serveur":
                        System.out.print("Taille du biceps (nombre entier) ?\n> ");
                        int cBiceps = Integer.parseInt(input.nextLine());
                        SimulateurZytho.listeServeurs.add(new ServeurHomme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cBiceps));
                        System.out.println(AffichageGraphique.GREEN + "Le serveura bien été crée" + AffichageGraphique.RESET);
                    break;
                    case "serveuse":
                        System.out.print("Coefficient de charme (nombre entier) ?\n> ");
                        int cCharme = Integer.parseInt(input.nextLine());
                        SimulateurZytho.listeServeurs.add(new ServeurHomme(cPrenom, cSurnom, cArgent, cPopularite, cCri, cCharme));
                        System.out.println(AffichageGraphique.GREEN + "La serveusea bien été crée" + AffichageGraphique.RESET);
                    break;
                    case "barman":
                        String finPhrase = "coco";
                        SimulateurZytho.listeBarmen.add(new Barman(cPrenom, cSurnom, cArgent, cPopularite, cCri, finPhrase));
                        System.out.println(AffichageGraphique.GREEN + "Le barmana bien été crée" + AffichageGraphique.RESET);
                    break;
                    case "fournisseur":
                        SimulateurZytho.listeFournisseurs.add(new Fournisseur(cPrenom, cSurnom, cArgent, cPopularite, cCri));
                        System.out.println(AffichageGraphique.GREEN + "Le fournisseur a bien été crée !" + AffichageGraphique.RESET);
                    break;

                }

            }

        } catch(Exception e){
            System.out.println(AffichageGraphique.RED + "Il manque des arguments." + AffichageGraphique.RESET);
        }
         
    } 
    
    /**
     * METHODE PARLER
     * ==============
     * Cette méthode permet à un humain de parler à quelqu'un d'autre
     * 
     * ENTREES
     * =======
     * @param autreHumain 
     *          La personne à qui le personnage parle
     * 
     * SORTIES
     * =======
     * @return La phrase de présentation
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String parler(Humain autreHumain){
        // Le personnage gagne 1% de la popularité de la personne avec qui il parle
        this.setPopularite((float) (autreHumain.getPopularite()*0.01));
        
        new Log(this.getPrenom() + " parle à " + autreHumain.getPrenom()); 
        
        return SimulateurZytho.selectionAleatoire("phrases");
    }
    
    /**
     * METHODE BOIRE
     * =============
     * Cette méthode permet à un humain de boire un verre 
     * 
     * Un client peut boire de l'alcool, la fonction aura un overright
     * @See Client.boire
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
    public void boire(){
        new Log(this.getPrenom() + "A bu un verre d'eau"); 
    }
    
    /**
     * METHODE SE_PRESENTER
     * ====================
     * Cette méthode permet à un humain de se présenter à quelqu'un d'autre
     * 
     * ENTREES
     * =======
     * @param autreHumain 
     *          La personne à qui le personnage se présente
     * 
     * SORTIES
     * =======
     * @return La phrase de présentation
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String sePresenter(Humain autreHumain){
        
        new Log(this.getPrenom() + " se présente à " + autreHumain.getPrenom()); 
        
        return "Salut " + autreHumain.getPrenom() + " ! Je m'appelle " + this.prenom + ".";
    }
    
    
}
