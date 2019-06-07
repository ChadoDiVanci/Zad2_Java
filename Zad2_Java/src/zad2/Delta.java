package zad2;

import java.util.concurrent.Semaphore;

public class Delta extends Thread {
    private double delta;
    Data data;
    static Semaphore sem1;
    static Semaphore sem2;

    public Delta(Data data, Semaphore s1, Semaphore s2){
        this.data = data;
        sem1 = s1;
        sem2 = s2;
    }
    @Override
    public void run() {
        try {
            sem1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.calcDelta();
        sem2.release();
    }

    private void calcDelta() {
        delta = Math.pow(data.getB(), 2) - 4*data.getA()*data.getC();
    }

    public double getDelta() {
        return delta;
    }
}
