import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {
    private SafeInputObj safeInput;

    @BeforeEach
    void setUp() {
        String input = "John\n" + "42\n" + "25\n" + "Y\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        safeInput = new SafeInputObj(new Scanner(in));
    }

    @Test
    void testGetNonEmptyString() {
        String result = safeInput.getNonEmptyString("Enter name: ");
        assertEquals("John", result);
    }

    @Test
    void testGetDouble() {
        double result = safeInput.getDouble("Enter a number: ");
        assertEquals(42, result);
    }

    @Test
    void testGetInt() {
        int result = safeInput.getInt("Enter an age between 20 and 30: ", 20, 30);
        assertEquals(25, result);
    }

    @Test
    void testGetYNConfirm() {
        boolean result = safeInput.getYNConfirm("Continue? ");
        assertTrue(result);
    }
}
