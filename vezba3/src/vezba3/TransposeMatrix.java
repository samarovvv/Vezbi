package vezba3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TransposeMatrix {
    public static void main(String[] args) {
        try {
            // Читање на матрицата од датотеката "matrica1.txt"
            double[][] matrix = readMatrixFromFile("matrica1.txt");

            // Транспонирање на матрицата
            double[][] transposedMatrix = transposeMatrix(matrix);

            // Запишување на транспонираната матрица во датотеката "matrica2.txt"
            writeMatrixToFile("matrica2.txt", transposedMatrix);

            System.out.println("Програмата заврши успешно.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод за читање на матрица од датотека
    private static double[][] readMatrixFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Читање на бројот на редици и колони
            String[] dimensions = reader.readLine().split("\\s+");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            double[][] matrix = new double[rows][cols];

            // Читање на елементите од матрицата
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Double.parseDouble(reader.readLine());
                }
            }

            return matrix;
        }
    }

    // Метод за транспонирање на матрица
    private static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] transposedMatrix = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    // Метод за запишување на матрица во датотека
    private static void writeMatrixToFile(String filename, double[][] matrix) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Запишување на бројот на редици и колони
            writer.write(matrix.length + " " + matrix[0].length);
            writer.newLine();

            // Запишување на елементите од матрицата
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.write(Double.toString(matrix[i][j]));
                    writer.newLine();
                }
            }
        }
    }
}
