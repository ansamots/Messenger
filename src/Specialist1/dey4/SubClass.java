package Specialist1.dey4;

public class SubClass extends StartProject {
    SubClass(){
        System.out.println("Конструктор подкласса");
    }
    SubClass(String s){
        super(s);
        System.out.printf("Конструктор подкласса c параметром %s \n", s);
    }
}
