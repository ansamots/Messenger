package Specialist1.dey2;

import java.util.Scanner;

public class Celsiy {
    public static void main(String[] args){
        System.out.println("Начало работы программы");
        System.out.println("Если вы хотите перевести градусы цельсия в фаренгейт то введите f");
        System.out.println("Если из фаренгейта в цельсий то c - на латинице");

        {
            System.out.println("Печать блока!!!!!!!два");
        }
        try {
            Celsiy c = new Celsiy();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите символ: ");
            String s = scanner.nextLine();
//            var d = new Celsiy();
            if (s.equals("f")) {
                c.startCelsiy();
            }else if (s.equals("c")){
                c.startFaren();
            }else{
                System.out.println("Вы ввели некорректное значение");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void startCelsiy(){
        System.out.println("Введите градусы цельсия: ");
        try {
            Scanner scanner = new Scanner(System.in);
            double d = scanner.nextDouble();
            System.out.printf("Вы ввели %.0f градусов цельсия %n", d);
            double f = d * 9 / 5 + 32;
            System.out.printf("В фаренгейтах это будет: %.3f", f);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error");
        }
    }

    public void startFaren(){
        System.out.println("Введите градусы фаренгейта: ");
        try {
            Scanner scanner = new Scanner(System.in);
            double d = scanner.nextDouble();
            System.out.printf("Вы ввели %.0f градусов фаренгейта %n", d);
            double f = (d - 32) * 5 / 9 ;
            System.out.printf("В цельсиях это будет: %.3f", f);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error");
        }
    }
}
