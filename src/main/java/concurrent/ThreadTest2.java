package concurrent;

import java.util.concurrent.Executor;

public class ThreadTest2 {

    static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
        }
    }

    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                new Thread(command).start();
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(new MyThread2());
        }
    }

}
