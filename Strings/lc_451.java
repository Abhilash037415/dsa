import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class lc_451 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        Character[] characters = new Character[s.length()];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = s.charAt(i);
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char current : characters) {
            freqMap.put(current, freqMap.getOrDefault(current, 0) + 1);
        }
        Arrays.sort(characters, (a, b) -> {
            if (freqMap.get(b) - freqMap.get(a) == 0) {
                return a - b;
            } else {
                return freqMap.get(b) - freqMap.get(a);
            }
        });
        StringBuilder result = new StringBuilder();
        for (char c : characters) {
            result.append(c);
        }
        System.out.println(result.toString());
        input.close();
    }
}
