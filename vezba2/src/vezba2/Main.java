package vezba2;

public class Main {
    public static void main(String[] args) {
        Matrica matrix1 = new Matrica(3, 3);
        Matrica matrix2 = new Matrica(3, 3);

        // Set elements in matrix1
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        // ... set other elements in matrix1

        // Set elements in matrix2
        matrix2.setElement(0, 0, 3);
        matrix2.setElement(0, 1, 4);
        // ... set other elements in matrix2

        // Perform operations
        Matrica sum = matrix1.sum(matrix2);
        Matrica difference = matrix1.difference(matrix2);
        Matrica product = matrix1.product(matrix2);

        // Print the result of operations
        System.out.println("Matrix 1:");
        matrix1.printMatrix();

        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        System.out.println("Sum of matrices:");
        sum.printMatrix();

        System.out.println("Difference of matrices:");
        difference.printMatrix();

        System.out.println("Product of matrices:");
        product.printMatrix();
    }
}