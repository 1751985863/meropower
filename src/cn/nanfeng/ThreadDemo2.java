package cn.nanfeng;

public class ThreadDemo2 {
    public static void main(String[] args) {
        long startime=System.currentTimeMillis();
        int count=100;
        while (count>0){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if (count>0){
                    System.out.println(Thread.currentThread()+"出售第"+(100-count+1)+"张票");
                    count--;
                }

        }
        long endtime=System.currentTimeMillis();
        System.out.println("程序运行时间为"+(endtime-startime));
    }
}
