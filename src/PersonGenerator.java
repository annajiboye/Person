import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();  // ArrayList to store Person objects
        Scanner input = new Scanner(System.in);

       
        String fileName = SafeInput.getNonEmptyString(input, "Enter the name of the file to save the information to: ");

        boolean done = false;
        while (!done) {
            // Gather input for a Person
            String id = SafeInput.getNonEmptyString(input, "Enter the ID: ");
            String firstName = SafeInput.getNonEmptyString(input, "Enter the first name: ");
            String lastName = SafeInput.getNonEmptyString(input, "Enter the last name: ");
            String title = SafeInput.getNonEmptyString(input, "Enter the title, (like Mr., Mrs., Ms., Dr., etc.): ");
            int yearOfBirth = SafeInput.getInt(input, "Enter the year of birth (1940-2010): ", 1940, 2010);

           
            Person person = new Person(firstName, lastName, id, title, yearOfBirth);
            people.add(person);

            String cont = SafeInput.getNonEmptyString(input, "Are you finished entering information? (yes/no): ");
            if (cont.equalsIgnoreCase("yes")) {
                done = true;
            }
        }

       
        saveToFile(people, fileName);
        System.out.println("Data saved to " + fileName);
    }

 
    private static void saveToFile(ArrayList<Person> people, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Person person : people) {
                writer.write(person.toCSV() + System.lineSeparator());  // Use the toCSV method to format the output
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
