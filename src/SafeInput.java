import java.util.Scanner;

/**
 * Utility class for safe console input handling with static methods.
 */
public class SafeInput {

    /**
     * Gets a non-empty string input from the user.
     *
     * @param in    The Scanner object to read input from.
     * @param prompt The prompt to display to the user.
     * @return The non-empty string input from the user.
     */
    public static String getNonEmptyString(Scanner in, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    /**
     * Gets a double input from the user.
     *
     * @param pipe  The Scanner object to read input from.
     * @param prompt The prompt to display to the user.
     * @return The double input from the user.
     */
    public static double getDouble(Scanner pipe, String prompt) {
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
     * Gets an integer input within a specified range from the user.
     *
     * @param in    The Scanner object to read input from.
     * @param prompt The prompt to display to the user.
     * @param min   The minimum valid value (inclusive).
     * @param max   The maximum valid value (inclusive).
     * @return The integer input from the user within the specified range.
     */
    public static int getRangedInt(Scanner in, String prompt, int min, int max) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (result >= min && result <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
            in.nextLine();
        } while (!valid);
        return result;
    }

    /**
     * Gets an integer input from the user.
     *
     * @param in    The Scanner object to read input from.
     * @param prompt The prompt to display to the user.
     * @param min   The minimum valid value (inclusive).
     * @param max   The maximum valid value (inclusive).
     * @return The integer input from the user within the specified range.
     */
    public static int getInt(Scanner in, String prompt, int min, int max) {
        int result = 0;
        boolean valid = false;
        do {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (result >= min && result <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
            in.nextLine();
        } while (!valid);
        return result;
    }

    /**
     * Gets a Y/N confirmation from the user.
     *
     * @param in    The Scanner object to read input from.
     * @param prompt The prompt to display to the user.
     * @return True if the user input is "Y" or "y", false if it is "N" or "n".
     */
    public static boolean getYNConfirm(Scanner in, String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = in.nextLine();
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
