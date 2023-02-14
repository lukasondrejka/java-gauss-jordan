package gaussjordan;

/**
 * Main class
 */
public class Main {

    /**
     * Main method
     * @param args command line arguments
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Run
     */
    private static void run() {
        boolean loaded = false;

        while (!loaded) {
            System.out.println("Enter file name: ");
            String fileName = Helper.readString();

            try {
                double[][] data = Loader.loadMatrixData(fileName);
                solveMatrix(data);
                loaded = true;
            } catch (Exception e) {
                System.out.println("Error while loading file\n");
            }
        }
    }

    /**
     * Solve matrix
     * @param data matrix data
     */
    private static void solveMatrix(double[][] data) {
        Matrix m = new Matrix(data);
        m.eliminate();

        System.out.printf("Input matrix: %n%s%n", Helper.matrixToString(data));
        System.out.printf("Eliminated matrix: %n%s%n", m);
        System.out.printf("Solution: %s%n", m.getSolution());
    }
}
