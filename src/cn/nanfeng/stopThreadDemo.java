package cn.nanfeng;

class stopThread extends Thread{

    public boolean flag=true;
    @Override
    public synchronized void run() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                stopp();

            }
            System.out.println(Thread.currentThread().getName()+"------我是子线程");
        }

    }
    public void stopp(){
        flag=false;
        System.out.println(Thread.currentThread().getName()+"子线程挂了");
    }
}
public class stopThreadDemo {
    public static void main(String[] args) {
        stopThread stopThread=new stopThread();
        stopThread stopThread1=new stopThread();
        stopThread.start();
        stopThread1.start();
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==29){
             stopThread.interrupt();
             stopThread.interrupt();
            }
        }
    }
}
