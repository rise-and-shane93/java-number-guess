import java.util.Scanner;

public class numberGuess {
    public static void main(String[] args) {

        // Initialize Scanner
        Scanner input = new Scanner(System.in);

        /* Initialize playAgain variable to true. If a player decides to play again, then the program won't 
        re-assign it as it is already true. If a player decides to not play again, then this will be assigned
        to false and cause the parent do-while loop to stop executing */
        boolean playAgain = true;

        /* Parent do-while loop. This will repeat the number guessing game until the user types "no"
        at the end of the game */
        do {

            // Welcome statement & prompts the user to guess the upper end of the number range.
            System.out.print("\nWelcome to the number guessing game. Your objective is\nto guess the correct positive integer within\nthe number range. First, please enter the highest\npositive integer for the number range: ");
            int userNumRange = input.nextInt();

            // Prompts the user to enter the max number of attempts
            System.out.print("\nNow enter the number of attempts: ");
            int userNumAttempts = input.nextInt();

            // Selects a random number that is equal to or less than the userNumRange variable
            int randomNumber = (int) ( userNumRange * Math.random() ) + 1;

            // Prompts the user to guess the random number
            System.out.print("Guess the random number: ");
            int userGuessNumber = input.nextInt();

            /* Initializes the numAttempts and answerCorrect variables. numAttempts tracks the number
            of attempts and answerCorrect will check if the user selected the right number at the end of
            the child do-while loop. That variable will also change to true if the user guesses the right
            number before the end of the child do-while loop*/
            int numAttempts = 1;
            boolean answerCorrect = false;

            /* Child do-while loop. This will check to see if the number the user entered
            is equal to the random number. If it is equal,  */
            do {
                if (userGuessNumber == randomNumber) {
                    System.out.println("Correct!");

                    /* since the user answered correctly, change the answerCorrect variable to true 
                    This will exit the loop. */
                    answerCorrect = true;
                } else if (userGuessNumber > randomNumber) {

                    // Prompts the user to guess again and will change the userGuessNumber variable
                    System.out.print("\nToo high. Guess again: ");
                    userGuessNumber = input.nextInt();
                } else {

                    // Prompts the user to guess again and will change the userGuessNumber variable
                    System.out.print("\nToo low. Guess again: ");
                    userGuessNumber = input.nextInt();
                }

                // increments the numAttempts variable
                numAttempts++;

            /* checks for if numAttempts is less than or equal to userNumAttempts 
            and if answerCorrect is false. If a user got it right before exceeding the max number
            of attempts, the loop will end*/
            } while (numAttempts <= userNumAttempts && !answerCorrect);
    
            /* after the loop ends due to exceeding the max number of attempts, this will check if the user
            answered correctly for their final guess */
            if (!answerCorrect) {

                // The user answered correctly for their final attempt
                if (userGuessNumber == randomNumber) {
                    System.out.println("Correct!");
                    answerCorrect = true;
                
                // The user answered incorrectly for their final attempt
                } else {
                    System.out.println("Sorry, the correct answer is: " + randomNumber);
                }
            }

            // Ask if the user wants to paly again
            System.out.print("Would you like to play again? Type yes or no: ");
            String userPlayAgain = input.next();

            // if the user says no, set playAgain to false. Exits parent do-while loop
            if (userPlayAgain.toLowerCase().equals("no")) {
                playAgain = false;
            }

        // the condition in the parent do-while loop is whether or not the playAgain variable is true
        } while(playAgain);
        
        // Thank you message if the user declines to play again
        System.out.println("Thank you for playing");
        
    }
}