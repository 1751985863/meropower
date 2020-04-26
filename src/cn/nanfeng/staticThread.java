package cn.nanfeng;

/**
 * 静态同步函数
 */
public class staticThread {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain3 threadTrain = new ThreadTrain3();
        Thread thread1 = new Thread(threadTrain);
        Thread thread2 = new Thread(threadTrain);
        thread1.start();
        Thread.sleep(100);
        threadTrain.flag=false;
        thread2.start();
    }
}
class ThreadTrain3 implements Runnable{

    private static int count=100;
    private Object object=new Object();

    public boolean flag=true;
    public void run() {
        if (flag){
            while (count>0){
                synchronized (ThreadTrain3.class){

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
    public  static synchronized  void show(){

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