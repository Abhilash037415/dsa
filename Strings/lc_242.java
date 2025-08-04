import java.util.HashMap;
import java.util.Scanner;

public class lc_242{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = input.next();

        if(s.length() != t.length()){
            System.out.println(false);
            input.close();
            return;
        }

        HashMap<Character,Integer> frequencyMap = new HashMap<>();

        for(char current : s.toCharArray()){
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0)+1);
        }

        for(char current : t.toCharArray()){
            if(frequencyMap.containsKey(current)){
                frequencyMap.put(current,frequencyMap.get(current)-1);
            }else{
                System.out.println(false);
                input.close();
                return;
            }
            if(frequencyMap.get(current)==0){
                frequencyMap.remove(current);
            }
        }
        
        System.out.println(frequencyMap.size()==0);
        input.close();
    }
}