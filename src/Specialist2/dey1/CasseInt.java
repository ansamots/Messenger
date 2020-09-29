package Specialist2.dey1;

import java.util.ArrayList;

public class CasseInt {
    private volatile int x = 0;
    ArrayList <String> arrayList = new ArrayList<>();
    int[] intList = new int[3000];
    int i = 0;


    public void setX(RunningThread t) {
        intList[i] = x;
        i++;
        String s = Thread.currentThread().getName();
//        System.out.printf("Работает с переменной поток %s и её значение %d\n", s, x);
        x++;
//        System.out.printf("Поток %s увеличил переменную и её значение %d\n", s, x);
        arrayList.add(s);
    }

    public int getX(){
        return x;
    }
}
