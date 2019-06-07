package zad2;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem1 = new Semaphore(0);
        Semaphore sem2 = new Semaphore(0);
        Data data = new Data(sem1);
        Delta delta = new Delta(data, sem1, sem2);
        Roots roots = new Roots(data, delta, sem2);

        data.start();

        delta.start();

        roots.start();


    }
}
