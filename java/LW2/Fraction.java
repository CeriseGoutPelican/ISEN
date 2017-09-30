/**
 * LABWORK 2 - NIVEAU M1 - ISEN LILLE
 * 
 * Ce document a été rédigé dans le cadre du cours de programmation
 * Java sous la supervision de monsieur Morelle
 * 
 * @author  Grégoire Gaonach
 * @date    29-09-2017
 * @version 0.1
 */

package labwork2;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Cette classe répond au deuxième exercice du LW2 bis
 *      2 - Fractions
 */
public class Fraction {
    
    private static final int[] MIN_VALUE = {-1,Integer.MAX_VALUE};
    private static final int[] MAX_VALUE = {Integer.MAX_VALUE,1};
    private static final int[] ZERO      = {0,1};
    
    private int[] fraction = new int[2];
    
    // CONSTRUCTEUR
    public Fraction(){
        this.fraction = ZERO;
    }
    public Fraction(int n){
        this.fraction[0] = n;
        this.fraction[1] = 1;
    }
    public Fraction(int n, int d){
        this.fraction = dividedByZero(n, d);
    }
    public Fraction(String arg){
        String[] split = arg.split("/");
        this.fraction = dividedByZero(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
    
    public final int[] dividedByZero(int n, int d){
        if (d == 0 && n < 0){
            return MIN_VALUE;
        } else if (d == 0 && d >= 0) {
            return MAX_VALUE;
        }
        int[] frac = {n,d};
        return frac;
    }
    
    // ACCESSEURS
    public int[] getFraction(){
        return fraction;
    }
    
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction("200/3");
        
        System.out.println("a. Création d'une fraction et affichage : ");
        fraction1.display();
        fraction1.reverse();
        
        System.out.println("\nb. Inversion du numérateur avec le dénominateur : ");
        fraction1.display();
        fraction1.reverse();
        
        System.out.println("\nc. Valeur de la fraction en utilisant un float : ");
        System.out.println(fraction1.floatValue());
        
        System.out.println("\nd. Valeur de la fraction en utilisant un int : ");
        System.out.println(fraction1.intValue());
        
        Fraction addition = new Fraction("123/2");
        System.out.println("\ne. Addition de " + fraction1.toString() + " avec " + addition.toString() + " : ");
        addition = fraction1.add(addition);
        addition.display();
        
        System.out.println("\nf. Création d'une fraction aléatoire : ");
        Fraction random = rand();
        random.display();
        
        System.out.println("\ng. Comparaison de " + fraction1.toString() + " avec " + random.toString() + ": ");
        System.out.println(fraction1.compareTo(random));
        
        Fraction fraction1bis = fraction1.clone();
        System.out.println("\nh. Vérifie si deux fractions sont égales entre fraction1 " + fraction1.toString() + " et son clone fraction1bis " + fraction1bis.toString() + " : ");
        System.out.println(fraction1.equals(fraction1bis));
        
        System.out.println("\ni. Permet de connaître le signe d'une fraction : ");
        System.out.println(random.signum());
        
        Fraction[] fractions = {new Fraction("5/12"), new Fraction("85/10"), new Fraction("4/7")};
        System.out.println("\nj. Permet de connaître la fraction minimum d'une liste de fractions :");
        min(fractions).display();
    }
    
    public void display(){
        System.out.println(this.toString());
    }
    
    public void reverse(){
        int tmp = this.fraction[0];
        this.fraction[0] = this.fraction[1];
        this.fraction[1] = tmp;
    }
    
    public String toString(){
        return this.fraction[0] + "/" + this.fraction[1];
    }
    
    // PAS COMPRIS : QUESTION
    public Fraction valueOf(){
        return new Fraction("5/2");
    }
    
    public float floatValue(){
        return ((float) this.fraction[0]/this.fraction[1]);
    }
    public static float floatValue(Fraction fraction){
        return ((float) fraction.fraction[0]/fraction.fraction[1]);
    }
    
    public int intValue(){
        return (this.fraction[0]/this.fraction[1]);
    }
    
    public Fraction add(Fraction other){
        int n1 = this.fraction[0]*other.fraction[1];
        int d1 = this.fraction[1]*other.fraction[1];
        int n2 = other.fraction[0]*this.fraction[1];
        
        return new Fraction(n1+n2, d1);
    }
    
    public static Fraction add(Fraction f1, Fraction f2){
        int n1 = f1.fraction[0]*f2.fraction[1];
        int d1 = f1.fraction[1]*f2.fraction[1];
        int n2 = f2.fraction[0]*f1.fraction[1];
        
        return new Fraction(n1+n2, d1);
    }
    
    public Fraction clone(){
        return new Fraction(this.fraction[0], this.fraction[1]);
    }
    
    // TO UPDATE
    public static Fraction rand(){
        int min = Integer.MIN_VALUE/2;
        int max = Integer.MAX_VALUE/2;
        return new Fraction(ThreadLocalRandom.current().nextInt(min, max + 1), ThreadLocalRandom.current().nextInt(min, max + 1));
    }
    
    public int compareTo(Fraction other){
        if (this.floatValue() > other.floatValue())
            return -1;
        else if (this.floatValue() < other.floatValue())
            return 1;
        else
            return 0;
    }
    
    public boolean equals(Fraction other){
        return (this.floatValue() == other.floatValue());
    }
    
    public int signum(){
        if (this.intValue() > 0)
            return 1;
        else if (this.intValue() < 0)
            return -1;
        else
            return 0;
    }
    
    public static Fraction min(Fraction[] fractions){
        
        int minIndex = 0;
        float min    = floatValue(fractions[minIndex]);
        for (int i = 0; i < fractions.length; i++) {
            if (floatValue(fractions[i]) < min) {
                min = floatValue(fractions[i]);
                minIndex = i;
            }
        }
        
        return fractions[minIndex];
    }
    
    public void simplify(){
        
    }
    
}
