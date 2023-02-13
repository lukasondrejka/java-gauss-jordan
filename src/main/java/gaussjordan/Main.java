package gaussjordan;

public class Main {

    public static void main(String[] args) {

        double[][] data = {
                {1.66, 2, 3, 1},
                {4, 5, 6, 2},
                {4, 5, 5, 2}
        };

        solveMatrix(data);
    }

    private static void solveMatrix(double[][] data) {
        Matrix m = new Matrix(data);
        m.eliminate();
        System.out.println(m);
        System.out.println(m.getSolution());
    }
}
