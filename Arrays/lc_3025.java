import java.util.Scanner;

public class lc_3025 {

    static int numberOfPairs(int[][] points) {
        int count = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = 0; j < n; j++) {
                int[] pointB = points[j];
                if (i == j || (pointA[0] > pointB[0] || pointA[1] < pointB[1])) {
                    continue;
                }
                if (n == 2) {
                    count++;
                    continue;
                }
                boolean isValid = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    int[] temp = points[k];
                    boolean inX = pointA[0] <= temp[0] && temp[0] <= pointB[0];
                    boolean inY = pointA[1] <= temp[1] && temp[1] <= pointB[1];
                    if (inX && inY) {
                        isValid = false;
                    }
                }
                if (isValid) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = input.nextInt();
            }
        }

        System.out.println(numberOfPairs(points));
        input.close();
    }
}
