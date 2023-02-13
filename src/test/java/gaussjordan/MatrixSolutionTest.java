package gaussjordan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Matrix solution test
 */
class MatrixSolutionTest {

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

}