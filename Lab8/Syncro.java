class Display {

    synchronized void show(String threadName) {
        String words[] = {"I", "Love", "java", "Very", "Much"};

        for (String w : words) {
            System.out.println(threadName + ": " + w);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    Display d;

    MyThread1(Display d) {
        this.d = d;
    }

    public void run() {
        d.show("Thread 1");
    }
}

class MyThread2 extends Thread {
    Display d;

    MyThread2(Display d) {
        this.d = d;
    }

    public void run() {
        d.show("Thread 2");
    }
}

public class Syncro {
    public static void main(String args[]) {

        Display obj = new Display();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start();
    }
}