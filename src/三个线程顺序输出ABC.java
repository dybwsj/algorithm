import java.util.Arrays;

public class 三个线程顺序输出ABC implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    private 三个线程顺序输出ABC(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        三个线程顺序输出ABC pa = new 三个线程顺序输出ABC("A", c, a);
        三个线程顺序输出ABC pb = new 三个线程顺序输出ABC("B", a, b);
        三个线程顺序输出ABC pc = new 三个线程顺序输出ABC("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}