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

}
