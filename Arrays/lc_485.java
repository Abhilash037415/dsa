import java.util.Scanner;

public class lc_485 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int maxCount = 0;
        int count = 0;
        for(int current : nums){
            if(current == 0){
                maxCount = Math.max(maxCount,count);
                count=0;
            }else{
                count++;
            }
        }
        input.close();
    }
}
