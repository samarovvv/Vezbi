//Да се креира класа Matrica со реални вредности и димензии r и k (дифолт вредности се (5, 5)), и
//конструктор на матрица со дадени димензии, методи за поставување на елемент на матрица, читање
//елемент на матрица, читање димензија на матрица, печатење на матрица, внесување на матрица,
//пресметување збир, разлика, производ на две матрици, проверка на индекси на матрица, правење на
//копија на матрица. Проблематичните ситуации како недозволен индекс на елемент, неусогласени
//димензии на матрица, да се решат со исклучоци.


package vezba2;

public class Matrica {
    private double[][] matrix;
    private int rows;
    private int columns;

    public Matrica() {
        this.rows = 5;
        this.columns = 5;
        this.matrix = new double[rows][columns];
    }

    public Matrica(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Димензиите мора да бидат поголеми од 0.");
        }
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    public void setElement(int row, int column, double value) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Недозволен индекс на елемент.");
        }
        matrix[row][column] = value;
    }

    public double getElement(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Недозволен индекс на елемент.");
        }
        return matrix[row][column];
    }

    public int[] getDimensions() {
        return new int[]{rows, columns};
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void inputMatrix(double[][] input) {
        if (input.length != rows || input[0].length != columns) {
            throw new IllegalArgumentException("Неусогласени димензии на матрицата.");
        }
        matrix = input;
    }

    public Matrica sum(Matrica other) {
        int[] otherDimensions = other.getDimensions();
        if (rows != otherDimensions[0] || columns != otherDimensions[1]) {
            throw new IllegalArgumentException("Матриците не се од иста димензија за збир.");
        }
        Matrica result = new Matrica(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrica difference(Matrica other) {
        int[] otherDimensions = other.getDimensions();
        if (rows != otherDimensions[0] || columns != otherDimensions[1]) {
            throw new IllegalArgumentException("Матриците не се од иста димензија за разлика.");
        }
        Matrica result = new Matrica(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, this.getElement(i, j) - other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrica product(Matrica other) {
        int[] otherDimensions = other.getDimensions();
        if (columns != otherDimensions[0]) {
            throw new IllegalArgumentException("Матриците не може да се множат поради несоодветни димензии.");
        }
        Matrica result = new Matrica(rows, otherDimensions[1]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherDimensions[1]; j++) {
                double sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += this.getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public Matrica copy() {
        Matrica copy = new Matrica(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                copy.setElement(i, j, this.getElement(i, j));
            }
        }
        return copy;
    }
}
