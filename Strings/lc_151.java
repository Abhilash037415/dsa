import java.util.Scanner;

public class lc_151 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        s = s.trim();
        String[] words = s.split(" ");

        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i].isBlank() ? "" : words[i] + " ";
        }
        System.out.println(result.trim());
        input.close();
    }
}