package dev.lpa;

class OddThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i += 2) {
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread interrupted!");
                break;
            }
        }
    }
}

class EvenRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 2; i <= 10; i += 2) {
            System.out.println("EvenRunnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("EvenRunnable interrupted!");
                break;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {

//        Thread threadOdd = new Thread(() -> {
//            String tname = Thread.currentThread().getName();
//            for (int i = 0; i < 10; i += 2) {
//                System.out.print(i + 1 + " ");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("\nWhoops!! " + tname + " interrupted.");
//                    Thread.currentThread().interrupt();
//                    return;
//                }
//            }
//            System.out.println("\n" + tname + " completed.");
//        });
//
//
//        Thread threadEven = new Thread(() -> {
//            String tname = Thread.currentThread().getName();
//            for (int i = 0; i < 10; i += 2) {
//                System.out.print(i + 2 + " ");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("\nWhoops!! " + tname + " interrupted.");
//                    Thread.currentThread().interrupt();
//                    return;
//                }
//            }
//            System.out.println("\n" + tname + " completed.");
//        });
//
//        threadOdd.start();
//        threadEven.start();

        OddThread oddThread = new OddThread();

        Runnable runnable = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("EvenRunnable: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("EvenRunnable interrupted!");
                    break;
                }
            }
        };

//        Thread evenThread = new Thread(new EvenRunnable());
        Thread evenThread = new Thread(runnable);
        oddThread.start();
        evenThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oddThread.interrupt();
    }
}
