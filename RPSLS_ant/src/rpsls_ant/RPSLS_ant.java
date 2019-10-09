/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsls_ant;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ishanmadan
 */
public class RPSLS_ant {
    static int userScore = 0;
    static int computerScore = 0;
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hi there! Welcome to Rock, Paper, Scissors...Lizard, Spock!");
        
        boolean keepPlaying = true;
        
        while (keepPlaying) {
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Rock...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Paper...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Scissors...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Lizard...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Spock...");
            // wait
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Shoot! (Reply with your choice, or exit to exit)");
            String userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapesilzdxt]", "");

            while (!(userChoice.equals("rock") || 
                    userChoice.equals("paper") || 
                    userChoice.equals("scissors") || 
                    userChoice.equals("lizard") || 
                    userChoice.equals("spock") || 
                    userChoice.equals("exit"))) {
                System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?\nRock...");
                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Paper...");
                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Scissors...");
                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Lizard...");
                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Spock...");
                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Shoot! (Reply with your choice, or exit to exit)");
                userChoice = input.nextLine().toLowerCase().replaceAll("[^rockpapersilzdxt]", "");
            }

            if (userChoice.equals("exit")) {
                System.out.println("Bye!");
                keepPlaying = false;
            } else {
                String computerChoice = computerChoice();

                Map choiceValues = new HashMap();
                choiceValues.put("rock", 0);
                choiceValues.put("paper", 1);
                choiceValues.put("scissors", 2);
                choiceValues.put("spock", 3);
                choiceValues.put("lizard", 4);


                int userInt = (int)choiceValues.get(userChoice);
                int computerInt = (int)choiceValues.get(computerChoice);

                System.out.println("I choose " + computerChoice + ".");
                String victory = victoryCheck(computerInt, userInt);
                System.out.println(victory);

                System.out.println();

                System.out.print("Score: you " + userScore + ", me "+ computerScore + ". ");
                if (userScore > computerScore) {
                    System.out.print("You're winning!");
                } else if (userScore < computerScore) {
                    System.out.print("I'm winning!");
                } else {
                    System.out.print("We're tied!");
                }

                System.out.println();

                // wait
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("\nLet's play again!");
            }            
        }
    }
    
    public static String computerChoice() {
        String[] options = {"rock", "paper", "scissors", "lizard", "spock"};
        double rand = Math.random();
        double doubleOptionIndex = options.length * rand;
        int optionIndex = (int)(doubleOptionIndex);
        return options[optionIndex];
    }
    
    public static String victoryCheck(int computerInt, int userInt) {
        //user is first dimension, computer is second
        String[][] replyArray = {
            {"It's a tie!", 
            "You lose! Paper covers rock.", 
            "You win! Rock crushes scissors.", 
            "You lose! Spock vaporizes rock.", 
            "You win! Rock crushes lizard."},
            {"You win! Paper covers rock.",
            "It's a tie!",
            "You lose! Scissors cuts paper.",
            "You win! Paper disproves Spock.",
            "You lose! Lizard eats paper."},
            {"You lose! Rock crushes scissors.",
            "You win! Scissors cuts paper.",
            "It's a tie!",
            "You lose! Spock smashes scissors.",
            "You win! Scissors decapitates lizard."},
            {"You win! Spock vaporizes rock.",
            "You lose! Paper disproves Spock.",
            "You win! Spock smashes scissors.",
            "It's a tie!",
            "You lose! Lizard poisons Spock."},
            {"You lose! Rock crushes lizard.",
            "You win! Lizard eats paper.",
            "You lose! Scissors decapitates lizard.",
            "You win! Lizard poisons Spock.",
            "It's a tie!"}};
        
        if (userInt > 4 || userInt < 0 || computerInt > 4 || userInt < 0) {
            exit();
        }
        
        if (userInt > computerInt) {
            if (((userInt - computerInt) % 2) == 1) {
                userScore++;
            } else {
                computerScore++;
            }
        } else if (userInt < computerInt) {
            if (((computerInt - userInt) % 2) == 1) {
                computerScore++;
            } else {
                userScore++;
            }
        }
        
        return replyArray[userInt][computerInt];
    }
    
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the "
                + "afterlife. Goodbye!");
        System.exit(0);
    }
}