public class sample{
    public static void main(String[] args) {
        int i = 1231211;
        System.out.println(((int)Math.log10(i) + 1 & 1) == 0);
    }
}