package Specialist2.dey1;

public class TestThread3 {
    public static void main(String[] args) throws InterruptedException {
        CasseInt i = new CasseInt();
        RunningThread t0 = new RunningThread(i);
        RunningThread t1 = new RunningThread(i);
        RunningThread t2 = new RunningThread(i);

        t0.start();
        t1.start();
        t2.start();

        t0.join();
        t2.join();
        t1.join();

        int e = 0;
        System.out.println("Поток Main: "+i.getX());
        for(String s: i.arrayList){
            System.out.println("Массив: "+i.intList[e]);
            e++;
            System.out.println(s);
        }


    }
}
