package Specialist1.dey2;

import java.util.Scanner;

public class Vorony {
    public static void main(String[] args){
        System.out.println("Добрый день! Давайте сыграем в считалочку про ворон!))");
        System.out.println("Введите количество ворон:");
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        String s;
        int ost = v % 10;
        switch(ost){
            case 1 :
                s = "варона";
                break;
            case 2 :
            case 3 :
            case 4 :
                s = "вороны";
                break;
            default :
                s = "ворон";
        }
        System.out.printf("%d %s на ветке", v, s);
    }
}
