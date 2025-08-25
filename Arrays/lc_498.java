import java.util.Scanner;

public class lc_498 {
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

        // traversingUp
        boolean goingUp = true;
        int rowIndex = 0, colIndex = 0; 
        while (!(rowIndex==m || colIndex == n)) {
            while(goingUp){
                System.out.print(array[rowIndex][colIndex]+" ");
                if(colIndex == n-1){
                    rowIndex++;
                    break;
                }else if(rowIndex == 0){
                    colIndex++;
                    break;
                }
                rowIndex--;
                colIndex++;
            }
            while(!goingUp){
                System.out.print(array[rowIndex][colIndex]+" ");
                if(rowIndex == m-1){
                    colIndex++;
                    break;
                }
                else if(colIndex == 0){
                    rowIndex++;
                    break;
                }
                rowIndex++;
                colIndex--;
            }
            goingUp = !goingUp;
        }

        input.close();
    }
}
