import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp() {
        // Initialize Person objects for testing
        person1 = new Person("John", "Doe", "123", "Mr.", 1944);  // Example person with YOB 1944
        person2 = new Person("Jane", "Smith", "456", "Ms.", 1970);  // Example person with YOB 1970
    }

    @Test
    void testFullName() {
        // Test fullName method
        assertEquals("John Doe", person1.fullName());
        assertEquals("Jane Smith", person2.fullName());
    }

    @Test
    void testFormalName() {
        // Test formalName method
        assertEquals("Mr. John Doe", person1.formalName());
        assertEquals("Ms. Jane Smith", person2.formalName());
    }

    @Test
    void testGetAge() {
        // Test getAge method (current year)
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(currentYear - 1944, Integer.parseInt(person1.getAge()));
        assertEquals(currentYear - 1970, Integer.parseInt(person2.getAge()));
    }

    @Test
    void testGetAgeWithYear() {
        // Test getAge(int year) method
        assertEquals("40", person1.getAge(1984));  // Person1 should be 40 in 1984
        assertEquals("27", person2.getAge(1997));  // Person2 should be 27 in 1997
    }

    @Test
    void testToCSV() {
        // Test toCSV method
        assertEquals("123,John,Doe,Mr.,1944", person1.toCSV());
        assertEquals("456,Jane,Smith,Ms.,1970", person2.toCSV());
    }

    @Test
    void testToJSON() {
        // Adjust the expected JSON string to match the output of the toJSON() method
        String expectedJson1 = "{\"ID\":\"123\", \"firstName\":\"John\", \"lastName\":\"Doe\", \"title\":\"Mr.\", \"YOB\":1944}";
        String expectedJson2 = "{\"ID\":\"456\", \"firstName\":\"Jane\", \"lastName\":\"Smith\", \"title\":\"Ms.\", \"YOB\":1970}";

        assertEquals(expectedJson1, person1.toJSON());
        assertEquals(expectedJson2, person2.toJSON());
    }


    @Test
    void testToXML() {
        String expectedXml1 = "<Person><ID>123</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Mr.</Title><YOB>1944</YOB></Person>";
        String expectedXml2 = "<Person><ID>456</ID><FirstName>Jane</FirstName><LastName>Smith</LastName><Title>Ms.</Title><YOB>1970</YOB></Person>";

        assertEquals(expectedXml1.trim(), person1.toXML().trim());
        assertEquals(expectedXml2.trim(), person2.toXML().trim());
    }

}
