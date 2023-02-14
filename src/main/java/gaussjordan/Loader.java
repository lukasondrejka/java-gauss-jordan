package gaussjordan;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

/*
 * File structure:
 * a00 a01 ... a0n b0
 * a10 a11 ... a1n b1
 * ... ... ... ... ...
 * am0 am1 ... amn bm
 */

/**
 * Matrix loader. This class is used to load matrices from files.
 */
public class Loader {

    /**
    * Load matrix from file
    * @param filename matrix file name
    * @return matrix data
    */
    public static double[][] loadMatrixData(String filename) {
        try {
            File file = new File(filename);
            Scanner reader = new Scanner(file);

            int rowCount = 0;
            int columnCount = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.length() > 0) {
                    rowCount++;

                    if (columnCount == 0) {
                        // Replace multiple spaces or tabs with single space
                        line = line.replaceAll("\\s+", " ").trim();

                        // Split line to array of values by space
                        String[] values = line.split(" ");

                        columnCount = values.length;
                    }
                }
            }

            reader.close();

            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
            double[][] data = new double[rowCount][columnCount];

            for (int i = 0; i < rowCount; i++) {
                String line;

                // Skip empty lines
                do {
                    line = bufferedReader.readLine();
                } while (line != null && line.length() == 0);

                // Replace multiple spaces or tabs with single space
                line = line.replaceAll("\\s+", " ").trim();

                // Split line to array of values by space
                String[] values = line.split(" ");

                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = Double.parseDouble(values[j]);
                }
            }

            return data;
        } catch (Exception e) {
            throw new RuntimeException("Error while loading matrix from file");
        }
    }
}
