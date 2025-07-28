import java.util.Scanner;

public class lc_1021{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String result = "";
        String s = input.next();

        int count = 0;
        for(char current : s.toCharArray()){
            if(current == '('){
                count++;
                if(count>1) result+=current;
            }else{ 
                if(count>1) result += current;
                count--;
            }
        }
        System.out.println(result);
        input.close();
    }
}