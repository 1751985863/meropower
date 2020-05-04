package cn.nanfeng;


class joinThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName()+"-------");
        }
    }
}
public class joinThread {
    public static void main(String[] args) {
        joinThread1 thread1=new joinThread1();
        joinThread1 thread11=new joinThread1();
        thread1.start();
        try {
            thread1.join();//让其他线程等待，周当前线程执行完毕，才会释放
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread11.start();
        for (int i = 0; i < 30; i++) {
            System.out.println("main-------------");
        }
    }
}
