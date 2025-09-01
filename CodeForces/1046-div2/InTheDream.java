import java.util.Scanner;

public class InTheDream {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            int score1 = a, score2 = b;
            int score3 = c - a, score4 = d - b;
            System.out.println(Math.max(score1, score2) > (2 * Math.min(score1, score2) + 2) ||
                    Math.max(score3, score4) > (2 * Math.min(score3, score4) + 2) ? "NO" : "YES");
        }
        input.close();
    }
}