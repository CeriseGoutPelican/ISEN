package simulateurzytho.Humain.Client;

import simulateurzytho.Boisson;
import simulateurzytho.Humain.Humain;

/**
 * CLASSE CLIENT
 * =============
 * Un client est un humain qui peut consommer et s'amuser au bar
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
public class Client extends Humain{
    
    /**
     * CONSTANTE : degré d'alcool à partir du quel un client est pompette
     */
    public static final float TIPSY = 3;
    
    /**
     * CONSTANTE : degré d'alcool à partir du quel un client est vraiment bourré
     */
    public static final float BOURRE = 5;
    
    /**
     * La boisson favorite d'un client
     */
    private final Boisson boissonFavorite;
    
    /**
     * La boisson favorite de secours d'un client (on ne sait jamais)
     */
    private final Boisson boissonFavoriteBis;
    
    /**
     * Le taux d'alcoolémie d'un client
     */
    private float alcoolemie;
    
    /**
     * Le taux de "regularité" d'un client, plus il est élevé, plus on peut le considérer comme régulier
     */
    private float regularite;
    
    /**
     * Total des dépenses d'un client au bar. Il est souvent relié au taux d'alcoolémie
     */
    private float totalDepenses;

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
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Client(String prenom, String surnom, float argent, float popularite, String cri, Boisson boissonFavorite, Boisson boissonFavoriteBis, float alcoolemie, float regularite, float totalDepenses){
        super(prenom, surnom, argent, popularite, cri);

        this.boissonFavorite = boissonFavorite;
        this.boissonFavoriteBis = boissonFavoriteBis;
        this.alcoolemie = alcoolemie;
        this.regularite = regularite;
        this.totalDepenses = totalDepenses;
    }
    
    /**
     * ASSESSEUR GET_BOISSON_FAVORITE
     * ==============================
     * Retourne la boisson favorite d'un client
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la boisson favorite d'un client
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Boisson getBoissonfavorite(){
        return boissonFavorite;
    }
    
    /**
     * ASSESSEUR GET_BOISSON8FAVORITE_BIS
     * ==================================
     * Permet de récupérer la boisson favorite de secours d'un client
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne la boisson favorite de secours d'un client
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Boisson getBoissonfavoritebis(){
        return boissonFavoriteBis;
    }
    
    /**
     * ASSESSEUR GET_ALCOOLEMIE
     * ========================
     * Permet de récupérer le taux d'alcoolemie d'un client
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le taux d'alcoolemie d'un client
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public float getAlcoolemie(){
        return alcoolemie;
    }
    
    /**
     * ASSESSEUR GET_REGULARITE
     * ========================
     * Permet de le taux de récularité d'un client
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le taux de régularité d'un client
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public float getRegularite(){
        return regularite;
    }
    
    /**
     * ASSESSEUR GET_TOTAL_DEPENSES
     * ============================
     * Permet de récupérer le total des dépenses effectuées au bar d'un client
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le total des dépenses faites par un client
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public float getTotalDepenses(){
        return totalDepenses;
    }
    
    /**
     * MUTATEUR SET_ALCOOLEMIE
     * =======================
     * Permet d'éditer le taux d'alcoolémie d'un client
     * 
     * ENTREES
     * =======
     * @param alcoolemie 
     *          L'augmentation ou la diminution du taux d'alcoolémie d'un client
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setAlcoolemie(float alcoolemie){
        this.alcoolemie += alcoolemie;
    }  
    
    /**
     * MUTATEUR SET_TOTAL_DEPENSES
     * ===========================
     * Permet d'éditer le total des dépenses d'un client au bar 
     * 
     * ENTREES
     * =======
     * @param depenses 
     *          L'augmentation des dépenses du client au bar
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setTotalDepenses(float depenses){
        this.totalDepenses += depenses;
    }  
    
    /**
     * MUTATEUR SET_REGULARITE
     * =======================
     * Permet d'éditer la régularité de client
     * 
     * ENTREES
     * =======
     * @param regularite 
     *          L'augmentation de la régularité d'un client
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setRegularite(float regularite){
        this.regularite += regularite;
    }  
    
}
