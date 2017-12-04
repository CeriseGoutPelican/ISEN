package simulateurzytho;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * CLASSE LOG
 * ==========
 * La classe log permet de garder une trace de toutes les actions qui ont 
 * été faite dans le bar par les Humain la composant et de suivre l'avancée 
 * de la vie du bar
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
public final class Log {
    
    /**
     * Date du log
     */
    private final String date;
    
    /**
     * Texte du log
     */
    private final String texte;
    
    /**
     * CONSTRUCTEUR LOG
     * ================
     * Permet de construire un fichier log
     * 
     * ENTREES
     * =======
     * @param texte 
     */
    public Log(String texte){
        
        // Génération de la date et heure :
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        // Construction
        this.date = sdf.format(cal.getTime());
        this.texte = texte;
        
        // Ajout au fichier log
        ecritureLog(getFullLog());
    }
    
    /**
     * ASSESSEUR GET_FULL_LOG
     * ======================
     * Permet de récupérer une ligne du log
     * 
     * ENTREES
     * =======
     * Aucune entrée
     * 
     * SORTIES
     * =======
     * @return Retourne le mot de fin de phrase d'un serveur
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public String getFullLog(){
        return "["+this.date+"] " + this.texte;
    }
    
    /**
     * ASSESSEUR ECRITURE_LOG
     * ======================
     * Permet d'écrire une nouvelle ligne dans le fichier log
     * 
     * ENTREES
     * =======
     * @param ligne
     *          La ligne à ajouter au fichier log
     * 
     * SORTIES
     * =======
     * Aucune sortie
     * 
     * INFORMATIONS
     * ============
     * @since 1.0
     */
    public void ecritureLog(String ligne){
        try(PrintWriter output = new PrintWriter(new FileWriter("./src/simulateurzytho/files/log.txt",true))) 
        {
            output.printf("%s\r\n", ligne);
        } 
        catch (Exception e) {}
    }
    
}
