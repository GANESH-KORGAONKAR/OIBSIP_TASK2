package game;

import java.util.Random;
import java.util.Scanner;

public class Gamelogic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Game parameters
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int totalRounds = 3;
        int totalScore = 0;

        // Welcome message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts per round.");

        // Loop through the specified number of rounds
        for (int round = 1; round <= totalRounds; round++) {
            // Generate a random target number for the current round
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            int roundScore = 0;

            System.out.println("\nRound " + round + ": Guess the number between " + lowerBound + " and " + upperBound);

            // Allow the user to guess until they run out of attempts
            while (attemptsLeft > 0) {
                System.out.print("Attempts left: " + attemptsLeft + " - Enter your guess: ");
                int userGuess = scanner.nextInt();

                // Check if the user's guess is correct
                if (userGuess == targetNumber) {
                    // Calculate score for the current round based on remaining attempts
                    roundScore = attemptsLeft * 10;
                    System.out.println("Congratulations! You guessed it. You scored " + roundScore + " points in this round.");
                    break;
                } else if (userGuess < targetNumber) {
                    // Give a hint if the guess is too low
                    System.out.println("Try a higher number.");
                } else {
                    // Give a hint if the guess is too high
                    System.out.println("Try a lower number.");
                }

                // Decrement the number of attempts left
                attemptsLeft--;
            }

            // Update the total score after each round
            totalScore += roundScore;
            System.out.println("Round " + round + " ended. The correct number was " + targetNumber);
        }

        // Display the total score after all rounds are completed
        System.out.println("\nGame Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
