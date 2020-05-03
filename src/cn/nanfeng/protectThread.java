package cn.nanfeng;

public class protectThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {

                    System.out.println("我是子线程"+i);
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 30; i++) {
            Thread.sleep(100);
            System.out.println("我是主线程"+i);
        }
        System.out.println("主线程执行完毕");

    }
}
class protectThread1{


}
