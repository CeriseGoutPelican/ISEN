/**
 * LABWORK 1 - NIVEAU M1 - ISEN LILLE
 * 
 * Ce document a été rédigé dans le cadre du cours de programmation
 * Java sous la supervision de monsieur Morelle
 * 
 * @author  Grégoire Gaonach
 * @date    21-09-2017
 * @version 0.1
 */
package pkg1.textdisplay;

/**
 * Cette classe répond à la première problématique du LW1
 *      1- TEXT DISPLAY
 * 
 * Elle permet la récupération d'arguments passés en ligne de commande
 */
public class TextDisplay {

    /**
     * Méthode principale du programme
     * 
     * @param args les variables passés en argument (array)
     */
    public static void main(String[] args) {
        
        displayArray(args);
        
    }
    
    /**
    * Cette méthode permet d'afficher dans la console les éléments
    * contenus dans une liste
    * 
    * @param array l'array que l'on souhaite afficher
    */
    public static void displayArray(String[] array) {
       
        for (String s: array) {
            System.out.printf(s + " ");
        }
        System.out.printf("\n");        
        
    }    
    
}
