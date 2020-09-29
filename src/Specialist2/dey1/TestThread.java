package Specialist2.dey1;

public class TestThread {
    public static void main(String[] args){
        Thread t0 = new Thread(() -> {
            for (int i = 0; i<100; i++){
                System.out.printf("Поток %S сделал значение переменным следующее %d\n", Thread.currentThread().getName(), i);
            }
        });

        Thread t1 = new Thread(() -> {
            if (t0.isAlive()){
                try {
                    t0.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<100; i++){
                System.out.printf("Поток %S сделал значение переменным следующее %d\n", Thread.currentThread().getName(), i);
            }
        });

        t1.start();
        t0.start();
//        t1.start();

        try{
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main поток завершён: "+Thread.currentThread().getName());

    }
}
