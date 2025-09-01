import java.util.PriorityQueue;
import java.util.Scanner;

public class lc_1792 {
    static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            double delta1 = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);
            double delta2 = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
            int score = delta2 == delta1 ? 0 : delta2 > delta1 ? 1 : -1;
            return score;
        });
        for (int[] current : classes) {
            maxHeap.add(current);
        }
        while (extraStudents-- > 0) {
            int[] currentClass = maxHeap.poll();
            currentClass[0]++;
            currentClass[1]++;
            maxHeap.add(currentClass);
        }
        double ans = 0;
        for (int[] current : maxHeap) {
            ans += ((double) current[0]) / current[1];
        }
        return ans / classes.length;
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
        int extra = input.nextInt();
        System.out.println(maxAverageRatio(array, extra));
        input.close();
    }
}