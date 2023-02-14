package gaussjordan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Matrix solution test
 */
class MatrixSolutionTest {

    /**
     * Test for no solution
     */
    @Test
    void testNoSolution() {
        for (double[][] matrixData : Data.noSolutionMatrices) {
            this.testSolution(matrixData, Solution.NO_SOLUTION);
        }
    }

    /**
     * Test for one solution
     */
    @Test
    void testOneSolution() {
        for (double[][] matrixData : Data.oneSolutionMatrices) {
            this.testSolution(matrixData, Solution.ONE_SOLUTION);
        }
    }


    /**
     * Test for infinitely many solutions
     */
    @Test
    void testInfinitelyManySolutions() {
        for (double[][] matrixData : Data.infinitelyManySolutionsMatrices) {
            this.testSolution(matrixData, Solution.INFINITELY_MANY_SOLUTIONS);
        }
    }

    /**
     * Test for unknown solution before Gauss-Jordan elimination
     */
    @Test
    void testUnknownSolution() {
        Matrix matrix = new Matrix(2, 2);

        assertEquals(Solution.UNKNOWN, matrix.getSolution());
    }

    /**
     * Test solution values
     */
    @Test
    void testSolutionValues() {
        //noinspection ConstantConditions
        if (Data.matrices.length != Data.solutionValues.length) {
            throw new IllegalArgumentException("Data.matrices.length != Data.solutionValues.length");
        }

        for (int i = 0; i < Data.matrices.length; i++) {
            // Get matrix data and expected solution
            double[][] matrixData = Data.matrices[i];
            double[] expectedSolution = Data.solutionValues[i];

            Matrix matrix = new Matrix(matrixData);
            matrix.eliminate();

            assertEquals(Solution.ONE_SOLUTION, matrix.getSolution());

            // Get solution values
            double[] solutionValues = matrix.getSolutionValues();

            for (int j = 0; j < solutionValues.length; j++) {
                assertEquals(expectedSolution[j], solutionValues[j], 1e-10);
            }
        }
    }

    /**
     * Test for solution
     * @param matrixData matrix data
     * @param solution expected solution
     */
    private void testSolution(double[][] matrixData, Solution solution) {
        Matrix matrix = new Matrix(matrixData);
        matrix.eliminate();
        assertEquals(solution, matrix.getSolution(),
                "\nInput matrix: \n" + Helper.matrixToString(matrixData));
    }
}