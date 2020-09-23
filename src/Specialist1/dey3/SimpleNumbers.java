package Specialist1.dey3;

public class SimpleNumbers {
    public static void main(String[] args){
        int a = 1;
        int b = 0;
//        int c =;
        while (a < 1000){
            System.out.println(a);
//            c=b;
//            b=a;
//            a=b+c;
            a=b+a;
            b=a-b;
        }
        int[] n = new int[] {1, 2, 3, 4, 5};
        System.out.println(n);
    }
}