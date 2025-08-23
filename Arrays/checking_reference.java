import java.util.Scanner;

public class checking_reference {

    static void add1torow(int[] row){
        for (int index = 0; index < row.length; index++) {
            row[index]+=1;
        }
    }

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

        add1torow(array[0]);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }  

        input.close();
    }
}
