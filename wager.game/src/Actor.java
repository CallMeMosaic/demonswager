/*
The class which contains the main antagonist of the game demon's wager: The Demon

 */

import java.lang.*;
import java.io.*;

public class Actor{
    // Demon's values NEED to be in double, in order to have one get, change and set function for all values instead of separate ones for each value
    private double health; // indicates the demons health, which may be necessary for some games
    private double balance; // indicates the demons balance, which may be necessary for some games
    private String name; // indicates the demons name, which can be used to prematurely end the game with a win, if used in a sentence
    private int stage; // indicates the demons stage, which can be used to change the demons aggressivity and to indicate the end of the game
    private double bet; // indicates the demons bet, which is needed in most games to compare it to the player's bet
    private double wager_temp; // used to calculate the new wager total
    private double wager_total; // the total of all wagers offered by the player in a round
    private double wager; // Placeholder

    public Actor(double health, double balance, String name, int stage, double bet, double wager_temp, double wager_total, double wager){
        this.health = health;
        this.balance = balance;
        this.name = name;
        this.stage = stage;
        this.bet = bet;
        this.wager_temp = wager_temp;
        this.wager_total = wager_total;
        this.wager = wager;

    }
    public double getValue(String value, boolean needPrint){
        // Generalized Method to fetch double values from the demon's stats
        double returnValue = 0;
        switch (value){

            case "health":
                if(needPrint == true){
                    System.out.println(this.name +"'s Health is: " + health);
                }
                returnValue = this.health;
                break;

            case "balance":
                if(needPrint == true) {
                    System.out.println(this.name +"'s Balance is: " + balance);
                }
                returnValue = this.balance;
                break;

            case "bet":
                if(needPrint == true) {
                    System.out.println(this.name +"'s Bet is: " + bet);
                }
                returnValue =  this.bet;
                break;

            case "wager_total":
                if(needPrint == true) {
                    System.out.println("The wager is now: " + wager_total);
                }
                returnValue = this.wager_total;
                break;

            case "wager_temp":
                if(needPrint == true) {
                    System.out.println("The wager top up is now: " + wager_temp);
                }
                returnValue = this.wager_temp;
                break;

            case "wager":
                if(needPrint == true) {
                    System.out.println("The wager is now: " + wager);
                }
                returnValue = this.wager;
                break;
        }
     return returnValue;
    }

    public double changeValue(String value, double amount, boolean addition, boolean needPrint){
        // Generalized Method to change values of the demon's stats
        // First checks which value has been selected via a switch statement
        // Then checks if the given amount has to be added or deducted from value
        // Then checks if a print statement is needed
        // Finally returns the new value
        double returnValue = 0;
        switch (value){

            // Checks if the passed parameter is health
            case "health":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of health by the given amount and prints the change
                        returnValue = this.health + amount;
                        System.out.println(this.name +"'s health has been increased by " + amount + " points. " + " The Demon's Health is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of health by the given amount and does not print the change
                        returnValue = this.health + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of health by the given amount and prints the change
                        returnValue = this.health - amount;
                        System.out.println(this.name +" has been damaged by " + amount + " points. " + "The Demon's Health is now: " + returnValue);
                    }
                    // Changes the value of health by the given amount and does not print the change
                    else{
                        returnValue = this.health - amount;
                    }
                }
                break;

            // Checks if the passed parameter is balance
            case "balance":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of balance by the given amount and prints the change
                        returnValue = this.balance + amount;
                        System.out.println(this.name +"'s balance has been increased by " + amount + " points. " + " The Demon's balance is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of balance by the given amount and does not print the change
                        returnValue = this.balance + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of balance by the given amount and prints the change
                        returnValue = this.balance - amount;
                        System.out.println(this.name +"'s balance has been subtracted by" + amount + " points. " + "The Demon's balance is now: " + returnValue);
                    }
                    // Changes the value of balance by the given amount and does not print the change
                    else{
                        returnValue = this.balance - amount;
                    }
                }
                break;

