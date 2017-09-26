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
package orientationtuning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cette classe répond à la cinquième et dernière problématique du LW1
 *      5- ORIENTATION TUNING
 * 
 * Elle permet de compter le nombre d'occurence d'un chiffre avec différentes
 * options qui peuvent être pris en paramètre
 * 
 * Ex : -v 7 5 6 9 8 5 5 3 3 8 5 6 -s + -o v
 */
public class OrientationTuning {

    // Variables d'instances
    String symbol    = "*";
    boolean vertical = true;
    int[] count      = new int[10];
        
    /**
     * Méthode principale du programme
     * 
     * @param args les variables passés en argument (array)
     */
    public static void main(String[] args) {
        
        OrientationTuning firstInstance = new OrientationTuning();
        
        // 1- On lit les arguments en entrée 
        // 2- s'il manque les arguments de "-v" on les demande un à un
        firstInstance.tuning(args);
        
        // 2- On affiche le résultat
        firstInstance.displayChart();
    }
    
    /**
     * Cette méthode permet d'afficher le graphique de manière
     * soit vérticale soit horizontale selon le paramètre vertical
     */
    public void displayChart() {
       
        if (vertical){
            
            // Une boucle par ligne en commençant par la première
            for (int i = maxArrayValue(count); i > 0; i--) {
                // On boucle pour chacune des variables
                for (Integer y: count){
                    // Si la ligne doit avoir un élément
                    if (y >= i){
                        System.out.printf(" " + symbol);
                    } else {
                        System.out.printf("  ");
                    }
                }
                System.out.println("");
            }
            System.out.printf(" ");
            for (int i = 0; i < 10; i++) {
                System.out.printf(i + " ");
            }
            System.out.println("");
            
        } else {
            
            int index=0; for (Integer i: count) {
                System.out.printf(index + " ");
                // Le symbole pour le chart 
                for (int y = 0; y < i; y++) {
                    System.out.printf(symbol + " ");
                }
                System.out.println(" ");
                index++;
            }
            
        }       
        
    }
    
    /**
    * Cette méthode permet de connaître la valeur maximum d'un array
    * 
    * @param array l'array à vérifier
    * @return la valeur maximum
    */
    public static int maxArrayValue(int[] array){
        int max = 0;
        for (int counter = 1; counter < array.length; counter++)
        {
             if (array[counter] > max)
             {
                max = array[counter];
             }
        }
        return max;
    }
    
    /**
    * Cette méthode permet de traiter les variables passées en argument 
    * du main avec deux instructions particulières :
    * -v pour la chaîne principale des arguments
    * -s pour le symbole du graphique 
    * -o l'orientation du graphique
    * 
    * @param args l'array entré par l'utilisateur
    */
    public void tuning(String[] args) {
        
        // 0- Innitialisation
        String currentArg = null;
        
        // 1- On sépare les différents arguments
        
        for (String s: args){
            
            // V pour valeur
            if (s.equals("-v"))
                currentArg = "-v";
            // S pour symbole
            else if (s.equals("-s"))
                currentArg = "-s";
            else if (s.equals("-o"))
                currentArg = "-o";
                                   
            // V pour valeur
            if (currentArg != null && currentArg.equals("-v") && !s.equals("-v")){
                int i = Integer.parseInt(s);
                if (i >= 0 && i <= 9) {
                    count[i]++;
                }
            }
            // S pour symbole
            else if (currentArg != null && currentArg.equals("-s") && !s.equals("-s")){
                this.symbol = s;
                currentArg = null;
            }
            // O pour orientation
            else if (currentArg != null && currentArg.equals("-o") && !s.equals("-o")){
                this.vertical = !s.equals("h");
                currentArg = null;
            }
            
        }
        
        // S'il n'y a pas d'arguement inséré
        if(maxArrayValue(count) == 0)
            this.waitingInput();
        
    }
    
    /**
    * Cette méthode permet de retourner de compléter l'array de comptage
    * et est appelé si aucun argument -v n'est passé en entrée
    */
    public void waitingInput(){
      
        System.out.println("\nAucun argument passé en entrée, merci d'en inscrire : ");            

        String arg = "default"; 
        while(!arg.isEmpty()){
            Scanner input = new Scanner(System.in);
            arg = input.nextLine();

            // Permet d'éviter l'entrée d'un argument vide
            if(!arg.isEmpty()){
                int i = Integer.parseInt(arg);
                if (i >= 0 && i <= 9) {
                    count[i]++;
                }
            }
        }
    
    }
    
}
