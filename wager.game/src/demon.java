/*
The class which contains the main antagonist of the game demon's wager: The Demon

 */

import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class demon{
    private int health;
    private double balance;
    private String name;
    private int stage;
    private int bet;

    public double getBalance(boolean needPrint){
        if(needPrint == true){
            System.out.println("The Demon's Balance is: " + balance);
        }
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public int getHealth(boolean needPrint) {
        if(needPrint == true){
            System.out.println("The Demon's Health is: " + health);
        }
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStage(boolean needPrint) {
        if(needPrint == true){
            System.out.println("The Demon's Stage is: " + stage);
        }
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getName(boolean needPrint) {
        if(needPrint == true){
            System.out.println("The Demon's Name is: " + name);
        }
        return name;
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
}