import java.util.Scanner;

public class lc_1089 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int writer = 0;
        int[] newArr = arr.clone();

        for(int reader = 0;reader < arr.length && writer < arr.length;reader++){
            if(newArr[reader] == 0){
                arr[writer++] = 0;
                if(writer < arr.length){
                    arr[writer++] = 0;
                }else   break;
            }else{
                arr[writer++] = newArr[reader];
            }
        }


        for(int current: arr){
            System.out.print(current+" ");
        }
        input.close();
    }
}
