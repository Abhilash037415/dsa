import java.util.Scanner;

public class icpc2024regional_1 {

    public static boolean verify(int[] array) {
        int count1 = 0, count2 = 0, count3 = 0;
        for (int current : array) {
            if (current == 1)
                count1++;
            else if (current == 2)
                count2++;
            else if (current == 3)
                count3++;
            else
                return false;
        }

        int n = array.length / 3;

        // List all valid distributions
        return (count1 == 3 * n) ||
                (count1 == 2 * n && count2 == n) ||
                (count1 == n && count2 == 2 * n) ||
                (count1 == 2 * n && count3 == n) ||
                (count2 == 3 * n) ||
                (count1 == n && count2 == n && count3 == n) ||
                (count1 == n && count3 == 2 * n) ||
                (count2 == 2 * n && count3 == n) ||
                (count2 == n && count3 == 2 * n) ||
                (count3 == 3 * n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        System.out.println(verify(array));
        input.close();
    }
}
