/* A simple number guessing game.

  Uses java.util.Random and java.util.Scanner packages
  User gets 5 attempts to guess a random number from 1 to 100.

  The number of attempts is intentionally kept less than 7.
  If the number of guesses is 7 or more, a smart user can
  use the concept of binary search to arrive at the correct
  guess since 2^7 = 128.
 */
/* **************************************/

import java.util.Random; // package to generate random numbers
import java.util.Scanner; // package to get user input

/* **************************************/

/**
 * Game class starts the game.
 */
public class Game {

    public static void main(String[] args) // main function
    {
        System.out.println("\n THE GAME OF GUESSING !");

        int num; // var for user input
        int success = 7; // checks if user has exhausted all attempts

        Working guess = new Working(success); // creating an object to play the game

        try (Scanner sc = new Scanner(System.in)) {
            while (guess.valid()) // loop till the guess is valid
            {
                System.out.print("\n Enter a number: "); // user input
                num = sc.nextInt();

                guess.check(num); // checking user's guess
                success--; // incrementing the attempts used
            }
        }

        if (success == 0) // if all attempts are exhausted
            System.out.println("\n SHOOT !");

        System.out.println("\n The number was " + guess.getNumber()); // prompting the correct answer
        System.out.println("\n Thanks For Playing !\n\n\n"); // outro
    }
}

/* **************************************/

/**
 * Working class implements the actual working of the game
 */
class Working {
    private final int number; // number should not be public or mutable
    private int attempts; // number of attempts to validate guessing attempts
    private final int noOfGuesses; // setting the maximum guesses the user can make

    /**
     * Constructor
     * initialises the random number, number of guesses and attempts
     */
    Working(int _noOfGuesses) {
        Random rand = new Random(); // generating random number
        number = rand.nextInt(100) + 1;

        System.out.println("\n The computer has guessed a number !");

        noOfGuesses = _noOfGuesses;
        attempts = 0;
    }

    /**
     * Checks if the attempt is valid
     * 
     * @return boolean value true if the attempt is valid
     */
    boolean valid() {
        return attempts < noOfGuesses;
    }

    /**
     * checks the guess of the user
     * informs the user about the guess made
     * 
     * @param guess - guess of the user
     *
     */
    void check(int guess) {
        attempts = attempts + 1; // incrementing the number of attempts

        if (guess == number) { // case user guessed it right
            System.out.println("\n Congratulations You Guessed It !");
            attempts = noOfGuesses;
        } else if (guess < number) { // case user guessed less than the answer
            System.out.println(" Take it up a notch.");
        } else { // case user guessed higher than answer
            System.out.println(" Little lower.....");
        }
    }

    /**
     * to get the random number generated
     * 
     * @return generated random number
     */
    int getNumber() {
        return number; // number being private requires a method to get it
    }
}
// End of Code
/* **************************************/