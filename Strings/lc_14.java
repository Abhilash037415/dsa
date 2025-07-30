import java.util.Scanner;

class lc_12{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] strs = new String[n];
        for(int i = 0;i<n;i++){
            strs[i] = input.next();
        }
        String minString = strs[0];
        for(String current : strs){
            if(current.length() < minString.length()){
                minString = current;
            }
        }
        for(String current : strs){
            while(!current.startsWith(minString)){
                minString = minString.substring(0, minString.length()-1);
                if(minString ==""){
                    break;
                }
            }
        }
        System.out.println(minString);
        input.close();
    }
}