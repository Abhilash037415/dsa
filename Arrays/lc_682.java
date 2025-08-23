import java.util.Scanner;

public class lc_682 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String operations[] = new String[n];
        for (int i = 0; i < n; i++) {
            operations[i] = input.next();
        }

        int[] idk = new int[n];
        int k = 0, sum = 0;
        for (String operation : operations) {
            switch (operation) {
                case "+":
                    idk[k + 1] = idk[k] + idk[k - 1];
                    k++;
                    sum += idk[k];
                    break;
                case "D":
                    idk[k + 1] = idk[k] * 2;
                    k++;
                    sum += idk[k];
                    break;
                case "C":
                    sum -= idk[k];
                    k--;
                    break;
                default:
                    int value = Integer.parseInt(operation);
                    sum+=value;
                    idk[++k]=value;
            }
        }

        System.out.println(sum);

        input.close();
    }
}
