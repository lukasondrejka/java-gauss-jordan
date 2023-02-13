package gaussjordan;

public enum Solution {
    NO_SOLUTION,
    ONE_SOLUTION,
    INFINITELY_MANY_SOLUTIONS,
    UNKNOWN;    // before Gauss-Jordan elimination

    /**
     * String representation of solution
     * @return String
     */
    @Override
    public String toString() {
        String s = "";
        switch (this) {
            case NO_SOLUTION -> s = "The matrix has no solution";
            case ONE_SOLUTION -> s = "The matrix has one solution";
            case INFINITELY_MANY_SOLUTIONS -> s = "The matrix has infinitely many solutions";
            case UNKNOWN -> s = "The matrix is not eliminated";
        }
        return s;
    }
}
