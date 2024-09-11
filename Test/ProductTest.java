import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTest {

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product("Laptop", "High-end gaming laptop", "P123", 1500.00);
        product2 = new Product("Mouse", "Wireless mouse", "P456", 25.50);
    }

    @Test
    void testConstructor() {
        assertEquals("Laptop", product1.getName());
        assertEquals("High-end gaming laptop", product1.getDescription());
        assertEquals("P123", product1.getID());
        assertEquals(1500.00, product1.getCost());
    }

    @Test
    void testSetters() {
        product1.setName("Gaming Laptop");
        product1.setDescription("Ultra high-end gaming laptop");
        product1.setCost(1600.00);

        assertEquals("Gaming Laptop", product1.getName());
        assertEquals("Ultra high-end gaming laptop", product1.getDescription());
        assertEquals(1600.00, product1.getCost());
    }

    @Test
    void testToCSV() {
        assertEquals("P123,Laptop,High-end gaming laptop,1500.00", product1.toCSV());
    }

    @Test
    void testToJSON() {
        assertEquals("{\"ID\":\"P123\", \"name\":\"Laptop\", \"description\":\"High-end gaming laptop\", \"cost\":1500.00}", product1.toJSON());
    }

    @Test
    void testToXML() {
        assertEquals("<Product><ID>P123</ID><Name>Laptop</Name><Description>High-end gaming laptop</Description><Cost>1500.00</Cost></Product>", product1.toXML());
    }
}
