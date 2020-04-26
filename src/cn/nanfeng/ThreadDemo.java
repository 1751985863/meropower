package cn.nanfeng;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain2 threadTrain = new ThreadTrain2();
        Thread thread1 = new Thread(threadTrain);
        Thread thread2 = new Thread(threadTrain);
        thread1.start();
        Thread.sleep(100);
        threadTrain.flag=false;
        thread2.start();




    }
}

class ThreadTrain2 implements Runnable{

    private int count=100;
    private Object object=new Object();

    public boolean flag=true;
    public void run() {
        if (flag){
            while (count>0){
                synchronized (object){

                    if (count>0){
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread()+"出售第"+(100-count+1)+"张票");
                        count--;
                    }
                }
            }
        }

        else {
            while (count>0){
                show();
            }
        }

    }
    public  void show(){
        synchronized(object) {
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
