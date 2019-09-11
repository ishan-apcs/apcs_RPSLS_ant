/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorslizardspock_switch;

import java.util.Scanner;

/**
 *
 * @author ishanmadan
 */
public class RockPaperScissorsLizardSpock_switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        boolean keepGoing = true;
        String keepGoingAnswer;
        
        System.out.println("Hi there! Welcome to Rock, Paper, Scissors...Lizard, Spock!");
        
        while (keepGoing) {
            System.out.println("Rock...\nPaper...\nScissors...\nLizard...\nSpock...\nShoot!");
            String userChoice = input.nextLine();
            userChoice = userChoice.toLowerCase();
            userChoice = userChoice.replaceAll("[^rockpapesilzd]", "");
            while (!(userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors") || userChoice.equals("lizard") || userChoice.equals("spock"))) {
                System.out.println("I'm sorry, but that wasn't a recognized choice. Try again?\nRock...\nPaper...\nScissors...\nLizard...\nSpock...\nShoot!");
                userChoice = input.nextLine();
                userChoice = userChoice.toLowerCase();
                userChoice = userChoice.replaceAll("[^rockpapersilzd]", "");
            }

            String computerChoice = computerChoice();
            System.out.println("I choose " + computerChoice + ".");
            String victory = victoryCheck(computerChoice, userChoice);
            System.out.println(victory);
            
            System.out.println("Do you want to play again? Please answer yes or no.");
            keepGoingAnswer = input.nextLine();
            keepGoingAnswer = keepGoingAnswer.toLowerCase();
            keepGoingAnswer = keepGoingAnswer.replaceAll("[^yesno]", "");
            
            while (!(keepGoingAnswer.equals("yes") || keepGoingAnswer.equals("no"))) {
                System.out.println("I'm sorry, that's neither yes nor no. Do you want to play again? Please answer yes or no.");
                keepGoingAnswer = input.nextLine();
                keepGoingAnswer = keepGoingAnswer.toLowerCase();
                keepGoingAnswer = keepGoingAnswer.replaceAll("[^yesno]", "");
            }
            
            if (keepGoingAnswer.equals("yes")) {
                keepGoing = true;
            } else if (keepGoingAnswer.equals("no")) {
                keepGoing = false;
            } else {
                exit();
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
    
    public static String victoryCheck(String computerChoice, String userChoice) {
        if (computerChoice.equals(userChoice)) {
            return "It's a tie!";
        }
        switch(userChoice) {
            case "rock":
                switch(computerChoice) {
                    case "paper":
                        return "You lose! Paper covers rock.";
                    case "scissors":
                        return "You win! Rock crushes scissors.";
                    case "lizard":
                        return "You win! Rock crushes lizard.";
                    case "spock":
                        return "You lose! Spock vaporizes rock.";
                    default:
                        exit();
                }
            case "paper":
                switch(computerChoice) {
                    case "rock":
                        return "You win! Paper covers rock.";
                    case "scissors":
                        return "You lose! Scissors cuts paper.";
                    case "lizard":
                        return "You lose! Lizard eats paper.";
                    case "spock":
                        return "You win! Paper disproves Spock.";
                    default:
                        exit();
                }
            case "scissors":
                switch(computerChoice) {
                    case "rock":
                        return "You lose! Rock crushes scissors.";
                    case "paper":
                        return "You win! Scissors cuts paper.";
                    case "lizard":
                        return "You win! Scissors decapitates lizard.";
                    case "spock":
                        return "You lose! Spock smashes scissors.";
                    default:
                        exit();
                }
            case "lizard":
                switch(computerChoice) {
                    case "rock":
                        return "You lose! Rock crushes lizard.";
                    case "paper":
                        return "You win! Lizard eats paper.";
                    case "scissors":
                        return "You lose! Scissors decapitates lizard.";
                    case "spock":
                        return "You win! Lizard poisons Spock.";
                    default:
                        exit();
                }
            case "spock":
                switch(computerChoice) {
                    case "rock":
                        return "You win! Spock vaporizes rock.";
                    case "paper":
                        return "You lose! Paper disproves Spock.";
                    case "scissors":
                        return "You win! Spock smashes scissors.";
                    case "lizard":
                        return "You lose! Lizard poisons Spock.";
                    default:
                        exit();
                }
            default:
                exit();
        }
        return null;
    }
    
    public static void exit() {
        System.out.println("I'm sorry, but it appears that I can't code. My sincerest apologies. You will now be redirected to the afterlife. Goodbye!");
        System.exit(0);
    }
}
