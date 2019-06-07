package zad2;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Data extends Thread {
    private double a;
    private double b;
    private double c;
    static Semaphore sem;

    public Data(Semaphore s){
        sem = s;
    }

    @Override
    public void run() {
        this.getData();
    }
    private void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj a: ");
        a = scanner.nextDouble();
        System.out.print("Podaj b: ");
        b = scanner.nextDouble();
        System.out.print("Podaj c: ");
        c = scanner.nextDouble();
        sem.release();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
