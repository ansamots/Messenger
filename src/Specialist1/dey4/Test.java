package Specialist1.dey4;

public class Test {
    static int a = 0;
    static int b = 0;
    {
        b++;
        System.out.println("Не статический блок "+b);
    }
    static{
        a++;
        System.out.println("this "+a);
    }

}
