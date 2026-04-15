import java.util.*;
import java.lang.*;
import java.io.*;


// This class is the basis for all cards in the game

public class Card {
    private int value;
    private String suit;
    private String name;
    private boolean majorArcana;

    // Constructor
    public Card(int value, String suit, String name, boolean majorArcana){
        this.value = value;
        this.suit = suit;
        this.name = name;
        this.majorArcana = majorArcana;
    }

    // Get Methods (Method Overloading)
    public String get(String name, boolean needPrint){
        switch (name){
            case "name":
                return this.name;
            case "suit":
                return this.suit;
        }
        return null;
    }

    public int getValue(boolean upside, boolean needPrint){
        if(upside == true){
            return this.value;
        } else {
            return this.value * -1;
        }
    }

    public boolean getArcana(boolean needPrint){
        if(needPrint == true) {
            if (this.majorArcana == true) {
                System.out.println("The card " + this.name + " is a major arcana card.");
                return true;
            } else {
                System.out.println("The card " + this.name + " is a minor arcana card.");
                return false;
            }
        } else {
            return this.majorArcana;
        }
    }

    public boolean isUpside(boolean needPrint){
        boolean returnValue;
        Random random = new Random();
        // More complex algorithm to determine if the card is upside, for major arcana cards

        if (this.majorArcana == true){
            long randomTime1 = (System.nanoTime() * random.nextInt(99) * random.nextInt(99));
            randomTime1 = randomTime1 % 32;
            long randomTime2 = (System.nanoTime())* random.nextInt(99) * random.nextInt(99);
            randomTime2 = randomTime2 % 29;
            int value = (int) (randomTime1 + randomTime2);
            value = value % 2;
            if(value == 0){
                returnValue = true;
            } else {
                returnValue = false;
            }

        // Less complex algorithm to determine if the card is upside, for minor arcana cards
        } else {
            long randomTime1 = (System.nanoTime()) * random.nextInt(99) * random.nextInt(99);
            randomTime1 = randomTime1 % 32;
            int value = (int) (randomTime1);
            value = value % 2;
            if(value == 0){
                returnValue = true;
            } else {
                returnValue = false;
            }
        }

        // Print the result if print the parameter is true
        if(needPrint == true) {
            if (returnValue == true) {
                System.out.println("The card " + this.name + " is upside.");
                return true;
            } else {
                System.out.println("The card " + this.name + " is downside.");
                return false;
            }
        } else {
            return returnValue;
        }
    }




}