            // Checks if the passed parameter is bet
            case "bet":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of bet by the given amount and prints the change
                        returnValue = this.bet + amount;
                        System.out.println(this.name +"'s bet has been increased by " + amount + " points. " + " The Demon's bet is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of bet by the given amount and does not print the change
                        returnValue = this.bet + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of bet by the given amount and prints the change
                        returnValue = this.bet - amount;
                        System.out.println(this.name +"'s bet has been decreased by " + amount + " points. " + "The Demon's bet is now: " + returnValue);
                    }
                    // Changes the value of bet by the given amount and does not print the change
                    else{
                        returnValue = this.bet - amount;
                    }
                }
                break;

            // Checks if the passed parameter is wager_total
            case "wager_total":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager_total by the given amount and prints the change
                        returnValue = this.wager_total + amount;
                        System.out.println(this.name +"'s wager has been increased by " + amount + " points. " + " The Demon's wager is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of wager_total by the given amount and does not print the change
                        returnValue = this.wager_total + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager_total by the given amount and prints the change
                        returnValue = this.wager_total - amount;
                        System.out.println(this.name +"'s wager has been increased by " + amount + " points. " + "The Demon's wager is now: " + returnValue);
                    }
                    // Changes the value of wager_total by the given amount and does not print the change
                    else{
                        returnValue = this.wager_total - amount;
                    }
                }
                break;

            // Checks if the passed parameter is wager_temp
            case "wager_temp":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager_temp by the given amount and prints the change
                        returnValue = this.wager_temp + amount;
                        System.out.println(this.name +"'s wager top up has been increased by " + amount + " points. " + " The Demon's Hwager top up is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of wager_temp by the given amount and does not print the change
                        returnValue = this.wager_temp + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager_temp by the given amount and prints the change
                        returnValue = this.wager_temp - amount;
                        System.out.println(this.name +"'s wager top up has been decreased by" + amount + " points. " + "The Demon's wager top up is now: " + returnValue);
                    }
                    // Changes the value of wager_temp by the given amount and does not print the change
                    else{
                        returnValue = this.wager_temp - amount;
                    }
                }
                break;

            // Checks if the passed parameter is wager
            case "wager":
                // Checks if addition is expected
                if(addition == true){
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager by the given amount and prints the change
                        returnValue = this.wager + amount;
                        System.out.println(this.name +"'s wager has been increased by " + amount + " points. " + " The Demon's wager is now:"+ returnValue);
                    }
                    else{
                        // Changes the value of wager by the given amount and does not print the change
                        returnValue = this.wager + amount;
                    }
                }
                // Checks if addition is not expected, so it falls back to subtraction
                else if(addition == false) {
                    // Checks if printing is needed
                    if(needPrint == true){
                        // Changes the value of wager by the given amount and prints the change
                        returnValue = this.wager - amount;
                        System.out.println(this.name +"'s wager has been decreased by " + amount + " points. " + "The Demon's wager is now: " + returnValue);
                    }
                    // Changes the value of wager by the given amount and does not print the change
                    else{
                        returnValue = this.wager - amount;
                    }
                }
                break;

        }
        // Simply returns the edited returnValue to be used in other processes
        return returnValue;

    }

    public double setValue(String value, double amount, boolean needPrint) {
        // Generalized Method to change values of the demon's stats
        // First checks which value has been selected via a switch statement
        // Then checks if a print statement is needed
        // Finally returns the new value
        double returnValue = 0;
        switch (value) {

            // Checks if the passed parameter is health
            case "health":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of health to the given amount and prints the change
                    this.health = amount;
                    returnValue = this.health;
                    System.out.println(this.name +"'s health has been set to " + returnValue + " points. ");
                } else {
                    // Changes the value of health to the given amount and does not print the change
                    this.health = amount;
                    returnValue = this.health;
                }
                break;

            // Checks if the passed parameter is balance
            case "balance":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of balance to the given amount and prints the change
                    this.balance = amount;
                    returnValue = this.balance;
                    System.out.println(this.name +"'s balance has been set to " + returnValue + " points. ");
                } else {
                    // Changes the value of balance to the given amount and does not print the change
                    this.balance = amount;
                    returnValue = this.balance;
                }
                break;

            // Checks if the passed parameter is bet
            case "bet":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of bet to the given amount and prints the change
                    this.bet = amount;
                    returnValue = this.bet;
                    System.out.println(this.name +"'s bet has been set to " + returnValue + " points. ");
                } else {
                    // Changes the value of bet to the given amount and does not print the change
                    this.bet = amount;
                    returnValue = this.bet;
                }
                break;

            // Checks if the passed parameter is wager_total
            case "wager_total":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of wager_total by the given amount and prints the change
                    this.wager_total = amount;
                    returnValue = this.wager_total;
                    System.out.println(this.name +"'s wager has been increased by " + amount + " points. ");
                } else {
                    // Changes the value of wager_total to the given amount and does not print the change
                    this.wager_total = amount;
                    returnValue = this.wager_total;
                }
                break;

            // Checks if the passed parameter is wager_temp
            case "wager_temp":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of wager_temp to the given amount and prints the change
                    this.wager_temp = amount;
                    returnValue = this.wager_temp;
                    System.out.println(this.name +"'s wager top up has been increased by " + returnValue + " points. ");
                } else {
                    // Changes the value of wager_temp to the given amount and does not print the change
                    this.wager_temp = amount;
                    returnValue = this.wager_temp;
                }
                break;

            // Checks if the passed parameter is wager
            case "wager":
                // Checks if printing is needed
                if (needPrint == true) {
                    // Changes the value of wager to the given amount and prints the change
                    this.wager = amount;
                    returnValue = this.wager;
                    System.out.println(this.name +"'s wager has been increased by " + returnValue + " points. ");
                } else {
                    // Changes the value of wager to the given amount and does not print the change
                    this.wager = amount;
                    returnValue = this.wager;
                }
                break;

        }
        // Simply returns the edited returnValue to be used in other processes
        return returnValue;
    }

    public int stageValue(int amount, boolean needPrint, int mode){
        // amount is needed for all operations, except get and reset. If one of these operations is chosen, the value for amount is irrelevant to the operation.
        int returnValue = 0;
        // Checks which mode is selected: 1 = increase stage, 2 = decrease stage, 3 = set stage to given amount, 4 = reset stage to 0, 5 = return current stage
        switch (mode){
            // Case 1 would increase the stage by the given amount
            case 1:
                // Checks if printing is needed
                if(needPrint == true){
                    this.stage += amount;
                    returnValue = this.stage;
                    System.out.println(this.name +"'s stage has been increased by " + amount + " points. " + "It is now set to " + returnValue);
                }else{
                    this.stage += amount;
                    returnValue = this.stage;
                };
                break;
                // Case 2 would decrease the stage by the given amount
            case 2:
                // Checks if printing is needed
                if(needPrint == true){
                    this.stage -= amount;
                    returnValue = this.stage;
                    System.out.println(this.name +"'s stage has been decrease by " + amount + " points. " + "It is now set to " + returnValue);
                }else{
                    this.stage -= amount;
                    returnValue = this.stage;
                }
                break;
                // Case 3 would set the stage to the given amount (DEV MODE)
            case 3:
                // Checks if printing is needed
                if(needPrint == true){
                    this.stage = amount;
                    returnValue = this.stage;
                    System.out.println(this.name +"'s stage is now set to " + returnValue);
                }else{
                    this.stage = amount;
                    returnValue = this.stage;
                }
                break;
                // Case 4 would reset the stage to 0 (DEV MODE) THIS CASE DOES NOT USE the amount parameter
            case 4:
                // Checks if printing is needed
                if(needPrint == true){
                    this.stage = 1;
                    returnValue = this.stage;
                    System.out.println(this.name +"'s stage has been reset to " + returnValue);
                }else{
                    this.stage = 1;
                    returnValue = this.stage;
                }
                break;

            // Simply returns the current stage
            case 5:
                // Checks if printing is needed
                if(needPrint == true){
                    returnValue = this.stage;
                    System.out.println(this.name +"'s stage is currently set to " + returnValue);
                }else{
                    returnValue = this.stage;
                }
        }
        return returnValue;
    }

    public void setStage(int stage) {
        // Method used to change the demon's health (Dev Mode)
        this.stage = stage;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String speak(boolean needPrint, String message){
        if(needPrint == true){
            System.out.println(this.name + ": " + message);
        }
        return message;
    }
    public String findFile(boolean needPrint, String fileName){
        File file = new File(fileName);
        if(needPrint == true){
            System.out.println(fileName);
        }
        return fileName;
    }

}