package simulateurzytho.Humain;

import simulateurzytho.AffichageGraphique;
import simulateurzytho.Interface;

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
        this.popularite = 0;
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
        this.argent = argent;
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
        this.popularite = popularite;
    }
    
}
