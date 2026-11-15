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
        while(low <= high) {
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
                return attempts;
            } 
            else {
                System.out.println("Invalid response. Please type 'lower', 'higher', or 'correct'.");
            }
        }
        return attempts;
    }
    public static int  score(int attempts) {
        return 100 - attempts * 5;
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
        do {
            Scanner sc = new Scanner(System.in);
            int low = 1;
            int high = 100;
            begin(low, high, sc);
            int attempts = guess(low, high, sc);
            System.out.println("It took me " + attempts + " attempts to guess your number.");
            System.out.println("Your score is: " + score(attempts));
        } 
        while (wantsToPlayAgain(sc));
    }
}