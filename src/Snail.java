import java.util.Arrays;

public class Snail {
    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};
        int[][] arr = {{1}};
        System.out.println(Arrays.toString(snail(new int[0][0])));
        System.out.println(Arrays.toString(snail(arr)));
        System.out.println(Arrays.toString(snail(array)));
    }

    public static int[] snail(int[][] array) {
        if (array.length == 0 || array[0].length == 0)
            return new int[0];
        if (array.length == 1 && array[0].length == 1) {
            return new int[] {array[0][0]};
        }

        int n = array.length;
        int m = array[0].length;
        boolean[][] isPassed = new boolean[n][m];
        int[] result = new int[n * m];

        Integer i = 0;
        Integer j = 0, k = 0;
        result[k] = array[i][j];
        isPassed[i][j] = true;

        while (k < n*m - 1) {
            movingRight(i, j, array, k, isPassed, result);
//            while (j+1 <= m-1 && !isPassed[i][j+1]) {
//                j++;
//                k++;
//                isPassed[i][j] = true;
//                result[k] = array[i][j];
//            }
            movingDown(i, j, array, k, isPassed, result);
//            while (i+1 <= n-1 && !isPassed[i+1][j]) {
//                i++;
//                k++;
//                isPassed[i][j] = true;
//                result[k] = array[i][j];
//            }
            movingLeft(i, j, array, k, isPassed, result);
//            while (j-1 >= 0 && !isPassed[i][j-1]) {
//                j--;
//                k++;
//                isPassed[i][j] = true;
//                result[k] = array[i][j];
//            }
            movingUp(i, j, array, k, isPassed, result);
//            while (i-1 >= 0 && !isPassed[i-1][j]) {
//                i--;
//                k++;
//                isPassed[i][j] = true;
//                result[k] = array[i][j];
//            }
        }

        return result;
    }
    private static void movingRight(Integer i, Integer j, int[][] array, Integer k, boolean[][] isPassed, int[] result) {
        while (j+1 <= array[0].length-1 && !isPassed[i][j+1]) {
            j++;
            k++;
            isPassed[i][j] = true;
            result[k] = array[i][j];
        }
    }
    private static void movingDown(Integer i, Integer j, int[][] array, Integer k, boolean[][] isPassed, int[] result) {
        while (i+1 <= array.length-1 && !isPassed[i+1][j]) {
            i++;
            k++;
            isPassed[i][j] = true;
            result[k] = array[i][j];
        }
    }
    private static void movingLeft(Integer i, Integer j, int[][] array, Integer k, boolean[][] isPassed, int[] result) {
        while (j-1 >= 0 && !isPassed[i][j-1]) {
            j--;
            k++;
            isPassed[i][j] = true;
            result[k] = array[i][j];
        }
    }
    private static void movingUp(Integer i, Integer j, int[][] array, Integer k, boolean[][] isPassed, int[] result) {
        while (i-1 >= 0 && !isPassed[i-1][j]) {
            i--;
            k++;
            isPassed[i][j] = true;
            result[k] = array[i][j];
        }
    }
}
