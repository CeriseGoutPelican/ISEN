package simulateurzytho;

/**
 * CLASSE BAR
 * ==========
 * La classe donnes les principales informations du bar
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
public class Bar {
    
    /**
     * Nom du bar
     */
    private static String nom;
    
    /**
     * Liquidités totales
     */
    private float liquidites;

    /**
     * CONSTRUCTEUR BAR
     * ================
     * Permet de générer un bar
     * 
     * ENTREES
     * =======
     * @param nom
     *          Le nom du bar
     * @param liquidites 
     *          Les liquidités totales du bar
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public Bar(String nom, float liquidites) {
        this.nom = nom;
        this.liquidites = liquidites;
    }

    /**
     * ASSESSEUR GET_NOM
     * =================
     * Permet de récupérer le nom du bar
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le nom du bar
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */    
    public static String getNom() {
        return nom;
    }

    /**
     * ASSESSEUR GET_LIQUIDITES
     * ========================
     * Permet de récupérer le montant total des liquidités du bar
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne les liquidités du bar
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public float getLiquidites() {
        return liquidites;
    }

     /**
     * MUTATEUR SET_FIN_PHRASE
     * =======================
     * Permet de récupérer le mot de fin de phrase d'un barman
     * 
     * ENTREES
     * =======
     * @param liquidites 
     *          Met à jour les liquidités du bar
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void setLiquidites(float liquidites) {
        this.liquidites += liquidites;
    }
    
}
