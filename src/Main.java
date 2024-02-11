public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 1, 505},
                {22, 5, 97},
                {77, 4, 1}
        };

        sortMainDiagonal(matrix);
        printArray(matrix);
    }

    public static void sortMainDiagonal(int[][] matrix) {
        int n = matrix.length;
        boolean swapped = true;
        int gap = n;

        // Пока разрыв больше 1 и имеются обмены, продолжаем сортировку
        while (gap > 1 || swapped) {
            // Вычисляем новый разрыв
            gap /= 1.247;
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;

            // Проходим по диагонали с учетом разрыва
            for (int i = 0; i < n - gap; i++) {
                if (matrix[i][i] > matrix[i + gap][i + gap]) {
                    // Обмен значениями
                    int temp = matrix[i][i];
                    matrix[i][i] = matrix[i + gap][i + gap];
                    matrix[i + gap][i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}