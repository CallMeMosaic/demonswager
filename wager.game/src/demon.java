/*
The class which contains the main antagonist of the game demon's wager: The Demon

 */

import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class demon{
    // Demon's values NEED to be in double, in order to have one get, change and set function for all values instead of separate ones for each value
    private double health; // indicates the demons health, which may be necessary for some games
    private double balance; // indicates the demons balance, which may be necessary for some games
    private String name; // indicates the demons name, which can be used to prematurely end the game with a win, if used in a sentence
    private int stage; // indicates the demons stage, which can be used to change the demons aggressivity and to indicate the end of the game
    private double bet; // indicates the demons bet, which is needed in most games to compare it to the player's bet
    private double wager_temp; // used to calculate the new wager total
    private double wager_total; // the total of all wagers offered by the player in a round
    private double wager; // Placeholder


    public double getValue(String value, boolean needPrint){
        // Generalized Method to fetch double values from the demon's stats
        double returnValue = 0;
        switch (value){

            case "health":
                if(needPrint == true){
                    System.out.println("The Demon's Health is: " + health);
                }
                returnValue = this.health;
                break;

            case "balance":
                if(needPrint == true) {
                    System.out.println("The Demon's Balance is: " + balance);
                }
                returnValue = this.balance;
                break;

            case "bet":
                if(needPrint == true) {
                    System.out.println("The Demon's Bet is: " + bet);
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
                        System.out.println("The Demons's health has been increased by " + amount + " points. " + " The Demon's Health is now:"+ returnValue);
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
                        System.out.println("The Demon has been damanged by " + amount + " points. " + "The Demon's Health is now: " + returnValue);
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
                        System.out.println("The Demons's balance has been increased by " + amount + " points. " + " The Demon's balance is now:"+ returnValue);
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
                        System.out.println("The Demon's balance has been subtracted by" + amount + " points. " + "The Demon's balance is now: " + returnValue);
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
                        System.out.println("The Demons's bet has been increased by " + amount + " points. " + " The Demon's bet is now:"+ returnValue);
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
                        System.out.println("The Demon's bet has been decreased by " + amount + " points. " + "The Demon's bet is now: " + returnValue);
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
                        System.out.println("The Demons's wager has been increased by " + amount + " points. " + " The Demon's wager is now:"+ returnValue);
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
                        System.out.println("The Demon's wager has been increased by " + amount + " points. " + "The Demon's wager is now: " + returnValue);
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
                        System.out.println("The Demons's wager top up has been increased by " + amount + " points. " + " The Demon's Hwager top up is now:"+ returnValue);
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
                        System.out.println("The Demon's wager top up has been decreased by" + amount + " points. " + "The Demon's wager top up is now: " + returnValue);
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
                        System.out.println("The Demons's wager has been increased by " + amount + " points. " + " The Demon's wager is now:"+ returnValue);
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
                        System.out.println("The Demon's wager has been decreased by " + amount + " points. " + "The Demon's wager is now: " + returnValue);
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

    public void setBalance(double balance) {
        // Method used to set the balance of the demon (Dev Mode)
        this.balance = balance;
    }


    public void setHealth(int health) {
        // Method used to set the demon's health (Dev Mode)
        this.health = health;
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
            System.out.println(message);
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
    public
}