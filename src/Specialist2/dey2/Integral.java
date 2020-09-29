package Specialist2.dey2;

import java.util.function.DoubleFunction;

public class Integral {
    public static final int STEPS = 10000000;
    // y = f(x)

    public static double singleThread(DoubleFunction<Double> f, double a, double b, int steps) {
        double h = (b - a) / steps;
        double summa = 0d;

        for(int i = 0; i < steps; i++) {
            double x = a + h*i + h/2;
            double y = f.apply(x);
            summa += y*h;
        }

        return summa;
    }




    public static void main(String[] args) {
        singleThread(Math::sin, 0d, Math.PI/2, STEPS);
        singleThread(Math::sin, 0d, Math.PI/2, STEPS);

        long t1 = System.currentTimeMillis();
        double r1 = singleThread(Math::sin, 0d, Math.PI/2, STEPS);
        long t2 = System.currentTimeMillis();

        System.out.printf("Single thread integral: %.15f Time: %d\n", r1, t2-t1);

    }
}
