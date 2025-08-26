import java.util.Scanner;

public class lc_1672 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] accounts = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                accounts[i][j] = input.nextInt();
            }
        }

        int maxWealth = Integer.MIN_VALUE;

        for(int[] current : accounts){
            int totalbalance =0;
            for(int i : current){
                totalbalance += i;
            }
            maxWealth = Math.max(maxWealth,totalbalance);
        }

        System.out.println(maxWealth);

    }
}
