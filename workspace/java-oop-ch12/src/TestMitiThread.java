/**
 * 使用Thread类的子类实现线程，其功能为循环输出0-9数字，每次随机休眠不到10毫秒的时间。
 * 在main()方法中创建两个这样的线程，启动运行。所有线程开始、结束都要有相应的文字描述。 
 */

// TestMitiThread.java
public class TestMitiThread {
    public static void main(String[] rags) {
        System.out.println("main线程运行开始!");
        new MitiSay("A").start();
        new MitiSay("B").start();
        System.out.println("main线程运行结束!");
    }
}
 
class MitiSay extends Thread {
    public MitiSay(String threadName) {
        super(threadName);
    }
    public void run() {
        System.out.println(getName() + " 线程运行开始!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " 线程运行结束!");
    }
}
