import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lc_3446 {
    static int[][] sortMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int row = i, col = 0; row < grid.length; row++, col++) {
                list.add(grid[row][col]);
            }
            Collections.sort(list, Collections.reverseOrder());
            for (int row = i, col = 0; row < grid.length && col < grid.length; row++, col++) {
                grid[row][col] = list.get(col);
            }
        }

        for (int i = grid.length - 1; i > 0; i--) {
            List<Integer> list = new ArrayList<>();
            for (int row = 0, col = i; col < grid.length; row++, col++) {
                list.add(grid[row][col]);
            }
            Collections.sort(list);
            for (int row = 0, col = i; col < grid.length; row++, col++) {
                grid[row][col] = list.get(row);
            }
        }

        return grid;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = input.nextInt();
            }
        }

        sortMatrix(array);

        input.close();
    }
}
