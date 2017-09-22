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
package standardinput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Cette classe répond à la troisième problématique du LW1
 *      3- STANDARD INPUT
 * 
 * Elle permet de compter avec des étoiles le nombre d'occurence 
 * d'un nombre passé en argument tout en rajoutant la possibilité
 * de rajouter des entrées manuellement si elles n'existent pas
 */
public class StandardInput {

    /**
     * Méthode principale du programme
     * 
     * @param args les variables passés en argument (array)
     */
    public static void main(String[] args) {
        
        // On demande des entrées s'il n'y en pas déjà :
        args = waitingInput(args);
        
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
     */
    public static Integer[] StringArrayToInt(String[] array) {
        List<Integer> list = new ArrayList<Integer>();

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
    */
    public static int[][] CountDuplicate(Integer[] array){
        
        // Transformation de l'array en list pour pouvoir utiliser Collections
        List<Integer> list = Arrays.asList(array); 

        // On retire tous les éléments en double de la liste 
        Set<Integer> uniqueList = new HashSet<Integer>(list);
        
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
    
}
