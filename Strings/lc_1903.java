import java.util.Scanner;

class lc_1903{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int lastIndex=0;
        for(int i = s.length()-1;i>=0;i--){
            if(Integer.valueOf(s.charAt(i))%2!=0){
                lastIndex = i+1;
                break;
            }
        }
        System.out.println(s.substring(0, lastIndex));
        input.close();
    }
}