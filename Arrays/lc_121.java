import java.util.Scanner;

public class lc_121 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = input.nextInt();
        }

        int maxProfit = 0;
        int minValue = prices[0];
        for(int i=1;i<prices.length;i++){
            int currentProfit = prices[i] - minValue;
            maxProfit = Math.max(currentProfit,maxProfit);
            if(minValue > prices[i]){
                minValue = prices[i];
            }
        }
        System.out.println(maxProfit);
        input.close();
    }
}
