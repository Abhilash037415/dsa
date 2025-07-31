import java.util.Scanner;

public class lc_796{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String goal = input.next();

        if(s.length() != goal.length()){
            System.out.println(false);
            input.close();
            return;
        }

        System.out.println((s+s).contains(goal));
        input.close();
    }
}