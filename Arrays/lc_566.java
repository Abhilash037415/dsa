import java.util.Scanner;

public class lc_566 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] array = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                array[i][j] = input.nextInt();
            }
        }
        
        
        
        input.close();
    }
}
