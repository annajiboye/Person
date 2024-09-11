import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        JFileChooser chooser = new JFileChooser(new File("src"));  // Start JFileChooser in the src directory
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());

            try (Scanner scanner = new Scanner(file)) {
                System.out.println(String.format("%-10s %-20s %-30s %-10s", "ID", "Name", "Description", "Cost"));
                System.out.println("============================================================");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");  // Split the line by commas to extract the fields

                    if (data.length == 4) {
                        String id = data[0];
                        String name = data[1];
                        String description = data[2];
                        double cost = Double.parseDouble(data[3]);  // Convert cost from String to double

                        Product product = new Product(name, description, id, cost);
                        products.add(product);

                        System.out.println(String.format("%-10s %-20s %-30s %-10.2f", product.getID(), product.getName(), product.getDescription(), product.getCost()));
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please check the file path and try again.");
            }
        } else {
            System.out.println("File selection canceled.");
        }

        System.out.println("Number of products read: " + products.size());
    }
}

