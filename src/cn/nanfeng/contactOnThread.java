package cn.nanfeng;

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
            synchronized (res){//加锁
                if (res.flag) {
                    // 当前线程等待。wait();类似于 sleep 可以让当前线程，从运行状态变为休眠状态 wait
                    // 使用在多线程之间同步 和synchronized 一起使用
                    // wait可以释放锁 ,sleep 不能释放锁。
                    try {
                        res.wait();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
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
                res.notify();



            }
            //实现奇偶交替



        }
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
            synchronized (res){//加锁2
                if (!res.flag) {
                    try {
                        res.wait();

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                System.out.println(res.name + "---" + res.sex);
                res.flag = false;
                res.notify();
            }

        }
    }
}
