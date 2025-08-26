import java.util.Scanner;

public class lc_1732 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int gain[] = new int[n];
        for(int i = 0; i < n; i++) {
            gain[i] = input.nextInt();
        }

        int[] prefixSum = new int[gain.length];
        int sum=0;
        for(int i=0;i<prefixSum.length;i++){
            sum += gain[i];
            prefixSum[i] = sum;
        }

        int maxAltitude = 0;
        for(int current : prefixSum){
            System.out.print(current+" ");
            maxAltitude = Math.max(maxAltitude,current);
        }

        System.out.println(maxAltitude);

    }
}
