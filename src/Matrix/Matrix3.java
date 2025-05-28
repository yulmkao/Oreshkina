package Matrix;

public class Matrix3 {
    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new int[n][n];
        int middleOfMatrix = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - middleOfMatrix) + Math.abs(j - middleOfMatrix) <= middleOfMatrix) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}