import java.util.Scanner;

public class icpc2024regional_1 {
    public static boolean possible(int N, int c1, int c2, int c3) {
        int total = c1 + 2 * c2 + 3 * c3;
        if (total % N != 0)
            return false;
        int S = total / N;
        if (S < 3 || S > 9)
            return false;

        switch (S) {
            case 3:
                return c1 == 3 * N;
            case 4:
                return c1 == 2 * N && c2 == N;
            case 5:
                if (c3 > N)
                    return false;
                return c2 == 2 * (N - c3) && c1 == N + c3;
            case 6:
                if (c1 != c3)
                    return false;
                return c2 == 3 * N - 2 * c1;
            case 7:
                if (c1 > N)
                    return false;
                return c2 == 2 * (N - c1) && c3 == N + c1;
            case 8:
                return c2 == N && c3 == 2 * N;
            case 9:
                return c3 == 3 * N;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int tot = 3 * N;
            int c1 = 0, c2 = 0, c3 = 0;
            for (int i = 0; i < tot; i++) {
                int x = sc.nextInt();
                if (x == 1)
                    c1++;
                else if (x == 2)
                    c2++;
                else if (x == 3)
                    c3++;
            }
            System.out.println(possible(N, c1, c2, c3) ? "Yes\n" : "No\n");
        }
        sc.close();
    }
}
