import java.util.Scanner;
public class Game {
    public static void begin(int low, int high, Scanner sc) {
        System.out.println("Welcome to the Reverse Guessing Game!");
        System.out.println("Think of a number between " + low + " and " + high + ", and I will try to guess it.");
        System.out.println("After each guess, please respond with 'higher', 'lower', or 'correct'.");
        System.out.println("The faster i guess your number, the lessser points you will get.");
        System.out.println("Let's begin!");

        System.out.print("Now think of a number between " + low + " and " + high + " but dont tell me and press Enter when ready...");
        sc.nextLine();
    }
    public static int guess(int low, int high, Scanner sc) {
        int attempts = 0;
        int score = -1;
        boolean guessed = false;

        //core logic of the game, using binary search to guess the number
        while(low <= high && !guessed) {
            int guess = low + (high - low) / 2;
            attempts++;
            System.out.println("Is your number smaller, bigger or equal to " + guess + "? (Type 'lower', 'higher', or 'correct')");
            String response = sc.nextLine().toLowerCase();
            if(response.equals("lower")) {
                high = guess - 1;
            } 
            else if(response.equals("higher")) {
                low = guess + 1;
            } 
            else if(response.equals("correct")) {
                System.out.println("Yay! I guessed your number: " + guess);
                guessed = true;
                score = 100 - attempts * 5;
                return score;
            } 
            else {
                System.out.println("Invalid response. Please type 'lower', 'higher', or 'correct'.");
                attempts--; // Don't count invalid responses as attempts
            }
        }
        if(!guessed) {
            System.out.println("Hey! You gave contradictory hints—no such number exists!");
            return -1; // Return -1 to indicate an error due to contradictory hints        
        }
        score = attempts * 5;
        return score;
    }
    public static boolean wantsToPlayAgain(Scanner sc) {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = sc.nextLine().toLowerCase();
        if (response.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            int low = 1;
            int high = 1000000;
            begin(low, high, sc);
            int score = guess(low, high, sc);
            System.out.println("Your score is: " + score);
        } 
        while (wantsToPlayAgain(sc));
        sc.close(); 
    }
}