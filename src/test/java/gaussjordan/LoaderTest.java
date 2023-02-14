package gaussjordan;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Loader test
 */
public class LoaderTest {

    /**
     * Matrix data
     */
    static double[][] data;

    /**
     * Test file
     */
    static File file;

    /**
     * Test for loading matrix data from file
     */
    @RepeatedTest(3)
    public void testLoadMatrix() {
        double[][] matrix = Loader.loadMatrixData("test.txt");

        assertEquals(LoaderTest.data.length, matrix.length);
        assertEquals(LoaderTest.data[0].length, matrix[0].length);

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                assertEquals(LoaderTest.data[i][j], matrix[i][j]);
            }
        }
    }

    /**
     * Create test file
     */
    @BeforeEach
    public void createFile() {
        try {
            Random random = new Random();

            // Generate random matrix size
            int rowCount = random.nextInt(10) + 2;
            int columnCount = random.nextInt(10) + 2;

            // Create matrix data
            LoaderTest.data = new double[rowCount][columnCount];

            FileWriter writer = new FileWriter(LoaderTest.file);

            // Write matrix data to file
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    LoaderTest.data[i][j] = random.nextDouble(-10, 10);
                    writer.write(" " + LoaderTest.data[i][j]);
                }
                writer.write("\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while writing to file");
        }
    }

    /**
     * Initialize test file
     */
    @BeforeAll
    public static void init() {
        LoaderTest.file = new File("test.txt");
    }

    /**
     * Delete test file
     */
    @AfterAll
    public static void done() {
        LoaderTest.file.delete();
    }
}
