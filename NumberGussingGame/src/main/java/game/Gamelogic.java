package game;

import java.util.Random;
import java.util.Scanner;

public class Gamelogic {
		
		 public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();
		        int lowerBound = 1;
		        int upperBound = 100;
		        int maxAttempts = 7;
		        int totalRounds = 3;
		        int totalScore = 0;

		        System.out.println("Welcome to the Number Guessing Game!");
		        System.out.println("You have " + maxAttempts + " attempts per round.");

		        for (int round = 1; round <= totalRounds; round++) {
		            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
		            int attemptsLeft = maxAttempts;
		            int roundScore = 0;

		            System.out.println("\nRound " + round + ": Guess the number between " + lowerBound + " and " + upperBound);

		            while (attemptsLeft > 0) {
		                System.out.print("Attempts left: " + attemptsLeft + " - Enter your guess: ");
		                int userGuess = scanner.nextInt();

		                if (userGuess == targetNumber) {
		                    roundScore = attemptsLeft * 10;
		                    System.out.println("Congratulations! You guessed it. You scored " + roundScore + " points in this round.");
		                    break;
		                } else if (userGuess < targetNumber) {
		                    System.out.println("Try a higher number.");
		                } else {
		                    System.out.println("Try a lower number.");
		                }

		                attemptsLeft--;
		            }

		            totalScore += roundScore;
		            System.out.println("Round " + round + " ended. The correct number was " + targetNumber);
		        }

		        System.out.println("\nGame Over! Your total score is: " + totalScore);
		        scanner.close();
		    }

	
}
