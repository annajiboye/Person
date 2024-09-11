import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();  // ArrayList to store Person objects

        // Open JFileChooser to select the file
        JFileChooser chooser = new JFileChooser(new File("src"));  // Start JFileChooser in the src directory
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());

            // Try to open and read the file
            try (Scanner scanner = new Scanner(file)) {
                System.out.println(String.format("%-10s %-15s %-15s %-15s %-10s", "ID#", "Firstname", "Lastname", "Title", "YOB"));
                System.out.println("============================================================");

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(",");  // Split the line by commas to extract the fields

                    // Ensure that we have exactly 5 fields (ID, firstName, lastName, title, YOB)
                    if (data.length == 5) {
                        String id = data[0];
                        String firstName = data[1];
                        String lastName = data[2];
                        String title = data[3];
                        int yob;
                        try {
                            yob = Integer.parseInt(data[4]);  // Convert year of birth from String to int
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid year of birth format: " + data[4]);
                            continue;  // Skip this record and continue with the next one
                        }

                        // Instantiate a Person object and add it to the ArrayList
                        Person person = new Person(firstName, lastName, id, title, yob);
                        people.add(person);

                        // Display the person data in a formatted way
                        System.out.println(String.format("%-10s %-15s %-15s %-15s %-10d",
                                person.getID(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYOB()));
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

        // Display how many Person objects were read
        System.out.println("Number of people read: " + people.size());
    }
}
