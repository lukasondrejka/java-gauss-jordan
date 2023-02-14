package gaussjordan;

/**
 * Data for testing matrix solutions
 */
public class Data {

    /**
     * Matrices with no solution
     */
    public static final double[][][] noSolutionMatrices = {
            {
                    {1, 1},
                    {1, 0},
            },
            {
                    {1, 1, 1, 2},
                    {0, 1, -3, 1},
                    {2, 1, 5, 0},
            },
    };

    /**
     * Matrices with one solution
     */
    public static final double[][][] oneSolutionMatrices = {
            {
                    {1, 1},
                    {2, 2},
            },
            {
                    {1, 1, -1, 5},
                    {0, 1, -5, 8},
                    {0, 0, 5, 0},
            },
            {
                    {-3, 5, 36, 10},
                    {-1, 0, 7, 5},
                    {1, 1, -10, -4},
            },
    };

    /**
     * Matrices with infinitely many solutions
     */
    public static final double[][][] infinitelyManySolutionsMatrices = {
            {
                    {1, 0, 0},
                    {0, 0, 0},
            },
            {
                    {2, 1, 5},
                    {8, 4, 20},
            },
    };

    /**
     * Matrices for testing solution values
     */
    public static final double[][][] matrices = {
            // 1
            {
                    {1, 1, 1, 2},
                    {0, 1, -3, 1},
                    {2, 1, 3, 0},
            },

            // 2
            {
                    {4, 5, 9, 9, 9, 0},
                    {0, 4, 0, 5, 6, 3},
                    {3, 0, 0, 4, 1, 0},
                    {0, 0, -2, 0, 0, 4},
                    {-4, 3, 1, -9, 5, 4},
            },

    };

    /**
     * Solution values for matrices
     */
    public static final double[][] solutionValues = {
            // 1
            {-5, 5.5, 1.5},

            // 2
            {132.0/7.0, 51.0, -2.0, -51.0/7.0, -192.0/7.0},

    };
}
