import java.util.Scanner;

public class lc_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = input.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int high = height.length-1,low=0;
        while(high!=low){
            max = Math.max(max , Math.min(height[low],height[high])*(high-low));
            if(height[high]>height[low])    low++;
            else    high--;
        }
        System.out.println(max);
        input.close();
    }
}