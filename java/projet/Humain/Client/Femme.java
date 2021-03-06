package simulateurzytho.Humain.Client;

import simulateurzytho.Boisson;
import simulateurzytho.Humain.Client.Client;

/**
 * CLASSE Femme
 * ============
 * La classe homme est sous-classe dérivant de Client et de Humain
 * Elle offre de nouvelles caractéristiques
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
public class Femme extends Client{
    
    /**
     * Le type de bijoux porté par la femme
     */
    private final String bijoux;
    
    /**
     * Le qualificatif correspond à un petit mot que le client femme met à 
     * la fin de ses phrases lorsqu'il s'adresse à un serveur passé un certain
     * degré d'alcoolémie
     */
    private final String qualificatifServeur;

    /**
     * CONSTRUCTEUR HOMME
     * ==================
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
     * @param bijoux 
     *          Le type de bijoux porté par la femme
     * @param qualificatifServeur 
     *          Le petit mot utilisé par le client  femme pour s'adresser à un serveur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Femme(String prenom, String surnom, float argent, float popularite, String cri, Boisson boissonFavorite, Boisson boissonFavoriteBis, float alcoolemie, float regularite, float totalDepenses, String bijoux, String qualificatifServeur){
        super(prenom, surnom, argent, popularite, cri, boissonFavorite, boissonFavoriteBis, alcoolemie, regularite, totalDepenses);

        this.bijoux = bijoux;
        this.qualificatifServeur = qualificatifServeur;
    }
    
    /**
     * ASSESSEUR GET_BIJOUX
     * ====================
     * Retourne le type de bijoux d'une cliente
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le type de bijoux d'une cliente
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getBijoux(){
        return bijoux;
    }
    
    /**
     * ASSESSEUR GET_QUALIFICATIF SERVEUR
     * ==================================
     * Retourne le qualificatif correspond à un petit mot que le client femme 
     * met à la fin de ses phrases lorsqu'il s'adresse à un serveur passé 
     * un certain degré d'alcoolémie
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le qualificatif uniquement si le degré d'alccol est grand
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public String getQualificatifserveur(){
        if(this.getAlcoolemie() >= Client.TIPSY){
            return qualificatifServeur;
        }
        return null;
    }
    
}
