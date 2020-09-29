package Specialist1.dey4;

public class StartProject {
    StartProject(){
        System.out.println("Родительский конструктор без параметров");
    }

    StartProject(String s){
        System.out.printf("Родительский конструктор с параметром %s \n", s);
    }

    public void testString(){
        System.out.println("Test String Parents");
    }
}
