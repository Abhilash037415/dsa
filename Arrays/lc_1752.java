import java.util.Scanner;

public class lc_1752 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int rotationCounter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                rotationCounter++;
            }
        }
        if (nums[0] < nums[nums.length - 1]) {
            rotationCounter++;
        }

        System.out.println(rotationCounter);
        input.close();
        
    }
}
