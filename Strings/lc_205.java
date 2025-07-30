import java.util.HashMap;
import java.util.Scanner;

public class lc_205 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = input.next();

        HashMap<Character, Character> stot = new HashMap<>(), ttos = new HashMap<>();
        if (s.length() != t.length()) {
            System.out.println(false);
            input.close();
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (stot.containsKey(s.charAt(i)) && stot.get(s.charAt(i)) != t.charAt(i)) {
                System.out.println(false);
                input.close();
                return;
            }
            stot.put(s.charAt(i), t.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (ttos.containsKey(t.charAt(i)) && ttos.get(t.charAt(i)) != s.charAt(i)) {
                System.out.println(false);
                input.close();
                return;
            }
            ttos.put(t.charAt(i), s.charAt(i));
        }
        System.out.println(true);
        input.close();
    }
}