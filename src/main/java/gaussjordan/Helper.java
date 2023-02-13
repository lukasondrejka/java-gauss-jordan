package gaussjordan;

/**
 * Helper class
 */
public class Helper {

    /**
     * Zero threshold value
     */
    private static final double ZERO = 0.000_000_1;

    /**
     * Check if number is zero
     * @param number number to check
     * @return true if number is zero
     */
    public static boolean isZero(double number) {
        return Math.abs(number) < ZERO;
    }

    /**
     * Check if number is not zero
     * @param number number to check
     * @return true if number is not zero
     */
    public static boolean isNotZero(double number) {
        return !Helper.isZero(number);
    }

    /**
     * Format number
     * @param number number to format
     * @return formatted number
     */
    public static String formatNumber(double number) {
        final int PRECISION = 4;
        return String.format("%+05." + PRECISION + "f", number)
                .replaceAll("-0.", "+0.")
                .replaceAll(",", ".")
                .replaceAll("\\+", " ");
    }

    /**
     * Convert matrix to string
     * @param matrix matrix to print
     * @return string representation of matrix
     */
    public static String matrixToString(double[][] matrix) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                s.append(Helper.formatNumber(matrix[i][j]))
                        .append("  ");
            }
            s.append("\n");
        }

        return s.toString();
    }
}
