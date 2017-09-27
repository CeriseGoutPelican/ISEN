/**
 * LABWORK 1 bis - NIVEAU M1 - ISEN LILLE
 * 
 * Ce document a été rédigé dans le cadre du cours de programmation
 * Java sous la supervision de monsieur Morelle
 * 
 * @author  Grégoire Gaonach
 * @date    27-09-2017
 * @version 0.1
 */

package labwork1b;

/**
 * Cette classe répond au premier exercice du LW1 bis
 *      2- EXERCICE 2 : MARATHON DE LILLE
 */
class Exercice2 {

    private String[] names = {"Nicolas", "Annie", "Paul", "Pierre", "Corinne", "Emilie", "Sonia", "Stephane", "John", "Thomas", "Sabine", "Perinne", "Sebastien", "Jeanne", "Amelie", "Alain"};
    private int[]    times = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
    
    public static void main(String[] args) {
        
        Exercice2 firstTest = new Exercice2();
        
        System.out.println("Le meilleur coureur est " + firstTest.names[firstTest.fastestRunner()] 
                            + " avec un temps total de " + firstTest.times[firstTest.fastestRunner()] + " minutes !");
        
        System.out.println("Le coureur le plus lent est " + firstTest.names[firstTest.slowestRunner()] 
                            + " avec un temps total de " + firstTest.times[firstTest.slowestRunner()] + " minutes !");
        
        System.out.println("Les trois gagnants de la course sont :");
        int[] gagnants = firstTest.top3Runners();
        for (int i = 0; i < gagnants.length; i++) {
            System.out.println(" " + (i+1) + ". " + firstTest.names[gagnants[i]] + " : " + firstTest.times[gagnants[i]]);
        }
               
    }
    
    /**
     * Méthode permettant de retourner le coureur le plus rapide (plus petit
     * temps en minutes) 
     * 
     * @return minIndex l'index du plus petit temps
     */
    public int fastestRunner(){
        
        int minIndex = 0;
        int min      = this.times[minIndex];
        for (int i = 0; i < this.times.length; i++) {
            if (this.times[i] < min) {
                min = this.times[i];
                minIndex = i;
            }
        }
        
        return minIndex;
        
    }
    
    /**
     * Méthode permettant de retourner le couleur le plus lent (plus grand temps
     * en minutes)
     * 
     * @return maxIndex l'index du plus grand temps
     */
    public int slowestRunner(){
        
        int maxIndex = 0;
        int max      = 0;
        for (int i = 0; i < this.times.length; i++) {
            if (this.times[i] > max) {
                max = this.times[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
        
    }
    
    /**
     * Méthode permettant de retourner une liste contenant les trois 
     * meilleurs temps sous forme d'une liste.
     * 
     * @return retour un tableau int contenant les trois meilleurs index
     */
    public int[] top3Runners(){
        
        int indexMin1 = 0;
        int indexMin2 = 0;
        int indexMin3 = 0;
        int valueMin1 = this.times[indexMin1];
        int valueMin2 = this.times[indexMin2];
        int valueMin3 = this.times[indexMin3];
        
        for (int i = 0; i < this.times.length; i++){
                  
            if (this.times[i] < valueMin1){
                valueMin3 = valueMin2;
                valueMin2 = valueMin1;
                valueMin1 = this.times[i];
                
                indexMin3 = indexMin2;
                indexMin2 = indexMin1;
                indexMin1 = i;
            }
            else if (this.times[i] < valueMin2){
                valueMin3 = valueMin2;
                valueMin2 = this.times[i];
                
                indexMin3 = indexMin2;
                indexMin2 = i;
            }
            else if (this.times[i] < valueMin3){
                valueMin3 = this.times[i];
                
                indexMin3 = i;
            }
                        
        }
        
        int[] retour = {indexMin1, indexMin2, indexMin3};
        return retour;
        
    }
    
    
}
