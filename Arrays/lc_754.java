import java.util.Scanner;

public class lc_754 {
    public static void main(String[] args) {
        Scanner smth = new Scanner(System.in);
        int n = smth.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = smth.nextInt();
        }
        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
            prefixSum[i] = sum;
        }
        sum=0;
        for (int i = array.length-1; i >=0; i--) {
            sum+=array[i];
            suffixSum[i] = sum;
        }
        for(int i=0;i<n;i++){
            if(prefixSum[i]==suffixSum[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
        smth.close();
    }
}
