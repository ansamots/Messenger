package Specialist2.dey1;

public class RunningThread extends Thread{

    CasseInt anInt;

    RunningThread(CasseInt x){
        anInt = x;
    }
    @Override
    public void run() {
        super.run();
        for(int i = 0; i<1000; i++){
//            System.out.println("Я увеличиваю переменную"+ this);
            anInt.setX(this);
//            System.out.println("Я увеличиваю переменную "+anInt.getX());
        }

    }
}
