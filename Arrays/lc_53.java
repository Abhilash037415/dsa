import java.util.Scanner;

public class lc_53 {
    static int maxSubarray(int[] nums){
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for(int current : nums){
            currentSum = Math.max(current,currentSum+current);
            maxSum = Math.max(currentSum,maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[] = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        System.out.println(maxSubarray(array));
        input.close();
    }
}
