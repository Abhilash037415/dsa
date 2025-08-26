import java.util.Scanner;

public class lc_3000 {
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

        double maxDiagonal = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;

        for (int[] current : array) {
            int breadth = current[0];
            int length = current[1];
            double currentDiagonal = Math.sqrt(breadth * breadth + length * length);
            if (currentDiagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, breadth * length);
            }else if(currentDiagonal > maxDiagonal){
                maxDiagonal = currentDiagonal;
                maxArea = breadth * length;
            }
        }

        System.out.println(maxArea);

        input.close();
    }
}
