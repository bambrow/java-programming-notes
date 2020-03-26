package concurrent;

public class ThreadTest1 {

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 thread = new MyThread1();
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }

}
