import java.util.Scanner;

public class lc_832 {
    static void reverseRow(int[] row){
        int start=0,end=row.length-1;
        while(start<end){
            int temp = row[start];
            row[start++] = row[end];
            row[end--] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] image = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                image[i][j] = input.nextInt();
            }
        }
        for(int i=0;i<image.length;i++){
            reverseRow(image[i]);
        }
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        input.close();
    }
}
