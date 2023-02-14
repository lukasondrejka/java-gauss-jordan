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

    /**
     * Test for matrix
     */
    @Test
    void testMatrixGet() {
        double[][] data = {
                {1, 2, 3},
                {4, 5, 6},
        };
        Matrix matrix = new Matrix(data);

        for (int i = 0; i < data.length; i++)
            for (int j = 0; j < data[0].length; j++)
                assertEquals(data[i][j], matrix.get(i, j));

        // Test for out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(data.length, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> matrix.get(0, data[0].length));
    }
}