package zad2;

import java.util.concurrent.Semaphore;

public class Roots extends Thread {
    private double x1;
    private double x2;
    Data data;
    Delta delta;
    static Semaphore sem;

    public Roots(Data data, Delta delta, Semaphore s){
        this.data = data;
        this.delta = delta;
        sem = s;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.calcRoots();
        this.printRoots();
    }

    public void printRoots() {
        if(delta.getDelta() < 0) {
            System.out.println("Delta mniejsza od zera");
        }
        else if(delta.getDelta() == 0) {
            System.out.println("x = " + x1);
        }
        else {
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }
    }

    private void calcRoots() {
        x1 = (-data.getB() - Math.sqrt(delta.getDelta()))/(2*data.getA());
        x2 = (-data.getB() + Math.sqrt(delta.getDelta()))/(2*data.getA());
    }
}
