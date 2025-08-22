import java.util.Scanner;

public class lc_136 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int xorSum = 0;
        for (int current : nums) {
            xorSum ^= current;
        }
        System.out.println(xorSum);
        input.close();
    }
}
