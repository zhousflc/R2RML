/**
 * ʹ��Thread�������ʵ���̣߳��书��Ϊѭ�����0-9���֣�ÿ��������߲���10�����ʱ�䡣
 * ��main()�����д��������������̣߳��������С������߳̿�ʼ��������Ҫ����Ӧ������������ 
 */

// TestMitiThread.java
public class TestMitiThread {
    public static void main(String[] rags) {
        System.out.println("main�߳����п�ʼ!");
        new MitiSay("A").start();
        new MitiSay("B").start();
        System.out.println("main�߳����н���!");
    }
}
 
class MitiSay extends Thread {
    public MitiSay(String threadName) {
        super(threadName);
    }
    public void run() {
        System.out.println(getName() + " �߳����п�ʼ!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " �߳����н���!");
    }
}
