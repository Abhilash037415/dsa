import java.util.Scanner;

public class lc_1572 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mat[i][j] = input.nextInt();
            }
        }

        int sum = 0;
        for(int i=0;i<mat.length;i++){
            sum+=mat[i][i];
        }
        for(int i=0,j=mat.length-1;i<mat.length;i++,j--){
            if(i==j)    continue;
            sum += mat[i][j];
        }

        System.out.println(sum);
        input.close();
    }
}
