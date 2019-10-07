/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpsls_ant;

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
        
        while (true) {
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Rock...");
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Paper...");
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Scissors...");
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Lizard...");
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Spock...");
            // wait
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Shoot! (Reply with your choice, or exit to exit)");
            String userChoice = input.nextLine();
            userChoice = userChoice.toLowerCase();
            userChoice = userChoice.replaceAll("[^rockpapesilzdxt]", "");
            
            if (userChoice.equals("exit")) {
                System.out.println("Bye!");
                System.exit(0);
            }

            while (!(userChoice.equals("rock") || 
                    userChoice.equals("paper") || 
                    userChoice.equals("scissors") || 
                    userChoice.equals("lizard") || 
                    userChoice.equals("spock") || 
                    userChoice.equals("exit"))) {
                System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?\nRock...");
                // wait
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Paper...");
                // wait
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Scissors...");
                // wait
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Lizard...");
                // wait
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Spock...");
                // wait
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Shoot! (Reply with your choice, or exit to exit)");
                userChoice = input.nextLine();
                userChoice = userChoice.toLowerCase();
                userChoice = userChoice.replaceAll("[^rockpapersilzdxt]", "");
            }

            if (userChoice.equals("exit")) {
                System.out.println("Bye!");
                System.exit(0);
            }

            String computerChoice = computerChoice();
            System.out.println("I choose " + computerChoice + ".");
            String victory = victoryCheck(computerChoice, userChoice);
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
            TimeUnit.SECONDS.sleep(1);
            System.out.println("\nLet's play again!");
        }
    }
    
    public static String computerChoice() {
        String[] options = {"rock", "paper", "scissors", "lizard", "spock"};
        double rand = Math.random();
        double doubleOptionIndex = options.length * rand;
        int optionIndex = (int)(doubleOptionIndex);
        return options[optionIndex];
    }
    
    public static String victoryCheck(String computerChoice, String userChoice) {
        if (computerChoice.equals(userChoice)) {
            return "It's a tie!";
        }
        
        if (userChoice.equals("rock")) {
            if (computerChoice.equals("paper")) {
                computerScore++;
                return "You lose! Paper covers rock.";
            } else if (computerChoice.equals("scissors")) {
                userScore++;
                return "You win! Rock crushes scissors.";
            } else if (computerChoice.equals("lizard")) {
                userScore++;
                return "You win! Rock crushes lizard.";
            } else if (computerChoice.equals("spock")) {
                computerScore++;
                return "You lose! Spock vaporizes rock.";
            } else {
                exit();
            }
        } else if (userChoice.equals("paper")) {
            if (computerChoice.equals("rock")) {
                userScore++;
                return "You win! Paper covers rock.";
            } else if (computerChoice.equals("scissors")) {
                computerScore++;
                return "You lose! Scissors cuts paper.";
            } else if (computerChoice.equals("lizard")) {
                computerScore++;
                return "You lose! Lizard eats paper.";
            } else if (computerChoice.equals("spock")) {
                userScore++;
                return "You win! Paper disproves Spock.";
            } else {
                exit();
            }
        } else if (userChoice.equals("scissors")) {
            if (computerChoice.equals("rock")) {
                computerScore++;
                return "You lose! Rock crushes scissors.";
            } else if (computerChoice.equals("paper")) {
                userScore++;
                return "You win! Scissors cuts paper.";
            } else if (computerChoice.equals("lizard")) {
                userScore++;
                return "You win! Scissors decapitates lizard.";
            } else if (computerChoice.equals("spock")) {
                computerScore++;
                return "You lose! Spock smashes scissors.";
            } else {
                exit();
            }
        } else if (userChoice.equals("lizard")) {
            if (computerChoice.equals("rock")) {
                computerScore++;
                return "You lose! Rock crushes lizard.";
            } else if (computerChoice.equals("paper")) {
                userScore++;
                return "You win! Lizard eats paper.";
            } else if (computerChoice.equals("scissors")) {
                computerScore++;
                return "You lose! Scissors decapitates lizard.";
            } else if (computerChoice.equals("spock")) {
                userScore++;
                return "You win! Lizard poisons Spock.";
            } else {
                exit();
            }
        } else if (userChoice.equals("spock")) {
            if (computerChoice.equals("rock")) {
                userScore++;
                return "You win! Spock vaporizes rock.";
            } else if (computerChoice.equals("paper")) {
                computerScore++;
                return "You lose! Paper disproves Spock.";
            } else if (computerChoice.equals("scissors")) {
                userScore++;
                return "You win! Spock smashes scissors.";
            } else if (computerChoice.equals("lizard")) {
                computerScore++;
                return "You lose! Lizard poisons Spock.";
            } else {
                exit();
            }
        } else {
            exit();
        }
        
        exit();
        return null;
    }
    
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the "
                + "afterlife. Goodbye!");
        System.exit(0);
    }
}