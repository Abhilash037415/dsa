import java.util.Scanner;

public class lc_283 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                nums[i++] = nums[j];
            }
        }

        for(;i<nums.length;i++){
            nums[i]=0;
        }

        for (int current : nums) {
            System.out.print(current+" ");
        }
        input.close();
    }
}
