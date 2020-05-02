package cn.nanfeng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *使用同步代码块线程不安全
 */
public class contactOnThread {
    public static void main(String[] args) {
        Res res=new Res();
        inputThread inputThread = new inputThread(res);
        outThread outThread = new outThread(res);
        inputThread.start();
        outThread.start();
    }

}

/**
 * 共享资源
 */
class Res{
    public String name;
    public String sex;
    public boolean flag=false;//如果flag为false表示不能读，只能写
    public Lock lock=new ReentrantLock();
    public Condition condition=lock.newCondition();

    @Override
    public String toString() {
        return "Res{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

/**
 * 写线程
 */
class inputThread extends Thread{
    public Res res;

    public inputThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count=0;
        while (true){
            try {
                res.lock.lock();
                if (res.flag){
                        res.condition.await();
                }

                if (count == 0) {
                    res.name = "余胜军";
                    res.sex = "男";
                } else {
                    res.name = "小红";
                    res.sex = "女";
                }
                // 实现奇数和偶数
                count = (count + 1) % 2;
                res.flag = true;
                // 和wait 一起使用 唤醒拧一个线程  唤醒从阻塞状态变为运行状态
                res.condition.signal();
            }catch (Exception e){

            }
            finally {
                res.lock.unlock();
            }



            }
            //实现奇偶交替




    }
}

/**
 * 读的线程
 */
class outThread extends Thread{
    public Res res;

    public outThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count=0;
        while (true){
            try {
                res.lock.lock();
                if (!res.flag){

                    res.condition.await();

                }
                System.out.println(res.name + "---" + res.sex);
                res.flag = false;
                res.condition.signal();
            }catch (Exception e){

            }
            finally {
                res.lock.unlock();
            }



        }
    }
}
