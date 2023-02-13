package gaussjordan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Matrix test
 */
class MatrixTest {

    /**
     * Test for empty matrix creation
     */
    @Test
    void testEmptyMatrix() {
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(1, 0));

        assertThrows(IllegalArgumentException.class, () -> {
            double[][] data = {{}};
            new Matrix(data);
        });
    }
}