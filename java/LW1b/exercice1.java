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
 *      1- EXERCICE 1 : GRAVITY CALCULATOR
 */
class GravityCalculator {
    
    public static final double GRAVITY = -9.81; 
    
    private double initialVelocity;
    private double fallingTime;
    private double initialPosition;
    private double finalPosition;
    
    // CONSTRUCTEUR
    public GravityCalculator(double initialVelocity, double fallingTime, double initialPosition, double finalPosition){
        this.initialVelocity = initialVelocity;
        this.fallingTime     = fallingTime;
        this.initialPosition = initialPosition;
        this.finalPosition   = finalPosition;
    }
    
    // ACCESSEURS
    public double getInitialVelocity(){
        return initialVelocity;
    }
    public double getFallingTime(){
        return fallingTime;
    }
    public double getInitialPosition(){
        return initialPosition;
    }
    public double getFinalPosition(){
        return finalPosition;
    }
    
    public static void main(String[] args) {
        GravityCalculator firstTest = new GravityCalculator(0.0, 10.0, 0.0, 0.0);
        
        firstTest.calculateFinalPosition();
        
        System.out.println(firstTest.finalPosition);
    }
    
    /**
     * Cette méthode permet de calculer la position finale d'une valeur
     */
    public void calculateFinalPosition() {
        finalPosition = 0.5 * GRAVITY * (fallingTime*fallingTime) + initialVelocity * fallingTime + initialPosition;
    }
    
}
