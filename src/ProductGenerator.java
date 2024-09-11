import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String fileName = SafeInput.getNonEmptyString(input, "Enter the name of the file to save the information to: ");

        boolean done = false;
        while (!done) {
            String id = SafeInput.getNonEmptyString(input, "Enter the ID: ");
            String name = SafeInput.getNonEmptyString(input, "Enter the name: ");
            String description = SafeInput.getNonEmptyString(input, "Enter the description: ");
            double cost = SafeInput.getDouble(input, "Enter the cost: ");

            Product product = new Product(name, description, id, cost);
            products.add(product);

            String cont = SafeInput.getNonEmptyString(input, "Are you finished entering information? (yes/no): ");

            if (cont.equalsIgnoreCase("yes")) {
                done = true;
            }
        }

        saveToFile(products, fileName);
        System.out.println("Data saved to " + fileName);
    }

    private static void saveToFile(ArrayList<Product> products, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Product product : products) {
                writer.write(product.toCSV() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
