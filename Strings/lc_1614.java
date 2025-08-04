import java.util.Scanner;

public class lc_1614 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int count = 0;
        int maxCount = 0;
        for(char current : s.toCharArray()){
            if(current == '('){
                count++;
            }else if(current == ')'){
                maxCount = Math.max(count,maxCount);
                count--;
            }
        }
        System.out.println(maxCount);
    }
}
