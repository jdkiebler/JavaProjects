import java.util.Random;
import java.util.Scanner;

public class randomNum {

    public static void main(String[] args){
        // generate new random num between 0 and 100, add 1 to result to ensure num is within bounds
        Random rand = new Random();
        int genNum = rand.nextInt(100);
        genNum += 1;
        // init boolean to test if bounds of game are met
        boolean  correctGuess = false;
        // print instructions
        System.out.println("Welcome to the number guessing game! We've generated a number between 0 and 100. \nPlease enter your guess: ");
        // while !correctGuess, prompt user for input and give relation of guessed number
        do {
            Scanner myObj = new Scanner(System.in);
            String userGuess = myObj.nextLine();
            int userGuessToInt = Integer.parseInt(userGuess);

            if (userGuessToInt > genNum) {
                System.out.println("The generated number is lower.\nPlease try again: ");
            } else if (userGuessToInt < genNum) {
                System.out.println("The generated number is higher. \nPlease try again: ");
            } else {
                System.out.println("Spot on! You guessed it!");
                correctGuess = true;
            }
        }
        while (!correctGuess);



    }
}
