import java.util.Scanner;

public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj safeInput = new SafeInputObj();

        String name = safeInput.getNonEmptyString("Enter your name: ");
        System.out.println("Name: " + name);

        double number = safeInput.getDouble("Enter a number: ");
        System.out.println("Number: " + number);

        int age = safeInput.getInt("Enter your age (18-120): ", 18, 120);
        System.out.println("Age: " + age);

        boolean confirm = safeInput.getYNConfirm("Do you want to proceed? ");
        System.out.println("Proceed: " + confirm);
    }
}

