import java.util.Scanner;

/**
 * A class that provides methods for safe console input handling.
 */
public class SafeInputObj {
    private Scanner pipe;

    /**
     * Default constructor that initializes the scanner to System.in.
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor that allows setting a custom scanner.
     *
     * @param scanner the custom Scanner to use.
     */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Prompts the user with a message and gets a non-empty string input.
     *
     * @param prompt the message to prompt the user.
     * @return the non-empty string input from the user.
     */
    public String getNonEmptyString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = pipe.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    /**
     * Prompts the user with a message and gets a double input.
     *
     * @param prompt the message to prompt the user.
     * @return the double input from the user.
     */
    public double getDouble(String prompt) {
        double result = 0;
        boolean done = false;

        do {
            System.out.print(prompt);
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                pipe.nextLine();
            }
        } while (!done);

        return result;
    }

    /**
     * Prompts the user with a message and gets an integer input within a specified range.
     *
     * @param prompt the message to prompt the user.
     * @param min the minimum acceptable value.
     * @param max the maximum acceptable value.
     * @return the integer input from the user within the specified range.
     */
    public int getInt(String prompt, int min, int max) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                if (result >= min && result <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
            pipe.nextLine();
        } while (!valid);
        return result;
    }

    /**
     * Prompts the user with a message and gets a Yes/No confirmation.
     *
     * @param prompt the message to prompt the user.
     * @return true if the user inputs 'Y' or 'y', false otherwise.
     */
    public boolean getYNConfirm(String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print(prompt + " [Y/N] ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y/N]! " + response);
            }

        } while (!gotAVal);

        return retVal;
    }
}
