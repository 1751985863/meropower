package cn.nanfeng;

public class ThreadDemo {
    public static void main(String[] args) {
        long startime=System.currentTimeMillis();
        ThreadTrain2 threadTrain = new ThreadTrain2();
        Thread thread = new Thread(threadTrain);
        Thread thread1 = new Thread(threadTrain);
        thread.start();
        thread1.start();
        long endtime=System.currentTimeMillis();
        System.out.println("程序运行时间为"+(endtime-startime));


    }
}

class ThreadTrain implements Runnable{

    private int count=100;
    private Object object=new Object();
    @Override
    public void run() {

        while (count>0){
            synchronized (object){

                if (count>0){
                    System.out.println(Thread.currentThread()+"出售第"+(100-count+1)+"张票");
                    count--;
                }
            }
        }

    }
}
class ThreadTrain2 implements Runnable{

    private int count=100;
    private Object object=new Object();
    @Override
    public void run() {

        while (count>0){
            show();
        }

    }
    public  void show(){
        synchronized(this) {
            if (count > 0) {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
        }

    }
}
