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
package symboltuning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Cette classe répond à la quatrième problématique du LW1
 *      4- SYMBOL TUNING
 * 
 * Elle permet de compter avec des étoiles le nombre d'occurence 
 * d'un nombre passé en argument tout en rajoutant la possibilité
 * de rajouter des entrées manuellement si elles n'existent pas
 */
public class SymbolTuning {
    
    public String symbolChar = "*";

    /**
     * Méthode principale du programme
     * 
     * @param args les variables passés en argument (array)
     */
    public static void main(String[] args) {
                
        SymbolTuning test = new SymbolTuning();
        
        // Traitement des arguments
        args = test.parsingArgs(args);
        
        System.out.println("\nParamètres d'entrée : ");
        displayArray(args);
        
        System.out.println("Paramètres filtrés :");
        Integer[] filteredArgs = StringArrayToInt(args);
        Arrays.sort(filteredArgs);
        displayArray(filteredArgs);
        
        System.out.println("Nombre de récurences :");
        int[][] sortedArgs = CountDuplicate(filteredArgs);
        for (int[] i : sortedArgs){
            System.out.printf(i[0] + " ");
            for(int y=0; y < i[1]; ++y){
                System.out.printf("*");
            }
            System.out.println(" ");
        }
        
    }
    
    /**
     * Méthode permettant de retirer tout ce qui n'est pas un nombre
     * dans un array passé en argument
     * 
     * @param array l'array que l'on souhaite afficher
     * @return un array sans aucune lettre ou caractère différent d'un int
     */
    public static Integer[] StringArrayToInt(String[] array) {
        List<Integer> list = new ArrayList<>();

        for (String s: array){
            
            // On retire les éléments qui ne sont pas des chiffres
            boolean isNumeric = s.chars().allMatch(Character::isDigit);
            if (isNumeric){
                list.add(Integer.parseInt(s));
            }

        }
        
        // Permet de retourner un array sans avoir d'éléments en trop
        Integer[] finalArray = list.toArray(new Integer[0]);

        return finalArray;
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
    // Overload pour passer un int également
    public static void displayArray(Integer[] array) {
       
        for (Integer s: array) {
            System.out.printf(s + " ");
        }
        System.out.printf("\n");
    
    }
    
    /**
    * Cette méthode permet de retourner un array 2D contenant à la fois
    * l'élément récurent et son nombre de récurence dans la liste
    * 
    * @param array l'array que l'on souhaite trier
    * @return array 2D le nombre avec son nombre de récurence 
    */
    public static int[][] CountDuplicate(Integer[] array){
        
        // Transformation de l'array en list pour pouvoir utiliser Collections
        List<Integer> list = Arrays.asList(array); 

        // On retire tous les éléments en double de la liste 
        Set<Integer> uniqueList = new HashSet<>(list);
        
        // Création de la liste finale
        int[][] finalArray = new int[uniqueList.size()][2];
        
        int y=0; for (Integer i : uniqueList){
            
            finalArray[y][0] = i;
            finalArray[y][1] = Collections.frequency(list, i);
            
            y++;
        }

        return finalArray;
    }
    
    /**
    * Cette méthode permet de retourner un array contenant les entrées 
    * utilisateur si aucun paramètre n'est entré en argument dans le main
    * 
    * @param args l'array entré par l'utilisateur
    * @return la liste entrée par l'utilisateur si celle ci était vide, sinon
    * ce qui était donné par défaut
    */
    public static String[] waitingInput(String[] args){
      
        // Si les arguments sont vides
        if (args.length == 0) {

            System.out.println("\nAucun argument passé en entrée, merci d'en inscrire : ");            
            
            List<String> listArgs = new ArrayList<>();
            String arg = "default"; 
                                
            while(!arg.isEmpty()){
                Scanner input = new Scanner(System.in);
                arg = input.nextLine();
                
                // Permet d'éviter l'entrée d'un argument vide
                if(!arg.isEmpty())
                    listArgs.add(arg);
            }

            return listArgs.toArray(new String[listArgs.size()]);
                    
        } else {
            return args;
        }
    
    }
    
    /**
    * Cette méthode permet de traiter les variables passés en argument 
    * du main avec deux instructions particulières :
    * -v pour la chaîne principale
    * -s pour le symbole de compte 
    * 
    * @param args l'array entré par l'utilisateur
    * @return la liste des nombres à compter dans un array
    */
    public String[] parsingArgs(String[] args){
        
        List<String> listArgs = new ArrayList<>();
        
        // Initialisation
        String argType = "";
        
        for (String s: args){
            
            if (s.equals("-v"))
                argType = "-v";
            else if (s.equals("-s"))
                argType = "-s";
            
            // Les nombres à traiter
            if (argType.equals("-v") && !s.equals("-v")){
                listArgs.add(s);
            }
            // Le symbol de graphique
            else if (argType.equals("-s") && !s.equals("-s")){
                this.symbolChar = s;
                System.out.println("Le symbol choisi est : '" + s + "'");
                argType = "";
            }
            
        }
        
        if (listArgs.isEmpty()){
            String[] emptyArray = {};
            return waitingInput(emptyArray);
        }
        
        return listArgs.toArray(new String[listArgs.size()]);
       
    }
    
}
