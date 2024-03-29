package gaussjordan;

/*  Matrix representation
 *
 *            a00 + a01 + a02 = b0
 *            a00 + a01 + a02 = b1
 *            a00 + a01 + a02 = b2
 *
 *          / a00   a01   a02 | b0  \
 *  A|b =  |  a10   a11   a12 | b1  |
 *         \  a20   a21   a22 | b2 /
 *
 *  A|b is a matrix (2D array of doubles)
 */

/**
 * Class Matrix for Gauss-Jordan elimination method
 */
public class Matrix {
    private final double[][] matrix;
    private final int[] base;
    private final int rowCount;
    private final int columnCount;
    private Solution solution;

    /**
     * Constructor
     * @param rowCount number of rows
     * @param columnCount number of columns of matrix A (without b column)
     */
    public Matrix(int rowCount, int columnCount) {
        if (rowCount < 1 || columnCount < 1) {
            throw new IllegalArgumentException("rowCount and columnCount must be greater than 0");
        }

        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.matrix = new double[rowCount][columnCount];
        this.base = new int[rowCount];
        this.solution = Solution.UNKNOWN;
    }

    /**
     * Constructor
     * @param sourceData source data
     */
    public Matrix(double[][] sourceData) {
        this(sourceData.length, sourceData[0].length - 1);

        for (int i = 0; i < this.rowCount; i++) {
            this.matrix[i] = new double[this.columnCount + 1];
            System.arraycopy(sourceData[i], 0, this.matrix[i], 0, this.columnCount + 1);
        }
    }

    /**
     * Gauss-Jordan elimination method
     */
    public void eliminate() {
        int pivotRowIndex = 0;
        int pivotColumnIndex = 0;
        double pivot = 1;

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {

            boolean rowWithZeros = true;
            for (int columnIndex = 0; columnIndex < columnCount + 1; columnIndex++) {

                if (Helper.isNotZero(matrix[rowIndex][columnIndex])) {
                    rowWithZeros = false;
                    if (pivotColumnIndex == columnCount) {
                        base[rowIndex] = 0;
                        // no solution
                        this.solution = Solution.NO_SOLUTION;
                        return;
                    }

                    pivotRowIndex = rowIndex;
                    pivotColumnIndex = columnIndex;
                    pivot = matrix[pivotRowIndex][pivotColumnIndex];
                    base[rowIndex] = columnIndex;

                    if (columnIndex == columnCount) {
                        base[rowIndex] = 0;
                    }

                    break;
                }
            }

            if (rowWithZeros) {
                continue;
            }

            for (int columnIndex = 0; columnIndex < columnCount + 1; columnIndex++) {
                matrix[rowIndex][columnIndex] /= pivot;
            }

            double constant;
            for (int rowIndex2 = 0; rowIndex2 < rowCount; rowIndex2++) {
                if (rowIndex2 == pivotRowIndex) {
                    continue;
                }
                constant = matrix[rowIndex2][pivotColumnIndex];
                for (int columnIndex2 = 0; columnIndex2 < columnCount + 1; columnIndex2++) {
                    matrix[rowIndex2][columnIndex2] -= constant * matrix[pivotRowIndex][columnIndex2];
                }
            }
        }

        this.evaluateSolution();
    }

    /**
     * Evaluate solution
     */
    private void evaluateSolution() {
        if (this.solution != Solution.UNKNOWN) {
            return;
        }

        int rankA = 0;
        int rankAb = 0;
        for (int i = 0; i < rowCount; i++) {
            if (Helper.isNotZero(matrix[i][base[i]])) {
                rankA++;
                rankAb++;
            } else if (Helper.isNotZero(matrix[i][columnCount])) {
                rankAb++;
            }
        }

        if (rankA == rankAb) {
            if (rankA == columnCount) {
                this.solution = Solution.ONE_SOLUTION;
            } else {
                this.solution = Solution.INFINITELY_MANY_SOLUTIONS;
            }
        } else {
            this.solution = Solution.NO_SOLUTION;
        }
    }

    /**
     * Get number at position
     * @return number at position
     */
    public double get(int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }

    /**
     * Get solution
     * @return Solution
     */
    public Solution getSolution() {
        return solution;
    }

    /**
     * Get solution values
     * @return solution values
     */
    public double[] getSolutionValues() {
        if (this.solution != Solution.ONE_SOLUTION) {
            return null;
        }

        double[] solutionValues = new double[columnCount];
        for (int i = 0; i < columnCount; i++) {
            solutionValues[i] = matrix[i][columnCount];
        }

        return solutionValues;
    }

    /**
     * String representation of matrix
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Helper.matrixToString(matrix));

        if (solution != Solution.UNKNOWN) {
            sb.append("Solution: ").append(solution).append("\n");

            if (solution == Solution.ONE_SOLUTION) {
                double[] solutionValues = this.getSolutionValues();
                for (int i = 0; i < columnCount; i++) {
                    sb.append("x").append(i).append(" = ").append(solutionValues[i]).append("\n");
                }
            }
        }

        return sb.toString();
    }
}
