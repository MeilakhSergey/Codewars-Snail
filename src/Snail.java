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

        int i = 0, j = 0, k = 0;
        result[k] = array[i][j];
        isPassed[i][j] = true;

        while (k < n*m - 1) {
            while (j+1 <= m-1 && !isPassed[i][j+1]) {
                j++;
                k++;
                isPassed[i][j] = true;
                result[k] = array[i][j];
            }
            while (i+1 <= n-1 && !isPassed[i+1][j]) {
                i++;
                k++;
                isPassed[i][j] = true;
                result[k] = array[i][j];
            }
            while (j-1 >= 0 && !isPassed[i][j-1]) {
                j--;
                k++;
                isPassed[i][j] = true;
                result[k] = array[i][j];
            }
            while (i-1 >= 0 && !isPassed[i-1][j]) {
                i--;
                k++;
                isPassed[i][j] = true;
                result[k] = array[i][j];
            }
        }
        return result;
    }

}
