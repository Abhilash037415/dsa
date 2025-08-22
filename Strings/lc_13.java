import java.util.HashMap;
import java.util.Scanner;

public class lc_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int value = 0;
        char prev = s.charAt(0);
        for(char current : s.toCharArray()){
            if(romanMap.get(current)>romanMap.get(prev)){
                value -= romanMap.get(prev);
                value += (romanMap.get(current)-romanMap.get(prev));
            }else{
                value += romanMap.get(current);
            }
            prev = current;
        }

        System.out.println(value);
        input.close();
    }
}
