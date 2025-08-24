import java.util.Scanner;

public class lc_1295 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int count = 0;

        for(int current : nums){
            if( (int)(Math.log10(current)+1) % 2 == 0 ){
                count++;
            }
        }

        System.out.println(count);
        input.close();
    }
}
